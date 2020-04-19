public abstract class Square {

    private String name;
    private int id;

    public Square(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return this.id;
    }

    abstract public void landOn(Player p);

}
