package kotlinVideo

external interface Video {
    val id: Int
    val title: String
    val speaker: String
    val videoURL: String
}
data class KotlinVideo (
    override val id: Int,
    override val title: String,
    override val speaker: String,
    override val videoURL: String ) : Video
