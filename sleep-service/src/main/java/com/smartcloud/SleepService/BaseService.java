package com.smartcloud.SleepService;

import java.util.HashMap;
import java.util.LinkedList;

public class BaseService<E> extends LinkedList<E> implements IBaseService<E> {
    private int _totalCount = 0;
    public void setTotalCount(int value) {
        _totalCount = value;
    }
    public int getTotalCount() {
        return _totalCount;
    }

    private int _waveCount = 0;
    public void setWaveCount(int value) {
        _waveCount = value;
    }
    public int getWaveCount() {
        return _waveCount;
    }

    private BaseService<E> _next;
    public void setNext(IBaseService<E> next) {
        _next = (BaseService<E>) next;
    }

    private int _filterCount = 0;
    public BaseService(int count)
    {
        _filterCount = count;
    }

    public java.util.function.BooleanSupplier Func;
    public E Model;
    public HashMap<String, E> Models;

    public boolean filter() {
        if (size() > _filterCount)
        {
            if (_next != null){
                if (Func.getAsBoolean()){
                    _next.add(Model);
                }
                remove();
            }
            return  true;
        }
        return false;
    }
}
