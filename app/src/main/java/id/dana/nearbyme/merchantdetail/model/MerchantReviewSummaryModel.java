package id.dana.nearbyme.merchantdetail.model;

import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "I", "", "MyBillsEntityDataFactory", LogConstants.RESULT_FALSE, "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "p1", "p2", "<init>", "(FILid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantReviewSummaryModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MerchantReviewModel MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final float PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantReviewSummaryModel) {
            MerchantReviewSummaryModel merchantReviewSummaryModel = (MerchantReviewSummaryModel) p0;
            return Intrinsics.areEqual((Object) Float.valueOf(this.PlaceComponentResult), (Object) Float.valueOf(merchantReviewSummaryModel.PlaceComponentResult)) && this.KClassImpl$Data$declaredNonStaticMembers$2 == merchantReviewSummaryModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.MyBillsEntityDataFactory, merchantReviewSummaryModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.PlaceComponentResult);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantReviewModel merchantReviewModel = this.MyBillsEntityDataFactory;
        return (((floatToIntBits * 31) + i) * 31) + (merchantReviewModel == null ? 0 : merchantReviewModel.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewSummaryModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public MerchantReviewSummaryModel(float f, int i, MerchantReviewModel merchantReviewModel) {
        this.PlaceComponentResult = f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = merchantReviewModel;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        MerchantReviewModel merchantReviewModel = this.MyBillsEntityDataFactory;
        if (merchantReviewModel != null) {
            return merchantReviewModel.isLayoutRequested.length() > 0;
        }
        return false;
    }
}
