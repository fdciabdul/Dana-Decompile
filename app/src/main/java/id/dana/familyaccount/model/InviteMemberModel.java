package id.dana.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001a\u0010\u0015\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0017\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\r"}, d2 = {"Lid/dana/familyaccount/model/InviteMemberModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "Z", "()Z", "PlaceComponentResult", "getAuthRequestContext", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InviteMemberModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof InviteMemberModel) {
            InviteMemberModel inviteMemberModel = (InviteMemberModel) p0;
            return this.PlaceComponentResult == inviteMemberModel.PlaceComponentResult && this.KClassImpl$Data$declaredNonStaticMembers$2 == inviteMemberModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.getAuthRequestContext, inviteMemberModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, inviteMemberModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, inviteMemberModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, inviteMemberModel.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, inviteMemberModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((((r0 * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteMemberModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(')');
        return sb.toString();
    }

    public InviteMemberModel(boolean z, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.moveToNextValue = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
