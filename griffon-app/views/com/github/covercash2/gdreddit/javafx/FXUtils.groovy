package com.github.covercash2.gdreddit.javafx

import javafx.animation.Animation
import javafx.event.ActionEvent
import javafx.event.EventHandler

/**
 * Created by covercash on 7/31/15.
 */
class FXUtils {

    static EventHandler<ActionEvent> getEventHandler(Closure action, Object... args) {
        return new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent event) {
                action.call(args)
            }
        }
    }

}
