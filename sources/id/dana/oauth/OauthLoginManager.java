package id.dana.oauth;

import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import id.dana.oauth.model.OauthParamsModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u0007J\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0006\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0003\u0010\u001aR\"\u0010\u0006\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\b\u0010\u001dR\u001a\u0010\t\u001a\u00020\r8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\"\u0010\u0003\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u000f\"\u0004\b\t\u0010\u001dR\"\u0010\f\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u000f\"\u0004\b\u0018\u0010\u001dR\"\u0010\u000b\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b#\u0010\u000f\"\u0004\b\u0003\u0010\u001dR\"\u0010\n\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0004R\"\u0010\u001f\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b&\u0010\u000f\"\u0004\b\u0006\u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001e\u0010'\u001a\u0004\b!\u0010(R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005@\u0007X\u0087\n¢\u0006\f\n\u0004\b \u0010\u0019\"\u0004\b\t\u0010\u001aR\u001a\u0010\u001c\u001a\u00020)8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b\u001f\u0010+"}, d2 = {"Lid/dana/oauth/OauthLoginManager;", "", "", "getAuthRequestContext", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()Z", "PrepareContext", "isLayoutRequested", "Lid/dana/oauth/model/OauthParamsModel;", "p0", "(Lid/dana/oauth/model/OauthParamsModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lcom/iap/ac/android/biz/common/model/gol/SignContractRequest;", "Lcom/iap/ac/android/biz/common/model/gol/SignContractRequest;", "PlaceComponentResult", "Ljava/lang/String;", "(Ljava/lang/String;)V", "Z", "initRecordTimeStamp", "(Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "lookAheadTest", "GetContactSyncConfig", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/oauth/model/OauthParamsModel;", "()Lid/dana/oauth/model/OauthParamsModel;", "", "I", "()I", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OauthLoginManager {
    private static String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private static String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private static boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private static OauthParamsModel moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private static boolean lookAheadTest;
    private static int initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private static boolean getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private static boolean getErrorConfigVersion;
    public static final OauthLoginManager INSTANCE = new OauthLoginManager();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public static final SignContractRequest PlaceComponentResult = new SignContractRequest();

    private OauthLoginManager() {
    }

    @JvmName(name = "moveToNextValue")
    public static OauthParamsModel moveToNextValue() {
        return moveToNextValue;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static void MyBillsEntityDataFactory(String str) {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
    }

    @JvmName(name = "PlaceComponentResult")
    public static String PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "getAuthRequestContext")
    public static void getAuthRequestContext(String str) {
        BuiltInFictitiousFunctionClassFactory = str;
    }

    @JvmName(name = "DatabaseTableConfigUtil")
    public static boolean DatabaseTableConfigUtil() {
        return getErrorConfigVersion;
    }

    @JvmName(name = "getAuthRequestContext")
    public static void getAuthRequestContext(boolean z) {
        getErrorConfigVersion = z;
    }

    @JvmName(name = "GetContactSyncConfig")
    public static boolean GetContactSyncConfig() {
        return getAuthRequestContext;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static void MyBillsEntityDataFactory(boolean z) {
        getAuthRequestContext = z;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda1")
    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "PlaceComponentResult")
    public static void PlaceComponentResult(boolean z) {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static void BuiltInFictitiousFunctionClassFactory(boolean z) {
        KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @JvmName(name = "initRecordTimeStamp")
    public static boolean initRecordTimeStamp() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "newProxyInstance")
    public static boolean newProxyInstance() {
        return scheduleImpl;
    }

    @JvmName(name = "lookAheadTest")
    public static int lookAheadTest() {
        return initRecordTimeStamp;
    }

    public static String getErrorConfigVersion() {
        OauthParamsModel oauthParamsModel = moveToNextValue;
        String str = oauthParamsModel != null ? oauthParamsModel.GetContactSyncConfig : null;
        return str == null ? "" : str;
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        OauthParamsModel oauthParamsModel = moveToNextValue;
        String str = oauthParamsModel != null ? oauthParamsModel.BuiltInFictitiousFunctionClassFactory : null;
        return str == null ? "" : str;
    }

    public static String MyBillsEntityDataFactory() {
        OauthParamsModel oauthParamsModel = moveToNextValue;
        String str = oauthParamsModel != null ? oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        return str == null ? "" : str;
    }

    public static String scheduleImpl() {
        OauthParamsModel oauthParamsModel = moveToNextValue;
        String str = oauthParamsModel != null ? oauthParamsModel.lookAheadTest : null;
        return str == null ? "" : str;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        String str;
        OauthParamsModel oauthParamsModel = moveToNextValue;
        if (oauthParamsModel != null) {
            String str2 = oauthParamsModel != null ? oauthParamsModel.BuiltInFictitiousFunctionClassFactory : null;
            if (str2 == null) {
                str2 = "";
            }
            if (str2.length() > 0) {
                OauthParamsModel oauthParamsModel2 = moveToNextValue;
                if (oauthParamsModel2 == null || (str = oauthParamsModel2.MyBillsEntityDataFactory) == null || str.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String str;
        OauthParamsModel oauthParamsModel = moveToNextValue;
        return (oauthParamsModel == null || (str = oauthParamsModel.GetContactSyncConfig) == null) ? "" : str;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        OauthParamsModel oauthParamsModel = moveToNextValue;
        if (oauthParamsModel == null || (str = oauthParamsModel.initRecordTimeStamp) == null) {
            String str2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
            return str2 == null ? "" : str2;
        }
        return str;
    }

    public static void isLayoutRequested() {
        initRecordTimeStamp = 0;
    }

    public static void getAuthRequestContext() {
        scheduleImpl = false;
        lookAheadTest = false;
    }

    public static void PrepareContext() {
        MyBillsEntityDataFactory = false;
        moveToNextValue = null;
        getAuthRequestContext = false;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(OauthParamsModel p0) {
        MyBillsEntityDataFactory = false;
        moveToNextValue = null;
        getAuthRequestContext = false;
        if (p0 != null) {
            String str = p0.initRecordTimeStamp;
            if (str == null || str.length() == 0) {
                p0.initRecordTimeStamp = NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
        }
        moveToNextValue = p0;
        String str2 = p0 != null ? p0.GetContactSyncConfig : null;
        MyBillsEntityDataFactory = !(str2 == null || StringsKt.isBlank(str2));
    }
}
