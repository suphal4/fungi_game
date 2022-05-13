package cards;

public class Mushroom extends EdibleItem {
    protected int sticksPerMushroom;
    public Mushroom(CardType ctype, String name) {
        super(ctype, name);        
    }
    public int getSticksPerMushroom() {
        if ("Porcini".equals(getName())) { sticksPerMushroom=3;}
        else if ("Shiitake".equals(getName())) { sticksPerMushroom=2;}
        else if ("TreeEar".equals(getName())) { sticksPerMushroom=2;}
        else if ("HoneyFungus".equals(getName())) { sticksPerMushroom=1;}
        else if ("LawyersWig".equals(getName())) { sticksPerMushroom=1;}
        else if ("Morel".equals(getName())) { sticksPerMushroom=4;}
        else if ("HenOfWoods".equals(getName())) { sticksPerMushroom=1;}
        else if ("Chanterelle".equals(getName())) { sticksPerMushroom=2;}
        else if ("BirchBolete".equals(getName())) { sticksPerMushroom=2;}

        return sticksPerMushroom;
    }   
}
