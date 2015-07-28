package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.layout.VBox

@ArtifactProviderFor(GriffonView)
class SideBarView {
    FactoryBuilderSupport builder
    FeedModel model

    MainView parentView

    void initUI() {
        builder.with {
            content = vbox(spacing: 10, minWidth: 200) {
                label(text: "test text")
            }
        }

        parentView.mainView.right = builder.content
    }
}