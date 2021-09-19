public class BinarySearch {
    private int mid;

    public int search(int[] data, int value, int start, int end) throws Exception, StackOverflowError{
        mid = (start + end)/2;
        if(start == end && data[start] == value)
            return start;
        else if(start == end && data[start] != value || start == mid && data[start] != value && data[data.length-1] != value)
            return data[data.length];

        if(data[mid] == value)
            return mid;
        else if(value > data[mid]){
            start = mid + 1;
            search(data, value, start, end);
        }else{
            end = mid;
            search(data, value, start, end);
        }
        return mid;
    }
}