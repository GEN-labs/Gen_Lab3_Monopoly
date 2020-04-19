public class IncomeTaxSquare extends Square {

    final static int reducePercent = 10;
    final static int reduceMin = 200;

    public IncomeTaxSquare(int id) {
        super(id, "IncomeTaxSquare");
    }

    @Override
    public void landOn(Player p) {
        int netWorth = p.getNetWorth();
        //Recuce cash of player of 10% of is networth
        p.reduceCash(Math.min(IncomeTaxSquare.reduceMin, (netWorth / 100) * IncomeTaxSquare.reducePercent));

    }
}
