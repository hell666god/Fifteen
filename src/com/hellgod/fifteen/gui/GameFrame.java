package com.hellgod.fifteen.gui;

import com.hellgod.fifteen.game.GameController;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Евгений
 */
public class GameFrame extends JFrame {

    private static GameFrame gameFrame;
    
    private JMenuItem AboutMenuItem;
    private JMenu EditMenu;
    private JMenuItem ExitMenuItem;
    private JMenu GameMenu;
    private JMenuItem NewGameMenuItem;
    private JButton btnNewGame;
    private JMenuBar jMenuBar1;
    private JPanel panel;
    
    private GameController controller;
    
    
    private GameFrame() {
        controller = new GameController();
        initComponents();
    }
    
    public static GameFrame getInstance(){
        if(gameFrame == null){
            gameFrame = new GameFrame();
        }
        
        return gameFrame;
    }

    private void initComponents() {

        panel = new JPanel();
        btnNewGame = new JButton();
        jMenuBar1 = new JMenuBar();
        GameMenu = new JMenu();
        NewGameMenuItem = new JMenuItem();
        ExitMenuItem = new JMenuItem();
        EditMenu = new JMenu();
        AboutMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fifteen");
        setPreferredSize(new Dimension(350,380));
        setResizable(false);
        setLocation(100, 100);

        btnNewGame.setFont(new Font("Snap ITC", 0, 18)); 
        btnNewGame.setForeground(new Color(0, 195, 90));
        btnNewGame.setText("Press For New Game");
        btnNewGame.addActionListener((e) -> {
            NewGameMenuItemActionPerformed(e);
        });

        panel.setLayout(new BorderLayout());
        panel.add(btnNewGame);
        
        jMenuBar1.setMinimumSize(new Dimension(70, 20));
        jMenuBar1.setPreferredSize(new Dimension(70, 20));

        GameMenu.setText("Game");

        NewGameMenuItem.setText("New Game");
        NewGameMenuItem.addActionListener((e) -> {
            NewGameMenuItemActionPerformed(e);
        });
        GameMenu.add(NewGameMenuItem);

        ExitMenuItem.setText("Exit");
        ExitMenuItem.addActionListener((e) -> {
            ExitMenuItemActionPerformed(e);
        });
        GameMenu.add(ExitMenuItem);

        jMenuBar1.add(GameMenu);

        EditMenu.setText("Edit");

        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener((e) -> {
            AboutMenuItemActionPerformed(e);
        });
        EditMenu.add(AboutMenuItem);

        jMenuBar1.add(EditMenu);

        setJMenuBar(jMenuBar1);

        
        getContentPane().setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        pack();
    }      
    
//    создание новой игры
    public void newGame() {
        controller.newGame();
        panel.removeAll();
        panel.add(controller.getGrid());
        panel.updateUI();
    }

    
//    обработка пункта меню новая игра
    private void NewGameMenuItemActionPerformed(ActionEvent evt) {                                                
        newGame();
    }                                               

//    обработка пункта меню о программе
    private void AboutMenuItemActionPerformed(ActionEvent evt) {                                              
        new AboutFrame().setVisible(true);
    }                                             

//    Обработка пункта меню выхода
    private void ExitMenuItemActionPerformed(ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameFrame.getInstance().setVisible(true);
            }
        });
        
        
    }

}
