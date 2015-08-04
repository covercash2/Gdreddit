package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.metadata.ArtifactProviderFor
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel

/**
 * Created by covercash on 8/1/15.
 */
@ArtifactProviderFor(GriffonModel)
class SideBarModel extends AbstractGriffonModel {
    StringProperty descriptionProperty = new SimpleStringProperty()
}
