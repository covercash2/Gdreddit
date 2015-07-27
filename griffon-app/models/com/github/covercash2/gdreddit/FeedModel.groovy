package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.metadata.ArtifactProviderFor
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel

import javax.annotation.Nonnull


@ArtifactProviderFor(GriffonModel)
class FeedModel extends AbstractGriffonModel {
    ObservableList feedList = FXCollections.observableArrayList()
}