package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JFrameClass {

  public static void main(String[] args) {

    JFrame jf = new JFrame("窗口标题");
    jf.setSize(300, 300);
    jf.setLocationRelativeTo(null);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton jButton = new JButton("登陆");
    jButton.setSize(100, 100);
    jButton.setLocation(100, 100);

    jButton.addActionListener( (ActionEvent e) -> {
      System.out.println("按钮被点击了");
    });

    jf.add(jButton);
    jf.setVisible(true);
  }
}
