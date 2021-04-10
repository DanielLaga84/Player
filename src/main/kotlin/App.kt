import kotlinVideo.*
import kotlinx.css.*
import react.*
import react.dom.*
import styled.css
import styled.styledDiv


@JsExport
class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        unwatchedVideos = listOf(KotlinVideo(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
            KotlinVideo(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
            KotlinVideo(3, "The Web 7.0.", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
        )
        watchedVideos = listOf(kotlinVideo.KotlinVideo(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E"))
    }

    override fun RBuilder.render() {
        styledDiv  {
            css {
                position = Position.sticky
                top = 10.px
                right = 10.px
            }
        h1 {
            +"KotlinConf Explorer"
        }
            h3 {
                +"Videos to watch"
            }
            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video -> setState { currentVideo = video } }

            }
        }
        h3 {
            +"Videos watched"
        }
        videoList {
            videos = state.watchedVideos
            selectedVideo = state.currentVideo
            onSelectVideo = { video -> setState { currentVideo = video } }
        }

        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
                unwatchedVideo = currentVideo in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos) {
                    setState {
                        unwatchedVideos -= video
                        watchedVideos += video
                    }
                } else {
                setState {
                    watchedVideos -= video
                    unwatchedVideos += video
                }
                }
            }
            }
        }
    }
}

