package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zbf();
    private final PasswordRequestOptions zba;
    private final GoogleIdTokenRequestOptions zbb;
    private final String zbc;
    private final boolean zbd;
    private final int zbe;
    private final PasskeysRequestOptions zbf;
    private final PasskeyJsonRequestOptions zbg;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private PasswordRequestOptions zba;
        private GoogleIdTokenRequestOptions zbb;
        private PasskeysRequestOptions zbc;
        private PasskeyJsonRequestOptions zbd;
        private String zbe;
        private boolean zbf;
        private int zbg;

        public Builder() {
            PasswordRequestOptions.Builder builder = PasswordRequestOptions.builder();
            builder.setSupported(false);
            this.zba = builder.build();
            GoogleIdTokenRequestOptions.Builder builder2 = GoogleIdTokenRequestOptions.builder();
            builder2.setSupported(false);
            this.zbb = builder2.build();
            PasskeysRequestOptions.Builder builder3 = PasskeysRequestOptions.builder();
            builder3.setSupported(false);
            this.zbc = builder3.build();
            PasskeyJsonRequestOptions.Builder builder4 = PasskeyJsonRequestOptions.builder();
            builder4.setSupported(false);
            this.zbd = builder4.build();
        }

        public final BeginSignInRequest build() {
            return new BeginSignInRequest(this.zba, this.zbb, this.zbe, this.zbf, this.zbg, this.zbc, this.zbd);
        }

        public final Builder setAutoSelectEnabled(boolean z) {
            this.zbf = z;
            return this;
        }

        public final Builder setGoogleIdTokenRequestOptions(GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
            return this;
        }

        public final Builder setPasskeyJsonSignInRequestOptions(PasskeyJsonRequestOptions passkeyJsonRequestOptions) {
            this.zbd = (PasskeyJsonRequestOptions) Preconditions.checkNotNull(passkeyJsonRequestOptions);
            return this;
        }

        @Deprecated
        public final Builder setPasskeysSignInRequestOptions(PasskeysRequestOptions passkeysRequestOptions) {
            this.zbc = (PasskeysRequestOptions) Preconditions.checkNotNull(passkeysRequestOptions);
            return this;
        }

        public final Builder setPasswordRequestOptions(PasswordRequestOptions passwordRequestOptions) {
            this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
            return this;
        }

        public final Builder zba(String str) {
            this.zbe = str;
            return this;
        }

        public final Builder zbb(int i) {
            this.zbg = i;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zbl();
        private final boolean zba;
        private final String zbb;
        private final String zbc;
        private final boolean zbd;
        private final String zbe;
        private final List zbf;
        private final boolean zbg;

        /* loaded from: classes3.dex */
        public static final class Builder {
            private boolean zba = false;
            private String zbb = null;
            private String zbc = null;
            private boolean zbd = true;
            private String zbe = null;
            private List zbf = null;
            private boolean zbg = false;

            public final Builder associateLinkedAccounts(String str, List<String> list) {
                this.zbe = (String) Preconditions.checkNotNull(str, "linkedServiceId must be provided if you want to associate linked accounts.");
                this.zbf = list;
                return this;
            }

            public final GoogleIdTokenRequestOptions build() {
                return new GoogleIdTokenRequestOptions(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg);
            }

            public final Builder setFilterByAuthorizedAccounts(boolean z) {
                this.zbd = z;
                return this;
            }

            public final Builder setNonce(String str) {
                this.zbc = str;
                return this;
            }

            @Deprecated
            public final Builder setRequestVerifiedPhoneNumber(boolean z) {
                this.zbg = z;
                return this;
            }

            public final Builder setServerClientId(String str) {
                this.zbb = Preconditions.checkNotEmpty(str);
                return this;
            }

            public final Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public GoogleIdTokenRequestOptions(boolean z, String str, String str2, boolean z2, String str3, List list, boolean z3) {
            boolean z4 = true;
            if (z2 && z3) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.zba = z;
            if (z) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.zbb = str;
            this.zbc = str2;
            this.zbd = z2;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.zbf = arrayList;
            this.zbe = str3;
            this.zbg = z3;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            if (obj instanceof GoogleIdTokenRequestOptions) {
                GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
                return this.zba == googleIdTokenRequestOptions.zba && Objects.equal(this.zbb, googleIdTokenRequestOptions.zbb) && Objects.equal(this.zbc, googleIdTokenRequestOptions.zbc) && this.zbd == googleIdTokenRequestOptions.zbd && Objects.equal(this.zbe, googleIdTokenRequestOptions.zbe) && Objects.equal(this.zbf, googleIdTokenRequestOptions.zbf) && this.zbg == googleIdTokenRequestOptions.zbg;
            }
            return false;
        }

        public final boolean filterByAuthorizedAccounts() {
            return this.zbd;
        }

        public final List<String> getIdTokenDepositionScopes() {
            return this.zbf;
        }

        public final String getLinkedServiceId() {
            return this.zbe;
        }

        public final String getNonce() {
            return this.zbc;
        }

        public final String getServerClientId() {
            return this.zbb;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba), this.zbb, this.zbc, Boolean.valueOf(this.zbd), this.zbe, this.zbf, Boolean.valueOf(this.zbg));
        }

        public final boolean isSupported() {
            return this.zba;
        }

        @Deprecated
        public final boolean requestVerifiedPhoneNumber() {
            return this.zbg;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
            SafeParcelWriter.writeString(parcel, 3, getNonce(), false);
            SafeParcelWriter.writeBoolean(parcel, 4, filterByAuthorizedAccounts());
            SafeParcelWriter.writeString(parcel, 5, getLinkedServiceId(), false);
            SafeParcelWriter.writeStringList(parcel, 6, getIdTokenDepositionScopes(), false);
            SafeParcelWriter.writeBoolean(parcel, 7, requestVerifiedPhoneNumber());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* loaded from: classes2.dex */
    public static final class PasskeyJsonRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasskeyJsonRequestOptions> CREATOR = new zbm();
        private final boolean zba;
        private final String zbb;

        /* loaded from: classes2.dex */
        public static final class Builder {
            private boolean zba = false;
            private String zbb;

            public final PasskeyJsonRequestOptions build() {
                return new PasskeyJsonRequestOptions(this.zba, this.zbb);
            }

            public final Builder setRequestJson(String str) {
                this.zbb = str;
                return this;
            }

            public final Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PasskeyJsonRequestOptions(boolean z, String str) {
            if (z) {
                Preconditions.checkNotNull(str);
            }
            this.zba = z;
            this.zbb = str;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PasskeyJsonRequestOptions) {
                PasskeyJsonRequestOptions passkeyJsonRequestOptions = (PasskeyJsonRequestOptions) obj;
                return this.zba == passkeyJsonRequestOptions.zba && Objects.equal(this.zbb, passkeyJsonRequestOptions.zbb);
            }
            return false;
        }

        public final String getRequestJson() {
            return this.zbb;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba), this.zbb);
        }

        public final boolean isSupported() {
            return this.zba;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getRequestJson(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static final class PasskeysRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasskeysRequestOptions> CREATOR = new zbn();
        private final boolean zba;
        private final byte[] zbb;
        private final String zbc;

        /* loaded from: classes2.dex */
        public static final class Builder {
            private boolean zba = false;
            private byte[] zbb;
            private String zbc;

            public final PasskeysRequestOptions build() {
                return new PasskeysRequestOptions(this.zba, this.zbb, this.zbc);
            }

            public final Builder setChallenge(byte[] bArr) {
                this.zbb = bArr;
                return this;
            }

            public final Builder setRpId(String str) {
                this.zbc = str;
                return this;
            }

            public final Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PasskeysRequestOptions(boolean z, byte[] bArr, String str) {
            if (z) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkNotNull(str);
            }
            this.zba = z;
            this.zbb = bArr;
            this.zbc = str;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            if (this == obj) {
                return true;
            }
            if (obj instanceof PasskeysRequestOptions) {
                PasskeysRequestOptions passkeysRequestOptions = (PasskeysRequestOptions) obj;
                return this.zba == passkeysRequestOptions.zba && Arrays.equals(this.zbb, passkeysRequestOptions.zbb) && ((str = this.zbc) == (str2 = passkeysRequestOptions.zbc) || (str != null && str.equals(str2)));
            }
            return false;
        }

        public final byte[] getChallenge() {
            return this.zbb;
        }

        public final String getRpId() {
            return this.zbc;
        }

        public final int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.zba), this.zbc}) * 31) + Arrays.hashCode(this.zbb);
        }

        public final boolean isSupported() {
            return this.zba;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
            SafeParcelWriter.writeString(parcel, 3, getRpId(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* loaded from: classes3.dex */
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zbo();
        private final boolean zba;

        /* loaded from: classes3.dex */
        public static final class Builder {
            private boolean zba = false;

            public final PasswordRequestOptions build() {
                return new PasswordRequestOptions(this.zba);
            }

            public final Builder setSupported(boolean z) {
                this.zba = z;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PasswordRequestOptions(boolean z) {
            this.zba = z;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.zba == ((PasswordRequestOptions) obj).zba;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba));
        }

        public final boolean isSupported() {
            return this.zba;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z, int i, PasskeysRequestOptions passkeysRequestOptions, PasskeyJsonRequestOptions passkeyJsonRequestOptions) {
        this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.zbc = str;
        this.zbd = z;
        this.zbe = i;
        if (passkeysRequestOptions == null) {
            PasskeysRequestOptions.Builder builder = PasskeysRequestOptions.builder();
            builder.setSupported(false);
            passkeysRequestOptions = builder.build();
        }
        this.zbf = passkeysRequestOptions;
        if (passkeyJsonRequestOptions == null) {
            PasskeyJsonRequestOptions.Builder builder2 = PasskeyJsonRequestOptions.builder();
            builder2.setSupported(false);
            passkeyJsonRequestOptions = builder2.build();
        }
        this.zbg = passkeyJsonRequestOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder builder = builder();
        builder.setGoogleIdTokenRequestOptions(beginSignInRequest.getGoogleIdTokenRequestOptions());
        builder.setPasswordRequestOptions(beginSignInRequest.getPasswordRequestOptions());
        builder.setPasskeysSignInRequestOptions(beginSignInRequest.getPasskeysRequestOptions());
        builder.setPasskeyJsonSignInRequestOptions(beginSignInRequest.getPasskeyJsonRequestOptions());
        builder.setAutoSelectEnabled(beginSignInRequest.zbd);
        builder.zbb(beginSignInRequest.zbe);
        String str = beginSignInRequest.zbc;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BeginSignInRequest) {
            BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
            return Objects.equal(this.zba, beginSignInRequest.zba) && Objects.equal(this.zbb, beginSignInRequest.zbb) && Objects.equal(this.zbf, beginSignInRequest.zbf) && Objects.equal(this.zbg, beginSignInRequest.zbg) && Objects.equal(this.zbc, beginSignInRequest.zbc) && this.zbd == beginSignInRequest.zbd && this.zbe == beginSignInRequest.zbe;
        }
        return false;
    }

    public final GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions() {
        return this.zbb;
    }

    public final PasskeyJsonRequestOptions getPasskeyJsonRequestOptions() {
        return this.zbg;
    }

    public final PasskeysRequestOptions getPasskeysRequestOptions() {
        return this.zbf;
    }

    public final PasswordRequestOptions getPasswordRequestOptions() {
        return this.zba;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbf, this.zbg, this.zbc, Boolean.valueOf(this.zbd));
    }

    public final boolean isAutoSelectEnabled() {
        return this.zbd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPasswordRequestOptions(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getGoogleIdTokenRequestOptions(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isAutoSelectEnabled());
        SafeParcelWriter.writeInt(parcel, 5, this.zbe);
        SafeParcelWriter.writeParcelable(parcel, 6, getPasskeysRequestOptions(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getPasskeyJsonRequestOptions(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
