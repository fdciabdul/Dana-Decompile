package androidx.appcompat.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: classes3.dex */
public class PopupMenu {
    public final Context BuiltInFictitiousFunctionClassFactory;
    public OnMenuItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    OnDismissListener MyBillsEntityDataFactory;
    public final MenuBuilder PlaceComponentResult;
    private final View getAuthRequestContext;
    public final MenuPopupHelper mPopup;

    /* loaded from: classes3.dex */
    public interface OnDismissListener {
    }

    /* loaded from: classes3.dex */
    public interface OnMenuItemClickListener {
        boolean getAuthRequestContext(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, (byte) 0);
    }

    private PopupMenu(Context context, View view, byte b) {
        this(context, view, 0, R.attr.getValueOfTouchPositionAbsolute, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.PlaceComponentResult = menuBuilder;
        menuBuilder.setCallback(new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.PopupMenu.1
            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder2) {
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder2, MenuItem menuItem) {
                if (PopupMenu.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    return PopupMenu.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(menuItem);
                }
                return false;
            }
        });
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i2, i3);
        this.mPopup = menuPopupHelper;
        menuPopupHelper.MyBillsEntityDataFactory = i;
        menuPopupHelper.BuiltInFictitiousFunctionClassFactory = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.PopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (PopupMenu.this.MyBillsEntityDataFactory != null) {
                    OnDismissListener onDismissListener = PopupMenu.this.MyBillsEntityDataFactory;
                }
            }
        };
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 extends ForwardingListener {
        final /* synthetic */ PopupMenu MyBillsEntityDataFactory;

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean MyBillsEntityDataFactory() {
            if (this.MyBillsEntityDataFactory.mPopup.MyBillsEntityDataFactory()) {
                return true;
            }
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean BuiltInFictitiousFunctionClassFactory() {
            MenuPopupHelper menuPopupHelper = this.MyBillsEntityDataFactory.mPopup;
            if (menuPopupHelper.PlaceComponentResult()) {
                menuPopupHelper.mPopup.getAuthRequestContext();
                return true;
            }
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getAuthRequestContext() {
            MenuPopupHelper menuPopupHelper = this.MyBillsEntityDataFactory.mPopup;
            if (menuPopupHelper.mPopup == null) {
                menuPopupHelper.mPopup = menuPopupHelper.BuiltInFictitiousFunctionClassFactory();
            }
            return menuPopupHelper.mPopup;
        }
    }
}
