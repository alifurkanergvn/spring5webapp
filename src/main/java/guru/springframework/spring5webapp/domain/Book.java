package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jt on 12/22/19.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book"/* Olusturulan tablo adı */, joinColumns = @JoinColumn(name = "book_id")/* Bu clasın ıd si book_id seklinde colon olusturuldu */,
            inverseJoinColumns = @JoinColumn(name = "author_id")/*Eslestirilen classtaki id, author_book tablosunda author_id isminde kolon olusturuldu */)
    private Set<Author> authors; //Author da mappedBy authors diyerek yukarıdaki author_id'yi gerceklestirmis olduk

    public Book() {
    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
