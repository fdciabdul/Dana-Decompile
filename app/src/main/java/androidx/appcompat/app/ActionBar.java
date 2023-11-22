package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DisplayOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NavigationMode {
    }

    /* loaded from: classes.dex */
    public interface OnMenuVisibilityListener {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnNavigationListener {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class Tab {
        public abstract Drawable BuiltInFictitiousFunctionClassFactory();

        public abstract CharSequence KClassImpl$Data$declaredNonStaticMembers$2();

        public abstract CharSequence MyBillsEntityDataFactory();

        public abstract View PlaceComponentResult();

        public abstract int getAuthRequestContext();

        public abstract void moveToNextValue();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface TabListener {
    }

    public Context BuiltInFictitiousFunctionClassFactory() {
        return null;
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(CharSequence charSequence);

    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
    }

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    public ActionMode KClassImpl$Data$declaredNonStaticMembers$2(ActionMode.Callback callback) {
        return null;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

    public boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean MyBillsEntityDataFactory() {
        return false;
    }

    public boolean MyBillsEntityDataFactory(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
    }

    public void PlaceComponentResult(Configuration configuration) {
    }

    public void PlaceComponentResult(boolean z) {
    }

    public boolean PlaceComponentResult() {
        return false;
    }

    public abstract int getAuthRequestContext();

    public void getAuthRequestContext(boolean z) {
    }

    public abstract void getErrorConfigVersion();

    public boolean lookAheadTest() {
        return false;
    }

    public boolean moveToNextValue() {
        return false;
    }

    public abstract void scheduleImpl();

    public void DatabaseTableConfigUtil() {
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int BuiltInFictitiousFunctionClassFactory;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.BuiltInFictitiousFunctionClassFactory = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(R.styleable.BuiltInFictitiousFunctionClassFactory, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-2, -2);
            this.BuiltInFictitiousFunctionClassFactory = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.BuiltInFictitiousFunctionClassFactory = layoutParams.BuiltInFictitiousFunctionClassFactory;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.BuiltInFictitiousFunctionClassFactory = 0;
        }
    }
}
