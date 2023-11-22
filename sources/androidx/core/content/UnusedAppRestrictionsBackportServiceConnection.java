package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    boolean BuiltInFictitiousFunctionClassFactory;
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    ResolvableFuture<Integer> MyBillsEntityDataFactory;
    IUnusedAppRestrictionsBackportService getAuthRequestContext;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.getAuthRequestContext = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(new IUnusedAppRestrictionsBackportCallback.Stub() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
                @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
                public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException {
                    if (!z) {
                        UnusedAppRestrictionsBackportServiceConnection.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(0);
                        InstrumentInjector.log_e("PackageManagerCompat", "Unable to retrieve the permission revocation setting from the backport");
                    } else if (z2) {
                        UnusedAppRestrictionsBackportServiceConnection.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(3);
                    } else {
                        UnusedAppRestrictionsBackportServiceConnection.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(2);
                    }
                }
            });
        } catch (RemoteException unused) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.getAuthRequestContext = null;
    }
}
