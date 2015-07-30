package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Control
import javafx.scene.control.ListView
import javafx.scene.control.ScrollPane
import javafx.scene.layout.AnchorPane
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView

@ArtifactProviderFor(GriffonView)
class FeedView extends AbstractJavaFXGriffonView {
    FactoryBuilderSupport builder
    FeedController controller
    FeedModel model
    MainView parentView

    ListView lvFeed

    void initUI() {

        AnchorPane ap = new AnchorPane()

        lvFeed = new ListView()

        AnchorPane.setBottomAnchor(lvFeed, 0.0)
        AnchorPane.setLeftAnchor(lvFeed, 0.0)
        AnchorPane.setTopAnchor(lvFeed, 0.0)
        AnchorPane.setRightAnchor(lvFeed, 0.0)


        ap.children.add(lvFeed)

        def mainView = ap
        parentView.mainView.center = mainView
    }
}