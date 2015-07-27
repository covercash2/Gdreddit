package com.github.covercash2.gdreddit

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.control.Label

/**
 * Created by covercash on 7/26/15.
 */
class Data {
    FactoryBuilderSupport builder

    @FXML
    Label label1
    @FXML
    Label label2
    @FXML
    Node box
    String string = ''

    Data() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource('/com/github/covercash2/gdreddit/feedCell.fxml'))
        loader.controller = this
        try {
            loader.load()
        } catch (IOException e) {
            throw new RuntimeException(e) //TODO handle
        }
    }

    void setInfo(String string) {
        label1.setText(string)
        label2.setText(string)
    }
}
