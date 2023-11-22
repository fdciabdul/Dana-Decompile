package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi23;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MediaSessionCompatApi24 {

    /* loaded from: classes6.dex */
    public interface Callback extends MediaSessionCompatApi23.Callback {
        void MyBillsEntityDataFactory(String str, Bundle bundle);

        void PlaceComponentResult(Uri uri, Bundle bundle);

        void getAuthRequestContext(String str, Bundle bundle);

        void scheduleImpl();
    }

    public static Object MyBillsEntityDataFactory(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static String MyBillsEntityDataFactory(Object obj) {
        MediaSession mediaSession = (MediaSession) obj;
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            InstrumentInjector.log_e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.getAuthRequestContext).scheduleImpl();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((Callback) this.getAuthRequestContext).MyBillsEntityDataFactory(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((Callback) this.getAuthRequestContext).getAuthRequestContext(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((Callback) this.getAuthRequestContext).PlaceComponentResult(uri, bundle);
        }
    }

    private MediaSessionCompatApi24() {
    }
}
