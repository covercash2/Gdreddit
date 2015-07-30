package com.github.covercash2.gdreddit

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Hyperlink
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

    Hyperlink hlTitle = new Hyperlink()
    Hyperlink hlComments = new Hyperlink()

    Label lAuthor = new Label()
    Label lScore = new Label()
    Label lSubreddit = new Label()

    TitledPane tpContent = new TitledPane()

    Pane pContent = new Pane()

    Node box

    Data() {
        hlTitle.wrapTextProperty().set(true)

        // score pane
        VBox scoreBox = new VBox()
        scoreBox.with {
            children.addAll([
                    new Label('^'),
                    lScore,
                    new Label('v')
            ])
            alignment = Pos.CENTER
            setMinWidth(50)
        }

        ivThumb.with {
            fitHeight = 48
            fitWidth = 48
            preserveRatio = true
        }

        tpContent.with {
            text = 'test'
            content = pContent
            expanded = false
            visible = false
        }

        HBox detailBox = new HBox()
        detailBox.with {
            spacing = 10
        }
        detailBox.children.addAll([
                lSubreddit,
                hlComments,
                lAuthor,
        ])

        VBox titleBox = new VBox(spacing: 10)
        titleBox.children.addAll([
                hlTitle,
                detailBox,
                tpContent
        ])

        HBox mainBox = new HBox(spacing: 10)
        mainBox.children.addAll([
                scoreBox,
                ivThumb,
                titleBox
        ])

        box = mainBox
    }

    void addContent(String content) {
        pContent.children.add(new Label(content))
        showContent()
    }

    void addHtml(Pane root, String url, boolean javascript) {
        WebView web = new WebView()
        web.getEngine().load(url)
        web.engine.setJavaScriptEnabled(javascript)
        root.children.add(web)
        showContent()
    }

    void addHtmlContent(String content, boolean javascript) {
        WebView web = new WebView()
        web.getEngine().loadContent(content)
        web.engine.setJavaScriptEnabled(javascript)
        pContent.children.add(web)
        showContent()
    }

    private void showContent() {
        tpContent.visibleProperty().set(true)
    }
}
