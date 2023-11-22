package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class KeyEventDispatcher {
    private static Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static Field PlaceComponentResult;
    private static boolean getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    private KeyEventDispatcher() {
    }

    public static boolean PlaceComponentResult(Component component, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return MyBillsEntityDataFactory((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return getAuthRequestContext((Dialog) callback, keyEvent);
        }
        return (view != null && ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(ActionBar actionBar, KeyEvent keyEvent) {
        if (!MyBillsEntityDataFactory) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            MyBillsEntityDataFactory = true;
        }
        Method method = KClassImpl$Data$declaredNonStaticMembers$2;
        if (method != null) {
            try {
                Object invoke = method.invoke(actionBar, keyEvent);
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) invoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean MyBillsEntityDataFactory(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && KClassImpl$Data$declaredNonStaticMembers$2(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static DialogInterface.OnKeyListener MyBillsEntityDataFactory(Dialog dialog) {
        if (!getAuthRequestContext) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                PlaceComponentResult = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            getAuthRequestContext = true;
        }
        Field field = PlaceComponentResult;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
        return null;
    }

    private static boolean getAuthRequestContext(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(dialog);
        if (MyBillsEntityDataFactory2 == null || !MyBillsEntityDataFactory2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            Window window = dialog.getWindow();
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
        }
        return true;
    }
}
