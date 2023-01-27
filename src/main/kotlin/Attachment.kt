interface Attachment {
    val type: String
}

data class Video(val id: Int, val title: String)
data class VideoAttachments(val video: Video) : Attachment {
    override val type = "video"
}
data class Photo(val id: Int, val albumId: Int, val owenrId: Int)
data class PhotoAttachments(val photo: Photo) : Attachment {
    override val type = "photo"
}
data class Audio(val id: Int, val artist: String)
data class AudioAttachments(val audio: Audio) : Attachment {
    override val type = "audio"
}
data class Doc(val id: Int, val title: String)
data class DocAttachments(val doc: Doc) : Attachment {
    override val type = "doc"
}
data class Poll(val id: Int, val question: String)
data class PollAttachments(val poll: Poll) : Attachment {
    override val type = "poll"
}