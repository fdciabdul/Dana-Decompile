package id.dana.data.social.core;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Unknown type variable: T in type: id.dana.data.social.core.BaseNetwork<T> */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.data.social.core.BaseNetwork", f = "BaseNetwork.kt", i = {0}, l = {43, 69}, m = "wrapper", n = {"exceptionParser"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class BaseNetwork$wrapper$2<S extends BaseRpcResult> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseNetwork<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unknown type variable: T in type: id.dana.data.social.core.BaseNetwork<T> */
    public BaseNetwork$wrapper$2(BaseNetwork<T> baseNetwork, Continuation<? super BaseNetwork$wrapper$2> continuation) {
        super(continuation);
        this.this$0 = baseNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.wrapper(null, null, this);
    }
}
