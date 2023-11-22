package id.dana.network.base;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.exception.NetworkException;
import id.dana.network.util.FunctionFlow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/network/base/ExceptionParserAphomeFlow;", "Lid/dana/network/base/BaseRpcResultAphome;", "T", "Lid/dana/network/util/FunctionFlow;", SecurityConstants.KEY_TEXT, "apply", "(Lid/dana/network/base/BaseRpcResultAphome;)Lid/dana/network/base/BaseRpcResultAphome;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExceptionParserAphomeFlow<T extends BaseRpcResultAphome> implements FunctionFlow<T, T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.network.util.FunctionFlow
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((ExceptionParserAphomeFlow<T>) ((BaseRpcResultAphome) obj));
    }

    public final T apply(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        if (t.success) {
            return t;
        }
        throw new NetworkException((BaseRpcResultAphome) t);
    }
}
