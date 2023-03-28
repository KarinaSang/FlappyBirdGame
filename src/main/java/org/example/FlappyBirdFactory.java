package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.Texture;
import javafx.util.Duration;

public class FlappyBirdFactory implements EntityFactory {
    @Spawns("bird")
    public Entity newBird(SpawnData data) {
        BirdComponent birdComponent = new BirdComponent();
        Texture animatedBird = FXGL.texture("bird.png").toAnimatedTexture(2, Duration.seconds(0.5)).loop();

        return FXGL.entityBuilder()
                .type(EntityType.BIRD)
                .view(animatedBird)
                .at(100, 100)
                .with(birdComponent)
                .build();
    }
}
