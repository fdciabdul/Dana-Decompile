package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes6.dex */
class MediaBrowserCompatApi21 {

    /* loaded from: classes6.dex */
    interface ConnectionCallback {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    interface SubscriptionCallback {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, List<?> list);

        void getAuthRequestContext(String str);
    }

    public static Object BuiltInFictitiousFunctionClassFactory(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    public static Object getAuthRequestContext(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static void MyBillsEntityDataFactory(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static void BuiltInFictitiousFunctionClassFactory(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle getAuthRequestContext(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object PlaceComponentResult(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static Object PlaceComponentResult(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    /* loaded from: classes6.dex */
    static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T BuiltInFictitiousFunctionClassFactory;

        public ConnectionCallbackProxy(T t) {
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }
    }

    /* loaded from: classes6.dex */
    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T getAuthRequestContext;

        public SubscriptionCallbackProxy(T t) {
            this.getAuthRequestContext = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.getAuthRequestContext.getAuthRequestContext(str);
        }
    }

    /* loaded from: classes6.dex */
    static class MediaItem {
        public static int BuiltInFictitiousFunctionClassFactory(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        public static Object getAuthRequestContext(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        private MediaItem() {
        }
    }

    private MediaBrowserCompatApi21() {
    }
}
