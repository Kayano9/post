import org.junit.Test
import Post
import org.junit.Assert.*
import org.junit.Before

class WallServiseTest {

    @Before
    fun clear(){
    }

    @Test
    fun add() {
        val add = Post(1)
        val result = WallServise.add(Post(1))
        assertNotEquals(null, result)
    }


    @Test
    fun updateTrue() {
        WallServise.add(Post(1))
        val result = WallServise.update(Post(1))
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        WallServise.add(Post(1))
        val result = WallServise.update(Post(2))
        assertFalse(result)
    }
}