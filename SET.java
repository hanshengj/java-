package mapset;

import java.util.*;
public class TestDemo {

    /**
     * 找出10W个数据当中，第一个重复的数据
     * 思路：遍历list 拿到每个元素之后 存到set 注意，存储之前，需要看set中是否
     * 有这个数据？有 就说明找到了第一个重复的数据
     * @return
     */
    public static int findFirstRepeatNumber() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
        HashSet<Integer> set = new HashSet<>();
        //contatins
        for (int i = 0; i < 10_0000; i++) {
            if(!set.contains(list.get(i))) {
                set.add(list.get(i));
            }else {
                return list.get(i);
            }
        }
        return -1;
    }
    /**
     * 把10W个数据当中的重复的数据 去重
     * 思路：只需要把10W个数据放到集合当中
     * @return
     */
    public static Set<Integer> deputil() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(10_0000));
        }
       
        HashSet<Integer> set = new HashSet<>();
        //contatins
        /*for (int i = 0; i < 10_0000; i++) {
            set.add(list.get(i));//"巧合"
        }*/
        set.addAll(list);
        return set;
    }


 