package com.google.android.gms.common;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes7.dex */
public class PackageSignatureVerifier {
    static volatile zzac zza;
    private static zzad zzb;

    private static zzad zza() {
        zzad zzadVar;
        synchronized (zzad.class) {
            if (zzb == null) {
                zzb = new zzad();
            }
            zzadVar = zzb;
        }
        return zzadVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        PackageVerificationResult packageVerificationResult;
        String str2;
        PackageVerificationResult packageVerificationResult2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza();
        if (zzn.zzf()) {
            String concat = String.valueOf(str).concat(true != honorsDebugCertificates ? "-0" : "-1");
            if (zza != null) {
                str2 = zza.zza;
                if (str2.equals(concat)) {
                    packageVerificationResult2 = zza.zzb;
                    return packageVerificationResult2;
                }
            }
            zza();
            zzx zzc = zzn.zzc(str, honorsDebugCertificates, false, false);
            if (!zzc.zza) {
                Preconditions.checkNotNull(zzc.zzb);
                return PackageVerificationResult.zza(str, zzc.zzb, zzc.zzc);
            }
            zzac zzacVar = new zzac(concat, PackageVerificationResult.zzd(str, zzc.zzd));
            zza = zzacVar;
            packageVerificationResult = zzacVar.zzb;
            return packageVerificationResult;
        }
        throw new zzae();
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzc()) {
                InstrumentInjector.log_e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
                return queryPackageSignatureVerified2;
            }
            return queryPackageSignatureVerified2;
        }
    }
}
