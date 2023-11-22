package id.dana.data.transferaccount.source.network;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/data/transferaccount/source/network/TransferAccountStatusRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "type", "getType", "setType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountStatusRequest extends BaseRpcRequest {
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "setToken")
    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.token = str;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
    }

    public TransferAccountStatusRequest(@JSONField(name = "token") String str, @JSONField(name = "type") String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.token = str;
        this.type = str2;
    }
}
