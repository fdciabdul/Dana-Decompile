package id.dana.sendmoney.domain.globalsend.model.init;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\b\b\u0002\u0010'\u001a\u00020\f\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020\b\u0012\b\b\u0002\u0010*\u001a\u00020\b\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\b\b\u0002\u0010,\u001a\u00020\b\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002¢\u0006\u0004\b0\u00101R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\t\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0011\u0010\u0010\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0011\u0010\u0011\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0011\u0010\u0013\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0011\u0010\u0014\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0011\u0010\u0012\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0011\u0010\u0016\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0017\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0011\u0010\u0019\u001a\u00020\fX\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0011\u0010\u0018\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0011\u0010\u001a\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0011\u0010\u001b\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u001a\u0010\u001c\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010\n"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "", "", "isLayoutRequested", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/domain/user/CurrencyAmount;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "MyBillsEntityDataFactory", "scheduleImpl", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "newProxyInstance", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferUserInfo {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final CurrencyAmount GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CurrencyAmount BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final CurrencyAmount NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final boolean newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final CurrencyAmount initRecordTimeStamp;

    public TransferUserInfo() {
        this(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, 524287, null);
    }

    public TransferUserInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, CurrencyAmount currencyAmount3, CurrencyAmount currencyAmount4, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(currencyAmount2, "");
        Intrinsics.checkNotNullParameter(currencyAmount3, "");
        Intrinsics.checkNotNullParameter(currencyAmount4, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
        this.moveToNextValue = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.lookAheadTest = str6;
        this.MyBillsEntityDataFactory = z;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmount;
        this.initRecordTimeStamp = currencyAmount2;
        this.GetContactSyncConfig = currencyAmount3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = currencyAmount4;
        this.PlaceComponentResult = str7;
        this.DatabaseTableConfigUtil = str8;
        this.PrepareContext = str9;
        this.getAuthRequestContext = str10;
        this.scheduleImpl = str11;
        this.getErrorConfigVersion = str12;
        this.newProxyInstance = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public /* synthetic */ TransferUserInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, CurrencyAmount currencyAmount3, CurrencyAmount currencyAmount4, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? false : z, (i & 128) != 0 ? new CurrencyAmount("", "") : currencyAmount, (i & 256) != 0 ? new CurrencyAmount("", "") : currencyAmount2, (i & 512) != 0 ? new CurrencyAmount("", "") : currencyAmount3, (i & 1024) != 0 ? new CurrencyAmount("", "") : currencyAmount4, (i & 2048) != 0 ? "" : str7, (i & 4096) != 0 ? "" : str8, (i & 8192) != 0 ? "" : str9, (i & 16384) != 0 ? "" : str10, (i & 32768) != 0 ? "" : str11, (i & 65536) != 0 ? "" : str12, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z2, (i & 262144) != 0 ? false : z3);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getNewProxyInstance() {
        return this.newProxyInstance;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
