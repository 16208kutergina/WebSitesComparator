import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebSitesComparatorTest {
    private WebSitesTable previous = new WebSitesTable();
    private WebSitesTable current = new WebSitesTable();
    private WebSitesComparator webSitesComparator = new WebSitesComparator();

    public WebSitesComparator getWebSitesComparator() {
        return webSitesComparator;
    }

    @BeforeEach
    public void beforeTest(){
        Url url_1 = new Url("url_1");
        Html html_1 = new Html("html_1");
        Url url_2 = new Url("url_2");
        Html html_2 = new Html("html_2");
        Url url_3 = new Url("url_3");
        Html html_3 = new Html("html_3");

        previous.add(url_1, html_1);
        previous.add(url_2, html_2);
        previous.add(url_3, html_3);

        current.add(url_1, html_1);
        current.add(url_2, html_1);

        Url url_new = new Url("url_new");
        Html html_new = new Html("html_new");
        current.add(url_new, html_new);

        webSitesComparator.compareWebSites(previous, current);
    }

    @Test
    public void webSitesComparatorAddedTest(){
        Url url_new = new Url("url_new");
        assertTrue(webSitesComparator.getAdded().contains(url_new));
    }

    @Test
   public  void webSitesComparatorChangedTest(){
        Url url_2 = new Url("url_2");
        assertTrue(webSitesComparator.getChanged().contains(url_2));
    }

    @Test
    public void webSitesComparatorDeletedTest(){
        Url url_3 = new Url("url_3");
        assertTrue(webSitesComparator.getDeleted().contains(url_3));
    }

}