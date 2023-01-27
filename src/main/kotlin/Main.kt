data class Post(
    var id: Int = 0,
    val owenId: Int = 0,
    val fromId: Int = 0,
    val text: String?,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    var likeCount: Int = 0,
    var attachments: Array<Attachment> = emptyArray()
) {
    inner class Likes() {
    }
}


object WallServise {
    private var counter = 0
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post.copy(id = ++counter)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (newPost.id == post.id) {
                posts[index] = newPost.copy(text = "Пока", likeCount = post.likeCount)
                return true
            }
        }
        return false
    }

    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }

    fun likedById(id: Int, userLike: Boolean, canLike: Boolean) {
        for ((index, post) in posts.withIndex()) {
            if (userLike == false && canLike == true && post.id == id) {
                posts[index] = post.copy(likeCount = post.likeCount + 1)

            }
        }
    }

    fun clear() {
        posts = emptyArray()
    }
}

fun main() {

    WallServise.add(Post(1, 1, 1, text = "Привет", attachments = arrayOf(AudioAttachments(Audio(1,"Егор")), VideoAttachments(Video(1, "Смех")))))
    WallServise.add(Post(2, 2, 2, text = "Привет"))
    WallServise.likedById(1, false, true)
    WallServise.printAll()
    println(WallServise.update(Post(1, text = "Привет")))
    WallServise.printAll()
}
