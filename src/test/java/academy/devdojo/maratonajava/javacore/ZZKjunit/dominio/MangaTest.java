package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    void setUp() {
        manga1 = new Manga("Naruto", 20);
        manga2 = new Manga("Naruto", 20);
    }

    @Test
    void acessors_ResturnData_WhenInitialized() {
        Assertions.assertEquals("Naruto", manga1.name());
        Assertions.assertEquals(20, manga1.episodes());
    }

    @Test
    void equals_ResturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    void hashCode_ResturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    void constructor_ThrowNullPointerException_WhenNameIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Manga(null, 10));
    }

    @Test
    void isRecord_ThrowNullPointerException_WhenNameIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Manga(null, 10));
    }
}