package id.dana.mybills.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/CheckUniqueValueAndInquiryResult;", "", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "component1", "()Lid/dana/mybills/domain/model/CheckUniqueValue;", "Lid/dana/mybills/domain/model/BizProductDestination;", "component2", "()Lid/dana/mybills/domain/model/BizProductDestination;", "queryUniqueValue", "product", "copy", "(Lid/dana/mybills/domain/model/CheckUniqueValue;Lid/dana/mybills/domain/model/BizProductDestination;)Lid/dana/mybills/domain/model/CheckUniqueValueAndInquiryResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/domain/model/BizProductDestination;", "getProduct", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "getQueryUniqueValue", "<init>", "(Lid/dana/mybills/domain/model/CheckUniqueValue;Lid/dana/mybills/domain/model/BizProductDestination;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckUniqueValueAndInquiryResult {
    private final BizProductDestination product;
    private final CheckUniqueValue queryUniqueValue;

    public static /* synthetic */ CheckUniqueValueAndInquiryResult copy$default(CheckUniqueValueAndInquiryResult checkUniqueValueAndInquiryResult, CheckUniqueValue checkUniqueValue, BizProductDestination bizProductDestination, int i, Object obj) {
        if ((i & 1) != 0) {
            checkUniqueValue = checkUniqueValueAndInquiryResult.queryUniqueValue;
        }
        if ((i & 2) != 0) {
            bizProductDestination = checkUniqueValueAndInquiryResult.product;
        }
        return checkUniqueValueAndInquiryResult.copy(checkUniqueValue, bizProductDestination);
    }

    /* renamed from: component1  reason: from getter */
    public final CheckUniqueValue getQueryUniqueValue() {
        return this.queryUniqueValue;
    }

    /* renamed from: component2  reason: from getter */
    public final BizProductDestination getProduct() {
        return this.product;
    }

    public final CheckUniqueValueAndInquiryResult copy(CheckUniqueValue queryUniqueValue, BizProductDestination product) {
        Intrinsics.checkNotNullParameter(queryUniqueValue, "");
        Intrinsics.checkNotNullParameter(product, "");
        return new CheckUniqueValueAndInquiryResult(queryUniqueValue, product);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckUniqueValueAndInquiryResult) {
            CheckUniqueValueAndInquiryResult checkUniqueValueAndInquiryResult = (CheckUniqueValueAndInquiryResult) other;
            return Intrinsics.areEqual(this.queryUniqueValue, checkUniqueValueAndInquiryResult.queryUniqueValue) && Intrinsics.areEqual(this.product, checkUniqueValueAndInquiryResult.product);
        }
        return false;
    }

    public final int hashCode() {
        return (this.queryUniqueValue.hashCode() * 31) + this.product.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckUniqueValueAndInquiryResult(queryUniqueValue=");
        sb.append(this.queryUniqueValue);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(')');
        return sb.toString();
    }

    public CheckUniqueValueAndInquiryResult(CheckUniqueValue checkUniqueValue, BizProductDestination bizProductDestination) {
        Intrinsics.checkNotNullParameter(checkUniqueValue, "");
        Intrinsics.checkNotNullParameter(bizProductDestination, "");
        this.queryUniqueValue = checkUniqueValue;
        this.product = bizProductDestination;
    }

    @JvmName(name = "getQueryUniqueValue")
    public final CheckUniqueValue getQueryUniqueValue() {
        return this.queryUniqueValue;
    }

    @JvmName(name = "getProduct")
    public final BizProductDestination getProduct() {
        return this.product;
    }
}
