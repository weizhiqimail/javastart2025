package codeblock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClassUse {

  public static void main(String[] args) {
    JFrame win = new JFrame("登录窗口");
    JPanel panel = new JPanel();
    win.add(panel);

    JButton btn = new JButton("登录");
    panel.add(btn);

    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("您点击了登录按钮1");
      }
    });

    btn.addActionListener((ActionEvent e) -> {
      System.out.println("您点击了登录按钮2");
    });

    win.setSize(300, 300);
    win.setLocationRelativeTo(null);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.setVisible(true);

  }

}
