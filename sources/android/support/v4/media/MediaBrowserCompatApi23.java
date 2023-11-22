package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* loaded from: classes6.dex */
class MediaBrowserCompatApi23 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface ItemCallback {
        void KClassImpl$Data$declaredNonStaticMembers$2(Parcel parcel);

        void getAuthRequestContext(String str);
    }

    public static Object KClassImpl$Data$declaredNonStaticMembers$2(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T BuiltInFictitiousFunctionClassFactory;

        public ItemCallbackProxy(T t) {
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(obtain);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(str);
        }
    }

    private MediaBrowserCompatApi23() {
    }
}
