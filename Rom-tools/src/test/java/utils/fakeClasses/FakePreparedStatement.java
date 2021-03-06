package utils.fakeClasses;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

abstract class FakePreparedStatement implements PreparedStatement {

    @Override
    public void setNull(int i, int i1) {

    }

    @Override
    public void setBoolean(int i, boolean b) {

    }

    @Override
    public void setByte(int i, byte b) {

    }

    @Override
    public void setShort(int i, short i1) {

    }

    @Override
    public void setInt(int i, int i1) {

    }

    @Override
    public void setLong(int i, long l) {

    }

    @Override
    public void setFloat(int i, float v) {

    }

    @Override
    public void setDouble(int i, double v) {

    }

    @Override
    public void setBigDecimal(int i, BigDecimal bigDecimal) {

    }

    @Override
    public void setString(int i, String s) {

    }

    @Override
    public void setBytes(int i, byte[] bytes) {

    }

    @Override
    public void setDate(int i, Date date) {

    }

    @Override
    public void setTime(int i, Time time) {

    }

    @Override
    public void setTimestamp(int i, Timestamp timestamp) {

    }

    @Override
    public void setAsciiStream(int i, InputStream inputStream, int i1) {

    }

    @Override
    public void setUnicodeStream(int i, InputStream inputStream, int i1) {

    }

    @Override
    public void setBinaryStream(int i, InputStream inputStream, int i1) {

    }

    @Override
    public void clearParameters() {

    }

    @Override
    public void setObject(int i, Object o, int i1) {

    }

    @Override
    public void setObject(int i, Object o) {

    }

    @Override
    public void addBatch() {

    }

    @Override
    public void setCharacterStream(int i, Reader reader, int i1) {

    }

    @Override
    public void setRef(int i, Ref ref) {

    }

    @Override
    public void setBlob(int i, Blob blob) {

    }

    @Override
    public void setClob(int i, Clob clob) {

    }

    @Override
    public void setArray(int i, Array array) {

    }

    @Override
    public ResultSetMetaData getMetaData() {
        return null;
    }

    @Override
    public void setDate(int i, Date date, Calendar calendar) {

    }

    @Override
    public void setTime(int i, Time time, Calendar calendar) {

    }

    @Override
    public void setTimestamp(int i, Timestamp timestamp, Calendar calendar) {

    }

    @Override
    public void setNull(int i, int i1, String s) {

    }

    @Override
    public void setURL(int i, URL url) {

    }

    @Override
    public ParameterMetaData getParameterMetaData() {
        return null;
    }

    @Override
    public void setRowId(int i, RowId rowId) {

    }

    @Override
    public void setNString(int i, String s) {

    }

    @Override
    public void setNCharacterStream(int i, Reader reader, long l) {

    }

    @Override
    public void setNClob(int i, NClob nClob) {

    }

    @Override
    public void setClob(int i, Reader reader, long l) {

    }

    @Override
    public void setBlob(int i, InputStream inputStream, long l) {

    }

    @Override
    public void setNClob(int i, Reader reader, long l) {

    }

    @Override
    public void setSQLXML(int i, SQLXML sqlxml) {

    }

    @Override
    public void setObject(int i, Object o, int i1, int i2) {

    }

    @Override
    public void setAsciiStream(int i, InputStream inputStream, long l) {

    }

    @Override
    public void setBinaryStream(int i, InputStream inputStream, long l) {

    }

    @Override
    public void setCharacterStream(int i, Reader reader, long l) {

    }

    @Override
    public void setAsciiStream(int i, InputStream inputStream) {

    }

    @Override
    public void setBinaryStream(int i, InputStream inputStream) {

    }

    @Override
    public void setCharacterStream(int i, Reader reader) {

    }

    @Override
    public void setNCharacterStream(int i, Reader reader) {

    }

    @Override
    public void setClob(int i, Reader reader) {

    }

    @Override
    public void setBlob(int i, InputStream inputStream) {

    }

    @Override
    public void setNClob(int i, Reader reader) {

    }

    @Override
    public ResultSet executeQuery(String s) {
        return null;
    }

    @Override
    public int executeUpdate(String s) {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public int getMaxFieldSize() {
        return 0;
    }

    @Override
    public void setMaxFieldSize(int i) {

    }

    @Override
    public int getMaxRows() {
        return 0;
    }

    @Override
    public void setMaxRows(int i) {

    }

    @Override
    public void setEscapeProcessing(boolean b) {

    }

    @Override
    public int getQueryTimeout() {
        return 0;
    }

    @Override
    public void setQueryTimeout(int i) {

    }

    @Override
    public void cancel() {

    }

    @Override
    public SQLWarning getWarnings() {
        return null;
    }

    @Override
    public void clearWarnings() {

    }

    @Override
    public void setCursorName(String s) {

    }

    @Override
    public boolean execute(String s) {
        return false;
    }

    @Override
    public ResultSet getResultSet() {
        return null;
    }

    @Override
    public int getUpdateCount() {
        return 0;
    }

    @Override
    public boolean getMoreResults() {
        return false;
    }

    @Override
    public int getFetchDirection() {
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    public void setFetchDirection(int i) {

    }

    @Override
    public int getFetchSize() {
        return 0;
    }

    @Override
    public void setFetchSize(int i) {

    }

    @Override
    public int getResultSetConcurrency() {
        return ResultSet.CONCUR_UPDATABLE;
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public int getResultSetType() {
        return ResultSet.TYPE_SCROLL_INSENSITIVE;
    }

    @Override
    public void addBatch(String s) {

    }

    @Override
    public void clearBatch() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public boolean getMoreResults(int i) {
        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() {
        return null;
    }

    @Override
    public int executeUpdate(String s, int i) {
        return 0;
    }

    @Override
    public int executeUpdate(String s, int[] ints) {
        return 0;
    }

    @Override
    public int executeUpdate(String s, String[] strings) {
        return 0;
    }

    @Override
    public boolean execute(String s, int i) {
        return false;
    }

    @Override
    public boolean execute(String s, int[] ints) {
        return false;
    }

    @Override
    public boolean execute(String s, String[] strings) {
        return false;
    }

    @Override
    public int getResultSetHoldability() {
        return 0;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public boolean isPoolable() {
        return false;
    }

    @Override
    public void setPoolable(boolean b) {

    }

    @Override
    public void closeOnCompletion() {

    }

    @Override
    public boolean isCloseOnCompletion() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> aClass) {
        return false;
    }
}
