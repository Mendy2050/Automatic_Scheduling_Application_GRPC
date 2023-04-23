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

import edu.studentScheduling.AddStudentScheduleRequest;
import edu.studentScheduling.AddStudentScheduleResponse;
import edu.studentScheduling.GetStudentScheduleByIdRequest;
import edu.studentScheduling.GetStudentScheduleByIdResponse;
import edu.studentScheduling.StudentManagementGrpc;
import edu.studentScheduling.UpdateStudentScheduleRequest;
import edu.studentScheduling.UpdateStudentScheduleResponse;

public class StudentManagementGUI {

	private static StudentManagementGrpc.StudentManagementBlockingStub blockingStub;

	private ServiceInfo studentManagementServiceInfo;

	JFrame frame;
	private JTextField textStudentId;
	private JTextField textCourseIds;
	private JTextArea textResponse;

	private ManagedChannel channel;

	String host;
	int port;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				StudentManagementGUI window = new StudentManagementGUI();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public StudentManagementGUI() {

		String student_management_service_type = "_scheduling._tcp.local.";
		discoverStudentManagementService(student_management_service_type);

		if (studentManagementServiceInfo != null) {
			host = studentManagementServiceInfo.getHostAddresses()[0];
			port = studentManagementServiceInfo.getPort();
		} else {
			// Show an error message and use default host and port values.
//            JOptionPane.showMessageDialog(null, "Student Management Service not found. Using default host and port values.", "Service Not Found", JOptionPane.WARNING_MESSAGE);
			host = "localhost";
			port = 50051;
		}

		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingStub = StudentManagementGrpc.newBlockingStub(channel);

		initialize();
	}

	private void discoverStudentManagementService(String service_type) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Student Management Service resolved: " + event.getInfo());

					studentManagementServiceInfo = event.getInfo();

					int port = studentManagementServiceInfo.getPort();

					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:" + event.getType());
					System.out.println("\t name: " + event.getName());
					System.out
							.println("\t description/properties: " + studentManagementServiceInfo.getNiceTextString());
					System.out.println("\t host: " + studentManagementServiceInfo.getHostAddresses()[0]);
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Student Management Service removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Student Management Service added: " + event.getInfo());
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
		frame.setTitle("Client - Student Management Service Controller");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// 左侧部分
		JPanel panelLeft = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		frame.getContentPane().add(panelLeft, gbc);

		// AddStudentSchedule service panel
		// Student ID 和 Course ID在同一行
		JLabel lblStudentId = new JLabel("Student ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 5, 5);
		panelLeft.add(lblStudentId, gbc);

		textStudentId = new JTextField();
		textStudentId.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 5, 5, 5);
		panelLeft.add(textStudentId, gbc);

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

		// 剩下的三个方法名字按钮各自占一行
		gbc.insets = new Insets(10, 10, 10, 10);

