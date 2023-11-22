package id.dana.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0005\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0005\u0010\u0012J!\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\f\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/utils/KeyboardHelper;", "", "Landroid/app/Activity;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)V", "getAuthRequestContext", "Landroid/view/View;", "", "(Landroid/view/View;)I", "", "PlaceComponentResult", "(Landroid/app/Activity;)Z", "MyBillsEntityDataFactory", "(Landroid/view/View;)V", "Landroid/content/Context;", "p1", "(Landroid/content/Context;Landroid/view/View;)V", "Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "(Landroid/view/View;Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "<init>", "()V", "KeyboardVisibilityListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeyboardHelper {
    public static final KeyboardHelper INSTANCE = new KeyboardHelper();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface KeyboardVisibilityListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();
    }

    private KeyboardHelper() {
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.getWindow().setSoftInputMode(4);
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Context context = p0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).showSoftInput(p0, 2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @JvmStatic
    public static final void getAuthRequestContext(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object systemService = p0.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Activity p0) {
        View currentFocus;
        if (p0 == null || !PlaceComponentResult(p0) || (currentFocus = p0.getWindow().getCurrentFocus()) == null) {
            return;
        }
        Context context = currentFocus.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Activity p0) {
        View findViewById;
        if (p0 == null || (findViewById = p0.findViewById(16908290)) == null) {
            return;
        }
        Object systemService = p0.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(View p0) {
        if (p0 != null) {
            Context context = p0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(p0.getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private static boolean PlaceComponentResult(Activity p0) {
        return p0.getCurrentFocus() != null;
    }

    @JvmStatic
    public static final int getAuthRequestContext(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Rect rect = new Rect();
        p0.getWindowVisibleDisplayFrame(rect);
        return p0.getRootView().getHeight() - (rect.bottom - rect.top);
    }

    @JvmStatic
    public static final void PlaceComponentResult(final View p0, final KeyboardVisibilityListener p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0 != null) {
            final boolean[] zArr = {false};
            p0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.utils.KeyboardHelper$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    KeyboardHelper.PlaceComponentResult(p0, zArr, p1);
                }
            });
        }
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object systemService = p0.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).toggleSoftInput(1, 0);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(final Context p0, final View p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p1.post(new Runnable() { // from class: id.dana.utils.KeyboardHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardHelper.getAuthRequestContext(p1, p0);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(View view, boolean[] zArr, KeyboardVisibilityListener keyboardVisibilityListener) {
        Intrinsics.checkNotNullParameter(zArr, "");
        Intrinsics.checkNotNullParameter(keyboardVisibilityListener, "");
        if (getAuthRequestContext(view) > view.getRootView().getHeight() / 4) {
            zArr[0] = true;
            keyboardVisibilityListener.KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (zArr[0]) {
            zArr[0] = false;
            keyboardVisibilityListener.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(View view, Context context) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (view.requestFocus()) {
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).showSoftInput(view, 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
