package id.dana.core.ui.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0007\u0010\rJ!\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0007\u0010\u0012"}, d2 = {"Lid/dana/core/ui/util/KeyboardHelper;", "", "Landroid/app/Activity;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;)V", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Z", "PlaceComponentResult", "Landroid/view/View;", "(Landroid/view/View;)V", "Lid/dana/core/ui/util/KeyboardHelper$KeyboardVisibilityListener;", "p1", "(Landroid/view/View;Lid/dana/core/ui/util/KeyboardHelper$KeyboardVisibilityListener;)V", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<init>", "()V", "KeyboardVisibilityListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeyboardHelper {
    public static final KeyboardHelper INSTANCE = new KeyboardHelper();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/util/KeyboardHelper$KeyboardVisibilityListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface KeyboardVisibilityListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();
    }

    private KeyboardHelper() {
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
    public static final void PlaceComponentResult(Activity p0) {
        View currentFocus;
        if (p0 == null || !BuiltInFictitiousFunctionClassFactory(p0) || (currentFocus = p0.getWindow().getCurrentFocus()) == null) {
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
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0) {
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
    public static final void getAuthRequestContext(View p0) {
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

    private static boolean BuiltInFictitiousFunctionClassFactory(Activity p0) {
        return p0.getCurrentFocus() != null;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(final View p0, final KeyboardVisibilityListener p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0 != null) {
            final boolean[] zArr = {false};
            p0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.core.ui.util.KeyboardHelper$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    KeyboardHelper.MyBillsEntityDataFactory(p0, zArr, p1);
                }
            });
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object systemService = p0.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).toggleSoftInput(1, 0);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View view, boolean[] zArr, KeyboardVisibilityListener keyboardVisibilityListener) {
        Intrinsics.checkNotNullParameter(zArr, "");
        Intrinsics.checkNotNullParameter(keyboardVisibilityListener, "");
        Intrinsics.checkNotNullParameter(view, "");
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (view.getRootView().getHeight() - (rect.bottom - rect.top) > view.getRootView().getHeight() / 4) {
            zArr[0] = true;
            keyboardVisibilityListener.MyBillsEntityDataFactory();
        } else if (zArr[0]) {
            zArr[0] = false;
            keyboardVisibilityListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
