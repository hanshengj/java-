/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-29
 * Time: 12:21
 */
public class java20201229 {

    public static void main(String[] args) {
        int[] arr2 = createArray();
        for (int k=0;k<arr2.length;k++){
            if(k%10==0){
                System.out.println();
            }
            System.out.print(arr2[k] + " ");
        }

    }
    public static int [] createArray(){
       int []arr = new int [100];
       for (int i= 0;i < 100;i++){
           arr[i] = i+1;
       }
       return arr;
    }
    public static void printArray(int []array){
        for (int j=0; j< array.length;j++){
            System.out.print(array[j] + " ");
        }
    }
    public static int[] transForm(int []array){
        int [] arr = new int[array.length];
        for ( int i =0;i <array.length;i++){
            arr[i]= 2*array[i];
        }
        return arr;
    }
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double avg(int[] array) {
        double average = 0.0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = (double) sum / array.length;
        return average;
    }

}

