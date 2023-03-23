public class LinkedListJG {
    private Node head;

    public LinkedListJG(){

    }

    public void addNode(int data){
        Node newNode = new Node(data);
        // Check if head is null
        if(head == null){
            head = newNode;
        }
        else {
            // Look for null pointer
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            // We now know that the currentNode is point to null (end of the list)
            currentNode.setNext(newNode);
            newNode.setPrev(currentNode);
        }
    }

    public void addToHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            this.setHead(newNode);
        }
        else{
            newNode.setNext(head);
            this.setHead(newNode);
            newNode.getNext().setPrev(newNode);

        }
    }

    public void addToPos(int pos, int data){

        Node currentNode = head;
        Node newNode = new Node(data);
        // Check if pos is the head
        if(pos == 0){
            this.addToHead(data);
        }
        else {
            for (int i = 0; i < pos - 1; i++) {
                // Check if pos goes beyond of the list
                if(currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                else{
                    this.addNode(data);
                    break;
                }
            }

            if(currentNode.getNext() != null) {
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
                newNode.getNext().setPrev(newNode);
                newNode.setPrev(currentNode);
            }
        }
    }

    public void changeData(int data, int newData){
        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.getData() == data){
                currentNode.setData(newData);
            }
            else{
                currentNode = currentNode.getNext();
            }
        }
    }

    public void delete(int data){
        Node currentNode = head;
        if(currentNode.getData() == data){
            this.setHead(currentNode.getNext());
            head.setPrev(null);
            return;
        }
        currentNode = currentNode.getNext();
        while(currentNode.getNext() != null){
            if(currentNode.getData() == data){
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                break;
            }
            else{
                currentNode = currentNode.getNext();
            }
        }
        if(currentNode.getNext() == null && currentNode.getData() == data){
            currentNode.getPrev().setNext(null);
        }
    }

    public String reverseOutput(){
        String data = "";
        Node currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }

        while(currentNode.getPrev() != null){
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getPrev();
        }
        data = data + currentNode.getData();
        return data;
    }

    public String toString(){
        String data = "";
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();
        }
        data = data + currentNode.getData();
        return data;
    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }
}
