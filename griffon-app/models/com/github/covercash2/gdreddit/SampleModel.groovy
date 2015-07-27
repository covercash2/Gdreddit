package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class SampleModel {
    @FXObservable String clickCount = "0"
}