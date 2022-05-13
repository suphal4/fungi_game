package board;
import java.io.*;
import java.util.*;
import cards.*;
public class Board{
    private static CardPile forestCardsPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    public static void initialisePiles() {
        forestCardsPile = new CardPile();
        forest = new CardList();
        decayPile = new ArrayList<Card>();
    } 
    public static void setUpCards() {
        Porcini Por_D= new Porcini(CardType.DAYMUSHROOM);
        Shiitake Shi_D= new Shiitake(CardType.DAYMUSHROOM);
        TreeEar Tre_D= new TreeEar(CardType.DAYMUSHROOM);
        HoneyFungus Hon_D= new HoneyFungus(CardType.DAYMUSHROOM);
        LawyersWig Law_D= new LawyersWig(CardType.DAYMUSHROOM);
        Morel Mor_D= new Morel(CardType.DAYMUSHROOM);
        HenOfWoods Hen_D= new HenOfWoods(CardType.DAYMUSHROOM);
        Chanterelle Cha_D= new Chanterelle(CardType.DAYMUSHROOM);
        BirchBolete Bir_D= new BirchBolete(CardType.DAYMUSHROOM);

        Porcini Por_N= new Porcini(CardType.NIGHTMUSHROOM);
        Shiitake Shi_N= new Shiitake(CardType.NIGHTMUSHROOM);
        TreeEar Tre_N= new TreeEar(CardType.NIGHTMUSHROOM);
        HoneyFungus Hon_N= new HoneyFungus(CardType.NIGHTMUSHROOM);
        LawyersWig Law_N= new LawyersWig(CardType.NIGHTMUSHROOM);
        HenOfWoods Hen_N= new HenOfWoods(CardType.NIGHTMUSHROOM);
        Chanterelle Cha_N= new Chanterelle(CardType.NIGHTMUSHROOM);
        BirchBolete Bir_N= new BirchBolete(CardType.NIGHTMUSHROOM);

        Stick Sti= new Stick();
        Basket Bas= new Basket();
        
        Butter But= new Butter();
        Pan P_= new Pan();
        Cider Cid= new Cider();

        forestCardsPile.addCard(Por_N);
        forestCardsPile.addCard(Shi_N);
        forestCardsPile.addCard(Tre_N);
        forestCardsPile.addCard(Hon_N);
        forestCardsPile.addCard(Law_N);
        forestCardsPile.addCard(Hen_N);
        forestCardsPile.addCard(Cha_N);
        forestCardsPile.addCard(Bir_N);
        
        for (int i=0; i<=5; i++){
            forestCardsPile.addCard(Law_D);
        }
        for (int i=0; i<=4; i++){
            forestCardsPile.addCard(Shi_D);
            forestCardsPile.addCard(Hen_D);
            forestCardsPile.addCard(Bas);
        }
        for (int i=0; i<=3; i++){
            forestCardsPile.addCard(Bir_D);
            forestCardsPile.addCard(Por_D);
            forestCardsPile.addCard(Cha_D);
        }
        for (int i=0; i<=2; i++){
            forestCardsPile.addCard(Mor_D);
            forestCardsPile.addCard(But);
            forestCardsPile.addCard(Cid);
        }
        for (int i=0; i<=9; i++){
            forestCardsPile.addCard(Hon_D);
        }
        for (int i=0; i<=7; i++){
            forestCardsPile.addCard(Tre_D);
        }
        for (int i=0; i<=10; i++){
            forestCardsPile.addCard(P_);
        }

    }
    public static CardPile getForestCardsPile() {
        return forestCardsPile;        
    }
    public static CardList getForest() {
        return forest;        
    }
    public static ArrayList<Card> getDecayPile() {
        return decayPile;        
    }
    public static void updateDecayPile() {
        if (decayPile.size() == 4){
            decayPile.clear();
        }
        if (getForest().getElementAt(7)!= null){
            decayPile.add(getForest().getElementAt(7));
            forest.removeCardAt(1);
        } 
        else{
            decayPile.add(getForest().getElementAt(6));
            forest.removeCardAt(2);
        }
        
    }
}

