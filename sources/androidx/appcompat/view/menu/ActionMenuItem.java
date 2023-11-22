package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {
    private MenuItem.OnMenuItemClickListener BuiltInFictitiousFunctionClassFactory;
    private CharSequence MyBillsEntityDataFactory;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda0;
    private char NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Intent NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Context PlaceComponentResult;
    private CharSequence PrepareContext;
    private CharSequence isLayoutRequested;
    private char newProxyInstance;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8 = 4096;
    private int DatabaseTableConfigUtil = 4096;
    private ColorStateList lookAheadTest = null;
    private PorterDuff.Mode getErrorConfigVersion = null;
    private boolean scheduleImpl = false;
    private boolean moveToNextValue = false;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 16;
    private final int GetContactSyncConfig = 16908332;
    private final int getAuthRequestContext = 0;
    private final int initRecordTimeStamp = 0;

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final ActionProvider getAuthRequestContext() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    public ActionMenuItem(Context context, CharSequence charSequence) {
        this.PlaceComponentResult = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.getAuthRequestContext;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.GetContactSyncConfig;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.newProxyInstance;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.initRecordTimeStamp;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.PrepareContext;
        return charSequence == null ? this.NetworkUserEntityData$$ExternalSyntheticLambda7 : charSequence;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Character.toLowerCase(c);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Character.toLowerCase(c);
        this.DatabaseTableConfigUtil = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (z ? 1 : 0) | (this.KClassImpl$Data$declaredNonStaticMembers$2 & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (z ? 2 : 0) | (this.KClassImpl$Data$declaredNonStaticMembers$2 & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (z ? 16 : 0) | (this.KClassImpl$Data$declaredNonStaticMembers$2 & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = drawable;
        PlaceComponentResult();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ContextCompat.PlaceComponentResult(this.PlaceComponentResult, i);
        PlaceComponentResult();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.newProxyInstance = c;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.newProxyInstance = c;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.BuiltInFictitiousFunctionClassFactory = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.newProxyInstance = c;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.newProxyInstance = c;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KeyEvent.normalizeMetaState(i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Character.toLowerCase(c2);
        this.DatabaseTableConfigUtil = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.PlaceComponentResult.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.PrepareContext = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (z ? 0 : 8) | (this.KClassImpl$Data$declaredNonStaticMembers$2 & 8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem KClassImpl$Data$declaredNonStaticMembers$2(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem MyBillsEntityDataFactory(CharSequence charSequence) {
        this.MyBillsEntityDataFactory = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        this.isLayoutRequested = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.isLayoutRequested;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.lookAheadTest = colorStateList;
        this.scheduleImpl = true;
        PlaceComponentResult();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.lookAheadTest;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.getErrorConfigVersion = mode;
        this.moveToNextValue = true;
        PlaceComponentResult();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.getErrorConfigVersion;
    }

    private void PlaceComponentResult() {
        Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (drawable != null) {
            if (this.scheduleImpl || this.moveToNextValue) {
                Drawable scheduleImpl = DrawableCompat.scheduleImpl(drawable);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = scheduleImpl;
                Drawable mutate = scheduleImpl.mutate();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = mutate;
                if (this.scheduleImpl) {
                    DrawableCompat.PlaceComponentResult(mutate, this.lookAheadTest);
                }
                if (this.moveToNextValue) {
                    DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.MyBillsEntityDataFactory = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.isLayoutRequested = charSequence;
        return this;
    }
}
