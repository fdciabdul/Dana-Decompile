package id.dana.sendmoney.domain.groupsend.model.submit;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\u0010(\u001a\u0004\u0018\u00010\t\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\b\u0010,\u001a\u0004\u0018\u00010\t\u0012\b\u0010-\u001a\u0004\u0018\u00010\t\u0012\b\u0010.\u001a\u0004\u0018\u00010\t\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\b\u00100\u001a\u0004\u0018\u00010\t\u0012\b\u00101\u001a\u0004\u0018\u00010\t\u0012\b\u00102\u001a\u0004\u0018\u00010\t\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\b\u00106\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010;\u001a\u0004\u0018\u00010\t\u0012\b\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b=\u0010>J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\rR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b!\u0010\rR\u0013\u0010#\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b#\u0010\rR\u0013\u0010$\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b$\u0010\rR\u0013\u0010&\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b%\u0010\rR\u0013\u0010'\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b'\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantInfoSubmit;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Ljava/lang/Boolean;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "lookAheadTest", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "DatabaseTableConfigUtil", "initRecordTimeStamp", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "", "Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "newProxyInstance", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantInfoSubmit {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String initRecordTimeStamp;
    public final String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final String newProxyInstance;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String PrepareContext;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String GetContactSyncConfig;
    public final String isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;
    public final String moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final List<Milestone> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ParticipantInfoSubmit) {
            ParticipantInfoSubmit participantInfoSubmit = (ParticipantInfoSubmit) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, participantInfoSubmit.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.PrepareContext, participantInfoSubmit.PrepareContext) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, participantInfoSubmit.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, participantInfoSubmit.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, participantInfoSubmit.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, participantInfoSubmit.getAuthRequestContext) && Intrinsics.areEqual(this.scheduleImpl, participantInfoSubmit.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, participantInfoSubmit.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.isLayoutRequested, participantInfoSubmit.isLayoutRequested) && Intrinsics.areEqual(this.newProxyInstance, participantInfoSubmit.newProxyInstance) && Intrinsics.areEqual(this.GetContactSyncConfig, participantInfoSubmit.GetContactSyncConfig) && Intrinsics.areEqual(this.moveToNextValue, participantInfoSubmit.moveToNextValue) && Intrinsics.areEqual(this.lookAheadTest, participantInfoSubmit.lookAheadTest) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, participantInfoSubmit.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.PlaceComponentResult, participantInfoSubmit.PlaceComponentResult) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, participantInfoSubmit.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.initRecordTimeStamp, participantInfoSubmit.initRecordTimeStamp);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.PrepareContext;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.DatabaseTableConfigUtil;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.MyBillsEntityDataFactory;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.getAuthRequestContext;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.scheduleImpl;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.getErrorConfigVersion;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        List<Milestone> list = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode13 = list == null ? 0 : list.hashCode();
        String str13 = this.isLayoutRequested;
        int hashCode14 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.newProxyInstance;
        int hashCode15 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.GetContactSyncConfig;
        int hashCode16 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.moveToNextValue;
        int hashCode17 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.lookAheadTest;
        int hashCode18 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.FragmentBottomSheetPaymentSettingBinding;
        int hashCode19 = str18 == null ? 0 : str18.hashCode();
        Boolean bool = this.PlaceComponentResult;
        int hashCode20 = bool == null ? 0 : bool.hashCode();
        String str19 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode21 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.initRecordTimeStamp;
        return (((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + (str20 != null ? str20.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantInfoSubmit(NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantInfoSubmit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<Milestone> list, String str13, String str14, String str15, String str16, String str17, String str18, Boolean bool, String str19, String str20) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str3;
        this.PrepareContext = str4;
        this.DatabaseTableConfigUtil = str5;
        this.BuiltInFictitiousFunctionClassFactory = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str7;
        this.MyBillsEntityDataFactory = str8;
        this.getAuthRequestContext = str9;
        this.scheduleImpl = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str11;
        this.getErrorConfigVersion = str12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = list;
        this.isLayoutRequested = str13;
        this.newProxyInstance = str14;
        this.GetContactSyncConfig = str15;
        this.moveToNextValue = str16;
        this.lookAheadTest = str17;
        this.FragmentBottomSheetPaymentSettingBinding = str18;
        this.PlaceComponentResult = bool;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str19;
        this.initRecordTimeStamp = str20;
    }
}
