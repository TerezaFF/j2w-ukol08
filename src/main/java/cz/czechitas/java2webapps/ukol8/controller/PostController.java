package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznamPostu(@PageableDefault(sort = {"published"}) Pageable pageable) {
        return new ModelAndView("seznam").addObject("seznam", service.findByPublishedBeforeAndPublishedNotNull());
    }

    @GetMapping(path = "/", params = "slug")
    public ModelAndView detail(String slug) {
        return new ModelAndView("detail").addObject("detail", service.findByslug(slug));
    }

}
