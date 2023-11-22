package id.dana.data.wallet_v3.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/request/VerifyPinKtpRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "sendStrategy", "Ljava/lang/String;", "getSendStrategy", "()Ljava/lang/String;", "setSendStrategy", "(Ljava/lang/String;)V", "validateData", "getValidateData", "setValidateData", CashierKeyParams.VERIFICATION_METHOD, "getVerificationMethod", "setVerificationMethod", "verifyScene", "getVerifyScene", "setVerifyScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPinKtpRequest extends BaseRpcRequest {
    private String sendStrategy;
    private String validateData;
    private String verificationMethod;
    private String verifyScene;

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.validateData = str;
    }

    @JvmName(name = "getVerifyScene")
    public final String getVerifyScene() {
        return this.verifyScene;
    }

    @JvmName(name = "setVerifyScene")
    public final void setVerifyScene(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.verifyScene = str;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "setSendStrategy")
    public final void setSendStrategy(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.sendStrategy = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.verificationMethod = str;
    }

    public VerifyPinKtpRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.validateData = str;
        this.verifyScene = str2;
        this.sendStrategy = str3;
        this.verificationMethod = str4;
    }
}
