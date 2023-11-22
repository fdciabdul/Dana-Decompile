package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    boolean DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    Drawable GetContactSyncConfig;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    OverflowPopup NetworkUserEntityData$$ExternalSyntheticLambda1;
    OverflowMenuButton NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    private ActionMenuPopupCallback NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private int NetworkUserEntityData$$ExternalSyntheticLambda6;
    final PopupPresenterCallback NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final SparseBooleanArray NetworkUserEntityData$$ExternalSyntheticLambda8;
    boolean PrepareContext;
    private int getSupportButtonTintMode;
    int initRecordTimeStamp;
    boolean isLayoutRequested;
    ActionButtonSubmenu lookAheadTest;
    OpenOverflowRunnable newProxyInstance;
    private boolean readMicros;
    private boolean whenAvailable;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.MyBillsEntityDataFactory, R.layout.BuiltInFictitiousFunctionClassFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new SparseBooleanArray();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new PopupPresenterCallback();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy PlaceComponentResult = ActionBarPolicy.PlaceComponentResult(context);
        if (!this.isLayoutRequested) {
            this.PrepareContext = PlaceComponentResult.MyBillsEntityDataFactory();
        }
        if (!this.whenAvailable) {
            this.getSupportButtonTintMode = PlaceComponentResult.PlaceComponentResult.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.FragmentBottomSheetPaymentSettingBinding) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = PlaceComponentResult.getAuthRequestContext();
        }
        int i = this.getSupportButtonTintMode;
        if (this.PrepareContext) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.moveToNextValue);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = overflowMenuButton;
                if (this.DatabaseTableConfigUtil) {
                    overflowMenuButton.setImageDrawable(this.GetContactSyncConfig);
                    this.GetContactSyncConfig = null;
                    this.DatabaseTableConfigUtil = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.NetworkUserEntityData$$ExternalSyntheticLambda2.getMeasuredWidth();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public final void getErrorConfigVersion() {
        if (!this.FragmentBottomSheetPaymentSettingBinding) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = ActionBarPolicy.PlaceComponentResult(this.getAuthRequestContext).getAuthRequestContext();
        }
        if (this.PlaceComponentResult != null) {
            this.PlaceComponentResult.onItemsChanged(true);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final MenuView PlaceComponentResult(ViewGroup viewGroup) {
        MenuView menuView = this.scheduleImpl;
        MenuView PlaceComponentResult = super.PlaceComponentResult(viewGroup);
        if (menuView != PlaceComponentResult) {
            ((ActionMenuView) PlaceComponentResult).setPresenter(this);
        }
        return PlaceComponentResult;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final View PlaceComponentResult(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.MyBillsEntityDataFactory()) {
            actionView = super.PlaceComponentResult(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final void getAuthRequestContext(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.scheduleImpl);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean PlaceComponentResult(MenuItemImpl menuItemImpl) {
        return menuItemImpl.PlaceComponentResult();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.scheduleImpl).requestLayout();
        boolean z2 = false;
        if (this.PlaceComponentResult != null) {
            ArrayList<MenuItemImpl> actionItems = this.PlaceComponentResult.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider actionProvider = actionItems.get(i).BuiltInFictitiousFunctionClassFactory;
                if (actionProvider != null) {
                    actionProvider.BuiltInFictitiousFunctionClassFactory(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems = this.PlaceComponentResult != null ? this.PlaceComponentResult.getNonActionItems() : null;
        if (this.PrepareContext && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new OverflowMenuButton(this.moveToNextValue);
            }
            ViewGroup viewGroup = (ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getParent();
            if (viewGroup != this.scheduleImpl) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.scheduleImpl;
                actionMenuView.addView(this.NetworkUserEntityData$$ExternalSyntheticLambda2, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == this.scheduleImpl) {
                ((ViewGroup) this.scheduleImpl).removeView(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
        }
        ((ActionMenuView) this.scheduleImpl).setOverflowReserved(this.PrepareContext);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return false;
        }
        return super.BuiltInFictitiousFunctionClassFactory(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        View view;
        boolean z = false;
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (subMenuBuilder2.getParentMenu() != this.PlaceComponentResult) {
                subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
            }
            MenuItem item = subMenuBuilder2.getItem();
            ViewGroup viewGroup = (ViewGroup) this.scheduleImpl;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    view = viewGroup.getChildAt(i);
                    if ((view instanceof MenuView.ItemView) && ((MenuView.ItemView) view).getItemData() == item) {
                        break;
                    }
                }
            }
            view = null;
            if (view == null) {
                return false;
            }
            this.initRecordTimeStamp = subMenuBuilder.getItem().getItemId();
            int size = subMenuBuilder.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item2 = subMenuBuilder.getItem(i2);
                if (item2.isVisible() && item2.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.getAuthRequestContext, subMenuBuilder, view);
            this.lookAheadTest = actionButtonSubmenu;
            actionButtonSubmenu.PlaceComponentResult = z;
            MenuPopup menuPopup = actionButtonSubmenu.mPopup;
            if (menuPopup != null) {
                menuPopup.getAuthRequestContext(z);
            }
            if (this.lookAheadTest.MyBillsEntityDataFactory()) {
                super.onSubMenuSelected(subMenuBuilder);
                return true;
            }
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        return false;
    }

    public final boolean scheduleImpl() {
        if (!this.PrepareContext || BuiltInFictitiousFunctionClassFactory() || this.PlaceComponentResult == null || this.scheduleImpl == null || this.newProxyInstance != null || this.PlaceComponentResult.getNonActionItems().isEmpty()) {
            return false;
        }
        this.newProxyInstance = new OpenOverflowRunnable(new OverflowPopup(this.getAuthRequestContext, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        ((View) this.scheduleImpl).post(this.newProxyInstance);
        return true;
    }

    public final boolean PlaceComponentResult() {
        if (this.newProxyInstance != null && this.scheduleImpl != null) {
            ((View) this.scheduleImpl).removeCallbacks(this.newProxyInstance);
            this.newProxyInstance = null;
            return true;
        }
        OverflowPopup overflowPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (overflowPopup != null) {
            if (overflowPopup.PlaceComponentResult()) {
                overflowPopup.mPopup.getAuthRequestContext();
            }
            return true;
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        return PlaceComponentResult() | KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        ActionButtonSubmenu actionButtonSubmenu = this.lookAheadTest;
        if (actionButtonSubmenu != null) {
            if (actionButtonSubmenu.PlaceComponentResult()) {
                actionButtonSubmenu.mPopup.getAuthRequestContext();
                return true;
            }
            return true;
        }
        return false;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        OverflowPopup overflowPopup = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return overflowPopup != null && overflowPopup.PlaceComponentResult();
    }

    public final boolean getAuthRequestContext() {
        return this.newProxyInstance != null || BuiltInFictitiousFunctionClassFactory();
    }

    public final boolean moveToNextValue() {
        return this.PrepareContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00ee  */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean flagActionItems() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.flagActionItems():boolean");
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MyBillsEntityDataFactory();
        super.onCloseMenu(menuBuilder, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.KClassImpl$Data$declaredNonStaticMembers$2 = this.initRecordTimeStamp;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.KClassImpl$Data$declaredNonStaticMembers$2 <= 0 || (findItem = this.PlaceComponentResult.findItem(savedState.KClassImpl$Data$declaredNonStaticMembers$2)) == null) {
                return;
            }
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public final void MyBillsEntityDataFactory(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.PlaceComponentResult != null) {
            this.PlaceComponentResult.close(false);
        }
    }

    /* loaded from: classes.dex */
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda2);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.PlaceComponentResult(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu getAuthRequestContext() {
                    if (ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                        return null;
                    }
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (overflowPopup.mPopup == null) {
                        overflowPopup.mPopup = overflowPopup.BuiltInFictitiousFunctionClassFactory();
                    }
                    return overflowPopup.mPopup;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean MyBillsEntityDataFactory() {
                    ActionMenuPresenter.this.scheduleImpl();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean BuiltInFictitiousFunctionClassFactory() {
                    if (ActionMenuPresenter.this.newProxyInstance != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.PlaceComponentResult();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.scheduleImpl();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.getAuthRequestContext(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view) {
            super(context, menuBuilder, view, true, R.attr.initRecordTimeStamp);
            this.MyBillsEntityDataFactory = 8388613;
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.getAuthRequestContext = popupPresenterCallback;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void getAuthRequestContext() {
            if (ActionMenuPresenter.this.PlaceComponentResult != null) {
                ActionMenuPresenter.this.PlaceComponentResult.close();
            }
            ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
            super.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R.attr.initRecordTimeStamp);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).PlaceComponentResult()) {
                getAuthRequestContext(ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null ? (View) ActionMenuPresenter.this.scheduleImpl : ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.getAuthRequestContext = popupPresenterCallback;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void getAuthRequestContext() {
            ActionMenuPresenter.this.lookAheadTest = null;
            ActionMenuPresenter.this.initRecordTimeStamp = 0;
            super.getAuthRequestContext();
        }
    }

    /* loaded from: classes.dex */
    class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean getAuthRequestContext(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.PlaceComponentResult) {
                return false;
            }
            ActionMenuPresenter.this.initRecordTimeStamp = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (callback != null) {
                return callback.getAuthRequestContext(menuBuilder);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (callback != null) {
                callback.MyBillsEntityDataFactory(menuBuilder, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup getAuthRequestContext;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.getAuthRequestContext = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.PlaceComponentResult != null) {
                ActionMenuPresenter.this.PlaceComponentResult.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.scheduleImpl;
            if (view != null && view.getWindowToken() != null && this.getAuthRequestContext.MyBillsEntityDataFactory()) {
                ActionMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.getAuthRequestContext;
            }
            ActionMenuPresenter.this.newProxyInstance = null;
        }
    }

    /* loaded from: classes.dex */
    class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public final ShowableListMenu getAuthRequestContext() {
            if (ActionMenuPresenter.this.lookAheadTest != null) {
                ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.lookAheadTest;
                if (actionButtonSubmenu.mPopup == null) {
                    actionButtonSubmenu.mPopup = actionButtonSubmenu.BuiltInFictitiousFunctionClassFactory();
                }
                return actionButtonSubmenu.mPopup;
            }
            return null;
        }
    }
}
