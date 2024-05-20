package module3.c2;

public class Arrays {
    public static void main(String[] args) {
        int[] myArray = {57,81,92,10};

        float sum =0;
        for(int i=0; i< myArray.length;i++){
            sum+=myArray[i];
        }
        float avg;
        avg = sum/myArray.length;

        System.out.println("Average of values is "+avg);

    }

}
