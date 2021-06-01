package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.time.LocalDate;

@Service
public class PostService {

    private final PostRepository repository;

    Pageable page20 = PageRequest.of(0, 20, Sort.by("published").descending());

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post findBySlug(String slug) {
       return repository.findBySlug(slug);
    }

    public Page<Post> findByPublishedBeforeAndPublishedNotNull() {
        LocalDate today = LocalDate.now();
        return repository.findByPublishedBeforeAndPublishedNotNull(today, page20);
    }


}
