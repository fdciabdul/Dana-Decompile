package androidx.view;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static int BuiltInFictitiousFunctionClassFactory;
    private static Field KClassImpl$Data$declaredNonStaticMembers$2;
    private static Field MyBillsEntityDataFactory;
    private static Field PlaceComponentResult;
    private Activity getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.getAuthRequestContext = activity;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (BuiltInFictitiousFunctionClassFactory == 0) {
            try {
                BuiltInFictitiousFunctionClassFactory = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                PlaceComponentResult = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                MyBillsEntityDataFactory = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                KClassImpl$Data$declaredNonStaticMembers$2 = declaredField3;
                declaredField3.setAccessible(true);
                BuiltInFictitiousFunctionClassFactory = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (BuiltInFictitiousFunctionClassFactory == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.getAuthRequestContext.getSystemService("input_method");
            try {
                Object obj = KClassImpl$Data$declaredNonStaticMembers$2.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) PlaceComponentResult.get(inputMethodManager);
                        if (view == null) {
                            return;
                        }
                        if (view.isAttachedToWindow()) {
                            return;
                        }
                        try {
                            MyBillsEntityDataFactory.set(inputMethodManager, null);
                            inputMethodManager.isActive();
                        } catch (IllegalAccessException unused2) {
                        }
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
