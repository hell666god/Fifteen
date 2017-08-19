package com.hellgod.fifteen.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Евгений
 */

//Окно "Your win"
public class WinDialog extends JDialog {

                
    private JButton exitBtn;
    private JLabel winLabel;
    private JButton newGameBtn;              

    public WinDialog(Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        int x = (int) (parent.getLocationOnScreen().getX()+(parent.getSize().getWidth()/2 - this.getSize().getWidth()/2));
        int y = (int) (parent.getLocationOnScreen().getY()+(parent.getSize().getHeight()/2 - this.getSize().getHeight()/2));
        setLocation(x,y);
    }


                        
    private void initComponents() {

        newGameBtn = new JButton();
        exitBtn = new JButton();
        winLabel = new JLabel();

        setModal(true);
        setName("WinDialog");
        
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        newGameBtn.setText("New Game");
        exitBtn.setPreferredSize(new Dimension(90, 28));
        newGameBtn.addActionListener((evt) -> {
            okButtonActionPerformed(evt);
        });

        exitBtn.setText("Exit");
        exitBtn.setPreferredSize(new Dimension(90, 28));
        exitBtn.addActionListener((evt) -> {
            cancelButtonActionPerformed(evt);
        });

        winLabel.setFont(new Font("Curlz MT", 1, 24));
        winLabel.setForeground(new Color(255, 0, 0));
        winLabel.setText("Your Win");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newGameBtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(winLabel)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(winLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameBtn))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(newGameBtn);

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {                                         
        GameFrame.getInstance().newGame();
        setVisible(false);
    }                                        

    private void cancelButtonActionPerformed(ActionEvent evt) {                                             
        System.exit(0);
    }                                            
    
}
