package board;
import java.io.*;
import java.util.*;
import cards.*;
public class Player extends Board{
    private static Hand h;
    private static Display d;
    private static int score;
    private static int handlimit;
    private static int sticks;
    public Player() {
        h = new Hand();
        d = new Display();
        score = 0;
        handlimit = 8;
        sticks = 0;
        d.add(new Pan());
    }
    public int getScore() {
        return score;        
    }
    public int getHandLimit() {
        for (int i=0;i<h.size();i++){

            if (h.getElementAt(i).getType().equals(CardType.BASKET)){
                    d.add(new Basket());
                    handlimit = handlimit + 2;
                    h.removeElement(i);
            }         
               
        }
        return handlimit;
    }
    public int getStickNumber() {
        return sticks;
    }
    public void addSticks(int stcks) {
        this.sticks = this.sticks + stcks;
        d.add(new Stick());
    }
    public void removeSticks(int stcks) {
        sticks = sticks - stcks;
        int a = 0;
        for (int i=0; i<d.size();i++){
            if (d.getElementAt(i).getType().equals(CardType.STICK)){
                d.removeElement(i);
                a=a+1;
                if (a==stcks);
                    break;
            }
        }
    }
    public Hand getHand() {
        return h;
    }
    public Display getDisplay() {
        return d;
    }
    public void addCardtoHand(Card crd) {
         h.add(crd);
    }
    public void addCardtoDisplay(Card crd) {
        d.add(crd);
    }
    public boolean takeCardFromTheForest(int x) 
{
if (h.size()==handlimit && ((getForest().getElementAt(8-x).getType())!=(CardType.BASKET) || (getForest().getElementAt(8-x).getType())!=(CardType.STICK))){
            return false;
        }
        if ((x>2 && x<=8) && getStickNumber()>=(x-2) ){
//               Card card=getForest().removeCardAt(8-x);
            if (getForest().getElementAt(8-x).getType()==(CardType.BASKET)){
                addCardtoHand(getForest().removeCardAt(8-x));
                getHandLimit();
                removeSticks(x-2);
                return true;
            }
            
 
            else if (getForest().getElementAt(8-x).getType()==(CardType.STICK)){
                addSticks(1);
                getForest().removeCardAt(8-x);
                removeSticks(x-2);
                return true;
            }
            else if (h.size()<handlimit){
                addCardtoHand(getForest().removeCardAt(8-x));
                removeSticks(x-2);
                return true;
            }
            else{
                return false;
            }
        }
        else if ( x == 2 || x==1){
            if (getForest().getElementAt(8-x).getType()==(CardType.BASKET)){
                addCardtoHand(getForest().removeCardAt(8-x));
                getHandLimit();
                return true;
            }

 
            else if (getForest().getElementAt(8-x).getType()==(CardType.STICK)){
                addSticks(1);
                getForest().removeCardAt(8-x);
                return true;
            }
            else if (h.size()<handlimit){
                addCardtoHand(getForest().removeCardAt(8-x));
                return true;
            }
            else{
                return false;
            }
        }

        return false;
    }
//    {
//
//     if ((handlimit-h.size())>0)
//        {
//           if(x<=2)
//            {
//                Card card= Board.getForest().removeCardAt(x);
//                if(card.getType()==CardType.BASKET)
//                {
//                    addCardtoDisplay(card);
//                    getHandLimit();
//                }
//                else{addCardtoHand(card);}
//                return true;
//            }
//            else if (x<=8)
//            {
//                if (sticks>=x-2)
//                {   
//                    Card card=Board.getForest().removeCardAt(x);
//                    if (card.getType()==CardType.BASKET)
//                     {
//                        addCardtoDisplay(card);
//                        getHandLimit();
//                        removeSticks(x-2);
//                        }
//                    else
//                    {
//                        addCardtoHand(card);
//                        removeSticks(x-2);
//                    }
//                    return true;
//                }
//                else
//                   return false;
//                
//            }
//        }
//         return false;
//
//    }

