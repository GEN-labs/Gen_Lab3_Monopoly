public class GoToJailSquare extends Square {

    final JailSquare jail;

    public GoToJailSquare(int id, JailSquare jail) {
        super(id, "GoToJail");
        this.jail = jail;
    }
    @Override
    public void landOn(Player p) {
        p.getPiece().setLocation(jail);
    }
}
