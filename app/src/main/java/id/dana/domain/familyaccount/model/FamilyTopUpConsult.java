package id.dana.domain.familyaccount.model;

import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;", "", "Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "component1", "()Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "Lid/dana/domain/user/CurrencyAmount;", "component2", "()Lid/dana/domain/user/CurrencyAmount;", "topUpUserConsultResult", "balance", "copy", "(Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;Lid/dana/domain/user/CurrencyAmount;)Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/user/CurrencyAmount;", "getBalance", "Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;", "getTopUpUserConsultResult", "<init>", "(Lid/dana/domain/familyaccount/model/TopUpUserConsultResult;Lid/dana/domain/user/CurrencyAmount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FamilyTopUpConsult {
    private final CurrencyAmount balance;
    private final TopUpUserConsultResult topUpUserConsultResult;

    public static /* synthetic */ FamilyTopUpConsult copy$default(FamilyTopUpConsult familyTopUpConsult, TopUpUserConsultResult topUpUserConsultResult, CurrencyAmount currencyAmount, int i, Object obj) {
        if ((i & 1) != 0) {
            topUpUserConsultResult = familyTopUpConsult.topUpUserConsultResult;
        }
        if ((i & 2) != 0) {
            currencyAmount = familyTopUpConsult.balance;
        }
        return familyTopUpConsult.copy(topUpUserConsultResult, currencyAmount);
    }

    /* renamed from: component1  reason: from getter */
    public final TopUpUserConsultResult getTopUpUserConsultResult() {
        return this.topUpUserConsultResult;
    }

    /* renamed from: component2  reason: from getter */
    public final CurrencyAmount getBalance() {
        return this.balance;
    }

    public final FamilyTopUpConsult copy(TopUpUserConsultResult topUpUserConsultResult, CurrencyAmount balance) {
        Intrinsics.checkNotNullParameter(topUpUserConsultResult, "");
        Intrinsics.checkNotNullParameter(balance, "");
        return new FamilyTopUpConsult(topUpUserConsultResult, balance);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FamilyTopUpConsult) {
            FamilyTopUpConsult familyTopUpConsult = (FamilyTopUpConsult) other;
            return Intrinsics.areEqual(this.topUpUserConsultResult, familyTopUpConsult.topUpUserConsultResult) && Intrinsics.areEqual(this.balance, familyTopUpConsult.balance);
        }
        return false;
    }

    public final int hashCode() {
        return (this.topUpUserConsultResult.hashCode() * 31) + this.balance.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyTopUpConsult(topUpUserConsultResult=");
        sb.append(this.topUpUserConsultResult);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(')');
        return sb.toString();
    }

    public FamilyTopUpConsult(TopUpUserConsultResult topUpUserConsultResult, CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(topUpUserConsultResult, "");
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        this.topUpUserConsultResult = topUpUserConsultResult;
        this.balance = currencyAmount;
    }

    @JvmName(name = "getTopUpUserConsultResult")
    public final TopUpUserConsultResult getTopUpUserConsultResult() {
        return this.topUpUserConsultResult;
    }

    @JvmName(name = "getBalance")
    public final CurrencyAmount getBalance() {
        return this.balance;
    }
}
