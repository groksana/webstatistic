package com.gromoks.webstatistic.service.impl;

import com.gromoks.webstatistic.dao.StatisticDao;
import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;
import com.gromoks.webstatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticDao statisticDao;

    @Override
    public List<FileStatistic> getAllFile() {
        return statisticDao.getAllFile();
    }

    @Override
    public List<LineStatistic> getAllLineByFileId(int fileId) {
        return statisticDao.getAllLineByFileId(fileId);
    }
}
