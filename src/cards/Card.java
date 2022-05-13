package cards;

public class Card {
    protected CardType type;
    protected String CardName;

    public Card(CardType ctype, String name){
        type = ctype;
        CardName = name;
    }

    public CardType getType(){return type;}
    public String getName(){return CardName;}
}