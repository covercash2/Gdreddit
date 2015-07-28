package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import javafx.scene.control.Button
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class NavBarController extends AbstractGriffonController {
    FeedModel model
    NavBarView view

    Button bReload

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        println 'NavBarController init'
        model = args.get 'model'
        view = args.get 'view'

        bReload.onAction =  {
            model.addBullshit(5, 'maybe not bullshit')
        }
    }
}