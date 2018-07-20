package com.gromoks.webstatistic.dao.impl;

import com.gromoks.webstatistic.dao.StatisticDao;
import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StatisticDaoImpl implements StatisticDao {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<FileStatistic> getAllFile() {
        LOG.info("Start query to get all files from DB");
        long startTime = System.currentTimeMillis();

        List<FileStatistic> fileStatisticList = sessionFactory.getCurrentSession()
                .createCriteria(FileStatistic.class)
                .list();

        LOG.info("Finish query to get all files from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return fileStatisticList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LineStatistic> getAllLineByFileId(int fileId) {
        LOG.info("Start query to get all lines from DB by file id {}", fileId);
        long startTime = System.currentTimeMillis();

        List<LineStatistic> lineStatisticList = sessionFactory.getCurrentSession().createCriteria(LineStatistic.class)
                .add(Restrictions.eq("fileStatistic.id", fileId))
                .list();

        LOG.info("Finish query to get all lines from DB by file id. It took {} ms", System.currentTimeMillis() - startTime);
        return lineStatisticList;
    }
}
