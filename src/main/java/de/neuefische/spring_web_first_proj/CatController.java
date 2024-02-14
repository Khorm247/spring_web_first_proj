package de.neuefische.spring_web_first_proj;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private List<Cat> cats = new ArrayList<>();

    public CatController(){
        cats.add(new Cat("Minka","British Shorthair", "black"));
        cats.add(new Cat("Ferdi","Bengal", "brown"));
        cats.add(new Cat("Garfield","Mixture", "orange"));
    }

    @GetMapping
    public List<Cat> getAllCats(){
        return cats;
    }

    @GetMapping("/search")
    public Cat getCatByName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String breed){
        for (Cat cat : cats) {
            if (cat.name().equals(name)) {
                return cat;
            }
            if (cat.breed().equals(breed)) {
                return cat;
            }
        }
        return null;
    }

    @PostMapping
    public List<Cat> addCat(@RequestBody Cat cat){
        cats.add(cat);
        return cats;
    }
}
