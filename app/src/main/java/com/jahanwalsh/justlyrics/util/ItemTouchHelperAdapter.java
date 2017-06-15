package com.jahanwalsh.justlyrics.util;

/**
 * Created by jahanwalsh on 6/13/17.
 */

public interface ItemTouchHelperAdapter {



    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
