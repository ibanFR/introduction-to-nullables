package com.lexler.refactored;

import com.lexler.refactored.domain.Book;
import com.lexler.refactored.domain.Borrower;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _2_3_NullLoanTest {

    // Your toolbox:
    //   assertThat(overdue).containsOnly(book)
    //   assertThat(overdue).containsExactlyInAnyOrder(books...)

    private static final LocalDate TODAY = LocalDate.of(2026, 7, 1);
    private static final LocalDate DUE_LAST_YEAR = TODAY.minusYears(1);
    private static final LocalDate DUE_NEXT_WEEK = TODAY.plusDays(7);

    private static final Borrower ANNA = new Borrower("Anna", "anna@example.com");
    private static final Borrower TOM = new Borrower("Tom", "tom@example.com");

    @Test
    void onlyTheOverdueBook() {
        // TOM borrowed a book DUE_LAST_YEAR
        Book tomsBook = new Book("Dune", TOM, DUE_LAST_YEAR);
        // ANNA borrowed a book DUE_NEXT_WEEK
        Book annasBook = new Book("Solaris", ANNA, DUE_NEXT_WEEK);
        // create Loans with both books
        Loans loans = Loans.createNull(tomsBook, annasBook);

        // ask for TODAY's overdue books
        List<Book> overdue = loans.overdue(TODAY);

        // check Tom's book is the one and only overdue book
        assertThat(overdue).containsOnly(tomsBook);
    }

    @Test
    void everyOverdueBook() {
        // TOM borrowed a book DUE_LAST_YEAR
        Book tomsBook = new Book("Dune", TOM, DUE_LAST_YEAR);
        // ANNA borrowed a book DUE_LAST_YEAR
        Book annasBook = new Book("Solaris", ANNA, DUE_LAST_YEAR);
        // create Loans with both books
        Loans loans = Loans.createNull(tomsBook, annasBook);

        // ask for TODAY's overdue books
        List<Book> overdue = loans.overdue(TODAY);

        // check both books are overdue
        assertThat(overdue).containsExactlyInAnyOrder(tomsBook, annasBook);
    }
}
