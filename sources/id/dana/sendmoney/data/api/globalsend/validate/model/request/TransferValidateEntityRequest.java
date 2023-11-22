package id.dana.sendmoney.data.api.globalsend.validate.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "beneficiary", "Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "getBeneficiary", "()Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "cardCredential", "getCardCredential", WalletConstant.CARD_INDEX_NO, "getCardIndexNo", "instId", "getInstId", "", "onlyValidate", "Z", "getOnlyValidate", "()Z", "transferMethod", "getTransferMethod", "<init>", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateEntityRequest extends BaseRpcRequest {
    private final String amount;
    private final BeneficiaryInfoEntity beneficiary;
    private final String cardCredential;
    private final String cardIndexNo;
    private final String instId;
    private final boolean onlyValidate;
    private final String transferMethod;

    public /* synthetic */ TransferValidateEntityRequest(BeneficiaryInfoEntity beneficiaryInfoEntity, String str, String str2, boolean z, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(beneficiaryInfoEntity, str, str2, z, str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }

    @JvmName(name = "getBeneficiary")
    public final BeneficiaryInfoEntity getBeneficiary() {
        return this.beneficiary;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getOnlyValidate")
    public final boolean getOnlyValidate() {
        return this.onlyValidate;
    }

    @JvmName(name = "getCardCredential")
    public final String getCardCredential() {
        return this.cardCredential;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public TransferValidateEntityRequest(BeneficiaryInfoEntity beneficiaryInfoEntity, String str, String str2, boolean z, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(beneficiaryInfoEntity, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.beneficiary = beneficiaryInfoEntity;
        this.transferMethod = str;
        this.amount = str2;
        this.onlyValidate = z;
        this.cardCredential = str3;
        this.instId = str4;
        this.cardIndexNo = str5;
    }
}
