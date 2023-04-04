package org.example;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.input.virtual.VirtualButton;
import javafx.animation.Interpolator;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class FlappyBirdGame extends GameApplication {

    private BirdComponent birdComponent;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Flappy Bird Mock");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("score", 0);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("jump") {
            @Override
            protected void onActionBegin() {
                birdComponent.jump();
            }
        }, KeyCode.SPACE, VirtualButton.UP);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new FlappyBirdFactory());

        Entity bird = FXGL.spawn("bird");
        birdComponent = bird.getComponent(BirdComponent.class);

        FXGL.getGameScene().getViewport().setBounds(0, 0, Integer.MAX_VALUE, FXGL.getAppHeight());
        FXGL.getGameScene().getViewport().bindToEntity(bird, FXGL.getAppWidth()/3, FXGL.getAppHeight()/2);

        FXGL.spawnWithScale(bird, Duration.seconds(1), Interpolators.BOUNCE.EASE_OUT());
    }

    @Override
    protected void initUI() { // user interface
        Text scoreText = new Text("0");
        scoreText.setFont(Font.font(60));
        scoreText.textProperty().bind(FXGL.getip("score").asString());
        FXGL.addUINode(scoreText, FXGL.getAppWidth()-200, 50);

        Group virtualButton = FXGL.getInput().createVirtualDpadView();
        FXGL.addUINode(virtualButton, 0, 630);
    }

    @Override
    protected void onUpdate(double tpf) {
        FXGL.inc("score", 1);
    }

    public static void main(String[] args) {
        launch(args);
    }


}