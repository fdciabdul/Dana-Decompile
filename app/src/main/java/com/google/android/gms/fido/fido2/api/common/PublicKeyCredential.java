package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class PublicKeyCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzal();
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final AuthenticatorAttestationResponse zzd;
    private final AuthenticatorAssertionResponse zze;
    private final AuthenticatorErrorResponse zzf;
    private final AuthenticationExtensionsClientOutputs zzg;
    private final String zzh;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String zza;
        private byte[] zzb;
        private AuthenticatorResponse zzc;
        private AuthenticationExtensionsClientOutputs zzd;
        private String zze;

        public PublicKeyCredential build() {
            AuthenticatorResponse authenticatorResponse = this.zzc;
            return new PublicKeyCredential(this.zza, PublicKeyCredentialType.PUBLIC_KEY.toString(), this.zzb, authenticatorResponse instanceof AuthenticatorAttestationResponse ? (AuthenticatorAttestationResponse) authenticatorResponse : null, authenticatorResponse instanceof AuthenticatorAssertionResponse ? (AuthenticatorAssertionResponse) authenticatorResponse : null, authenticatorResponse instanceof AuthenticatorErrorResponse ? (AuthenticatorErrorResponse) authenticatorResponse : null, this.zzd, this.zze);
        }

        public Builder setAuthenticationExtensionsClientOutputs(AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs) {
            this.zzd = authenticationExtensionsClientOutputs;
            return this;
        }

        public Builder setAuthenticatorAttachment(String str) {
            this.zze = str;
            return this;
        }

        public Builder setId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setRawId(byte[] bArr) {
            this.zzb = bArr;
            return this;
        }

        public Builder setResponse(AuthenticatorResponse authenticatorResponse) {
            this.zzc = authenticatorResponse;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicKeyCredential(String str, String str2, byte[] bArr, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3) {
        boolean z = true;
        if ((authenticatorAttestationResponse == null || authenticatorAssertionResponse != null || authenticatorErrorResponse != null) && ((authenticatorAttestationResponse != null || authenticatorAssertionResponse == null || authenticatorErrorResponse != null) && (authenticatorAttestationResponse != null || authenticatorAssertionResponse != null || authenticatorErrorResponse == null))) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = authenticatorAttestationResponse;
        this.zze = authenticatorAssertionResponse;
        this.zzf = authenticatorErrorResponse;
        this.zzg = authenticationExtensionsClientOutputs;
        this.zzh = str3;
    }

    public static PublicKeyCredential deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredential) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PublicKeyCredential) {
            PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
            return Objects.equal(this.zza, publicKeyCredential.zza) && Objects.equal(this.zzb, publicKeyCredential.zzb) && Arrays.equals(this.zzc, publicKeyCredential.zzc) && Objects.equal(this.zzd, publicKeyCredential.zzd) && Objects.equal(this.zze, publicKeyCredential.zze) && Objects.equal(this.zzf, publicKeyCredential.zzf) && Objects.equal(this.zzg, publicKeyCredential.zzg) && Objects.equal(this.zzh, publicKeyCredential.zzh);
        }
        return false;
    }

    public String getAuthenticatorAttachment() {
        return this.zzh;
    }

    public AuthenticationExtensionsClientOutputs getClientExtensionResults() {
        return this.zzg;
    }

    public String getId() {
        return this.zza;
    }

    public byte[] getRawId() {
        return this.zzc;
    }

    public AuthenticatorResponse getResponse() {
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
        if (authenticatorAttestationResponse != null) {
            return authenticatorAttestationResponse;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
        if (authenticatorAssertionResponse != null) {
            return authenticatorAssertionResponse;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
        if (authenticatorErrorResponse != null) {
            return authenticatorErrorResponse;
        }
        throw new IllegalStateException("No response set.");
    }

    public String getType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zze, this.zzd, this.zzf, this.zzg, this.zzh);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0058 A[Catch: JSONException -> 0x0078, TRY_ENTER, TryCatch #0 {JSONException -> 0x0078, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000c, B:7:0x0015, B:9:0x0019, B:10:0x001e, B:12:0x0022, B:14:0x0026, B:15:0x002b, B:17:0x002f, B:18:0x0034, B:21:0x003b, B:32:0x0058, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:22:0x0040, B:24:0x0044, B:26:0x004a, B:28:0x004e), top: B:44:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061 A[Catch: JSONException -> 0x0078, TRY_ENTER, TryCatch #0 {JSONException -> 0x0078, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000c, B:7:0x0015, B:9:0x0019, B:10:0x001e, B:12:0x0022, B:14:0x0026, B:15:0x002b, B:17:0x002f, B:18:0x0034, B:21:0x003b, B:32:0x0058, B:33:0x005b, B:36:0x0061, B:38:0x006b, B:22:0x0040, B:24:0x0044, B:26:0x004a, B:28:0x004e), top: B:44:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toJson() {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L78
            r0.<init>()     // Catch: org.json.JSONException -> L78
            byte[] r1 = r4.zzc     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L15
            int r2 = r1.length     // Catch: org.json.JSONException -> L78
            if (r2 <= 0) goto L15
            java.lang.String r2 = "rawId"
            java.lang.String r1 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r1)     // Catch: org.json.JSONException -> L78
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L78
        L15:
            java.lang.String r1 = r4.zzh     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L1e
            java.lang.String r2 = "authenticatorAttachment"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L78
        L1e:
            java.lang.String r1 = r4.zzb     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L2b
            com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse r2 = r4.zzf     // Catch: org.json.JSONException -> L78
            if (r2 != 0) goto L2b
            java.lang.String r2 = "type"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L78
        L2b:
            java.lang.String r1 = r4.zza     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L34
            java.lang.String r2 = "id"
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L78
        L34:
            com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse r1 = r4.zze     // Catch: org.json.JSONException -> L78
            r2 = 0
            java.lang.String r3 = "response"
            if (r1 == 0) goto L40
            org.json.JSONObject r1 = r1.zza()     // Catch: org.json.JSONException -> L78
            goto L48
        L40:
            com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse r1 = r4.zzd     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L4a
            org.json.JSONObject r1 = r1.zza()     // Catch: org.json.JSONException -> L78
        L48:
            r2 = 1
            goto L56
        L4a:
            com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse r1 = r4.zzf     // Catch: org.json.JSONException -> L78
            if (r1 == 0) goto L55
            org.json.JSONObject r1 = r1.zza()     // Catch: org.json.JSONException -> L78
            java.lang.String r3 = "error"
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5b
            r0.put(r3, r1)     // Catch: org.json.JSONException -> L78
        L5b:
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs r1 = r4.zzg     // Catch: org.json.JSONException -> L78
            java.lang.String r3 = "clientExtensionResults"
            if (r1 == 0) goto L69
            org.json.JSONObject r1 = r1.zza()     // Catch: org.json.JSONException -> L78
            r0.put(r3, r1)     // Catch: org.json.JSONException -> L78
            goto L73
        L69:
            if (r2 == 0) goto L73
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L78
            r1.<init>()     // Catch: org.json.JSONException -> L78
            r0.put(r3, r1)     // Catch: org.json.JSONException -> L78
        L73:
            java.lang.String r0 = r0.toString()
            return r0
        L78:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error encoding PublicKeyCredential to JSON object"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.PublicKeyCredential.toJson():java.lang.String");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getRawId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getClientExtensionResults(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getAuthenticatorAttachment(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
