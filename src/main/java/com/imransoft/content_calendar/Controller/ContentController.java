package com.imransoft.content_calendar.Controller;

import com.imransoft.content_calendar.model.Content;
import com.imransoft.content_calendar.repository.ContentCollectionRepository;
import com.imransoft.content_calendar.repository.ContentJdbcTemplateRepository;
import com.imransoft.content_calendar.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    //private final ContentCollectionRepository contentCollectionRepository;
//    private final ContentJdbcTemplateRepository repository;
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

//    public ContentController(ContentJdbcTemplateRepository repository) {
//        this.repository = repository;
//    }


//    public ContentController(ContentCollectionRepository contentCollectionRepository) {
//        this.contentCollectionRepository = contentCollectionRepository;
//    }

    @GetMapping()
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

//    @GetMapping("")
//    public List<Content> findAll(){
//        return contentCollectionRepository.findAll();
//    }

//    @GetMapping("/{id}")
//    public Content findById(@PathVariable Integer id){
//        return contentCollectionRepository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "no content"));
//
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    public void create(@RequestBody Content c){
//        contentCollectionRepository.save(c);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    public void update(@RequestBody Content c, @PathVariable Integer id){
//        if(!contentCollectionRepository.existsById(id))
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "content not found");
//
//        contentCollectionRepository.save(c);
//    }
}
