package id.dana.sendmoney.domain.core.model.init;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b6\u00107R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\t"}, d2 = {"Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;", "", "", "getAuthRequestContext", "Ljava/lang/Boolean;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/domain/nearbyme/model/MoneyView;", "lookAheadTest", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "GetContactSyncConfig", "PrepareContext", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda5", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferUserInfo {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MoneyView getAuthRequestContext;
    public final MoneyView DatabaseTableConfigUtil;
    public final MoneyView GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public final Boolean FragmentBottomSheetPaymentSettingBinding;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String isLayoutRequested;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final MoneyView newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Boolean PlaceComponentResult;
    public final String getErrorConfigVersion;
    public final String initRecordTimeStamp;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final MoneyView PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Boolean moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    public TransferUserInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    public TransferUserInfo(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool2, Boolean bool3, String str13, Boolean bool4, MoneyView moneyView5) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str;
        this.initRecordTimeStamp = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str4;
        this.getErrorConfigVersion = str5;
        this.lookAheadTest = str6;
        this.moveToNextValue = bool;
        this.getAuthRequestContext = moneyView;
        this.DatabaseTableConfigUtil = moneyView2;
        this.PrepareContext = moneyView3;
        this.GetContactSyncConfig = moneyView4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
        this.isLayoutRequested = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str9;
        this.scheduleImpl = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str12;
        this.FragmentBottomSheetPaymentSettingBinding = bool2;
        this.BuiltInFictitiousFunctionClassFactory = bool3;
        this.MyBillsEntityDataFactory = str13;
        this.PlaceComponentResult = bool4;
        this.newProxyInstance = moneyView5;
    }

    public /* synthetic */ TransferUserInfo(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool2, Boolean bool3, String str13, Boolean bool4, MoneyView moneyView5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView, (i & 256) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView2, (i & 512) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView3, (i & 1024) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView4, (i & 2048) != 0 ? "" : str7, (i & 4096) != 0 ? "" : str8, (i & 8192) != 0 ? "" : str9, (i & 16384) != 0 ? "" : str10, (i & 32768) != 0 ? "" : str11, (i & 65536) != 0 ? "" : str12, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? Boolean.FALSE : bool2, (i & 262144) != 0 ? Boolean.FALSE : bool3, (i & 524288) != 0 ? "" : str13, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? Boolean.FALSE : bool4, (i & 2097152) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView5);
    }
}
