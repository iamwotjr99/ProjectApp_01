package org.techtown.chattingapp_01;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;

    public ListViewItem(String title) { }

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) { titleStr = title; }
    public Drawable getIcon() {
        return iconDrawable;
    }
    public String getTitle() {
        return titleStr;
    }
}
