package GUI;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.border.EmptyBorder;

import edu.teacherScheduling.AddTeacherScheduleRequest;
import edu.teacherScheduling.AddTeacherScheduleResponse;
import edu.teacherScheduling.GetTeacherScheduleByIdRequest;
import edu.teacherScheduling.GetTeacherScheduleByIdResponse;
import edu.teacherScheduling.TeacherManagementGrpc;
import edu.teacherScheduling.TeachingItem;
import edu.teacherScheduling.UpdateTeacherScheduleRequest;
import edu.teacherScheduling.UpdateTeacherScheduleResponse;

public class TeacherManagementGUI {

	private static TeacherManagementGrpc.TeacherManagementBlockingStub blockingStub;

	private ServiceInfo TeacherManagementServiceInfo;

	JFrame frame;
	private JTextField textTeacherId;
	private JTextField textCourseIds;
	private JTextArea textResponse;

	private ManagedChannel channel;

	String host;
	int port;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TeacherManagementGUI window = new TeacherManagementGUI();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TeacherManagementGUI() {

		String Teacher_management_service_type = "_scheduling._tcp.local.";
		discoverTeacherManagementService(Teacher_management_service_type);

		if (TeacherManagementServiceInfo != null) {
			host = TeacherManagementServiceInfo.getHostAddresses()[0];
			port = TeacherManagementServiceInfo.getPort();
		} else {
			// Show an error message and use default host and port values.
//            JOptionPane.showMessageDialog(null, "Teacher Management Service not found. Using default host and port values.", "Service Not Found", JOptionPane.WARNING_MESSAGE);
			host = "localhost";
			port = 50053;
		}

		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingStub = TeacherManagementGrpc.newBlockingStub(channel);

		initialize();
	}

	private void discoverTeacherManagementService(String service_type) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Teacher Management Service resolved: " + event.getInfo());

					TeacherManagementServiceInfo = event.getInfo();

