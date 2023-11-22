package id.dana.domain.social.core;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.social.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u001b\u0012\b\b\u0002\u0010)\u001a\u00020\u0018\u0012\b\b\u0002\u0010*\u001a\u00020\u0018¢\u0006\u0004\b+\u0010,J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0005\u001a\u00028\u0000H¤@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00028\u00002\u0019\u0010\u000e\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\t0\f2\u001f\u0010\u0011\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0002\b\r\u0012\u0004\u0012\u00020\t0\fH\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0015@\u0015X\u0095\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0015@\u0015X\u0095\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010#\u001a\u00020\"8\u0015@\u0015X\u0095\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/social/core/BaseUseCase;", "T", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "dispose", "()V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "onSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, BridgeDSL.INVOKE, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "onErrorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getOnErrorDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setOnErrorDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "onSuccessDispatcher", "getOnSuccessDispatcher", "setOnSuccessDispatcher", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "getSupervisorJob", "()Lkotlinx/coroutines/CompletableJob;", "setSupervisorJob", "(Lkotlinx/coroutines/CompletableJob;)V", "threadExecutor", "postThreadExecutor", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseUseCase<T, R> implements CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private CoroutineDispatcher onErrorDispatcher;
    private CoroutineDispatcher onSuccessDispatcher;
    private CompletableJob supervisorJob;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseUseCase() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.social.core.BaseUseCase.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object buildUseCase(T t, Continuation<? super Result<? extends R>> continuation);

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    /* renamed from: getCoroutineContext */
    public CoroutineContext getPlaceComponentResult() {
        return this.$$delegate_0.getPlaceComponentResult();
    }

    public BaseUseCase(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        this.$$delegate_0 = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
        this.onSuccessDispatcher = coroutineDispatcher2;
        this.onErrorDispatcher = coroutineDispatcher2;
        this.supervisorJob = SupervisorKt.SupervisorJob$default(null, 1, null);
    }

    public /* synthetic */ BaseUseCase(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UseCaseDispatchers.getJobDispatcher() : coroutineDispatcher, (i & 2) != 0 ? UseCaseDispatchers.getPostDispatcher() : coroutineDispatcher2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getOnSuccessDispatcher")
    public CoroutineDispatcher getOnSuccessDispatcher() {
        return this.onSuccessDispatcher;
    }

    @JvmName(name = "setOnSuccessDispatcher")
    protected void setOnSuccessDispatcher(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.onSuccessDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getOnErrorDispatcher")
    public CoroutineDispatcher getOnErrorDispatcher() {
        return this.onErrorDispatcher;
    }

    @JvmName(name = "setOnErrorDispatcher")
    protected void setOnErrorDispatcher(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        this.onErrorDispatcher = coroutineDispatcher;
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

    public final void dispose() {
        JobKt.cancelChildren$default(getSupervisorJob(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invoke(T params, Function1<? super R, Unit> onSuccess, Function1<? super Exception, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(onError, "");
        BuildersKt__Builders_commonKt.launch$default(this, new BaseUseCase$invoke$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this, onError).plus(getSupervisorJob()), null, new BaseUseCase$invoke$1(this, params, onSuccess, onError, null), 2, null);
    }
}
