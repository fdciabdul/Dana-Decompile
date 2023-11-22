package androidx.credentials.provider.utils;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Landroidx/credentials/provider/utils/PrivilegedApp;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Set;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "fingerprints", "copy", "(Ljava/lang/String;Ljava/util/Set;)Landroidx/credentials/provider/utils/PrivilegedApp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Set;", "getFingerprints", "Ljava/lang/String;", "getPackageName", "<init>", "(Ljava/lang/String;Ljava/util/Set;)V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PrivilegedApp {
    private static final String ANDROID_TYPE_KEY = "android";
    private static final String APPS_KEY = "apps";
    private static final String APP_INFO_KEY = "info";
    private static final String BUILD_KEY = "build";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FINGERPRINT_KEY = "cert_fingerprint_sha256";
    private static final String PACKAGE_NAME_KEY = "package_name";
    private static final String SIGNATURES_KEY = "signatures";
    private static final String TYPE_KEY = "type";
    private static final String USER_BUILD_TYPE = "userdebug";
    private static final String USER_DEBUG_KEY = "userdebug";
    private final Set<String> fingerprints;
    private final String packageName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrivilegedApp copy$default(PrivilegedApp privilegedApp, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = privilegedApp.packageName;
        }
        if ((i & 2) != 0) {
            set = privilegedApp.fingerprints;
        }
        return privilegedApp.copy(str, set);
    }

    @JvmStatic
    public static final PrivilegedApp createFromJSONObject(JSONObject jSONObject, boolean z) {
        return INSTANCE.createFromJSONObject(jSONObject, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final Set<String> component2() {
        return this.fingerprints;
    }

    public final PrivilegedApp copy(String packageName, Set<String> fingerprints) {
        Intrinsics.checkNotNullParameter(packageName, "");
        Intrinsics.checkNotNullParameter(fingerprints, "");
        return new PrivilegedApp(packageName, fingerprints);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PrivilegedApp) {
            PrivilegedApp privilegedApp = (PrivilegedApp) other;
            return Intrinsics.areEqual(this.packageName, privilegedApp.packageName) && Intrinsics.areEqual(this.fingerprints, privilegedApp.fingerprints);
        }
        return false;
    }

    public final int hashCode() {
        return (this.packageName.hashCode() * 31) + this.fingerprints.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrivilegedApp(packageName=");
        sb.append(this.packageName);
        sb.append(", fingerprints=");
        sb.append(this.fingerprints);
        sb.append(')');
        return sb.toString();
    }

    public PrivilegedApp(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(set, "");
        this.packageName = str;
        this.fingerprints = set;
    }

    @JvmName(name = "getPackageName")
    public final String getPackageName() {
        return this.packageName;
    }

    @JvmName(name = "getFingerprints")
    public final Set<String> getFingerprints() {
        return this.fingerprints;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\t\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000f"}, d2 = {"Landroidx/credentials/provider/utils/PrivilegedApp$Companion;", "", "Lorg/json/JSONObject;", "appInfoJsonObject", "", "filterUserDebug", "Landroidx/credentials/provider/utils/PrivilegedApp;", "createFromJSONObject", "(Lorg/json/JSONObject;Z)Landroidx/credentials/provider/utils/PrivilegedApp;", "jsonObject", "", "extractPrivilegedApps$credentials_release", "(Lorg/json/JSONObject;)Ljava/util/List;", "", "ANDROID_TYPE_KEY", "Ljava/lang/String;", "APPS_KEY", "APP_INFO_KEY", "BUILD_KEY", "FINGERPRINT_KEY", "PACKAGE_NAME_KEY", "SIGNATURES_KEY", "TYPE_KEY", "USER_BUILD_TYPE", "USER_DEBUG_KEY", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        private static int $10 = 0;
        private static int $11 = 1;
        private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        private static int PlaceComponentResult;
        private static char[] getAuthRequestContext = {35424, 35424, 35441, 35743};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<PrivilegedApp> extractPrivilegedApps$credentials_release(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "");
            ArrayList arrayList = new ArrayList();
            Object[] objArr = new Object[1];
            a(new int[]{0, 4, 142, 3}, true, null, objArr);
            JSONArray jSONArray = jsonObject.getJSONArray(((String) objArr[0]).intern());
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                if ((i < length ? 'W' : (char) 30) == 30) {
                    return arrayList;
                }
                int i2 = PlaceComponentResult + 45;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (Intrinsics.areEqual(jSONObject.getString("type"), PrivilegedApp.ANDROID_TYPE_KEY)) {
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
                    PlaceComponentResult = i4 % 128;
                    if (i4 % 2 != 0) {
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
                    arrayList.add(createFromJSONObject(jSONObject2, true));
                }
                i++;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        
            if (r11 != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            if (r11 != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual("userdebug", r1.getJSONObject(r5).optString(androidx.credentials.provider.utils.PrivilegedApp.BUILD_KEY)) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        
            if (r6 == true) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual("userdebug", android.os.Build.TYPE) == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
        
            r6 = r1.getJSONObject(r5).getString(androidx.credentials.provider.utils.PrivilegedApp.FINGERPRINT_KEY);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "");
            r2.add(r6);
            r6 = androidx.credentials.provider.utils.PrivilegedApp.Companion.PlaceComponentResult + 37;
            androidx.credentials.provider.utils.PrivilegedApp.Companion.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
            r6 = r6 % 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        
            r5 = r5 + 1;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.credentials.provider.utils.PrivilegedApp createFromJSONObject(org.json.JSONObject r10, boolean r11) {
            /*
                r9 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch: java.lang.Exception -> L90
                java.lang.String r1 = "signatures"
                org.json.JSONArray r1 = r10.getJSONArray(r1)     // Catch: java.lang.Exception -> L90
                java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch: java.lang.Exception -> L90
                r2.<init>()     // Catch: java.lang.Exception -> L90
                java.util.Set r2 = (java.util.Set) r2     // Catch: java.lang.Exception -> L90
                int r3 = r1.length()     // Catch: java.lang.Exception -> L90
                int r4 = androidx.credentials.provider.utils.PrivilegedApp.Companion.KClassImpl$Data$declaredNonStaticMembers$2
                int r4 = r4 + 117
                int r5 = r4 % 128
                androidx.credentials.provider.utils.PrivilegedApp.Companion.PlaceComponentResult = r5
                int r4 = r4 % 2
                r4 = 0
                r5 = 0
            L23:
                if (r5 >= r3) goto L81
                int r6 = androidx.credentials.provider.utils.PrivilegedApp.Companion.PlaceComponentResult
                int r6 = r6 + 9
                int r7 = r6 % 128
                androidx.credentials.provider.utils.PrivilegedApp.Companion.KClassImpl$Data$declaredNonStaticMembers$2 = r7
                int r6 = r6 % 2
                r7 = 17
                if (r6 != 0) goto L36
                r6 = 17
                goto L38
            L36:
                r6 = 27
            L38:
                if (r6 == r7) goto L3d
                if (r11 == 0) goto L62
                goto L41
            L3d:
                r6 = 0
                int r6 = r6.length     // Catch: java.lang.Throwable -> L7f
                if (r11 == 0) goto L62
            L41:
                org.json.JSONObject r6 = r1.getJSONObject(r5)
                java.lang.String r7 = "build"
                java.lang.String r6 = r6.optString(r7)
                java.lang.String r7 = "userdebug"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r6)
                r8 = 1
                if (r6 == 0) goto L57
                r6 = 0
                goto L58
            L57:
                r6 = 1
            L58:
                if (r6 == r8) goto L62
                java.lang.String r6 = android.os.Build.TYPE
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r6)
                if (r6 == 0) goto L7c
            L62:
                org.json.JSONObject r6 = r1.getJSONObject(r5)
                java.lang.String r7 = "cert_fingerprint_sha256"
                java.lang.String r6 = r6.getString(r7)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                r2.add(r6)
                int r6 = androidx.credentials.provider.utils.PrivilegedApp.Companion.PlaceComponentResult
                int r6 = r6 + 37
                int r7 = r6 % 128
                androidx.credentials.provider.utils.PrivilegedApp.Companion.KClassImpl$Data$declaredNonStaticMembers$2 = r7
                int r6 = r6 % 2
            L7c:
                int r5 = r5 + 1
                goto L23
            L7f:
                r10 = move-exception
                throw r10
            L81:
                java.lang.String r11 = "package_name"
                java.lang.String r10 = r10.getString(r11)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
                androidx.credentials.provider.utils.PrivilegedApp r11 = new androidx.credentials.provider.utils.PrivilegedApp
                r11.<init>(r10, r2)
                return r11
            L90:
                r10 = move-exception
                goto L93
            L92:
                throw r10
            L93:
                goto L92
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.utils.PrivilegedApp.Companion.createFromJSONObject(org.json.JSONObject, boolean):androidx.credentials.provider.utils.PrivilegedApp");
        }

        private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
            int length;
            char[] cArr;
            int i;
            VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            char[] cArr2 = getAuthRequestContext;
            if (cArr2 != null) {
                try {
                    int i6 = $10 + 51;
                    $11 = i6 % 128;
                    if (i6 % 2 == 0) {
                        length = cArr2.length;
                        cArr = new char[length];
                    } else {
                        length = cArr2.length;
                        cArr = new char[length];
                    }
                    int i7 = 0;
                    while (i7 < length) {
                        cArr[i7] = (char) (cArr2[i7] ^ 5097613533456403102L);
                        i7++;
                        int i8 = $11 + 43;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                    }
                    cArr2 = cArr;
                } catch (Exception e) {
                    throw e;
                }
            }
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, i2, cArr3, 0, i3);
            if (bArr != null) {
                char[] cArr4 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    int i10 = $11 + 79;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        int i12 = $10 + 27;
                        $11 = i12 % 128;
                        if (i12 % 2 == 0) {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] + 4) * 0) - c);
                        } else {
                            try {
                                cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if ((i5 > 0 ? 'Z' : 'K') != 'K') {
                char[] cArr5 = new char[i3];
                System.arraycopy(cArr3, 0, cArr5, 0, i3);
                int i13 = i3 - i5;
                System.arraycopy(cArr5, 0, cArr3, i13, i5);
                System.arraycopy(cArr5, i5, cArr3, 0, i13);
            }
            if (z) {
                int i14 = $10 + 17;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                char[] cArr6 = new char[i3];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i4 > 0) {
                int i16 = $11 + 125;
                $10 = i16 % 128;
                int i17 = i16 % 2;
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    int i18 = $11 + 71;
                    $10 = i18 % 128;
                    if (i18 % 2 != 0) {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] / iArr[4]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory - 1;
                    } else {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i;
                }
            }
            objArr[0] = new String(cArr3);
        }
    }
}
