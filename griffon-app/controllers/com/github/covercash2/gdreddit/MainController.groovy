package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import org.spacehq.reddit.Reddit

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class MainController extends AbstractGriffonController {
    MainModel model

    @Inject
    RedditService redditService

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        model = args.get('model') as MainModel
    }
}