package id.dana.domain.merchantmanagement.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "", "", "Lid/dana/domain/merchantmanagement/model/LinkedMerchant;", "component1", "()Ljava/util/List;", "", "component2", "()I", "merchantList", "totalPageNumber", "copy", "(Ljava/util/List;I)Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getMerchantList", "setMerchantList", "(Ljava/util/List;)V", "I", "getTotalPageNumber", "setTotalPageNumber", "(I)V", "<init>", "(Ljava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LinkedMerchantInfo {
    private List<LinkedMerchant> merchantList;
    private int totalPageNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkedMerchantInfo copy$default(LinkedMerchantInfo linkedMerchantInfo, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = linkedMerchantInfo.merchantList;
        }
        if ((i2 & 2) != 0) {
            i = linkedMerchantInfo.totalPageNumber;
        }
        return linkedMerchantInfo.copy(list, i);
    }

    public final List<LinkedMerchant> component1() {
        return this.merchantList;
    }

    /* renamed from: component2  reason: from getter */
    public final int getTotalPageNumber() {
        return this.totalPageNumber;
    }

    public final LinkedMerchantInfo copy(List<LinkedMerchant> merchantList, int totalPageNumber) {
        Intrinsics.checkNotNullParameter(merchantList, "");
        return new LinkedMerchantInfo(merchantList, totalPageNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LinkedMerchantInfo) {
            LinkedMerchantInfo linkedMerchantInfo = (LinkedMerchantInfo) other;
            return Intrinsics.areEqual(this.merchantList, linkedMerchantInfo.merchantList) && this.totalPageNumber == linkedMerchantInfo.totalPageNumber;
        }
        return false;
    }

    public final int hashCode() {
        return (this.merchantList.hashCode() * 31) + this.totalPageNumber;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedMerchantInfo(merchantList=");
        sb.append(this.merchantList);
        sb.append(", totalPageNumber=");
        sb.append(this.totalPageNumber);
        sb.append(')');
        return sb.toString();
    }

    public LinkedMerchantInfo(List<LinkedMerchant> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.merchantList = list;
        this.totalPageNumber = i;
    }

    @JvmName(name = "getMerchantList")
    public final List<LinkedMerchant> getMerchantList() {
        return this.merchantList;
    }

    @JvmName(name = "setMerchantList")
    public final void setMerchantList(List<LinkedMerchant> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.merchantList = list;
    }

    @JvmName(name = "getTotalPageNumber")
    public final int getTotalPageNumber() {
        return this.totalPageNumber;
    }

    @JvmName(name = "setTotalPageNumber")
    public final void setTotalPageNumber(int i) {
        this.totalPageNumber = i;
    }
}
