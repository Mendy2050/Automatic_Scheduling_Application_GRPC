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
import java.util.Arrays;
import javax.swing.border.EmptyBorder;

import edu.courseScheduling.AddCourseScheduleRequest;
import edu.courseScheduling.AddCourseScheduleResponse;
import edu.courseScheduling.CourseItem;
import edu.courseScheduling.CourseManagementGrpc;
import edu.courseScheduling.GetAllCoursesScheduleRequest;
import edu.courseScheduling.GetAllCoursesScheduleResponse;
import edu.courseScheduling.GetCourseScheduleByIdRequest;
import edu.courseScheduling.GetCourseScheduleByIdResponse;

public class CourseManagementGUI {

	private static CourseManagementGrpc.CourseManagementBlockingStub blockingStub;

	private ServiceInfo CourseManagementServiceInfo;

	JFrame frame;
	private JTextField textCourseId;
	private JTextField textCourseIds;
	private JTextArea textResponse;

	private ManagedChannel channel;

	String host;
	int port;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CourseManagementGUI window = new CourseManagementGUI();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CourseManagementGUI() {

		String Course_management_service_type = "_scheduling._tcp.local.";
		discoverCourseManagementService(Course_management_service_type);

		if (CourseManagementServiceInfo != null) {
			host = CourseManagementServiceInfo.getHostAddresses()[0];
			port = CourseManagementServiceInfo.getPort();
		} else {
			// Show an error message and use default host and port values.
//            JOptionPane.showMessageDialog(null, "Course Management Service not found. Using default host and port values.", "Service Not Found", JOptionPane.WARNING_MESSAGE);
			host = "localhost";
			port = 50052;
		}

		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingStub = CourseManagementGrpc.newBlockingStub(channel);

		initialize();
	}

	private void discoverCourseManagementService(String service_type) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Course Management Service resolved: " + event.getInfo());

					CourseManagementServiceInfo = event.getInfo();

					int port = CourseManagementServiceInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out
							.println("\t description/properties: " + CourseManagementServiceInfo.getNiceTextString());
					System.out.println("\t host: " + CourseManagementServiceInfo.getHostAddresses()[0]);
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Course Management Service removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Course Management Service added: " + event.getInfo());
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
		frame.setTitle("Client - Course Management Service Controller");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// On the left
		JPanel panelLeft = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		frame.getContentPane().add(panelLeft, gbc);

		// AddCourseSchedule service panel
		// Course ID and Course ID 
		JLabel lblCourseId = new JLabel("Course ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 5, 5);
		panelLeft.add(lblCourseId, gbc);

		textCourseId = new JTextField();
		textCourseId.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 5, 5, 5);
		panelLeft.add(textCourseId, gbc);

		JLabel lblCourseIds = new JLabel("Course - Day(s) Of Week \n (comma separated)");
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

