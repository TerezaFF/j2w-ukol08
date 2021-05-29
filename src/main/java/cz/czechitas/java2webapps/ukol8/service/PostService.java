package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.time.LocalDate;

@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    //Vraci seznam vsech postu
    public Page<Post> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Post> findByslug(String slug) {
       return repository.findByslug(slug, PostRepository.page20);
    }

    public Page<Post> findByPublishedBeforeAndPublishedNotNull() {
        LocalDate today = LocalDate.now();
        return repository.findByPublishedBeforeAndPublishedNotNull(today, PostRepository.page20);
    }


}
