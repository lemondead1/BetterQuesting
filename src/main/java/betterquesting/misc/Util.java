package betterquesting.misc;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Util {
  public static Iterable<Integer> closedOpenRange(int from, int to, boolean reverse) {
    return reverse ? () -> new Iterator<Integer>() {
      int curr = to - 1;

      @Override
      public boolean hasNext() {
        return curr >= from;
      }

      @Override
      public Integer next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return curr--;
      }
    } : () -> new Iterator<Integer>() {
      int curr = from;

      @Override
      public boolean hasNext() {
        return curr < to;
      }

      @Override
      public Integer next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return curr++;
      }
    };
  }

  public static int[] toIntArray(Collection<Integer> collection) {
    int i = 0;
    int[] aryAct = new int[collection.size()];
    for (Integer q : collection) {
      aryAct[i++] = q;
    }
    return aryAct;
  }
}
