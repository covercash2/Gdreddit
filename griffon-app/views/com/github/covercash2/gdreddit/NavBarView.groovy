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
        model.parentView = parentView
    }

    void initUI() {
        println 'NavBarView initUI'

        builder.with {
            content = hbox(spacing: 20) {
                button(
                        text: 'Reload',
                        onAction: controller.reload
                )
                button(
                        text: 'Login',
                        onAction: controller.login
                )
            }
        }
        controller.bReload = builder.content.children[0] as Button

        // add view to parent
        parentView.mainView.top = builder.content
    }
}