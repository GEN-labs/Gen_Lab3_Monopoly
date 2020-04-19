public class Cup {

    private Dice[] dices;
    private int totalValue;
    public Cup(Dice[] dices){
        this.dices = dices;
    }

    public void roll(){
        totalValue = 0;
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
            totalValue += dices[i].getFaceValue();
        }
    }

    public int getTotal(){
        return totalValue;
    }



}
