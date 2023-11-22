package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import androidx.view.ComponentDialog;

/* loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new KeyEventDispatcher.Component() { // from class: androidx.appcompat.app.AppCompatDialog$$ExternalSyntheticLambda0
            @Override // androidx.core.view.KeyEventDispatcher.Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
        AppCompatDelegate delegate = getDelegate();
        delegate.PlaceComponentResult(getThemeResId(context, i));
        delegate.MyBillsEntityDataFactory((Bundle) null);
    }

    public AppCompatDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new KeyEventDispatcher.Component() { // from class: androidx.appcompat.app.AppCompatDialog$$ExternalSyntheticLambda0
            @Override // androidx.core.view.KeyEventDispatcher.Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AppCompatDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().NetworkUserEntityData$$ExternalSyntheticLambda0();
        super.onCreate(bundle);
        getDelegate().MyBillsEntityDataFactory(bundle);
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void setContentView(int i) {
        getDelegate().getAuthRequestContext(i);
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        getDelegate().KClassImpl$Data$declaredNonStaticMembers$2(view);
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().MyBillsEntityDataFactory(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().BuiltInFictitiousFunctionClassFactory(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().KClassImpl$Data$declaredNonStaticMembers$2(getContext().getString(i));
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().BuiltInFictitiousFunctionClassFactory(view, layoutParams);
    }

    @Override // androidx.view.ComponentDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().moveToNextValue();
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().MyBillsEntityDataFactory(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().scheduleImpl();
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.getAuthRequestContext(this, this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.SubSequence, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.PlaceComponentResult(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
