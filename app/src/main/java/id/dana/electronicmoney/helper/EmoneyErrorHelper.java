package id.dana.electronicmoney.helper;

import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorCode;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0011\u0010\t\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0011\u0010\f\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0011\u0010\r\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0011\u0010\u0013\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0011\u0010\u0017\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0005R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019"}, d2 = {"Lid/dana/electronicmoney/helper/EmoneyErrorHelper;", "", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;)Z", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "", "(Ljava/lang/String;)Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "DatabaseTableConfigUtil", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isLayoutRequested", "PrepareContext", "", "[Ljava/lang/String;", "<init>", "()V", "EmoneyErrorChecker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmoneyErrorHelper {
    public static final EmoneyErrorHelper INSTANCE = new EmoneyErrorHelper();
    private static final String[] getAuthRequestContext = {EmoneyMandiriErrorCode.TID_NOT_FOUND, EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND, EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAIL};

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final String[] BuiltInFictitiousFunctionClassFactory = {"30001", "30000", EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND_CODE, EmoneyMandiriErrorCode.CARD_NOT_SUPPORTED, EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAILED, "51003", EmoneyMandiriErrorCode.REVERSAL_NEEDED, EmoneyMandiriErrorCode.GENERAL_ERROR, EmoneyMandiriErrorCode.CARD_NOT_FOUND, EmoneyMandiriErrorCode.ACCOUNT_LIMIT_EXCEEDED, EmoneyMandiriErrorCode.MONTHLY_TOPUP_LIMIT_EXCEDEED, EmoneyMandiriErrorCode.RETRY_UPDATE_BALANCE, EmoneyMandiriErrorCode.REVERSAL_UPDATE_BALANCE, EmoneyMandiriErrorCode.TID_NOT_FOUND, EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAIL, EmoneyMandiriErrorCode.NO_PENDING_BALANCE};

    private EmoneyErrorHelper() {
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        if (!Intrinsics.areEqual(str, EmoneyMandiriErrorCode.NO_PENDING_BALANCE)) {
            if (!(str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "51003", false, 2, (Object) null))) {
                return false;
            }
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/electronicmoney/helper/EmoneyErrorHelper$EmoneyErrorChecker;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "PlaceComponentResult", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class EmoneyErrorChecker {
        public final String PlaceComponentResult;

        public EmoneyErrorChecker(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return StringsKt.contains$default((CharSequence) p0, (CharSequence) this.PlaceComponentResult, false, 2, (Object) null);
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) EmoneyMandiriErrorCode.CARD_NOT_SUPPORTED, false, 2, (Object) null);
        }
        return false;
    }

    public static boolean PlaceComponentResult(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAILED).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAIL).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        if (str != null) {
            return StringsKt.contains$default((CharSequence) str, (CharSequence) EmoneyMandiriErrorCode.GENERAL_ERROR, false, 2, (Object) null);
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.GENERAL_ERROR).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.CARD_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TID_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND_CODE).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean getAuthRequestContext(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.PlaceComponentResult.get("message");
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return upperCase != null && StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "BALANCE", false, 2, (Object) null);
        }
        return false;
    }

    public static boolean moveToNextValue(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.PlaceComponentResult.get("message");
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return upperCase != null && StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "DONE", false, 2, (Object) null);
        }
        return false;
    }

    public static boolean getErrorConfigVersion(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.PlaceComponentResult.get("message");
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return upperCase != null && StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "DONE_00", false, 2, (Object) null);
        }
        return false;
    }

    public static boolean lookAheadTest(EmoneyApiResult emoneyApiResult) {
        String str;
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str2 = emoneyApiResult.PlaceComponentResult.get("message");
        if (str2 != null) {
            str = str2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        String str3 = str != null ? str : "";
        if (new EmoneyErrorChecker("DONE_P5").BuiltInFictitiousFunctionClassFactory(str3) ? true : new EmoneyErrorChecker("DONE_P6").BuiltInFictitiousFunctionClassFactory(str3)) {
            return true;
        }
        return new EmoneyErrorChecker("DONE_").BuiltInFictitiousFunctionClassFactory(str3);
    }

    public static boolean scheduleImpl(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        if (!Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorCode.NO_PENDING_BALANCE)) {
            String str = emoneyApiResult.getAuthRequestContext;
            if (!(str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "51003", false, 2, (Object) null))) {
                return false;
            }
        }
        return true;
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.GENERAL_ERROR).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TID_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TERMINAL_NOT_FOUND_CODE).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.DIGITAL_SIGNATURE_FAILED).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean DatabaseTableConfigUtil(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        return Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorCode.THREE_TIMES_LIMIT);
    }

    public static boolean GetContactSyncConfig(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        return Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorCode.RETRY_UPDATE_BALANCE) || ArraysKt.contains(getAuthRequestContext, emoneyApiResult.getAuthRequestContext);
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda1(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.REVERSAL_NEEDED).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.REVERSAL_IN_PROGRESS).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.REVERSAL_LIMIT_EXCEEDED).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean initRecordTimeStamp(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.CARD_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TID_NOT_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.REVERSAL_AMOUNT_DID_NOT_MATCH).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.TRANSACTION_CAN_NOT_BE_FOUND).BuiltInFictitiousFunctionClassFactory(str2) ? true : new EmoneyErrorChecker(EmoneyMandiriErrorCode.ACCOUNT_LIMIT_EXCEEDED).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.MONTHLY_TOPUP_LIMIT_EXCEDEED).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda2(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        String str2 = str != null ? str : "";
        if (new EmoneyErrorChecker(EmoneyMandiriErrorCode.DATA_MISMATCH).BuiltInFictitiousFunctionClassFactory(str2)) {
            return true;
        }
        return new EmoneyErrorChecker(EmoneyMandiriErrorCode.REVERSAL_UPDATE_BALANCE).BuiltInFictitiousFunctionClassFactory(str2);
    }

    public static boolean isLayoutRequested(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        return Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, "TIMEOUT");
    }

    public static boolean PrepareContext(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        if (!Intrinsics.areEqual(emoneyApiResult.getAuthRequestContext, EmoneyMandiriErrorCode.CARD_NOT_FOUND)) {
            String str = emoneyApiResult.getAuthRequestContext;
            if (!StringsKt.contains$default((CharSequence) (str != null ? str : ""), (CharSequence) EmoneyMandiriErrorCode.CARD_NOT_FOUND, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
