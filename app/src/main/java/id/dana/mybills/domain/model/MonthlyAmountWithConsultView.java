package id.dana.mybills.domain.model;

import id.dana.mybills.ui.model.MonthlyHighlightBillModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/MonthlyAmountWithConsultView;", "", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "component1", "()Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "component2", "()Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "myBillsMonthlyAmount", "myBillsHighlight", "copy", "(Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;)Lid/dana/mybills/domain/model/MonthlyAmountWithConsultView;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "getMyBillsHighlight", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "getMyBillsMonthlyAmount", "<init>", "(Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MonthlyAmountWithConsultView {
    private final MonthlyHighlightBillModel myBillsHighlight;
    private final MyBillsMonthlyAmount myBillsMonthlyAmount;

    public static /* synthetic */ MonthlyAmountWithConsultView copy$default(MonthlyAmountWithConsultView monthlyAmountWithConsultView, MyBillsMonthlyAmount myBillsMonthlyAmount, MonthlyHighlightBillModel monthlyHighlightBillModel, int i, Object obj) {
        if ((i & 1) != 0) {
            myBillsMonthlyAmount = monthlyAmountWithConsultView.myBillsMonthlyAmount;
        }
        if ((i & 2) != 0) {
            monthlyHighlightBillModel = monthlyAmountWithConsultView.myBillsHighlight;
        }
        return monthlyAmountWithConsultView.copy(myBillsMonthlyAmount, monthlyHighlightBillModel);
    }

    /* renamed from: component1  reason: from getter */
    public final MyBillsMonthlyAmount getMyBillsMonthlyAmount() {
        return this.myBillsMonthlyAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final MonthlyHighlightBillModel getMyBillsHighlight() {
        return this.myBillsHighlight;
    }

    public final MonthlyAmountWithConsultView copy(MyBillsMonthlyAmount myBillsMonthlyAmount, MonthlyHighlightBillModel myBillsHighlight) {
        Intrinsics.checkNotNullParameter(myBillsMonthlyAmount, "");
        Intrinsics.checkNotNullParameter(myBillsHighlight, "");
        return new MonthlyAmountWithConsultView(myBillsMonthlyAmount, myBillsHighlight);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MonthlyAmountWithConsultView) {
            MonthlyAmountWithConsultView monthlyAmountWithConsultView = (MonthlyAmountWithConsultView) other;
            return Intrinsics.areEqual(this.myBillsMonthlyAmount, monthlyAmountWithConsultView.myBillsMonthlyAmount) && Intrinsics.areEqual(this.myBillsHighlight, monthlyAmountWithConsultView.myBillsHighlight);
        }
        return false;
    }

    public final int hashCode() {
        return (this.myBillsMonthlyAmount.hashCode() * 31) + this.myBillsHighlight.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MonthlyAmountWithConsultView(myBillsMonthlyAmount=");
        sb.append(this.myBillsMonthlyAmount);
        sb.append(", myBillsHighlight=");
        sb.append(this.myBillsHighlight);
        sb.append(')');
        return sb.toString();
    }

    public MonthlyAmountWithConsultView(MyBillsMonthlyAmount myBillsMonthlyAmount, MonthlyHighlightBillModel monthlyHighlightBillModel) {
        Intrinsics.checkNotNullParameter(myBillsMonthlyAmount, "");
        Intrinsics.checkNotNullParameter(monthlyHighlightBillModel, "");
        this.myBillsMonthlyAmount = myBillsMonthlyAmount;
        this.myBillsHighlight = monthlyHighlightBillModel;
    }

    @JvmName(name = "getMyBillsMonthlyAmount")
    public final MyBillsMonthlyAmount getMyBillsMonthlyAmount() {
        return this.myBillsMonthlyAmount;
    }

    @JvmName(name = "getMyBillsHighlight")
    public final MonthlyHighlightBillModel getMyBillsHighlight() {
        return this.myBillsHighlight;
    }
}
