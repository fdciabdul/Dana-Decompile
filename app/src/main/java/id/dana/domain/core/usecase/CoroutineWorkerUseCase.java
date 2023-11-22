package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0086Bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/core/usecase/CoroutineWorkerUseCase;", "P", "", "R", "param", "execute", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/social/Result;", BridgeDSL.INVOKE, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class CoroutineWorkerUseCase<P, R> {
    public abstract Object execute(P p, Continuation<? super R> continuation);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(P r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<? extends R>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.domain.core.usecase.CoroutineWorkerUseCase$invoke$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.domain.core.usecase.CoroutineWorkerUseCase$invoke$1 r0 = (id.dana.domain.core.usecase.CoroutineWorkerUseCase$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.domain.core.usecase.CoroutineWorkerUseCase$invoke$1 r0 = new id.dana.domain.core.usecase.CoroutineWorkerUseCase$invoke$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L46
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3     // Catch: java.lang.Exception -> L46
            java.lang.Object r6 = r4.execute(r5, r0)     // Catch: java.lang.Exception -> L46
            if (r6 != r1) goto L3e
            return r1
        L3e:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success     // Catch: java.lang.Exception -> L46
            r5.<init>(r6)     // Catch: java.lang.Exception -> L46
            id.dana.domain.social.Result r5 = (id.dana.domain.social.Result) r5     // Catch: java.lang.Exception -> L46
            goto L4f
        L46:
            r5 = move-exception
            id.dana.domain.social.Result$Error r6 = new id.dana.domain.social.Result$Error
            r6.<init>(r5)
            r5 = r6
            id.dana.domain.social.Result r5 = (id.dana.domain.social.Result) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.core.usecase.CoroutineWorkerUseCase.invoke(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