		JButton btnAddCourseSchedule = new JButton("Add Course Schedule");
		Dimension btnAddPreferredSize = btnAddCourseSchedule.getPreferredSize();
		int btnAddNewHeight = (int) (btnAddPreferredSize.height * 0.75);
		Dimension btnAddMaxSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		Dimension btnAddMinSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		btnAddCourseSchedule.setMaximumSize(btnAddMaxSize);
		btnAddCourseSchedule.setMinimumSize(btnAddMinSize);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnAddCourseSchedule, gbc);

		JButton btnGetCourseScheduleById = new JButton("Get Course Schedule By ID");
		Dimension btnGetPreferredSize = btnGetCourseScheduleById.getPreferredSize();
		int btnGetNewHeight = (int) (btnGetPreferredSize.height * 0.75);
		Dimension btnGetMaxSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		Dimension btnGetMinSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		btnGetCourseScheduleById.setMaximumSize(btnGetMaxSize);
		btnGetCourseScheduleById.setMinimumSize(btnGetMinSize);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnGetCourseScheduleById, gbc);

		JButton btnGetAllCourses = new JButton("Get All Courses");
		Dimension btnUpdatePreferredSize = btnGetAllCourses.getPreferredSize();
		int btnUpdateNewHeight = (int) (btnUpdatePreferredSize.height * 0.75);
		Dimension btnUpdateMaxSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		Dimension btnUpdateMinSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		btnGetAllCourses.setMaximumSize(btnUpdateMaxSize);
		btnGetAllCourses.setMinimumSize(btnUpdateMinSize);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnGetAllCourses, gbc);

		btnAddCourseSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CourseId = textCourseId.getText();
				String courseIdsInput = textCourseIds.getText();
				String[] courseIdsArray = courseIdsInput.split(",");
				AddCourseScheduleRequest request = AddCourseScheduleRequest.newBuilder().setCourseId(CourseId)
						.addAllCourseDayOfWeek(Arrays.asList(courseIdsArray)).build();

				CourseManagementGrpc.CourseManagementStub asyncStub = CourseManagementGrpc.newStub(channel);

				StreamObserver<AddCourseScheduleResponse> addCourseScheduleResponseObserver = new StreamObserver<AddCourseScheduleResponse>() {
					@Override
					public void onNext(AddCourseScheduleResponse response) {
						textResponse.append(
								"Status: " + response.getStatus() + ", Message: " + response.getMessage() + "\n");
					}

					@Override
					public void onError(Throwable t) {
						textResponse.append("Error: " + t.getMessage() + "\n");
					}

					@Override
					public void onCompleted() {
						textResponse.append("Add Course Schedule Completed\n\n");
					}
				};

				asyncStub.addCourse(request, addCourseScheduleResponseObserver);
			}
		});

		// GetCourseScheduleById service panel
		btnGetCourseScheduleById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CourseId = textCourseId.getText();
				GetCourseScheduleByIdRequest request = GetCourseScheduleByIdRequest.newBuilder()
						.setCourseId(CourseId).build();

				CourseManagementGrpc.CourseManagementStub asyncStub = CourseManagementGrpc.newStub(channel);

				StreamObserver<GetCourseScheduleByIdResponse> getCourseScheduleByIdResponseObserver = new StreamObserver<GetCourseScheduleByIdResponse>() {
					@Override
					public void onNext(GetCourseScheduleByIdResponse response) {
						SwingUtilities.invokeLater(() -> {
							String courses = String.join(", ", response.getCourseDayOfWeekList());
							textResponse.append(
									"Course ID: " + response.getCourseId() + ", Course - Day(s) Of Week " + courses + "\n\n");
						});

					}

					@Override
					public void onError(Throwable t) {
						textResponse.append("Error: " + t.getMessage() + "\n");
					}

					@Override
					public void onCompleted() {
						textResponse.append("Get Course Schedule By ID Completed\n");
					}
				};

				asyncStub.getCourseById(request, getCourseScheduleByIdResponseObserver);

			}
		});

		// getAllCourses service panel
		btnGetAllCourses.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        GetAllCoursesScheduleRequest request = GetAllCoursesScheduleRequest.newBuilder().build();

		        StreamObserver<GetAllCoursesScheduleResponse> responseObserver = new StreamObserver<GetAllCoursesScheduleResponse>() {
		            @Override
		            public void onNext(GetAllCoursesScheduleResponse response) {
		                for (CourseItem courseItem : response.getCourseItemList()) {
		                    textResponse.append("Course ID: " + courseItem.getCourseId() +
		                            ", Course Day of Week: " + courseItem.getCourseDayOfWeek() + "\n");
		                }
		            }

		            @Override
		            public void onError(Throwable t) {
		                textResponse.append("Error: " + t.getMessage() + "\n");
		            }

		            @Override
		            public void onCompleted() {
		                textResponse.append("Get All Courses Completed\n\n");
		            }
		        };

		        CourseManagementGrpc.CourseManagementStub asyncStub = CourseManagementGrpc.newStub(channel);

		        try {
		            asyncStub.getAllCourses(request, responseObserver);
		        } catch (RuntimeException ex) {
		            responseObserver.onError(ex);
		            throw ex;
		        }
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
				// close channel 
				channel.shutdown();
				// exit the application 
				System.exit(0);
			}
		});

	}
}

