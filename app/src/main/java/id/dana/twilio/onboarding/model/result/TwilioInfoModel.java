package id.dana.twilio.onboarding.model.result;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013"}, d2 = {"Lid/dana/twilio/onboarding/model/result/TwilioInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "PlaceComponentResult", "Ljava/lang/String;", "", "Ljava/util/List;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class TwilioInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final List<String> getAuthRequestContext;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final boolean BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TwilioInfoModel) {
            TwilioInfoModel twilioInfoModel = (TwilioInfoModel) p0;
            return this.BuiltInFictitiousFunctionClassFactory == twilioInfoModel.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == twilioInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.PlaceComponentResult, twilioInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, twilioInfoModel.getAuthRequestContext);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z2 ? 1 : z2 ? 1 : 0;
        String str = this.PlaceComponentResult;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.getAuthRequestContext;
        return (((((r0 * 31) + i) * 31) + hashCode) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioInfoModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }
}
