package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import javafx.scene.control.ListView
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class FeedController extends AbstractGriffonController {
    FeedModel model
    FeedView view

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        model = args.get 'model'
        view = args.get 'view'

        model.feedList.addAll(generateBullshit(10))

        view.lvFeed.with {
            items = model.feedList
            cellFactory = { ListView<String> param ->
                return new FeedCell()
            }
        }
    }

    static Set<String> generateBullshit(int num) {
        Set<String> result = new HashSet<>();
        0.upto(num) {
            result.add('bullshit' + "$it".toString())
        }
        return result
    }
}