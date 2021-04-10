@file:JsModule("react-youtube-lite")
@file:JsNonModule

package kotlinVideo

import react.RClass
import react.RProps

@JsName("ReactYouTubeLite")
external val reactPlayer: RClass<dynamic>

external interface ReactYouTubeProps : RProps {
    val url : String
}