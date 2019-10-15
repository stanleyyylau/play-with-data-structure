public class Array {

    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLast fail, Array is full");
//        data[size] = e;
//        size++;

        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLast fail, Array is full");
//        for (int i = 0; i < size; i++) {
//            data[i] = data[i+1];
//        }
//        data[0] = e;
//        size++;
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLast fail, Array is full");
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public int get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
