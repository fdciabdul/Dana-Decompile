package id.dana.sendmoney.ui.groupsend.groupdetail.model;

import id.dana.sendmoney.ui.groupsend.summary.model.MilestoneModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u0010(\u001a\u00020\t\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\t\u0012\u0006\u0010-\u001a\u00020\t\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010/\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020\t\u0012\u0006\u00102\u001a\u00020\t\u0012\u0006\u00103\u001a\u00020\t\u0012\u0006\u00104\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0011\u0010\u0014\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0018\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0011\u0010\u001e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0011\u0010\u0017\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0011\u0010 \u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0011\u0010!\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b \u0010\rR\u0011\u0010#\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/model/ParticipantInfoDetailModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "getErrorConfigVersion", "lookAheadTest", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "Lid/dana/sendmoney/ui/groupsend/summary/model/MilestoneModel;", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "DatabaseTableConfigUtil", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantInfoDetailModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final List<MilestoneModel> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String PrepareContext;
    public final String PlaceComponentResult;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ParticipantInfoDetailModel) {
            ParticipantInfoDetailModel participantInfoDetailModel = (ParticipantInfoDetailModel) p0;
            return Intrinsics.areEqual(this.PrepareContext, participantInfoDetailModel.PrepareContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, participantInfoDetailModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.initRecordTimeStamp, participantInfoDetailModel.initRecordTimeStamp) && Intrinsics.areEqual(this.GetContactSyncConfig, participantInfoDetailModel.GetContactSyncConfig) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, participantInfoDetailModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, participantInfoDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, participantInfoDetailModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, participantInfoDetailModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, participantInfoDetailModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, participantInfoDetailModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, participantInfoDetailModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, participantInfoDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, participantInfoDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, participantInfoDetailModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.moveToNextValue, participantInfoDetailModel.moveToNextValue) && Intrinsics.areEqual(this.getAuthRequestContext, participantInfoDetailModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, participantInfoDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, participantInfoDetailModel.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((this.PrepareContext.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.initRecordTimeStamp.hashCode()) * 31) + this.GetContactSyncConfig.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode()) * 31) + this.DatabaseTableConfigUtil.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantInfoDetailModel(PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantInfoDetailModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<MilestoneModel> list, String str12, String str13, String str14, String str15, String str16, String str17) {
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
        this.PrepareContext = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.initRecordTimeStamp = str3;
        this.GetContactSyncConfig = str4;
        this.MyBillsEntityDataFactory = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
        this.PlaceComponentResult = str8;
        this.lookAheadTest = str9;
        this.scheduleImpl = str10;
        this.getErrorConfigVersion = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str12;
        this.DatabaseTableConfigUtil = str13;
        this.moveToNextValue = str14;
        this.getAuthRequestContext = str15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str17;
    }
}
