package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    public static Method getAuthRequestContext;
    public MenuItemHoverListener KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                getAuthRequestContext = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            InstrumentInjector.log_i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, int i, int i2) {
        super(context, null, i, i2);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    DropDownListView BuiltInFictitiousFunctionClassFactory(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public final void PlaceComponentResult(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.PlaceComponentResult(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public final void BuiltInFictitiousFunctionClassFactory(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.BuiltInFictitiousFunctionClassFactory(menuBuilder, menuItem);
        }
    }

    /* loaded from: classes.dex */
    public static class MenuDropDownListView extends DropDownListView {
        private MenuItem BuiltInFictitiousFunctionClassFactory;
        private MenuItemHoverListener KClassImpl$Data$declaredNonStaticMembers$2;
        final int mAdvanceKey;
        final int mRetreatKey;

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i, boolean z) {
            return super.lookForSelectablePosition(i, z);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
            return super.measureHeightOfChildrenCompat(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            return super.onForwardedEvent(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.mAdvanceKey = 21;
                this.mRetreatKey = 22;
                return;
            }
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = menuItemHoverListener;
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            MenuAdapter menuAdapter;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.mAdvanceKey) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.mRetreatKey) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                }
                menuAdapter.BuiltInFictitiousFunctionClassFactory.close(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            MenuAdapter menuAdapter;
            int pointToPosition;
            int i2;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                MenuItemImpl menuItemImpl = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < menuAdapter.getCount()) {
                    menuItemImpl = menuAdapter.getItem(i2);
                }
                MenuItem menuItem = this.BuiltInFictitiousFunctionClassFactory;
                if (menuItem != menuItemImpl) {
                    MenuBuilder menuBuilder = menuAdapter.BuiltInFictitiousFunctionClassFactory;
                    if (menuItem != null) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(menuBuilder, menuItem);
                    }
                    this.BuiltInFictitiousFunctionClassFactory = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(menuBuilder, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        /* loaded from: classes.dex */
        static class Api17Impl {
            private Api17Impl() {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void PlaceComponentResult(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void MyBillsEntityDataFactory(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }
}
