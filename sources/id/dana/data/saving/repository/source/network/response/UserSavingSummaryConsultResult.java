package id.dana.data.saving.repository.source.network.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.saving.model.SavingView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J^\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0018\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b,\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b-\u0010\u0004R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u000e"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component1", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "", "component3", "()J", "component4", "component5", "", "Lid/dana/data/saving/model/SavingView;", "component6", "()Ljava/util/List;", "", "component7", "()Z", "savingBalanceAmount", "maxSavingAmount", "maxSavingCount", "remainingAmount", "remainingCount", "savingViews", "hasNext", "copy", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;JLid/dana/network/response/expresspurchase/MoneyViewEntity;JLjava/util/List;Z)Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasNext", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getMaxSavingAmount", "J", "getMaxSavingCount", "getRemainingAmount", "getRemainingCount", "getSavingBalanceAmount", "Ljava/util/List;", "getSavingViews", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;JLid/dana/network/response/expresspurchase/MoneyViewEntity;JLjava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserSavingSummaryConsultResult extends BaseRpcResult {
    private final boolean hasNext;
    private final MoneyViewEntity maxSavingAmount;
    private final long maxSavingCount;
    private final MoneyViewEntity remainingAmount;
    private final long remainingCount;
    private final MoneyViewEntity savingBalanceAmount;
    private final List<SavingView> savingViews;

    /* renamed from: component1  reason: from getter */
    public final MoneyViewEntity getSavingBalanceAmount() {
        return this.savingBalanceAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getMaxSavingAmount() {
        return this.maxSavingAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final long getMaxSavingCount() {
        return this.maxSavingCount;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getRemainingAmount() {
        return this.remainingAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final long getRemainingCount() {
        return this.remainingCount;
    }

    public final List<SavingView> component6() {
        return this.savingViews;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final UserSavingSummaryConsultResult copy(MoneyViewEntity savingBalanceAmount, MoneyViewEntity maxSavingAmount, long maxSavingCount, MoneyViewEntity remainingAmount, long remainingCount, List<SavingView> savingViews, boolean hasNext) {
        Intrinsics.checkNotNullParameter(savingBalanceAmount, "");
        Intrinsics.checkNotNullParameter(maxSavingAmount, "");
        Intrinsics.checkNotNullParameter(remainingAmount, "");
        return new UserSavingSummaryConsultResult(savingBalanceAmount, maxSavingAmount, maxSavingCount, remainingAmount, remainingCount, savingViews, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserSavingSummaryConsultResult) {
            UserSavingSummaryConsultResult userSavingSummaryConsultResult = (UserSavingSummaryConsultResult) other;
            return Intrinsics.areEqual(this.savingBalanceAmount, userSavingSummaryConsultResult.savingBalanceAmount) && Intrinsics.areEqual(this.maxSavingAmount, userSavingSummaryConsultResult.maxSavingAmount) && this.maxSavingCount == userSavingSummaryConsultResult.maxSavingCount && Intrinsics.areEqual(this.remainingAmount, userSavingSummaryConsultResult.remainingAmount) && this.remainingCount == userSavingSummaryConsultResult.remainingCount && Intrinsics.areEqual(this.savingViews, userSavingSummaryConsultResult.savingViews) && this.hasNext == userSavingSummaryConsultResult.hasNext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.savingBalanceAmount.hashCode();
        int hashCode2 = this.maxSavingAmount.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.maxSavingCount);
        int hashCode3 = this.remainingAmount.hashCode();
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.remainingCount);
        List<SavingView> list = this.savingViews;
        int hashCode4 = list == null ? 0 : list.hashCode();
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + m) * 31) + hashCode3) * 31) + m2) * 31) + hashCode4) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserSavingSummaryConsultResult(savingBalanceAmount=");
        sb.append(this.savingBalanceAmount);
        sb.append(", maxSavingAmount=");
        sb.append(this.maxSavingAmount);
        sb.append(", maxSavingCount=");
        sb.append(this.maxSavingCount);
        sb.append(", remainingAmount=");
        sb.append(this.remainingAmount);
        sb.append(", remainingCount=");
        sb.append(this.remainingCount);
        sb.append(", savingViews=");
        sb.append(this.savingViews);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingBalanceAmount")
    public final MoneyViewEntity getSavingBalanceAmount() {
        return this.savingBalanceAmount;
    }

    @JvmName(name = "getMaxSavingAmount")
    public final MoneyViewEntity getMaxSavingAmount() {
        return this.maxSavingAmount;
    }

    @JvmName(name = "getMaxSavingCount")
    public final long getMaxSavingCount() {
        return this.maxSavingCount;
    }

    @JvmName(name = "getRemainingAmount")
    public final MoneyViewEntity getRemainingAmount() {
        return this.remainingAmount;
    }

    @JvmName(name = "getRemainingCount")
    public final long getRemainingCount() {
        return this.remainingCount;
    }

    @JvmName(name = "getSavingViews")
    public final List<SavingView> getSavingViews() {
        return this.savingViews;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public UserSavingSummaryConsultResult(MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, long j, MoneyViewEntity moneyViewEntity3, long j2, List<SavingView> list, boolean z) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity2, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity3, "");
        this.savingBalanceAmount = moneyViewEntity;
        this.maxSavingAmount = moneyViewEntity2;
        this.maxSavingCount = j;
        this.remainingAmount = moneyViewEntity3;
        this.remainingCount = j2;
        this.savingViews = list;
        this.hasNext = z;
    }
}
