package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.Button
import javafx.scene.layout.HBox
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
        model.parentView = parentView
    }

    void initUI() {
        Button bReload = new Button()
        bReload.with {
            text = 'Reload'
            onAction = controller.reload
        }

        Button bLogin = new Button()
        bLogin.with {
            text = 'Login'
            onAction = controller.login
        }

        HBox mainBox = new HBox()
        mainBox.with {
            spacing = 20
            children.addAll([
                    bReload,
                    bLogin,
            ])
        }

        controller.bReload = bReload

        // add view to parent
        parentView.mainView.top = mainBox
    }
}