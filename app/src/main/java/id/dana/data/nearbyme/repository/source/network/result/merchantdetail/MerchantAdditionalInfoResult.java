package id.dana.data.nearbyme.repository.source.network.result.merchantdetail;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.domain.nearbyme.model.MerchantAdditionalInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "bizInfo", "infoContent", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "toMerchantAdditionalInfo", "()Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "toString", "Ljava/lang/String;", "getBizInfo", "getInfoContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantAdditionalInfoResult extends BaseRpcResult {
    private final String bizInfo;
    private final String infoContent;

    public static /* synthetic */ MerchantAdditionalInfoResult copy$default(MerchantAdditionalInfoResult merchantAdditionalInfoResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantAdditionalInfoResult.bizInfo;
        }
        if ((i & 2) != 0) {
            str2 = merchantAdditionalInfoResult.infoContent;
        }
        return merchantAdditionalInfoResult.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizInfo() {
        return this.bizInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInfoContent() {
        return this.infoContent;
    }

    public final MerchantAdditionalInfoResult copy(String bizInfo, String infoContent) {
        return new MerchantAdditionalInfoResult(bizInfo, infoContent);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantAdditionalInfoResult) {
            MerchantAdditionalInfoResult merchantAdditionalInfoResult = (MerchantAdditionalInfoResult) other;
            return Intrinsics.areEqual(this.bizInfo, merchantAdditionalInfoResult.bizInfo) && Intrinsics.areEqual(this.infoContent, merchantAdditionalInfoResult.infoContent);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizInfo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.infoContent;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantAdditionalInfoResult(bizInfo=");
        sb.append(this.bizInfo);
        sb.append(", infoContent=");
        sb.append(this.infoContent);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizInfo")
    public final String getBizInfo() {
        return this.bizInfo;
    }

    @JvmName(name = "getInfoContent")
    public final String getInfoContent() {
        return this.infoContent;
    }

    public MerchantAdditionalInfoResult(String str, String str2) {
        this.bizInfo = str;
        this.infoContent = str2;
    }

    public final MerchantAdditionalInfo toMerchantAdditionalInfo() {
        String str = this.bizInfo;
        if (str == null) {
            str = "";
        }
        String str2 = this.infoContent;
        return new MerchantAdditionalInfo(str, str2 != null ? str2 : "");
    }
}
