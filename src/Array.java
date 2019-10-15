public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
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
    public void addLast(E e){
        if(size == data.length)
            throw new IllegalArgumentException("AddLast fail, Array is full");
//        data[size] = e;
//        size++;

        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
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
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if(size == data.length) {
            resize(size*2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Delete failed. Index is illegal.");

        E res = data[index];
        for(int i = index; i < size - 1 ; i++) {
            data[i] = data[i+1];
        }

        size--;
        data[size] = null;

        if(size == data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return res;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return  remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
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

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
