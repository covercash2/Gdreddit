package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor
import javafx.beans.property.StringProperty
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel

@ArtifactProviderFor(GriffonModel)
class NavBarModel extends AbstractGriffonModel {
    MainView parentView
    StringProperty subredditDescription
}