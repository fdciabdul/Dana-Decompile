package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes3.dex */
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zbr();
    private final SignInPassword zba;
    private final String zbb;
    private final int zbc;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private SignInPassword zba;
        private String zbb;
        private int zbc;

        public final SavePasswordRequest build() {
            return new SavePasswordRequest(this.zba, this.zbb, this.zbc);
        }

        public final Builder setSignInPassword(SignInPassword signInPassword) {
            this.zba = signInPassword;
            return this;
        }

        public final Builder zba(String str) {
            this.zbb = str;
            return this;
        }

        public final Builder zbb(int i) {
            this.zbc = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavePasswordRequest(SignInPassword signInPassword, String str, int i) {
        this.zba = (SignInPassword) Preconditions.checkNotNull(signInPassword);
        this.zbb = str;
        this.zbc = i;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        Builder builder = builder();
        builder.setSignInPassword(savePasswordRequest.getSignInPassword());
        builder.zbb(savePasswordRequest.zbc);
        String str = savePasswordRequest.zbb;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SavePasswordRequest) {
            SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
            return Objects.equal(this.zba, savePasswordRequest.zba) && Objects.equal(this.zbb, savePasswordRequest.zbb) && this.zbc == savePasswordRequest.zbc;
        }
        return false;
    }

    public SignInPassword getSignInPassword() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSignInPassword(), i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zbc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
