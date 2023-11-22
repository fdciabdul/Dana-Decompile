package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    private static final int KClassImpl$Data$declaredNonStaticMembers$2 = R.layout.GetContactSyncConfig;
    View BuiltInFictitiousFunctionClassFactory;
    private final Context DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    ViewTreeObserver MyBillsEntityDataFactory;
    private final MenuBuilder NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private MenuPresenter.Callback NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final int PrepareContext;
    final MenuPopupWindow getAuthRequestContext;
    private PopupWindow.OnDismissListener initRecordTimeStamp;
    private final int isLayoutRequested;
    private final MenuAdapter lookAheadTest;
    private View moveToNextValue;
    private final boolean newProxyInstance;
    private int scheduleImpl;
    final ViewTreeObserver.OnGlobalLayoutListener PlaceComponentResult = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.PlaceComponentResult() || StandardMenuPopup.this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                return;
            }
            View view = StandardMenuPopup.this.BuiltInFictitiousFunctionClassFactory;
            if (view == null || !view.isShown()) {
                StandardMenuPopup.this.getAuthRequestContext();
            } else {
                StandardMenuPopup.this.getAuthRequestContext.a_();
            }
        }
    };
    private final View.OnAttachStateChangeListener NetworkUserEntityData$$ExternalSyntheticLambda0 = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (StandardMenuPopup.this.MyBillsEntityDataFactory != null) {
                if (!StandardMenuPopup.this.MyBillsEntityDataFactory.isAlive()) {
                    StandardMenuPopup.this.MyBillsEntityDataFactory = view.getViewTreeObserver();
                }
                StandardMenuPopup.this.MyBillsEntityDataFactory.removeGlobalOnLayoutListener(StandardMenuPopup.this.PlaceComponentResult);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int GetContactSyncConfig = 0;

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void PlaceComponentResult(MenuBuilder menuBuilder) {
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

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.DatabaseTableConfigUtil = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = menuBuilder;
        this.newProxyInstance = z;
        this.lookAheadTest = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, KClassImpl$Data$declaredNonStaticMembers$2);
        this.isLayoutRequested = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i2;
        Resources resources = context.getResources();
        this.PrepareContext = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory));
        this.moveToNextValue = view;
        this.getAuthRequestContext = new MenuPopupWindow(context, i, i2);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void getAuthRequestContext(boolean z) {
        this.lookAheadTest.MyBillsEntityDataFactory = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void PlaceComponentResult(int i) {
        this.GetContactSyncConfig = i;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        View view;
        if (PlaceComponentResult()) {
            return true;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 || (view = this.moveToNextValue) == null) {
            return false;
        }
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.getAuthRequestContext.MyBillsEntityDataFactory(this);
        this.getAuthRequestContext.getAuthRequestContext(this);
        this.getAuthRequestContext.getAuthRequestContext(true);
        View view2 = this.BuiltInFictitiousFunctionClassFactory;
        boolean z = this.MyBillsEntityDataFactory == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.MyBillsEntityDataFactory = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.PlaceComponentResult);
        }
        view2.addOnAttachStateChangeListener(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.getAuthRequestContext.PlaceComponentResult(view2);
        this.getAuthRequestContext.getErrorConfigVersion(this.GetContactSyncConfig);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            this.scheduleImpl = BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.DatabaseTableConfigUtil, this.PrepareContext);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        }
        this.getAuthRequestContext.PlaceComponentResult(this.scheduleImpl);
        this.getAuthRequestContext.scheduleImpl(2);
        this.getAuthRequestContext.PlaceComponentResult(this.getErrorConfigVersion);
        this.getAuthRequestContext.a_();
        ListView listView = this.getAuthRequestContext.getListView();
        listView.setOnKeyListener(this);
        if (this.FragmentBottomSheetPaymentSettingBinding && this.NetworkUserEntityData$$ExternalSyntheticLambda1.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.DatabaseTableConfigUtil).inflate(R.layout.initRecordTimeStamp, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.NetworkUserEntityData$$ExternalSyntheticLambda1.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.getAuthRequestContext.PlaceComponentResult(this.lookAheadTest);
        this.getAuthRequestContext.a_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void a_() {
        if (!BuiltInFictitiousFunctionClassFactory()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void getAuthRequestContext() {
        if (PlaceComponentResult()) {
            this.getAuthRequestContext.getAuthRequestContext();
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean PlaceComponentResult() {
        return !this.NetworkUserEntityData$$ExternalSyntheticLambda6 && this.getAuthRequestContext.PlaceComponentResult();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.close();
        ViewTreeObserver viewTreeObserver = this.MyBillsEntityDataFactory;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver();
            }
            this.MyBillsEntityDataFactory.removeGlobalOnLayoutListener(this.PlaceComponentResult);
            this.MyBillsEntityDataFactory = null;
        }
        this.BuiltInFictitiousFunctionClassFactory.removeOnAttachStateChangeListener(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        PopupWindow.OnDismissListener onDismissListener = this.initRecordTimeStamp;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        MenuAdapter menuAdapter = this.lookAheadTest;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.DatabaseTableConfigUtil, subMenuBuilder, this.BuiltInFictitiousFunctionClassFactory, this.newProxyInstance, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            MenuPresenter.Callback callback = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            menuPopupHelper.getAuthRequestContext = callback;
            MenuPopup menuPopup = menuPopupHelper.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(callback);
            }
            boolean authRequestContext = MenuPopup.getAuthRequestContext(subMenuBuilder);
            menuPopupHelper.PlaceComponentResult = authRequestContext;
            MenuPopup menuPopup2 = menuPopupHelper.mPopup;
            if (menuPopup2 != null) {
                menuPopup2.getAuthRequestContext(authRequestContext);
            }
            menuPopupHelper.BuiltInFictitiousFunctionClassFactory = this.initRecordTimeStamp;
            this.initRecordTimeStamp = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.close(false);
            int BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
            int errorConfigVersion = this.getAuthRequestContext.getErrorConfigVersion();
            if ((Gravity.getAbsoluteGravity(this.GetContactSyncConfig, ViewCompat.initRecordTimeStamp(this.moveToNextValue)) & 7) == 5) {
                BuiltInFictitiousFunctionClassFactory += this.moveToNextValue.getWidth();
            }
            if (menuPopupHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, errorConfigVersion)) {
                MenuPresenter.Callback callback2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (callback2 != null) {
                    callback2.getAuthRequestContext(subMenuBuilder);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        getAuthRequestContext();
        MenuPresenter.Callback callback = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (callback != null) {
            callback.MyBillsEntityDataFactory(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void MyBillsEntityDataFactory(View view) {
        this.moveToNextValue = view;
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
    public final void MyBillsEntityDataFactory(PopupWindow.OnDismissListener onDismissListener) {
        this.initRecordTimeStamp = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView getListView() {
        return this.getAuthRequestContext.getListView();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.getAuthRequestContext.getAuthRequestContext(i);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.FragmentBottomSheetPaymentSettingBinding = z;
    }
}
