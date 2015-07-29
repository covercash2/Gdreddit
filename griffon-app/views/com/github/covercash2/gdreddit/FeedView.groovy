package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Control
import javafx.scene.control.ListView
import javafx.scene.control.ScrollPane
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView

@ArtifactProviderFor(GriffonView)
class FeedView extends AbstractJavaFXGriffonView {
    FactoryBuilderSupport builder
    FeedController controller
    FeedModel model
    MainView parentView

    ListView lvFeed

    void initUI() {
        builder.with {
            content =  scrollPane {
                    listView()
                }
        }

        ScrollPane scrollPane = builder.content

        scrollPane.with {
            fitToWidth = true
            fitToHeight = true
        }

        lvFeed = scrollPane.content as ListView

        parentView.mainView.center = builder.content
    }
}