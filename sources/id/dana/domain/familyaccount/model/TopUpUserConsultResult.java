package id.dana.domain.familyaccount.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.requestmoney.BundleKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JR\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\t"}, d2 = {"Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "component1", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "", "Lid/dana/domain/payasset/model/PayMethodView;", "component3", "()Ljava/util/List;", "component4", "component5", BundleKey.MINIMUM_AMOUNT, BundleKey.MAXIMUM_AMOUNT, "payMethodView", "maxBalanceAmount", "maxMonthFundInAmount", "copy", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "getMaxAmount", "getMaxBalanceAmount", "getMaxMonthFundInAmount", "getMinAmount", "Ljava/util/List;", "getPayMethodView", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpUserConsultResult {
    private final MoneyView maxAmount;
    private final MoneyView maxBalanceAmount;
    private final MoneyView maxMonthFundInAmount;
    private final MoneyView minAmount;
    private final List<PayMethodView> payMethodView;

    public TopUpUserConsultResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TopUpUserConsultResult copy$default(TopUpUserConsultResult topUpUserConsultResult, MoneyView moneyView, MoneyView moneyView2, List list, MoneyView moneyView3, MoneyView moneyView4, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyView = topUpUserConsultResult.minAmount;
        }
        if ((i & 2) != 0) {
            moneyView2 = topUpUserConsultResult.maxAmount;
        }
        MoneyView moneyView5 = moneyView2;
        List<PayMethodView> list2 = list;
        if ((i & 4) != 0) {
            list2 = topUpUserConsultResult.payMethodView;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            moneyView3 = topUpUserConsultResult.maxBalanceAmount;
        }
        MoneyView moneyView6 = moneyView3;
        if ((i & 16) != 0) {
            moneyView4 = topUpUserConsultResult.maxMonthFundInAmount;
        }
        return topUpUserConsultResult.copy(moneyView, moneyView5, list3, moneyView6, moneyView4);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    public final List<PayMethodView> component3() {
        return this.payMethodView;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    public final TopUpUserConsultResult copy(MoneyView minAmount, MoneyView maxAmount, List<? extends PayMethodView> payMethodView, MoneyView maxBalanceAmount, MoneyView maxMonthFundInAmount) {
        return new TopUpUserConsultResult(minAmount, maxAmount, payMethodView, maxBalanceAmount, maxMonthFundInAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpUserConsultResult) {
            TopUpUserConsultResult topUpUserConsultResult = (TopUpUserConsultResult) other;
            return Intrinsics.areEqual(this.minAmount, topUpUserConsultResult.minAmount) && Intrinsics.areEqual(this.maxAmount, topUpUserConsultResult.maxAmount) && Intrinsics.areEqual(this.payMethodView, topUpUserConsultResult.payMethodView) && Intrinsics.areEqual(this.maxBalanceAmount, topUpUserConsultResult.maxBalanceAmount) && Intrinsics.areEqual(this.maxMonthFundInAmount, topUpUserConsultResult.maxMonthFundInAmount);
        }
        return false;
    }

    public final int hashCode() {
        MoneyView moneyView = this.minAmount;
        int hashCode = moneyView == null ? 0 : moneyView.hashCode();
        MoneyView moneyView2 = this.maxAmount;
        int hashCode2 = moneyView2 == null ? 0 : moneyView2.hashCode();
        List<PayMethodView> list = this.payMethodView;
        int hashCode3 = list == null ? 0 : list.hashCode();
        MoneyView moneyView3 = this.maxBalanceAmount;
        int hashCode4 = moneyView3 == null ? 0 : moneyView3.hashCode();
        MoneyView moneyView4 = this.maxMonthFundInAmount;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (moneyView4 != null ? moneyView4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpUserConsultResult(minAmount=");
        sb.append(this.minAmount);
        sb.append(", maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", payMethodView=");
        sb.append(this.payMethodView);
        sb.append(", maxBalanceAmount=");
        sb.append(this.maxBalanceAmount);
        sb.append(", maxMonthFundInAmount=");
        sb.append(this.maxMonthFundInAmount);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopUpUserConsultResult(MoneyView moneyView, MoneyView moneyView2, List<? extends PayMethodView> list, MoneyView moneyView3, MoneyView moneyView4) {
        this.minAmount = moneyView;
        this.maxAmount = moneyView2;
        this.payMethodView = list;
        this.maxBalanceAmount = moneyView3;
        this.maxMonthFundInAmount = moneyView4;
    }

    public /* synthetic */ TopUpUserConsultResult(MoneyView moneyView, MoneyView moneyView2, List list, MoneyView moneyView3, MoneyView moneyView4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : moneyView, (i & 2) != 0 ? null : moneyView2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : moneyView3, (i & 16) != 0 ? null : moneyView4);
    }

    @JvmName(name = "getMinAmount")
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getPayMethodView")
    public final List<PayMethodView> getPayMethodView() {
        return this.payMethodView;
    }

    @JvmName(name = "getMaxBalanceAmount")
    public final MoneyView getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    @JvmName(name = "getMaxMonthFundInAmount")
    public final MoneyView getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }
}
