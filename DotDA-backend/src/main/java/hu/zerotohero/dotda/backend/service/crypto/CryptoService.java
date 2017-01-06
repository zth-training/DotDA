package hu.zerotohero.dotda.backend.service.crypto;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public abstract class CryptoService {

    protected static final String SALT = "ZTHDotDASalt$";

    public abstract String encrypt(String plainTextPassword);

    public abstract boolean isValidPassword(String password, String passwordHash);

}
