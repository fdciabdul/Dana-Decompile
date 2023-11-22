package id.dana.mybills.data.model.response;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/BillAmountDetail;", "", "", "component1", "()Ljava/lang/Long;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "period", "amount", "copy", "(Ljava/lang/Long;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/mybills/data/model/response/BillAmountDetail;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAmount", "Ljava/lang/Long;", "getPeriod", "<init>", "(Ljava/lang/Long;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillAmountDetail {
    private final MoneyViewEntity amount;
    private final Long period;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Long, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.network.response.expresspurchase.MoneyViewEntity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BillAmountDetail() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.model.response.BillAmountDetail.<init>():void");
    }

    public static /* synthetic */ BillAmountDetail copy$default(BillAmountDetail billAmountDetail, Long l, MoneyViewEntity moneyViewEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            l = billAmountDetail.period;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = billAmountDetail.amount;
        }
        return billAmountDetail.copy(l, moneyViewEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final Long getPeriod() {
        return this.period;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }

    public final BillAmountDetail copy(Long period, MoneyViewEntity amount) {
        return new BillAmountDetail(period, amount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillAmountDetail) {
            BillAmountDetail billAmountDetail = (BillAmountDetail) other;
            return Intrinsics.areEqual(this.period, billAmountDetail.period) && Intrinsics.areEqual(this.amount, billAmountDetail.amount);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.period;
        int hashCode = l == null ? 0 : l.hashCode();
        MoneyViewEntity moneyViewEntity = this.amount;
        return (hashCode * 31) + (moneyViewEntity != null ? moneyViewEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillAmountDetail(period=");
        sb.append(this.period);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(')');
        return sb.toString();
    }

    public BillAmountDetail(Long l, MoneyViewEntity moneyViewEntity) {
        this.period = l;
        this.amount = moneyViewEntity;
    }

    public /* synthetic */ BillAmountDetail(Long l, MoneyViewEntity moneyViewEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : moneyViewEntity);
    }

    @JvmName(name = "getPeriod")
    public final Long getPeriod() {
        return this.period;
    }

    @JvmName(name = "getAmount")
    public final MoneyViewEntity getAmount() {
        return this.amount;
    }
}
