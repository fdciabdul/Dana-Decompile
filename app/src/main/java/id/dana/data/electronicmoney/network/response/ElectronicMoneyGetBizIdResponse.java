package id.dana.data.electronicmoney.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "bizId", "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ElectronicMoneyGetBizIdResponse extends BaseRpcResult {
    private final String bizId;

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    public ElectronicMoneyGetBizIdResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizId = str;
    }
}
