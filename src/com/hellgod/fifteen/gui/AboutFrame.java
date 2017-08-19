package com.hellgod.fifteen.gui;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Евгений
 */

//Окно о программе
public class AboutFrame extends JFrame{

    private JScrollPane scrollPane;
    private JTextArea text;    
    
    
    public AboutFrame() {
        initComponents();
        setWindowAdapter();
    }
                      
    private void initComponents() {
        scrollPane = new JScrollPane();
        text = new JTextArea();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("About");
        setLocation(new java.awt.Point(400, 100));

        text.setColumns(20);
        text.setRows(5);
        text.setText("В разработке\n");
        text.setBorder(null);
        scrollPane.setViewportView(text);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }
             

    private void setWindowAdapter() {
        super.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
            
        });
    }
}
