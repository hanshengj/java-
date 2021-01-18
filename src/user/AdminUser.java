package user;

import operation.*;

import java.util.Scanner;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-18
 * Time: 16:23
 */
public class AdminUser extends User{
    public AdminUser(String name) {
        super(name);
        this.operations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("hellow" + this.name +"欢迎来到图书管理系统");
        System.out.println("0->--------------退出系统");
        System.out.println("1->--------------查找图书");
        System.out.println("2->--------------增加图书");
        System.out.println("3->--------------删除图书");
        System.out.println("4->--------------显示图书");
        System.out.println("-----------------------");
        int choice = sc.nextInt();
        return choice;
    }
}
