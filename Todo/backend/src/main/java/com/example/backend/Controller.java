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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class Controller {

    @Autowired Repo rep;
    @PostMapping("/send_data")
    public String postMethodName(@RequestBody Student std) {
        rep.save(std);
        return "data send";
    }
    
    @GetMapping("/get_data")
   public ResponseEntity<?> get_data(){
    return ResponseEntity.ok(rep.findAll());
   }

   @GetMapping("search/{name}")
   public Optional<Student> GetMethodName(@PathVariable String name ) {
      return rep.findByName(name);
   }
   @DeleteMapping("/delete_data")
    public ResponseEntity<?> deleted(@RequestBody Student std ){
     rep.deleteByname(std.getName());
     return ResponseEntity.ok("Done");
   }
}
