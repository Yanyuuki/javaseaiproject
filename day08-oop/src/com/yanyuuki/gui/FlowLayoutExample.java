package com.yanyuuki.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class FlowLayoutExample {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(FlowLayoutExample::createAndShowGui);
	}

	private static void createAndShowGui() {
		JFrame frame = new JFrame("FlowLayout 演示");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 18, 12);
		JPanel flowPanel = new JPanel(flowLayout);

		for (int i = 1; i <= 12; i++) {
			flowPanel.add(new JButton("按钮 " + i));
		}

		JPanel controlPanel = buildControlPanel(flowPanel, flowLayout, frame);

		frame.add(new JLabel("拖动窗口大小，观察组件自动换行", SwingConstants.CENTER), BorderLayout.NORTH);
		frame.add(flowPanel, BorderLayout.CENTER);
		frame.add(controlPanel, BorderLayout.SOUTH);

		frame.setSize(560, 320);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static JPanel buildControlPanel(JPanel flowPanel, FlowLayout flowLayout, JFrame frame) {
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));

		String[] alignNames = {"LEFT", "CENTER", "RIGHT"};
		int[] alignValues = {FlowLayout.LEFT, FlowLayout.CENTER, FlowLayout.RIGHT};
		JComboBox<String> alignBox = new JComboBox<>(alignNames);
		alignBox.setSelectedIndex(1);

		JSlider hgapSlider = new JSlider(0, 40, flowLayout.getHgap());
		hgapSlider.setMajorTickSpacing(10);
		hgapSlider.setPaintTicks(true);
		hgapSlider.setPaintLabels(true);

		JSlider vgapSlider = new JSlider(0, 30, flowLayout.getVgap());
		vgapSlider.setMajorTickSpacing(10);
		vgapSlider.setPaintTicks(true);
		vgapSlider.setPaintLabels(true);

		alignBox.addActionListener(e -> {
			int index = alignBox.getSelectedIndex();
			flowLayout.setAlignment(alignValues[index]);
			flowPanel.revalidate();
			flowPanel.repaint();
			frame.setTitle("FlowLayout 演示 - 对齐: " + alignNames[index]);
		});

		ChangeListener gapListener = e -> {
			flowLayout.setHgap(hgapSlider.getValue());
			flowLayout.setVgap(vgapSlider.getValue());
			flowPanel.revalidate();
			flowPanel.repaint();
		};

		hgapSlider.addChangeListener(gapListener);
		vgapSlider.addChangeListener(gapListener);

		controlPanel.add(new JLabel("对齐"));
		controlPanel.add(alignBox);
		controlPanel.add(new JLabel("水平间距"));
		controlPanel.add(hgapSlider);
		controlPanel.add(new JLabel("垂直间距"));
		controlPanel.add(vgapSlider);

		return controlPanel;
	}
}
