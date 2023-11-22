package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/kyb/model/KybServiceModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/kyb/model/KybServiceRedirectValueModel;", "Lid/dana/kyb/model/KybServiceRedirectValueModel;", "lookAheadTest", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/model/KybServiceRedirectValueModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final KybServiceRedirectValueModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public KybServiceModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybServiceModel) {
            KybServiceModel kybServiceModel = (KybServiceModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, kybServiceModel.getAuthRequestContext) && Intrinsics.areEqual(this.getErrorConfigVersion, kybServiceModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, kybServiceModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, kybServiceModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybServiceModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, kybServiceModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.getAuthRequestContext;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.getErrorConfigVersion;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode4 = this.PlaceComponentResult.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        KybServiceRedirectValueModel kybServiceRedirectValueModel = this.MyBillsEntityDataFactory;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (kybServiceRedirectValueModel != null ? kybServiceRedirectValueModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceModel(String str, String str2, String str3, String str4, String str5, KybServiceRedirectValueModel kybServiceRedirectValueModel) {
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = str;
        this.getErrorConfigVersion = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.PlaceComponentResult = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.MyBillsEntityDataFactory = kybServiceRedirectValueModel;
    }

    public /* synthetic */ KybServiceModel(String str, String str2, String str3, String str4, String str5, KybServiceRedirectValueModel kybServiceRedirectValueModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : kybServiceRedirectValueModel);
    }
}
