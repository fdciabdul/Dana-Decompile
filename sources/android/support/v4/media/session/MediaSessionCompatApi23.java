package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi21;

/* loaded from: classes6.dex */
class MediaSessionCompatApi23 {

    /* loaded from: classes6.dex */
    public interface Callback extends MediaSessionCompatApi21.Callback {
        void KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Bundle bundle);
    }

    public static Object MyBillsEntityDataFactory(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((Callback) this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(uri, bundle);
        }
    }

    private MediaSessionCompatApi23() {
    }
}
