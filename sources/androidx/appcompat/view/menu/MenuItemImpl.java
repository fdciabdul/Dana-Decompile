package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    public ActionProvider BuiltInFictitiousFunctionClassFactory;
    private CharSequence DatabaseTableConfigUtil;
    private Intent FragmentBottomSheetPaymentSettingBinding;
    private final int GetContactSyncConfig;
    private View NetworkUserEntityData$$ExternalSyntheticLambda0;
    private MenuItem.OnMenuItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Runnable NetworkUserEntityData$$ExternalSyntheticLambda3;
    private MenuItem.OnActionExpandListener NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda8;
    public MenuBuilder PlaceComponentResult;
    private char SubSequence;
    private CharSequence VerifyPinStateManager$executeRiskChallenge$2$1;
    ContextMenu.ContextMenuInfo getAuthRequestContext;
    private int getCallingPid;
    private CharSequence getSupportButtonTintMode;
    private final int initRecordTimeStamp;
    public SubMenuBuilder moveToNextValue;
    private CharSequence readMicros;
    final int scheduleImpl;
    private char whenAvailable;
    int lookAheadTest = 4096;
    int getErrorConfigVersion = 4096;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private ColorStateList PrepareContext = null;
    private PorterDuff.Mode isLayoutRequested = null;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
    private boolean newProxyInstance = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
    public int MyBillsEntityDataFactory = 16;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.PlaceComponentResult = menuBuilder;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = i2;
        this.initRecordTimeStamp = i;
        this.GetContactSyncConfig = i3;
        this.scheduleImpl = i4;
        this.getSupportButtonTintMode = charSequence;
        this.getCallingPid = i5;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            MenuBuilder menuBuilder = this.PlaceComponentResult;
            if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
                return true;
            }
            Runnable runnable = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.FragmentBottomSheetPaymentSettingBinding != null) {
                try {
                    this.PlaceComponentResult.getContext().startActivity(this.FragmentBottomSheetPaymentSettingBinding);
                    return true;
                } catch (ActivityNotFoundException e) {
                    InstrumentInjector.log_e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            ActionProvider actionProvider = this.BuiltInFictitiousFunctionClassFactory;
            return actionProvider != null && actionProvider.PlaceComponentResult();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.MyBillsEntityDataFactory & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.MyBillsEntityDataFactory |= 16;
        } else {
            this.MyBillsEntityDataFactory &= -17;
        }
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.initRecordTimeStamp;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.GetContactSyncConfig;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.FragmentBottomSheetPaymentSettingBinding = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.whenAvailable;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.whenAvailable == c) {
            return this;
        }
        this.whenAvailable = Character.toLowerCase(c);
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.whenAvailable == c && this.getErrorConfigVersion == i) {
            return this;
        }
        this.whenAvailable = Character.toLowerCase(c);
        this.getErrorConfigVersion = KeyEvent.normalizeMetaState(i);
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.getErrorConfigVersion;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.SubSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.lookAheadTest;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.SubSequence == c) {
            return this;
        }
        this.SubSequence = c;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.SubSequence == c && this.lookAheadTest == i) {
            return this;
        }
        this.SubSequence = c;
        this.lookAheadTest = KeyEvent.normalizeMetaState(i);
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.SubSequence = c;
        this.whenAvailable = Character.toLowerCase(c2);
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.SubSequence = c;
        this.lookAheadTest = KeyEvent.normalizeMetaState(i);
        this.whenAvailable = Character.toLowerCase(c2);
        this.getErrorConfigVersion = KeyEvent.normalizeMetaState(i2);
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.isQwertyMode() ? this.whenAvailable : this.SubSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean scheduleImpl() {
        return this.PlaceComponentResult.isShortcutsVisible() && KClassImpl$Data$declaredNonStaticMembers$2() != 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.moveToNextValue;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.moveToNextValue != null;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.getSupportButtonTintMode;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.getSupportButtonTintMode = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.moveToNextValue;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        return setTitle(this.PlaceComponentResult.getContext().getString(i));
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.readMicros;
        if (charSequence == null) {
            charSequence = this.getSupportButtonTintMode;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.readMicros = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (drawable != null) {
            return getAuthRequestContext(drawable);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != 0) {
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.getContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2;
            return getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = drawable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.PrepareContext = colorStateList;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.PrepareContext;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.isLayoutRequested = mode;
        this.newProxyInstance = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.isLayoutRequested;
    }

    private Drawable getAuthRequestContext(Drawable drawable) {
        if (drawable != null && this.NetworkUserEntityData$$ExternalSyntheticLambda5 && (this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.newProxyInstance)) {
            drawable = DrawableCompat.scheduleImpl(drawable).mutate();
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                DrawableCompat.PlaceComponentResult(drawable, this.PrepareContext);
            }
            if (this.newProxyInstance) {
                DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(drawable, this.isLayoutRequested);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.MyBillsEntityDataFactory & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.MyBillsEntityDataFactory = i2;
        if (i != i2) {
            this.PlaceComponentResult.onItemsChanged(false);
        }
        return this;
    }

    public final boolean lookAheadTest() {
        return (this.MyBillsEntityDataFactory & 4) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.MyBillsEntityDataFactory & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        if ((this.MyBillsEntityDataFactory & 4) != 0) {
            this.PlaceComponentResult.setExclusiveItemChecked(this);
        } else {
            BuiltInFictitiousFunctionClassFactory(z);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.MyBillsEntityDataFactory = i2;
        if (i != i2) {
            this.PlaceComponentResult.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        ActionProvider actionProvider = this.BuiltInFictitiousFunctionClassFactory;
        return (actionProvider == null || !actionProvider.KClassImpl$Data$declaredNonStaticMembers$2()) ? (this.MyBillsEntityDataFactory & 8) == 0 : (this.MyBillsEntityDataFactory & 8) == 0 && this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(boolean z) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.MyBillsEntityDataFactory = i2;
        return i != i2;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        if (MyBillsEntityDataFactory(z)) {
            this.PlaceComponentResult.onItemVisibleChanged(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.getSupportButtonTintMode;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.getAuthRequestContext;
    }

    public final boolean moveToNextValue() {
        return this.PlaceComponentResult.getOptionalIconsVisible();
    }

    public final boolean PlaceComponentResult() {
        return (this.MyBillsEntityDataFactory & 32) == 32;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (this.getCallingPid & 1) == 1;
    }

    public final boolean getErrorConfigVersion() {
        return (this.getCallingPid & 2) == 2;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return (this.getCallingPid & 4) == 4;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.getCallingPid = i;
        this.PlaceComponentResult.onItemActionRequestChanged(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        int i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.BuiltInFictitiousFunctionClassFactory = null;
        if (view != null && view.getId() == -1 && (i = this.NetworkUserEntityData$$ExternalSyntheticLambda6) > 0) {
            view.setId(i);
        }
        this.PlaceComponentResult.onItemActionRequestChanged(this);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final View getActionView() {
        View view = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.BuiltInFictitiousFunctionClassFactory;
        if (actionProvider != null) {
            View KClassImpl$Data$declaredNonStaticMembers$2 = actionProvider.KClassImpl$Data$declaredNonStaticMembers$2(this);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$2;
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final ActionProvider getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem KClassImpl$Data$declaredNonStaticMembers$2(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.BuiltInFictitiousFunctionClassFactory;
        if (actionProvider2 != null) {
            actionProvider2.moveToNextValue();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.BuiltInFictitiousFunctionClassFactory = actionProvider;
        this.PlaceComponentResult.onItemsChanged(true);
        ActionProvider actionProvider3 = this.BuiltInFictitiousFunctionClassFactory;
        if (actionProvider3 != null) {
            actionProvider3.PlaceComponentResult(new ActionProvider.VisibilityListener() { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                @Override // androidx.core.view.ActionProvider.VisibilityListener
                public final void MyBillsEntityDataFactory() {
                    MenuItemImpl.this.PlaceComponentResult.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean expandActionView() {
        if (MyBillsEntityDataFactory()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.PlaceComponentResult.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.getCallingPid & 8) == 0) {
            return false;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.PlaceComponentResult.collapseItemActionView(this);
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        ActionProvider actionProvider;
        if ((this.getCallingPid & 8) != 0) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null && (actionProvider = this.BuiltInFictitiousFunctionClassFactory) != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = actionProvider.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = onActionExpandListener;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem MyBillsEntityDataFactory(CharSequence charSequence) {
        this.DatabaseTableConfigUtil = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.PlaceComponentResult.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // android.view.MenuItem
    public final /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.DatabaseTableConfigUtil = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = charSequence;
        this.PlaceComponentResult.onItemsChanged(false);
        return this;
    }
}
