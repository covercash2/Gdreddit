package com.github.covercash2.gdreddit

import griffon.transform.FXObservable
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import javafx.scene.image.ImageView
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.web.WebView

/**
 * Created by covercash on 7/26/15.
 */
class Data {
    ImageView ivThumb = new ImageView()

    Label lTitle = new Label()
    Label lAuthor = new Label()
    Label lScore = new Label()
    Label lComments = new Label()
    Label lSelfText = new Label()
    Label lSubreddit = new Label()

    TitledPane tpContent = new TitledPane()

    Pane pContent = new Pane()

    Node box

    Data() {
        ivThumb.with {
            fitHeight = 48
            fitWidth = 48
            preserveRatio = true
        }

        tpContent.with {
            text = 'test'
            content = pContent
            expanded = false
        }

        HBox detailBox = new HBox()
        detailBox.with {
            spacing = 10
        }

        detailBox.children.addAll([
                lSubreddit,
                lComments,
                lAuthor,
        ])

        VBox titleBox = new VBox(spacing: 10)
        titleBox.children.addAll([
                lTitle,
                detailBox,
                tpContent
        ])

        HBox mainBox = new HBox(spacing: 10)

        mainBox.maxWidth(200.0)

        mainBox.children.addAll([
                lScore,
                ivThumb,
                titleBox
        ])

        box = mainBox
    }

    void addContent(String content) {
        pContent.children.add(new Label(content))
    }

    void addHtml(Pane root, String url, boolean javascript) {
        WebView web = new WebView()
        web.getEngine().load(url)
        web.engine.setJavaScriptEnabled(javascript)
        root.children.add(web)
    }

    void addHtmlContent(Pane root, String content, boolean javascript) {
        WebView web = new WebView()
        web.getEngine().loadContent(content)
        web.engine.setJavaScriptEnabled(javascript)
        root.children.add(web)
    }
}
