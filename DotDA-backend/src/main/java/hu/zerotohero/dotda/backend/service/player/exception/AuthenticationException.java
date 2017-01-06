package hu.zerotohero.dotda.backend.service.player.exception;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class AuthenticationException extends Exception {

    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

}
