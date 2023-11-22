package id.dana.network.base;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.network.exception.NetworkException;
import id.dana.network.util.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/network/base/ExceptionParserSuspend;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "S", "Lid/dana/network/util/Function;", SecurityConstants.KEY_TEXT, "apply", "(Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "getOperationType", "()Ljava/lang/String;", HummerConstants.CONTEXT, "", "setContext", "(Landroid/content/Context;)V", "operationType", "setOperationType", "(Ljava/lang/String;)V", "Landroid/content/Context;", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExceptionParserSuspend<S extends BaseRpcResult> implements Function<S, S> {
    private Context context;
    private String operationType;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.network.util.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj, Continuation continuation) {
        return apply((ExceptionParserSuspend<S>) ((BaseRpcResult) obj), (Continuation<? super ExceptionParserSuspend<S>>) continuation);
    }

    public final Object apply(S s, Continuation<? super S> continuation) {
        if (s.success) {
            return s;
        }
        throw new NetworkException(s);
    }

    public final String getOperationType() {
        return this.operationType;
    }

    public final void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }
}
