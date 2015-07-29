package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.core.mvc.MVCGroup
import griffon.metadata.ArtifactProviderFor
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonView)
class MainView extends AbstractJavaFXGriffonView {
    FactoryBuilderSupport builder

    MainModel model

    BorderPane mainView

    @Inject
    RedditService reddit

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        MVCGroup navbarGroup = createMVCGroup('navbar')
        MVCGroup loginGroup = createMVCGroup('login')
    }

    @Override
    void mvcGroupDestroy() {
    }

    void startMainActivity() {
        destroyMVCGroup('login')
        MVCGroup feedGroup = createMVCGroup('feed')
        MVCGroup sidebarGroup = createMVCGroup('sidebar')
    }

    void initUI() {
        Stage stage = application.createApplicationContainer(Collections.<String, Object>emptyMap())

        mainView = new BorderPane()

        stage.with {
            title = application.configuration.getAsString('application.title')
            scene = new Scene(mainView)
            sizeToScene()
        }

        application.windowManager.attach("mainWindow", stage)
    }


}