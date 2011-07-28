import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * GUI application for remote control of a NXT running RCNavigator<br>
 * Distance in meters <br>
 * uses RCNavComms class for bluetooth communications used Command enum in this
 * project
 * 
 * @author Roger Glassey
 */
public class RCNavigationControl extends JFrame {
	private static final long serialVersionUID = 1L;

	/** Creates new form RCNavigationControl */
	public RCNavigationControl() {
		initComponents();
	}

	/**
	 * calls constructor for this class
	 */
	public static void main(String args[]) {
		new RCNavigationControl().setVisible(true);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("RC Navigator Control");

		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 500, 0 };
		gbl_contentPanel.rowHeights = new int[] { 40, 133, 67, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		commandPanel = new JPanel();

		commandPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Commands",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		connectPanel = new JPanel();
		GridBagLayout gbl_connectPanel = new GridBagLayout();
		gbl_connectPanel.columnWidths = new int[] { 0, 125, 0, 125, 50, 0 };
		gbl_connectPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_connectPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_connectPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		connectPanel.setLayout(gbl_connectPanel);
		nameText = new JTextField();
		GridBagConstraints gbc_nameText = new GridBagConstraints();
		gbc_nameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameText.weightx = 0.5;
		gbc_nameText.insets = new Insets(0, 0, 5, 5);
		gbc_nameText.gridx = 1;
		gbc_nameText.gridy = 0;
		connectPanel.add(nameText, gbc_nameText);
		jLabel10 = new JLabel();
		jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jLabel10 = new GridBagConstraints();
		gbc_jLabel10.fill = GridBagConstraints.BOTH;
		gbc_jLabel10.anchor = GridBagConstraints.WEST;
		gbc_jLabel10.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel10.gridx = 2;
		gbc_jLabel10.gridy = 0;
		connectPanel.add(jLabel10, gbc_jLabel10);

		jLabel10.setText("Address:");
		addressText = new JTextField();
		GridBagConstraints gbc_addressText = new GridBagConstraints();
		gbc_addressText.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressText.weightx = 0.5;
		gbc_addressText.insets = new Insets(0, 0, 5, 5);
		gbc_addressText.gridx = 3;
		gbc_addressText.gridy = 0;
		connectPanel.add(addressText, gbc_addressText);

		connectButton = new JButton();
		GridBagConstraints gbc_connectButton = new GridBagConstraints();
		gbc_connectButton.insets = new Insets(0, 0, 5, 0);
		gbc_connectButton.gridx = 4;
		gbc_connectButton.gridy = 0;
		connectPanel.add(connectButton, gbc_connectButton);

		connectButton.setText("Connect");
		connectButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				connectButtonMouseClicked(evt);
			}
		});
		jLabel1 = new JLabel();
		jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jLabel1 = new GridBagConstraints();
		gbc_jLabel1.fill = GridBagConstraints.BOTH;
		gbc_jLabel1.anchor = GridBagConstraints.WEST;
		gbc_jLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel1.gridx = 0;
		gbc_jLabel1.gridy = 0;
		connectPanel.add(jLabel1, gbc_jLabel1);

		jLabel1.setText("Name:");
		jLabel11 = new JLabel();
		jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jLabel11 = new GridBagConstraints();
		gbc_jLabel11.fill = GridBagConstraints.BOTH;
		gbc_jLabel11.anchor = GridBagConstraints.WEST;
		gbc_jLabel11.insets = new Insets(0, 0, 0, 5);
		gbc_jLabel11.gridx = 0;
		gbc_jLabel11.gridy = 1;
		connectPanel.add(jLabel11, gbc_jLabel11);

		jLabel11.setText("Status:");
		statusField = new JTextField();
		GridBagConstraints gbc_statusField = new GridBagConstraints();
		gbc_statusField.fill = GridBagConstraints.HORIZONTAL;
		gbc_statusField.gridwidth = 3;
		gbc_statusField.insets = new Insets(0, 0, 0, 5);
		gbc_statusField.gridx = 1;
		gbc_statusField.gridy = 1;
		connectPanel.add(statusField, gbc_statusField);

		statusField.setText("waiting to connect");
		GridBagConstraints gbc_connectPanel = new GridBagConstraints();
		gbc_connectPanel.anchor = GridBagConstraints.NORTH;
		gbc_connectPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_connectPanel.insets = new Insets(0, 10, 15, 10);
		gbc_connectPanel.gridx = 0;
		gbc_connectPanel.gridy = 0;
		contentPanel.add(connectPanel, gbc_connectPanel);
		GridBagConstraints gbc_commandPanel = new GridBagConstraints();
		gbc_commandPanel.anchor = GridBagConstraints.NORTH;
		gbc_commandPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_commandPanel.insets = new Insets(0, 0, 5, 0);
		gbc_commandPanel.gridx = 0;
		gbc_commandPanel.gridy = 1;
		contentPanel.add(commandPanel, gbc_commandPanel);
		GridBagLayout gbl_commandPanel = new GridBagLayout();
		gbl_commandPanel.columnWidths = new int[] { 75, 44, 125, 14, 125, 0 };
		gbl_commandPanel.rowHeights = new int[] { 23, 23, 23, 0 };
		gbl_commandPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_commandPanel.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		commandPanel.setLayout(gbl_commandPanel);
		goButton = new JButton();
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		goButton.setText("GoTo XY");
		goButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				goButtonMouseClicked(evt);
			}
		});
		GridBagConstraints gbc_goButton = new GridBagConstraints();
		gbc_goButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_goButton.insets = new Insets(0, 10, 5, 5);
		gbc_goButton.gridx = 0;
		gbc_goButton.gridy = 0;
		commandPanel.add(goButton, gbc_goButton);
		jLabel2 = new JLabel();
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);

		jLabel2.setText("X");
		GridBagConstraints gbc_jLabel2 = new GridBagConstraints();
		gbc_jLabel2.fill = GridBagConstraints.BOTH;
		gbc_jLabel2.anchor = GridBagConstraints.EAST;
		gbc_jLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel2.gridx = 1;
		gbc_jLabel2.gridy = 0;
		commandPanel.add(jLabel2, gbc_jLabel2);
		XField = new JTextField();
		GridBagConstraints gbc_XField = new GridBagConstraints();
		gbc_XField.weightx = 0.5;
		gbc_XField.anchor = GridBagConstraints.NORTH;
		gbc_XField.fill = GridBagConstraints.HORIZONTAL;
		gbc_XField.insets = new Insets(0, 0, 5, 5);
		gbc_XField.gridx = 2;
		gbc_XField.gridy = 0;
		commandPanel.add(XField, gbc_XField);
		jLabel3 = new JLabel();
		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);

		jLabel3.setText("Y");
		GridBagConstraints gbc_jLabel3 = new GridBagConstraints();
		gbc_jLabel3.fill = GridBagConstraints.BOTH;
		gbc_jLabel3.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel3.gridx = 3;
		gbc_jLabel3.gridy = 0;
		commandPanel.add(jLabel3, gbc_jLabel3);
		travelButton = new JButton();

		travelButton.setText("Travel");
		travelButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				travelButtonMouseClicked(evt);
			}
		});
		YField = new JTextField();
		GridBagConstraints gbc_YField = new GridBagConstraints();
		gbc_YField.weightx = 0.5;
		gbc_YField.anchor = GridBagConstraints.NORTH;
		gbc_YField.fill = GridBagConstraints.HORIZONTAL;
		gbc_YField.insets = new Insets(0, 0, 5, 0);
		gbc_YField.gridx = 4;
		gbc_YField.gridy = 0;
		commandPanel.add(YField, gbc_YField);
		GridBagConstraints gbc_travelButton = new GridBagConstraints();
		gbc_travelButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_travelButton.insets = new Insets(0, 10, 5, 5);
		gbc_travelButton.gridx = 0;
		gbc_travelButton.gridy = 1;
		commandPanel.add(travelButton, gbc_travelButton);
		jLabel4 = new JLabel();
		jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);

		jLabel4.setText("Distance");
		GridBagConstraints gbc_jLabel4 = new GridBagConstraints();
		gbc_jLabel4.fill = GridBagConstraints.BOTH;
		gbc_jLabel4.anchor = GridBagConstraints.EAST;
		gbc_jLabel4.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel4.gridx = 1;
		gbc_jLabel4.gridy = 1;
		commandPanel.add(jLabel4, gbc_jLabel4);
		distanceField = new JTextField();
		GridBagConstraints gbc_distanceField = new GridBagConstraints();
		gbc_distanceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_distanceField.insets = new Insets(0, 0, 5, 5);
		gbc_distanceField.gridx = 2;
		gbc_distanceField.gridy = 1;
		commandPanel.add(distanceField, gbc_distanceField);
		rotateButton = new JButton();

		rotateButton.setText("Rotate");
		rotateButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				rotateButtonMouseClicked(evt);
			}
		});
		GridBagConstraints gbc_rotateButton = new GridBagConstraints();
		gbc_rotateButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_rotateButton.insets = new Insets(0, 10, 5, 5);
		gbc_rotateButton.gridx = 0;
		gbc_rotateButton.gridy = 2;
		commandPanel.add(rotateButton, gbc_rotateButton);
		jLabel5 = new JLabel();
		jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);

		jLabel5.setText("Angle");
		GridBagConstraints gbc_jLabel5 = new GridBagConstraints();
		gbc_jLabel5.fill = GridBagConstraints.BOTH;
		gbc_jLabel5.anchor = GridBagConstraints.EAST;
		gbc_jLabel5.insets = new Insets(0, 0, 0, 5);
		gbc_jLabel5.gridx = 1;
		gbc_jLabel5.gridy = 2;
		commandPanel.add(jLabel5, gbc_jLabel5);
		angleField = new JTextField();
		GridBagConstraints gbc_angleField = new GridBagConstraints();
		gbc_angleField.anchor = GridBagConstraints.NORTH;
		gbc_angleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_angleField.insets = new Insets(0, 0, 5, 5);
		gbc_angleField.gridx = 2;
		gbc_angleField.gridy = 2;
		commandPanel.add(angleField, gbc_angleField);
		robotPanel = new JPanel();

		robotPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Robot Position and Heading", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_robotPanel = new GridBagConstraints();
		gbc_robotPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_robotPanel.anchor = GridBagConstraints.NORTH;
		gbc_robotPanel.gridx = 0;
		gbc_robotPanel.gridy = 2;
		contentPanel.add(robotPanel, gbc_robotPanel);
		GridBagLayout gbl_robotPanel = new GridBagLayout();
		gbl_robotPanel.columnWidths = new int[] { 0, 86, 0, 82, 0, 81, 0 };
		gbl_robotPanel.rowHeights = new int[] { 20, 0 };
		gbl_robotPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_robotPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		robotPanel.setLayout(gbl_robotPanel);
		jLabel7 = new JLabel();
		jLabel7.setHorizontalAlignment(SwingConstants.LEFT);

		jLabel7.setText("X");
		GridBagConstraints gbc_jLabel7 = new GridBagConstraints();
		gbc_jLabel7.fill = GridBagConstraints.BOTH;
		gbc_jLabel7.anchor = GridBagConstraints.WEST;
		gbc_jLabel7.insets = new Insets(0, 10, 5, 5);
		gbc_jLabel7.gridx = 0;
		gbc_jLabel7.gridy = 0;
		robotPanel.add(jLabel7, gbc_jLabel7);
		robotX = new JTextField();
		GridBagConstraints gbc_robotX = new GridBagConstraints();
		gbc_robotX.weightx = 0.3;
		gbc_robotX.anchor = GridBagConstraints.NORTH;
		gbc_robotX.fill = GridBagConstraints.HORIZONTAL;
		gbc_robotX.insets = new Insets(0, 0, 5, 5);
		gbc_robotX.gridx = 1;
		gbc_robotX.gridy = 0;
		robotPanel.add(robotX, gbc_robotX);
		jLabel8 = new JLabel();
		jLabel8.setHorizontalAlignment(SwingConstants.LEFT);

		jLabel8.setText("Y");
		GridBagConstraints gbc_jLabel8 = new GridBagConstraints();
		gbc_jLabel8.fill = GridBagConstraints.BOTH;
		gbc_jLabel8.anchor = GridBagConstraints.WEST;
		gbc_jLabel8.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel8.gridx = 2;
		gbc_jLabel8.gridy = 0;
		robotPanel.add(jLabel8, gbc_jLabel8);
		robotY = new JTextField();
		GridBagConstraints gbc_robotY = new GridBagConstraints();
		gbc_robotY.weightx = 0.3;
		gbc_robotY.anchor = GridBagConstraints.NORTH;
		gbc_robotY.fill = GridBagConstraints.HORIZONTAL;
		gbc_robotY.insets = new Insets(0, 0, 5, 5);
		gbc_robotY.gridx = 3;
		gbc_robotY.gridy = 0;
		robotPanel.add(robotY, gbc_robotY);
		jLabel9 = new JLabel();
		jLabel9.setHorizontalAlignment(SwingConstants.LEFT);

		jLabel9.setText("Heading");
		GridBagConstraints gbc_jLabel9 = new GridBagConstraints();
		gbc_jLabel9.fill = GridBagConstraints.BOTH;
		gbc_jLabel9.anchor = GridBagConstraints.WEST;
		gbc_jLabel9.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel9.gridx = 4;
		gbc_jLabel9.gridy = 0;
		robotPanel.add(jLabel9, gbc_jLabel9);
		robotHeading = new JTextField();
		GridBagConstraints gbc_robotHeading = new GridBagConstraints();
		gbc_robotHeading.insets = new Insets(0, 0, 5, 0);
		gbc_robotHeading.weightx = 0.3;
		gbc_robotHeading.anchor = GridBagConstraints.NORTH;
		gbc_robotHeading.fill = GridBagConstraints.HORIZONTAL;
		gbc_robotHeading.gridx = 5;
		gbc_robotHeading.gridy = 0;
		robotPanel.add(robotHeading, gbc_robotHeading);

		pack();
	}

	private void connectButtonMouseClicked(java.awt.event.MouseEvent evt) {
		String name = nameText.getText();
		String address = addressText.getText();
		statusField.setText("Connecting to " + name);
		if (!communicator.connect(name, address)) {
			statusField.setText("Connection Failed");
			connected = false;
		} else {
			statusField.setText("Connected to " + name);
			connected = true;
		}
	}

	private void goButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (!connected)
			return;
		statusField
				.setText("GoTo " + XField.getText() + " " + YField.getText());
		float x;
		float y;
		try {
			x = Float.parseFloat(XField.getText());
			y = Float.parseFloat(YField.getText());
			System.out.println("Sent " + Command.GOTO + " x " + x + " y " + y);
			communicator.send(Command.GOTO, x, y);
			statusField.setText("waiting for data");
		} catch (NumberFormatException e) {
			statusField.setText("Invalid x, y values");
		}
	}

	private void travelButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (!connected)
			return;
		statusField.setText("Travel " + distanceField.getText());
		float distance;
		try {
			distance = Float.parseFloat(distanceField.getText());
			System.out.println("Sent " + Command.TRAVEL + " " + distance);
			communicator.send(Command.TRAVEL, distance);
			statusField.setText("waiting for data");
		} catch (NumberFormatException e) {
			statusField.setText("Invalid distance value");
		}
	}

	private void rotateButtonMouseClicked(java.awt.event.MouseEvent evt) {
		if (!connected)
			return;
		statusField.setText("Rotate " + angleField.getText());
		float angle;
		try {
			angle = Float.parseFloat(angleField.getText());
			System.out.println("Sent " + Command.ROTATE + " " + angle);
			communicator.send(Command.ROTATE, angle);
			statusField.setText("waiting for data");
		} catch (NumberFormatException e) {
			statusField.setText("Invalid angle value");
		}
	}

	public void showtRobotPosition(float x, float y, float heading) {
		robotX.setText("" + x);
		robotY.setText("" + y);
		robotHeading.setText("" + heading);
		statusField.setText("waiting for command");
	}

	private JTextField XField;
	private JTextField YField;
	private JTextField addressText;
	private JTextField angleField;
	private JPanel commandPanel;
	private JButton connectButton;
	private JTextField distanceField;
	private JButton goButton;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JTextField nameText;
	private JTextField robotHeading;
	private JPanel robotPanel;
	private JTextField robotX;
	private JTextField robotY;
	private JButton rotateButton;
	private JTextField statusField;
	private JButton travelButton;
	
	private boolean connected = false;

	private RCNavComms communicator = new RCNavComms(this);
	private JPanel connectPanel;
}
