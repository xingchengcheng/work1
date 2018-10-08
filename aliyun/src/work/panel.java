package work;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;


public class panel extends JPanel{
	private JLabel label_send, label_receive;            //标签      发送消息，接收消息
	private JButton button_send, button_receive;//按钮      发送消息，接收消息
	private JTextField send_text;//文本框  消息发送
	private JTextField receive_text;//密码框  消息接收
	private JPanel panel_send;
	private JPanel panel_receive;
	private JPanel panelLoginButton;
	public panel(){
		this.label_send = new JLabel("发送消息");
		this.label_receive= new JLabel("接收消息");
		this.button_send = new JButton("发送");
		this.button_receive = new JButton("接收");
		this.send_text = new JTextField(10);
		this.receive_text = new JTextField(10);
		this.panel_send = new JPanel();
		this.panel_receive = new JPanel();
		this.panelLoginButton = new JPanel();
		//this.spanel=new JPanel();
		//this.rpanel=new JPanel();
		this.setLayout(new GridLayout(3, 1));  //网格式布局
		this.panel_send.add(this.label_send);
		this.panel_send.add(this.send_text);
		this.panel_receive.add(this.label_receive);
		this.panel_receive.add(this.receive_text);
		this.panelLoginButton.add(button_send);
		this.panelLoginButton.add(button_receive);
		this.add(this.panel_send);
		this.add(this.panel_receive);
		this.add(this.panelLoginButton);
		send_action send=new send_action();
		button_send.addActionListener(send);
		send_action receive=new send_action();
		button_receive.addActionListener(receive);
		}
	private class send_action implements ActionListener
	{
		public send_action()
		{
			
		}
		 public void actionPerformed(ActionEvent event){  
	            //ActionEvent对应按钮点击、菜单选择、选择列表项或在文本框中ENTER  
			 if(event.getActionCommand().equals("发送"))
			 {
				 System.out.println("点击了发送消息按钮");
				 String mention_send=send_text.getText();
				 ProducerDemo send=new ProducerDemo();
				 send.producer(mention_send);
			 }
			 if(event.getActionCommand().equals("接收"))
			 {
				 System.out.println("点击了接收消息按钮");
				 ComsumerDemo comsume=new ComsumerDemo();
				 comsume.comsurmer();
				 String result=comsume.result;
				 receive_text.setText(result);
			 }
	        }  
	}
}
