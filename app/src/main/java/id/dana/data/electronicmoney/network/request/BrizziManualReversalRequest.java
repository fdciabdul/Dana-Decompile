package id.dana.data.electronicmoney.network.request;

import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.domain.electronicmoney.model.request.BrizziReversalInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/electronicmoney/network/request/BrizziManualReversalRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", ZimMessageChannel.K_RPC_RES_CODE, "getResponseCode", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "reversalInfo", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "getReversalInfo", "()Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BrizziManualReversalRequest extends BaseRpcRequest {
    private final String data;
    private final String responseCode;
    private final BrizziReversalInfo reversalInfo;

    @JvmName(name = "getData")
    public final String getData() {
        return this.data;
    }

    @JvmName(name = "getResponseCode")
    public final String getResponseCode() {
        return this.responseCode;
    }

    @JvmName(name = "getReversalInfo")
    public final BrizziReversalInfo getReversalInfo() {
        return this.reversalInfo;
    }

    public BrizziManualReversalRequest(String str, String str2, BrizziReversalInfo brizziReversalInfo) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(brizziReversalInfo, "");
        this.data = str;
        this.responseCode = str2;
        this.reversalInfo = brizziReversalInfo;
    }
}
