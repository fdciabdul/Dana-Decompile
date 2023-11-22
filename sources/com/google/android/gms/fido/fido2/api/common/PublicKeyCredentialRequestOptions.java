package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class PublicKeyCredentialRequestOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzao();
    private final byte[] zza;
    private final Double zzb;
    private final String zzc;
    private final List zzd;
    private final Integer zze;
    private final TokenBinding zzf;
    private final zzay zzg;
    private final AuthenticationExtensions zzh;
    private final Long zzi;

    /* loaded from: classes7.dex */
    public static final class Builder {
        private byte[] zza;
        private Double zzb;
        private String zzc;
        private List zzd;
        private Integer zze;
        private TokenBinding zzf;
        private zzay zzg;
        private AuthenticationExtensions zzh;

        public Builder() {
        }

        public Builder(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
            if (publicKeyCredentialRequestOptions != null) {
                this.zza = publicKeyCredentialRequestOptions.getChallenge();
                this.zzb = publicKeyCredentialRequestOptions.getTimeoutSeconds();
                this.zzc = publicKeyCredentialRequestOptions.getRpId();
                this.zzd = publicKeyCredentialRequestOptions.getAllowList();
                this.zze = publicKeyCredentialRequestOptions.getRequestId();
                this.zzf = publicKeyCredentialRequestOptions.getTokenBinding();
                this.zzg = publicKeyCredentialRequestOptions.zza();
                this.zzh = publicKeyCredentialRequestOptions.getAuthenticationExtensions();
            }
        }

        public final PublicKeyCredentialRequestOptions build() {
            byte[] bArr = this.zza;
            Double d = this.zzb;
            String str = this.zzc;
            List list = this.zzd;
            Integer num = this.zze;
            TokenBinding tokenBinding = this.zzf;
            zzay zzayVar = this.zzg;
            return new PublicKeyCredentialRequestOptions(bArr, d, str, list, num, tokenBinding, zzayVar == null ? null : zzayVar.toString(), this.zzh, null);
        }

        public final Builder setAllowList(List<PublicKeyCredentialDescriptor> list) {
            this.zzd = list;
            return this;
        }

        public final Builder setAuthenticationExtensions(AuthenticationExtensions authenticationExtensions) {
            this.zzh = authenticationExtensions;
            return this;
        }

        public final Builder setChallenge(byte[] bArr) {
            this.zza = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        public final Builder setRequestId(Integer num) {
            this.zze = num;
            return this;
        }

        public final Builder setRpId(String str) {
            this.zzc = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder setTimeoutSeconds(Double d) {
            this.zzb = d;
            return this;
        }

        public final Builder setTokenBinding(TokenBinding tokenBinding) {
            this.zzf = tokenBinding;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicKeyCredentialRequestOptions(byte[] bArr, Double d, String str, List list, Integer num, TokenBinding tokenBinding, String str2, AuthenticationExtensions authenticationExtensions, Long l) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = d;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = list;
        this.zze = num;
        this.zzf = tokenBinding;
        this.zzi = l;
        if (str2 != null) {
            try {
                this.zzg = zzay.zza(str2);
            } catch (zzax e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = authenticationExtensions;
    }

    public static PublicKeyCredentialRequestOptions deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredentialRequestOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (obj instanceof PublicKeyCredentialRequestOptions) {
            PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
            return Arrays.equals(this.zza, publicKeyCredentialRequestOptions.zza) && Objects.equal(this.zzb, publicKeyCredentialRequestOptions.zzb) && Objects.equal(this.zzc, publicKeyCredentialRequestOptions.zzc) && (((list = this.zzd) == null && publicKeyCredentialRequestOptions.zzd == null) || (list != null && (list2 = publicKeyCredentialRequestOptions.zzd) != null && list.containsAll(list2) && publicKeyCredentialRequestOptions.zzd.containsAll(this.zzd))) && Objects.equal(this.zze, publicKeyCredentialRequestOptions.zze) && Objects.equal(this.zzf, publicKeyCredentialRequestOptions.zzf) && Objects.equal(this.zzg, publicKeyCredentialRequestOptions.zzg) && Objects.equal(this.zzh, publicKeyCredentialRequestOptions.zzh) && Objects.equal(this.zzi, publicKeyCredentialRequestOptions.zzi);
        }
        return false;
    }

    public List<PublicKeyCredentialDescriptor> getAllowList() {
        return this.zzd;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzh;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] getChallenge() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Integer getRequestId() {
        return this.zze;
    }

    public String getRpId() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public TokenBinding getTokenBinding() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeString(parcel, 4, getRpId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getAllowList(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getTokenBinding(), i, false);
        zzay zzayVar = this.zzg;
        SafeParcelWriter.writeString(parcel, 8, zzayVar == null ? null : zzayVar.toString(), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getAuthenticationExtensions(), i, false);
        SafeParcelWriter.writeLongObject(parcel, 10, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzay zza() {
        return this.zzg;
    }
}
