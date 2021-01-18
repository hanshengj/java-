package operation;

import book.BookList;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:25
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);
    }
}
