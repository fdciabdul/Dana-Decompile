package id.dana.mybills.utils;

import id.dana.mybills.ui.constant.BizProviderName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u00020\u0007*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010"}, d2 = {"Lid/dana/mybills/utils/PhoneNumberUtils;", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "", "", "getAuthRequestContext", "(Ljava/lang/String;[Ljava/lang/String;)Z", "Lid/dana/mybills/utils/PhoneNumberValidation;", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/mybills/utils/PhoneNumberValidation;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "[Ljava/lang/String;", "moveToNextValue", "lookAheadTest", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhoneNumberUtils {
    public static final PhoneNumberUtils INSTANCE = new PhoneNumberUtils();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final String getAuthRequestContext = BizProviderName.BYU;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private static final String getErrorConfigVersion = BizProviderName.MPWR;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = BizProviderName.LIVE_ON;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private static final String MyBillsEntityDataFactory = "indosat";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private static final String initRecordTimeStamp = "telkomsel";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda8 = "xl";

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private static final String DatabaseTableConfigUtil = "smartfren";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private static final String GetContactSyncConfig = "tri";

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final String BuiltInFictitiousFunctionClassFactory = "axis";

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static final String[] PlaceComponentResult = {"085155", "085156", "085157", "085158"};

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private static final String[] lookAheadTest = {"081414"};

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private static final String[] moveToNextValue = {"0859103", "0859104", "0859105", "0859106"};

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private static final String[] scheduleImpl = {"0814", "0815", "0816", "0855", "0856", "0857", "0858"};
    private static final String[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {"0811", "0812", "0813", "0821", "0822", "0823", "0851", "0852", "0853", "0854"};

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private static final String[] NetworkUserEntityData$$ExternalSyntheticLambda7 = {"0817", "0818", "0819", "08590", "0877", "0878", "0879", "08592", "08593", "08594", "08595", "08596", "08597", "08599"};
    private static final String[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {"0881", "0882", "0883", "0884", "0885", "0886", "0887", "0888", "0889"};
    private static final String[] PrepareContext = {"0895", "0896", "0897", "0898", "0899"};

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {"0831", "0832", "0833", "0838", "08591", "08598"};

    private PhoneNumberUtils() {
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://a.m.dana.id/resource/imgs/providerLogo/telco-square/");
        sb.append(p0);
        sb.append(".png");
        return sb.toString();
    }

    public static PhoneNumberValidation PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (StringsKt.startsWith$default(str, "62", false, 2, (Object) null)) {
            str = StringsKt.replaceFirst$default(str, "62", "0", false, 4, (Object) null);
        }
        PhoneNumberValidation phoneNumberValidation = new PhoneNumberValidation(str, null, null, 6, null);
        if (!getAuthRequestContext(str, PlaceComponentResult)) {
            if (!getAuthRequestContext(str, lookAheadTest)) {
                if (!getAuthRequestContext(str, moveToNextValue)) {
                    if (!getAuthRequestContext(str, scheduleImpl)) {
                        if (!getAuthRequestContext(str, NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                            if (!getAuthRequestContext(str, NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                                if (!getAuthRequestContext(str, NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                                    if (!getAuthRequestContext(str, PrepareContext)) {
                                        if (getAuthRequestContext(str, KClassImpl$Data$declaredNonStaticMembers$2)) {
                                            phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                                            phoneNumberValidation.PlaceComponentResult = "axis";
                                        }
                                    } else {
                                        phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(GetContactSyncConfig);
                                        phoneNumberValidation.PlaceComponentResult = "tri";
                                    }
                                } else {
                                    phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(DatabaseTableConfigUtil);
                                    phoneNumberValidation.PlaceComponentResult = "smartfren";
                                }
                            } else {
                                phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda8);
                                phoneNumberValidation.PlaceComponentResult = "xl";
                            }
                        } else {
                            phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(initRecordTimeStamp);
                            phoneNumberValidation.PlaceComponentResult = "telkomsel";
                        }
                    } else {
                        phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                        phoneNumberValidation.PlaceComponentResult = "indosat";
                    }
                } else {
                    phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda0);
                    phoneNumberValidation.PlaceComponentResult = BizProviderName.LIVE_ON;
                }
            } else {
                phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion);
                phoneNumberValidation.PlaceComponentResult = BizProviderName.MPWR;
            }
        } else {
            phoneNumberValidation.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext);
            phoneNumberValidation.PlaceComponentResult = BizProviderName.BYU;
        }
        return phoneNumberValidation;
    }

    private static boolean getAuthRequestContext(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
