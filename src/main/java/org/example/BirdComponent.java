package org.example;

import com.almasb.fxgl.entity.component.Component;

public class BirdComponent extends Component {

    private double accelerationX = 4;
    private double accelerationY = 0;

    @Override
    public void onUpdate(double tpf) {
        accelerationX += tpf * 0.05;
        accelerationY += tpf * 10;

        if (accelerationY < -5) {
            accelerationY = -5;
        }

        if (accelerationY > 5) {
            accelerationY = 5;
        }

        entity.translate(accelerationX, accelerationY);
    }

    public void jump() {
        accelerationY -= 5;
    }
}
