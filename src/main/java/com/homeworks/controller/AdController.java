package com.homeworks.controller;

import com.homeworks.domain.Ad;
import com.homeworks.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("ads-management")
//@AllArgsConstructor
public class AdController {


    private final AdService adService/* = new AdServiceImpl()*/;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @DeleteMapping("/ads/inactive")
    @ResponseBody
    public void deleteInactiveAds() {
        adService.deleteInactiveAds();
    }

    @GetMapping("/ads/headings")//GET /api/headings?ids=1,2,3
    @ResponseBody
    public List<Ad> getAdsByHeadings(@RequestParam List<Integer> headingIds) {
        return adService.getAdsByHeadings(headingIds);
    }

    @GetMapping("/ads/publication-date/{publicationDate}")
    @ResponseBody
    public List<Ad> getAdsByPublicationDate(@PathVariable LocalDate publicationDate) {
        //добавить фильтр, и возможно сделать тип стоки и парсить в методе в дату

        return adService.getAdsByPublicationDate(publicationDate);
    }

    @GetMapping("/ads/author/{id}")
    @ResponseBody
    public List<Ad> getAdsByAuthor(@PathVariable(name = "id") int authorId) {
        return adService.getAdsByAuthor(authorId);
    }

    @GetMapping("/ads/key-word/{word}")
    @ResponseBody
    public List<Ad> getAdsByKeyword(@PathVariable(name = "word") String keyWord) {
        return adService.getAdsByKeyword(keyWord);
    }

    @PostMapping("/ads")
    public void create(@RequestBody Ad obj) {
        adService.create(obj);
    }

    @PutMapping("/ads")
    public void update(@RequestBody Ad obj) {
        adService.update(obj);

    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public Ad getById(@PathVariable(name = "id") int id) {
        return adService.getById(id);
    }

    @DeleteMapping("/ads")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Ad obj) {
        adService.delete(obj);
    }
}
