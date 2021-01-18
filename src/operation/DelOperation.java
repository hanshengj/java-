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
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("输入你要删除的书名");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        int i=0;
        for(;i<bookList.getUsedSize();i++){
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i>=bookList.getUsedSize()){
            System.out.println("没有要删除的书");
             return;
        }
        for(int j=i;j<bookList.getUsedSize()-1;j++){
            Book book=bookList.getBooks(j+1);
            bookList.setBooks(j,book);
        }
        int curUsedSize=bookList.getUsedSize();
        bookList.setUsedSize(curUsedSize-1);
        System.out.println("删除完毕");
    }
}
