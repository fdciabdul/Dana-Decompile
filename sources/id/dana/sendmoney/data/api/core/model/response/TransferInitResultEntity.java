package id.dana.sendmoney.data.api.core.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.requestmoney.BundleKey;
import id.dana.sendmoney.data.api.core.model.TransferUserInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/data/api/core/model/response/TransferInitResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "feeAmount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getFeeAmount", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", BundleKey.MAXIMUM_AMOUNT, "getMaxAmount", BundleKey.MINIMUM_AMOUNT, "getMinAmount", "Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;", "payeeUserInfo", "Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;", "getPayeeUserInfo", "()Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;", "payerUserInfo", "getPayerUserInfo", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferInitResultEntity extends BaseRpcResult {
    private final MoneyViewEntity feeAmount;
    private final MoneyViewEntity maxAmount;
    private final MoneyViewEntity minAmount;
    private final TransferUserInfoEntity payeeUserInfo;
    private final TransferUserInfoEntity payerUserInfo;

    @JvmName(name = "getMinAmount")
    public final MoneyViewEntity getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getFeeAmount")
    public final MoneyViewEntity getFeeAmount() {
        return this.feeAmount;
    }

    @JvmName(name = "getPayerUserInfo")
    public final TransferUserInfoEntity getPayerUserInfo() {
        return this.payerUserInfo;
    }

    @JvmName(name = "getPayeeUserInfo")
    public final TransferUserInfoEntity getPayeeUserInfo() {
        return this.payeeUserInfo;
    }

    public TransferInitResultEntity(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, TransferUserInfoEntity transferUserInfoEntity, TransferUserInfoEntity transferUserInfoEntity2) {
        this.minAmount = moneyViewEntity;
        this.maxAmount = moneyViewEntity2;
        this.feeAmount = moneyViewEntity3;
        this.payerUserInfo = transferUserInfoEntity;
        this.payeeUserInfo = transferUserInfoEntity2;
    }
}
