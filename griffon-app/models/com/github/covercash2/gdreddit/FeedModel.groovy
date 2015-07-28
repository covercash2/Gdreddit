package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.metadata.ArtifactProviderFor
import griffon.transform.FXObservable
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel

import javax.annotation.Nonnull


@ArtifactProviderFor(GriffonModel)
class FeedModel extends AbstractGriffonModel {
    FeedList feedList

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        println 'FeedModel init'
        feedList = args.get('feedList') as FeedList
    }

    void addBullshit(@Nonnull int num, String msg) {
        feedList.addAll(generateBullshit(num, msg))
    }

    static Set<String> generateBullshit(@Nonnull int num, String msg) {
        Set<String> result = new HashSet<>();

        String string
        string = msg ?: 'bullshit'
        0.upto(num) {
            result.add(string + "$it".toString())
        }
        return result
    }
}