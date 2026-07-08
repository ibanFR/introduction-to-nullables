package com.lexler.refactored;

import com.lexler.refactored.domain.Book;
import com.lexler.refactored.domain.Borrower;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _2_2_NullLoanTest {

    // Your toolbox:
    //   Loans.createNull(books...)            loans with these books out
    //   new Book("title", borrower, dueDate)

    private static final LocalDate TODAY = LocalDate.of(2026, 7, 1);
    private static final LocalDate DUE_NEXT_WEEK = TODAY.plusDays(7);
    private static final Borrower ANNA = new Borrower("Anna", "anna@example.com");

    @Test
    void noOverdueBooks() {
        // create a book that is DUE_NEXT_WEEK borrowed by ANNA
        Book book = new Book("Dune", ANNA, DUE_NEXT_WEEK);
        // create Loans with that book
        Loans loans = Loans.createNull(book);

        // ask for TODAY's overdue books
        List<Book> overdue = loans.overdue(TODAY);

        // there are none
        assertThat(overdue).isEmpty();
    }
}
