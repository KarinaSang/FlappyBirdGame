package org.example;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.animation.Interpolator;
import javafx.util.Duration;

public class FlappyBirdGame extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Flappy Bird Mock");
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new FlappyBirdFactory());

        Entity bird = FXGL.spawn("bird");


        FXGL.spawnWithScale(bird, Duration.seconds(1), Interpolators.BOUNCE.EASE_OUT());
    }

    public static void main(String[] args) {
        launch(args);
    }


}