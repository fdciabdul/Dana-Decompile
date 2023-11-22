package id.dana.mybills.data.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "adminFee", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAdminFee", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "baseAmount", "getBaseAmount", "", "payMode", "Ljava/lang/String;", "getPayMode", "()Ljava/lang/String;", "subscriptionId", "getSubscriptionId", "trxAmount", "getTrxAmount", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayRequestEntity extends BaseRpcRequest {
    private final MoneyViewEntity adminFee;
    private final MoneyViewEntity baseAmount;
    private final String payMode;
    private final String subscriptionId;
    private final MoneyViewEntity trxAmount;

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getTrxAmount")
    public final MoneyViewEntity getTrxAmount() {
        return this.trxAmount;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "getAdminFee")
    public final MoneyViewEntity getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getBaseAmount")
    public final MoneyViewEntity getBaseAmount() {
        return this.baseAmount;
    }

    public HighlightTransactionPayRequestEntity(String str, MoneyViewEntity moneyViewEntity, String str2, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3) {
        Intrinsics.checkNotNullParameter(str2, "");
        this.subscriptionId = str;
        this.trxAmount = moneyViewEntity;
        this.payMode = str2;
        this.adminFee = moneyViewEntity2;
        this.baseAmount = moneyViewEntity3;
    }
}
