package com.gromoks.webstatistic.service;

import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;

import java.util.List;

public interface StatisticService {
    List<FileStatistic> getAllFile();

    List<LineStatistic> getAllLineByFileId(int fileId);
}
