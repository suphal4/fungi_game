package board;
import cards.*;
public interface Displayable {
    public abstract void add(Card cd_);

    public abstract int size();

    public abstract Card getElementAt(int n);

    public abstract Card removeElement(int n);
}