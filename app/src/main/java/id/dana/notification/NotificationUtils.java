package id.dana.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.base.Ascii;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.notification.decorator.NotificationContentDecorator;
import id.dana.notification.decorator.NotificationDecorator;
import id.dana.notification.decorator.NotificationIconDecorator;
import id.dana.utils.OSUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.ResourceUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u0004H\u0007J\u001a\u0010!\u001a\u00020\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0007J \u0010%\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0007J\u0018\u0010*\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0006H\u0007J\u001a\u0010,\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010/\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u00106\u001a\u00020\u0004H\u0002J\u0006\u00107\u001a\u000208J4\u00107\u001a\u0002092\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010;\u001a\u00020\u001dH\u0002J0\u0010<\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u0010#\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010;\u001a\u00020\u001dH\u0002J\u000e\u0010=\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016JI\u0010>\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010?\u001a\u0002042\u0006\u0010;\u001a\u00020\u001d2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020$H\u0007J\n\u0010E\u001a\u00020\u001d*\u000208J\u0014\u0010F\u001a\u00020\u001d*\u00020G2\u0006\u0010H\u001a\u000208H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006I"}, d2 = {"Lid/dana/notification/NotificationUtils;", "", "()V", "LOCAL_CHANNEL", "", "MAXIMUM_ACTIONS", "", "PERSISTENT_NOTIFICATION_ID", "PERSISTENT_NOTIFICATION_TAG", "PREFIX_NORMAL_NOTIFICATION", "notificationCreationTimeMillis", "", "getNotificationCreationTimeMillis", "()J", "notificationCreationTimeMillis$delegate", "Lkotlin/Lazy;", "pushNotifLogo", "getPushNotifLogo", "()I", "createBigIconBitmap", "Landroid/graphics/Bitmap;", HummerConstants.CONTEXT, "Landroid/content/Context;", "iconUrl", "createNotificationChannel", "", "channel", "name", "isImportance", "", "createNotificationId", "createPersistentNotificaionChannel", "title", "createPersistentNotification", "Landroid/app/Notification;", "notificationData", "Lid/dana/notification/NotificationData;", "createPersistentNotificationData", "intent", "Landroid/content/Intent;", "onGoing", "message", "dismissNotificationById", "id", "getAlarmSound", "Landroid/net/Uri;", "soundUrl", "getBigNotification", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "bitmap", "resultPendingIntent", "Landroid/app/PendingIntent;", "getBitmapFromURL", "strURL", "getNotificationManager", "Landroidx/core/app/NotificationManagerCompat;", "Landroid/app/NotificationManager;", "channelId", "showUpNotification", "getSmallNotification", "openAppNotificationSettings", "showNotificationMessage", BaseGmsClient.KEY_PENDING_INTENT, "actions", "", "Landroidx/core/app/NotificationCompat$Action;", "(Landroid/content/Context;Lid/dana/notification/NotificationData;Landroid/app/PendingIntent;ZLjava/util/List;Ljava/lang/Integer;)V", "showPersistantNotification", "areNotificationsFullyEnabled", "isFullyEnabled", "Landroid/app/NotificationChannel;", "notificationManager", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationUtils {
    public static final byte[] MyBillsEntityDataFactory = {44, 104, -53, -66, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int getAuthRequestContext = 188;
    public static final NotificationUtils BuiltInFictitiousFunctionClassFactory = new NotificationUtils();
    public static final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Long>() { // from class: id.dana.notification.NotificationUtils$notificationCreationTimeMillis$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 5
            int r8 = r8 + 18
            int r7 = r7 * 6
            int r7 = 103 - r7
            int r9 = r9 * 22
            int r9 = r9 + 4
            byte[] r0 = id.dana.notification.NotificationUtils.MyBillsEntityDataFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r8 = r8 + r9
            int r8 = r8 + (-8)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.notification.NotificationUtils.a(short, byte, int, java.lang.Object[]):void");
    }

    private NotificationUtils() {
    }

    @JvmStatic
    public static final Notification PlaceComponentResult(Context context, NotificationData notificationData) {
        Intrinsics.checkNotNullParameter(notificationData, "");
        Intrinsics.checkNotNull(context);
        NotificationDecorator notificationDecorator = new NotificationDecorator(context, "local_channel", Intrinsics.areEqual(String.valueOf(Boolean.TRUE), notificationData.NetworkUserEntityData$$ExternalSyntheticLambda0.get("onGoing")));
        String str = notificationData.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = notificationData.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        Notification BuiltInFictitiousFunctionClassFactory2 = new NotificationIconDecorator(new NotificationContentDecorator(notificationDecorator, str, str2), OSUtil.moveToNextValue() ? R.drawable.dana_logo_white : R.drawable.dana_logo_white_png).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "");
        NotificationManagerCompat.MyBillsEntityDataFactory(context).MyBillsEntityDataFactory(i);
    }

    private static NotificationManager BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2, String str3, boolean z) {
        Object systemService = context != null ? context.getSystemService("notification") : null;
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            int i = z ? 4 : 3;
            AudioAttributes build = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            NotificationChannel notificationChannel = new NotificationChannel(str2, str, i);
            notificationChannel.setDescription("msg");
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setSound(KClassImpl$Data$declaredNonStaticMembers$2(context, str3), build);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return notificationManager;
    }

    private static Uri KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        Uri.Builder authority = new Uri.Builder().scheme("android.resource").authority(context.getPackageName());
        ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
        Uri build = authority.appendPath(String.valueOf(ResourceUtils.BuiltInFictitiousFunctionClassFactory(context, str))).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }

    private static Bitmap BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection()));
            if (uRLConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException unused) {
            return null;
        }
    }

    public static void MyBillsEntityDataFactory(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        NotificationChannel notificationChannel = new NotificationChannel("local_channel", str, 4);
        Object systemService = context.getSystemService("notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    @JvmStatic
    public static final NotificationData PlaceComponentResult(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        NotificationData notificationData = new NotificationData();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("onGoing", String.valueOf(z));
        notificationData.getErrorConfigVersion = RedirectType.OCR_RECEIPT;
        notificationData.scheduleImpl = str;
        notificationData.lookAheadTest = str2;
        notificationData.NetworkUserEntityData$$ExternalSyntheticLambda0 = hashMap;
        return notificationData;
    }

    public static void MyBillsEntityDataFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            try {
                byte b = (byte) (MyBillsEntityDataFactory[8] - 1);
                Object[] objArr = new Object[1];
                a(b, b, MyBillsEntityDataFactory[41], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = MyBillsEntityDataFactory[41];
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr2);
                intent.putExtra("app_uid", ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).uid);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        context.startActivity(intent);
    }

    public static boolean PlaceComponentResult(NotificationManagerCompat notificationManagerCompat) {
        Intrinsics.checkNotNullParameter(notificationManagerCompat, "");
        if (notificationManagerCompat.BuiltInFictitiousFunctionClassFactory()) {
            if (Build.VERSION.SDK_INT >= 26) {
                for (NotificationChannel notificationChannel : notificationManagerCompat.MyBillsEntityDataFactory()) {
                    Intrinsics.checkNotNullExpressionValue(notificationChannel, "");
                    if (!KClassImpl$Data$declaredNonStaticMembers$2(notificationChannel, notificationManagerCompat)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(NotificationChannel notificationChannel, NotificationManagerCompat notificationManagerCompat) {
        Intrinsics.checkNotNullParameter(notificationChannel, "");
        Intrinsics.checkNotNullParameter(notificationManagerCompat, "");
        if (notificationChannel.getImportance() == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            NotificationChannelGroup KClassImpl$Data$declaredNonStaticMembers$22 = notificationManagerCompat.KClassImpl$Data$declaredNonStaticMembers$2(notificationChannel.getGroup());
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null && KClassImpl$Data$declaredNonStaticMembers$22.isBlocked()) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context context, NotificationData notificationData, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        BuiltInFictitiousFunctionClassFactory(context, notificationData, pendingIntent, false, CollectionsKt.emptyList(), null);
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context context, NotificationData notificationData, PendingIntent pendingIntent, boolean z, List<? extends NotificationCompat.Action> list, Integer num) {
        Bitmap decodeResource;
        int parseInt;
        Bitmap BuiltInFictitiousFunctionClassFactory2;
        Bitmap decodeResource2;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(notificationData, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (TextUtils.isEmpty(notificationData.lookAheadTest)) {
            return;
        }
        String string = context.getString(R.string.default_notification_channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String str = notificationData.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(str, "");
        NotificationManager BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(context, str, string, notificationData.initRecordTimeStamp, z);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, string);
        Iterator it = CollectionsKt.take(list, 3).iterator();
        while (it.hasNext()) {
            builder.PlaceComponentResult((NotificationCompat.Action) it.next());
        }
        String str2 = notificationData.moveToNextValue;
        String str3 = notificationData.BuiltInFictitiousFunctionClassFactory;
        if (str3 != null) {
            decodeResource = BuiltInFictitiousFunctionClassFactory(str3);
        } else {
            decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7);
        }
        String str4 = notificationData.scheduleImpl;
        String str5 = notificationData.lookAheadTest;
        if (z) {
            builder.BuiltInFictitiousFunctionClassFactory(3);
            builder.KClassImpl$Data$declaredNonStaticMembers$2(2);
        }
        String str6 = str4;
        NotificationCompat.Builder KClassImpl$Data$declaredNonStaticMembers$22 = builder.KClassImpl$Data$declaredNonStaticMembers$2(str6);
        boolean moveToNextValue = OSUtil.moveToNextValue();
        int i = R.drawable.dana_logo_white;
        String str7 = str5;
        Notification BuiltInFictitiousFunctionClassFactory4 = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(moveToNextValue ? R.drawable.dana_logo_white : R.drawable.dana_logo_white_png).getAuthRequestContext(str6).MyBillsEntityDataFactory(str7).BuiltInFictitiousFunctionClassFactory(decodeResource).getAuthRequestContext(new NotificationCompat.BigTextStyle().getAuthRequestContext(str7).KClassImpl$Data$declaredNonStaticMembers$2(str6)).PlaceComponentResult(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f23182131099816)).KClassImpl$Data$declaredNonStaticMembers$2(pendingIntent).BuiltInFictitiousFunctionClassFactory(true).KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2(context, notificationData.initRecordTimeStamp)).BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
        if (str2 != null && Patterns.WEB_URL.matcher(str2).matches() && (BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str2)) != null) {
            String str8 = notificationData.BuiltInFictitiousFunctionClassFactory;
            if (str8 != null) {
                decodeResource2 = BuiltInFictitiousFunctionClassFactory(str8);
            } else {
                decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7);
            }
            String str9 = notificationData.scheduleImpl;
            String str10 = notificationData.lookAheadTest;
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            String str11 = str9;
            bigPictureStyle.KClassImpl$Data$declaredNonStaticMembers$2(str11);
            bigPictureStyle.MyBillsEntityDataFactory(HtmlCompat.PlaceComponentResult(str10, 0).toString());
            bigPictureStyle.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2);
            NotificationCompat.Builder authRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2(str11).BuiltInFictitiousFunctionClassFactory(true).getAuthRequestContext(str11).KClassImpl$Data$declaredNonStaticMembers$2(pendingIntent).KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2(context, notificationData.initRecordTimeStamp)).getAuthRequestContext(bigPictureStyle);
            if (!OSUtil.moveToNextValue()) {
                i = R.drawable.dana_logo_white_png;
            }
            BuiltInFictitiousFunctionClassFactory4 = authRequestContext.getAuthRequestContext(i).PlaceComponentResult(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f23182131099816)).BuiltInFictitiousFunctionClassFactory(decodeResource2).MyBillsEntityDataFactory(str10).BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
        }
        try {
            if (num != null) {
                parseInt = num.intValue();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('2');
                sb.append(RandomInteger.BuiltInFictitiousFunctionClassFactory());
                parseInt = Integer.parseInt(sb.toString());
            }
            BuiltInFictitiousFunctionClassFactory3.notify(parseInt, BuiltInFictitiousFunctionClassFactory4);
        } catch (RuntimeException e) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
            NotificationException notificationException = new NotificationException(e);
            Intrinsics.checkNotNullParameter(notificationException, "");
            authRequestContext2.getAuthRequestContext.recordException(notificationException);
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context context, NotificationData notificationData) {
        Intrinsics.checkNotNullParameter(notificationData, "");
        String str = notificationData.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(str, "");
        BuiltInFictitiousFunctionClassFactory(context, str, "local_channel", "", true).notify("persistant_notification", 100, PlaceComponentResult(context, notificationData));
    }
}
