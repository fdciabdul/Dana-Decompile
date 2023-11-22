package androidx.credentials;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/CredentialProviderFactory;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CredentialProviderFactory {
    private static final String CREDENTIAL_PROVIDER_KEY = "androidx.credentials.CREDENTIAL_PROVIDER_KEY";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CRED_MAN_PRE_FRAMEWORK_API_LEVEL = 33;
    private static final String TAG = "CredProviderFactory";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011"}, d2 = {"Landroidx/credentials/CredentialProviderFactory$Companion;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "", "getAllowedProvidersFromManifest", "(Landroid/content/Context;)Ljava/util/List;", "Landroidx/credentials/CredentialProvider;", "getBestAvailableProvider", "(Landroid/content/Context;)Landroidx/credentials/CredentialProvider;", "getUAndAboveProvider", "classNames", "instantiatePreUProvider", "(Ljava/util/List;Landroid/content/Context;)Landroidx/credentials/CredentialProvider;", "tryCreatePreUOemProvider", "CREDENTIAL_PROVIDER_KEY", "Ljava/lang/String;", "", "MAX_CRED_MAN_PRE_FRAMEWORK_API_LEVEL", "I", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final byte[] MyBillsEntityDataFactory = {11, -83, -14, 91, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
        public static final int BuiltInFictitiousFunctionClassFactory = 14;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CredentialProvider getBestAvailableProvider(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            if (Build.VERSION.SDK_INT >= 34) {
                return new CredentialProviderFrameworkImpl(context);
            }
            if (Build.VERSION.SDK_INT <= 33) {
                return tryCreatePreUOemProvider(context);
            }
            return null;
        }

        public final CredentialProvider getUAndAboveProvider(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            return new CredentialProviderFrameworkImpl(context);
        }

        private final CredentialProvider tryCreatePreUOemProvider(Context context) {
            List<String> allowedProvidersFromManifest = getAllowedProvidersFromManifest(context);
            if (allowedProvidersFromManifest.isEmpty()) {
                return null;
            }
            return instantiatePreUProvider(allowedProvidersFromManifest, context);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:6:0x0015, B:10:0x0048, B:12:0x004f, B:15:0x0074, B:18:0x007e), top: B:23:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:6:0x0015, B:10:0x0048, B:12:0x004f, B:15:0x0074, B:18:0x007e), top: B:23:0x0015 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0080 -> B:20:0x0084). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final androidx.credentials.CredentialProvider instantiatePreUProvider(java.util.List<java.lang.String> r17, android.content.Context r18) {
            /*
                r16 = this;
                java.util.Iterator r0 = r17.iterator()
                r1 = 0
                r2 = r0
                r3 = r1
                r0 = r18
            L9:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L8f
                java.lang.Object r4 = r2.next()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L8c
                r5 = 1
                java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L8c
                byte[] r7 = androidx.credentials.CredentialProviderFactory.Companion.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L8c
                r8 = 5
                r7 = r7[r8]     // Catch: java.lang.Throwable -> L8c
                int r7 = r7 + r5
                byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L8c
                int r8 = r7 + 1
                byte r8 = (byte) r8     // Catch: java.lang.Throwable -> L8c
                byte r9 = (byte) r8     // Catch: java.lang.Throwable -> L8c
                int r7 = r7 + 4
                int r9 = r9 * 4
                int r9 = 97 - r9
                int r8 = r8 * 4
                int r8 = 23 - r8
                byte[] r10 = androidx.credentials.CredentialProviderFactory.Companion.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L8c
                byte[] r11 = new byte[r8]     // Catch: java.lang.Throwable -> L8c
                int r8 = r8 + (-1)
                r12 = -1
                if (r10 != 0) goto L42
                r14 = r9
                r12 = r11
                r13 = -1
                r9 = r7
                r11 = r10
                r10 = r8
                r8 = r6
                goto L84
            L42:
                r12 = r11
                r13 = -1
                r11 = r10
                r10 = r8
                r8 = r7
                r7 = r6
            L48:
                int r13 = r13 + r5
                byte r14 = (byte) r9     // Catch: java.lang.Throwable -> L8c
                r12[r13] = r14     // Catch: java.lang.Throwable -> L8c
                int r8 = r8 + r5
                if (r13 != r10) goto L7e
                java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L8c
                r9 = 0
                r8.<init>(r12, r9)     // Catch: java.lang.Throwable -> L8c
                java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Throwable -> L8c
                r6[r9] = r8     // Catch: java.lang.Throwable -> L8c
                java.lang.reflect.Constructor r4 = r4.getConstructor(r7)     // Catch: java.lang.Throwable -> L8c
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L8c
                r5[r9] = r0     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r4 = r4.newInstance(r5)     // Catch: java.lang.Throwable -> L8c
                kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: java.lang.Throwable -> L8c
                androidx.credentials.CredentialProvider r4 = (androidx.credentials.CredentialProvider) r4     // Catch: java.lang.Throwable -> L8c
                boolean r5 = r4.isAvailableOnDevice()     // Catch: java.lang.Throwable -> L8c
                if (r5 == 0) goto L9
                if (r3 == 0) goto L7c
                java.lang.String r4 = "CredProviderFactory"
                java.lang.String r5 = "Only one active OEM CredentialProvider allowed"
                com.fullstory.instrumentation.InstrumentInjector.log_i(r4, r5)     // Catch: java.lang.Throwable -> L8c
                return r1
            L7c:
                r3 = r4
                goto L9
            L7e:
                r14 = r11[r8]     // Catch: java.lang.Throwable -> L8c
                r15 = r8
                r8 = r7
                r7 = r9
                r9 = r15
            L84:
                int r7 = r7 + r14
                int r7 = r7 + (-8)
                r15 = r9
                r9 = r7
                r7 = r8
                r8 = r15
                goto L48
            L8c:
                goto L9
            L8f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.CredentialProviderFactory.Companion.instantiatePreUProvider(java.util.List, android.content.Context):androidx.credentials.CredentialProvider");
        }

        private final List<String> getAllowedProvidersFromManifest(Context context) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
            ArrayList arrayList = new ArrayList();
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                Intrinsics.checkNotNullExpressionValue(serviceInfoArr, "");
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.metaData != null) {
                        Bundle bundle = serviceInfo.metaData;
                        arrayList.add("androidx.credentials.playservices.CredentialProviderPlayServicesImpl");
                    }
                }
            }
            return CollectionsKt.toList(arrayList);
        }
    }
}
