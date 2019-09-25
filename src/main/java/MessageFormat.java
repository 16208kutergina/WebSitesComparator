import java.util.Set;

public class MessageFormat {
    public static String reportOfModifiedPages(
            String appeal,
            Set<Url> deletedPages,
            Set<Url> changedPages,
            Set<Url> addedPages){
        StringBuilder message = new StringBuilder("Здравствуйте, " + appeal + "\n"
                + "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n" +
                "1) Исчезли следующие страницы: \n");
        printSetUrl(deletedPages, message);
        message.append("2) Появились следующие новые страницы\n");
        printSetUrl(addedPages, message);
        message.append("3) Изменились следующие страницы\n");
        printSetUrl(changedPages, message);
        message.append("С уважением,\n" +
                "автоматизированная система мониторинга.");
        return message.toString();
    }

    private static void printSetUrl(Set<Url> pages, StringBuilder message) {
        for(Url url : pages){
            message.append(url);
            message.append("\n");
        }
    }
}
