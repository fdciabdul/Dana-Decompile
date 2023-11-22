package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.common.base.Ascii;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_CHR, 112, -114, 9, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 32;
    private static final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zaa = com.google.android.gms.signin.zad.zac;
    private final Context zab;
    private final Handler zac;
    private final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zad;
    private final Set<Scope> zae;
    private final ClientSettings zaf;
    private com.google.android.gms.signin.zae zag;
    private zacs zah;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = zaa;
        this.zab = context;
        this.zac = handler;
        this.zaf = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zae = clientSettings.getRequiredScopes();
        this.zad = abstractClientBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = 19 - r7
            int r6 = r6 + 105
            byte[] r0 = com.google.android.gms.common.api.internal.zact.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 3
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + 2
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zact.a(int, short, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zad(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        ConnectionResult zaa2 = zakVar.zaa();
        if (zaa2.isSuccess()) {
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zaa3 = zavVar.zaa();
            if (!zaa3.isSuccess()) {
                String valueOf = String.valueOf(zaa3);
                String.valueOf(valueOf).length();
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(valueOf)), new Exception());
                zactVar.zah.zae(zaa3);
                zactVar.zag.disconnect();
                return;
            }
            zactVar.zah.zaf(zavVar.zab(), zactVar.zae);
        } else {
            zactVar.zah.zae(zaa2);
        }
        zactVar.zag.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zag.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zag.disconnect();
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.zac.post(new zacr(this, zakVar));
    }

    public final void zae(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.zag;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        ClientSettings clientSettings = this.zaf;
        try {
            Object[] objArr = {this};
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr3 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr3);
            clientSettings.zae(Integer.valueOf(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = this.zad;
            Context context = this.zab;
            Looper looper = this.zac.getLooper();
            ClientSettings clientSettings2 = this.zaf;
            this.zag = abstractClientBuilder.buildClient(context, looper, clientSettings2, (ClientSettings) clientSettings2.zaa(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
            this.zah = zacsVar;
            Set<Scope> set = this.zae;
            if (set == null || set.isEmpty()) {
                this.zac.post(new zacq(this));
            } else {
                this.zag.zab();
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final void zaf() {
        com.google.android.gms.signin.zae zaeVar = this.zag;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }
}
