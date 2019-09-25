import org.junit.jupiter.api.Test;

public class MailManagerTest extends WebSitesComparatorTest{

    @Test
    public void sendMessageTest(){
        WebSitesComparator webSitesComparator = super.getWebSitesComparator();
        final String message = MessageFormat.reportOfModifiedPages(
                "дорогая и.о. секретаря",
                webSitesComparator.getDeleted(),
                webSitesComparator.getChanged(),
                webSitesComparator.getAdded()
        );
        MailManager.sendMessage("Отчёт об изменениях",
                message,
                "a.kutergina@g.nsu.ru"
        );
    }
}


