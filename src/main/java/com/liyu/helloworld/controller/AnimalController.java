package com.liyu.helloworld.controller;

import com.liyu.helloworld.common.AjaxResponse;
import com.liyu.helloworld.domain.Animal;
import com.liyu.helloworld.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Levi
 * @date 2019/9/18 9:36
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    //@RequestMapping(value = "/animals", method = POST, produces = "application/json")
    @PostMapping("/animals")   //简略版本测试
    public AjaxResponse saveAnimals(@RequestBody Animal animal) {
        String result = animalService.saveAnimal(animal);
        log.info("saveAnimals：{}",animal);
        return  AjaxResponse.success(animal);
    }

    @PostMapping("/animals2")
    public AjaxResponse saveAnimals2(@ModelAttribute Animal animal,
                                        @RequestParam (value = "id", required = true) Long id) {

        log.info("saveAnimals：{}",animal);
        return  AjaxResponse.success(animal);
    }


    @RequestMapping(value = "/animals/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteAnimals(@PathVariable Long id) {

        log.info("deleteAnimals：{}",id);
        return AjaxResponse.success(id);
    }


    @RequestMapping(value = "/animals/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateAnimals(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);

        log.info("updateAnimals：{}",animal);
        return AjaxResponse.success(animal);
    }

    @RequestMapping(value = "/animals/{id}", method = GET, produces = "application/json")
    public AjaxResponse getAnimals(@PathVariable Long id) {

        Animal animal = Animal.builder().id(1L).name("levi").build();
        return AjaxResponse.success(animal);
    }

}
