package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonView)
class SideBarView {
    FactoryBuilderSupport builder
    FeedModel model

    void initUI() {
        builder.with {

        }
    }
}