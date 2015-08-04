package com.github.covercash2.gdreddit

import com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.SideBar
import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

@ArtifactProviderFor(GriffonView)
class SideBarView {
    FactoryBuilderSupport builder
    SideBarModel model

    MainView parentView

    SideBar sideBar

    void initUI() {
        sideBar = new SideBar(350)

        TextField searchBox = new TextField()

        VBox mainContent = new VBox()

        searchBox.with {
            promptText = 'search'
            prefWidthProperty().bind(sideBar.prefWidthProperty())
        }

        Label lDescription = new Label()
        lDescription.with {
            textProperty().bind(model.descriptionProperty)
            wrapText = true
        }

        model.descriptionProperty.set('test test test')


        mainContent.with {
            children.addAll(
                    searchBox,
                    lDescription
            )
            fillWidth = true
        }

        sideBar.with {
            children.addAll(
                    mainContent
            )
        }

        def content = sideBar
        parentView.mainView.right = content
    }
}