package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//You will need to use the
// findAll(), findOne(id), save(Person) and delete(id) methods of PersonRepository to fetch and save Person objects.

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;


    @PostMapping("/people/")
    ResponseEntity<Person> createPerson(@RequestBody Person p){
        personRepository.save(p);
        return new ResponseEntity(personRepository.save(p),HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    ResponseEntity<Person> getPerson(@PathVariable int id){
      return new ResponseEntity<>(personRepository.findOne(id),HttpStatus.OK);
    }

    List<Person> getPersonList(){
        return (List<Person>) personRepository.findAll();
    }
    @PutMapping("/people/{id}")
    ResponseEntity<Person> updatePerson(@PathVariable int id,@RequestBody Person p){
        Person person = personRepository.findOne(id);
//        personRepository.delete(id);
        p.setId(person.getId());
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        //return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/people/{id}")
    @ResponseStatus(value =  HttpStatus.NO_CONTENT)
    public void DeletePerson(@PathVariable int id){
        personRepository.delete(id);
//        return new ResponseEntity<Boolean>(personRepository.delete(id), HttpStatus.NO_CONTENT);

    }
}
