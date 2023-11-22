package id.dana.explore.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/explore/model/TrackerExploreDanaOpen;", "", "", "getAuthRequestContext", "()Ljava/lang/String;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrackerExploreDanaOpen {
    public static final TrackerExploreDanaOpen INSTANCE = new TrackerExploreDanaOpen();
    private static String BuiltInFictitiousFunctionClassFactory = "Home";

    private TrackerExploreDanaOpen() {
    }

    public static String getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory = p0;
    }
}
