package hu.zerotohero.dotda.backend.service.crypto;

import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class HashCryptoService extends CryptoService {

    @Override
    public String encrypt(String plainTextPassword) {
        return null;
    }

    @Override
    public boolean isValidPassword(String password, String passwordHash) {
        return false;
    }

}
