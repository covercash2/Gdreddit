package com.github.covercash2.gdreddit

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.ProgressIndicator
import javafx.scene.layout.VBox
import javafx.scene.Node
import org.spacehq.reddit.util.http.RequestException

import javax.inject.Inject

@ArtifactProviderFor(GriffonView)
class LoginView {
    FactoryBuilderSupport builder
    LoginModel model
    LoginController controller

    @Inject
    RedditService reddit

    MainView parentView

    VBox content

    Label lError
    ProgressIndicator progressIndicator

    void initUI() {
        builder.with {
            content = vbox(spacing: 20, maxWidth: 200, alignment: Pos.CENTER) {
                label(text: 'login')
                label(text: 'username')
                textField(text: bind(model.usernameProperty)) {
                    onAction {
                        authenticate()
                    }
                }
                label(text: 'password')
                passwordField(text: bind(model.passwordProperty)) {
                    onAction {
                        authenticate()
                    }
                }
                button(text: 'login') {
                    onAction {
                        authenticate()
                    }
                }
            }
        }

        content = builder.content

        lError = new Label()
        lError.with {
            text = 'Error'
            visible = false
        }

        progressIndicator = new ProgressIndicator()
        progressIndicator.with {
            visible = false
        }

        content.children.with {
            add(lError)
            add(progressIndicator)
        }

        parentView.mainView.center = content
    }

    void authenticate() {
        progressIndicator.visible = true
        lError.visible = false

        def callback = {
            progressIndicator.visible = false
            parentView.startMainActivity()
        }

        def error = { e ->
            lError.visible = true
            progressIndicator.visible = false

            if (e instanceof RequestException) {
                e.printStackTrace()
                println e
            }
        }

        String username = model.username
        String password = model.password

        if (username && password) {
            reddit.authenticate(username, password, callback, error)
        } else {
            error.call(new NullPointerException('requires username and password'))
        }
    }
}