package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import javafx.collections.ObservableList
import javafx.scene.control.Button
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class NavBarController extends AbstractGriffonController {
    NavBarModel model
    NavBarView view

    @Inject
    RedditService reddit

    Button bReload
    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        println 'NavBarController init'
        model = args.get 'model'
        view = args.get 'view'

        bReload.onAction =  {
            reddit.feedList.addBullshit(10, 'new bullshit')
        }
    }
}