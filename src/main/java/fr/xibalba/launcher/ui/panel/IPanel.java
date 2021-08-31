package fr.xibalba.launcher.ui.panel;

import fr.xibalba.launcher.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {

    void init(PanelManager manager);
    GridPane getLayout();
    void onShow();
    void onHide();
    String getName();
}