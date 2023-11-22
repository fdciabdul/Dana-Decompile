package id.dana.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/model/FaceAuthenticationModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "", "toString", "()Ljava/lang/String;", "Lid/dana/model/LoginAuthenticationMethod;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/model/LoginAuthenticationMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/String;", "p1", "p2", "<init>", "(Lid/dana/model/LoginAuthenticationMethod;Lid/dana/model/LoginAuthenticationMethod;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FaceAuthenticationModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final LoginAuthenticationMethod PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final LoginAuthenticationMethod MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FaceAuthenticationModel) {
            FaceAuthenticationModel faceAuthenticationModel = (FaceAuthenticationModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, faceAuthenticationModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, faceAuthenticationModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, faceAuthenticationModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FaceAuthenticationModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public FaceAuthenticationModel(LoginAuthenticationMethod loginAuthenticationMethod, LoginAuthenticationMethod loginAuthenticationMethod2, String str) {
        Intrinsics.checkNotNullParameter(loginAuthenticationMethod, "");
        Intrinsics.checkNotNullParameter(loginAuthenticationMethod2, "");
        this.MyBillsEntityDataFactory = loginAuthenticationMethod;
        this.PlaceComponentResult = loginAuthenticationMethod2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult.PlaceComponentResult();
    }
}
