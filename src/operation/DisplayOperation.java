package operation;

import book.Book;
import book.BookList;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:26
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("展示图书");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
