package com.service;

import com.model.SkiResort;
import org.springframework.stereotype.Service;
import com.scraper.WebScraper;

import java.util.List;

@Service
public class WebScraperService {

    public List<SkiResort> getSkiResortsDetails() {
        WebScraper webScraper = WebScraper.getWebScraper();
        return webScraper.getSkiResortsData();
    }
}
