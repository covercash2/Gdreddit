package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonService
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.spacehq.reddit.Reddit
import org.spacehq.reddit.apis.ListingAPI
import org.spacehq.reddit.data.json.Link
import org.spacehq.reddit.data.json.Listing

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

    Listing currentListing

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

    void loadDefaultFeed() {
        Map query = new HashMap()
        reddit.listing.list(query, updateList, errorCallback)

    }

    void loadSideBar() {
        def callback = {
            println it
        }

        def error = { Exception e ->
            e.printStackTrace()
        }

        reddit.subreddit.about('videos', callback, error)
    }

    def updateList = { Listing feed ->
        currentListing = feed
        feedList.content.with {
            clear()
            addAll(feed.children)
        }
    }

    def errorCallback = { Exception e ->
        e.printStackTrace()
    }
}
