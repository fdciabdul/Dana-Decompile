package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.payasset.source.network.result.PayMethodViewDTO;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.requestmoney.BundleKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JR\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\t"}, d2 = {"Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component1", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "", "Lid/dana/data/payasset/source/network/result/PayMethodViewDTO;", "component3", "()Ljava/util/List;", "component4", "component5", BundleKey.MINIMUM_AMOUNT, BundleKey.MAXIMUM_AMOUNT, "payMethodViewDtos", "maxBalanceAmount", "maxMonthFundInAmount", "copy", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/data/familyaccount/model/result/TopUpUserConsultResultEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getMaxAmount", "getMaxBalanceAmount", "getMaxMonthFundInAmount", "getMinAmount", "Ljava/util/List;", "getPayMethodViewDtos", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpUserConsultResultEntity extends BaseRpcResult {
    private final MoneyViewEntity maxAmount;
    private final MoneyViewEntity maxBalanceAmount;
    private final MoneyViewEntity maxMonthFundInAmount;
    private final MoneyViewEntity minAmount;
    private final List<PayMethodViewDTO> payMethodViewDtos;

    public TopUpUserConsultResultEntity() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TopUpUserConsultResultEntity copy$default(TopUpUserConsultResultEntity topUpUserConsultResultEntity, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, List list, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyViewEntity = topUpUserConsultResultEntity.minAmount;
        }
        if ((i & 2) != 0) {
            moneyViewEntity2 = topUpUserConsultResultEntity.maxAmount;
        }
        MoneyViewEntity moneyViewEntity5 = moneyViewEntity2;
        List<PayMethodViewDTO> list2 = list;
        if ((i & 4) != 0) {
            list2 = topUpUserConsultResultEntity.payMethodViewDtos;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            moneyViewEntity3 = topUpUserConsultResultEntity.maxBalanceAmount;
        }
        MoneyViewEntity moneyViewEntity6 = moneyViewEntity3;
        if ((i & 16) != 0) {
            moneyViewEntity4 = topUpUserConsultResultEntity.maxMonthFundInAmount;
        }
        return topUpUserConsultResultEntity.copy(moneyViewEntity, moneyViewEntity5, list3, moneyViewEntity6, moneyViewEntity4);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyViewEntity getMinAmount() {
        return this.minAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    public final List<PayMethodViewDTO> component3() {
        return this.payMethodViewDtos;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    public final TopUpUserConsultResultEntity copy(MoneyViewEntity minAmount, MoneyViewEntity maxAmount, List<? extends PayMethodViewDTO> payMethodViewDtos, MoneyViewEntity maxBalanceAmount, MoneyViewEntity maxMonthFundInAmount) {
        return new TopUpUserConsultResultEntity(minAmount, maxAmount, payMethodViewDtos, maxBalanceAmount, maxMonthFundInAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpUserConsultResultEntity) {
            TopUpUserConsultResultEntity topUpUserConsultResultEntity = (TopUpUserConsultResultEntity) other;
            return Intrinsics.areEqual(this.minAmount, topUpUserConsultResultEntity.minAmount) && Intrinsics.areEqual(this.maxAmount, topUpUserConsultResultEntity.maxAmount) && Intrinsics.areEqual(this.payMethodViewDtos, topUpUserConsultResultEntity.payMethodViewDtos) && Intrinsics.areEqual(this.maxBalanceAmount, topUpUserConsultResultEntity.maxBalanceAmount) && Intrinsics.areEqual(this.maxMonthFundInAmount, topUpUserConsultResultEntity.maxMonthFundInAmount);
        }
        return false;
    }

    public final int hashCode() {
        MoneyViewEntity moneyViewEntity = this.minAmount;
        int hashCode = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.maxAmount;
        int hashCode2 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        List<PayMethodViewDTO> list = this.payMethodViewDtos;
        int hashCode3 = list == null ? 0 : list.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.maxBalanceAmount;
        int hashCode4 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        MoneyViewEntity moneyViewEntity4 = this.maxMonthFundInAmount;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (moneyViewEntity4 != null ? moneyViewEntity4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpUserConsultResultEntity(minAmount=");
        sb.append(this.minAmount);
        sb.append(", maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", payMethodViewDtos=");
        sb.append(this.payMethodViewDtos);
        sb.append(", maxBalanceAmount=");
        sb.append(this.maxBalanceAmount);
        sb.append(", maxMonthFundInAmount=");
        sb.append(this.maxMonthFundInAmount);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TopUpUserConsultResultEntity(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, List list, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : moneyViewEntity, (i & 2) != 0 ? null : moneyViewEntity2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : moneyViewEntity3, (i & 16) != 0 ? null : moneyViewEntity4);
    }

    @JvmName(name = "getMinAmount")
    public final MoneyViewEntity getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getPayMethodViewDtos")
    public final List<PayMethodViewDTO> getPayMethodViewDtos() {
        return this.payMethodViewDtos;
    }

    @JvmName(name = "getMaxBalanceAmount")
    public final MoneyViewEntity getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    @JvmName(name = "getMaxMonthFundInAmount")
    public final MoneyViewEntity getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopUpUserConsultResultEntity(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, List<? extends PayMethodViewDTO> list, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4) {
        this.minAmount = moneyViewEntity;
        this.maxAmount = moneyViewEntity2;
        this.payMethodViewDtos = list;
        this.maxBalanceAmount = moneyViewEntity3;
        this.maxMonthFundInAmount = moneyViewEntity4;
    }
}
