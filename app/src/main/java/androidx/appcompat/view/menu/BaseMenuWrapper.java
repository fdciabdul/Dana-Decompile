package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class BaseMenuWrapper {
    final Context BuiltInFictitiousFunctionClassFactory;
    private SimpleArrayMap<SupportMenuItem, MenuItem> KClassImpl$Data$declaredNonStaticMembers$2;
    private SimpleArrayMap<SupportSubMenu, SubMenu> PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMenuWrapper(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem MyBillsEntityDataFactory(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleArrayMap<>();
            }
            MenuItem menuItem2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(supportMenuItem);
            if (menuItem2 == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.BuiltInFictitiousFunctionClassFactory, supportMenuItem);
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(supportMenuItem, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu getAuthRequestContext(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new SimpleArrayMap<>();
            }
            SubMenu subMenu2 = this.PlaceComponentResult.get(supportSubMenu);
            if (subMenu2 == null) {
                SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.BuiltInFictitiousFunctionClassFactory, supportSubMenu);
                this.PlaceComponentResult.put(supportSubMenu, subMenuWrapperICS);
                return subMenuWrapperICS;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.PlaceComponentResult;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
            if (((SupportMenuItem) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2 << 1]).getGroupId() == i) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i2);
                i2--;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i2++) {
            if (((SupportMenuItem) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[i2 << 1]).getItemId() == i) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i2);
                return;
            }
        }
    }
}
