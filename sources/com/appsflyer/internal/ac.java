package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
/* loaded from: classes.dex */
final class ac {
    ac() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c AFInAppEventParameterName(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        a aVar = new a((byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, aVar, 1)) {
                if (context != null) {
                    context.unbindService(aVar);
                }
                throw new IOException("Google Play connection failed");
            } else if (aVar.values) {
                throw new IllegalStateException("Cannot call get on this connection more than once");
            } else {
                aVar.values = true;
                IBinder poll = aVar.AFInAppEventType.poll(10L, TimeUnit.SECONDS);
                if (poll != null) {
                    b bVar = new b(poll);
                    return new c(bVar.AFKeystoreWrapper(), bVar.values());
                }
                throw new TimeoutException("Timed out waiting for the service connection");
            }
        } finally {
            if (context != null) {
                context.unbindService(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class c {
        private final boolean AFKeystoreWrapper;
        final String valueOf;

        c(String str, boolean z) {
            this.valueOf = str;
            this.AFKeystoreWrapper = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean AFInAppEventParameterName() {
            return this.AFKeystoreWrapper;
        }
    }

    /* loaded from: classes.dex */
    static final class a implements ServiceConnection {
        final LinkedBlockingQueue<IBinder> AFInAppEventType;
        boolean values;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.AFInAppEventType = new LinkedBlockingQueue<>(1);
            this.values = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.AFInAppEventType.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    static final class b implements IInterface {
        private final IBinder AFKeystoreWrapper;

        b(IBinder iBinder) {
            this.AFKeystoreWrapper = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.AFKeystoreWrapper;
        }

        public final String AFKeystoreWrapper() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.AFKeystoreWrapper.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        final boolean values() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.AFKeystoreWrapper.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
