package org.example;

import com.almasb.fxgl.entity.component.Component;

public class BirdComponent extends Component {
    @Override
    public void onUpdate(double tpf) {
        entity.translate(4, -0.02);
    }

    public void jump() {
        // make the bird move up
    }
}
