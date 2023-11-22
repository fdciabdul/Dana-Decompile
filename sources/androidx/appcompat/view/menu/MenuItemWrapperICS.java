package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    private Method MyBillsEntityDataFactory;
    private final SupportMenuItem getAuthRequestContext;

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.getAuthRequestContext = supportMenuItem;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.getAuthRequestContext.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.getAuthRequestContext.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.getAuthRequestContext.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.getAuthRequestContext.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.getAuthRequestContext.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.getAuthRequestContext.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.getAuthRequestContext.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.getAuthRequestContext.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.getAuthRequestContext.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.getAuthRequestContext.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.getAuthRequestContext.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.getAuthRequestContext.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.getAuthRequestContext.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.getAuthRequestContext.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.getAuthRequestContext.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.getAuthRequestContext.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.getAuthRequestContext.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.getAuthRequestContext.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.getAuthRequestContext.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.getAuthRequestContext.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.getAuthRequestContext.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.getAuthRequestContext.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.getAuthRequestContext.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.getAuthRequestContext.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.getAuthRequestContext.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.getAuthRequestContext.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.getAuthRequestContext.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.getAuthRequestContext.setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.getAuthRequestContext.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.getAuthRequestContext.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.getAuthRequestContext.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.getAuthRequestContext.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return getAuthRequestContext(this.getAuthRequestContext.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.getAuthRequestContext.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.getAuthRequestContext.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.getAuthRequestContext.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.getAuthRequestContext.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.getAuthRequestContext.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.getAuthRequestContext.setActionView(i);
        View actionView = this.getAuthRequestContext.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.getAuthRequestContext.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.getAuthRequestContext.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? (View) ((CollapsibleActionViewWrapper) actionView).BuiltInFictitiousFunctionClassFactory : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.ActionProvider actionProviderWrapper;
        if (Build.VERSION.SDK_INT >= 16) {
            actionProviderWrapper = new ActionProviderWrapperJB(this.BuiltInFictitiousFunctionClassFactory, actionProvider);
        } else {
            actionProviderWrapper = new ActionProviderWrapper(this.BuiltInFictitiousFunctionClassFactory, actionProvider);
        }
        SupportMenuItem supportMenuItem = this.getAuthRequestContext;
        if (actionProvider == null) {
            actionProviderWrapper = null;
        }
        supportMenuItem.KClassImpl$Data$declaredNonStaticMembers$2(actionProviderWrapper);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider authRequestContext = this.getAuthRequestContext.getAuthRequestContext();
        if (authRequestContext instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) authRequestContext).PlaceComponentResult;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.getAuthRequestContext.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.getAuthRequestContext.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.getAuthRequestContext.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.getAuthRequestContext.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.getAuthRequestContext.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.getAuthRequestContext.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.getAuthRequestContext.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.getAuthRequestContext.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.getAuthRequestContext.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.getAuthRequestContext.getIconTintMode();
    }

    public final void PlaceComponentResult() {
        try {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = this.getAuthRequestContext.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.MyBillsEntityDataFactory.invoke(this.getAuthRequestContext, Boolean.TRUE);
        } catch (Exception e) {
            InstrumentInjector.log_w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* loaded from: classes3.dex */
    class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener BuiltInFictitiousFunctionClassFactory;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.BuiltInFictitiousFunctionClassFactory = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.BuiltInFictitiousFunctionClassFactory.onMenuItemClick(MenuItemWrapperICS.this.MyBillsEntityDataFactory(menuItem));
        }
    }

    /* loaded from: classes3.dex */
    class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener MyBillsEntityDataFactory;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.MyBillsEntityDataFactory = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.MyBillsEntityDataFactory.onMenuItemActionExpand(MenuItemWrapperICS.this.MyBillsEntityDataFactory(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.MyBillsEntityDataFactory.onMenuItemActionCollapse(MenuItemWrapperICS.this.MyBillsEntityDataFactory(menuItem));
        }
    }

    /* loaded from: classes3.dex */
    class ActionProviderWrapper extends androidx.core.view.ActionProvider {
        final ActionProvider PlaceComponentResult;

        ActionProviderWrapper(Context context, ActionProvider actionProvider) {
            super(context);
            this.PlaceComponentResult = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        public View getAuthRequestContext() {
            return this.PlaceComponentResult.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean PlaceComponentResult() {
            return this.PlaceComponentResult.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean MyBillsEntityDataFactory() {
            return this.PlaceComponentResult.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public void MyBillsEntityDataFactory(SubMenu subMenu) {
            this.PlaceComponentResult.onPrepareSubMenu(MenuItemWrapperICS.this.getAuthRequestContext(subMenu));
        }
    }

    /* loaded from: classes3.dex */
    class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        private ActionProvider.VisibilityListener getAuthRequestContext;

        ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.ActionProvider
        public View KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem) {
            return this.PlaceComponentResult.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult.isVisible();
        }

        @Override // androidx.core.view.ActionProvider
        public void PlaceComponentResult(ActionProvider.VisibilityListener visibilityListener) {
            this.getAuthRequestContext = visibilityListener;
            this.PlaceComponentResult.setVisibilityListener(visibilityListener != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener = this.getAuthRequestContext;
            if (visibilityListener != null) {
                visibilityListener.MyBillsEntityDataFactory();
            }
        }
    }

    /* loaded from: classes3.dex */
    static class CollapsibleActionViewWrapper extends FrameLayout implements androidx.appcompat.view.CollapsibleActionView {
        final CollapsibleActionView BuiltInFictitiousFunctionClassFactory;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.BuiltInFictitiousFunctionClassFactory = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.BuiltInFictitiousFunctionClassFactory.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.BuiltInFictitiousFunctionClassFactory.onActionViewCollapsed();
        }
    }
}
