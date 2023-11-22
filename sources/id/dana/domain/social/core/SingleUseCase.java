package id.dana.domain.social.core;

import com.alibaba.ariver.kernel.RVEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u00062!\b\u0002\u0010\f\u001a\u001b\u0012\u0011\u0012\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/social/core/SingleUseCase;", "T", "", "R", "Lid/dana/domain/social/core/BaseUseCase;", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "threadExecutor", "postThreadExecutor", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SingleUseCase<T, R> extends BaseUseCase<T, R> {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.social.core.SingleUseCase.<init>():void");
    }

    public /* synthetic */ SingleUseCase(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UseCaseDispatchers.getJobDispatcher() : coroutineDispatcher, (i & 2) != 0 ? UseCaseDispatchers.getPostDispatcher() : coroutineDispatcher2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUseCase(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        super(coroutineDispatcher, coroutineDispatcher2);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void execute$default(SingleUseCase singleUseCase, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
        }
        if ((i & 2) != 0) {
            function1 = new Function1<R, Unit>() { // from class: id.dana.domain.social.core.SingleUseCase$execute$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(R r) {
                    Intrinsics.checkNotNullParameter(r, "");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                    invoke2((SingleUseCase$execute$1<R>) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function12 = new Function1<Exception, Unit>() { // from class: id.dana.domain.social.core.SingleUseCase$execute$2
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
        singleUseCase.execute(obj, function1, function12);
    }

    public final void execute(T params, Function1<? super R, Unit> onSuccess, Function1<? super Exception, Unit> r4) {
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(r4, "");
        invoke(params, onSuccess, r4);
    }
}
