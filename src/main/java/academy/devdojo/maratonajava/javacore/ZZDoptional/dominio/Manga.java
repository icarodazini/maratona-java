package academy.devdojo.maratonajava.javacore.ZZDoptional.dominio;

public class Manga {
    private Integer id;
    private String tittle;
    private int chapters;

    public Manga(Integer id, String tittle, int chapters) {
        this.id = id;
        this.tittle = tittle;
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", chapters=" + chapters +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public int getChapters() {
        return chapters;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }
}
