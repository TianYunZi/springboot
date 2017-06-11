package com.boot.controller;

import com.boot.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJX on 2017/6/10.
 */
@Controller
public class Ch724Controller {

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx", 22);
        Person p2 = new Person("yy", 33);
        Person p3 = new Person("zz", 44);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
