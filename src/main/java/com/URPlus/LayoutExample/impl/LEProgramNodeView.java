package com.URPlus.LayoutExample.impl;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;

public class LEProgramNodeView implements SwingProgramNodeView<LEProgramNodeContribution>{
	
	private final ViewAPIProvider apiProvider;
	private final Style style;
	private Locale locale;
	
	private JComboBox<Integer> ioComboBox = new JComboBox<Integer>();

	private static final ImageIcon LOGO_ICON = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/URPlus.png"));
	private static final ImageIcon STDCUBE_100_ICON = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/stdCube100square.png"));
	private static final ImageIcon STDCUBE_200_ICON = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/stdCube200square.png"));
	
	public LEProgramNodeView(ViewAPIProvider apiProvider, Style style, Locale locale) {
		// TODO Auto-generated constructor stub
		this.apiProvider = apiProvider;
		this.style = style;
		this.locale = locale;
	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<LEProgramNodeContribution> provider) {
		// TODO Auto-generated method stub
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JTabbedPane jTabbedPane = new JTabbedPane();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		jTabbedPane.add("Box",p1);  //tryout panel for BoxLayout
		jTabbedPane.add("Grid&Border",p2); //tryout panel for Grid&Border layoutManager
		jTabbedPane.add("Card",p3); //tryout panel for CardLayout
		jTabbedPane.add("Abs",p4); //tryout panel for AbsoluteLayout
		jTabbedPane.add("Spring",p5); //tryout Panel for Springlayout
		jTabbedPane.add("Group",p6); //tryout Panel for GroupLayout
		
		configBoxLayout(p1);
		configGridLayout(p2);
		configCardLayout(p3);
		configAbsLayoutPanel(p4);
		configSpringLayout(p5);
		configGroupLayout(p6);
		
		panel.add(jTabbedPane);
	}
	
