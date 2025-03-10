public class Array{
    public static void main(String args[]){
        int array[]={2,3,4,5,6};
        int even,odd;
        for(int i=0 ; i<array.length ; i++){
            if (array[i]%2== 0){
                even =even+1;
            }
            else{
                odd =odd+1;
            }

        }
        System.out.println(even);
        System.out.println(odd);

    }
}