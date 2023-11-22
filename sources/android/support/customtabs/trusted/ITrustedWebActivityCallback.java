package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes6.dex */
public interface ITrustedWebActivityCallback extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements ITrustedWebActivityCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        }
    }

    void onExtraCallback(String str, Bundle bundle) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
        static final int TRANSACTION_onExtraCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityCallback");
        }

        public static ITrustedWebActivityCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITrustedWebActivityCallback)) {
                return (ITrustedWebActivityCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            onExtraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class Proxy implements ITrustedWebActivityCallback {
            public static ITrustedWebActivityCallback sDefaultImpl;
            private IBinder MyBillsEntityDataFactory;

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityCallback";
            }

            Proxy(IBinder iBinder) {
                this.MyBillsEntityDataFactory = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.MyBillsEntityDataFactory;
            }

            @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.MyBillsEntityDataFactory.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onExtraCallback(str, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (iTrustedWebActivityCallback != null) {
                    Proxy.sDefaultImpl = iTrustedWebActivityCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ITrustedWebActivityCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
