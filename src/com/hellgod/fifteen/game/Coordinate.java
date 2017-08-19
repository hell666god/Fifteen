package com.hellgod.fifteen.game;

/**
 *
 * @author Евгений
 */
public class Coordinate {

    private int x;
    private int y;
    
    public Coordinate(int x, int y){
        setXY(x,y);
    }
    
    public Coordinate(Coordinate coord){
        setXY(coord.getX(), coord.getY());
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getY(){
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    
}
