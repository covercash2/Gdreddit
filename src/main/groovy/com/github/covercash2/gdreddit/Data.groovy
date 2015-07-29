package com.github.covercash2.gdreddit

import griffon.transform.FXObservable
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.HBox

/**
 * Created by covercash on 7/26/15.
 */
class Data {
    @FXObservable String title
    @FXObservable String author
    @FXObservable String score

    Label lTitle
    Label lAuthor
    Label lScore

    Node box

    Data() {
        lTitle = new Label()
        lAuthor = new Label()
        lScore = new Label()

        box = new HBox(spacing: 10)
        box.children.addAll([
                lScore,
                lTitle,
                lAuthor
        ])
    }
}
