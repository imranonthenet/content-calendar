package com.imransoft.content_calendar.repository;

import com.imransoft.content_calendar.model.Content;
import com.imransoft.content_calendar.model.Status;
import com.imransoft.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content c){
        content.removeIf(x -> x.id().equals(c.id()));
        content.add(c);
    }

    public boolean existsById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
                1,
                "My first blog post",
                "my first blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        content.add(c);
    }
}
