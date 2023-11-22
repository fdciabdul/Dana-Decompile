package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;

/* loaded from: classes8.dex */
public abstract class MenuItemActionViewExpandEvent extends MenuItemActionViewEvent {
    public static MenuItemActionViewExpandEvent create(MenuItem menuItem) {
        return new AutoValue_MenuItemActionViewExpandEvent(menuItem);
    }
}
