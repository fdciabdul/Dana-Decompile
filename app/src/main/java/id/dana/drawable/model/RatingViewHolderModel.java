package id.dana.drawable.model;

import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB3\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0014\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016"}, d2 = {"Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "I", "p1", "p2", "p3", "<init>", "(ILid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;Lid/dana/nearbyme/model/ShopModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RatingViewHolderModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MerchantConsultReviewModel PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MerchantReviewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ShopModel BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RatingViewHolderModel) {
            RatingViewHolderModel ratingViewHolderModel = (RatingViewHolderModel) p0;
            return this.MyBillsEntityDataFactory == ratingViewHolderModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ratingViewHolderModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, ratingViewHolderModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ratingViewHolderModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.MyBillsEntityDataFactory;
        MerchantReviewModel merchantReviewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = merchantReviewModel == null ? 0 : merchantReviewModel.hashCode();
        MerchantConsultReviewModel merchantConsultReviewModel = this.PlaceComponentResult;
        int hashCode2 = merchantConsultReviewModel == null ? 0 : merchantConsultReviewModel.hashCode();
        ShopModel shopModel = this.BuiltInFictitiousFunctionClassFactory;
        return (((((i * 31) + hashCode) * 31) + hashCode2) * 31) + (shopModel != null ? shopModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RatingViewHolderModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    private RatingViewHolderModel(int i, MerchantReviewModel merchantReviewModel, MerchantConsultReviewModel merchantConsultReviewModel, ShopModel shopModel) {
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantReviewModel;
        this.PlaceComponentResult = merchantConsultReviewModel;
        this.BuiltInFictitiousFunctionClassFactory = shopModel;
    }

    public /* synthetic */ RatingViewHolderModel(int i, MerchantReviewModel merchantReviewModel, MerchantConsultReviewModel merchantConsultReviewModel, ShopModel shopModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : merchantReviewModel, (i2 & 4) != 0 ? null : merchantConsultReviewModel, (i2 & 8) != 0 ? null : shopModel);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\n\u0010\fJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\r¢\u0006\u0004\b\u0003\u0010\u000e"}, d2 = {"Lid/dana/nearbyrevamp/model/RatingViewHolderModel$Companion;", "", "Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "p0", "(Lid/dana/nearbyme/model/ShopModel;)Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;)Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)Lid/dana/nearbyrevamp/model/RatingViewHolderModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RatingViewHolderModel MyBillsEntityDataFactory() {
            return new RatingViewHolderModel(6, null, null, null, 14, null);
        }

        public static RatingViewHolderModel PlaceComponentResult() {
            return new RatingViewHolderModel(7, null, null, null, 14, null);
        }

        public static RatingViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new RatingViewHolderModel(2, p0, null, null, 12, null);
        }

        public static RatingViewHolderModel MyBillsEntityDataFactory(MerchantConsultReviewModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new RatingViewHolderModel(4, null, p0, null, 10, null);
        }

        public static RatingViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new RatingViewHolderModel(3, null, null, null, 14, null);
        }

        public static RatingViewHolderModel BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new RatingViewHolderModel(0, null, null, p0, 6, null);
        }

        public static RatingViewHolderModel BuiltInFictitiousFunctionClassFactory() {
            return new RatingViewHolderModel(5, null, null, null, 14, null);
        }
    }
}
