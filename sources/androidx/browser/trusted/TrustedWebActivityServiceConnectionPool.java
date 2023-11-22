package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public final class TrustedWebActivityServiceConnectionPool {
    final Map<Uri, ConnectionHolder> PlaceComponentResult;

    /* loaded from: classes6.dex */
    static class BindToServiceAsyncTask extends AsyncTask<Void, Void, Exception> {
        private final Intent BuiltInFictitiousFunctionClassFactory;
        private final ConnectionHolder KClassImpl$Data$declaredNonStaticMembers$2;
        private final Context MyBillsEntityDataFactory;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Exception doInBackground(Void[] voidArr) {
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Exception exc) {
            Exception exc2 = exc;
            if (exc2 != null) {
                ConnectionHolder connectionHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = connectionHolder.MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    it.next().BuiltInFictitiousFunctionClassFactory(exc2);
                }
                connectionHolder.MyBillsEntityDataFactory.clear();
                connectionHolder.getAuthRequestContext.run();
                connectionHolder.BuiltInFictitiousFunctionClassFactory = 3;
                connectionHolder.PlaceComponentResult = exc2;
            }
        }

        private Exception KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                if (this.MyBillsEntityDataFactory.bindService(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, 4097)) {
                    return null;
                }
                this.MyBillsEntityDataFactory.unbindService(this.KClassImpl$Data$declaredNonStaticMembers$2);
                return new IllegalStateException("Could not bind to the service");
            } catch (SecurityException e) {
                InstrumentInjector.log_w("TWAConnectionPool", "SecurityException while binding.", e);
                return e;
            }
        }
    }
}
