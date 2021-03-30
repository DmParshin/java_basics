public class Printer {
    String queue = "";
    public int totalPages = 0;
    public int totalDocs = 0;
    public int totalDocsHistory = 0;

    public void append(String text) {
        append(text, "Имя не указано", 0 );
    }

    public void append(String text, String name) {
        append(text, name, 0 );
    }

    public void append(String text, int pages) {
        append(text, "Имя не указано", pages );
    }

    public void append(String text, String name, int pages){
        queue = queue + "\n" + text + " - " + name + " - " + pages;
        totalPages = totalPages + pages;
        totalDocs = totalDocs + 1;
        totalDocsHistory = totalDocsHistory + 1;
    }

    public void clear() {
        queue = "";
        totalPages = 0;
        totalDocs = 0;
    }

    public void print(String title) {
        System.out.print(title);
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
        }
        this.clear();
    }

    public int getPagesCount() {
        return totalPages;
    }

    public int getDocumentsCount() {
        return totalDocs;
    }

    public int getTotalDocsHistory(){
        return totalDocsHistory;
    }
}

