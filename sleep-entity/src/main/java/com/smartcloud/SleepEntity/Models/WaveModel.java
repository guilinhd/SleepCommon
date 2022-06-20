package com.smartcloud.SleepEntity.Models;

public class WaveModel {
    private boolean _type = false;
    public void setType(boolean value){
        _type = value;
    }
    public boolean getType(){
        return _type;
    }

    private int _x = 0;
    public void setX(int value) {
        _x = value;
    }
    public int getX() {
        return _x;
    }

    private Double _y = 0.0;
    public void setY(Double value){
        _y = value;
    }
    public Double getY(){
        return _y;
    }
}
