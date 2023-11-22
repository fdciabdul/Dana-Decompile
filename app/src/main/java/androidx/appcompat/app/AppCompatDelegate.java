package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -100;
    private static final ArraySet<WeakReference<AppCompatDelegate>> getAuthRequestContext = new ArraySet<>();
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NightMode {
    }

    public abstract <T extends View> T BuiltInFictitiousFunctionClassFactory(int i);

    public abstract ActionBarDrawerToggle.Delegate BuiltInFictitiousFunctionClassFactory();

    @Deprecated
    public void BuiltInFictitiousFunctionClassFactory(Context context) {
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(View view, ViewGroup.LayoutParams layoutParams);

    public abstract ActionBar KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(View view);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence);

    public int MyBillsEntityDataFactory() {
        return -100;
    }

    public abstract void MyBillsEntityDataFactory(Configuration configuration);

    public abstract void MyBillsEntityDataFactory(Bundle bundle);

    public abstract void MyBillsEntityDataFactory(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean MyBillsEntityDataFactory(int i);

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda2();

    public abstract ActionMode PlaceComponentResult(ActionMode.Callback callback);

    public void PlaceComponentResult(int i) {
    }

    public abstract void PlaceComponentResult(Bundle bundle);

    public abstract void PlaceComponentResult(Toolbar toolbar);

    public abstract MenuInflater getAuthRequestContext();

    public abstract void getAuthRequestContext(int i);

    public abstract void getErrorConfigVersion();

    public abstract void lookAheadTest();

    public abstract void moveToNextValue();

    public abstract void scheduleImpl();

    public static AppCompatDelegate MyBillsEntityDataFactory(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate getAuthRequestContext(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public Context getAuthRequestContext(Context context) {
        BuiltInFictitiousFunctionClassFactory(context);
        return context;
    }

    public static int PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static void BuiltInFictitiousFunctionClassFactory(boolean z) {
        VectorEnabledTintResources.BuiltInFictitiousFunctionClassFactory(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(AppCompatDelegate appCompatDelegate) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            PlaceComponentResult(appCompatDelegate);
            getAuthRequestContext.add(new WeakReference<>(appCompatDelegate));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(AppCompatDelegate appCompatDelegate) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            PlaceComponentResult(appCompatDelegate);
        }
    }

    private static void PlaceComponentResult(AppCompatDelegate appCompatDelegate) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            Iterator<WeakReference<AppCompatDelegate>> it = getAuthRequestContext.iterator();
            while (it.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = it.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it.remove();
                }
            }
        }
    }
}
