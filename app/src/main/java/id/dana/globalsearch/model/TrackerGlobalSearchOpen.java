package id.dana.globalsearch.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/globalsearch/model/TrackerGlobalSearchOpen;", "", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrackerGlobalSearchOpen {
    public static final TrackerGlobalSearchOpen INSTANCE = new TrackerGlobalSearchOpen();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static String getAuthRequestContext = "Deeplink";

    private TrackerGlobalSearchOpen() {
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext = p0;
    }
}
