package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController

import javax.annotation.Nonnull
import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class LoginController extends AbstractGriffonController{
    LoginModel model

    @Inject
    RedditService reddit

    @Override
    void mvcGroupInit(@Nonnull Map<String, Object> args) {

    }

}