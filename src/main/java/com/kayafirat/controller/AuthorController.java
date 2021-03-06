package com.kayafirat.controller;

import com.kayafirat.entity.Author;
import com.kayafirat.service.IAuthorService;
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
public class AuthorController {

    private final IAuthorService IAuthorService;

    @GetMapping("/author")
    public String book(Model model) {
        model.addAttribute("authors", IAuthorService.getAllAuthor());
        model.addAttribute("a1", new Author());
        return "author";
    }

    @PostMapping("/author")
    public String authorSave(@ModelAttribute Author a1, Model model) {
        model.addAttribute("a1", a1);
        IAuthorService.addAuthor(a1);
        return "redirect:/author";
    }

    @PostMapping("/author/update")
    public String authorUpdate(@Valid @ModelAttribute Author a1, Model model) {
        model.addAttribute("a1", a1);
        IAuthorService.updateAuthor(a1);
        return "redirect:/author";
    }
    @PostMapping("/author/delete/{id}")
    public String authorDelete(@PathVariable Long id){
        IAuthorService.deleteAuthor(id);
        return "redirect:/author";
    }



}
