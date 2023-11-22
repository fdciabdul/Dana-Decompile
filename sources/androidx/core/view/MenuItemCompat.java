package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenuItem;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public final class MenuItemCompat {

    @Deprecated
    /* loaded from: classes6.dex */
    public interface OnActionExpandListener {
        boolean BuiltInFictitiousFunctionClassFactory(MenuItem menuItem);

        boolean MyBillsEntityDataFactory(MenuItem menuItem);
    }

    public static MenuItem PlaceComponentResult(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).KClassImpl$Data$declaredNonStaticMembers$2(actionProvider);
        }
        InstrumentInjector.log_w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: androidx.core.view.MenuItemCompat$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements MenuItem.OnActionExpandListener {
        final /* synthetic */ OnActionExpandListener PlaceComponentResult;

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.PlaceComponentResult.MyBillsEntityDataFactory(menuItem);
        }
    }

    public static void MyBillsEntityDataFactory(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).MyBillsEntityDataFactory(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.BuiltInFictitiousFunctionClassFactory(menuItem, charSequence);
        }
    }

    public static void PlaceComponentResult(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).BuiltInFictitiousFunctionClassFactory(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    public static void PlaceComponentResult(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.MyBillsEntityDataFactory(menuItem, c, i);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.BuiltInFictitiousFunctionClassFactory(menuItem, c, i);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.BuiltInFictitiousFunctionClassFactory(menuItem, colorStateList);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.PlaceComponentResult(menuItem, mode);
        }
    }

    private MenuItemCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static MenuItem BuiltInFictitiousFunctionClassFactory(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        static MenuItem MyBillsEntityDataFactory(MenuItem menuItem, char c, int i) {
            return menuItem.setNumericShortcut(c, i);
        }

        static MenuItem BuiltInFictitiousFunctionClassFactory(MenuItem menuItem, char c, int i) {
            return menuItem.setAlphabeticShortcut(c, i);
        }

        static MenuItem BuiltInFictitiousFunctionClassFactory(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        static MenuItem PlaceComponentResult(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }
    }
}
