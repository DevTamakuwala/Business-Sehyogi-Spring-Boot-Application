package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.LinksRepository;
import com.businesssehyogi.BusinessSehyogi.model.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class LinksController {

    @Autowired
    private LinksRepository linkRepository;

    @GetMapping("/getLinks")
    public List<Links> getAllLinks() {
        return linkRepository.findAll();
    }

    @GetMapping("getLinkById/{id}")
    public ResponseEntity<Links> getLinkById(@PathVariable Long id) {
        Optional<Links> link = linkRepository.findById(id);
        return link.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addLink")
    public Links createLink(@RequestBody Links link) {
        return linkRepository.save(link);
    }

    @PutMapping("/updateLink/{id}")
    public ResponseEntity<Links> updateLink(@PathVariable Long id, @RequestBody Links linkDetails) {
        Optional<Links> linkOptional = linkRepository.findById(id);
        if (linkOptional.isPresent()) {
            Links link = linkOptional.get();
            link.setLink(linkDetails.getLink());
            return ResponseEntity.ok(linkRepository.save(link));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteLink/{id}")
    public ResponseEntity<Void> deleteLink(@PathVariable Long id) {
        Optional<Links> link = linkRepository.findById(id);
        if (link.isPresent()) {
            linkRepository.delete(link.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
