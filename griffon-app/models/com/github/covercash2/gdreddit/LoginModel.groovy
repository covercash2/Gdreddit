package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonModel
import griffon.metadata.ArtifactProviderFor
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonModel

import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonModel)
class LoginModel extends AbstractGriffonModel {
    private StringProperty username;
    private StringProperty password;

    @Nonnull
    public final StringProperty usernameProperty() {
        if (username == null) {
            username = new SimpleStringProperty(this, "username");
        }
        return username;
    }

    public final StringProperty getUsernameProperty() {
        return usernameProperty();
    }

    public String getUsername() {
        return username == null ? null : usernameProperty().get();
    }

    public void setUsername(String username) {
        usernameProperty().set(username);
    }

    @Nonnull
    public final StringProperty passwordProperty() {
        if (password == null) {
            password = new SimpleStringProperty(this, "password");
        }
        return password;
    }

    public final StringProperty getPasswordProperty() {
        return passwordProperty();
    }

    public String getPassword() {
        return password == null ? null : passwordProperty().get();
    }

    public void setPassword(String password) {
        passwordProperty().set(password);
    }
}