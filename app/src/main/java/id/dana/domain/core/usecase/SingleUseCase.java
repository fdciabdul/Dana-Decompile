package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJM\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012JW\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b"}, d2 = {"Lid/dana/domain/core/usecase/SingleUseCase;", "T", "Params", "", "params", "Lio/reactivex/Single;", "buildUseCase", "(Ljava/lang/Object;)Lio/reactivex/Single;", "", "dispose", "()V", "Lkotlin/Function1;", "Lid/dana/domain/core/usecase/OnSuccessCallback;", "onSuccess", "", "Lid/dana/domain/core/usecase/OnErrorCallback;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lio/reactivex/functions/Action;", "onDispose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lio/reactivex/functions/Action;)V", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/Scheduler;", "jobScheduler", "Lio/reactivex/Scheduler;", "postScheduler", "<init>", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SingleUseCase<T, Params> {
    private final CompositeDisposable disposable;
    private final Scheduler jobScheduler;
    private final Scheduler postScheduler;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.Scheduler, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SingleUseCase() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.SingleUseCase.<init>():void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.Scheduler, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SingleUseCase(io.reactivex.Scheduler r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.SingleUseCase.<init>(io.reactivex.Scheduler):void");
    }

    /* renamed from: execute$lambda-0 */
    public static final void m2286execute$lambda0() {
    }

    /* renamed from: execute$lambda-1 */
    public static final void m2287execute$lambda1() {
    }

    public abstract Single<T> buildUseCase(Params params);

    public final void execute(Params params, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        execute$default(this, params, function1, null, 4, null);
    }

    public SingleUseCase(Scheduler scheduler, Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler, "");
        Intrinsics.checkNotNullParameter(scheduler2, "");
        this.jobScheduler = scheduler;
        this.postScheduler = scheduler2;
        this.disposable = new CompositeDisposable();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ SingleUseCase(io.reactivex.Scheduler r2, io.reactivex.Scheduler r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r1 = this;
            r5 = r4 & 1
            java.lang.String r0 = ""
            if (r5 == 0) goto Ld
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.MyBillsEntityDataFactory()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
        Ld:
            r4 = r4 & 2
            if (r4 == 0) goto L18
            io.reactivex.Scheduler r3 = io.reactivex.android.schedulers.AndroidSchedulers.PlaceComponentResult()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
        L18:
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.SingleUseCase.<init>(io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(SingleUseCase singleUseCase, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.SingleUseCase$execute$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            };
        }
        singleUseCase.execute(obj, function1, function12);
    }

    public final void execute(Params params, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r4, "");
        execute(params, onSuccess, r4, new Action() { // from class: id.dana.domain.core.usecase.SingleUseCase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                SingleUseCase.m2286execute$lambda0();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(SingleUseCase singleUseCase, Object obj, Function1 function1, Function1 function12, Action action, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.SingleUseCase$execute$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 8) != 0) {
            action = new Action() { // from class: id.dana.domain.core.usecase.SingleUseCase$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Action
                public final void run() {
                    SingleUseCase.m2287execute$lambda1();
                }
            };
        }
        singleUseCase.execute(obj, function1, function12, action);
    }

    public final void execute(Params params, final Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, Unit> r6, Action onDispose) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r6, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        Single<T> buildUseCase = buildUseCase(params);
        Scheduler scheduler = this.jobScheduler;
        ObjectHelper.PlaceComponentResult(scheduler, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(buildUseCase, scheduler));
        Scheduler scheduler2 = this.postScheduler;
        ObjectHelper.PlaceComponentResult(scheduler2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, scheduler2));
        ObjectHelper.PlaceComponentResult(onDispose, "onDispose is null");
        this.disposable.getAuthRequestContext(RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleDoOnDispose(BuiltInFictitiousFunctionClassFactory2, onDispose)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.domain.core.usecase.SingleUseCase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SingleUseCase.m2288execute$lambda2(Function1.this, this, obj);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.SingleUseCase$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SingleUseCase.m2289execute$lambda3(Function1.this, this, (Throwable) obj);
            }
        }));
    }

    /* renamed from: execute$lambda-2 */
    public static final void m2288execute$lambda2(Function1 function1, SingleUseCase singleUseCase, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(singleUseCase, "");
        function1.invoke(obj);
        singleUseCase.dispose();
    }

    /* renamed from: execute$lambda-3 */
    public static final void m2289execute$lambda3(Function1 function1, SingleUseCase singleUseCase, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(singleUseCase, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        singleUseCase.dispose();
    }

    public final void dispose() {
        this.disposable.MyBillsEntityDataFactory();
    }
}
