package org.programmerplanet.sshtunnel.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * 
 * @author <a href="jfifield@programmerplanet.org">Joseph Fifield</a>
 */
public class CustomDialog extends JDialog {

	public static final int OK = 1;
	public static final int CANCEL = 0;

	private int selection = CANCEL;

	public static int show(Frame owner, String title, JPanel panel) {
		CustomDialog dialog = new CustomDialog(owner, title, panel);

		dialog.setResizable(false);
		
		dialog.pack();
		dialog.setLocationRelativeTo(owner);
		dialog.setVisible(true);
		dialog.dispose();

		return dialog.selection;
	}

	public CustomDialog(Frame owner, String title, JPanel panel) {
		super(owner, title, true);
		initialize(panel);
	}

	private void initialize(JPanel panel) {
		this.getContentPane().setLayout(new BorderLayout());

		this.getContentPane().add(panel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton ok = new JButton("Ok");
		buttonPanel.add(ok);
		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				selection = OK;
				CustomDialog.this.setVisible(false);
			}

		});

		JButton cancel = new JButton("Cancel");
		buttonPanel.add(cancel);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CustomDialog.this.setVisible(false);
			}

		});
	}

}