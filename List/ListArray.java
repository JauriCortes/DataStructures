package List;

public class ListArray {
    int N = 5; 
    int count, position, larray[];

    ListArray() {
        count = position = 0;
        larray = new int[N];
    }

    public boolean empty() {
        return (count <= 0);
    }
    public boolean full() {
        return (count >= N);
    }

    public boolean insert(int item) {
        boolean inserted = false;
        if(!full()) {
            if(!search(item)) {

                for(int j = count; j>position; j--){
                    larray[j] = larray[j-1];
                }

                larray[position] = item;
                count++;
                inserted = true;
            }
        }
        else {
            System.out.println("List is full");
        }
        return inserted;
    }

    public boolean delete(int item) {
        boolean deleted = false;
        if(!empty()) {
            if(search(item)){
                for (int j = position; j<count; j++){
                    larray[j] = larray[j+1];
                }
                count--;
                deleted = true;
            }
        }
        else {
            System.out.println("List is empty");
        }
        return deleted;
    }

    public boolean search (int item) {
        boolean found = false; 
        boolean stop = false;
        position = 0;
        while(position < count && !stop ) {
            if(larray[position] >= item){
                stop = true;
                if(larray[position] == item) {
                    found = true;
                }
            }
            else {
                position++;
            }
        }
        return found;
    }
}
