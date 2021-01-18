package user;

import book.BookList;
import operation.IOperation;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:22
 */
abstract public class User {
    public String name;
    public IOperation[] operations;

    public User(String name) {
        this.name = name;
    }
    public abstract  int menu();
    public void doOperation(int choice, BookList bookList){
        this.operations[choice].work(bookList);
    }
}
