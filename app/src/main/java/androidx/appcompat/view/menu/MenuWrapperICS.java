package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes3.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu MyBillsEntityDataFactory;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.MyBillsEntityDataFactory = supportMenu;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.add(charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return getAuthRequestContext(this.MyBillsEntityDataFactory.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return getAuthRequestContext(this.MyBillsEntityDataFactory.addSubMenu(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return getAuthRequestContext(this.MyBillsEntityDataFactory.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return getAuthRequestContext(this.MyBillsEntityDataFactory.addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.MyBillsEntityDataFactory.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = MyBillsEntityDataFactory(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        BuiltInFictitiousFunctionClassFactory(i);
        this.MyBillsEntityDataFactory.removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        PlaceComponentResult(i);
        this.MyBillsEntityDataFactory.removeGroup(i);
    }

    @Override // android.view.Menu
    public void clear() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.MyBillsEntityDataFactory.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.MyBillsEntityDataFactory.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.MyBillsEntityDataFactory.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.MyBillsEntityDataFactory.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.findItem(i));
    }

    @Override // android.view.Menu
    public int size() {
        return this.MyBillsEntityDataFactory.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.getItem(i));
    }

    @Override // android.view.Menu
    public void close() {
        this.MyBillsEntityDataFactory.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.MyBillsEntityDataFactory.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.MyBillsEntityDataFactory.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.MyBillsEntityDataFactory.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.MyBillsEntityDataFactory.setQwertyMode(z);
    }
}
