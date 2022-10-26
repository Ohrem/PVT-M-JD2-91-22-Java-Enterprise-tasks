package ohremchuk.jdbc.task7.exception;

public class DaoException extends RuntimeException {
    public DaoException(Throwable throwable) {
        super(throwable);
    }
}
