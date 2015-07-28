package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Button
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView)
class NavBarView extends AbstractJavaFXGriffonView {
    FactoryBuilderSupport builder

    NavBarModel model
    NavBarController controller

    MainView parentView

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        println 'NavBarView init'
    }

    void initUI() {
        println 'NavBarView initUI'
        builder.with {
            content = builder.fxml(resource('/com/github/covercash2/gdreddit/navbar.fxml')) {

            }
        }
        controller.bReload = builder.content.children[0] as Button

        connectActions(builder.content, controller)

        // add view to parent
        parentView.mainView.top = builder.content
    }
}