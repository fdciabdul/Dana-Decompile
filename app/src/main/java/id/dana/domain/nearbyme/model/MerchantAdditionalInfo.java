package id.dana.domain.nearbyme.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "bizInfo", "infoContent", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizInfo", "getInfoContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantAdditionalInfo {
    private final String bizInfo;
    private final String infoContent;

    public static /* synthetic */ MerchantAdditionalInfo copy$default(MerchantAdditionalInfo merchantAdditionalInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantAdditionalInfo.bizInfo;
        }
        if ((i & 2) != 0) {
            str2 = merchantAdditionalInfo.infoContent;
        }
        return merchantAdditionalInfo.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizInfo() {
        return this.bizInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInfoContent() {
        return this.infoContent;
    }

    public final MerchantAdditionalInfo copy(String bizInfo, String infoContent) {
        Intrinsics.checkNotNullParameter(bizInfo, "");
        Intrinsics.checkNotNullParameter(infoContent, "");
        return new MerchantAdditionalInfo(bizInfo, infoContent);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantAdditionalInfo) {
            MerchantAdditionalInfo merchantAdditionalInfo = (MerchantAdditionalInfo) other;
            return Intrinsics.areEqual(this.bizInfo, merchantAdditionalInfo.bizInfo) && Intrinsics.areEqual(this.infoContent, merchantAdditionalInfo.infoContent);
        }
        return false;
    }

    public final int hashCode() {
        return (this.bizInfo.hashCode() * 31) + this.infoContent.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantAdditionalInfo(bizInfo=");
        sb.append(this.bizInfo);
        sb.append(", infoContent=");
        sb.append(this.infoContent);
        sb.append(')');
        return sb.toString();
    }

    public MerchantAdditionalInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.bizInfo = str;
        this.infoContent = str2;
    }

    @JvmName(name = "getBizInfo")
    public final String getBizInfo() {
        return this.bizInfo;
    }

    @JvmName(name = "getInfoContent")
    public final String getInfoContent() {
        return this.infoContent;
    }
}
