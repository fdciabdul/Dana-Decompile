package id.dana.domain.social.core;

import com.alibaba.ariver.kernel.RVEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J6\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u001f\u0010\n\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0002\b\t\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8U@UX\u0094\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/domain/social/core/CompletableUseCase;", "", "T", "Lid/dana/domain/social/core/BaseUseCase;", "", "params", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "getOnErrorDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setOnErrorDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "onErrorDispatcher", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class CompletableUseCase<T> extends BaseUseCase<T, Unit> {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CompletableUseCase() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.social.core.CompletableUseCase.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.social.core.BaseUseCase
    @JvmName(name = "getOnErrorDispatcher")
    public CoroutineDispatcher getOnErrorDispatcher() {
        return UseCaseDispatchers.getJobDispatcher();
    }

    @Override // id.dana.domain.social.core.BaseUseCase
    @JvmName(name = "setOnErrorDispatcher")
    protected void setOnErrorDispatcher(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        setOnErrorDispatcher(coroutineDispatcher);
    }

    public final void execute(T params, Function1<? super Exception, Unit> onError) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(onError, "");
        invoke(params, new Function1<Unit, Unit>() { // from class: id.dana.domain.social.core.CompletableUseCase$execute$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, onError);
    }
}
