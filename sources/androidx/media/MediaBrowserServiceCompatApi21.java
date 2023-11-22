package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class MediaBrowserServiceCompatApi21 {

    /* loaded from: classes6.dex */
    public interface ServiceCompatProxy {
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, ResultWrapper<List<Parcel>> resultWrapper);

        BrowserRoot getAuthRequestContext(String str, int i, Bundle bundle);
    }

    public static Object MyBillsEntityDataFactory(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void PlaceComponentResult(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static IBinder PlaceComponentResult(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void getAuthRequestContext(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }

    public static void PlaceComponentResult(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    /* loaded from: classes6.dex */
    static class ResultWrapper<T> {
        MediaBrowserService.Result KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ResultWrapper(MediaBrowserService.Result result) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void KClassImpl$Data$declaredNonStaticMembers$2(T t) {
            if (t instanceof List) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.sendResult(KClassImpl$Data$declaredNonStaticMembers$2((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.KClassImpl$Data$declaredNonStaticMembers$2.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.sendResult(null);
            }
        }

        List<MediaBrowser.MediaItem> KClassImpl$Data$declaredNonStaticMembers$2(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    /* loaded from: classes6.dex */
    static class BrowserRoot {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final Bundle getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BrowserRoot(String str, Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = bundle;
        }
    }

    /* loaded from: classes6.dex */
    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // android.service.media.MediaBrowserService, android.app.Service
        public void onCreate() {
            super.onCreate();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = serviceCompatProxy;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            BrowserRoot authRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(str, i, bundle == null ? null : new Bundle(bundle));
            if (authRequestContext == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.getAuthRequestContext);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str, new ResultWrapper<>(result));
        }
    }

    private MediaBrowserServiceCompatApi21() {
    }
}
