package id.dana.utils;

import androidx.view.LifecycleObserver;
import androidx.view.ProcessLifecycleOwner;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/utils/LifecycleUtil;", "", "Landroidx/lifecycle/LifecycleObserver;", "p0", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "(Landroidx/lifecycle/LifecycleObserver;)Lio/reactivex/disposables/Disposable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LifecycleUtil {
    public static final LifecycleUtil INSTANCE = new LifecycleUtil();

    private LifecycleUtil() {
    }

    @JvmStatic
    public static final Disposable getAuthRequestContext(final LifecycleObserver p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.utils.LifecycleUtil$registerLifecycleObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().BuiltInFictitiousFunctionClassFactory(LifecycleObserver.this);
            }
        };
        Completable PlaceComponentResult = Completable.PlaceComponentResult(new Runnable() { // from class: id.dana.utils.LifecycleUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LifecycleUtil.BuiltInFictitiousFunctionClassFactory(Function0.this);
            }
        });
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Disposable q_ = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(PlaceComponentResult, PlaceComponentResult2)).q_();
        Intrinsics.checkNotNullExpressionValue(q_, "");
        return q_;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
