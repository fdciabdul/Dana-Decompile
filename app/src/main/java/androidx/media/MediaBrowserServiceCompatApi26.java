package androidx.media;

import android.content.Context;
import android.content.res.Resources;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompatApi23;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class MediaBrowserServiceCompatApi26 {
    static Field KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes6.dex */
    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void PlaceComponentResult(String str, ResultWrapper resultWrapper, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            KClassImpl$Data$declaredNonStaticMembers$2 = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            InstrumentInjector.log_w("MBSCompatApi26", e);
        }
    }

    public static Object getAuthRequestContext(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void PlaceComponentResult(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }

    /* loaded from: classes6.dex */
    static class ResultWrapper {
        MediaBrowserService.Result getAuthRequestContext;

        ResultWrapper(MediaBrowserService.Result result) {
            this.getAuthRequestContext = result;
        }

        public void PlaceComponentResult(List<Parcel> list, int i) {
            try {
                MediaBrowserServiceCompatApi26.KClassImpl$Data$declaredNonStaticMembers$2.setInt(this.getAuthRequestContext, i);
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_w("MBSCompatApi26", e);
            }
            this.getAuthRequestContext.sendResult(PlaceComponentResult(list));
        }

        List<MediaBrowser.MediaItem> PlaceComponentResult(List<Parcel> list) {
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
    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        @Override // androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor, androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            super.attachBaseContext(context);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor, androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor, androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor, androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor, androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor, android.service.media.MediaBrowserService, android.app.Service
        public void onCreate() {
            super.onCreate();
        }

        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            ((ServiceCompatProxy) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(str, new ResultWrapper(result), bundle);
        }
    }

    private MediaBrowserServiceCompatApi26() {
    }
}
