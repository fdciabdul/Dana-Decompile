package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.atomic.AtomicInteger;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public final class CommonNotificationBuilder {
    private static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL = "fcm_fallback_notification_channel";
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL = "fcm_fallback_notification_channel_label";
    private static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_NAME_NO_RESOURCE = "Misc";
    private static final int ILLEGAL_RESOURCE_ID = 0;
    public static final String METADATA_DEFAULT_CHANNEL_ID = "com.google.firebase.messaging.default_notification_channel_id";
    public static final String METADATA_DEFAULT_COLOR = "com.google.firebase.messaging.default_notification_color";
    public static final String METADATA_DEFAULT_ICON = "com.google.firebase.messaging.default_notification_icon";
    private static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private CommonNotificationBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayNotificationInfo createNotificationInfo(Context context, NotificationParams notificationParams) {
        Bundle manifestMetadata = getManifestMetadata(context.getPackageManager(), context.getPackageName());
        return createNotificationInfo(context, context, notificationParams, getOrCreateChannel(context, notificationParams.getNotificationChannelId(), manifestMetadata), manifestMetadata);
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, String str, NotificationParams notificationParams, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        return createNotificationInfo(context, context, notificationParams, str2, bundle, str, resources, packageManager);
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, Context context2, NotificationParams notificationParams, String str, Bundle bundle) {
        return createNotificationInfo(context, context2, notificationParams, str, bundle, context2.getPackageName(), context2.getResources(), context2.getPackageManager());
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, Context context2, NotificationParams notificationParams, String str, Bundle bundle, String str2, Resources resources, PackageManager packageManager) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, str);
        String possiblyLocalizedString = notificationParams.getPossiblyLocalizedString(resources, str2, Constants.MessageNotificationKeys.TITLE);
        if (!TextUtils.isEmpty(possiblyLocalizedString)) {
            builder.getAuthRequestContext(possiblyLocalizedString);
        }
        String possiblyLocalizedString2 = notificationParams.getPossiblyLocalizedString(resources, str2, Constants.MessageNotificationKeys.BODY);
        if (!TextUtils.isEmpty(possiblyLocalizedString2)) {
            builder.MyBillsEntityDataFactory(possiblyLocalizedString2);
            builder.getAuthRequestContext(new NotificationCompat.BigTextStyle().getAuthRequestContext(possiblyLocalizedString2));
        }
        builder.getAuthRequestContext(getSmallIcon(packageManager, resources, str2, notificationParams.getString(Constants.MessageNotificationKeys.ICON), bundle));
        Uri sound = getSound(str2, notificationParams, resources);
        if (sound != null) {
            builder.KClassImpl$Data$declaredNonStaticMembers$2(sound);
        }
        builder.KClassImpl$Data$declaredNonStaticMembers$2(createContentIntent(context, notificationParams, str2, packageManager));
        PendingIntent createDeleteIntent = createDeleteIntent(context, context2, notificationParams);
        if (createDeleteIntent != null) {
            builder.getAuthRequestContext(createDeleteIntent);
        }
        Integer color = getColor(context2, notificationParams.getString(Constants.MessageNotificationKeys.COLOR), bundle);
        if (color != null) {
            builder.PlaceComponentResult(color.intValue());
        }
        builder.BuiltInFictitiousFunctionClassFactory(!notificationParams.getBoolean(Constants.MessageNotificationKeys.STICKY));
        builder.PlaceComponentResult(notificationParams.getBoolean(Constants.MessageNotificationKeys.LOCAL_ONLY));
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TICKER);
        if (string != null) {
            builder.KClassImpl$Data$declaredNonStaticMembers$2(string);
        }
        Integer notificationPriority = notificationParams.getNotificationPriority();
        if (notificationPriority != null) {
            builder.KClassImpl$Data$declaredNonStaticMembers$2(notificationPriority.intValue());
        }
        Integer visibility = notificationParams.getVisibility();
        if (visibility != null) {
            builder.scheduleImpl(visibility.intValue());
        }
        Integer notificationCount = notificationParams.getNotificationCount();
        if (notificationCount != null) {
            builder.MyBillsEntityDataFactory(notificationCount.intValue());
        }
        Long l = notificationParams.getLong(Constants.MessageNotificationKeys.EVENT_TIME);
        if (l != null) {
            builder.MyBillsEntityDataFactory(true);
            builder.KClassImpl$Data$declaredNonStaticMembers$2(l.longValue());
        }
        long[] vibrateTimings = notificationParams.getVibrateTimings();
        if (vibrateTimings != null) {
            builder.getAuthRequestContext(vibrateTimings);
        }
        int[] lightSettings = notificationParams.getLightSettings();
        if (lightSettings != null) {
            builder.BuiltInFictitiousFunctionClassFactory(lightSettings[0], lightSettings[1], lightSettings[2]);
        }
        builder.BuiltInFictitiousFunctionClassFactory(getConsolidatedDefaults(notificationParams));
        return new DisplayNotificationInfo(builder, getTag(notificationParams), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int getConsolidatedDefaults(NotificationParams notificationParams) {
        boolean z = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_SOUND);
        ?? r0 = z;
        if (notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_VIBRATE_TIMINGS)) {
            r0 = (z ? 1 : 0) | true;
        }
        return notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_LIGHT_SETTINGS) ? r0 | 4 : r0;
    }

    private static boolean isValidIcon(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (resources.getDrawable(i, null) instanceof AdaptiveIconDrawable) {
                StringBuilder sb = new StringBuilder();
                sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
                sb.append(i);
                InstrumentInjector.log_e(Constants.TAG, sb.toString());
                return false;
            }
            return true;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            InstrumentInjector.log_e(Constants.TAG, sb2.toString());
            return false;
        }
    }

    private static int getSmallIcon(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && isValidIcon(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && isValidIcon(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
        }
        int i = bundle.getInt(METADATA_DEFAULT_ICON, 0);
        if (i == 0 || !isValidIcon(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Couldn't get own application info: ");
                sb2.append(e);
                InstrumentInjector.log_w(Constants.TAG, sb2.toString());
            }
        }
        if (i == 0 || !isValidIcon(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static Integer getColor(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                InstrumentInjector.log_w(Constants.TAG, sb.toString());
            }
        }
        int i = bundle.getInt(METADATA_DEFAULT_COLOR, 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, i));
            } catch (Resources.NotFoundException unused2) {
                InstrumentInjector.log_w(Constants.TAG, "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    private static Uri getSound(String str, NotificationParams notificationParams, Resources resources) {
        String soundResourceName = notificationParams.getSoundResourceName();
        if (TextUtils.isEmpty(soundResourceName)) {
            return null;
        }
        if (!"default".equals(soundResourceName) && resources.getIdentifier(soundResourceName, "raw", str) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(soundResourceName);
            return Uri.parse(sb.toString());
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private static PendingIntent createContentIntent(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent createTargetIntent = createTargetIntent(str, notificationParams, packageManager);
        if (createTargetIntent == null) {
            return null;
        }
        createTargetIntent.addFlags(67108864);
        createTargetIntent.putExtras(notificationParams.paramsWithReservedKeysRemoved());
        if (shouldUploadMetrics(notificationParams)) {
            createTargetIntent.putExtra(Constants.MessageNotificationKeys.ANALYTICS_DATA, notificationParams.paramsForAnalyticsIntent());
        }
        return PendingIntent.getActivity(context, generatePendingIntentRequestCode(), createTargetIntent, getPendingIntentFlags(1073741824));
    }

    private static Intent createTargetIntent(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.CLICK_ACTION);
        if (!TextUtils.isEmpty(string)) {
            Intent intent = new Intent(string);
            intent.setPackage(str);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            return intent;
        }
        Uri link = notificationParams.getLink();
        if (link != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(link);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            InstrumentInjector.log_w(Constants.TAG, "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static Bundle getManifestMetadata(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't get own application info: ");
            sb.append(e);
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
        }
        return Bundle.EMPTY;
    }

    public static String getOrCreateChannel(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                InstrumentInjector.log_w(Constants.TAG, sb.toString());
            }
            if (!TextUtils.isEmpty("fcm_default_channel")) {
                if (notificationManager.getNotificationChannel("fcm_default_channel") != null) {
                    return "fcm_default_channel";
                }
                InstrumentInjector.log_w(Constants.TAG, "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            } else {
                InstrumentInjector.log_w(Constants.TAG, "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL) == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL, context.getString(id.dana.R.string.fcm_fallback_notification_channel_label), 3));
            }
            return FCM_FALLBACK_NOTIFICATION_CHANNEL;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int generatePendingIntentRequestCode() {
        return requestCodeProvider.incrementAndGet();
    }

    private static int getPendingIntentFlags(int i) {
        return Build.VERSION.SDK_INT >= 23 ? i | 67108864 : i;
    }

    private static PendingIntent createDeleteIntent(Context context, Context context2, NotificationParams notificationParams) {
        if (shouldUploadMetrics(notificationParams)) {
            return createMessagingPendingIntent(context, context2, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(notificationParams.paramsForAnalyticsIntent()));
        }
        return null;
    }

    private static PendingIntent createMessagingPendingIntent(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, generatePendingIntentRequestCode(), new Intent(ACTION_MESSAGING_EVENT).setComponent(new ComponentName(context2, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, intent), getPendingIntentFlags(1073741824));
    }

    static boolean shouldUploadMetrics(NotificationParams notificationParams) {
        return notificationParams.getBoolean(Constants.AnalyticsKeys.ENABLED);
    }

    private static String getTag(NotificationParams notificationParams) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TAG);
        if (TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append("FCM-Notification:");
            sb.append(SystemClock.uptimeMillis());
            return sb.toString();
        }
        return string;
    }

    /* loaded from: classes3.dex */
    public static class DisplayNotificationInfo {

        /* renamed from: id  reason: collision with root package name */
        public final int f7440id;
        public final NotificationCompat.Builder notificationBuilder;
        public final String tag;

        DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i) {
            this.notificationBuilder = builder;
            this.tag = str;
            this.f7440id = i;
        }
    }
}
