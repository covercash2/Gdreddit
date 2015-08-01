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

    SideBar sideBar

    void initUI() {
        sideBar = new SideBar(350)

        def content = sideBar
        parentView.mainView.right = content
    }
}