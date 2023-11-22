package id.dana.nearbyme.merchantdetail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/ProductOrderModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProductOrderModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ProductOrderModel) {
            ProductOrderModel productOrderModel = (ProductOrderModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, productOrderModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, productOrderModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, productOrderModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.getAuthRequestContext.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductOrderModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public ProductOrderModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.MyBillsEntityDataFactory = str3;
    }
}
