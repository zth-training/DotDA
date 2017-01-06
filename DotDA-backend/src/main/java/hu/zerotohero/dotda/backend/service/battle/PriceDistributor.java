package hu.zerotohero.dotda.backend.service.battle;

import org.springframework.transaction.annotation.Transactional;
import hu.zerotohero.dotda.model.character.*;
import hu.zerotohero.dotda.model.character.Character;

import java.util.ArrayList;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class PriceDistributor implements CharacterVisitor {

    private Character looser;
    private CharacterDao characterDao;

    public PriceDistributor(Character looser, CharacterDao characterDao) {
        this.looser = looser;
        this.characterDao = characterDao;
    }

    @Override
    @Transactional
    public void visit(PlayerCharacter winner) {
        winner.getInventory().addAll(looser.getInventory());
        looser.setInventory(new ArrayList<>());
        int currencyPrice;
        double currencyPriceMultiplier;

        if (winner.getSetting().equals(Setting.HARD)) {
            currencyPriceMultiplier = 0.4;
        } else {
            currencyPriceMultiplier = 0.8;
        }

        distributeCurrency(winner, currencyPriceMultiplier);
    }

    @Override
    @Transactional
    public void visit(NonPlayerCharacter winner) {
        distributeCurrency(winner, 0.1);
    }

    private int getWinedCurrency(Character looser, double currencyPriceMultiplier) {
        return (int) Math.round(looser.getCurrency() * currencyPriceMultiplier);
    }

    private void distributeCurrency(Character winner, double currencyPriceMultiplier) {
        int currencyPrice;
        currencyPrice = getWinedCurrency(looser, currencyPriceMultiplier);
        characterDao.changeCharacterCurrency(winner, currencyPrice);
        characterDao.changeCharacterCurrency(looser, -1 * currencyPrice);
    }

}
