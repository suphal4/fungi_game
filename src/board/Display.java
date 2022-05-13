package board;
import java.io.*;
import java.util.*;
import cards.*;
public class Display implements Displayable{
    private ArrayList<Card> displayList;
    public Display() {
        displayList = new ArrayList<Card>();
    }
        
   
    public void add(Card card) {
        displayList.add(card);
    }
    public int size() {
        return displayList.size();
    }
    public Card getElementAt(int position){
        return displayList.get(position);
    }
    public Card removeElement(int position) {
        return displayList.remove(position);
    }
}