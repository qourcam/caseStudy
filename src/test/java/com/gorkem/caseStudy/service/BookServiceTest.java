package com.gorkem.caseStudy.service;

import com.gorkem.caseStudy.factory.TestDAOFactory;
import com.gorkem.caseStudy.factory.TestEntityFactory;
import com.gorkem.caseStudy.repository.BookRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void saveBookTestSuccessful(){
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(TestEntityFactory.book());
        bookService.saveBook(TestDAOFactory.bookDAO());
    }
}
