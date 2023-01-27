import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.lang.RuntimeException

class WallServiseTest {

    @Before
    fun clear(){
    }

    @Test
    fun add() {
        val add = Post(1, text = "Привет")
        val result = WallServise.add(Post(1, text = "Привет"))
        assertNotEquals(null, result)
    }


    @Test
    fun updateTrue() {
        WallServise.add(Post(1, text = "Привет"))
        val result = WallServise.update(Post(1, text = "Привет"))
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        WallServise.add(Post(1, text = "Привет"))
        val result = WallServise.update(Post(2, text = "Привет"))
        assertFalse(result)
    }

    @Test
    fun createCommentCorrect(){
        WallServise.add(Post(1, text = "Привет"))
        val result = WallServise.createComment(1, Comment(1,2,"Супер"))
        assertEquals(Comment(1,2,"Супер"), result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallServise.add(Post(1, text = "Привет"))
        val result = WallServise.createComment(3, Comment(1,2,"Супер"))
    }
}

