package id.dana.sendmoney.domain.groupsend.model.detail;

import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u0010(\u001a\u00020\t\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\t\u0012\u0006\u0010-\u001a\u00020\t\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010/\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020\t\u0012\u0006\u00102\u001a\u00020\t\u0012\u0006\u00103\u001a\u00020\t\u0012\u0006\u00104\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0014\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0018\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0011\u0010\u001b\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0011\u0010\u0017\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0011\u0010 \u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0011\u0010\"\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b!\u0010\rR\u0011\u0010\u001f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b#\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/detail/ParticipantInfoDetail;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "moveToNextValue", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "DatabaseTableConfigUtil", "GetContactSyncConfig", "", "Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "PrepareContext", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantInfoDetail {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final List<Milestone> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ParticipantInfoDetail) {
            ParticipantInfoDetail participantInfoDetail = (ParticipantInfoDetail) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, participantInfoDetail.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, participantInfoDetail.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, participantInfoDetail.initRecordTimeStamp) && Intrinsics.areEqual(this.getAuthRequestContext, participantInfoDetail.getAuthRequestContext) && Intrinsics.areEqual(this.GetContactSyncConfig, participantInfoDetail.GetContactSyncConfig) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, participantInfoDetail.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, participantInfoDetail.PlaceComponentResult) && Intrinsics.areEqual(this.scheduleImpl, participantInfoDetail.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, participantInfoDetail.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.newProxyInstance, participantInfoDetail.newProxyInstance) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, participantInfoDetail.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.getErrorConfigVersion, participantInfoDetail.getErrorConfigVersion) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, participantInfoDetail.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.lookAheadTest, participantInfoDetail.lookAheadTest) && Intrinsics.areEqual(this.PrepareContext, participantInfoDetail.PrepareContext);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.DatabaseTableConfigUtil.hashCode()) * 31) + this.initRecordTimeStamp.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.GetContactSyncConfig.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode()) * 31) + this.newProxyInstance.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.PrepareContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantInfoDetail(NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantInfoDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<Milestone> list, String str12, String str13, String str14, String str15, String str16, String str17) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.DatabaseTableConfigUtil = str3;
        this.initRecordTimeStamp = str4;
        this.getAuthRequestContext = str5;
        this.GetContactSyncConfig = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
        this.PlaceComponentResult = str8;
        this.scheduleImpl = str9;
        this.moveToNextValue = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = list;
        this.newProxyInstance = str12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str13;
        this.getErrorConfigVersion = str14;
        this.MyBillsEntityDataFactory = str15;
        this.lookAheadTest = str16;
        this.PrepareContext = str17;
    }
}
