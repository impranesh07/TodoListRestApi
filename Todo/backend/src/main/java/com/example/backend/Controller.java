package com.example.backend;

import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin
@RestController
public class Controller {

    @Autowired Repo rep;
    @PostMapping("/send_data")
    public Student postMethodName(@RequestBody Student std) {
       Student st=rep.save(std);
       return st;
    }
    
    @GetMapping("/get_data")
   public ResponseEntity<?> get_data(){
    return ResponseEntity.ok(rep.findAll());
   }

   @GetMapping("search/{name}")
   public Optional<Student> GetMethodName(@PathVariable String name ) {
      return rep.findByName(name);
   }
   
   @CrossOrigin
   @PutMapping("/delete_data/{name}")
   public String putMethodName(@PathVariable String name) {
        rep.deleteByname(name);
        return "deleted";
   }
}
