package id.dana.cashier.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/utils/CashierPayQueryCounter;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "PlaceComponentResult", "", "p0", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "()I", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayQueryCounter {
    public static final CashierPayQueryCounter INSTANCE = new CashierPayQueryCounter();
    private static int getAuthRequestContext;

    private CashierPayQueryCounter() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static int BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext++;
    }

    public static void PlaceComponentResult() {
        getAuthRequestContext = 0;
    }
}
