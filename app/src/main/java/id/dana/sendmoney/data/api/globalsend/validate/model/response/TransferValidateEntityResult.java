package id.dana.sendmoney.data.api.globalsend.validate.model.response;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "beneficiary", "Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "getBeneficiary", "()Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "", WalletConstant.CARD_INDEX_NO, "Ljava/lang/String;", "getCardIndexNo", "()Ljava/lang/String;", "maskedCardNo", "getMaskedCardNo", "<init>", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateEntityResult extends BaseRpcResultAphome {
    @SerializedName("beneficiary")
    private final BeneficiaryInfoEntity beneficiary;
    @SerializedName(WalletConstant.CARD_INDEX_NO)
    private final String cardIndexNo;
    @SerializedName("maskedCardNo")
    private final String maskedCardNo;

    @JvmName(name = "getBeneficiary")
    public final BeneficiaryInfoEntity getBeneficiary() {
        return this.beneficiary;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public TransferValidateEntityResult(BeneficiaryInfoEntity beneficiaryInfoEntity, String str, String str2) {
        this.beneficiary = beneficiaryInfoEntity;
        this.cardIndexNo = str;
        this.maskedCardNo = str2;
    }
}
