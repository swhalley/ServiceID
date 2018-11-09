package ca.sean;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import ca.sean.DataRepository;

@RestController
public class DataController {

    @Autowired 
    private DataRepository repository;

    @GetMapping("/nextID")
    public int getNextID(){

        return repository.getNextID();
    }
}