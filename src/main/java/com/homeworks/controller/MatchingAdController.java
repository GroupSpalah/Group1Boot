package com.homeworks.controller;

import com.homeworks.domain.MatchingAd;
import com.homeworks.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("matchingAds-management")
//@AllArgsConstructor
public class MatchingAdController {

    private final CrudService<MatchingAd> matchingAdService;

    @Autowired
    public MatchingAdController(CrudService<MatchingAd> MatchingAdService) {
        this.matchingAdService = MatchingAdService;
    }

    @PostMapping("/matchingAds")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatchingAd obj) {
        matchingAdService.create(obj);
    }

    @PutMapping("/matchingAds")
    public void update(@RequestBody MatchingAd obj) {
        matchingAdService.update(obj);

    }

    @GetMapping("/matchingAds/{id}")
    @ResponseBody
    public MatchingAd getMatchingAdsById(@PathVariable(name = "id") int id) {
        return matchingAdService.getById(id);
    }

    @DeleteMapping("/matchingAds")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody MatchingAd obj) {
        matchingAdService.delete(obj);
    }
}
