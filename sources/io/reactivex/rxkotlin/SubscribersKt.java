package io.reactivex.rxkotlin;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0000\u0010\n*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0002\u001a\u0012\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0002\u001aX\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00132\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001a2\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00172\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aX\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00132\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u001aH\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\n0\u00192\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00042\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"onCompleteStub", "Lkotlin/Function0;", "", "onErrorStub", "Lkotlin/Function1;", "", "onNextStub", "", "asConsumer", "Lio/reactivex/functions/Consumer;", "T", "asOnCompleteAction", "Lio/reactivex/functions/Action;", "asOnErrorConsumer", "blockingSubscribeBy", "Lio/reactivex/Flowable;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "onComplete", "onNext", "Lio/reactivex/Observable;", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/Completable;", "Lio/reactivex/Maybe;", "onSuccess", "Lio/reactivex/Single;", "rxkotlin"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SubscribersKt {
    private static final Function1<Object, Unit> PlaceComponentResult = new Function1<Object, Unit>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onNextStub$1
        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "");
        }
    };
    private static final Function1<Throwable, Unit> KClassImpl$Data$declaredNonStaticMembers$2 = new Function1<Throwable, Unit>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onErrorStub$1
        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "");
        }
    };
    private static final Function0<Unit> BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onCompleteStub$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Action$0] */
    private static final Action KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> function0) {
        if (function0 == BuiltInFictitiousFunctionClassFactory) {
            Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkExpressionValueIsNotNull(action, "");
            return action;
        }
        if (function0 != null) {
            function0 = new SubscribersKt$sam$io_reactivex_functions_Action$0(function0);
        }
        return (Action) function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.reactivex.rxkotlin.SubscribersKt$sam$io_reactivex_functions_Consumer$0] */
    public static /* synthetic */ Disposable MyBillsEntityDataFactory(Observable observable, Function1 function1, Function0 function0) {
        Consumer consumer;
        SubscribersKt$sam$io_reactivex_functions_Consumer$0 subscribersKt$sam$io_reactivex_functions_Consumer$0;
        Function1<Object, Unit> function12 = PlaceComponentResult;
        Intrinsics.checkParameterIsNotNull(observable, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        Intrinsics.checkParameterIsNotNull(function0, "");
        Intrinsics.checkParameterIsNotNull(function12, "");
        if (function12 == PlaceComponentResult) {
            consumer = Functions.PlaceComponentResult();
            Intrinsics.checkExpressionValueIsNotNull(consumer, "");
        } else {
            if (function12 != null) {
                function12 = new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function12);
            }
            consumer = (Consumer) function12;
        }
        if (function1 == KClassImpl$Data$declaredNonStaticMembers$2) {
            subscribersKt$sam$io_reactivex_functions_Consumer$0 = Functions.DatabaseTableConfigUtil;
            Intrinsics.checkExpressionValueIsNotNull(subscribersKt$sam$io_reactivex_functions_Consumer$0, "");
        } else {
            subscribersKt$sam$io_reactivex_functions_Consumer$0 = new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1);
        }
        Disposable subscribe = observable.subscribe(consumer, subscribersKt$sam$io_reactivex_functions_Consumer$0, KClassImpl$Data$declaredNonStaticMembers$2(function0));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "");
        return subscribe;
    }

    public static /* synthetic */ Disposable MyBillsEntityDataFactory(Completable completable, Function1 function1, Function0 function0, int i) {
        if ((i & 1) != 0) {
            function1 = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if ((i & 2) != 0) {
            function0 = BuiltInFictitiousFunctionClassFactory;
        }
        return BuiltInFictitiousFunctionClassFactory(completable, function1, function0);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final Disposable BuiltInFictitiousFunctionClassFactory(Completable completable, Function1<? super Throwable, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(completable, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        Intrinsics.checkParameterIsNotNull(function0, "");
        Function1<Throwable, Unit> function12 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (function1 == function12 && function0 == BuiltInFictitiousFunctionClassFactory) {
            Disposable q_ = completable.q_();
            Intrinsics.checkExpressionValueIsNotNull(q_, "");
            return q_;
        } else if (function1 == function12) {
            Disposable KClassImpl$Data$declaredNonStaticMembers$22 = completable.KClassImpl$Data$declaredNonStaticMembers$2(new SubscribersKt$sam$io_reactivex_functions_Action$0(function0));
            Intrinsics.checkExpressionValueIsNotNull(KClassImpl$Data$declaredNonStaticMembers$22, "");
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } else {
            Disposable authRequestContext = completable.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(function0), new SubscribersKt$sam$io_reactivex_functions_Consumer$0(function1));
            Intrinsics.checkExpressionValueIsNotNull(authRequestContext, "");
            return authRequestContext;
        }
    }
}
