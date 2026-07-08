package com.lexler.legacy;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class _1_MockedLoanTest {

    private static final LocalDate TODAY = LocalDate.of(2026, 7, 1);

    @Test
    void noLoans() throws Exception {
        // arrange:
        // DataSource → Connection → PreparedStatement → empty ResultSet
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement statement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(false); // empty database

        Loans loans = new Loans(dataSource);

        // act:
        List<Book> overdueBooks = loans.overdue(TODAY);

        // assert:
        assertThat(overdueBooks).isEmpty();
    }
}
