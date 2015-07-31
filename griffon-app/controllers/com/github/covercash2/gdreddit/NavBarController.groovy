package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import javafx.collections.ObservableList
import javafx.scene.control.Button
import javafx.scene.control.Control
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import org.spacehq.reddit.data.json.Subreddit

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class NavBarController extends AbstractGriffonController {
    NavBarModel model

    @Inject
    RedditService reddit

    Button bReload

    def reload = {
        reddit.loadDefaultFeed()
    }

    def login = {
        model.parentView.destroyMainActivity()
        model.parentView.startLoginActivity()
    }

    def loadSideBar = { Pane parentView ->
        def callback = { Subreddit sub ->
            sub.each { println it }
            Label about = new Label()
            about.with {
                text = sub.description
            }
            parentView.children.add(about)
        }

        reddit.loadSideBar(callback)
    }
}