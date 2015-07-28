package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonService
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.spacehq.reddit.Reddit

import javax.annotation.PostConstruct

/**
 * Created by covercash on 7/28/15.
 */

@griffon.metadata.ArtifactProviderFor(GriffonService)
class RedditService {
    static final def USER_AGENT

    FeedList feedList = new FeedList()

    Reddit reddit

    @PostConstruct
    void init() {
        println 'test service'

        reddit = new Reddit(USER_AGENT)

        reddit.globalErrorHandler = {
            it.printStackTrace()
            reddit.dispose()
        }

        // login
        reddit.redditAuth.login("covercash2", "astros9009", false)

        reddit.redditAuth.me {
            println it
            reddit.dispose()
        }
    }
}
