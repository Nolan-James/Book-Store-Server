package me.nolanjames.backend.repository;

import me.nolanjames.backend.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {
    List<Book> findBooksByTitle(String title);
}
