package id.dana.nearbyme.model;

import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0019\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper$Type;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper$Type;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper$Type;Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;)V", "Companion", "Type"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySpecialDealsItemWrapper {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Type getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public MerchantProductInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM", "SEE_MORE", "EMPTY_SPACE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Type {
        ITEM,
        SEE_MORE,
        EMPTY_SPACE
    }

    public NearbySpecialDealsItemWrapper(Type type, MerchantProductInfoModel merchantProductInfoModel) {
        Intrinsics.checkNotNullParameter(type, "");
        this.getAuthRequestContext = type;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantProductInfoModel;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper$Companion;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "p0", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;)Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "PlaceComponentResult", "()Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static NearbySpecialDealsItemWrapper PlaceComponentResult() {
            return new NearbySpecialDealsItemWrapper(Type.EMPTY_SPACE, null);
        }

        public static NearbySpecialDealsItemWrapper BuiltInFictitiousFunctionClassFactory() {
            return new NearbySpecialDealsItemWrapper(Type.SEE_MORE, null);
        }

        public static NearbySpecialDealsItemWrapper BuiltInFictitiousFunctionClassFactory(MerchantProductInfoModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new NearbySpecialDealsItemWrapper(Type.ITEM, p0);
        }
    }
}
