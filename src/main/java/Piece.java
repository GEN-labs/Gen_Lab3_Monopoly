public class Piece {

    private String name;
    private Square location;

     public Piece(String name, Square startSquare){
         this.name = name;
         this.location = startSquare;
    }

    String getName(){
         return name;
    }

    public Square getLocation(){
         return location;
    }

    public void setLocation(Square newLoc){
         this.location =  newLoc;
    }
}
