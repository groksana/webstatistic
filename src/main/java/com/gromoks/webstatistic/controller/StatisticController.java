package com.gromoks.webstatistic.controller;

import com.gromoks.webstatistic.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.gromoks.webstatistic.util.JsonJacksonConverter.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/v1/statistic", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatisticController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private StatisticService statisticService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String getAllFile() {
        LOG.info("Sending request to get all files");
        long startTime = System.currentTimeMillis();

        String json = toJson(statisticService.getAllFile());

        LOG.info("Files are received. It took {} ms", System.currentTimeMillis() - startTime);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/{fileId}", method = GET)
    public String getAllLineByFileId(@PathVariable("fileId") int fileId) {
        LOG.info("Sending request to get all lines by file id = {}", fileId);
        long startTime = System.currentTimeMillis();

        String json = toJson(statisticService.getAllLineByFileId(fileId));

        LOG.info("Lines are received. It took {} ms", System.currentTimeMillis() - startTime);
        return json;
    }
}
