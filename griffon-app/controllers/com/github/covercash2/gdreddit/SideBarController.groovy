package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading

@ArtifactProviderFor(GriffonController)
class SideBarController {
    FeedModel model
}