    public boolean takeFromDecay() {
        
        getHandLimit();
        getHandLimit();
        getHandLimit();

        if (getDecayPile().size()>0 && getDecayPile().size()<=4 ){
            int x=0;
            for (int i=0; i<getDecayPile().size();i++){
                if (getDecayPile().get(i).getType().equals(CardType.BASKET)){
                    x=x+1;
                }
            }
            if (h.size()+getDecayPile().size() -x <=(handlimit + x*2)){
                for (int i=0; i < getDecayPile().size();i++)
                {
                    Card card=getDecayPile().get(i);
                    if (getDecayPile().get(i).getType().equals(CardType.STICK)){
                        
                        addCardtoDisplay(card);

                    }
                    else{
                        addCardtoHand(card);
                        getHandLimit();
                    }
                }        
                return true;    
            }
            else{
                return false;
            }
        }

        return false;
    
    }
    public boolean cookMushrooms(ArrayList<Card> A_L) {
        boolean p_an=false;
        boolean paninhand=false;
        String nameOfMush="";
        int x=0;
        int b_ut=0;
        int c_id=0;
        for (int i=0; i<A_L.size();i++){
            if (A_L.get(i).getType().equals(CardType.BASKET) || A_L.get(i).getType().equals(CardType.STICK)){
                return false;
            }
        }
        for (int i=0; i<A_L.size();i++){
            if (A_L.get(i).getType().equals(CardType.PAN)){
                p_an=true;
                paninhand=true;
            }
        }
        if(!p_an){
            for (int i=0; i<d.size();i++){
                if (getDisplay().getElementAt(i).getType().equals(CardType.PAN)){
                    p_an=true;
                    break;
                }
            }
        }
        if (p_an){
            for (int i=0; i<A_L.size();i++){
                if (A_L.get(i).getType().equals(CardType.CIDER)){c_id=c_id+1;}
                else if (A_L.get(i).getType().equals(CardType.BUTTER)){b_ut=b_ut+1;}
            }        
            for (int i=0; i<A_L.size();i++){
                if (A_L.get(i).getType().equals(CardType.DAYMUSHROOM)||A_L.get(i).getType().equals(CardType.NIGHTMUSHROOM)){
                    if (A_L.get(i).getType().equals(CardType.DAYMUSHROOM)){x=x+1;}
                    else if (A_L.get(i).getType().equals(CardType.NIGHTMUSHROOM)){x=x+2;}
                    nameOfMush= A_L.get(i).getName();
                    for (int j=i+1; j<A_L.size();j++){
                        if (A_L.get(j).getType().equals(CardType.DAYMUSHROOM)||A_L.get(j).getType().equals(CardType.NIGHTMUSHROOM)){
                            if (A_L.get(i).getName() != A_L.get(j).getName())
                            {
                                return false;
                            }
                        }
                        if (A_L.get(j).getType().equals(CardType.DAYMUSHROOM)){x=x+1;}
                        else if (A_L.get(j).getType().equals(CardType.NIGHTMUSHROOM)){x=x+2;}
                    }
                    break;

                }
            }
            if (x<3){return false;}
            else if (x < c_id*5 + b_ut*4){return false;}
            else{
                if ("Porcini".equals(nameOfMush)) { score= score + x*3 + c_id*5 + b_ut*3;}
                else if ("Shiitake".equals(nameOfMush)) { score= score + x*2 + c_id*5 + b_ut*3;}
                else if ("TreeEar".equals(nameOfMush)) { score= score + x*1 + c_id*5 + b_ut*3;}
                else if ("HoneyFungus".equals(nameOfMush)) { score= score + x*1 + c_id*5 + b_ut*3;}
                else if ("LawyersWig".equals(nameOfMush)) { score= score + x*2 + c_id*5 + b_ut*3;}
                else if ("Morel".equals(nameOfMush)) { score= score + x*6 + c_id*5 + b_ut*3;}
                else if ("HenOfWoods".equals(nameOfMush)) { score= score + x*3 + c_id*5 + b_ut*3;}
                else if ("Chanterelle".equals(nameOfMush)) { score= score + x*4 + c_id*5 + b_ut*3;}
                else if ("BirchBolete".equals(nameOfMush)) { score= score + x*3 + c_id*5 + b_ut*3;}
                for (int i=0;i<A_L.size();i++) {

                    for (int j=0; j<h.size();j++){
                        if (A_L.get(i).getType().equals(h.getElementAt(j).getType()) && A_L.get(i).getName().equals(h.getElementAt(j).getName())){
                            getHand().removeElement(i);
                            break;
                        }
                    }
                } 
                if (!paninhand){
                    for (int i=0; i<d.size();i++){
                        if (getDisplay().getElementAt(i).getType().equals(CardType.PAN)){
                            getDisplay().removeElement(i);
                            break;
                        }
                    }                
                }



                return true;

            }
        
        
    }
    return false;
    }

