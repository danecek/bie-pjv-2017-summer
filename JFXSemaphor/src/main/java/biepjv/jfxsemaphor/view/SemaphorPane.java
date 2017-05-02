/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.jfxsemaphor.view;

import biepjv.jfxsemaphor.controller.SemaphorController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SemaphorPane extends VBox implements Observer {

    List<Light> lights;

    public SemaphorPane(Observable observable, int size, Color... cols) {
        observable.addObserver(this);
        lights = new ArrayList<>();
        setSpacing(10);
        setPadding(new Insets(10));
        for (Color col : cols) {
            lights.add(new Light(col, size));
        }
        getChildren().addAll(lights);
    }

    @Override
    public void update(Observable o, Object arg) {
        SemaphorController sc = (SemaphorController) o;
        Set<Color> onColors = sc.getCurrentState().getColors();
        for (Light l : lights) {
            l.setOn(onColors.contains(l.getColor()));
        }

    }

}
