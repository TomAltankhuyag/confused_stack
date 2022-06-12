public class List{
    
    class Node{
        public Node next;
        public String data;
        int index = 1;
        public Node(){

        }
        public Node(String s){
            data = s;
        }
        public String getData(){
            return data;
        }
    }
    Node head;
    public boolean check666 = false;

     public List(){

    }

    public void add(String s){
        if(head == null){
            head = new Node(s);
        }else{
        Node temp = new Node(s);
        temp.index = head.index + 1;
        temp.next = head;
        head = temp;
        }
    }

    
    public int length(){
        Node temp = head;
        int i = 0;
        while(temp!=null){
            temp = temp.next;
            i++;
        }
        return i;
    }

    public String getData(int index){ //Returns data with the inputted index
        Node temp = head;
        if(index < 1){
            throw new IllegalArgumentException();
        }else if(index > this.length()){
            throw new IllegalArgumentException();
        }
        while(temp != null){
            if(temp.index == index){
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }


    public void printData(){ //This code is was strictly used to check all the data inside our list
        if(check666){
        for(int i = 1; i <= this.length(); i++){
            if(!this.getData(i).equals("666")){
                System.out.println(this.getData(i));
            }
            
        }
    }else{
        for(int i = 1; i <= this.length(); i++){
            System.out.println(this.getData(i));
        }
    }
    }
    

    public void sort(){

        Node temp = head;
        while(temp!=null){
            if(temp.data.equals("666")){
                check666 = true;
                break;
            }
            temp = temp.next;
        }
        
        if(check666){
            this.add("@");
            this.sortAscending();
        }else{
            this.sortDescending();
        }
        
    }

  public void sortAscending(){//method to sort the linked list in an ascending order

        for(int i = this.length() + 1 ; i > 0; i--){ 
            for(int j = 1; j < this.length()  ; j++){
            if(this.getFloat(j) > this.getFloat(j+1)) {
                this.setNewIndex(j,999);
                this.setNewIndex(j+1,j);
                this.setNewIndex(999,j+1);
            }
        }
    }
}

  public void sortDescending(){//method to sort the linked list in an descending order

    for(int i = this.length() + 1 ; i > 0; i--){ //since head.index is the length
        for(int j = 1; j < this.length()  ; j++){
        if(this.getFloat(j) < this.getFloat(j+1)) {
            this.setNewIndex(j,999);
            this.setNewIndex(j+1,j);
            this.setNewIndex(999,j+1);
        }
    }

    }

}
       

  
  public float getFloat(int index){//returns float value of the node containing the index
    //System.out.println("landmine");
      Node temp = head;
      if(index < 1){
        throw new IllegalArgumentException();
    }else if(index > this.length()){
        throw new IllegalArgumentException();
    }
      while(temp!=null){
          if (temp.index == index){
              if(this.isInteger(temp.data)){
                  return (float)this.toInteger(temp.data);
              }else{
                  return this.symbolToFloat(temp.data);
              }
          }
          temp = temp.next;
      }
      //System.out.println(index);
     throw new IndexOutOfBoundsException();
  }

  public void setNewIndex(int oldIndex, int newIndex){
      Node headOriginal = head;
      while(head!=null){
          if(head.index == oldIndex){
              head.index = newIndex;
              break;
          }
          head = head.next;
          
      }
      head = headOriginal;
  }

  public boolean isInteger(String s) {
      if(s.length() == 0){
          return false;
      }
    if(s.charAt(0) == '-' || s.charAt(0) == '+'){
        return false;
    } else if(s.charAt(0) == '0' && s.length() > 1){
        return false;
    }
    try {
        int d = Integer.parseInt(s);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

public int toInteger(String s){

return Integer.parseInt(s);

}

public boolean checkSymbol(String s){ //Method to check if the string is one of the special symbols
    if(s.equals("Do") || s.equals("Re") || s.equals("Mi")  || s.equals("&") || s.equals("@") || s.equals("%")|| s.equals("Asymbolwithareallylongname")
    || s.equals("$") ||s.equals("Fa") || s.equals("One" ) || s.equals("Two") || s.equals("Three")){
        return true;
    }else{
        return false;
    }
}
public float symbolToFloat(String s){
    if(s.equals("Do")){
        return 0.5f;
    }else if(s.equals("Re") ){
        return 100.5f;
    } else if(s.equals("Mi") ){
        return 1000.5f;
    } else if(s.equals("&")){
        return 3.5f ;
    }else if(s.equals("@")){
        return 3.2f;
    }else if(s.equals("%")){
        return 1005000.5f;
    }else if(s.equals("Asymbolwithareallylongname")){
        return 55.5f;
    }else if(s.equals("$") ){
        return 20.5f;
    }else if(s.equals("Fa") ){
        return 15.5f;
    }else if(s.equals("One" )){
        return 103.1f;
    }else if(s.equals("Two") ){
        return 103.5f;
    }else if(s.equals("Three") ){
        return 103.8f;
    }
    else{
        return 0f;
    }
}

}