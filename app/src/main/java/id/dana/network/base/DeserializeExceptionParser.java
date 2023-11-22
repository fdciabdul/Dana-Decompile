package id.dana.network.base;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.util.BaseNetworkUtils;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/network/base/DeserializeExceptionParser;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "T", "Lio/reactivex/functions/Function;", "", "Lio/reactivex/SingleSource;", SecurityConstants.KEY_TEXT, "apply", "(Ljava/lang/Throwable;)Lio/reactivex/SingleSource;", "Ljava/lang/Class;", "outputType", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeserializeExceptionParser<T extends BaseRpcResult> implements Function<Throwable, SingleSource<T>> {
    private final Class<T> outputType;

    public DeserializeExceptionParser(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        this.outputType = cls;
    }

    @Override // io.reactivex.functions.Function
    public final SingleSource<T> apply(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "");
        try {
            BaseRpcResult onDeserializeFailure = BaseNetworkUtils.onDeserializeFailure(this.outputType, t);
            Intrinsics.checkNotNullExpressionValue(onDeserializeFailure, "");
            Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(onDeserializeFailure);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            Single authRequestContext = Single.getAuthRequestContext(e);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return authRequestContext;
        }
    }
}
