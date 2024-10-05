package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.ImagesRepository;
import com.businesssehyogi.BusinessSehyogi.model.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class ImagesController {

    @Autowired
    private ImagesRepository imageRepository;

    @GetMapping("/getImages")
    public List<Images> getAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/getImageById/{id}")
    public ResponseEntity<Images> getImageById(@PathVariable Long id) {
        Optional<Images> image = imageRepository.findById(id);
        return image.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addImage")
    public Images createImage(@RequestBody Images image) {
        return imageRepository.save(image);
    }

    @PutMapping("/updateImage/{id}")
    public ResponseEntity<Images> updateImage(@PathVariable Long id, @RequestBody Images imageDetails) {
        Optional<Images> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Images image = imageOptional.get();
            image.setImageName(imageDetails.getImageName());
            return ResponseEntity.ok(imageRepository.save(image));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteImage/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        Optional<Images> image = imageRepository.findById(id);
        if (image.isPresent()) {
            imageRepository.delete(image.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
