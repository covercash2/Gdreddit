package com.github.covercash2.gdreddit

import javafx.collections.FXCollections
import javafx.collections.ObservableList

import javax.annotation.Nonnull

/**
 * Created by covercash on 7/27/15.
 */
class FeedList {
    ObservableList content = FXCollections.observableArrayList()

    void addBullshit(@Nonnull int num, String msg) {
        content.addAll(generateBullshit(num, msg))
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
