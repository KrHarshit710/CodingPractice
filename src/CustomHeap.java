public class CustomHeap {

    private int MAX_SIZE = 100;

    private int NO_OF_ELEMENTS = 0;

    private int[] arr;
    CustomHeap(int size){
        MAX_SIZE = size;
        arr = new int[MAX_SIZE];
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private void swap(int[] arr, int i, int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public void insert(int item){
        int i = NO_OF_ELEMENTS;
        arr[i] = item;
        NO_OF_ELEMENTS++;

        while(i>0){
            if(arr[i] < arr[parent(i)]){
                swap(arr,i,parent(i));
                i = parent(i);
            }else {
                break;
            }
        }
    }

    public void deleteMin(){
        swap(arr,0,NO_OF_ELEMENTS-1);
        NO_OF_ELEMENTS--;

        int i=0;
        while(2*i+1 < NO_OF_ELEMENTS){
            int smallest = i;
            if(2*i+1<NO_OF_ELEMENTS && arr[2*i+1]<arr[smallest])
                smallest = 2*i+1;
            if(2*i+2<NO_OF_ELEMENTS && arr[2*i+2]<arr[smallest])
                smallest = 2*i+2;

            if(i != smallest) {
                swap(arr, i, smallest);
                i = smallest;
            }else {
                break;
            }
        }
    }

    public int getMin(){
        return arr[0];
    }

    public static void main(String[] args) {
        CustomHeap minHeap = new CustomHeap(10);

        minHeap.insert(10);

        System.out.println(minHeap.getMin()); // 10

        minHeap.insert(20);

        System.out.println(minHeap.getMin()); // 10

        minHeap.insert(-4);

        System.out.println(minHeap.getMin()); // -4

        minHeap.insert(1);

        System.out.println(minHeap.getMin()); // -4

        minHeap.insert(4);

        System.out.println(minHeap.getMin()); // -4

        minHeap.deleteMin();

        System.out.println(minHeap.getMin()); // 1

        minHeap.deleteMin();

        System.out.println(minHeap.getMin()); // 4

        minHeap.deleteMin();

        System.out.println(minHeap.getMin()); // 10

        minHeap.insert(12);

        System.out.println(minHeap.getMin()); //10

        minHeap.deleteMin();

        System.out.println(minHeap.getMin()); // 12
    }
}
