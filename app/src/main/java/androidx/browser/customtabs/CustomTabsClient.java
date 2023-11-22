package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class CustomTabsClient {
    private final ComponentName BuiltInFictitiousFunctionClassFactory;
    private final ICustomTabsService KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = iCustomTabsService;
        this.BuiltInFictitiousFunctionClassFactory = componentName;
        this.MyBillsEntityDataFactory = context;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends CustomTabsServiceConnection {
        final /* synthetic */ Context MyBillsEntityDataFactory;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            customTabsClient.BuiltInFictitiousFunctionClassFactory();
            this.MyBillsEntityDataFactory.unbindService(this);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        try {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.warmup(0L);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 extends ICustomTabsCallback.Stub {
        private Handler KClassImpl$Data$declaredNonStaticMembers$2 = new Handler(Looper.getMainLooper());
        final /* synthetic */ CustomTabsCallback val$callback;

        AnonymousClass2(CustomTabsCallback customTabsCallback) {
            this.val$callback = customTabsCallback;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(final int i, final Bundle bundle) {
            if (this.val$callback == null) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.val$callback.MyBillsEntityDataFactory(i, bundle);
                }
            });
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.val$callback.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
                }
            });
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
            CustomTabsCallback customTabsCallback = this.val$callback;
            if (customTabsCallback == null) {
                return null;
            }
            return customTabsCallback.PlaceComponentResult(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.val$callback.PlaceComponentResult(bundle);
                }
            });
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.val$callback.getAuthRequestContext(str, bundle);
                }
            });
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(final int i, final Uri uri, final boolean z, final Bundle bundle) throws RemoteException {
            if (this.val$callback == null) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.val$callback.getAuthRequestContext(i, uri, z, bundle);
                }
            });
        }
    }
}
