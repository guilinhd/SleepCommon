package com.smartcloud.SleepService;

public interface IBaseService<E> {
    void setTotalCount(int value);
    int getTotalCount();

    void setWaveCount(int value);
    int getWaveCount();

    void setNext(IBaseService<E> next);

    boolean filter();
}
