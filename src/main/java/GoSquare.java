public class GoSquare extends Square {

    public GoSquare(int id, String name) {
        super(id, name);
    }

    @Override
    public void landOn(Player p){
        try {
            p.addCash(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
