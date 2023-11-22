package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013"}, d2 = {"Lid/dana/kyb/model/KybServiceRuleModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/kyb/model/KybServiceMessageModel;", "MyBillsEntityDataFactory", "Lid/dana/kyb/model/KybServiceMessageModel;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "PlaceComponentResult", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lid/dana/kyb/model/KybServiceMessageModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceRuleModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final KybServiceMessageModel getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Object PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybServiceRuleModel) {
            KybServiceRuleModel kybServiceRuleModel = (KybServiceRuleModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybServiceRuleModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, kybServiceRuleModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, kybServiceRuleModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        Object obj = this.PlaceComponentResult;
        int hashCode2 = obj == null ? 0 : obj.hashCode();
        KybServiceMessageModel kybServiceMessageModel = this.getAuthRequestContext;
        return (((hashCode * 31) + hashCode2) * 31) + (kybServiceMessageModel != null ? kybServiceMessageModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceRuleModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceRuleModel(String str, Object obj, KybServiceMessageModel kybServiceMessageModel) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = obj;
        this.getAuthRequestContext = kybServiceMessageModel;
    }
}
