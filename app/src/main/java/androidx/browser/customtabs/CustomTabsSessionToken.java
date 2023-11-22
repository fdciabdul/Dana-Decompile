package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class CustomTabsSessionToken {
    private final PendingIntent BuiltInFictitiousFunctionClassFactory;
    private final CustomTabsCallback MyBillsEntityDataFactory;
    final ICustomTabsCallback PlaceComponentResult;

    /* loaded from: classes6.dex */
    static class MockCallback extends ICustomTabsCallback.Stub {
        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }

        MockCallback() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.PlaceComponentResult = iCustomTabsCallback;
        this.BuiltInFictitiousFunctionClassFactory = pendingIntent;
        this.MyBillsEntityDataFactory = iCustomTabsCallback == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void MyBillsEntityDataFactory(int i, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.PlaceComponentResult.onNavigationEvent(i, bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.PlaceComponentResult.extraCallback(str, bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final Bundle PlaceComponentResult(String str, Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.PlaceComponentResult.extraCallbackWithResult(str, bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void PlaceComponentResult(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.PlaceComponentResult.onMessageChannelReady(bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void getAuthRequestContext(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.PlaceComponentResult.onPostMessage(str, bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public final void getAuthRequestContext(int i, Uri uri, boolean z, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.PlaceComponentResult.onRelationshipValidationResult(i, uri, z, bundle);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.BuiltInFictitiousFunctionClassFactory;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        ICustomTabsCallback iCustomTabsCallback = this.PlaceComponentResult;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder().hashCode();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public boolean equals(Object obj) {
        if (obj instanceof CustomTabsSessionToken) {
            CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
            PendingIntent pendingIntent = customTabsSessionToken.BuiltInFictitiousFunctionClassFactory;
            PendingIntent pendingIntent2 = this.BuiltInFictitiousFunctionClassFactory;
            if ((pendingIntent2 == null) != (pendingIntent == null)) {
                return false;
            }
            if (pendingIntent2 != null) {
                return pendingIntent2.equals(pendingIntent);
            }
            ICustomTabsCallback iCustomTabsCallback = this.PlaceComponentResult;
            if (iCustomTabsCallback == null) {
                throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
            }
            IBinder asBinder = iCustomTabsCallback.asBinder();
            ICustomTabsCallback iCustomTabsCallback2 = customTabsSessionToken.PlaceComponentResult;
            if (iCustomTabsCallback2 != null) {
                return asBinder.equals(iCustomTabsCallback2.asBinder());
            }
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        return false;
    }
}
