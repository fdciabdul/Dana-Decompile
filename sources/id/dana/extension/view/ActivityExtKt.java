package id.dana.extension.view;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import id.dana.base.BaseActivity;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/base/BaseActivity;", "Ljava/lang/Runnable;", "p0", "", "PlaceComponentResult", "(Lid/dana/base/BaseActivity;Ljava/lang/Runnable;)V", "Landroid/app/Activity;", "Landroid/view/View;", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Landroid/view/View;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityExtKt {
    public static final void MyBillsEntityDataFactory(Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "");
        Object systemService = activity.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static final void PlaceComponentResult(BaseActivity baseActivity, Runnable runnable) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Completable PlaceComponentResult = Completable.PlaceComponentResult(runnable);
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(PlaceComponentResult, PlaceComponentResult2));
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        baseActivity.addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult3)).q_());
    }
}
