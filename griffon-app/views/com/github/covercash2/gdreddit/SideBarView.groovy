package com.github.covercash2.gdreddit

import com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.SideBar
import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

@ArtifactProviderFor(GriffonView)
class SideBarView {
    FactoryBuilderSupport builder
    FeedModel model

    MainView parentView

    void initUI() {

        VBox contentBox = new VBox()
        contentBox.with {
            spacing = 10
            children.addAll([
                    new Label('test text')
            ])
        }

        SideBar sideBar = new SideBar(250, contentBox)
        Button bExpander = sideBar.controlButton

        VBox mainBox = new VBox()
        mainBox.with {
            spacing = 10
            children.addAll([
                    sideBar.controlButton,
                    sideBar
            ])
        }

        mainBox.stylesheets.add(getClass().getResource('/com/github/covercash2/gdreddit/javafx/view/slideout.css').toExternalForm())

        def content = mainBox
        parentView.mainView.right = content
    }
}