package com.github.covercash2.gdreddit

import javafx.scene.control.ListCell
import org.spacehq.reddit.data.json.Link

/**
 * Created by covercash on 7/26/15.
 */
class FeedCell extends ListCell<Link> {
    @Override
    void updateItem(Link link, boolean empty) {
        super.updateItem(link, empty)
        if (link) {
            Data data = new Data()

            data.with {
                lTitle.text = link.title
                lAuthor.text = link.author
                lScore.text = link.ups
            }

            setGraphic(data.box)
        }
    }
}
