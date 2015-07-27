package com.github.covercash2.gdreddit

import griffon.core.artifact.ArtifactManager
import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import org.junit.Rule
import org.junit.Test

import javax.inject.Inject

import static com.jayway.awaitility.Awaitility.await

@TestFor(MainController)
class MainControllerTest {
    static {
        System.setProperty('org.slf4j.simpleLogger.defaultLogLevel', 'trace')
        // force initialization JavaFX Toolkit
        new javafx.embed.swing.JFXPanel()
    }

    @Inject
    private ArtifactManager artifactManager

    private MainController controller

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    @Test
    void executeClickAction() {
        // given:
        controller.model = artifactManager.newInstance(MainModel)

        // when:
        controller.invokeAction('click')
        await().until { controller.model.clickCount != "0" }

        // then:
        assert "1" == controller.model.clickCount
    }
}
