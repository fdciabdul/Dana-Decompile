package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int moveToNextValue = R.layout.lookAheadTest;
    View BuiltInFictitiousFunctionClassFactory;
    private final int FragmentBottomSheetPaymentSettingBinding;
    private final Context GetContactSyncConfig;
    ViewTreeObserver NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private MenuPresenter.Callback NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda6;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    boolean PlaceComponentResult;
    private final int PrepareContext;
    private int SubSequence;
    final Handler getAuthRequestContext;
    private boolean getCallingPid;
    private PopupWindow.OnDismissListener isLayoutRequested;
    private View lookAheadTest;
    private final boolean newProxyInstance;
    private int whenAvailable;
    private final List<MenuBuilder> NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
    final List<CascadingMenuInfo> MyBillsEntityDataFactory = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener KClassImpl$Data$declaredNonStaticMembers$2 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.PlaceComponentResult() || CascadingMenuPopup.this.MyBillsEntityDataFactory.size() <= 0 || CascadingMenuPopup.this.MyBillsEntityDataFactory.get(0).getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                return;
            }
            View view = CascadingMenuPopup.this.BuiltInFictitiousFunctionClassFactory;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.getAuthRequestContext();
                return;
            }
            Iterator<CascadingMenuInfo> it = CascadingMenuPopup.this.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext.a_();
            }
        }
    };
    private final View.OnAttachStateChangeListener scheduleImpl = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (CascadingMenuPopup.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                if (!CascadingMenuPopup.this.NetworkUserEntityData$$ExternalSyntheticLambda0.isAlive()) {
                    CascadingMenuPopup.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view.getViewTreeObserver();
                }
                CascadingMenuPopup.this.NetworkUserEntityData$$ExternalSyntheticLambda0.removeGlobalOnLayoutListener(CascadingMenuPopup.this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener NetworkUserEntityData$$ExternalSyntheticLambda7 = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void BuiltInFictitiousFunctionClassFactory(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.getAuthRequestContext.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void PlaceComponentResult(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            CascadingMenuPopup.this.getAuthRequestContext.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.MyBillsEntityDataFactory.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.MyBillsEntityDataFactory.get(i).PlaceComponentResult) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final CascadingMenuInfo cascadingMenuInfo = i2 < CascadingMenuPopup.this.MyBillsEntityDataFactory.size() ? CascadingMenuPopup.this.MyBillsEntityDataFactory.get(i2) : null;
            CascadingMenuPopup.this.getAuthRequestContext.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (cascadingMenuInfo != null) {
                        CascadingMenuPopup.this.PlaceComponentResult = true;
                        cascadingMenuInfo.PlaceComponentResult.close(false);
                        CascadingMenuPopup.this.PlaceComponentResult = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }
    };
    private int NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    private int DatabaseTableConfigUtil = 0;
    private boolean initRecordTimeStamp = false;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HorizPosition {
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    protected final boolean MyBillsEntityDataFactory() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.GetContactSyncConfig = context;
        this.lookAheadTest = view;
        this.FragmentBottomSheetPaymentSettingBinding = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = i2;
        this.newProxyInstance = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ViewCompat.initRecordTimeStamp(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.PrepareContext = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory));
        this.getAuthRequestContext = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void getAuthRequestContext(boolean z) {
        this.initRecordTimeStamp = z;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void a_() {
        if (PlaceComponentResult()) {
            return;
        }
        Iterator<MenuBuilder> it = this.NetworkUserEntityData$$ExternalSyntheticLambda5.iterator();
        while (it.hasNext()) {
            KClassImpl$Data$declaredNonStaticMembers$2(it.next());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.clear();
        View view = this.lookAheadTest;
        this.BuiltInFictitiousFunctionClassFactory = view;
        if (view != null) {
            boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.BuiltInFictitiousFunctionClassFactory.addOnAttachStateChangeListener(this.scheduleImpl);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void getAuthRequestContext() {
        int size = this.MyBillsEntityDataFactory.size();
        if (size <= 0) {
            return;
        }
        CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.MyBillsEntityDataFactory.toArray(new CascadingMenuInfo[size]);
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[size];
            if (cascadingMenuInfo.getAuthRequestContext.PlaceComponentResult()) {
                cascadingMenuInfo.getAuthRequestContext.getAuthRequestContext();
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            getAuthRequestContext();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void PlaceComponentResult(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.GetContactSyncConfig);
        if (PlaceComponentResult()) {
            KClassImpl$Data$declaredNonStaticMembers$2(menuBuilder);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.add(menuBuilder);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.view.menu.MenuBuilder r17) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.size() > 0 && this.MyBillsEntityDataFactory.get(0).getAuthRequestContext.PlaceComponentResult();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.MyBillsEntityDataFactory.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.MyBillsEntityDataFactory.get(i);
            if (!cascadingMenuInfo.getAuthRequestContext.PlaceComponentResult()) {
                break;
            }
            i++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.PlaceComponentResult.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        Iterator<CascadingMenuInfo> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = it.next().getAuthRequestContext.getListView().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.MyBillsEntityDataFactory) {
            if (subMenuBuilder == cascadingMenuInfo.PlaceComponentResult) {
                cascadingMenuInfo.getAuthRequestContext.getListView().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            PlaceComponentResult(subMenuBuilder);
            MenuPresenter.Callback callback = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (callback != null) {
                callback.getAuthRequestContext(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void PlaceComponentResult(int i) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i;
            this.DatabaseTableConfigUtil = GravityCompat.BuiltInFictitiousFunctionClassFactory(i, ViewCompat.initRecordTimeStamp(this.lookAheadTest));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void MyBillsEntityDataFactory(View view) {
        if (this.lookAheadTest != view) {
            this.lookAheadTest = view;
            this.DatabaseTableConfigUtil = GravityCompat.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3, ViewCompat.initRecordTimeStamp(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void MyBillsEntityDataFactory(PopupWindow.OnDismissListener onDismissListener) {
        this.isLayoutRequested = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView getListView() {
        if (this.MyBillsEntityDataFactory.isEmpty()) {
            return null;
        }
        return this.MyBillsEntityDataFactory.get(r0.size() - 1).getAuthRequestContext.getListView();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        this.SubSequence = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.whenAvailable = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.getCallingPid = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CascadingMenuInfo {
        public final int MyBillsEntityDataFactory;
        public final MenuBuilder PlaceComponentResult;
        public final MenuPopupWindow getAuthRequestContext;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.getAuthRequestContext = menuPopupWindow;
            this.PlaceComponentResult = menuBuilder;
            this.MyBillsEntityDataFactory = i;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int size = this.MyBillsEntityDataFactory.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == this.MyBillsEntityDataFactory.get(i).PlaceComponentResult) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < this.MyBillsEntityDataFactory.size()) {
            this.MyBillsEntityDataFactory.get(i2).PlaceComponentResult.close(false);
        }
        CascadingMenuInfo remove = this.MyBillsEntityDataFactory.remove(i);
        remove.PlaceComponentResult.removeMenuPresenter(this);
        if (this.PlaceComponentResult) {
            MenuPopupWindow menuPopupWindow = remove.getAuthRequestContext;
            if (Build.VERSION.SDK_INT >= 23) {
                MenuPopupWindow.Api23Impl.PlaceComponentResult(menuPopupWindow.NetworkUserEntityData$$ExternalSyntheticLambda0, null);
            }
            remove.getAuthRequestContext.MyBillsEntityDataFactory(0);
        }
        remove.getAuthRequestContext.getAuthRequestContext();
        int size2 = this.MyBillsEntityDataFactory.size();
        if (size2 > 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.MyBillsEntityDataFactory.get(size2 - 1).MyBillsEntityDataFactory;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = ViewCompat.initRecordTimeStamp(this.lookAheadTest) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                this.MyBillsEntityDataFactory.get(0).PlaceComponentResult.close(false);
                return;
            }
            return;
        }
        getAuthRequestContext();
        MenuPresenter.Callback callback = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (callback != null) {
            callback.MyBillsEntityDataFactory(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.removeGlobalOnLayoutListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
        this.BuiltInFictitiousFunctionClassFactory.removeOnAttachStateChangeListener(this.scheduleImpl);
        this.isLayoutRequested.onDismiss();
    }
}
