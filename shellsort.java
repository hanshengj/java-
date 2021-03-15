public static void shell(int[] array ,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j = j-gap) {
            
                //如果这里是一个大于等于号 此时这个
                //排序就不稳定了
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};//增量数组,都选素数
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }