package board;
import java.io.*;
import java.util.*;
import cards.*;
public class Hand implements Displayable{
    private  ArrayList<Card> handList;
    public Hand() {
        handList = new ArrayList<Card>();
        
    }
    public void add(Card card) {
        handList.add(card);
    }
    public int size() {
        return handList.size();
    }
    public Card getElementAt(int position){
        return handList.get(position);
    }
    public Card removeElement(int position) {
        return handList.remove(position);
    }
}