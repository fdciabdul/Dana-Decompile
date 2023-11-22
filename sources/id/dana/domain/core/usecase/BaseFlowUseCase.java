package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007Ji\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Param", "Result", "", "param", "Lkotlinx/coroutines/flow/Flow;", "buildUseCase", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "", "onStart", "Lkotlin/Function1;", "onSuccess", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "onCompletion", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseFlowUseCase<Param, Result> {
    private final CoroutineDispatcher defaultDispatcher;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseFlowUseCase() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.BaseFlowUseCase.<init>():void");
    }

    public abstract Flow<Result> buildUseCase(Param param);

    public BaseFlowUseCase(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.defaultDispatcher = coroutineDispatcher;
    }

    public /* synthetic */ BaseFlowUseCase(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public static /* synthetic */ void execute$default(BaseFlowUseCase baseFlowUseCase, Object obj, Function0 function0, Function1 function1, Function1 function12, Function0 function02, CoroutineScope coroutineScope, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        BaseFlowUseCase$execute$1 baseFlowUseCase$execute$1 = function0;
        if ((i & 2) != 0) {
            baseFlowUseCase$execute$1 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseFlowUseCase$execute$1
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
        Function0 function03 = baseFlowUseCase$execute$1;
        BaseFlowUseCase$execute$2 baseFlowUseCase$execute$2 = function1;
        if ((i & 4) != 0) {
            baseFlowUseCase$execute$2 = new Function1<Result, Unit>() { // from class: id.dana.domain.core.usecase.BaseFlowUseCase$execute$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Result result) {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                    invoke2((BaseFlowUseCase$execute$2<Result>) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function13 = baseFlowUseCase$execute$2;
        BaseFlowUseCase$execute$3 baseFlowUseCase$execute$3 = function12;
        if ((i & 8) != 0) {
            baseFlowUseCase$execute$3 = new Function1<Throwable, Unit>() { // from class: id.dana.domain.core.usecase.BaseFlowUseCase$execute$3
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
        Function1 function14 = baseFlowUseCase$execute$3;
        BaseFlowUseCase$execute$4 baseFlowUseCase$execute$4 = function02;
        if ((i & 16) != 0) {
            baseFlowUseCase$execute$4 = new Function0<Unit>() { // from class: id.dana.domain.core.usecase.BaseFlowUseCase$execute$4
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
        baseFlowUseCase.execute(obj, function03, function13, function14, baseFlowUseCase$execute$4, coroutineScope);
    }

    public final void execute(Param param, Function0<Unit> onStart, Function1<? super Result, Unit> onSuccess, Function1<? super Throwable, Unit> r6, Function0<Unit> onCompletion, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(onStart, "");
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r6, "");
        Intrinsics.checkNotNullParameter(onCompletion, "");
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        FlowKt.launchIn(FlowKt.onCompletion(FlowKt.m4649catch(FlowKt.onEach(FlowKt.onStart(FlowKt.flowOn(buildUseCase(param), this.defaultDispatcher), new BaseFlowUseCase$execute$5(onStart, null)), new BaseFlowUseCase$execute$6(onSuccess, null)), new BaseFlowUseCase$execute$7(r6, null)), new BaseFlowUseCase$execute$8(onCompletion, null)), coroutineScope);
    }
}
