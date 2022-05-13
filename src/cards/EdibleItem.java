package cards;

public class EdibleItem extends Card {
    protected int flavourPoints;
    public EdibleItem(CardType ctype, String name) {
        super(ctype, name);        
    }
    public int getFlavourPoints() {
        if ("Porcini".equals(getName())) { flavourPoints=3;}
        else if ("Shiitake".equals(getName())) { flavourPoints=2;}
        else if ("TreeEar".equals(getName())) { flavourPoints=1;}
        else if ("HoneyFungus".equals(getName())) { flavourPoints=1;}
        else if ("LawyersWig".equals(getName())) { flavourPoints=2;}
        else if ("Morel".equals(getName())) { flavourPoints=6;}
        else if ("HenOfWoods".equals(getName())) { flavourPoints=3;}
        else if ("Chanterelle".equals(getName())) { flavourPoints=4;}
        else if ("BirchBolete".equals(getName())) { flavourPoints=3;}

        return flavourPoints;
    }   
}
