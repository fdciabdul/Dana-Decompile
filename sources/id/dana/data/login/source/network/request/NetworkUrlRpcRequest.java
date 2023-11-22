package id.dana.data.login.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/data/login/source/network/request/NetworkUrlRpcRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "consentId", "Ljava/lang/String;", "getConsentId", "()Ljava/lang/String;", "setConsentId", "(Ljava/lang/String;)V", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "userIdType", "getUserIdType", "setUserIdType", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NetworkUrlRpcRequest extends BaseRpcRequest {
    private String consentId;
    private String phoneNumber;
    private String userIdType;

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @JvmName(name = "getConsentId")
    public final String getConsentId() {
        return this.consentId;
    }

    @JvmName(name = "setConsentId")
    public final void setConsentId(String str) {
        this.consentId = str;
    }

    @JvmName(name = "getUserIdType")
    public final String getUserIdType() {
        return this.userIdType;
    }

    @JvmName(name = "setUserIdType")
    public final void setUserIdType(String str) {
        this.userIdType = str;
    }
}
