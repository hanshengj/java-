 public static void func() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);
        //遍历list 每次拿list当中的数据作为map的key
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i);
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer number = map.get(key);
                map.put(key,number+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        }
    }
