package book;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:21
 */
public class BookList {
    private Book[] books;


    private  int usedSize;

    public BookList() {
        this.books=new Book[20];
        books[0] = new Book("三国演义","罗贯中",72,"小说");
        books[1] = new Book("西游记","吴承恩",32,"小说");
        books[2] = new Book("水浒传","施耐庵",52,"小说");
        this.usedSize = 3;
    }
    public Book getBooks(int index) {
        return this.books[index];
    }

    public void setBooks(int index,Book books) {
        this.books[index] = books;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook(int i) {
        return this.books[i];
    }
}
