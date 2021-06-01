package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findBySlug(String slug);

    Page<Post> findByPublishedBeforeAndPublishedNotNull (LocalDate today, Pageable page20);

}
