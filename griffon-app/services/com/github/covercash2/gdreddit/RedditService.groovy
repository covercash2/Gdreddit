package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonService
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.spacehq.reddit.Reddit

import javax.annotation.Nonnull
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

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
            println it
            reddit.dispose()
        }
    }

    @PreDestroy
    void destroy() {
        reddit.dispose()
    }

    void authenticate(@Nonnull String username,
                      @Nonnull String password,
                      @Nonnull Closure callback,
                      Closure error) {
        reddit.redditAuth.login(username, password, false)

        reddit.redditAuth.me(callback, error)
    }
}
