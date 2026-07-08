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
        // create a mocked Connection
        Connection connection = mock(Connection.class);
        // create a mocked PreparedStatement
        PreparedStatement statement = mock(PreparedStatement.class);
        // create a mocked ResultSet
        ResultSet resultSet = mock(ResultSet.class);

        // make dataSource.getConnection() return the connection: when(..).thenReturn(..)
        when(dataSource.getConnection()).thenReturn(connection);
        // make connection.prepareStatement() return the statement when called with anyString()
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        // make statement.executeQuery() return the resultSet
        when(statement.executeQuery()).thenReturn(resultSet);
        // the database is empty: make resultSet.next() return false
        when(resultSet.next()).thenReturn(false);

        Loans loans = new Loans(dataSource);

        // act:
        List<Book> overdueBooks = loans.overdue(TODAY);

        // assert:
        assertThat(overdueBooks).isEmpty();
    }
}
