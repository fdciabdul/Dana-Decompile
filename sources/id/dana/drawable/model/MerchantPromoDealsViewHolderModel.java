package id.dana.drawable.model;

import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB?\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "Lid/dana/nearbyme/model/PromoInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/model/ShopModel;", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "getAuthRequestContext", "I", "p1", "p2", "p3", "<init>", "(ILjava/util/List;Ljava/util/List;Lid/dana/nearbyme/model/ShopModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantPromoDealsViewHolderModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<PromoInfoModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<MerchantProductInfoModel> BuiltInFictitiousFunctionClassFactory;
    public final ShopModel PlaceComponentResult;
    public final int getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantPromoDealsViewHolderModel) {
            MerchantPromoDealsViewHolderModel merchantPromoDealsViewHolderModel = (MerchantPromoDealsViewHolderModel) p0;
            return this.getAuthRequestContext == merchantPromoDealsViewHolderModel.getAuthRequestContext && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, merchantPromoDealsViewHolderModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantPromoDealsViewHolderModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, merchantPromoDealsViewHolderModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.getAuthRequestContext;
        List<PromoInfoModel> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = list == null ? 0 : list.hashCode();
        List<MerchantProductInfoModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        ShopModel shopModel = this.PlaceComponentResult;
        return (((((i * 31) + hashCode) * 31) + hashCode2) * 31) + (shopModel != null ? shopModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantPromoDealsViewHolderModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantPromoDealsViewHolderModel(int i, List<? extends PromoInfoModel> list, List<MerchantProductInfoModel> list2, ShopModel shopModel) {
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.BuiltInFictitiousFunctionClassFactory = list2;
        this.PlaceComponentResult = shopModel;
    }

    public /* synthetic */ MerchantPromoDealsViewHolderModel(int i, List list, List list2, ShopModel shopModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2, (i2 & 8) != 0 ? null : shopModel);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        List<PromoInfoModel> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list == null || list.isEmpty()) {
            List<MerchantProductInfoModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
            return !(list2 == null || list2.isEmpty());
        }
        return true;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel$Companion;", "", "", "Lid/dana/nearbyme/model/PromoInfoModel;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "p1", "Lid/dana/nearbyme/model/ShopModel;", "p2", "Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/util/List;Lid/dana/nearbyme/model/ShopModel;)Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/nearbyrevamp/model/MerchantPromoDealsViewHolderModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static MerchantPromoDealsViewHolderModel BuiltInFictitiousFunctionClassFactory(List<? extends PromoInfoModel> p0, List<MerchantProductInfoModel> p1, ShopModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            return new MerchantPromoDealsViewHolderModel(0, p0, p1, p2);
        }

        public static MerchantPromoDealsViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new MerchantPromoDealsViewHolderModel(1, null, null, null, 14, null);
        }
    }
}
