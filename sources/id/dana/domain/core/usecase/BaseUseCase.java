package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b(\u0010\nJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJM\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012Ja\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0014¢\u0006\u0004\b\u0011\u0010\u0016Jq\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0011\u0010\u0019JM\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f¢\u0006\u0004\b\u001a\u0010\u0012Jo\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u000f2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001d\u001a\u00020\u001cH\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010!\u001a\u00020 *\u00020\u001fH\u0004¢\u0006\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0005X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'"}, d2 = {"Lid/dana/domain/core/usecase/BaseUseCase;", "T", "Params", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/Object;)Lio/reactivex/Observable;", "", "dispose", "()V", "Lkotlin/Function1;", "Lid/dana/domain/core/usecase/OnSuccessCallback;", "onSuccess", "", "Lid/dana/domain/core/usecase/OnErrorCallback;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "Lid/dana/domain/core/usecase/OnCompleteCallback;", "onComplete", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/functions/Action;", "onDispose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lio/reactivex/functions/Action;)V", "executeInBackground", "executeRxInBackground", "", "getSubclassPath", "()Ljava/lang/String;", "Lio/reactivex/disposables/Disposable;", "", "collect", "(Lio/reactivex/disposables/Disposable;)Z", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseUseCase<T, Params> {
    private final CompositeDisposable disposable = new CompositeDisposable();

    /* renamed from: execute$lambda-0 */
    public static final void m2256execute$lambda0() {
    }

    /* renamed from: execute$lambda-1 */
    public static final void m2257execute$lambda1() {
    }

    /* renamed from: execute$lambda-2 */
    public static final void m2258execute$lambda2() {
    }

    /* renamed from: executeInBackground$lambda-7 */
    public static final void m2264executeInBackground$lambda7() {
    }

    /* renamed from: executeInBackground$lambda-8 */
    public static final void m2265executeInBackground$lambda8() {
    }

    public abstract Observable<T> buildUseCase(Params params);

    public final void execute(Params params, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        execute$default(this, params, function1, null, 4, null);
    }

    public final void executeInBackground(Params params, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        executeInBackground$default(this, params, function1, null, 4, null);
    }

    @JvmName(name = "getDisposable")
    public final CompositeDisposable getDisposable() {
        return this.disposable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(BaseUseCase baseUseCase, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$execute$1
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
        baseUseCase.execute(obj, function1, function12);
    }

    public final void execute(Params params, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> r10) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r10, "");
        execute(params, onSuccess, r10, null, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCase.m2256execute$lambda0();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(BaseUseCase baseUseCase, Object obj, Function1 function1, Function1 function12, Function0 function0, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$execute$3
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
            function0 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$execute$4
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
        baseUseCase.execute(obj, function1, function12, function0);
    }

    public final void execute(Params params, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> r10, Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r10, "");
        Intrinsics.checkNotNullParameter(onComplete, "");
        execute(params, onSuccess, r10, onComplete, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCase.m2257execute$lambda1();
            }
        });
    }

    public static /* synthetic */ void execute$default(BaseUseCase baseUseCase, Object obj, Function1 function1, Function1 function12, Function0 function0, Action action, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        BaseUseCase$execute$6 baseUseCase$execute$6 = function12;
        if ((i & 4) != 0) {
            baseUseCase$execute$6 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$execute$6
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
        Function1 function13 = baseUseCase$execute$6;
        BaseUseCase$execute$7 baseUseCase$execute$7 = function0;
        if ((i & 8) != 0) {
            baseUseCase$execute$7 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$execute$7
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
        Function0 function02 = baseUseCase$execute$7;
        if ((i & 16) != 0) {
            action = new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BaseUseCase.m2258execute$lambda2();
                }
            };
        }
        baseUseCase.execute(obj, function1, function13, function02, action);
    }

    public void execute(Params params, final Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, Unit> r5, final Function0<Unit> onComplete, Action onDispose) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r5, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        System.out.print((Object) "test");
        this.disposable.getAuthRequestContext(buildUseCase(params).subscribeOn(UseCaseSchedulers.getJobScheduler()).observeOn(UseCaseSchedulers.getPostScheduler()).doOnDispose(onDispose).subscribe(new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCase.m2259execute$lambda3(Function1.this, obj);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCase.m2260execute$lambda4(BaseUseCase.this, r5, (Throwable) obj);
            }
        }, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCase.m2261execute$lambda5(Function0.this, this);
            }
        }));
    }

    /* renamed from: execute$lambda-3 */
    public static final void m2259execute$lambda3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    /* renamed from: execute$lambda-4 */
    public static final void m2260execute$lambda4(BaseUseCase baseUseCase, Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(baseUseCase, "");
        Intrinsics.checkNotNullParameter(function1, "");
        baseUseCase.getSubclassPath();
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        baseUseCase.dispose();
    }

    /* renamed from: execute$lambda-5 */
    public static final void m2261execute$lambda5(Function0 function0, BaseUseCase baseUseCase) {
        Intrinsics.checkNotNullParameter(baseUseCase, "");
        if (function0 != null) {
            function0.invoke();
        }
        baseUseCase.dispose();
    }

    public final String getSubclassPath() {
        String name = getClass().asSubclass(getClass()).getName();
        return name == null ? "Unknown" : name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void executeInBackground$default(BaseUseCase baseUseCase, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeInBackground");
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$executeInBackground$1
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
        baseUseCase.executeInBackground(obj, function1, function12);
    }

    public final void executeInBackground(Params params, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> r10) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r10, "");
        executeInBackground(params, onSuccess, r10, null, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCase.m2264executeInBackground$lambda7();
            }
        });
    }

    public static /* synthetic */ void executeInBackground$default(BaseUseCase baseUseCase, Object obj, Function1 function1, Function1 function12, Function0 function0, Action action, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeInBackground");
        }
        BaseUseCase$executeInBackground$3 baseUseCase$executeInBackground$3 = function12;
        if ((i & 4) != 0) {
            baseUseCase$executeInBackground$3 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$executeInBackground$3
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
        Function1 function13 = baseUseCase$executeInBackground$3;
        BaseUseCase$executeInBackground$4 baseUseCase$executeInBackground$4 = function0;
        if ((i & 8) != 0) {
            baseUseCase$executeInBackground$4 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseUseCase$executeInBackground$4
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
        Function0 function02 = baseUseCase$executeInBackground$4;
        if ((i & 16) != 0) {
            action = new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Action
                public final void run() {
                    BaseUseCase.m2265executeInBackground$lambda8();
                }
            };
        }
        baseUseCase.executeInBackground(obj, function1, function13, function02, action);
    }

    public final void executeInBackground(Params params, final Function1<? super T, Unit> onSuccess, final Function1<? super Throwable, Unit> r4, final Function0<Unit> onComplete, Action onDispose) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r4, "");
        Intrinsics.checkNotNullParameter(onDispose, "");
        this.disposable.getAuthRequestContext(buildUseCase(params).subscribeOn(UseCaseSchedulers.getJobScheduler()).doOnDispose(onDispose).subscribe(new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCase.m2266executeInBackground$lambda9(Function1.this, obj);
            }
        }, new Consumer() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseUseCase.m2262executeInBackground$lambda10(BaseUseCase.this, r4, (Throwable) obj);
            }
        }, new Action() { // from class: id.dana.domain.core.usecase.BaseUseCase$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseUseCase.m2263executeInBackground$lambda11(Function0.this, this);
            }
        }));
    }

    /* renamed from: executeInBackground$lambda-9 */
    public static final void m2266executeInBackground$lambda9(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(obj);
    }

    /* renamed from: executeInBackground$lambda-10 */
    public static final void m2262executeInBackground$lambda10(BaseUseCase baseUseCase, Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(baseUseCase, "");
        Intrinsics.checkNotNullParameter(function1, "");
        baseUseCase.getSubclassPath();
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
        baseUseCase.dispose();
    }

    /* renamed from: executeInBackground$lambda-11 */
    public static final void m2263executeInBackground$lambda11(Function0 function0, BaseUseCase baseUseCase) {
        Intrinsics.checkNotNullParameter(baseUseCase, "");
        if (function0 != null) {
            function0.invoke();
        }
        baseUseCase.dispose();
    }

    public final Observable<T> executeRxInBackground(Params params) {
        Observable<T> subscribeOn = buildUseCase(params).subscribeOn(UseCaseSchedulers.getJobScheduler());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }

    public void dispose() {
        this.disposable.MyBillsEntityDataFactory();
    }

    public final boolean collect(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        return this.disposable.getAuthRequestContext(disposable);
    }
}