		JButton btnAddStudentSchedule = new JButton("Add Student Schedule");
		Dimension btnAddPreferredSize = btnAddStudentSchedule.getPreferredSize();
		int btnAddNewHeight = (int) (btnAddPreferredSize.height * 0.75);
		Dimension btnAddMaxSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		Dimension btnAddMinSize = new Dimension(btnAddPreferredSize.width, btnAddNewHeight);
		btnAddStudentSchedule.setMaximumSize(btnAddMaxSize);
		btnAddStudentSchedule.setMinimumSize(btnAddMinSize);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnAddStudentSchedule, gbc);

		JButton btnGetStudentScheduleById = new JButton("Get Student Schedule By ID");
		Dimension btnGetPreferredSize = btnGetStudentScheduleById.getPreferredSize();
		int btnGetNewHeight = (int) (btnGetPreferredSize.height * 0.75);
		Dimension btnGetMaxSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		Dimension btnGetMinSize = new Dimension(btnGetPreferredSize.width, btnGetNewHeight);
		btnGetStudentScheduleById.setMaximumSize(btnGetMaxSize);
		btnGetStudentScheduleById.setMinimumSize(btnGetMinSize);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnGetStudentScheduleById, gbc);

		JButton btnUpdateStudentSchedules = new JButton("Update Student Schedules");
		Dimension btnUpdatePreferredSize = btnUpdateStudentSchedules.getPreferredSize();
		int btnUpdateNewHeight = (int) (btnUpdatePreferredSize.height * 0.75);
		Dimension btnUpdateMaxSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		Dimension btnUpdateMinSize = new Dimension(btnUpdatePreferredSize.width, btnUpdateNewHeight);
		btnUpdateStudentSchedules.setMaximumSize(btnUpdateMaxSize);
		btnUpdateStudentSchedules.setMinimumSize(btnUpdateMinSize);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelLeft.add(btnUpdateStudentSchedules, gbc);

		btnAddStudentSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId = textStudentId.getText();
				String courseIdsInput = textCourseIds.getText();
				String[] courseIdsArray = courseIdsInput.split(",");
				AddStudentScheduleRequest request = AddStudentScheduleRequest.newBuilder().setStudentId(studentId)
						.addAllCourseIds(Arrays.asList(courseIdsArray)).build();

				StudentManagementGrpc.StudentManagementStub asyncStub = StudentManagementGrpc.newStub(channel);

				StreamObserver<AddStudentScheduleResponse> addStudentScheduleResponseObserver = new StreamObserver<AddStudentScheduleResponse>() {
					@Override
					public void onNext(AddStudentScheduleResponse response) {
						textResponse.append(
								"Status: " + response.getStatus() + ", Message: " + response.getMessage() + "\n");
					}

					@Override
					public void onError(Throwable t) {
						textResponse.append("Error: " + t.getMessage() + "\n");
					}

					@Override
					public void onCompleted() {
						textResponse.append("Add Student Schedule Completed\n\n");
					}
				};

				asyncStub.addStudentSchedule(request, addStudentScheduleResponseObserver);
			}
		});

		// GetStudentScheduleById service panel
		btnGetStudentScheduleById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId = textStudentId.getText();
				GetStudentScheduleByIdRequest request = GetStudentScheduleByIdRequest.newBuilder()
						.setStudentId(studentId).build();

				StudentManagementGrpc.StudentManagementStub asyncStub = StudentManagementGrpc.newStub(channel);

				StreamObserver<GetStudentScheduleByIdResponse> getStudentScheduleByIdResponseObserver = new StreamObserver<GetStudentScheduleByIdResponse>() {
					@Override
					public void onNext(GetStudentScheduleByIdResponse response) {
						SwingUtilities.invokeLater(() -> {
							String courses = String.join(", ", response.getCourseIdsList());
							textResponse.append(
									"Student ID: " + response.getStudentId() + ", Course IDs: " + courses + "\n\n");
						});

					}

					@Override
					public void onError(Throwable t) {
						textResponse.append("Error: " + t.getMessage() + "\n");
					}

					@Override
					public void onCompleted() {
						textResponse.append("Get Student Schedule By ID Completed\n");
					}
				};

				asyncStub.getStudentScheduleById(request, getStudentScheduleByIdResponseObserver);

			}
		});

		// UpdateStudentSchedules service panel
		btnUpdateStudentSchedules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId = textStudentId.getText();
				String courseIdsInput = textCourseIds.getText();
				String[] courseIdsArray = courseIdsInput.split(",");

				UpdateStudentScheduleRequest request = UpdateStudentScheduleRequest.newBuilder().setStudentId(studentId)
						.addAllCourseIds(Arrays.asList(courseIdsArray)).build();

				StreamObserver<UpdateStudentScheduleResponse> responseObserver = new StreamObserver<UpdateStudentScheduleResponse>() {
					@Override
					public void onNext(UpdateStudentScheduleResponse response) {
						textResponse.append(
								"Status: " + response.getStatus() + ", Message: " + response.getMessage() + "\n");
					}

					@Override
					public void onError(Throwable t) {
						textResponse.append("Error: " + t.getMessage() + "\n");
					}

					@Override
					public void onCompleted() {
						textResponse.append("Update Student Schedules Completed\n\n");
					}
				};

				StudentManagementGrpc.StudentManagementStub asyncStub = StudentManagementGrpc.newStub(channel);
				StreamObserver<UpdateStudentScheduleRequest> requestObserver = asyncStub
						.updateStudentSchedules(responseObserver);

				try {
					requestObserver.onNext(request);
				} catch (RuntimeException ex) {
					requestObserver.onError(ex);
					throw ex;
				}
				requestObserver.onCompleted();
			}
		});

		// 右侧部分
		JPanel panelRight = new JPanel(new GridBagLayout());
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		frame.getContentPane().add(panelRight, gbc);

		// TextArea 在第一行，但是高度略微高点
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

		// Exit 在右边部分的最下面
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
				// 关闭channel连接
				channel.shutdown();
				// 退出应用程序
				System.exit(0);
			}
		});

	}
}

