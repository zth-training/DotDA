package hu.zerotohero.dotda.frontend.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import hu.zerotohero.dotda.frontend.ui.player.login.LoginLayout;
import hu.zerotohero.dotda.model.context.AppCtx;
import lombok.Setter;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Theme("valo")
public class MainUI extends UI {

    private HorizontalSplitPanel mainLayoutContainer;
    private MenuLayout menuLayout;

    private MainControllerBean mainControllerBean;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        menuLayout = new MenuLayout();
        mainLayoutContainer = new HorizontalSplitPanel(menuLayout, new LoginLayout());
        initMainLayout();
        setContent(mainLayoutContainer);
    }

    private void initMainLayout() {
        mainControllerBean = AppCtx.bean(MainControllerBean.class);
        mainControllerBean.setMainLayoutContainer(mainLayoutContainer);
        mainControllerBean.setMenuLayout(menuLayout);
        mainLayoutContainer.setSplitPosition(15, Unit.PERCENTAGE);
    }

}
