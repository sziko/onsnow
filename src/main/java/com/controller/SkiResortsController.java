package com.controller;

import com.model.SkiResort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.WebScraperService;

import java.util.List;

@RestController("/ski-resorts")
public class SkiResortsController {

    @Autowired
    private WebScraperService webScraperService;

    @GetMapping
    public ResponseEntity<List<SkiResort>> getResortDetails() {
        final List<SkiResort> skiResorts = webScraperService.getSkiResortsDetails();
        return ResponseEntity.ok().body(skiResorts);
    }
}
