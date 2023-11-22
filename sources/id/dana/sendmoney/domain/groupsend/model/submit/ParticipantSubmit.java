package id.dana.sendmoney.domain.groupsend.model.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "moveToNextValue", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantSubmit {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ParticipantInfoSubmit KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ParticipantSubmit) {
            ParticipantSubmit participantSubmit = (ParticipantSubmit) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, participantSubmit.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, participantSubmit.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, participantSubmit.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, participantSubmit.getErrorConfigVersion) && Intrinsics.areEqual(this.PlaceComponentResult, participantSubmit.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, participantSubmit.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        ParticipantInfoSubmit participantInfoSubmit = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = participantInfoSubmit == null ? 0 : participantInfoSubmit.hashCode();
        String str = this.getAuthRequestContext;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int hashCode4 = this.getErrorConfigVersion.hashCode();
        String str3 = this.PlaceComponentResult;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantSubmit(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantSubmit(ParticipantInfoSubmit participantInfoSubmit, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = participantInfoSubmit;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = str2;
        this.getErrorConfigVersion = str3;
        this.PlaceComponentResult = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
    }
}
