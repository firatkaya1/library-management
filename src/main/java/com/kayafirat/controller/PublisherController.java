package com.kayafirat.controller;

import com.kayafirat.entity.Publisher;
import com.kayafirat.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping("/publisher")
    public String book(Model model) {
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("p1", new Publisher());
        return "publisher";
    }

    @PostMapping("/publisher")
    public String authorSave(@ModelAttribute Publisher p1, Model model) {
        model.addAttribute("p1", p1);
        publisherService.addPublisher(p1);
        return "redirect:/publisher";
    }

    @PostMapping("/publisher/update")
    public String authorUpdate(@Valid @ModelAttribute Publisher p1, Model model) {
        model.addAttribute("p1", p1);
        publisherService.updatePublisher(p1);
        return "redirect:/publisher";
    }
    @PostMapping("/publisher/delete/{id}")
    public String authorDelete(@PathVariable Long id){
        publisherService.deletePublisher(id);
        return "redirect:/publisher";
    }
}