	private void configAbsLayoutPanel(JPanel jPanel) {
		jPanel.setLayout(null);
		Box logo = createIcon(LOGO_ICON);
		ImageIcon cube100 = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/stdCube100square.png"));
		ImageIcon cube200 = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/stdCube200square.png"));
		logo.setBounds(500, 350, 150, 150); //set logo icon position and size
		JLabel pic = new JLabel();
		JLabel pic_2 = new JLabel();
		
		pic.setIcon(cube100); 
		pic.setBounds(100, 100, 100, 100); //set 100 pixel standard cube position and size
		pic_2.setIcon(cube200);
		pic_2.setBounds(400, 100, 200, 200);
		JButton button = new JButton("Test");
		JLabel jLabel_1 = new JLabel("In AbsoluteLayout, elements can be placed freely ");
		jLabel_1.setBounds(0, 400, 500, 30);
		JLabel jLabel_1_biz = new JLabel("anywhere with setBounds method.");
		jLabel_1_biz.setBounds(0, 430, 500, 30);
		JLabel jLabel_2 = new JLabel("Pos. x=200, y=200");
		jLabel_2.setBounds(200, 200, 200, 30);
		jLabel_2.setBackground(Color.GREEN);
		button.setBounds(0, 10, 100, 30);
		button.setEnabled(false);
		
		jPanel.add(pic);
		jPanel.add(pic_2);
		jPanel.add(jLabel_2);
		jPanel.add(jLabel_1);
		jPanel.add(jLabel_1_biz);
		jPanel.add(logo);
		jPanel.add(button);
	}
	private void configCardLayout(final JPanel jPanel) {
		jPanel.setLayout(new BorderLayout()); //the global panel adopts BorderLayout, and cardPanel uses CardLayout
		final CardLayout card = new CardLayout(5,5); //CardLayout with hgap = 5, vgap = 5
		Box box = Box.createHorizontalBox();
		Box buttonBox = Box.createHorizontalBox();
				
		final JPanel cardPanel = new JPanel();
		cardPanel.setLayout(card);
		

		JButton btn_previous = new JButton("< UP");
		JButton btn_next = new JButton("DOWN >");
		JButton b_1 = new JButton("1"), b_2 = new JButton("2"), b_3 = new JButton("3");
		JPanel p_1 = new JPanel(), p_2 = new JPanel(), p_3 = new JPanel();
		
		p_1.setBackground(new Color(246,152,130));
		p_2.setBackground(new Color(169,209,142));
		p_3.setBackground(new Color(157,195,230));
		p_1.add(new JLabel("JPanel_1"));
		p_2.add(new JLabel("JPanel_2"));
		p_3.add(new JLabel("JPanel_3"));
		cardPanel.add(p_1,"p1");
		cardPanel.add(p_2,"p2");
		cardPanel.add(p_3,"p3");
		
		b_1.setMargin(new Insets(2, 2, 2, 2));
		b_2.setMargin(new Insets(2, 2, 2, 2));
		b_3.setMargin(new Insets(2, 2, 2, 2));
	
		btn_previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.previous(cardPanel);
			}
		});
		btn_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.next(cardPanel);
			}
		});
		b_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(cardPanel, "p1");
			}
		});
		b_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(cardPanel, "p2");
			}
		});
		b_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(cardPanel, "p3");
			}
		});
		buttonBox.add(createSpacer(300, 0));
		buttonBox.add(btn_previous);
		buttonBox.add(createHorizontalSpacing());
		buttonBox.add(b_1);
		buttonBox.add(createHorizontalSpacing());
		buttonBox.add(b_2);
		buttonBox.add(createHorizontalSpacing());
		buttonBox.add(b_3);
		buttonBox.add(createHorizontalSpacing());
		buttonBox.add(btn_next);
		jPanel.add(buttonBox,BorderLayout.SOUTH);
		jPanel.add(cardPanel,BorderLayout.CENTER);
		
	}
	private void configGridLayout(final JPanel jPanel) {
		jPanel.setLayout(new BorderLayout());
		JPanel jPanel_millieu = new JPanel();
		JPanel jPanel_sud = new JPanel();
		JPanel jPanel_est = new JPanel();
		JPanel jPanel_nord = new JPanel();
		ButtonGroup group = new ButtonGroup();
		Box box = Box.createHorizontalBox();
		Box box_sud = Box.createHorizontalBox();
		Box box_est = Box.createVerticalBox();
		Box box_nord = Box.createHorizontalBox();
		jPanel_millieu.setLayout(new GridLayout(0,3,10,10)); //create GridLayout with 3 columns
		jPanel_sud.setLayout(new GridLayout(0,4,10,10)); //create GridLayout with 4 columns
		jPanel_est.setLayout(new GridLayout(3,0,10,10)); //create GridLayout with 3 rows
//		jPanel_nord.setLayout(new BoxLayout(jPanel_nord, BoxLayout.Y_AXIS));
		jPanel_nord.setBackground(Color.LIGHT_GRAY);
		

//		box.setBounds(100, 100, 400, 100); //in BorderLayout the setBounds will NOT take effect.
		
		JButton b_A = new JButton("button-A");
//		b_A.setSize(new Dimension(100,30));
		JButton b_B = new JButton("button-B");
		JButton b_C = new JButton("button-C");
		JButton b_D = new JButton("button-D");
		JButton b_E = new JButton("button-E");
		jPanel_millieu.add(b_A);
		jPanel_millieu.add(b_B);
		jPanel_millieu.add(b_C);
		jPanel_millieu.add(b_D);
		jPanel_millieu.add(b_E);
		
		JCheckBox cb_a = new JCheckBox("checkbox-A");
		JCheckBox cb_b = new JCheckBox("checkbox-B");
		JCheckBox cb_c = new JCheckBox("checkbox-C");
		JCheckBox cb_d = new JCheckBox("checkbox-D");
		JCheckBox cb_e = new JCheckBox("checkbox-E");
		JCheckBox cb_f = new JCheckBox("checkbox-F");
		JCheckBox cb_g = new JCheckBox("checkbox-G");
		JCheckBox cb_h = new JCheckBox("checkbox-H");
		jPanel_sud.add(cb_a);
		jPanel_sud.add(cb_b);
		jPanel_sud.add(cb_c);
		jPanel_sud.add(cb_d);
		jPanel_sud.add(cb_e);
		jPanel_sud.add(cb_f);
		jPanel_sud.add(cb_g);
		jPanel_sud.add(cb_h);
		
		JRadioButton rb_a = new JRadioButton("radiobutton-A");
		JRadioButton rb_b = new JRadioButton("radiobutton-B");
		JRadioButton rb_c = new JRadioButton("radiobutton-C");
		group.add(rb_a);group.add(rb_b);group.add(rb_c);
		jPanel_est.add(rb_a);
		jPanel_est.add(rb_b);
		jPanel_est.add(rb_c);
		
		jPanel_nord.add(createSpacer(0, 100));
//		JLabel jLabel = new JLabel("this BorderLayout North area.");
//		jPanel_nord.add(jLabel);
		box.add(jPanel_millieu);
		box_sud.add(jPanel_sud);
		box_est.add(jPanel_est);
		box_nord.add(jPanel_nord);
		
		box.setBorder(BorderFactory.createEtchedBorder()); //create border line with Etched effect
		box_sud.setBorder(BorderFactory.createRaisedBevelBorder()); //create border line with Raised effect or Lowered effct.
		box_est.setBorder(BorderFactory.createLoweredBevelBorder());
		
		
		jPanel.add(box,BorderLayout.CENTER);
		jPanel.add(box_sud,BorderLayout.SOUTH);
		jPanel.add(box_est,BorderLayout.EAST);
		jPanel.add(box_nord,BorderLayout.NORTH);
	}
	private void configBoxLayout(final JPanel jPanel) {
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		JTextField tf = new JTextField();
		JButton button = new JButton("Test");
		ImageIcon logoicon = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/URPlus.png"));
		ImageIcon cube100 = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/stdCube100square.png"));
		logoicon.setImage(logoicon.getImage().getScaledInstance(logoicon.getIconWidth()/10, logoicon.getIconHeight()/10, Image.SCALE_DEFAULT));
		JLabel jLabel = new JLabel();
		jLabel.setIcon(logoicon);
		jLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel jLabel_100cube = new JLabel();
		jLabel_100cube.setIcon(cube100);
		jLabel_100cube.setAlignmentX(Component.LEFT_ALIGNMENT);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setBackground(Color.YELLOW);
		tf.setEnabled(false);
		tf.setText("text display demo");
		tf.setPreferredSize(new Dimension(300,30));
		tf.setMaximumSize(tf.getPreferredSize());
		tf.setAlignmentX(Component.LEFT_ALIGNMENT);
		button.setSize(new Dimension(100,30)); //NOT working in BoxLayout //在BoxLayout中不起作用
		button.setEnabled(false);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jPanel.add(createSpacer(0, 50));
		jPanel.add(createDescription("BoxLayout draws elements vertically from up -> down:"));
		jPanel.add(createVerticalSpacing());
		jPanel.add(tf);
		jPanel.add(createVerticalSpacing());
		jPanel.add(button);
		jPanel.add(createVerticalSpacing());
		jPanel.add(jLabel_100cube);
		jPanel.add(createVerticalSpacing());
		jPanel.add(jLabel);
		
		
	}
	private void configSpringLayout(final JPanel jPanel) {
		SpringLayout layout = new SpringLayout();
		jPanel.setLayout(layout);
		
		JLabel headerLabel = new JLabel("",JLabel.CENTER);
		JLabel label = new JLabel("Input name:");
		JLabel labelIcon = new JLabel();
		ImageIcon icon = new ImageIcon(LEProgramNodeContribution.class.getResource("/logo/SpringLayoutDemo.png"));
		icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_DEFAULT));
		labelIcon.setIcon(icon);
		JTextField textField = new JTextField("SpringLayout",15);
		textField.setEnabled(false);
		headerLabel.setText("Layout in action: SpringLayout");
		headerLabel.setToolTipText("setToolTipText..");
		
		layout.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.SOUTH, headerLabel);
		layout.putConstraint(SpringLayout.WEST, textField, 20, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, headerLabel, 50, SpringLayout.NORTH, jPanel);
		layout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.NORTH, labelIcon, 100, SpringLayout.SOUTH, textField);
		layout.putConstraint(SpringLayout.WEST, labelIcon, 0, SpringLayout.WEST, label);
		
		jPanel.add(headerLabel);
		jPanel.add(label);
		jPanel.add(textField);
		jPanel.add(labelIcon);

	}
	private void configGroupLayout(final JPanel jPanel) {
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
		JLabel headerLabel = new JLabel("Layout in action: GroupLayout",JLabel.LEFT);
		headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		jPanel.add(createSpacer(0, 20));
		jPanel.add(headerLabel);
		jPanel.add(createSpacer(0, 100));
		
		JPanel sub_panel = new JPanel();
		sub_panel.setSize(300,150);
		sub_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		GroupLayout layout = new GroupLayout(sub_panel);
		sub_panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JButton button_a = new JButton("Button-A");
		JButton button_b = new JButton("Button-B");
		JButton button_c = new JButton("Button-C");
		JButton button_d = new JButton("Button-D");
		JButton button_e = new JButton("Button-E");
		button_a.setEnabled(false);button_b.setEnabled(false);button_c.setEnabled(false);button_d.setEnabled(false);button_e.setEnabled(false);
		/* HorizontalGroup (only determinate X direction
		 * Horizontal - Sequential => left-right
		 * Horizontal - Parallel => up-down
		 */
		//Horizontal-Parallel btn-a & btn-b
		GroupLayout.ParallelGroup hParalGroup01 = layout.createParallelGroup().addComponent(button_a).addComponent(button_b);
		
		//Horizontal-Parallel btn-c & btn-d
		GroupLayout.ParallelGroup hParalGroup02 = layout.createParallelGroup().addComponent(button_c).addComponent(button_d);
		
		//Horizontal-Sequential hParalGroup01 & hParalGroup02
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup01).addGroup(hParalGroup02);
		
		//Horizontal-Paralle hSeqGroup & btn-e
		GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addGroup(hSeqGroup).addComponent(button_e,GroupLayout.Alignment.CENTER);
		
		layout.setHorizontalGroup(hParalGroup); //complete horizontal configuration
		
		/*VerticalGroup (only determinate Y direction
		 * Vertical - Sequential => up-down
		 * Vertical - Parallel => left-right
		 */
		//Vertical-Parallel btn-a & btn-c
		GroupLayout.ParallelGroup vParalGroup01 = layout.createParallelGroup().addComponent(button_a).addComponent(button_c);
		
		//Vertical-Parallel btn-b & btn-d
		GroupLayout.ParallelGroup vParalGroup02 = layout.createParallelGroup().addComponent(button_b).addComponent(button_d);
		
		//Vertical-Sequential vParalGroup01 & vParalGroup02 & btn05
		GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addGroup(vParalGroup01).addGroup(vParalGroup02).addComponent(button_e);
		
		layout.setVerticalGroup(vSeqGroup); //complete vertical configuration
		
		jPanel.add(sub_panel);
		
	}
	
	private Box createIcon(final ImageIcon image) {
		Box box = Box.createHorizontalBox();
		final JLabel pic = new JLabel();
		image.setImage(image.getImage().getScaledInstance(image.getIconWidth()/10, image.getIconHeight()/10, Image.SCALE_DEFAULT));
		pic.setIcon(image);
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(pic);
		return box;
	}

	
	private Box createDescription(String desc) {
		Box box = Box.createHorizontalBox();//示教器上显示的每一个组建都需要转换成Box或者Component类型，再由JPanel.add()添加到面板上，String或者JLabel或者其他组建类型不能直接添加
		box.setAlignmentX(Component.LEFT_ALIGNMENT);//设置组建Y方向左对齐
		box.setPreferredSize(new Dimension(500,30));
		box.setMaximumSize(box.getPreferredSize());
		JLabel label = new JLabel(desc); //将String装进JLabel中
		box.add(label); //将JLabel装进Box中
		return box;
	}
	private Component createHorizontalSpacing() {
		return Box.createRigidArea(new Dimension(style.getHorizontalSpacing(),0));
	}
	private Component createVerticalSpacing() {
		return Box.createRigidArea(new Dimension(0,style.getVerticalSpacing()));
	}
	private Component createSpacer(int width, int height) {
		return Box.createRigidArea(new Dimension(width,height));
	}

}
