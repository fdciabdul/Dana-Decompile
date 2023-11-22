package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;

/* loaded from: classes8.dex */
public abstract class MenuItemActionViewCollapseEvent extends MenuItemActionViewEvent {
    public static MenuItemActionViewCollapseEvent create(MenuItem menuItem) {
        return new AutoValue_MenuItemActionViewCollapseEvent(menuItem);
    }
}
