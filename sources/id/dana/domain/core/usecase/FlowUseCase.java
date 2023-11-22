package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b$\u0010%J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\n2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\rJX\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00002\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u00050\u000e2!\b\u0002\u0010\u0013\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0015@\u0015X\u0095\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/domain/core/usecase/FlowUseCase;", "P", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "cancelChildren", "()V", "dispose", "params", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/social/Result;", "execute", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "onSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, BridgeDSL.INVOKE, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "getSupervisorJob", "()Lkotlinx/coroutines/CompletableJob;", "setSupervisorJob", "(Lkotlinx/coroutines/CompletableJob;)V", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class FlowUseCase<P, R> implements CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final CoroutineDispatcher coroutineDispatcher;
    private CompletableJob supervisorJob;

    public abstract Flow<Result<R>> execute(P params);

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    /* renamed from: getCoroutineContext */
    public CoroutineContext getPlaceComponentResult() {
        return this.$$delegate_0.getPlaceComponentResult();
    }

    public final void invoke(P p) {
        invoke$default(this, p, null, null, 6, null);
    }

    public final void invoke(P p, Function1<? super R, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        invoke$default(this, p, function1, null, 4, null);
    }

    public FlowUseCase(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.coroutineDispatcher = coroutineDispatcher;
        this.$$delegate_0 = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
        this.supervisorJob = SupervisorKt.SupervisorJob$default(null, 1, null);
    }

    @JvmName(name = "getSupervisorJob")
    protected CompletableJob getSupervisorJob() {
        return this.supervisorJob;
    }

    @JvmName(name = "setSupervisorJob")
    protected void setSupervisorJob(CompletableJob completableJob) {
        Intrinsics.checkNotNullParameter(completableJob, "");
        this.supervisorJob = completableJob;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void invoke$default(FlowUseCase flowUseCase, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i & 2) != 0) {
            function1 = new Function1<R, Unit>() { // from class: id.dana.domain.core.usecase.FlowUseCase$invoke$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(R r) {
                    Intrinsics.checkNotNullParameter(r, "");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                    invoke2((FlowUseCase$invoke$1<R>) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Exception, Unit>() { // from class: id.dana.domain.core.usecase.FlowUseCase$invoke$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                    invoke2(exc);
                    return Unit.INSTANCE;
                }
            };
        }
        flowUseCase.invoke(obj, function1, function12);
    }

    public final void dispose() {
        Job.DefaultImpls.cancel$default(getSupervisorJob(), null, 1, null);
    }

    public final void cancelChildren() {
        JobKt__JobKt.cancelChildren$default(getSupervisorJob(), null, 1, null);
    }

    public final void invoke(P p, Function1<? super R, Unit> function1, Function1<? super Exception, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        BuildersKt__Builders_commonKt.launch$default(this, new FlowUseCase$invoke$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this, function12).plus(getSupervisorJob()), null, new FlowUseCase$invoke$3(this, p, function1, function12, null), 2, null);
    }
}
