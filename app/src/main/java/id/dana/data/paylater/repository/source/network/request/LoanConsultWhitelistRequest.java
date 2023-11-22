package id.dana.data.paylater.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/paylater/repository/source/network/request/LoanConsultWhitelistRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "", "withBill", "Z", "getWithBill", "()Z", "setWithBill", "(Z)V", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanConsultWhitelistRequest extends BaseRpcRequest {
    private String userId;
    private boolean withBill;

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
    }

    @JvmName(name = "getWithBill")
    public final boolean getWithBill() {
        return this.withBill;
    }

    @JvmName(name = "setWithBill")
    public final void setWithBill(boolean z) {
        this.withBill = z;
    }

    public LoanConsultWhitelistRequest(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
        this.withBill = z;
    }
}
