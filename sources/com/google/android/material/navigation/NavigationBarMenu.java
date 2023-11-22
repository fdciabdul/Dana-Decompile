package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* loaded from: classes7.dex */
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    private final Class<?> viewClass;

    public NavigationBarMenu(Context context, Class<?> cls, int i) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.viewClass.getSimpleName());
        sb.append(" does not support submenus");
        throw new UnsupportedOperationException(sb.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > this.maxItemCount) {
            String simpleName = this.viewClass.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("Maximum number of items supported by ");
            sb.append(simpleName);
            sb.append(" is ");
            sb.append(this.maxItemCount);
            sb.append(". Limit can be checked with ");
            sb.append(simpleName);
            sb.append("#getMaxItemCount()");
            throw new IllegalArgumentException(sb.toString());
        }
        stopDispatchingItemsChanged();
        MenuItem addInternal = super.addInternal(i, i2, i3, charSequence);
        if (addInternal instanceof MenuItemImpl) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal;
            menuItemImpl.MyBillsEntityDataFactory = (menuItemImpl.MyBillsEntityDataFactory & (-5)) | 4;
        }
        startDispatchingItemsChanged();
        return addInternal;
    }
}
