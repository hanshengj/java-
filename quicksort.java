//快速排序
    //默认最左边的为选基准
    public static int pivot(int[] array, int start, int end) {
        int tmp = array[start];//将最基准放在临时变量里
        while (start < end) {
        //从右往左找比基准小的值
            while (start < end && array[end] >= tmp) {
                end--;
            }
            array[start] = array[end];
            //把找到的比基准小的数据赋值给start

          // 从左往右找比基准大的数据
            while (start < end && array[start] <= tmp) {
                start++;
            }
            //把比基准小的数据赋值给end
            array[end] = array[start];
        }
        //当start不小于end退出循环，将基准赋值给start.
        array[start] = tmp;
        return start;
    }


    public static void quick(int[] array, int low, int high) {
        if (low < high) {
        //这个之前进行优化
       /////medianOfThree(array,low,high);//三数取中法进行优化选基准
            int piv = pivot(array, low, high);
            quick(array, low, piv - 1);
            quick(array, piv + 1, high);
        }
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    //优化三数取中法，
    public static void medianOfThree(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        //array[mid] <= array[low] <= array[end]
        if (array[low] < array[mid]) {
            swap(array, low, mid);
        }//array[mid] <= array[low]
        if (array[low] > array[high]) {
            swap(array, low, high);
        }//array[low] <= array[high]
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }//array[mid] <= array[high]
    }
    //交换

    public static void swap(int[] array, int k, int i) {
        int tmp = array[k];
        array[k] = array[i];
        array[i] = tmp;
    }