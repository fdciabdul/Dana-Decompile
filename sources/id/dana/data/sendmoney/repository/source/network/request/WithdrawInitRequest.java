package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/sendmoney/repository/source/network/request/WithdrawInitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "needCertifiedUser", "payMethod", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/data/sendmoney/repository/source/network/request/WithdrawInitRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getNeedCertifiedUser", "setNeedCertifiedUser", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getPayMethod", "setPayMethod", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WithdrawInitRequest extends BaseRpcRequest {
    private Boolean needCertifiedUser;
    private String payMethod;

    public static /* synthetic */ WithdrawInitRequest copy$default(WithdrawInitRequest withdrawInitRequest, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = withdrawInitRequest.needCertifiedUser;
        }
        if ((i & 2) != 0) {
            str = withdrawInitRequest.payMethod;
        }
        return withdrawInitRequest.copy(bool, str);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getNeedCertifiedUser() {
        return this.needCertifiedUser;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    public final WithdrawInitRequest copy(Boolean needCertifiedUser, String payMethod) {
        return new WithdrawInitRequest(needCertifiedUser, payMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WithdrawInitRequest) {
            WithdrawInitRequest withdrawInitRequest = (WithdrawInitRequest) other;
            return Intrinsics.areEqual(this.needCertifiedUser, withdrawInitRequest.needCertifiedUser) && Intrinsics.areEqual(this.payMethod, withdrawInitRequest.payMethod);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.needCertifiedUser;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.payMethod;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInitRequest(needCertifiedUser=");
        sb.append(this.needCertifiedUser);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getNeedCertifiedUser")
    public final Boolean getNeedCertifiedUser() {
        return this.needCertifiedUser;
    }

    @JvmName(name = "setNeedCertifiedUser")
    public final void setNeedCertifiedUser(Boolean bool) {
        this.needCertifiedUser = bool;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public WithdrawInitRequest(Boolean bool, String str) {
        this.needCertifiedUser = bool;
        this.payMethod = str;
    }
}
