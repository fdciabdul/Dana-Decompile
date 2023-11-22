package com.xiaomi.channel.commonutils.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
final class d {

    /* loaded from: classes8.dex */
    static final class a {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        final String getAuthRequestContext;

        a(String str, boolean z) {
            this.getAuthRequestContext = str;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        public final boolean getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes8.dex */
    static final class b implements ServiceConnection {
        final LinkedBlockingQueue<IBinder> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean getAuthRequestContext;

        private b() {
            this.getAuthRequestContext = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes8.dex */
    static final class c implements IInterface {
        private IBinder PlaceComponentResult;

        public c(IBinder iBinder) {
            this.PlaceComponentResult = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.PlaceComponentResult.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.PlaceComponentResult.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.PlaceComponentResult;
        }
    }

    public static a BuiltInFictitiousFunctionClassFactory(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                byte b2 = 0;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                b bVar = new b(b2);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (context.bindService(intent, bVar, 1)) {
                        try {
                            if (bVar.getAuthRequestContext) {
                                throw new IllegalStateException();
                            }
                            bVar.getAuthRequestContext = true;
                            IBinder poll = bVar.KClassImpl$Data$declaredNonStaticMembers$2.poll(30000L, TimeUnit.MILLISECONDS);
                            if (poll != null) {
                                c cVar = new c(poll);
                                return new a(cVar.a(), cVar.a(true));
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    throw new IOException("Google Play connection failed");
                } finally {
                    context.unbindService(bVar);
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }
}
