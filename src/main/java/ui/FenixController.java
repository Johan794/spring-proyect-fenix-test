package ui;

import model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import service.PostManagementService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
@ComponentScan("service")
public class FenixController {

    @Autowired
    private PostManagementService service;


   private List<Jugador> jugadorList = new ArrayList<>();



   @GetMapping(value = "/greet/{name}")
   public String greet(@PathVariable(value = "name") String name){
      return "Hola "+name;
   }

   @GetMapping(value = "/list")
   public ResponseEntity list(){
      return new ResponseEntity(service.list(), HttpStatus.OK);
   }



   @PostMapping(value = "/add")
   public ResponseEntity add(@RequestBody Jugador jugador){
      return new ResponseEntity(service.add(jugador), HttpStatus.OK);
   }

   @PutMapping(value = "/{name}/update")
   public ResponseEntity edit(@PathVariable(value = "name")String name , @RequestBody Jugador jugador){
      return new ResponseEntity(null, HttpStatus.OK);
   }

   @DeleteMapping(value = "/{name}/delete")
   public ResponseEntity delete(@PathVariable(value = "name") String name){
      return new ResponseEntity(null, HttpStatus.OK);
   }








}
