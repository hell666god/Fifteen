package com.hellgod.fifteen.game;

import com.hellgod.fifteen.gui.WinDialog;
import com.hellgod.fifteen.gui.GameFrame;
import com.hellgod.fifteen.gui.GameGrid;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Евгений
 */

//"Мозг" игры
public class GameController implements ActionListener{

    private GameGrid gameGrid;
    private Component panel;
    private GameButton[][] buttons;
    private Integer[][] numGrid;
    
//    Комбинация для выигрыша... лучше пока не придумал
    private Integer[][] winCombination = {{1,2,3,4},
                                          {5,6,7,8},
                                          {9,10,11,12},
                                          {13,14,15,0}};
    
    
    public GameController(){
        gameGrid = new GameGrid();
        
       
    }
    
//    создание новой игры
    public void newGame() {
        
        createNumberGrid();
        gameGrid.createGameGrid(numGrid);
        
        panel = (JPanel) gameGrid.getGrid();
        buttons = gameGrid.getButtons();
        for(int y=0; y<buttons.length; y++){
            for(int x=0; x<buttons[y].length; x++){
                buttons[y][x].addActionListener(this);
            }
        }
        
    }
    
//    возвращает игравую панель
    public Component getGrid(){
        return panel;
    }
    
//    Создание изначального массива чисел
     public void createNumberGrid(){
        Random random = new Random();
        int num;
        numGrid = new Integer[4][4];
        
        ArrayList<Integer> tmpList = new ArrayList<>(16);
        while(tmpList.size() != 16){
            num = random.nextInt(16);
            if(!tmpList.contains(num)){
                tmpList.add(num);
            }
        }

//        Для быстрой Проверки работоспособности
//        for(int i=1;i<15;i++){
//            tmpList.add(i);
//        }
//        tmpList.add(0);
//        tmpList.add(15);
        
        Iterator iterator = tmpList.iterator();
        for(int y=0; y<4; y++){
            for(int x=0; x<4; x++){
                numGrid[y][x] = (Integer) iterator.next();
            }
        }
        
    }
     
     
//    "Меняет" кнопки местами... конечно не сами кнопки
    private void swapButtons(GameButton pressedBtn, GameButton nullBtn) {
    
        String text = pressedBtn.getText();
        pressedBtn.setText(nullBtn.getText());
        nullBtn.setText(text);
        pressedBtn.setEnabled(false);
        nullBtn.setEnabled(true);
        
    }

//    Поиск пустой кнопки
    private GameButton nullButton() {
        GameButton nullButton = null;
        for(GameButton[] btns: buttons)
            for(GameButton btn: btns){
                if(btn.getText().equals("")){
                    nullButton = btn;
                }
            }
        
        return nullButton;
    }

//    Обработка нажатий кнопок игровой панели
    @Override
    public void actionPerformed(ActionEvent e) {
        
//        Проверка непосредственное нахождение нажатой кнопки возле пустой
        GameButton pressedBtn =(GameButton) e.getSource();
        GameButton nullBtn = nullButton();
        if(nullBtn.getCoordinate().getX() == pressedBtn.getCoordinate().getX()){
            if((nullBtn.getCoordinate().getY() == pressedBtn.getCoordinate().getY()-1)||
                    (nullBtn.getCoordinate().getY() == pressedBtn.getCoordinate().getY()+1)){
                swapButtons(pressedBtn, nullBtn);
                swapNumber(pressedBtn.getCoordinate(), nullBtn.getCoordinate());
            }
                        
        }else if(nullBtn.getCoordinate().getY() == pressedBtn.getCoordinate().getY()){
            if((nullBtn.getCoordinate().getX() == pressedBtn.getCoordinate().getX()-1)||
                    (nullBtn.getCoordinate().getX() == pressedBtn.getCoordinate().getX()+1)){
                    swapNumber(pressedBtn.getCoordinate(), nullBtn.getCoordinate());
                    swapButtons(pressedBtn, nullBtn);
            }
        }
        
//        Если комбинация совпала с конрольной содается модальное окно "Your win"
        if(checkWin()){
            new WinDialog(GameFrame.getInstance(), true).setVisible(true);
        }
    }

//    Проверка условия выйгрыша
    public boolean checkWin() {
        boolean isWin = false;
        
        if(numGrid[3][3] == 0){
            isWin = true;    
            for(int y=0; y<numGrid.length; y++){
                for(int x=0; x<numGrid[y].length; x++){
                    if(numGrid[y][x] != winCombination[y][x]){
                        return false;
                    }
                } 
            }
        }
        
        return isWin;
    }

//    Меняет числа в рабочем массиве местами
    private void swapNumber(Coordinate coordinate1, Coordinate coordinate2) {
        Integer tmp = numGrid[coordinate1.getY()][coordinate1.getX()];
        numGrid[coordinate1.getY()][coordinate1.getX()] = numGrid[coordinate2.getY()][coordinate2.getX()];
        numGrid[coordinate2.getY()][coordinate2.getX()] = tmp;

//        printNumGrid();
    }
    
//      проверка правильности пермещения
//    private void printNumGrid() {
//        for(Integer[] nums : numGrid){
//            for(Integer num: nums){
//                System.out.print(num+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//    }
}
