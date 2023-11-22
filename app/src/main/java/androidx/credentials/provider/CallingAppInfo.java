package androidx.credentials.provider;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.credentials.provider.utils.PrivilegedApp;
import androidx.credentials.provider.utils.RequestValidationUtil;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB#\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002¢\u0006\u0004\b\n\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0004\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo;", "", "", "privilegedAllowlist", "getOrigin", "(Ljava/lang/String;)Ljava/lang/String;", "", "Landroidx/credentials/provider/utils/PrivilegedApp;", "candidateApps", "", "isAppPrivileged", "(Ljava/util/List;)Z", "", "candidateFingerprints", "(Ljava/util/Set;)Z", "isOriginPopulated", "()Z", "origin", "Ljava/lang/String;", "()Ljava/lang/String;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "getPackageName", "Landroid/content/pm/SigningInfo;", "signingInfo", "Landroid/content/pm/SigningInfo;", "getSigningInfo", "()Landroid/content/pm/SigningInfo;", "<init>", "(Ljava/lang/String;Landroid/content/pm/SigningInfo;Ljava/lang/String;)V", "Companion", "SignatureVerifierApi28"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallingAppInfo {
    private static final String TAG = "CallingAppInfo";
    private final String origin;
    private final String packageName;
    private final SigningInfo signingInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String str, SigningInfo signingInfo) {
        this(str, signingInfo, null, 4, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(signingInfo, "");
    }

    public CallingAppInfo(String str, SigningInfo signingInfo, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(signingInfo, "");
        this.packageName = str;
        this.signingInfo = signingInfo;
        this.origin = str2;
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("packageName must not be empty".toString());
        }
    }

    public /* synthetic */ CallingAppInfo(String str, SigningInfo signingInfo, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, signingInfo, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getPackageName")
    public final String getPackageName() {
        return this.packageName;
    }

    @JvmName(name = "getSigningInfo")
    public final SigningInfo getSigningInfo() {
        return this.signingInfo;
    }

    @JvmName(name = "getOrigin")
    public final String getOrigin() {
        return this.origin;
    }

    public final String getOrigin(String privilegedAllowlist) {
        Intrinsics.checkNotNullParameter(privilegedAllowlist, "");
        if (!RequestValidationUtil.INSTANCE.isValidJSON(privilegedAllowlist)) {
            throw new IllegalArgumentException("privilegedAllowlist must not be empty, and must be a valid JSON");
        }
        String str = this.origin;
        if (str == null) {
            return str;
        }
        try {
            if (isAppPrivileged(PrivilegedApp.INSTANCE.extractPrivilegedApps$credentials_release(new JSONObject(privilegedAllowlist)))) {
                return this.origin;
            }
            throw new IllegalStateException("Origin is not being returned as the calling app did notmatch the privileged allowlist");
        } catch (JSONException unused) {
            throw new IllegalArgumentException("privilegedAllowlist must be formatted properly");
        }
    }

    public final boolean isOriginPopulated() {
        return this.origin != null;
    }

    private final boolean isAppPrivileged(List<PrivilegedApp> candidateApps) {
        for (PrivilegedApp privilegedApp : candidateApps) {
            if (Intrinsics.areEqual(privilegedApp.getPackageName(), this.packageName)) {
                return isAppPrivileged(privilegedApp.getFingerprints());
            }
        }
        return false;
    }

    private final boolean isAppPrivileged(Set<String> candidateFingerprints) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new SignatureVerifierApi28(this.signingInfo).verifySignatureFingerprints(candidateFingerprints);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo$SignatureVerifierApi28;", "", "", "Landroid/content/pm/Signature;", "signatures", "", "", "convertToFingerprints", "([Landroid/content/pm/Signature;)Ljava/util/Set;", "getSignatureFingerprints", "()Ljava/util/Set;", "candidateSigFingerprints", "", "verifySignatureFingerprints", "(Ljava/util/Set;)Z", "Landroid/content/pm/SigningInfo;", "signingInfo", "Landroid/content/pm/SigningInfo;", "<init>", "(Landroid/content/pm/SigningInfo;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SignatureVerifierApi28 {
        private final SigningInfo signingInfo;

        public SignatureVerifierApi28(SigningInfo signingInfo) {
            Intrinsics.checkNotNullParameter(signingInfo, "");
            this.signingInfo = signingInfo;
        }

        private final Set<String> getSignatureFingerprints() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (this.signingInfo.hasMultipleSigners() && this.signingInfo.getApkContentsSigners() != null) {
                Signature[] apkContentsSigners = this.signingInfo.getApkContentsSigners();
                Intrinsics.checkNotNullExpressionValue(apkContentsSigners, "");
                linkedHashSet.addAll(convertToFingerprints(apkContentsSigners));
            } else if (this.signingInfo.getSigningCertificateHistory() != null) {
                Signature signature = this.signingInfo.getSigningCertificateHistory()[0];
                Intrinsics.checkNotNullExpressionValue(signature, "");
                linkedHashSet.addAll(convertToFingerprints(new Signature[]{signature}));
            }
            return linkedHashSet;
        }

        private final Set<String> convertToFingerprints(Signature[] signatures) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Signature signature : signatures) {
                byte[] digest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
                Intrinsics.checkNotNullExpressionValue(digest, "");
                linkedHashSet.add(ArraysKt.joinToString$default(digest, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: androidx.credentials.provider.CallingAppInfo$SignatureVerifierApi28$convertToFingerprints$1
                    public final CharSequence invoke(byte b) {
                        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        return format;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }
                }, 30, (Object) null));
            }
            return linkedHashSet;
        }

        public final boolean verifySignatureFingerprints(Set<String> candidateSigFingerprints) {
            Intrinsics.checkNotNullParameter(candidateSigFingerprints, "");
            Set<String> signatureFingerprints = getSignatureFingerprints();
            if (this.signingInfo.hasMultipleSigners()) {
                return candidateSigFingerprints.containsAll(signatureFingerprints);
            }
            return !CollectionsKt.intersect(candidateSigFingerprints, signatureFingerprints).isEmpty();
        }
    }
}
