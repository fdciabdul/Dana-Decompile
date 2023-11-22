package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/kyb/model/KybCompleteInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/kyb/model/KybInfoModel;", "PlaceComponentResult", "Lid/dana/kyb/model/KybInfoModel;", "Lid/dana/kyb/model/KybMerchantInfoModel;", "MyBillsEntityDataFactory", "Lid/dana/kyb/model/KybMerchantInfoModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/model/UserInfoKybModel;", "getAuthRequestContext", "Lid/dana/kyb/model/UserInfoKybModel;", "p1", "p2", "<init>", "(Lid/dana/kyb/model/UserInfoKybModel;Lid/dana/kyb/model/KybInfoModel;Lid/dana/kyb/model/KybMerchantInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybCompleteInfoModel {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final KybMerchantInfoModel BuiltInFictitiousFunctionClassFactory;
    public final KybInfoModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final UserInfoKybModel MyBillsEntityDataFactory;

    public KybCompleteInfoModel() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybCompleteInfoModel) {
            KybCompleteInfoModel kybCompleteInfoModel = (KybCompleteInfoModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, kybCompleteInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, kybCompleteInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybCompleteInfoModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        UserInfoKybModel userInfoKybModel = this.MyBillsEntityDataFactory;
        int hashCode = userInfoKybModel == null ? 0 : userInfoKybModel.hashCode();
        KybInfoModel kybInfoModel = this.PlaceComponentResult;
        int hashCode2 = kybInfoModel == null ? 0 : kybInfoModel.hashCode();
        KybMerchantInfoModel kybMerchantInfoModel = this.BuiltInFictitiousFunctionClassFactory;
        return (((hashCode * 31) + hashCode2) * 31) + (kybMerchantInfoModel != null ? kybMerchantInfoModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybCompleteInfoModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public KybCompleteInfoModel(UserInfoKybModel userInfoKybModel, KybInfoModel kybInfoModel, KybMerchantInfoModel kybMerchantInfoModel) {
        this.MyBillsEntityDataFactory = userInfoKybModel;
        this.PlaceComponentResult = kybInfoModel;
        this.BuiltInFictitiousFunctionClassFactory = kybMerchantInfoModel;
    }

    public /* synthetic */ KybCompleteInfoModel(UserInfoKybModel userInfoKybModel, KybInfoModel kybInfoModel, KybMerchantInfoModel kybMerchantInfoModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : userInfoKybModel, (i & 2) != 0 ? null : kybInfoModel, (i & 4) != 0 ? null : kybMerchantInfoModel);
    }

    public static /* synthetic */ KybCompleteInfoModel BuiltInFictitiousFunctionClassFactory(KybCompleteInfoModel kybCompleteInfoModel, KybMerchantInfoModel kybMerchantInfoModel) {
        return new KybCompleteInfoModel(kybCompleteInfoModel.MyBillsEntityDataFactory, kybCompleteInfoModel.PlaceComponentResult, kybMerchantInfoModel);
    }
}
