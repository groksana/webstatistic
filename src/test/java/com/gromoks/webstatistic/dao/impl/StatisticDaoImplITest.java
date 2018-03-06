package com.gromoks.webstatistic.dao.impl;

import com.gromoks.webstatistic.dao.StatisticDao;
import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;
import com.gromoks.webstatistic.util.EmbeddedDataBaseLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:/spring/test-db-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticDaoImplITest {
    private final static String SQL_FILE_INFO_STATEMENT = "SELECT * FROM FILE_INFO";

    private final static String SQL_LINE_INFO_STATEMENT = "SELECT * FROM LINE_INFO";

    @Autowired(required = true)
    private DataSource dataSource;

    @Autowired(required = true)
    private EmbeddedDataBaseLoader dbFiller;

    @Autowired(required = true)
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StatisticDao statisticDao;

    @Before
    public void setUp() throws Exception {
        dbFiller.fill();
    }

    @Test
    public void dbPopulationTest() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FILE_INFO_STATEMENT);
        checkFileInfoState(rows);

        rows = jdbcTemplate.queryForList(SQL_LINE_INFO_STATEMENT);
        checkLineInfoState(rows);
    }

    @Test
    public void getAllFileTest() {
        List<FileStatistic> fileStatisticList = statisticDao.getAllFile();
        assertEquals(fileStatisticList.size(), 2);
    }

    @Test
    public void getAllLineByFileIdTest() {
        int fileId = 1;
        List<LineStatistic> lineStatisticList = statisticDao.getAllLineByFileId(fileId);
        assertEquals(lineStatisticList.size(), 2);
    }

    private void checkFileInfoState(List<Map<String, Object>> rows) {
        assertEquals(rows.size(), 2);
        Map<String, Object> humanData = rows.get(0);
        assertEquals(humanData.get("FILE_NAME"), "text1");
    }

    private void checkLineInfoState(List<Map<String, Object>> rows) {
        assertEquals(rows.size(), 2);
        Map<String, Object> humanData = rows.get(0);
        assertEquals(humanData.get("LONGEST_WORDS"), "testtest");
    }
}
