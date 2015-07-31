package com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view

import com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.anim.AnimationUtils
import com.github.covercash2.gdreddit.javafx.FXUtils
import javafx.animation.Animation
import javafx.animation.Transition
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Control
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

        // create animations
        final Animation hideSideBar = AnimationUtils.hideRight(this, expandedWidth)

        final Animation showSideBar = AnimationUtils.showRight(this, expandedWidth)

        controlButton.onAction = FXUtils.getEventHandler({
            if (AnimationUtils.allStopped(hideSideBar, showSideBar)) {
                if (visible) {
                    hideSideBar.play()
                } else {
                    setVisible(true)
                    showSideBar.play()
                }
            }
        })
    }
}
