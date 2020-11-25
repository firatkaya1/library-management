package com.kayafirat.bookstore.controller;

import com.kayafirat.bookstore.entity.Book;
import com.kayafirat.bookstore.service.AuthorService;
import com.kayafirat.bookstore.service.BookService;
import com.kayafirat.bookstore.service.PublisherService;
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

    private final BookService bookService;

    private final AuthorService authorService;

    private final PublisherService publisherService;

    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("books",bookService.getAllBook());
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors",authorService.getAllAuthor());
        model.addAttribute("b1", new Book());
        model.addAttribute("totalPages",0);
        return "book";
    }

    @PostMapping("/book")
    public String bookSave(@ModelAttribute Book b1, Model model) {
        model.addAttribute("b1", b1);
        bookService.addBook(b1);
        return "redirect:/book";
    }
    @PostMapping("/book/update")
    public String bookUpdate(@Valid @ModelAttribute Book b1, Model model) {
        model.addAttribute("b1", b1);
        bookService.updateBook(b1);
        return "redirect:/book";
    }
    @PostMapping("/book/delete/{id}")
    public String bookDelete(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("book/search")
    public String searchResult(@RequestParam String orderBy,
                               @RequestParam String sortedBy,
                               @RequestParam String keyword,
                               @RequestParam int pageNumber,
                               @RequestParam int pageSize,Model model){
        Page<Book> bookPage = bookService.searchBook(keyword,pageNumber,pageSize,sortedBy,orderBy);
        model.addAttribute("books",bookPage);
        model.addAttribute("publishers",publisherService.getAllPublisher());
        model.addAttribute("authors",authorService.getAllAuthor());
        model.addAttribute("b1", new Book());
        model.addAttribute("totalPages",bookPage.getTotalPages());
        return "book";
    }





}