					int port = TeacherManagementServiceInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out
							.println("\t description/properties: " + TeacherManagementServiceInfo.getNiceTextString());
					System.out.println("\t host: " + TeacherManagementServiceInfo.getHostAddresses()[0]);
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Teacher Management Service removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Teacher Management Service added: " + event.getInfo());
				}
			});

			Thread.sleep(2000);

			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Teacher Management Service Controller");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// the left part
		JPanel panelLeft = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		frame.getContentPane().add(panelLeft, gbc);

		// AddTeacherSchedule service panel
		// Teacher ID 和 Course IDs 
		JLabel lblTeacherId = new JLabel("Teacher ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 5, 5);
		panelLeft.add(lblTeacherId, gbc);

		textTeacherId = new JTextField();
		textTeacherId.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 5, 5, 5);
		panelLeft.add(textTeacherId, gbc);

		JLabel lblCourseIds = new JLabel("Course IDs (comma separated)");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 10, 5, 5);
		panelLeft.add(lblCourseIds, gbc);

		textCourseIds = new JTextField();
		textCourseIds.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panelLeft.add(textCourseIds, gbc);

		// the three method buttons 
		gbc.insets = new Insets(10, 10, 10, 10);

		JButton btnAddTeacherSchedule = new JButton("Add Teacher Schedule");
		Dimension btnAddPreferredSize = btnAddTeacherSchedule.getPreferredSize();
		int btnAddNewHeight = (int) (btnAddPreferredSize.height * 0.75);
		Dimension btnAddMaxSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		Dimension btnAddMinSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		btnAddTeacherSchedule.setMaximumSize(btnAddMaxSize);
		btnAddTeacherSchedule.setMinimumSize(btnAddMinSize);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnAddTeacherSchedule, gbc);

		JButton btnGetTeacherScheduleById = new JButton("Get Teacher Schedule By ID");
		Dimension btnGetPreferredSize = btnGetTeacherScheduleById.getPreferredSize();
		int btnGetNewHeight = (int) (btnGetPreferredSize.height * 0.75);
		Dimension btnGetMaxSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		Dimension btnGetMinSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		btnGetTeacherScheduleById.setMaximumSize(btnGetMaxSize);
		btnGetTeacherScheduleById.setMinimumSize(btnGetMinSize);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnGetTeacherScheduleById, gbc);

		JButton btnUpdateTeacherSchedules = new JButton("Update Teacher Schedules");
		Dimension btnUpdatePreferredSize = btnUpdateTeacherSchedules.getPreferredSize();
		int btnUpdateNewHeight = (int) (btnUpdatePreferredSize.height * 0.75);
		Dimension btnUpdateMaxSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		Dimension btnUpdateMinSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		btnUpdateTeacherSchedules.setMaximumSize(btnUpdateMaxSize);
		btnUpdateTeacherSchedules.setMinimumSize(btnUpdateMinSize);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnUpdateTeacherSchedules, gbc);

		// AddTeacherScheduleById service panel		
				btnAddTeacherSchedule.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String TeacherId = textTeacherId.getText();
						String courseIdsInput = textCourseIds.getText();
						String[] courseIdsArray = courseIdsInput.split(",");
						AddTeacherScheduleRequest request = AddTeacherScheduleRequest.newBuilder().setTeacherId(TeacherId)
								.addAllCourseIds(Arrays.asList(courseIdsArray)).build();

						TeacherManagementGrpc.TeacherManagementStub asyncStub = TeacherManagementGrpc.newStub(channel);

						StreamObserver<AddTeacherScheduleResponse> addTeacherScheduleResponseObserver = new StreamObserver<AddTeacherScheduleResponse>() {
							@Override
							public void onNext(AddTeacherScheduleResponse response) {
								textResponse.append(
										"Status: " + response.getStatus() + ", Message: " + response.getMessage() + "\n");
							}

							@Override
							public void onError(Throwable t) {
								textResponse.append("Error: " + t.getMessage() + "\n");
							}

							@Override
							public void onCompleted() {
								textResponse.append("Add Teacher Schedule Completed\n\n");
							}
						};

						asyncStub.addTeacherSchedule(request, addTeacherScheduleResponseObserver);
					}
				});

				// GetTeacherScheduleById service panel
				btnGetTeacherScheduleById.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String TeacherId = textTeacherId.getText();
						GetTeacherScheduleByIdRequest request = GetTeacherScheduleByIdRequest.newBuilder()
								.setTeacherId(TeacherId).build();

						TeacherManagementGrpc.TeacherManagementStub asyncStub = TeacherManagementGrpc.newStub(channel);

						StreamObserver<GetTeacherScheduleByIdResponse> getTeacherScheduleByIdResponseObserver = new StreamObserver<GetTeacherScheduleByIdResponse>() {
							@Override
							public void onNext(GetTeacherScheduleByIdResponse response) {
								SwingUtilities.invokeLater(() -> {
									String courses = String.join(", ", response.getCourseIdsList());
									textResponse.append(
											"Teacher ID: " + response.getTeacherId() + ", Course IDs: " + courses + "\n\n");
								});

							}

							@Override
							public void onError(Throwable t) {
								textResponse.append("Error: " + t.getMessage() + "\n");
							}

							@Override
							public void onCompleted() {
								textResponse.append("Get Teacher Schedule By ID Completed\n");
							}
						};

						asyncStub.getTeacherScheduleById(request, getTeacherScheduleByIdResponseObserver);

					}
				});
				

		// UpdateTeacherSchedules service panel
				btnUpdateTeacherSchedules.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        StreamObserver<UpdateTeacherScheduleResponse> responseObserver = new StreamObserver<UpdateTeacherScheduleResponse>() {
				            @Override
				            public void onNext(UpdateTeacherScheduleResponse response) {
				                List<TeachingItem> teachingItems = response.getTeachingItemList();
				                for (TeachingItem item : teachingItems) {
				                    textResponse.append("Teacher ID: " + item.getTeacherId() + ", Course IDs: " + item.getCourseIds() + "\n");
				                }
				            }

				            @Override
				            public void onError(Throwable t) {
				                textResponse.append("Error: " + t.getMessage() + "\n");
				            }

				            @Override
				            public void onCompleted() {
				                textResponse.append("Update Teacher Schedules Completed\n\n");
				            }
				        };

				        TeacherManagementGrpc.TeacherManagementStub asyncStub = TeacherManagementGrpc.newStub(channel);
				        StreamObserver<UpdateTeacherScheduleRequest> requestObserver = asyncStub.updateTeacherSchedules(responseObserver);

				        // Simulate streaming requests
				        for (int i = 1; i <= 5; i++) {
				            String teacherId = "teacher" + i;
				            List<String> courseIds = new ArrayList<>();
				            for (int j = 1; j <= 3; j++) {
				                courseIds.add("course" + i + "_" + j);
				            }
				            UpdateTeacherScheduleRequest request = UpdateTeacherScheduleRequest.newBuilder()
				                    .setTeacherId(teacherId)
				                    .addAllCourseIds(courseIds)
				                    .build();
				            try {
				                requestObserver.onNext(request);
				                Thread.sleep(1000); // Simulate time delay between requests
				            } catch (RuntimeException | InterruptedException ex) {
				                requestObserver.onError(ex);
				                throw new RuntimeException(ex);
				            }
				        }
				        requestObserver.onCompleted();
				    }
				});


		// the right part
		JPanel panelRight = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		frame.getContentPane().add(panelRight, gbc);

		// TextArea  
		textResponse = new JTextArea(15, 25);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textResponse);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0.9;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 10, 5, 10);
		panelRight.add(scrollPane, gbc);

		// Exit button
		JButton btnExit = new JButton("Exit");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.insets = new Insets(5, 10, 10, 10);
		panelRight.add(btnExit, gbc);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close the channel 
				channel.shutdown();
				// exit the application 
				System.exit(0);
			}
		});

	}
}

