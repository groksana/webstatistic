package com.gromoks.webstatistic.controller;

import com.gromoks.webstatistic.entity.FileStatistic;
import com.gromoks.webstatistic.entity.LineStatistic;
import com.gromoks.webstatistic.service.StatisticService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

public class StatisticControllerTest {

    @Mock
    private StatisticService statisticService;

    @InjectMocks
    private StatisticController statisticController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(statisticController).build();
    }

    @Test
    public void testGetAllFile() throws Exception {
        int firstFileId = 1;
        String firstFileName = "test";
        String firstLongestWords = "ffffff";
        String firstShortestWords = "f";
        int firstLength = 10;
        double firstAverageWordLength = 3.5;

        int secondFileId = 2;
        String secondFileName = "test2";
        String secondLongestWords = "ggggggg";
        String secondShortestWords = "g";
        int secondLength = 10;
        double secondAverageWordLength = 3;

        List<FileStatistic> fileStatisticList = new ArrayList<>();
        fileStatisticList.add(new FileStatistic(firstFileId, firstFileName, firstLongestWords, firstShortestWords, firstLength, firstAverageWordLength));
        fileStatisticList.add(new FileStatistic(secondFileId, secondFileName, secondLongestWords, secondShortestWords, secondLength, secondAverageWordLength));

        when(statisticService.getAllFile()).thenReturn(fileStatisticList);
        mockMvc.perform(get("/v1/statistic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].fileName", is("test")))
                .andExpect(jsonPath("$[0].longestWords", is("ffffff")))
                .andExpect(jsonPath("$[0].shortestWords", is("f")))
                .andExpect(jsonPath("$[0].length", is(10)))
                .andExpect(jsonPath("$[0].averageWordLength", is(3.5)));
    }

    @Test
    public void testGetAllLineByFileId() throws Exception {
        int fileId = 1;
        String fileName = "test";

        FileStatistic fileStatistic = new FileStatistic();
        fileStatistic.setId(fileId);
        fileStatistic.setFileName(fileName);

        int firstRowNumber = 1;
        String firstLongestWords = "ffffff";
        String firstShortestWords = "f";
        int firstLength = 10;
        double firstAverageWordLength = 3.5;

        int secondRowNumber = 2;
        String secondLongestWords = "ggggggg";
        String secondShortestWords = "g";
        int secondLength = 10;
        double secondAverageWordLength = 3;

        List<LineStatistic> lineStatisticList = new ArrayList<>();
        lineStatisticList.add(new LineStatistic(firstRowNumber, firstLongestWords, firstShortestWords, firstLength, firstAverageWordLength, fileStatistic));
        lineStatisticList.add(new LineStatistic(secondRowNumber, secondLongestWords, secondShortestWords, secondLength, secondAverageWordLength, fileStatistic));

        when(statisticService.getAllLineByFileId(fileId)).thenReturn(lineStatisticList);
        mockMvc.perform(get("/v1/statistic/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].rowNumber", is(1)))
                .andExpect(jsonPath("$[0].longestWords", is("ffffff")))
                .andExpect(jsonPath("$[0].shortestWords", is("f")))
                .andExpect(jsonPath("$[0].length", is(10)))
                .andExpect(jsonPath("$[0].averageWordLength", is(3.5)));
    }
}
