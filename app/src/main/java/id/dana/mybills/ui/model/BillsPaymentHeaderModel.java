package id.dana.mybills.ui.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/model/BillsPaymentHeaderModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()Z", "title", "billsNumber", "enableAddNewBill", "copy", "(Ljava/lang/String;IZ)Lid/dana/mybills/ui/model/BillsPaymentHeaderModel;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getBillsNumber", "Z", "getEnableAddNewBill", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class BillsPaymentHeaderModel {
    private final int billsNumber;
    private final boolean enableAddNewBill;
    private final String title;

    public static /* synthetic */ BillsPaymentHeaderModel copy$default(BillsPaymentHeaderModel billsPaymentHeaderModel, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = billsPaymentHeaderModel.title;
        }
        if ((i2 & 2) != 0) {
            i = billsPaymentHeaderModel.billsNumber;
        }
        if ((i2 & 4) != 0) {
            z = billsPaymentHeaderModel.enableAddNewBill;
        }
        return billsPaymentHeaderModel.copy(str, i, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final int getBillsNumber() {
        return this.billsNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getEnableAddNewBill() {
        return this.enableAddNewBill;
    }

    public final BillsPaymentHeaderModel copy(String title, int billsNumber, boolean enableAddNewBill) {
        Intrinsics.checkNotNullParameter(title, "");
        return new BillsPaymentHeaderModel(title, billsNumber, enableAddNewBill);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillsPaymentHeaderModel) {
            BillsPaymentHeaderModel billsPaymentHeaderModel = (BillsPaymentHeaderModel) other;
            return Intrinsics.areEqual(this.title, billsPaymentHeaderModel.title) && this.billsNumber == billsPaymentHeaderModel.billsNumber && this.enableAddNewBill == billsPaymentHeaderModel.enableAddNewBill;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.title.hashCode();
        int i = this.billsNumber;
        boolean z = this.enableAddNewBill;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((hashCode * 31) + i) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillsPaymentHeaderModel(title=");
        sb.append(this.title);
        sb.append(", billsNumber=");
        sb.append(this.billsNumber);
        sb.append(", enableAddNewBill=");
        sb.append(this.enableAddNewBill);
        sb.append(')');
        return sb.toString();
    }

    public BillsPaymentHeaderModel(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
        this.billsNumber = i;
        this.enableAddNewBill = z;
    }

    public /* synthetic */ BillsPaymentHeaderModel(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z);
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getBillsNumber")
    public final int getBillsNumber() {
        return this.billsNumber;
    }

    @JvmName(name = "getEnableAddNewBill")
    public final boolean getEnableAddNewBill() {
        return this.enableAddNewBill;
    }
}
