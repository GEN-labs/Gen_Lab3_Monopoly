public class GoToJailSquare extends Square {

    final JailSquare jail;

    public GoToJailSquare(int id, JailSquare jail) {
        super(id, "GoToJail");
        this.jail = jail;
    }
    @Override
    public void landOn(Player p) {
        System.out.println("Il se trouve maintenant en prison");
        p.getPiece().setLocation(jail);
    }
}
