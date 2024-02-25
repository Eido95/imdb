package com.derkino.data_service.controllers;

import com.derkino.data_service.documents.Title;
import com.derkino.data_service.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TitleController {
    @Autowired
    TitleService titleService;

    @GetMapping("/titles/{id}")
    public Title getTitle(@PathVariable String id) {
        return titleService.getTitle(id);
    }

    @GetMapping("/titles")
    public Page<Title> getTitles(Pageable pageable,
                                 @RequestParam(required = false) String titleType,
                                 @RequestParam(required = false) String primaryTitle,
                                 @RequestParam(required = false) Boolean isAdult,
                                 @RequestParam(required = false) List<String> genres) {
        return titleService.getTitles(pageable, titleType, primaryTitle, isAdult, genres);
    }
}
