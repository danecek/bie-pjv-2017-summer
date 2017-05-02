/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.jfxsemaphor.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.paint.Color;

public abstract class State {
    
    public Set<Color> getColors() {
        return colors;
    }
    
    abstract void exit(SemaphorController sc);
    
    private final Set<Color> colors;
    
    public State(Color... colors) {
        this.colors = new HashSet<>(Arrays.asList(colors));
    }    
    
}
