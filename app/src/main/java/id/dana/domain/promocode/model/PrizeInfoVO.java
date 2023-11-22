package id.dana.domain.promocode.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/promocode/model/PrizeInfoVO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "prizeId", "prizeName", "prizeType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/promocode/model/PrizeInfoVO;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPrizeId", "getPrizeName", "getPrizeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PrizeInfoVO {
    private final String prizeId;
    private final String prizeName;
    private final String prizeType;

    public static /* synthetic */ PrizeInfoVO copy$default(PrizeInfoVO prizeInfoVO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prizeInfoVO.prizeId;
        }
        if ((i & 2) != 0) {
            str2 = prizeInfoVO.prizeName;
        }
        if ((i & 4) != 0) {
            str3 = prizeInfoVO.prizeType;
        }
        return prizeInfoVO.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPrizeId() {
        return this.prizeId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPrizeName() {
        return this.prizeName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPrizeType() {
        return this.prizeType;
    }

    public final PrizeInfoVO copy(String prizeId, String prizeName, String prizeType) {
        return new PrizeInfoVO(prizeId, prizeName, prizeType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PrizeInfoVO) {
            PrizeInfoVO prizeInfoVO = (PrizeInfoVO) other;
            return Intrinsics.areEqual(this.prizeId, prizeInfoVO.prizeId) && Intrinsics.areEqual(this.prizeName, prizeInfoVO.prizeName) && Intrinsics.areEqual(this.prizeType, prizeInfoVO.prizeType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.prizeId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.prizeName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.prizeType;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrizeInfoVO(prizeId=");
        sb.append(this.prizeId);
        sb.append(", prizeName=");
        sb.append(this.prizeName);
        sb.append(", prizeType=");
        sb.append(this.prizeType);
        sb.append(')');
        return sb.toString();
    }

    public PrizeInfoVO(String str, String str2, String str3) {
        this.prizeId = str;
        this.prizeName = str2;
        this.prizeType = str3;
    }

    @JvmName(name = "getPrizeId")
    public final String getPrizeId() {
        return this.prizeId;
    }

    @JvmName(name = "getPrizeName")
    public final String getPrizeName() {
        return this.prizeName;
    }

    @JvmName(name = "getPrizeType")
    public final String getPrizeType() {
        return this.prizeType;
    }
}
