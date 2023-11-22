package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.os.BuildCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ContextCompat {
    private static TypedValue getAuthRequestContext;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {105, Ascii.NAK, -43, 101, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = 170;
    private static final Object MyBillsEntityDataFactory = new Object();
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RegisterReceiverFlags {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 6
            int r7 = 103 - r7
            int r8 = r8 + 4
            int r9 = r9 * 5
            int r9 = r9 + 18
            byte[] r0 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.ContextCompat.a(int, byte, byte, java.lang.Object[]):void");
    }

    public static boolean getAuthRequestContext(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void MyBillsEntityDataFactory(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static File[] MyBillsEntityDataFactory(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.MyBillsEntityDataFactory(context) : new File[]{context.getObbDir()};
    }

    public static File[] getAuthRequestContext(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.BuiltInFictitiousFunctionClassFactory(context, str) : new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] PlaceComponentResult(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    public static Drawable PlaceComponentResult(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(context, i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return InstrumentInjector.Resources_getDrawable(context.getResources(), i);
        }
        synchronized (MyBillsEntityDataFactory) {
            if (getAuthRequestContext == null) {
                getAuthRequestContext = new TypedValue();
            }
            context.getResources().getValue(i, getAuthRequestContext, true);
            i2 = getAuthRequestContext.resourceId;
        }
        return InstrumentInjector.Resources_getDrawable(context.getResources(), i2);
    }

    public static int BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.BuiltInFictitiousFunctionClassFactory(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        ObjectsCompat.getAuthRequestContext(str, "permission must be non-null");
        if (BuildCompat.PlaceComponentResult() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return NotificationManagerCompat.MyBillsEntityDataFactory(context).BuiltInFictitiousFunctionClassFactory() ? 0 : -1;
    }

    public static File getAuthRequestContext(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext(context);
        }
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            byte b2 = (byte) (-b);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(BuiltInFictitiousFunctionClassFactory[41], BuiltInFictitiousFunctionClassFactory[1], BuiltInFictitiousFunctionClassFactory[41], objArr2);
            return MyBillsEntityDataFactory(new File(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).dataDir, "no_backup"));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static File MyBillsEntityDataFactory(File file) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to create files subdir ");
                sb.append(file.getPath());
                InstrumentInjector.log_w("ContextCompat", sb.toString());
            }
            return file;
        }
    }

    public static Context BuiltInFictitiousFunctionClassFactory(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.PlaceComponentResult(context);
        }
        return null;
    }

    public static Executor KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getAuthRequestContext(context);
        }
        return ExecutorCompat.PlaceComponentResult(new Handler(context.getMainLooper()));
    }

    public static void PlaceComponentResult(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.BuiltInFictitiousFunctionClassFactory(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static <T> T PlaceComponentResult(Context context, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) Api23Impl.getAuthRequestContext(context, cls);
        }
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context, cls);
        if (MyBillsEntityDataFactory2 != null) {
            return (T) context.getSystemService(MyBillsEntityDataFactory2);
        }
        return null;
    }

    public static Intent BuiltInFictitiousFunctionClassFactory(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return PlaceComponentResult(context, broadcastReceiver, intentFilter, null, null, i);
    }

    public static Intent PlaceComponentResult(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        int i2 = i & 1;
        if (i2 == 0 || (i & 4) == 0) {
            if (i2 != 0) {
                i |= 2;
            }
            int i3 = i;
            int i4 = i3 & 2;
            if (i4 == 0 && (i3 & 4) == 0) {
                throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            }
            if (i4 != 0 && (i3 & 4) != 0) {
                throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            }
            if (!BuildCompat.PlaceComponentResult()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return Api26Impl.BuiltInFictitiousFunctionClassFactory(context, broadcastReceiver, intentFilter, str, handler, i3);
                }
                if ((i3 & 4) != 0 && str == null) {
                    return context.registerReceiver(broadcastReceiver, intentFilter, scheduleImpl(context), handler);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i3);
        }
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static String MyBillsEntityDataFactory(Context context, Class<?> cls) {
        if (Build.VERSION.SDK_INT < 23) {
            return LegacyServiceMapHolder.PlaceComponentResult.get(cls);
        }
        return context.getSystemServiceName(cls);
    }

    static String scheduleImpl(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION");
        String obj = sb.toString();
        if (PermissionChecker.getAuthRequestContext(context, obj) == 0) {
            return obj;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Permission ");
        sb2.append(obj);
        sb2.append(" is required by your application to receive broadcasts, please add it to your manifest");
        throw new RuntimeException(sb2.toString());
    }

    /* loaded from: classes.dex */
    public static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> PlaceComponentResult;

        private LegacyServiceMapHolder() {
        }

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            PlaceComponentResult = hashMap;
            if (Build.VERSION.SDK_INT >= 22) {
                hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap.put(AppWidgetManager.class, "appwidget");
                hashMap.put(BatteryManager.class, "batterymanager");
                hashMap.put(CameraManager.class, "camera");
                hashMap.put(JobScheduler.class, "jobscheduler");
                hashMap.put(LauncherApps.class, "launcherapps");
                hashMap.put(MediaProjectionManager.class, "media_projection");
                hashMap.put(MediaSessionManager.class, "media_session");
                hashMap.put(RestrictionsManager.class, "restrictions");
                hashMap.put(TelecomManager.class, "telecom");
                hashMap.put(TvInputManager.class, "tv_input");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                hashMap.put(AppOpsManager.class, "appops");
                hashMap.put(CaptioningManager.class, "captioning");
                hashMap.put(ConsumerIrManager.class, "consumer_ir");
                hashMap.put(PrintManager.class, "print");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                hashMap.put(BluetoothManager.class, TinyAppActionState.ACTION_BLUE_TOOTH);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                hashMap.put(DisplayManager.class, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                hashMap.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT >= 16) {
                hashMap.put(InputManager.class, "input");
                hashMap.put(MediaRouter.class, "media_router");
                hashMap.put(NsdManager.class, "servicediscovery");
            }
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, SecuredAccountPreferences.Key.ACCOUNT);
            hashMap.put(ActivityManager.class, AkuEventParamsKey.KEY_ACTIVITY);
            hashMap.put(AlarmManager.class, "alarm");
            hashMap.put(AudioManager.class, H5ResourceHandlerUtil.AUDIO);
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void BuiltInFictitiousFunctionClassFactory(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static File[] BuiltInFictitiousFunctionClassFactory(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] MyBillsEntityDataFactory(Context context) {
            return context.getObbDirs();
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable PlaceComponentResult(Context context, int i) {
            return InstrumentInjector.Resources_getDrawable(context, i);
        }

        static File getAuthRequestContext(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static int BuiltInFictitiousFunctionClassFactory(Context context, int i) {
            return context.getColor(i);
        }

        static <T> T getAuthRequestContext(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static Context PlaceComponentResult(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static Intent BuiltInFictitiousFunctionClassFactory(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            if ((i & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.scheduleImpl(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1);
        }

        static ComponentName BuiltInFictitiousFunctionClassFactory(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static Executor getAuthRequestContext(Context context) {
            return context.getMainExecutor();
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private Api30Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }
    }
}
