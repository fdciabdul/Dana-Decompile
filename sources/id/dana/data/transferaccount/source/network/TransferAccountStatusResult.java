package id.dana.data.transferaccount.source.network;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/transferaccount/source/network/TransferAccountStatusResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountStatusResult extends BaseRpcResult {
    public static final String CHANGE_MOBILE = "CHANGE_MOBILE_NUMBER";
    public static final String CHANGE_PIN = "CHANGE_PIN";
    public static final String DELETE_USER = "DELETE_USER";
    public static final String OPERATION_STATUS = "OPERATION_STATUS";
    public static final String TRANSFER_BALANCE = "TRANSFER_BALANCE";
    @SerializedName("status")
    private String status;

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    public TransferAccountStatusResult(@JSONField(name = "status") String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }
}
