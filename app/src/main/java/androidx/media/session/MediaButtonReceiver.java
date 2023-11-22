package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;

/* loaded from: classes6.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignore unsupported intent: ");
            sb.append(intent);
            InstrumentInjector.log_d("MediaButtonReceiver", sb.toString());
            return;
        }
        ComponentName authRequestContext = getAuthRequestContext(context, "android.intent.action.MEDIA_BUTTON");
        if (authRequestContext != null) {
            intent.setComponent(authRequestContext);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
                return;
            } else {
                context.startService(intent);
                return;
            }
        }
        ComponentName authRequestContext2 = getAuthRequestContext(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (authRequestContext2 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, authRequestContext2, mediaButtonConnectionCallback, null);
            mediaButtonConnectionCallback.getAuthRequestContext = mediaBrowserCompat;
            mediaBrowserCompat.MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    /* loaded from: classes6.dex */
    static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private final Intent KClassImpl$Data$declaredNonStaticMembers$2;
        private final Context PlaceComponentResult;
        MediaBrowserCompat getAuthRequestContext;
        private final BroadcastReceiver.PendingResult lookAheadTest;

        MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.PlaceComponentResult = context;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intent;
            this.lookAheadTest = pendingResult;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void BuiltInFictitiousFunctionClassFactory() {
            try {
                new MediaControllerCompat(this.PlaceComponentResult, this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()).KClassImpl$Data$declaredNonStaticMembers$2((KeyEvent) this.KClassImpl$Data$declaredNonStaticMembers$2.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                InstrumentInjector.log_e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            this.getAuthRequestContext.getAuthRequestContext();
            this.lookAheadTest.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void PlaceComponentResult() {
            this.getAuthRequestContext.getAuthRequestContext();
            this.lookAheadTest.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void getAuthRequestContext() {
            this.getAuthRequestContext.getAuthRequestContext();
            this.lookAheadTest.finish();
        }
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(keyEvent);
        return keyEvent;
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            InstrumentInjector.log_w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j) {
        if (componentName == null) {
            InstrumentInjector.log_w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
            return null;
        }
        int PlaceComponentResult = PlaybackStateCompat.PlaceComponentResult(j);
        if (PlaceComponentResult == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot build a media button pending intent with the given action: ");
            sb.append(j);
            InstrumentInjector.log_w("MediaButtonReceiver", sb.toString());
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, PlaceComponentResult));
        return PendingIntent.getBroadcast(context, PlaceComponentResult, intent, 0);
    }

    public static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        } else if (queryBroadcastReceivers.size() > 1) {
            InstrumentInjector.log_w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        } else {
            return null;
        }
    }

    private static ComponentName getAuthRequestContext(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected 1 service that handles ");
            sb.append(str);
            sb.append(", found ");
            sb.append(queryIntentServices.size());
            throw new IllegalStateException(sb.toString());
        }
    }
}
