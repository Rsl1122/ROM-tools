package com.djrapitops.rom.backend.database.sql;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import utils.fakeClasses.ThrowingFakePreparedStatement;
import utils.fakeClasses.ValuedFakePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryAllStatementTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private PreparedStatement valuedPreparedStatement;
    private PreparedStatement throwingPreparedStatement;

    @Before
    public void setUp() {
        valuedPreparedStatement = new ValuedFakePreparedStatement();
        throwingPreparedStatement = new ThrowingFakePreparedStatement();
    }

    @Test
    public void querySuccess() throws SQLException {
        QueryAllStatement<Boolean> statement = new QueryAllStatement<Boolean>("") {
            @Override
            public Boolean processResults(ResultSet set) {
                return true;
            }
        };
        assertTrue(statement.executeQuery(valuedPreparedStatement));
    }

    @Test
    public void queryThrowsException() throws SQLException {
        thrown.expect(SQLException.class);
        thrown.expectMessage(ThrowingFakePreparedStatement.QUERY);

        QueryAllStatement<Boolean> statement = new QueryAllStatement<Boolean>("") {
            @Override
            public Boolean processResults(ResultSet set) {
                return true;
            }
        };
        // Throws expected exception
        assertTrue(statement.executeQuery(throwingPreparedStatement));
    }

    @Test
    public void getSqlReturnsValue() {
        String expected = "Test Success";

        QueryAllStatement<Boolean> statement = new QueryAllStatement<Boolean>(expected) {
            @Override
            public Boolean processResults(ResultSet set) {
                return true;
            }
        };
        assertEquals(expected, statement.getSql());
    }
}