package id.dana.nearbyme.merchantdetail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "p1", "<init>", "(ILid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantReviewViewModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MerchantReviewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantReviewViewModel) {
            MerchantReviewViewModel merchantReviewViewModel = (MerchantReviewViewModel) p0;
            return this.MyBillsEntityDataFactory == merchantReviewViewModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantReviewViewModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.MyBillsEntityDataFactory;
        MerchantReviewModel merchantReviewModel = this.BuiltInFictitiousFunctionClassFactory;
        return (i * 31) + (merchantReviewModel == null ? 0 : merchantReviewModel.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewViewModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public MerchantReviewViewModel(int i, MerchantReviewModel merchantReviewModel) {
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = merchantReviewModel;
    }

    public /* synthetic */ MerchantReviewViewModel(int i, MerchantReviewModel merchantReviewModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : merchantReviewModel);
    }
}
