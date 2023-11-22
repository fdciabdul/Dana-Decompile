package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: classes6.dex */
class MediaSessionCompatApi21 {

    /* loaded from: classes6.dex */
    interface Callback {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(long j);

        void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(Object obj);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle, ResultReceiver resultReceiver);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String str, Bundle bundle);

        boolean PlaceComponentResult(Intent intent);

        void getAuthRequestContext();

        void getAuthRequestContext(long j);

        void getErrorConfigVersion();

        void lookAheadTest();
    }

    public static Object getAuthRequestContext(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object BuiltInFictitiousFunctionClassFactory(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* loaded from: classes6.dex */
    static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
        protected final T getAuthRequestContext;

        public CallbackProxy(T t) {
            this.getAuthRequestContext = t;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.getAuthRequestContext.PlaceComponentResult(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.getAuthRequestContext.PlaceComponentResult(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            this.getAuthRequestContext.getAuthRequestContext(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.getAuthRequestContext.getAuthRequestContext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.getAuthRequestContext.MyBillsEntityDataFactory();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.getAuthRequestContext.lookAheadTest();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.getAuthRequestContext.PlaceComponentResult();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.getAuthRequestContext.getErrorConfigVersion();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(str, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class QueueItem {
        public static long PlaceComponentResult(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }

        private QueueItem() {
        }
    }

    private MediaSessionCompatApi21() {
    }
}
