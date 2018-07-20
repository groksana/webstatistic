package com.gromoks.webstatistic.dao;

import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;

import java.util.List;

public interface StatisticDao {
    List<FileStatistic> getAllFile();

    List<LineStatistic> getAllLineByFileId(int fileId);
}
