package id.dana.sendmoney.domain.globalsend.model.validate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b+\u0018\u00002\u00020\u0001Bß\u0001\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00106\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0006\u00108\u001a\u00020\u0002\u0012\u0006\u00109\u001a\u00020\u0013\u0012\u0006\u0010:\u001a\u00020\u0013\u0012\u0006\u0010;\u001a\u00020\u0002\u0012\u0006\u0010<\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0011\u0010\f\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0011\u0010\n\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0011\u0010\r\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0011\u0010\u000e\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0011\u0010\u0010\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0011\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0017\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0011\u0010\u0015\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0011\u0010\u0019\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0011\u0010\u0018\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0011\u0010\u001b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0011\u0010\u001c\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0011\u0010\u001e\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0011\u0010\u001d\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0011\u0010\u001a\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0011\u0010 \u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0012\u0010!\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "J", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "whenAvailable", "readMicros", "getCallingPid", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeneficiaryInfo {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda3;
    public final String GetContactSyncConfig;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final long NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public final String FragmentBottomSheetPaymentSettingBinding;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String newProxyInstance;
    public final String PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String isLayoutRequested;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final long DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public String getCallingPid;
    public final String scheduleImpl;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    public final String readMicros;

    public BeneficiaryInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, long j, long j2, String str24, String str25) {
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
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(str18, "");
        Intrinsics.checkNotNullParameter(str19, "");
        Intrinsics.checkNotNullParameter(str20, "");
        Intrinsics.checkNotNullParameter(str21, "");
        Intrinsics.checkNotNullParameter(str22, "");
        Intrinsics.checkNotNullParameter(str23, "");
        Intrinsics.checkNotNullParameter(str24, "");
        Intrinsics.checkNotNullParameter(str25, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.initRecordTimeStamp = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str3;
        this.lookAheadTest = str4;
        this.MyBillsEntityDataFactory = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str7;
        this.moveToNextValue = str8;
        this.FragmentBottomSheetPaymentSettingBinding = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str11;
        this.getAuthRequestContext = str12;
        this.scheduleImpl = str13;
        this.newProxyInstance = str14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str15;
        this.PlaceComponentResult = str16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str17;
        this.GetContactSyncConfig = str18;
        this.isLayoutRequested = str19;
        this.PrepareContext = str20;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str21;
        this.getCallingPid = str22;
        this.getErrorConfigVersion = str23;
        this.DatabaseTableConfigUtil = j;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = j2;
        this.readMicros = str24;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str25;
    }
}
