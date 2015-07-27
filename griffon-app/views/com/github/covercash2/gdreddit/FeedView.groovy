package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
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
            content = builder.fxml(resource('/com/github/covercash2/gdreddit/feed.fxml')) {
            }
        }

        connectActions(builder.content, controller)

        ScrollPane scrollPane = builder.content

        lvFeed = scrollPane.content as ListView

        parentView.mainView.center = builder.content
    }
}