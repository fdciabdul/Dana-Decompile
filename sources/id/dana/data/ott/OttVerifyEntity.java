package id.dana.data.ott;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b"}, d2 = {"Lid/dana/data/ott/OttVerifyEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "merchantId", "Ljava/lang/String;", "getMerchantId", "()Ljava/lang/String;", "setMerchantId", "(Ljava/lang/String;)V", "mobileNo", "getMobileNo", "setMobileNo", "", "needLogout", "Ljava/lang/Boolean;", "getNeedLogout", "()Ljava/lang/Boolean;", "setNeedLogout", "(Ljava/lang/Boolean;)V", "userId", "getUserId", "setUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OttVerifyEntity extends BaseRpcResult {
    private String merchantId;
    private String mobileNo;
    private Boolean needLogout;
    private String userId;

    public OttVerifyEntity() {
        this(null, null, null, null, 15, null);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public /* synthetic */ OttVerifyEntity(String str, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getNeedLogout")
    public final Boolean getNeedLogout() {
        return this.needLogout;
    }

    @JvmName(name = "setNeedLogout")
    public final void setNeedLogout(Boolean bool) {
        this.needLogout = bool;
    }

    @JvmName(name = "getMobileNo")
    public final String getMobileNo() {
        return this.mobileNo;
    }

    @JvmName(name = "setMobileNo")
    public final void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public OttVerifyEntity(String str, String str2, Boolean bool, String str3) {
        this.userId = str;
        this.merchantId = str2;
        this.needLogout = bool;
        this.mobileNo = str3;
    }
}
