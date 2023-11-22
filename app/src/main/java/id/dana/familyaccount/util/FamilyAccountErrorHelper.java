package id.dana.familyaccount.util;

import id.dana.network.exception.NetworkException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/familyaccount/util/FamilyAccountErrorHelper;", "", "", "", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountErrorHelper {
    public static final FamilyAccountErrorHelper INSTANCE = new FamilyAccountErrorHelper();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final List<String> MyBillsEntityDataFactory = CollectionsKt.listOf((Object[]) new String[]{"AE15112158339345", "AE15112158339347", "AE15112158336329", "AE15112158339348", "AE15112158339325", "AE15112158339201"});

    private FamilyAccountErrorHelper() {
    }

    public static boolean getAuthRequestContext(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return (th instanceof NetworkException) && MyBillsEntityDataFactory.contains(((NetworkException) th).getErrorCode());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MyBillsEntityDataFactory(java.lang.Throwable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            boolean r0 = r1 instanceof id.dana.network.exception.NetworkException
            if (r0 == 0) goto L76
            id.dana.network.exception.NetworkException r1 = (id.dana.network.exception.NetworkException) r1
            java.lang.String r1 = r1.getErrorCode()
            if (r1 == 0) goto L76
            int r0 = r1.hashCode()
            switch(r0) {
                case -75859092: goto L6a;
                case 408591349: goto L5f;
                case 408594260: goto L53;
                case 408596363: goto L4a;
                case 408596364: goto L3e;
                case 510866378: goto L35;
                case 1586449126: goto L2c;
                case 1586449157: goto L23;
                case 2000531499: goto L1a;
                default: goto L18;
            }
        L18:
            goto L76
        L1a:
            java.lang.String r0 = "AE13012128002430"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L73
            goto L76
        L23:
            java.lang.String r0 = "AE13112148999313"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L47
            goto L76
        L2c:
            java.lang.String r0 = "AE13112148999303"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L47
            goto L76
        L35:
            java.lang.String r0 = "AE13112168000993"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L47
            goto L76
        L3e:
            java.lang.String r0 = "AE15101858018871"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L47
            goto L76
        L47:
            java.lang.String r1 = "ACCOUNT_FREEZE"
            goto L78
        L4a:
            java.lang.String r0 = "AE15101858018870"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L67
            goto L76
        L53:
            java.lang.String r0 = "AE15101858018615"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5c
            goto L76
        L5c:
            java.lang.String r1 = "KYC_REVOKED"
            goto L78
        L5f:
            java.lang.String r0 = "AE15101858018308"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L76
        L67:
            java.lang.String r1 = "REQUEST_EXPIRED"
            goto L78
        L6a:
            java.lang.String r0 = "AE15112168003039"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L73
            goto L76
        L73:
            java.lang.String r1 = "MEMBER_USER_FREEZE"
            goto L78
        L76:
            java.lang.String r1 = "GENERAL_STATUS_ERROR"
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.util.FamilyAccountErrorHelper.MyBillsEntityDataFactory(java.lang.Throwable):java.lang.String");
    }
}
