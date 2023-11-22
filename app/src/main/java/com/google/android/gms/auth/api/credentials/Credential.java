package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.Nonnull;

@Deprecated
/* loaded from: classes2.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zba();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @Nonnull
    private final String zba;
    private final String zbb;
    private final Uri zbc;
    @Nonnull
    private final List zbd;
    private final String zbe;
    private final String zbf;
    private final String zbg;
    private final String zbh;

    @Deprecated
    /* loaded from: classes2.dex */
    public static class Builder {
        private final String zba;
        private String zbb;
        private Uri zbc;
        private List zbd;
        private String zbe;
        private String zbf;
        private String zbg;
        private String zbh;

        public Builder(Credential credential) {
            this.zba = credential.zba;
            this.zbb = credential.zbb;
            this.zbc = credential.zbc;
            this.zbd = credential.zbd;
            this.zbe = credential.zbe;
            this.zbf = credential.zbf;
            this.zbg = credential.zbg;
            this.zbh = credential.zbh;
        }

        public Builder(String str) {
            this.zba = str;
        }

        public Credential build() {
            return new Credential(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
        }

        public Builder setAccountType(String str) {
            this.zbf = str;
            return this;
        }

        public Builder setName(String str) {
            this.zbb = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zbe = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zbc = uri;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Credential(java.lang.String r5, java.lang.String r6, android.net.Uri r7, java.util.List r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = "credential identifier cannot be null"
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r0)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = r5.trim()
            java.lang.String r0 = "credential identifier cannot be empty"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5, r0)
            if (r9 == 0) goto L25
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L1d
            goto L25
        L1d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Password must not be empty if set"
            r5.<init>(r6)
            throw r5
        L25:
            if (r10 == 0) goto L81
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 != 0) goto L70
            android.net.Uri r0 = android.net.Uri.parse(r10)
            boolean r2 = r0.isAbsolute()
            if (r2 == 0) goto L70
            boolean r2 = r0.isHierarchical()
            if (r2 == 0) goto L70
            java.lang.String r2 = r0.getScheme()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L70
            java.lang.String r2 = r0.getAuthority()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L70
            java.lang.String r2 = r0.getScheme()
            java.lang.String r3 = "http"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 != 0) goto L6a
            java.lang.String r0 = r0.getScheme()
            java.lang.String r2 = "https"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L6b
        L6a:
            r1 = 1
        L6b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            goto L72
        L70:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L72:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L79
            goto L81
        L79:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Account type must be a valid Http/Https URI"
            r5.<init>(r6)
            throw r5
        L81:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L96
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L8e
            goto L96
        L8e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Password and AccountType are mutually exclusive"
            r5.<init>(r6)
            throw r5
        L96:
            if (r6 == 0) goto La3
            java.lang.String r0 = r6.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La3
            r6 = 0
        La3:
            r4.zbb = r6
            r4.zbc = r7
            if (r8 != 0) goto Lae
            java.util.List r6 = java.util.Collections.emptyList()
            goto Lb2
        Lae:
            java.util.List r6 = java.util.Collections.unmodifiableList(r8)
        Lb2:
            r4.zbd = r6
            r4.zba = r5
            r4.zbe = r9
            r4.zbf = r10
            r4.zbg = r11
            r4.zbh = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Credential) {
            Credential credential = (Credential) obj;
            return TextUtils.equals(this.zba, credential.zba) && TextUtils.equals(this.zbb, credential.zbb) && Objects.equal(this.zbc, credential.zbc) && TextUtils.equals(this.zbe, credential.zbe) && TextUtils.equals(this.zbf, credential.zbf);
        }
        return false;
    }

    public String getAccountType() {
        return this.zbf;
    }

    public String getFamilyName() {
        return this.zbh;
    }

    public String getGivenName() {
        return this.zbg;
    }

    @Nonnull
    public String getId() {
        return this.zba;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zbd;
    }

    public String getName() {
        return this.zbb;
    }

    public String getPassword() {
        return this.zbe;
    }

    public Uri getProfilePictureUri() {
        return this.zbc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbe, this.zbf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
