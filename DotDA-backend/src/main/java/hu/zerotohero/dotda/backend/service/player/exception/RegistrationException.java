package hu.zerotohero.dotda.backend.service.player.exception;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class RegistrationException extends Exception {

    public RegistrationException() {
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }

}
