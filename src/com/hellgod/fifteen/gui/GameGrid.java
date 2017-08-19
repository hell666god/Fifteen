package com.hellgod.fifteen.gui;

import com.hellgod.fifteen.game.Coordinate;
import com.hellgod.fifteen.game.GameButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Евгений
 */

//Игровая панель
public class GameGrid {
    private JPanel grid;
    private GameButton[][] buttons;
    
    public Component getGrid(){
        return grid;
    }
    
    public GameButton[][] getButtons(){
        return buttons;
    }
    
//    Создание игровой панели
    public void createGameGrid(Integer[][] numGrid){
        
        grid = new JPanel();

        grid.setLayout(new GridLayout(4,4));
        grid.setPreferredSize(new Dimension(350,350));
        
        createButtons(numGrid);

        for(GameButton[] tmpButtons: buttons){
            for(GameButton tmpButton: tmpButtons){
                //System.out.println(tmpButton);
                grid.add(tmpButton);
            }
        }

    }
    
    
//    Создание кнопок 
    private void createButtons(Integer[][] numGrid){
        buttons = new GameButton[4][4];
        GameButton tmp;
        for(int y=0; y<4; y++){
            for(int x=0; x<4; x++){
                tmp = new GameButton(numGrid[y][x].toString(), new Coordinate(x,y));
                tmp.setPreferredSize(new Dimension(49,49));
                if(numGrid[y][x].equals(0)){
                    tmp.setText("");
                    tmp.setEnabled(false);
                }
                buttons[y][x] = tmp;
            }
        }
    }
    
}
