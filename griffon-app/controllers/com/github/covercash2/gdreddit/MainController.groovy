package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import org.spacehq.reddit.Reddit

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class MainController extends AbstractGriffonController {
    MainModel model

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {
        model = args.get('model') as MainModel

        Reddit reddit = new Reddit('Gdreddit/0.1.0 author: covercash2@gmail.com')

        reddit.globalErrorHandler = {
            it.printStackTrace()
            reddit.dispose()
        }

        // login with reddit's default authentication
        reddit.redditAuth.login("covercash2", "astros9009", false)

        reddit.redditAuth.me {
            println it
            reddit.dispose()
        }
    }
}