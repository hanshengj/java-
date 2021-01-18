package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:27
 */
public class BorrowOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要借阅书籍的名字");
        String name=sc.nextLine();
        for(int i=0;i<bookList.getUsedSize();i++){
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                book.setStatus(true);
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有要借阅的书");
    }
}
