package com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view

import javafx.animation.Animation
import javafx.animation.Transition
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.util.Duration

/**
 * based on  https://gist.github.com/jewelsea/1437374
 */
class SideBar extends VBox {
    static final long ANIMATION_DURATION = 250
    Button controlButton

    SideBar(final double expandedWidth, Node nodes) {
        styleClass << 'sidebar'

        setPrefWidth(expandedWidth)
        setMinWidth(0)

        // create a bar to hide and show
        setAlignment(Pos.CENTER)
        children.addAll(nodes)

        // create a button to control the sidebar
        controlButton = new Button('Collapse')
        controlButton.getStyleClass() << 'hide-left'

        controlButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            void handle(ActionEvent e) {
                final Animation hideSideBar = new Transition() {
                    { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }
                    @Override
                    protected void interpolate(double frac) {
                        final double curWidth = expandedWidth * (1.0 - frac)
                        setPrefWidth(curWidth)
                        setTranslateX(expandedWidth - curWidth)
                    }
                }
                hideSideBar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                    @Override
                    void handle(ActionEvent event) {
                        setVisible(false)
                        controlButton.with {
                            text = 'Show'
                            styleClass.remove('hide-left')
                            styleClass.add('show-right')
                        }
                    }
                })

                final Animation showSideBar = new Transition() {
                    { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }

                    @Override
                    protected void interpolate(double frac) {
                        final double curWidth = expandedWidth * frac
                        setPrefWidth(curWidth)
                        setTranslateX(expandedWidth - curWidth)
                    }
                }
                showSideBar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                    @Override
                    void handle(ActionEvent event) {
                        controlButton.with {
                            text = 'Collapse'
                            styleClass.add('hide-left')
                            styleClass.remove('show-right')
                        }
                    }
                })

                if (showSideBar.statusProperty().get() == Animation.Status.STOPPED &&
                        hideSideBar.statusProperty().get() == Animation.Status.STOPPED) {
                    if (visible) {
                        hideSideBar.play()
                    } else {
                        setVisible(true)
                        showSideBar.play()
                    }
                }

            }
        })
    }
}
