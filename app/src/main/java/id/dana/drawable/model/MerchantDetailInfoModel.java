package id.dana.drawable.model;

import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.nearbyme.model.ShopModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(ILid/dana/nearbyme/model/ShopModel;Lid/dana/domain/nearbyme/model/MerchantDetailConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantDetailInfoModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public MerchantDetailConfig PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public ShopModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantDetailInfoModel) {
            MerchantDetailInfoModel merchantDetailInfoModel = (MerchantDetailInfoModel) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == merchantDetailInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantDetailInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, merchantDetailInfoModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ShopModel shopModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = shopModel == null ? 0 : shopModel.hashCode();
        MerchantDetailConfig merchantDetailConfig = this.PlaceComponentResult;
        return (((i * 31) + hashCode) * 31) + (merchantDetailConfig != null ? merchantDetailConfig.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantDetailInfoModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public MerchantDetailInfoModel(int i, ShopModel shopModel, MerchantDetailConfig merchantDetailConfig) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.BuiltInFictitiousFunctionClassFactory = shopModel;
        this.PlaceComponentResult = merchantDetailConfig;
    }

    public /* synthetic */ MerchantDetailInfoModel(int i, ShopModel shopModel, MerchantDetailConfig merchantDetailConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : shopModel, (i2 & 4) != 0 ? null : merchantDetailConfig);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel$Companion;", "", "Lid/dana/nearbyme/model/ShopModel;", "p0", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "p1", "Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "getAuthRequestContext", "(Lid/dana/nearbyme/model/ShopModel;Lid/dana/domain/nearbyme/model/MerchantDetailConfig;)Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "(Lid/dana/nearbyme/model/ShopModel;)Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyrevamp/model/MerchantDetailInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static MerchantDetailInfoModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new MerchantDetailInfoModel(1, null, null, 6, null);
        }

        public static MerchantDetailInfoModel getAuthRequestContext(ShopModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new MerchantDetailInfoModel(0, p0, null, 4, null);
        }

        public static MerchantDetailInfoModel getAuthRequestContext(ShopModel p0, MerchantDetailConfig p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new MerchantDetailInfoModel(2, p0, p1);
        }

        public static MerchantDetailInfoModel MyBillsEntityDataFactory() {
            return new MerchantDetailInfoModel(3, null, null, 6, null);
        }
    }
}
