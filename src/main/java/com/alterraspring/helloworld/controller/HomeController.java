package com.alterraspring.helloworld.controller;

import com.alterraspring.helloworld.entity.Home;
import com.alterraspring.helloworld.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    HomeRepository repo;

    @GetMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return "Hello World!";
        } else {
            return "Hello " + name + "!";
        }
    }

    @GetMapping("/v1/messages/{id}")
    public String index(@PathVariable("id") int id) {
        return "Hello " + id + "!";
    }

    @GetMapping("/v1/messages")
    public List<Home> getAll() {
        List<Home> members = repo.findAll();
        return members;
    }

    @PostMapping("/v1/messages")
    public Home save(@RequestBody CreateMemberRequest member) {
        System.out.println(member.getName());
        Home member1 = new Home();
        member1.setName(member.getName());
        repo.save(member1);
        return member1;
    }

    @DeleteMapping("/v1/messages/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            repo.deleteById(id);
            return String.format("{\"message\":\"success deleted\",\"status\":\"200\"}");
        } catch (Exception e) {
            return String.format("{\"message\":\"Member not Found\",\"status\":\"404\"}");
        }

    }
}
