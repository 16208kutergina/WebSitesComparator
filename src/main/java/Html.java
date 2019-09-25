import java.util.Objects;

public class Html {
    private String html;

    public Html(String html) {
        this.html = html;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Html html1 = (Html) o;
        return Objects.equals(html, html1.html);
    }

    @Override
    public int hashCode() {
        return Objects.hash(html);
    }
}
