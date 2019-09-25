import java.util.HashSet;
import java.util.Set;

public class WebSitesComparator {
    private Set<Url> added = new HashSet<>();
    private Set<Url> changed = new HashSet<>();
    private Set<Url> deleted = new HashSet<>();

    public Set<Url> getAdded() {
        return added;
    }

    public Set<Url> getChanged() {
        return changed;
    }

    public Set<Url> getDeleted() {
        return deleted;
    }

    private void resetCounters(){
        added = new HashSet<>();
        changed = new HashSet<>();
        deleted = new HashSet<>();
    }

    public void compareWebSites(WebSitesTable prev, WebSitesTable current){
        resetCounters();
        Set<Url> prevUrls = prev.getUrls();
        Set<Url> currentUrls = current.getUrls();
        for(Url url: prevUrls){
            if(currentUrls.contains(url)){
                Html prevHtml = prev.getHtmlByUrl(url);
                Html curHtml = current.getHtmlByUrl(url);
                if(!prevHtml.equals(curHtml)){
                    changed.add(url);
                }
                currentUrls.remove(url);
            }else{
                deleted.add(url);
            }
        }
        added.addAll(currentUrls);
    }
}
