package id.dana.kyb.domain.model;

import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/MerchantContractInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "productCode", MessageConstants.KEY_PRODUCT_NAME, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/MerchantContractInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getProductCode", "getProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantContractInfo {
    private final String productCode;
    private final String productName;

    public static /* synthetic */ MerchantContractInfo copy$default(MerchantContractInfo merchantContractInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantContractInfo.productCode;
        }
        if ((i & 2) != 0) {
            str2 = merchantContractInfo.productName;
        }
        return merchantContractInfo.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProductCode() {
        return this.productCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    public final MerchantContractInfo copy(String productCode, String productName) {
        Intrinsics.checkNotNullParameter(productCode, "");
        Intrinsics.checkNotNullParameter(productName, "");
        return new MerchantContractInfo(productCode, productName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantContractInfo) {
            MerchantContractInfo merchantContractInfo = (MerchantContractInfo) other;
            return Intrinsics.areEqual(this.productCode, merchantContractInfo.productCode) && Intrinsics.areEqual(this.productName, merchantContractInfo.productName);
        }
        return false;
    }

    public final int hashCode() {
        return (this.productCode.hashCode() * 31) + this.productName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantContractInfo(productCode=");
        sb.append(this.productCode);
        sb.append(", productName=");
        sb.append(this.productName);
        sb.append(')');
        return sb.toString();
    }

    public MerchantContractInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.productCode = str;
        this.productName = str2;
    }

    @JvmName(name = "getProductCode")
    public final String getProductCode() {
        return this.productCode;
    }

    @JvmName(name = "getProductName")
    public final String getProductName() {
        return this.productName;
    }
}
