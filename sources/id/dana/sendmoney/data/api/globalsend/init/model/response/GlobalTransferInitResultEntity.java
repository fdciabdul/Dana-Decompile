package id.dana.sendmoney.data.api.globalsend.init.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.requestmoney.BundleKey;
import id.dana.sendmoney.data.api.globalsend.init.model.SubTransferMethodInfoEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.TransferUserInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/model/CurrencyAmountResult;", "feeAmount", "Lid/dana/data/model/CurrencyAmountResult;", "getFeeAmount", "()Lid/dana/data/model/CurrencyAmountResult;", BundleKey.MAXIMUM_AMOUNT, "getMaxAmount", BundleKey.MINIMUM_AMOUNT, "getMinAmount", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;", "payeeUserInfo", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;", "getPayeeUserInfo", "()Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;", "payerUserInfo", "getPayerUserInfo", "", "Lid/dana/sendmoney/data/api/globalsend/init/model/SubTransferMethodInfoEntity;", "subTransferMethodInfos", "Ljava/util/List;", "getSubTransferMethodInfos", "()Ljava/util/List;", "<init>", "(Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Ljava/util/List;Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitResultEntity extends BaseRpcResult {
    private final CurrencyAmountResult feeAmount;
    private final CurrencyAmountResult maxAmount;
    private final CurrencyAmountResult minAmount;
    private final TransferUserInfoEntity payeeUserInfo;
    private final TransferUserInfoEntity payerUserInfo;
    private final List<SubTransferMethodInfoEntity> subTransferMethodInfos;

    @JvmName(name = "getMinAmount")
    public final CurrencyAmountResult getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final CurrencyAmountResult getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getFeeAmount")
    public final CurrencyAmountResult getFeeAmount() {
        return this.feeAmount;
    }

    @JvmName(name = "getSubTransferMethodInfos")
    public final List<SubTransferMethodInfoEntity> getSubTransferMethodInfos() {
        return this.subTransferMethodInfos;
    }

    @JvmName(name = "getPayerUserInfo")
    public final TransferUserInfoEntity getPayerUserInfo() {
        return this.payerUserInfo;
    }

    @JvmName(name = "getPayeeUserInfo")
    public final TransferUserInfoEntity getPayeeUserInfo() {
        return this.payeeUserInfo;
    }

    public GlobalTransferInitResultEntity(CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, CurrencyAmountResult currencyAmountResult3, List<SubTransferMethodInfoEntity> list, TransferUserInfoEntity transferUserInfoEntity, TransferUserInfoEntity transferUserInfoEntity2) {
        this.minAmount = currencyAmountResult;
        this.maxAmount = currencyAmountResult2;
        this.feeAmount = currencyAmountResult3;
        this.subTransferMethodInfos = list;
        this.payerUserInfo = transferUserInfoEntity;
        this.payeeUserInfo = transferUserInfoEntity2;
    }
}
