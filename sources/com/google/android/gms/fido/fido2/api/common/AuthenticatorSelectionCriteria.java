package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

/* loaded from: classes3.dex */
public class AuthenticatorSelectionCriteria extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticatorSelectionCriteria> CREATOR = new zzm();
    private final Attachment zza;
    private final Boolean zzb;
    private final zzay zzc;
    private final ResidentKeyRequirement zzd;

    /* loaded from: classes2.dex */
    public static class Builder {
        private Attachment zza;
        private Boolean zzb;
        private ResidentKeyRequirement zzc;

        public AuthenticatorSelectionCriteria build() {
            Attachment attachment = this.zza;
            String obj = attachment == null ? null : attachment.toString();
            Boolean bool = this.zzb;
            ResidentKeyRequirement residentKeyRequirement = this.zzc;
            return new AuthenticatorSelectionCriteria(obj, bool, null, residentKeyRequirement == null ? null : residentKeyRequirement.toString());
        }

        public Builder setAttachment(Attachment attachment) {
            this.zza = attachment;
            return this;
        }

        public Builder setRequireResidentKey(Boolean bool) {
            this.zzb = bool;
            return this;
        }

        public Builder setResidentKeyRequirement(ResidentKeyRequirement residentKeyRequirement) {
            this.zzc = residentKeyRequirement;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthenticatorSelectionCriteria(String str, Boolean bool, String str2, String str3) {
        Attachment fromString;
        ResidentKeyRequirement residentKeyRequirement = null;
        if (str == null) {
            fromString = null;
        } else {
            try {
                fromString = Attachment.fromString(str);
            } catch (Attachment.UnsupportedAttachmentException | ResidentKeyRequirement.UnsupportedResidentKeyRequirementException | zzax e) {
                throw new IllegalArgumentException(e);
            }
        }
        this.zza = fromString;
        this.zzb = bool;
        this.zzc = str2 == null ? null : zzay.zza(str2);
        if (str3 != null) {
            residentKeyRequirement = ResidentKeyRequirement.fromString(str3);
        }
        this.zzd = residentKeyRequirement;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AuthenticatorSelectionCriteria) {
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
            return Objects.equal(this.zza, authenticatorSelectionCriteria.zza) && Objects.equal(this.zzb, authenticatorSelectionCriteria.zzb) && Objects.equal(this.zzc, authenticatorSelectionCriteria.zzc) && Objects.equal(getResidentKeyRequirement(), authenticatorSelectionCriteria.getResidentKeyRequirement());
        }
        return false;
    }

    public Attachment getAttachment() {
        return this.zza;
    }

    public String getAttachmentAsString() {
        Attachment attachment = this.zza;
        if (attachment == null) {
            return null;
        }
        return attachment.toString();
    }

    public Boolean getRequireResidentKey() {
        return this.zzb;
    }

    public ResidentKeyRequirement getResidentKeyRequirement() {
        ResidentKeyRequirement residentKeyRequirement = this.zzd;
        if (residentKeyRequirement == null) {
            Boolean bool = this.zzb;
            if (bool == null || !bool.booleanValue()) {
                return null;
            }
            return ResidentKeyRequirement.RESIDENT_KEY_REQUIRED;
        }
        return residentKeyRequirement;
    }

    public String getResidentKeyRequirementAsString() {
        if (getResidentKeyRequirement() == null) {
            return null;
        }
        return getResidentKeyRequirement().toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, getResidentKeyRequirement());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAttachmentAsString(), false);
        SafeParcelWriter.writeBooleanObject(parcel, 3, getRequireResidentKey(), false);
        zzay zzayVar = this.zzc;
        SafeParcelWriter.writeString(parcel, 4, zzayVar == null ? null : zzayVar.toString(), false);
        SafeParcelWriter.writeString(parcel, 5, getResidentKeyRequirementAsString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
