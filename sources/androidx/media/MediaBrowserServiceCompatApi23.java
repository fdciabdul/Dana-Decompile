package androidx.media;

import android.content.Context;
import android.content.res.Resources;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompatApi21;

/* loaded from: classes6.dex */
class MediaBrowserServiceCompatApi23 {

    /* loaded from: classes6.dex */
    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void BuiltInFictitiousFunctionClassFactory(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper);
    }

    public static Object BuiltInFictitiousFunctionClassFactory(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    /* loaded from: classes6.dex */
    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        @Override // androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(context);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.service.media.MediaBrowserService, android.app.Service
        public void onCreate() {
            super.onCreate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((ServiceCompatProxy) this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory(str, new MediaBrowserServiceCompatApi21.ResultWrapper<>(result));
        }
    }

    private MediaBrowserServiceCompatApi23() {
    }
}
