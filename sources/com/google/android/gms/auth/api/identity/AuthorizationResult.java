package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* loaded from: classes7.dex */
public final class AuthorizationResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthorizationResult> CREATOR = new zbe();
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final List zbd;
    private final GoogleSignInAccount zbe;
    private final PendingIntent zbf;

    public AuthorizationResult(String str, String str2, String str3, List<String> list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = (List) Preconditions.checkNotNull(list);
        this.zbf = pendingIntent;
        this.zbe = googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AuthorizationResult) {
            AuthorizationResult authorizationResult = (AuthorizationResult) obj;
            return Objects.equal(this.zba, authorizationResult.zba) && Objects.equal(this.zbb, authorizationResult.zbb) && Objects.equal(this.zbc, authorizationResult.zbc) && Objects.equal(this.zbd, authorizationResult.zbd) && Objects.equal(this.zbf, authorizationResult.zbf) && Objects.equal(this.zbe, authorizationResult.zbe);
        }
        return false;
    }

    public final String getAccessToken() {
        return this.zbb;
    }

    public final List<String> getGrantedScopes() {
        return this.zbd;
    }

    public final PendingIntent getPendingIntent() {
        return this.zbf;
    }

    public final String getServerAuthCode() {
        return this.zba;
    }

    public final boolean hasResolution() {
        return this.zbf != null;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbd, this.zbf, this.zbe);
    }

    public final GoogleSignInAccount toGoogleSignInAccount() {
        return this.zbe;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getServerAuthCode(), false);
        SafeParcelWriter.writeString(parcel, 2, getAccessToken(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeStringList(parcel, 4, getGrantedScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, toGoogleSignInAccount(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPendingIntent(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
