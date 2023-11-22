package id.dana.cashier.helper;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\n\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\n\u0010\u000fR\"\u0010\u0010\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\t\u0010\u000fR\"\u0010\u0003\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/cashier/helper/CashierVariables;", "", "", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "lookAheadTest", "()V", "MyBillsEntityDataFactory", "PlaceComponentResult", "getErrorConfigVersion", "", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierVariables {
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static boolean MyBillsEntityDataFactory;
    public static final CashierVariables INSTANCE = new CashierVariables();
    private static String PlaceComponentResult = "";

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private static String getAuthRequestContext = "";

    private CashierVariables() {
    }

    @JvmName(name = "PlaceComponentResult")
    public static void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        PlaceComponentResult = str;
    }

    @JvmName(name = "getAuthRequestContext")
    public static String getAuthRequestContext() {
        return PlaceComponentResult;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static String BuiltInFictitiousFunctionClassFactory() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static void MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory = str;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return MyBillsEntityDataFactory;
    }

    @JvmName(name = "lookAheadTest")
    public static void lookAheadTest() {
        MyBillsEntityDataFactory = true;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static void BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        getAuthRequestContext = str;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static String MyBillsEntityDataFactory() {
        return getAuthRequestContext;
    }

    @JvmName(name = "PlaceComponentResult")
    public static boolean PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getErrorConfigVersion")
    public static void getErrorConfigVersion() {
        KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }
}
