package com.github.covercash2.gdreddit

import com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.SideBar
import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
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

        Button bReload = new Button()
        bReload.with {
            text = 'Reload'
            onAction = getEventHandler(controller.reload)
        }

        Button bLogin = new Button()
        bLogin.with {
            text = 'Login'
            onAction = getEventHandler(controller.login)
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

        // add views to parent
        parentView.mainView.top = mainBox
    }

    static EventHandler<ActionEvent> getEventHandler(Closure action, Object... args) {
        return new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent event) {
                action.call(args)
            }
        }
    }
}