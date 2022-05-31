package me.nolanjames.backend.service;

import me.nolanjames.backend.dto.BookDto;
import me.nolanjames.backend.entity.Book;
import me.nolanjames.backend.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDto> getBooks() {
        Iterable<Book> allBooks = bookRepository.findAll();
        return StreamSupport.stream(allBooks.spliterator(), false)
                .map(convertBookToBookDto())
                .collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookToBookDto() {
        return book -> modelMapper.map(book, BookDto.class);
    }
}
