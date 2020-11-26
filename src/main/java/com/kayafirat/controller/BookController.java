package com.kayafirat.controller;

import com.kayafirat.entity.Book;
import com.kayafirat.service.IAuthorService;
import com.kayafirat.service.IBookService;
import com.kayafirat.service.IPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final IBookService IBookService;

    private final IAuthorService IAuthorService;

    private final IPublisherService publisherService;

    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("books", IBookService.getAllBook());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors", IAuthorService.getAllAuthor());
        model.addAttribute("b1", new Book());
        model.addAttribute("totalPages",0);
        return "book";
    }

    @PostMapping("/book")
    public String bookSave(@ModelAttribute Book b1, Model model) {
        model.addAttribute("b1", b1);
        IBookService.addBook(b1);
        return "redirect:/book";
    }
    @PostMapping("/book/update")
    public String bookUpdate(@Valid @ModelAttribute Book b1, Model model) {
        model.addAttribute("b1", b1);
        IBookService.updateBook(b1);
        return "redirect:/book";
    }
    @PostMapping("/book/delete/{id}")
    public String bookDelete(@PathVariable Long id){
        IBookService.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("book/search")
    public String searchResult(@RequestParam String orderBy,
                               @RequestParam String sortedBy,
                               @RequestParam String keyword,
                               @RequestParam int pageNumber,
                               @RequestParam int pageSize,Model model){
        Page<Book> bookPage = IBookService.searchBook(keyword,pageNumber,pageSize,sortedBy,orderBy);
        model.addAttribute("books",bookPage);
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors", IAuthorService.getAllAuthor());
        model.addAttribute("b1", new Book());
        model.addAttribute("totalPages",bookPage.getTotalPages());
        return "book";
    }





}
