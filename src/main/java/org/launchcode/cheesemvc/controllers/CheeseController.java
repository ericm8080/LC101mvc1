package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by ericmueller on 7/1/17. for my LC101 class4 prepwork
 * LaunchCode class LC101 spring/summer2017
 */
@Controller
@RequestMapping("cheese")  // when we added this path dont forget we then added a cheese dir to templates dir
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    // note:  Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("Title", "My Cheeses");
        return "cheese/index"; // this is the template name(not the file name with extension)
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("Title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        cheeses.add(cheeseName);
        // redirect to /cheese
        return "redirect:";
    }
}
