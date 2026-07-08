package com.lexler.refactored;

import com.lexler.refactored.domain.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _2_1_NullLoanTest {

    // Your toolbox:
    //   Loans.createNull()                    loans with no books out
    //   List<Book> overdue(forDate)
    //   assertThat(...).isEmpty()

    private static final LocalDate TODAY = LocalDate.of(2026, 7, 1);

    @Test
    void noLoans() {
        // create Loans with no borrowed books
        Loans loans = Loans.createNull();

        // ask for TODAY's overdue books
        List<Book> overdue = loans.overdue(TODAY);

        // there are none
        assertThat(overdue).isEmpty();
    }
}
