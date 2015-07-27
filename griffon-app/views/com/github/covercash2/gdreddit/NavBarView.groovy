package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView

@ArtifactProviderFor(GriffonView)
class NavBarView extends AbstractJavaFXGriffonView {
    FactoryBuilderSupport builder

    NavBarModel model
    NavBarController controller

    MainView parentView

    void initUI() {
        builder.with {
            content = builder.fxml(resource('/com/github/covercash2/gdreddit/navbar.fxml'))
        }

        connectActions(builder.content, controller)

        parentView.mainView.top = builder.content
    }
}