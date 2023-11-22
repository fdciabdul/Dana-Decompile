package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* loaded from: classes7.dex */
public final class zbn {
    private static zbn zbd;
    final Storage zba;
    GoogleSignInAccount zbb;
    GoogleSignInOptions zbc;

    private zbn(Context context) {
        Storage storage = Storage.getInstance(context);
        this.zba = storage;
        this.zbb = storage.getSavedDefaultGoogleSignInAccount();
        this.zbc = storage.getSavedDefaultGoogleSignInOptions();
    }

    public static zbn zbc(Context context) {
        zbn zbf;
        synchronized (zbn.class) {
            zbf = zbf(context.getApplicationContext());
        }
        return zbf;
    }

    private static zbn zbf(Context context) {
        synchronized (zbn.class) {
            zbn zbnVar = zbd;
            if (zbnVar != null) {
                return zbnVar;
            }
            zbn zbnVar2 = new zbn(context);
            zbd = zbnVar2;
            return zbnVar2;
        }
    }

    public final GoogleSignInAccount zba() {
        GoogleSignInAccount googleSignInAccount;
        synchronized (this) {
            googleSignInAccount = this.zbb;
        }
        return googleSignInAccount;
    }

    public final GoogleSignInOptions zbb() {
        GoogleSignInOptions googleSignInOptions;
        synchronized (this) {
            googleSignInOptions = this.zbc;
        }
        return googleSignInOptions;
    }

    public final void zbd() {
        synchronized (this) {
            this.zba.clear();
            this.zbb = null;
            this.zbc = null;
        }
    }

    public final void zbe(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        synchronized (this) {
            this.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
            this.zbb = googleSignInAccount;
            this.zbc = googleSignInOptions;
        }
    }
}
