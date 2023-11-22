package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.PlaceComponentResult = supportSubMenu;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        this.PlaceComponentResult.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.PlaceComponentResult.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        this.PlaceComponentResult.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.PlaceComponentResult.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.PlaceComponentResult.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.PlaceComponentResult.clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.PlaceComponentResult.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.PlaceComponentResult.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return MyBillsEntityDataFactory(this.PlaceComponentResult.getItem());
    }
}
