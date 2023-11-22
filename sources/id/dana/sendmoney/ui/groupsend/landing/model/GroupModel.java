package id.dana.sendmoney.ui.groupsend.landing.model;

import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0012\u0010\f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0019\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/sendmoney/ui/groupsend/summary/model/ParticipantSubmitModel;", "Ljava/util/List;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "I", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<ParticipantSubmitModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final int scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof GroupModel) {
            GroupModel groupModel = (GroupModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, groupModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, groupModel.getAuthRequestContext) && this.scheduleImpl == groupModel.scheduleImpl && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, groupModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, groupModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, groupModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, groupModel.getErrorConfigVersion) && Intrinsics.areEqual(this.PlaceComponentResult, groupModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.scheduleImpl) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public GroupModel(String str, String str2, int i, List<ParticipantSubmitModel> list, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.scheduleImpl = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.MyBillsEntityDataFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.getErrorConfigVersion = str5;
        this.PlaceComponentResult = str6;
    }
}
