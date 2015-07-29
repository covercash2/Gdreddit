package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import org.spacehq.reddit.data.json.Link

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class FeedController extends AbstractGriffonController {
    FeedModel model
    FeedView view

    @Inject
    RedditService reddit

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        model = args.get 'model'
        view = args.get 'view'

        view.lvFeed.with {
            items = reddit.feedList.content
            cellFactory = { ListView<Link> param ->
                return new FeedCell()
            }
        }
    }
}