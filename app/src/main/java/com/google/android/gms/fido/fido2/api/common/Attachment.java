package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.google.android.gms.fido.fido2.api.common.Attachment;

/* loaded from: classes2.dex */
public enum Attachment implements Parcelable {
    PLATFORM(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM),
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<Attachment> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zza
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return Attachment.fromString(parcel.readString());
            } catch (Attachment.UnsupportedAttachmentException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i) {
            return new Attachment[i];
        }
    };
    private final String zzb;

    /* loaded from: classes3.dex */
    public static class UnsupportedAttachmentException extends Exception {
        public UnsupportedAttachmentException(String str) {
            super(String.format("Attachment %s not supported", str));
        }
    }

    Attachment(String str) {
        this.zzb = str;
    }

    public static Attachment fromString(String str) throws UnsupportedAttachmentException {
        for (Attachment attachment : values()) {
            if (str.equals(attachment.zzb)) {
                return attachment;
            }
        }
        throw new UnsupportedAttachmentException(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzb);
    }
}
