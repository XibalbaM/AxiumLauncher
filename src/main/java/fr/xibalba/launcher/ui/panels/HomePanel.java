package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.games.GamesRegistry;
import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.ui.PanelManager;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.launcher.ui.panels.includes.GamePanel;
import fr.xibalba.launcher.ui.panels.includes.LeftPanel;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class HomePanel extends Panel {

    private final LeftPanel leftPanel = new LeftPanel();
    private final GridPane centerPanel = new GridPane();
    private final PanelManager panelManager = AxiumLauncher.getPanelManager();

    @Override
    public void init() {
        super.init();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.LEFT);
        columnConstraints.setMinWidth(300);
        columnConstraints.setMaxWidth(300);

        this.layout.getColumnConstraints().addAll(columnConstraints, new ColumnConstraints());
        this.layout.add(leftPanel.getLayout(),0,  0);
        this.leftPanel.init();

        this.layout.add(centerPanel,1,  0);
        GridPane.setHgrow(centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(centerPanel, Priority.ALWAYS);

        this.showGamePanel(new GamePanel(GamesRegistry.getInstance().worldLegends));
    }

    public void showGamePanel(GamePanel instance) {
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(instance.getLayout());

        GridPane.setHgrow(instance.getLayout(), Priority.ALWAYS);
        GridPane.setVgrow(instance.getLayout(), Priority.ALWAYS);
        instance.init();
    }

    public LeftPanel getLeftPanel() {

        return leftPanel;
    }

    public GridPane getCenterPanel() {

        return centerPanel;
    }
}