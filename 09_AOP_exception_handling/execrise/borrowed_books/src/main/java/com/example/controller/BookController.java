package com.example.controller;

import com.example.excetionhandle.BookIsOverException;
import com.example.excetionhandle.FullBookException;
import com.example.model.BookLibrary;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String getShowBorrow(@PathVariable int id, Model model) throws BookIsOverException {
        BookLibrary bookLibrary = bookService.findById(id);
        if (bookLibrary.getAmount() == 0) {
            throw new BookIsOverException();
        } else {
            model.addAttribute("bookBorrow", bookLibrary);
            return "borrow";
        }
    }

    @PostMapping("/save")
    public String borrowBook(@ModelAttribute("bookBorrow") BookLibrary bookLibrary, RedirectAttributes redirectAttributes) {
        bookLibrary.setAmount(bookLibrary.getAmount() - 1);
        bookService.save(bookLibrary);
        redirectAttributes.addFlashAttribute("mess" + bookLibrary.getBook() + "Mượn Sách Thành Công");
        return "redirect:/";
    }

    @GetMapping("/pay/{id}")
    public String getReturnBorrow(@PathVariable int id, Model model) throws FullBookException {
        BookLibrary bookLibrary = bookService.findById(id);
        if (bookLibrary.getAmount() == bookLibrary.getStartAmount()) {
            throw new FullBookException();
        } else {
            model.addAttribute("bookBorrow", bookLibrary);
            return "pay";
        }
    }

    @PostMapping("/return")
    public String returnBook(@ModelAttribute("bookBorrow") BookLibrary bookLibrary, RedirectAttributes redirectAttributes) {
        bookLibrary.setAmount(bookLibrary.getAmount() + 1);
        bookService.save(bookLibrary);
        redirectAttributes.addFlashAttribute("mess" + bookLibrary.getBook() + "Trả Sách Thành Công");
        return "redirect:/";
    }

    @ExceptionHandler(BookIsOverException.class)
    public String showErrorBookOver() {
        return "errors";
    }

    @ExceptionHandler(FullBookException.class)
    public String showErrorFullBook() {
        return "errorsbook";
    }

}
