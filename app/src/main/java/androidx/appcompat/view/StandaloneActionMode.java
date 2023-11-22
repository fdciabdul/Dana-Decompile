package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback BuiltInFictitiousFunctionClassFactory;
    private ActionBarContextView MyBillsEntityDataFactory;
    private Context PlaceComponentResult;
    private WeakReference<View> getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private MenuBuilder lookAheadTest;
    private boolean moveToNextValue;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = actionBarContextView;
        this.BuiltInFictitiousFunctionClassFactory = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.lookAheadTest = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.getErrorConfigVersion = z;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void MyBillsEntityDataFactory(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void PlaceComponentResult(int i) {
        this.MyBillsEntityDataFactory.setTitle(this.PlaceComponentResult.getString(i));
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void getAuthRequestContext(int i) {
        this.MyBillsEntityDataFactory.setSubtitle(this.PlaceComponentResult.getString(i));
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void MyBillsEntityDataFactory(boolean z) {
        super.MyBillsEntityDataFactory(z);
        this.MyBillsEntityDataFactory.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final boolean scheduleImpl() {
        return this.MyBillsEntityDataFactory.isTitleOptional();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void MyBillsEntityDataFactory(View view) {
        this.MyBillsEntityDataFactory.setCustomView(view);
        this.getAuthRequestContext = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void lookAheadTest() {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this, this.lookAheadTest);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.moveToNextValue) {
            return;
        }
        this.moveToNextValue = true;
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final Menu PlaceComponentResult() {
        return this.lookAheadTest;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final CharSequence getErrorConfigVersion() {
        return this.MyBillsEntityDataFactory.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.MyBillsEntityDataFactory.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        WeakReference<View> weakReference = this.getAuthRequestContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final MenuInflater MyBillsEntityDataFactory() {
        return new SupportMenuInflater(this.MyBillsEntityDataFactory.getContext());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this, this.lookAheadTest);
        this.MyBillsEntityDataFactory.showOverflowMenu();
    }
}
