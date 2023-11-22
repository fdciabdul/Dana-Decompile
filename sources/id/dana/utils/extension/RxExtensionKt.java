package id.dana.utils.extension;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"T", "Lio/reactivex/Observable;", "Lkotlin/Function1;", "", "", "p0", "", "", "p1", "p2", "", "p3", "PlaceComponentResult", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;IJ)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/Single;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;IJ)Lio/reactivex/Single;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxExtensionKt {
    public static final <T> Single<T> BuiltInFictitiousFunctionClassFactory(Single<T> single, final Function1<? super Throwable, Boolean> function1, final Function1<? super Integer, Unit> function12, final int i, final long j) {
        Flowable<T> authRequestContext;
        Single<T> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(single, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Function function = new Function() { // from class: id.dana.utils.extension.RxExtensionKt$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RxExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, i, function1, j, (Flowable) obj);
            }
        };
        if (single instanceof FuseToFlowable) {
            authRequestContext = ((FuseToFlowable) single).KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            authRequestContext = RxJavaPlugins.getAuthRequestContext(new SingleToFlowable(single));
        }
        ObjectHelper.PlaceComponentResult(function, "handler is null");
        BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new FlowableSingleSingle(RxJavaPlugins.getAuthRequestContext(new FlowableRetryWhen(authRequestContext, function))));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static final <T> Observable<T> PlaceComponentResult(Observable<T> observable, final Function1<? super Throwable, Boolean> function1, final Function1<? super Integer, Unit> function12, final int i, final long j) {
        Intrinsics.checkNotNullParameter(observable, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Observable<T> retryWhen = observable.retryWhen(new Function() { // from class: id.dana.utils.extension.RxExtensionKt$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RxExtensionKt.PlaceComponentResult(Function1.this, i, function1, j, (Observable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(retryWhen, "");
        return retryWhen;
    }

    public static /* synthetic */ Publisher KClassImpl$Data$declaredNonStaticMembers$2(final Function1 function1, final int i, final Function1 function12, final long j, Flowable flowable) {
        Flowable authRequestContext;
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(flowable, "");
        final Ref.IntRef intRef = new Ref.IntRef();
        Function function = new Function() { // from class: id.dana.utils.extension.RxExtensionKt$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RxExtensionKt.BuiltInFictitiousFunctionClassFactory(Function1.this, intRef, i, function12, j, (Throwable) obj);
            }
        };
        int BuiltInFictitiousFunctionClassFactory = Flowable.BuiltInFictitiousFunctionClassFactory();
        int BuiltInFictitiousFunctionClassFactory2 = Flowable.BuiltInFictitiousFunctionClassFactory();
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "maxConcurrency");
        ObjectHelper.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, "bufferSize");
        if (flowable instanceof ScalarCallable) {
            Object call = ((ScalarCallable) flowable).call();
            if (call == null) {
                authRequestContext = Flowable.getAuthRequestContext();
            } else {
                authRequestContext = FlowableScalarXMap.BuiltInFictitiousFunctionClassFactory(call, function);
            }
        } else {
            authRequestContext = RxJavaPlugins.getAuthRequestContext(new FlowableFlatMap(flowable, function, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2));
        }
        return authRequestContext;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, Ref.IntRef intRef, int i, Function1 function12, long j, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(intRef, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(th, "");
        function1.invoke(Integer.valueOf(intRef.element));
        if (intRef.element < i && ((Boolean) function12.invoke(th)).booleanValue()) {
            intRef.element++;
            return Observable.timer(j, TimeUnit.MILLISECONDS);
        }
        return Observable.error(th);
    }

    public static /* synthetic */ Publisher BuiltInFictitiousFunctionClassFactory(Function1 function1, Ref.IntRef intRef, int i, Function1 function12, long j, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(intRef, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(th, "");
        function1.invoke(Integer.valueOf(intRef.element));
        if (intRef.element < i && ((Boolean) function12.invoke(th)).booleanValue()) {
            intRef.element++;
            return Flowable.getAuthRequestContext(j, TimeUnit.MILLISECONDS);
        }
        return Flowable.MyBillsEntityDataFactory(th);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final Function1 function1, final int i, final Function1 function12, final long j, Observable observable) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(observable, "");
        final Ref.IntRef intRef = new Ref.IntRef();
        return observable.flatMap(new Function() { // from class: id.dana.utils.extension.RxExtensionKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RxExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, intRef, i, function12, j, (Throwable) obj);
            }
        });
    }
}
