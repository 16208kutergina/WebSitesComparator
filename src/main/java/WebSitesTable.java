import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class WebSitesTable {
    private Hashtable<Url, Html> webSites = new Hashtable<>();

    public Set<Url> getUrls(){
        return webSites.keySet();
    }

    public Html getHtmlByUrl(Url url){
        return webSites.get(url);
    }

    public void add(Url url, Html html){
        webSites.put(url, html);
    }


}
