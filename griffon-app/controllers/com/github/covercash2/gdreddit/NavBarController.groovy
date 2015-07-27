package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Threading
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController

@ArtifactProviderFor(GriffonController)
class NavBarController extends AbstractGriffonController {
    NavBarModel model

}