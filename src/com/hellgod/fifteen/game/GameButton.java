package com.hellgod.fifteen.game;

import javax.swing.JButton;

/**
 *
 * @author Евгений
 */
public class GameButton extends JButton {
    Coordinate coordinate;
    int number;
    public GameButton(String name, Coordinate coordinate){
        super(name);
        try{
            number = Integer.parseInt(name);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        setCoordinate(coordinate);
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    
    public Coordinate getCoordinate(){
        return coordinate;
    }

    public int getNumber(){
        return this.number;
    }
}
