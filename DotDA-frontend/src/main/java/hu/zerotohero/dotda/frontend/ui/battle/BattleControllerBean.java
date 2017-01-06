package hu.zerotohero.dotda.frontend.ui.battle;

import hu.zerotohero.dotda.backend.service.battle.BattleService;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.character.NonPlayerCharacter;
import hu.zerotohero.dotda.model.context.AppCtx;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class BattleControllerBean {

    @Getter
    private BattleService battleService;

    public void newBattleStart(BattleService battleService) {
        this.battleService = battleService;
    }

    public NonPlayerCharacter getEnemy() {
        return new BattleService(AppCtx.bean(BaseDao.class)).getEnemy();
    }
}
