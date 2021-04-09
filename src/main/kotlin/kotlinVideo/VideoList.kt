package kotlinVideo


import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.onClick
import kotlinx.html.video
import react.*
import react.dom.p



external interface VideoListProps : RProps {
    var videos: List<Video>
}

external interface VideoListState : RState {
    var selectedVideo: Video?
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class){
    this.attrs(handler)
}
}

@JsExport
class VideoList : RComponent<VideoListProps, VideoListState>() {
    override fun RBuilder.render() {
        for (video in props.videos) {
            p {
                key = video.id.toString()
                attrs{
                    onClickFunction = {
                        window.alert("Clicked $video!")
                        setState {
                            selectedVideo = video
                        }
                    }
                }
                if ( video == state.selectedVideo) {
                    +"▶  "
                }
                +"${video.speaker}: ${video.title}: ${video.videoURL}"
            }
        }
    }
}