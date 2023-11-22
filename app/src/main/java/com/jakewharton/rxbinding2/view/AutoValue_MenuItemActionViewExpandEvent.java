package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;

/* loaded from: classes8.dex */
final class AutoValue_MenuItemActionViewExpandEvent extends MenuItemActionViewExpandEvent {
    private final MenuItem menuItem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_MenuItemActionViewExpandEvent(MenuItem menuItem) {
        if (menuItem == null) {
            throw new NullPointerException("Null menuItem");
        }
        this.menuItem = menuItem;
    }

    @Override // com.jakewharton.rxbinding2.view.MenuItemActionViewEvent
    public final MenuItem menuItem() {
        return this.menuItem;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MenuItemActionViewExpandEvent{menuItem=");
        sb.append(this.menuItem);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MenuItemActionViewExpandEvent) {
            return this.menuItem.equals(((MenuItemActionViewExpandEvent) obj).menuItem());
        }
        return false;
    }

    public final int hashCode() {
        return this.menuItem.hashCode() ^ 1000003;
    }
}
