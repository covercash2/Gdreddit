package com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view

import com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.anim.AnimationUtils
import com.github.covercash2.gdreddit.javafx.FXUtils
import javafx.animation.Animation
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.VBox

/**
 * based on  https://gist.github.com/jewelsea/1437374
 */
class SideBar extends VBox {
    static final long ANIMATION_DURATION = 250
    static final long HIDDEN_WIDTH = 28.0
    Button controlButton

    boolean expanded

    SideBar(final double expandedWidth, Node nodes) {
        styleClass << 'sidebar'

        setPrefWidth(expandedWidth)
        setMinWidth(HIDDEN_WIDTH)

        // create a bar to hide and show
        children.addAll(nodes)

        // create a button to control the sidebar
        controlButton = new Button('<')
        controlButton.getStyleClass() << 'hide-left'
        controlButton.maxWidth(HIDDEN_WIDTH)

        // create animations
        final Animation hideSideBar = AnimationUtils.hideRightPartial(this, expandedWidth, HIDDEN_WIDTH)

        hideSideBar.onFinishedProperty().set(FXUtils.getEventHandler({
            expanded = false
        }))

        final Animation showSideBar = AnimationUtils.showRight(this, expandedWidth)

        controlButton.onAction = FXUtils.getEventHandler({
            if (AnimationUtils.allStopped(hideSideBar, showSideBar)) {
                /*
                 * decide whether to show or hide side bar
                 */
                if (expanded) {
                    hideSideBar.play()
                } else {
                    expanded = true
                    showSideBar.play()
                }
            }
        })
    }
}
