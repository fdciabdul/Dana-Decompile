package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJC\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u00002\u0012\b\u0002\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u00070\nj\u0002`\u000b2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u00002\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u00070\nj\u0002`\u000b2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rj\u0002`\u000f¢\u0006\u0004\b\u0013\u0010\u0012JQ\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u00002\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rj\u0002`\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0013\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/domain/core/usecase/CompletableUseCase;", "Params", "", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Ljava/lang/Object;)Lio/reactivex/Completable;", "", "dispose", "()V", "Lkotlin/Function0;", "Lid/dana/domain/core/usecase/OnCompleteCallback;", "onComplete", "Lkotlin/Function1;", "", "Lid/dana/domain/core/usecase/OnErrorCallback;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "executeInBackground", "Lio/reactivex/functions/Action;", "onDispose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lio/reactivex/functions/Action;)V", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CompletableUseCase<Params> {
    private Disposable disposable;

    /* renamed from: executeInBackground$lambda-2 */
    public static final void m2280executeInBackground$lambda2() {
    }

    /* renamed from: executeInBackground$lambda-3 */
    public static final void m2281executeInBackground$lambda3() {
    }

    public abstract Completable buildUseCase(Params params);

    public final void execute(Params params) {
        execute$default(this, params, null, null, 6, null);
    }

    public final void execute(Params params, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        execute$default(this, params, function0, null, 4, null);
    }

    public final void executeInBackground(Params params, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        executeInBackground$default(this, params, function0, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(CompletableUseCase completableUseCase, Object obj, Function0 function0, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.CompletableUseCase$execute$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function1 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.CompletableUseCase$execute$2
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
        completableUseCase.execute(obj, function0, function1);
    }

    public final void execute(Params params, final Function0<Unit> onComplete, final Function1<? super Throwable, Unit> r6) {
        Intrinsics.checkNotNullParameter(onComplete, "");
        Intrinsics.checkNotNullParameter(r6, "");
        dispose();
        Completable buildUseCase = buildUseCase(params);
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(buildUseCase, MyBillsEntityDataFactory));
        Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult, "scheduler is null");
        this.disposable = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult)).getAuthRequestContext(new Action() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                CompletableUseCase.m2278execute$lambda0(Function0.this, this);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CompletableUseCase.m2279execute$lambda1(Function1.this, this, (Throwable) obj);
            }
        });
    }

    /* renamed from: execute$lambda-0 */
    public static final void m2278execute$lambda0(Function0 function0, CompletableUseCase completableUseCase) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(completableUseCase, "");
        function0.invoke();
        completableUseCase.dispose();
    }

    /* renamed from: execute$lambda-1 */
    public static final void m2279execute$lambda1(Function1 function1, CompletableUseCase completableUseCase, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(completableUseCase, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        completableUseCase.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void executeInBackground$default(CompletableUseCase completableUseCase, Object obj, Function0 function0, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeInBackground");
        }
        if ((i & 4) != 0) {
            function1 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.CompletableUseCase$executeInBackground$1
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
        completableUseCase.executeInBackground(obj, function0, function1);
    }

    public final void executeInBackground(Params params, Function0<Unit> onComplete, Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(onComplete, "");
        Intrinsics.checkNotNullParameter(r4, "");
        executeInBackground(params, onComplete, r4, new Action() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Action
            public final void run() {
                CompletableUseCase.m2280executeInBackground$lambda2();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void executeInBackground$default(CompletableUseCase completableUseCase, Object obj, Function0 function0, Function1 function1, Action action, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeInBackground");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.CompletableUseCase$executeInBackground$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function1 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.CompletableUseCase$executeInBackground$4
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
            action = new Action() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Action
                public final void run() {
                    CompletableUseCase.m2281executeInBackground$lambda3();
                }
            };
        }
        completableUseCase.executeInBackground(obj, function0, function1, action);
    }

    public final void executeInBackground(Params params, final Function0<Unit> onComplete, final Function1<? super Throwable, Unit> r12, Action onDispose) {
        Intrinsics.checkNotNullParameter(r12, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        Completable buildUseCase = buildUseCase(params);
        Scheduler jobScheduler = UseCaseSchedulers.getJobScheduler();
        ObjectHelper.PlaceComponentResult(jobScheduler, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(buildUseCase, jobScheduler));
        Consumer<? super Disposable> PlaceComponentResult = Functions.PlaceComponentResult();
        Consumer<? super Throwable> PlaceComponentResult2 = Functions.PlaceComponentResult();
        Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, PlaceComponentResult2, action, action, Functions.KClassImpl$Data$declaredNonStaticMembers$2, onDispose).getAuthRequestContext(new Action() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                CompletableUseCase.m2282executeInBackground$lambda4(Function0.this, this);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.CompletableUseCase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CompletableUseCase.m2283executeInBackground$lambda5(Function1.this, this, (Throwable) obj);
            }
        });
        dispose();
    }

    /* renamed from: executeInBackground$lambda-4 */
    public static final void m2282executeInBackground$lambda4(Function0 function0, CompletableUseCase completableUseCase) {
        Intrinsics.checkNotNullParameter(completableUseCase, "");
        if (function0 != null) {
            function0.invoke();
        }
        completableUseCase.dispose();
    }

    /* renamed from: executeInBackground$lambda-5 */
    public static final void m2283executeInBackground$lambda5(Function1 function1, CompletableUseCase completableUseCase, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(completableUseCase, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        completableUseCase.dispose();
    }

    public final void dispose() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.disposable = null;
    }
}
