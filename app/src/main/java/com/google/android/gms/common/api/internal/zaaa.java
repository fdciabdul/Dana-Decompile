package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.common.base.Ascii;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zaaa implements zaca {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, 93, -14, -126, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 66;
    private final Context zaa;
    private final zabe zab;
    private final Looper zac;
    private final zabi zad;
    private final zabi zae;
    private final Map<Api.AnyClientKey<?>, zabi> zaf;
    private final Api.Client zah;
    private Bundle zai;
    private final Lock zam;
    private final Set<SignInConnectionListener> zag = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult zaj = null;
    private ConnectionResult zak = null;
    private boolean zal = false;
    private int zan = 0;

    private zaaa(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zat> arrayList, ArrayList<zat> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.zaa = context;
        this.zab = zabeVar;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        this.zad = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zax(this, null));
        this.zae = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this, null));
        ArrayMap arrayMap = new ArrayMap();
        Iterator<Api.AnyClientKey<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put(it.next(), this.zad);
        }
        Iterator<Api.AnyClientKey<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put(it2.next(), this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap);
    }

    private static void a(byte b, int i, int i2, Object[] objArr) {
        int i3 = 18 - (i * 15);
        int i4 = 106 - i2;
        int i5 = 16 - (b * 2);
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i4 = i7 + i3 + 2;
            i7 = i7;
            i3 = i3;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i4;
            int i8 = i3 + 1;
            if (i6 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i4 = i4 + bArr[i8] + 2;
            i7 = i7;
            i3 = i8;
        }
    }

    private final void zaB() {
        Iterator<SignInConnectionListener> it = this.zag.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.zag.clear();
    }

    private final boolean zaC() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean zaD(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        zabi zabiVar = this.zaf.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        return zabiVar.equals(this.zae);
    }

    private static boolean zaE(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static zaaa zag(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder, ArrayList<zat> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (true == value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> zab = api.zab();
            if (arrayMap.containsKey(zab)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(zab)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zat zatVar = arrayList.get(i);
            if (arrayMap3.containsKey(zatVar.zaa)) {
                arrayList2.add(zatVar);
            } else if (arrayMap4.containsKey(zatVar.zaa)) {
                arrayList3.add(zatVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaaa(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zan(zaaa zaaaVar, int i, boolean z) {
        zaaaVar.zab.zac(i, z);
        zaaaVar.zak = null;
        zaaaVar.zaj = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zao(zaaa zaaaVar, Bundle bundle) {
        Bundle bundle2 = zaaaVar.zai;
        if (bundle2 == null) {
            zaaaVar.zai = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zap(zaaa zaaaVar) {
        ConnectionResult connectionResult;
        if (zaE(zaaaVar.zaj)) {
            if (zaE(zaaaVar.zak) || zaaaVar.zaC()) {
                int i = zaaaVar.zan;
                if (i != 1) {
                    if (i == 2) {
                        ((zabe) Preconditions.checkNotNull(zaaaVar.zab)).zab(zaaaVar.zai);
                    } else {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        zaaaVar.zan = 0;
                        return;
                    }
                }
                zaaaVar.zaB();
                zaaaVar.zan = 0;
                return;
            }
            ConnectionResult connectionResult2 = zaaaVar.zak;
            if (connectionResult2 != null) {
                if (zaaaVar.zan == 1) {
                    zaaaVar.zaB();
                    return;
                }
                zaaaVar.zaA(connectionResult2);
                zaaaVar.zad.zar();
            }
        } else if (zaaaVar.zaj == null || !zaE(zaaaVar.zak)) {
            ConnectionResult connectionResult3 = zaaaVar.zaj;
            if (connectionResult3 == null || (connectionResult = zaaaVar.zak) == null) {
                return;
            }
            if (zaaaVar.zae.zaf < zaaaVar.zad.zaf) {
                connectionResult3 = connectionResult;
            }
            zaaaVar.zaA(connectionResult3);
        } else {
            zaaaVar.zae.zar();
            zaaaVar.zaA((ConnectionResult) Preconditions.checkNotNull(zaaaVar.zaj));
        }
    }

    private final PendingIntent zaz() {
        if (this.zah == null) {
            return null;
        }
        Context context = this.zaa;
        try {
            Object[] objArr = {this.zab};
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            return com.google.android.gms.internal.base.zal.zaa(context, ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue(), this.zah.getSignInIntent(), com.google.android.gms.internal.base.zal.zaa | 134217728);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zad(Api<?> api) {
        if (Objects.equal(this.zaf.get(api.zab()), this.zae)) {
            if (zaC()) {
                return new ConnectionResult(4, zaz());
            }
            return this.zae.zad(api);
        }
        return this.zad.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zae(T t) {
        if (zaD(t)) {
            if (zaC()) {
                t.setFailedResult(new Status(4, (String) null, zaz()));
                return t;
            }
            this.zae.zae(t);
            return t;
        }
        this.zad.zae(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaf(T t) {
        if (zaD(t)) {
            if (zaC()) {
                t.setFailedResult(new Status(4, (String) null, zaz()));
                return t;
            }
            return (T) this.zae.zaf(t);
        }
        return (T) this.zad.zaf(t);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zaq() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zaq();
        this.zae.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zar() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zar();
        this.zae.zar();
        zaB();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zae.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zad.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zat() {
        this.zad.zat();
        this.zae.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        this.zam.lock();
        try {
            boolean zax = zax();
            this.zae.zar();
            this.zak = new ConnectionResult(4);
            if (zax) {
                new com.google.android.gms.internal.base.zaq(this.zac).post(new zav(this));
            } else {
                zaB();
            }
        } finally {
            this.zam.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r3.zan == 1) goto L11;
     */
    @Override // com.google.android.gms.common.api.internal.zaca
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zaw() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.zam
            r0.lock()
            com.google.android.gms.common.api.internal.zabi r0 = r3.zad     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.zaw()     // Catch: java.lang.Throwable -> L28
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L22
            com.google.android.gms.common.api.internal.zabi r0 = r3.zae     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.zaw()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L21
            boolean r0 = r3.zaC()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L21
            int r0 = r3.zan     // Catch: java.lang.Throwable -> L28
            if (r0 != r2) goto L22
        L21:
            r1 = 1
        L22:
            java.util.concurrent.locks.Lock r0 = r3.zam
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.zam
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaa.zaw():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        this.zam.lock();
        try {
            return this.zan == 2;
        } finally {
            this.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            if ((!zax() && !zaw()) || this.zae.zaw()) {
                this.zam.unlock();
                return false;
            }
            this.zag.add(signInConnectionListener);
            if (this.zan == 0) {
                this.zan = 1;
            }
            this.zak = null;
            this.zae.zaq();
            return true;
        } finally {
            this.zam.unlock();
        }
    }

    private final void zaA(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i != 1) {
            if (i == 2) {
                this.zab.zaa(connectionResult);
            } else {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zan = 0;
            }
        }
        zaB();
        this.zan = 0;
    }
}
