//package com.businesssehyogi.BusinessSehyogi.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.businesssehyogi.BusinessSehyogi.Repository.AlienRepo;
//import com.businesssehyogi.BusinessSehyogi.model.Alien;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class AlienController {
//    @Autowired
//    AlienRepo repo;
//
//    @GetMapping("/aliens")
//    public List<Alien> getAliens()
//    {
//
//        return repo.findAll();
//    }
//
////    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/alien/{aid}")
//    public Alien getAlien(@PathVariable("aid") int aid)
//    {
//        return repo.findById(aid).orElse(new Alien(0,""));
//    }
//
//    @GetMapping("/alienByName/{aname}")
//    public List<Alien> getAlienByName(@PathVariable("aname") String aname)
//    {
//        return repo.findByAname(aname);
//    }
//
//    @PostMapping(value="/alien", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Alien addAliens(@RequestBody Alien alien)
//    {
//        repo.save(alien);
//        return alien;
//    }
//
//    @PostMapping(value="/alien/{aid}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Alien> updateAlien(@PathVariable("aid") int aid, @RequestBody Alien NewAlienData)
//    {
//        Alien findAlien = repo.findById(aid).orElse(new Alien(0,""));
//        findAlien.setAname(NewAlienData.getAname());
//        findAlien.setAge(NewAlienData.getAge());
//        findAlien.setMobile(NewAlienData.getMobile());
//        Alien updateAlien = repo.save(findAlien);
//        return ResponseEntity.ok(updateAlien);
//    }
//
//    @PostMapping("/alien/{aid}")
//    public List<Alien> deleteAlien(@PathVariable("aid") int aid)
//    {
//        repo.deleteById(aid);
//        return repo.findAll();
//    }
//}
