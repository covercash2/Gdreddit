package com.github.covercash2.gdreddit

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.spacehq.reddit.data.json.Link

import javax.annotation.Nonnull

/**
 * Created by covercash on 7/27/15.
 */
class FeedList {
    ObservableList<Link> content = FXCollections.observableArrayList()
}