    public boolean sellMushrooms(String str, int s_M) {
        if (s_M<2){return false;}
        String card_name=str.toLowerCase();
        boolean pass=false; 
        boolean pass1st=false;       
        card_name=str.replaceAll(" ", "");
        card_name=str.replaceAll("\\s", "");
        if (card_name.equals("honeyfungus")){
            card_name="HoneyFungus";
            pass=true;
        }
        else if (card_name.equals("honey fungus")){
            card_name="HoneyFungus";
            pass=true;
        }
        else if (card_name.equals("birchbolete")){
            card_name="BirchBolete";
            pass=true;
        }
        else if (card_name.equals("birch bolete")){
            card_name="BirchBolete";
            pass=true;
        }
        else if (card_name.equals("chanterelle")){
            card_name="Chanterelle";
            pass=true;
        }
        else if (card_name.equals("henofwoods")){
            card_name="HenOfWoods";
            pass=true;
        }
        else if (card_name.equals("hen of woods")){
            card_name="HenOfWoods";
            pass=true;
        }
        else if (card_name.equals("lawyerswig")){
            card_name="LawyersWig";
            pass=true;
        }
        else if (card_name.equals("lawyers wig")){
            card_name="LawyersWig";
            pass=true;
        }
        else if (card_name.equals("morel")){
            card_name="Morel";
            pass=true;
        }
        else if (card_name.equals("porcini")){
            card_name="Porcini";
            pass=true;
        }
        else if (card_name.equals("shiitake")){
            card_name="Shiitake";
            pass=true;
        }
        else if (card_name.equals("treeear")){
            card_name="TreeEar";
            pass=true;
        }
        else if (card_name.equals("tree ear")){
            card_name="TreeEar";
            pass=true;
        }
        else{
            return false;
        }
        
        for (int i=0;i<h.size();i++){
                if ((getHand().getElementAt(i).getName()).equals(card_name)){
                    pass1st=true;
                }
        }
        if (!pass1st){
            return false;
        }       
        if (pass){
            int c=0;
            for (int i=0;i<h.size();i++){
                if (getHand().getElementAt(i).getName().equals(card_name)){ 
                    if (getHand().getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM)){
                        c=c+2;
                    }
                    else{
                        c=c+1;
                    }
                }                
            }
            int totalm=s_M;

            if ("Porcini".equals(card_name)) { sticks= sticks + totalm*3;}
            else if ("Shiitake".equals(card_name)) { sticks= sticks + totalm*2 ;}
            else if ("TreeEar".equals(card_name)) { sticks= sticks + totalm*2 ;}
            else if ("HoneyFungus".equals(card_name)) { sticks= sticks + totalm*1 ;}
            else if ("LawyersWig".equals(card_name)) { sticks= sticks + totalm*1 ;}
            else if ("Morel".equals(card_name)) { sticks= sticks + totalm*4 ;}
            else if ("HenOfWoods".equals(card_name)) { sticks= sticks + totalm*1 ;}
            else if ("Chanterelle".equals(card_name)) { sticks= sticks + totalm*2 ;}
            else if ("BirchBolete".equals(card_name)) { sticks= sticks + totalm*2 ;}
            int bsdk=s_M;
            for (int i=0;i<bsdk;i++){
                for (int j=0;j<h.size();j++){
                    if (getHand().getElementAt(j).getName().equals(card_name) && getHand().getElementAt(j).getType().equals(CardType.NIGHTMUSHROOM)){
                        h.removeElement(j);
                        s_M=s_M-2;
                        if (s_M==0){
                            return true;   
                        }
                        break;                        
                    }
                }
                for (int j=0;j<h.size();j++){
                    if (getHand().getElementAt(j).getName().equals(card_name) && getHand().getElementAt(j).getType().equals(CardType.DAYMUSHROOM)){
                        h.removeElement(j);
                        s_M=s_M-1;
                        if (s_M==0){
                            return true;     
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
    public boolean putPanDown() {
        for (int i=0;i<h.size();i++){
            if (getHand().getElementAt(i).getType().equals(CardType.PAN)){
                getHand().removeElement(i);
                addCardtoDisplay(new Pan());
                return true;
            }
        }
        return false;
    }
}

