package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:24
 */
public  class AddOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("添加图书");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入图书的名字");
        String name=sc.nextLine();
        System.out.println("请输入图书的作者");
        String author=sc.nextLine();
        System.out.println("请输入图书的价格");
        int price=sc.nextInt();
        System.out.println("请输入图书的类型");
        String type=sc.next();
        Book book=new Book(name,author,price,type);
        int index=bookList.getUsedSize();
        bookList.setBooks(index,book);
        bookList.setUsedSize(index+1);
    }
}
