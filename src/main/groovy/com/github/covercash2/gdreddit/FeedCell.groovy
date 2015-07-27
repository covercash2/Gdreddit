package com.github.covercash2.gdreddit

import javafx.scene.control.ListCell

/**
 * Created by covercash on 7/26/15.
 */
class FeedCell extends ListCell<String> {
    @Override
    void updateItem(String string, boolean empty) {
        super.updateItem(string, empty)
        if (string) {
            Data data = new Data()
            data.setInfo string
            setGraphic(data.getBox())
        }
    }
}
