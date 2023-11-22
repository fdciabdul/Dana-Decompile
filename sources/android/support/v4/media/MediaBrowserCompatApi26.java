package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* loaded from: classes6.dex */
class MediaBrowserCompatApi26 {

    /* loaded from: classes6.dex */
    interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle);

        void PlaceComponentResult(String str, List<?> list, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object MyBillsEntityDataFactory(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    /* loaded from: classes6.dex */
    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        SubscriptionCallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((SubscriptionCallback) this.getAuthRequestContext).PlaceComponentResult(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((SubscriptionCallback) this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
        }
    }

    private MediaBrowserCompatApi26() {
    }
}
