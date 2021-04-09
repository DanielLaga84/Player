package kotlinVideo


import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.onClick
import kotlinx.html.video
import react.*
import react.dom.p


external interface VideoListProps : RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

external interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}

@JsExport
class VideoList : RComponent<VideoListProps, RState>() {
    override fun RBuilder.render() {
        for (video in props.videos) {
            p {
                key = video.id.toString()
                attrs {
                    onClickFunction = {
                        props.onSelectVideo(video)

                    }
                }
                if (video == props.selectedVideo) {
                    +"▶  "
                }
                +"${video.speaker}: ${video.title}: ${video.videoURL}"
            }
        }
    }
}
