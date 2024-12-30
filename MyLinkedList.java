public class MyLinkedList extends MyAbstractList {
    private Node head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            return node.payload;
        }
        return null; // Nếu không tìm thấy phần tử, trả về null
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (head == null) return; // Danh sách rỗng

        if (index == 0) { // Xóa phần tử đầu tiên
            head = head.next;
            return;
        }

        Node prev = getNodeByIndex(index - 1);
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        Node newNode = new Node(payload);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        if (index == 0) {
            head = new Node(payload, head);
            return;
        }

        Node prev = getNodeByIndex(index - 1);
        if (prev != null) {
            prev.next = new Node(payload, prev.next);
        }
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(0);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            currentPosition = position;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return getNodeByIndex(currentPosition) != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Number next() {
            Node current = getNodeByIndex(currentPosition);
            currentPosition++;
            return current != null ? current.payload : null;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(currentPosition);
        }
    }
}
