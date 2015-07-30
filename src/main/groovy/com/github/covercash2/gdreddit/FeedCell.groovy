package com.github.covercash2.gdreddit

import javafx.scene.control.ListCell
import javafx.scene.image.Image
import org.apache.commons.lang3.StringEscapeUtils
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
                lAuthor.text = '/u/' + link.author
                lScore.text = link.ups
                lComments.text = link.num_comments + ' comments'
                lSelfText.text = link.selftext
                lSubreddit.text = '/r/' + link.subreddit
            }

            println link.media
            println link.media_embed
            println link.secure_media_embed

            println link.thumbnail

            if (link.thumbnail) {
                try {
                    Image thumb = new Image(link.thumbnail, true)
                    data.ivThumb.image = thumb
                } catch (IllegalArgumentException e) {
                    println 'thumbnail not found: ' + link.thumbnail
                }
            }

            if (link.selftext) {
                data.addContent(link.selftext)
            } else if (link.secure_media_embed) {
                def embed = StringEscapeUtils.unescapeHtml4(link.secure_media_embed.get('content'))
                data.addHtmlContent(data.pContent, embed, true)
            }

            prefWidthProperty().bind(listView.widthProperty().subtract(20))

            setGraphic(data.box)
        }
    }
}
