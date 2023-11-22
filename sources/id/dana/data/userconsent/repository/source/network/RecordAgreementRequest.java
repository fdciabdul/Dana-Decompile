package id.dana.data.userconsent.repository.source.network;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/userconsent/repository/source/network/RecordAgreementRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "agreementKey", "Ljava/lang/String;", "getAgreementKey", "()Ljava/lang/String;", "agreementType", "getAgreementType", "", "userAgree", "Z", "getUserAgree", "()Z", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecordAgreementRequest extends BaseRpcRequest {
    private final String agreementKey;
    private final String agreementType;
    private final boolean userAgree;

    @JvmName(name = "getAgreementKey")
    public final String getAgreementKey() {
        return this.agreementKey;
    }

    @JvmName(name = "getUserAgree")
    public final boolean getUserAgree() {
        return this.userAgree;
    }

    @JvmName(name = "getAgreementType")
    public final String getAgreementType() {
        return this.agreementType;
    }

    public RecordAgreementRequest(String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.agreementKey = str;
        this.userAgree = z;
        this.agreementType = str2;
    }
}
