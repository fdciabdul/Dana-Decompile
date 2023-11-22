package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes9.dex */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras = null;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final CursorWindow getWindow(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(1, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        CursorWindow newFromParcel = obtain2.readInt() == 1 ? CursorWindow.newFromParcel(obtain2) : null;
        obtain.recycle();
        obtain2.recycle();
        return newFromParcel;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final void onMove(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(8, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public final int count() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        boolean transact = this.mRemote.transact(2, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        int readInt = !transact ? -1 : obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final String[] getColumnNames() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(3, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        int readInt = obtain2.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            strArr[i] = obtain2.readString();
        }
        obtain.recycle();
        obtain2.recycle();
        return strArr;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final void deactivate() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(6, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public final void close() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(12, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public final int requery(IContentObserver iContentObserver, CursorWindow cursorWindow) throws RemoteException {
        int readInt;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeStrongInterface(iContentObserver);
        cursorWindow.writeToParcel(obtain, 0);
        boolean transact = this.mRemote.transact(7, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (transact) {
            readInt = obtain2.readInt();
            this.mExtras = obtain2.readBundle(getClass().getClassLoader());
        } else {
            readInt = -1;
        }
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final boolean updateRows(Map map) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeMap(map);
        this.mRemote.transact(4, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        boolean z = obtain2.readInt() == 1;
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final boolean deleteRow(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i);
        this.mRemote.transact(5, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        boolean z = obtain2.readInt() == 1;
        obtain.recycle();
        obtain2.recycle();
        return z;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(9, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        return readInt != 0;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final Bundle getExtras() throws RemoteException {
        if (this.mExtras == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(10, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            this.mExtras = obtain2.readBundle(getClass().getClassLoader());
            obtain.recycle();
            obtain2.recycle();
        }
        return this.mExtras;
    }

    @Override // net.sqlcipher.IBulkCursor
    public final Bundle respond(Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeBundle(bundle);
        this.mRemote.transact(11, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        Bundle readBundle = obtain2.readBundle(getClass().getClassLoader());
        obtain.recycle();
        obtain2.recycle();
        return readBundle;
    }
}
