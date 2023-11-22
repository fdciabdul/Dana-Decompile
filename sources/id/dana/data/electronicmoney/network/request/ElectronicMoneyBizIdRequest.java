package id.dana.data.electronicmoney.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/electronicmoney/network/request/ElectronicMoneyBizIdRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "bizEventName", "Ljava/lang/String;", "getBizEventName", "()Ljava/lang/String;", "setBizEventName", "(Ljava/lang/String;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ElectronicMoneyBizIdRequest extends BaseRpcRequest {
    private String bizEventName;

    @JvmName(name = "getBizEventName")
    public final String getBizEventName() {
        return this.bizEventName;
    }

    @JvmName(name = "setBizEventName")
    public final void setBizEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizEventName = str;
    }

    public ElectronicMoneyBizIdRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bizEventName = str;
    }
}
