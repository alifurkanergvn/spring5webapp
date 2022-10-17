package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){  //Spring MVC yapıya sahip controllerimiz var model şeklinde çağırarak
        // Modelimizi getiriyoruz. Burası view e göndereceğimizdir. View de modeli kopyalayacaktır.

        model.addAttribute("books", bookRepository.findAll()); //attribute ismini,attribute değerini yazdık.
        // Burası bize databaseden Book listesi verip books attribute na ekledi
        // Bu aşamaya kadar Spring MCV Controller ın temel seviyesini gördük

        return "books/list";  // books dizininin içinde list isimli template'e bak
    }
}
