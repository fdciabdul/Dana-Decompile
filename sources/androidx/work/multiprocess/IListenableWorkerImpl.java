package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/* loaded from: classes6.dex */
public interface IListenableWorkerImpl extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements IListenableWorkerImpl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }

    void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "androidx.work.multiprocess.IListenableWorkerImpl");
        }

        public static IListenableWorkerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.work.multiprocess.IListenableWorkerImpl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IListenableWorkerImpl)) {
                return (IListenableWorkerImpl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("androidx.work.multiprocess.IListenableWorkerImpl");
                startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("androidx.work.multiprocess.IListenableWorkerImpl");
                interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("androidx.work.multiprocess.IListenableWorkerImpl");
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class Proxy implements IListenableWorkerImpl {
            public static IListenableWorkerImpl sDefaultImpl;
            private IBinder getAuthRequestContext;

            public String getInterfaceDescriptor() {
                return "androidx.work.multiprocess.IListenableWorkerImpl";
            }

            Proxy(IBinder iBinder) {
                this.getAuthRequestContext = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.getAuthRequestContext;
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null);
                    if (this.getAuthRequestContext.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().startWork(bArr, iWorkManagerImplCallback);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(iWorkManagerImplCallback != null ? iWorkManagerImplCallback.asBinder() : null);
                    if (this.getAuthRequestContext.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().interrupt(bArr, iWorkManagerImplCallback);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IListenableWorkerImpl iListenableWorkerImpl) {
            if (Proxy.sDefaultImpl == null) {
                if (iListenableWorkerImpl != null) {
                    Proxy.sDefaultImpl = iListenableWorkerImpl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IListenableWorkerImpl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
