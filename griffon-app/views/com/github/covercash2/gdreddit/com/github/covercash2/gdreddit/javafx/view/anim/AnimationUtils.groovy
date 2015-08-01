package com.github.covercash2.gdreddit.com.github.covercash2.gdreddit.javafx.view.anim

import com.github.covercash2.gdreddit.javafx.FXUtils
import javafx.animation.Animation
import javafx.animation.Transition
import javafx.scene.layout.Region
import javafx.util.Duration

/**
 * Created by covercash on 7/31/15.
 */
class AnimationUtils {
    static final long ANIMATION_DURATION = 500

    static Transition hideRight(final Region region, final double expandedWidth) {
        Transition t = new Transition() {
            { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }
            @Override
            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * (1.0 - frac)
                region.setPrefWidth(curWidth)
                region.setTranslateX(expandedWidth - curWidth)
            }
        }

        t.onFinishedProperty().set(FXUtils.getEventHandler({
            region.with {
                setVisible(false)
                styleClass.with {
                    remove('hide-left')
                    add('show-right')
                }
            }
            region.setVisible(false)
            region.styleClass.remove('hide-left')
            region.styleClass.add('show-right')
        }))

        return t
    }

    static Transition hideRightPartial(
            final Region region,
            final double expandedWidth,
            final double minWidth) {
        Transition t = new Transition() {
            { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }
            @Override
            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * (1.0 - frac)
                if (curWidth >= minWidth) {
                    region.setPrefWidth(curWidth)
                } else {
                    // make sure the width isn't affected by the framerate
                    region.setPrefWidth(minWidth)
                }
            }
        }
        return t
    }

    static Transition showRightPartial(
            final Region region,
            final double expandedWidth,
            final double minWidth) {
        Transition t = getTransition { double frac ->
            final double curWidth = expandedWidth * frac + minWidth
            if (curWidth <= expandedWidth) {
                region.setPrefWidth(curWidth)
            } else {
                // make sure the width isn't affected by the framerate
                region.setPrefWidth(expandedWidth)
            }
        }
    }

    static Transition showRight(Region region, final double expandedWidth) {
        Transition t = new Transition() {
            { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }
            @Override
            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * frac
                region.setPrefWidth(curWidth)
                region.setTranslateX(expandedWidth - curWidth)
            }
        }
        t.onFinishedProperty().set(FXUtils.getEventHandler({
            region.styleClass.with {
                add('hide-left')
                remove('show-right')
            }
        }))

        return t
    }

    static Transition getTransition(Closure action) {
        return new Transition() {
            { setCycleDuration(Duration.millis(ANIMATION_DURATION)) }
            @Override
            protected void interpolate(double frac) {
                action.call(frac)
            }
        }
    }

    static boolean isStopped(Animation animation) {
        return animation.statusProperty().get() == Animation.Status.STOPPED
    }

    static boolean allStopped(Animation... animations) {
        boolean result = true
        animations.each { result = result && isStopped(it) }
    }

}
