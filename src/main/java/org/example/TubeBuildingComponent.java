package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.shape.Rectangle;


public class TubeBuildingComponent extends Component {
    private double lastX = 1000;

    @Override
    public void onUpdate(double tpf) {
        if (lastX - entity.getX() < FXGL.getAppWidth()) {
            buildTubes();
        }
    }

    private Rectangle newTube(double width, double height) {
        Rectangle tube = new Rectangle(width, height);
        tube.setArcWidth(25);
        tube.setArcHeight(25);
        return tube;
    }

    private void buildTubes() {
        double height = FXGL.getAppHeight();
        double distance = height/2;

        for (int i = 1; i <= 10; i++) {
            // creating one pair of tubes
            double topHeight = Math.random() * distance;
            double curX = lastX + i*500;

            // top tube
            FXGL.entityBuilder()
                    .at(curX, 0)
                    .type(EntityType.TUBE)
                    .viewWithBBox(newTube(50, topHeight))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();

            // bottom tube
            FXGL.entityBuilder()
                    .at(curX, distance+topHeight)
                    .type(EntityType.TUBE)
                    .viewWithBBox(newTube(50, distance-topHeight))
                    .with(new CollidableComponent(true))
                    .buildAndAttach();
        }

        lastX += 10*500;
    }
}
