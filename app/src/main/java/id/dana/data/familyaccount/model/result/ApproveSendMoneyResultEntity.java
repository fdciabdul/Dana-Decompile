package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b!\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "Lid/dana/data/familyaccount/model/result/AttributesResultEntity;", "component4", "()Lid/dana/data/familyaccount/model/result/AttributesResultEntity;", "fundOrderId", "fundAmount", CashierKeyParams.CASHIER_ORDER_ID, "attributes", "copy", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/data/familyaccount/model/result/AttributesResultEntity;)Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/data/familyaccount/model/result/AttributesResultEntity;", "getAttributes", "Ljava/lang/String;", "getCashierOrderId", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getFundAmount", "getFundOrderId", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Lid/dana/data/familyaccount/model/result/AttributesResultEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ApproveSendMoneyResultEntity extends BaseRpcResult {
    private final AttributesResultEntity attributes;
    private final String cashierOrderId;
    private final MoneyViewEntity fundAmount;
    private final String fundOrderId;

    public static /* synthetic */ ApproveSendMoneyResultEntity copy$default(ApproveSendMoneyResultEntity approveSendMoneyResultEntity, String str, MoneyViewEntity moneyViewEntity, String str2, AttributesResultEntity attributesResultEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = approveSendMoneyResultEntity.fundOrderId;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = approveSendMoneyResultEntity.fundAmount;
        }
        if ((i & 4) != 0) {
            str2 = approveSendMoneyResultEntity.cashierOrderId;
        }
        if ((i & 8) != 0) {
            attributesResultEntity = approveSendMoneyResultEntity.attributes;
        }
        return approveSendMoneyResultEntity.copy(str, moneyViewEntity, str2, attributesResultEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getFundAmount() {
        return this.fundAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component4  reason: from getter */
    public final AttributesResultEntity getAttributes() {
        return this.attributes;
    }

    public final ApproveSendMoneyResultEntity copy(String fundOrderId, MoneyViewEntity fundAmount, String cashierOrderId, AttributesResultEntity attributes) {
        return new ApproveSendMoneyResultEntity(fundOrderId, fundAmount, cashierOrderId, attributes);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ApproveSendMoneyResultEntity) {
            ApproveSendMoneyResultEntity approveSendMoneyResultEntity = (ApproveSendMoneyResultEntity) other;
            return Intrinsics.areEqual(this.fundOrderId, approveSendMoneyResultEntity.fundOrderId) && Intrinsics.areEqual(this.fundAmount, approveSendMoneyResultEntity.fundAmount) && Intrinsics.areEqual(this.cashierOrderId, approveSendMoneyResultEntity.cashierOrderId) && Intrinsics.areEqual(this.attributes, approveSendMoneyResultEntity.attributes);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.fundOrderId;
        int hashCode = str == null ? 0 : str.hashCode();
        MoneyViewEntity moneyViewEntity = this.fundAmount;
        int hashCode2 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        AttributesResultEntity attributesResultEntity = this.attributes;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (attributesResultEntity != null ? attributesResultEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApproveSendMoneyResultEntity(fundOrderId=");
        sb.append(this.fundOrderId);
        sb.append(", fundAmount=");
        sb.append(this.fundAmount);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", attributes=");
        sb.append(this.attributes);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getFundOrderId")
    public final String getFundOrderId() {
        return this.fundOrderId;
    }

    @JvmName(name = "getFundAmount")
    public final MoneyViewEntity getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getAttributes")
    public final AttributesResultEntity getAttributes() {
        return this.attributes;
    }

    public ApproveSendMoneyResultEntity(String str, MoneyViewEntity moneyViewEntity, String str2, AttributesResultEntity attributesResultEntity) {
        this.fundOrderId = str;
        this.fundAmount = moneyViewEntity;
        this.cashierOrderId = str2;
        this.attributes = attributesResultEntity;
    }
}
