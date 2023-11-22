package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
class ConnectionHolder implements ServiceConnection {
    int BuiltInFictitiousFunctionClassFactory;
    private TrustedWebActivityServiceConnection KClassImpl$Data$declaredNonStaticMembers$2;
    List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> MyBillsEntityDataFactory;
    Exception PlaceComponentResult;
    final Runnable getAuthRequestContext;
    private final WrapperFactory lookAheadTest;

    /* loaded from: classes6.dex */
    static class WrapperFactory {
        WrapperFactory() {
        }

        static TrustedWebActivityServiceConnection KClassImpl$Data$declaredNonStaticMembers$2(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.asInterface(iBinder), componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = WrapperFactory.KClassImpl$Data$declaredNonStaticMembers$2(componentName, iBinder);
        Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        this.MyBillsEntityDataFactory.clear();
        this.BuiltInFictitiousFunctionClassFactory = 1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.run();
        this.BuiltInFictitiousFunctionClassFactory = 2;
    }
}
