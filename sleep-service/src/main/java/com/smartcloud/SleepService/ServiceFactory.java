package com.smartcloud.SleepService;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceFactory<E> {
    private ArrayList<IBaseService<E>> _services = new ArrayList<>();
    private BaseService<E> _startService;
    private BaseService<E> _endService;

    private int _totalCount = 0;
    private int _waveCount = 0;

    private int _validCount = 0;
    public int getValidCount() {
        return _validCount;
    }

    public java.util.function.Consumer<HashMap<String, E>> consumer;

    public ServiceFactory(BaseService<E> startService, BaseService<E> endService){
        _startService = startService;
        _endService = endService;

        _services.add(startService);
    }

    public void addSerivce(IBaseService<E> service)
    {
        _services.add(service);
    }

    public void buildService()
    {
        _services.add(_endService);

        for (int i = 0; i < _services.size(); i++) {
            if (i < _services.size() - 1){
                _services.get(i).setNext(_services.get(i + 1));
            }
        }
    }

    public void add(E[] models)
    {
        for (int i = 0; i < models.length; i++) {
            filter(models[i]);
        }
    }

    private void filter(E model)
    {
        if(_totalCount > 2147483647)
        {
            _totalCount = 0;
        }
        _totalCount++;

        if (_waveCount > 2147483647)
        {
            _waveCount = 0;
        }
        _waveCount++;

        //添加数据到开始服务
        _startService.add(model);

        for (int i = 0; i < _services.size() - 1; i++) {
            _services.get(i).setTotalCount(_totalCount);
            _services.get(i).setWaveCount(_waveCount);

            _services.get(i).filter();

            _waveCount = _services.get(i).getWaveCount();
        }

        if (_endService.filter()){
            _validCount++;
            consumer.accept(_endService.Models);
        }
    }
}
