package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonView)
class LoginView {
    FactoryBuilderSupport builder
    LoginModel model

    MainView parentView

    void initUI() {
        builder.with {
            content = vbox(spacing: 20) {
                label(text: 'login')
                label(text: 'username')
                textField(text: bind(model.usernameProperty))
                label(text: 'password')
                passwordField(text: bind(model.passwordProperty))
            }
        }

        parentView.mainView.center = builder.content
    }
}