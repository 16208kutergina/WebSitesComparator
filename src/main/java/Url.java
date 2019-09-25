import java.util.Objects;

public class Url {
    private String url;

    public Url(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "url= " + url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url1 = (Url) o;
        return Objects.equals(url, url1.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
