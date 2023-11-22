package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/* loaded from: classes6.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };
    IResultReceiver PlaceComponentResult;
    final boolean getAuthRequestContext = false;
    final Handler BuiltInFictitiousFunctionClassFactory = null;

    protected void PlaceComponentResult(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes6.dex */
    class MyRunnable implements Runnable {
        final int PlaceComponentResult;
        final Bundle getAuthRequestContext;

        MyRunnable(int i, Bundle bundle) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.PlaceComponentResult(this.PlaceComponentResult, this.getAuthRequestContext);
        }
    }

    /* loaded from: classes6.dex */
    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i, Bundle bundle) {
            if (ResultReceiver.this.BuiltInFictitiousFunctionClassFactory != null) {
                ResultReceiver.this.BuiltInFictitiousFunctionClassFactory.post(new MyRunnable(i, bundle));
            } else {
                ResultReceiver.this.PlaceComponentResult(i, bundle);
            }
        }
    }

    public void BuiltInFictitiousFunctionClassFactory(int i, Bundle bundle) {
        if (this.getAuthRequestContext) {
            Handler handler = this.BuiltInFictitiousFunctionClassFactory;
            if (handler != null) {
                handler.post(new MyRunnable(i, bundle));
                return;
            } else {
                PlaceComponentResult(i, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.PlaceComponentResult;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.send(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new MyResultReceiver();
            }
            parcel.writeStrongBinder(this.PlaceComponentResult.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.PlaceComponentResult = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
}
