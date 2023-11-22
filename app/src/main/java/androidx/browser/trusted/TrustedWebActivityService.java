package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.browser.trusted.TrustedWebActivityServiceConnection;
import androidx.core.app.NotificationManagerCompat;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Locale;

/* loaded from: classes6.dex */
public abstract class TrustedWebActivityService extends Service {
    public static final String ACTION_TRUSTED_WEB_ACTIVITY_SERVICE = "android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE";
    public static final String KEY_SMALL_ICON_BITMAP = "android.support.customtabs.trusted.SMALL_ICON_BITMAP";
    public static final String KEY_SUCCESS = "androidx.browser.trusted.SUCCESS";
    public static final String META_DATA_NAME_SMALL_ICON = "android.support.customtabs.trusted.SMALL_ICON";
    public static final int SMALL_ICON_NOT_SET = -1;
    private NotificationManager getAuthRequestContext;
    int mVerifiedUid = -1;
    private final ITrustedWebActivityService.Stub PlaceComponentResult = new ITrustedWebActivityService.Stub() { // from class: androidx.browser.trusted.TrustedWebActivityService.1
        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle areNotificationsEnabled(Bundle bundle) {
            PlaceComponentResult();
            TrustedWebActivityServiceConnection.ResultArgs resultArgs = new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.onAreNotificationsEnabled(TrustedWebActivityServiceConnection.NotificationsEnabledArgs.KClassImpl$Data$declaredNonStaticMembers$2(bundle).KClassImpl$Data$declaredNonStaticMembers$2));
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", resultArgs.PlaceComponentResult);
            return bundle2;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            PlaceComponentResult();
            TrustedWebActivityServiceConnection.NotifyNotificationArgs BuiltInFictitiousFunctionClassFactory = TrustedWebActivityServiceConnection.NotifyNotificationArgs.BuiltInFictitiousFunctionClassFactory(bundle);
            TrustedWebActivityServiceConnection.ResultArgs resultArgs = new TrustedWebActivityServiceConnection.ResultArgs(TrustedWebActivityService.this.onNotifyNotificationWithChannel(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", resultArgs.PlaceComponentResult);
            return bundle2;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public void cancelNotification(Bundle bundle) {
            PlaceComponentResult();
            TrustedWebActivityServiceConnection.CancelNotificationArgs authRequestContext = TrustedWebActivityServiceConnection.CancelNotificationArgs.getAuthRequestContext(bundle);
            TrustedWebActivityService.this.onCancelNotification(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.MyBillsEntityDataFactory);
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getActiveNotifications() {
            PlaceComponentResult();
            TrustedWebActivityServiceConnection.ActiveNotificationsArgs activeNotificationsArgs = new TrustedWebActivityServiceConnection.ActiveNotificationsArgs(TrustedWebActivityService.this.onGetActiveNotifications());
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", activeNotificationsArgs.getAuthRequestContext);
            return bundle;
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public int getSmallIconId() {
            PlaceComponentResult();
            return TrustedWebActivityService.this.onGetSmallIconId();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getSmallIconBitmap() {
            PlaceComponentResult();
            return TrustedWebActivityService.this.onGetSmallIconBitmap();
        }

        @Override // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            PlaceComponentResult();
            return TrustedWebActivityService.this.onExtraCommand(str, bundle, TrustedWebActivityCallbackRemote.BuiltInFictitiousFunctionClassFactory(iBinder));
        }

        private void PlaceComponentResult() {
            if (TrustedWebActivityService.this.mVerifiedUid == -1) {
                String[] packagesForUid = TrustedWebActivityService.this.getPackageManager().getPackagesForUid(getCallingUid());
                int i = 0;
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token authRequestContext = TrustedWebActivityService.this.getTokenStore().getAuthRequestContext();
                PackageManager packageManager = TrustedWebActivityService.this.getPackageManager();
                if (authRequestContext != null) {
                    int length = packagesForUid.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (authRequestContext.MyBillsEntityDataFactory(packagesForUid[i], packageManager)) {
                            TrustedWebActivityService.this.mVerifiedUid = getCallingUid();
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (TrustedWebActivityService.this.mVerifiedUid != getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }
    };

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

    public abstract TokenStore getTokenStore();

    public Bundle onExtraCommand(String str, Bundle bundle, TrustedWebActivityCallbackRemote trustedWebActivityCallbackRemote) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.getAuthRequestContext = (NotificationManager) getSystemService("notification");
    }

    public Bundle onGetSmallIconBitmap() {
        int onGetSmallIconId = onGetSmallIconId();
        Bundle bundle = new Bundle();
        if (onGetSmallIconId == -1) {
            return bundle;
        }
        bundle.putParcelable(KEY_SMALL_ICON_BITMAP, BitmapFactory.decodeResource(getResources(), onGetSmallIconId));
        return bundle;
    }

    public int onGetSmallIconId() {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
            if (serviceInfo.metaData == null) {
                return -1;
            }
            return serviceInfo.metaData.getInt(META_DATA_NAME_SMALL_ICON, -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.PlaceComponentResult;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.mVerifiedUid = -1;
        return super.onUnbind(intent);
    }

    private static String MyBillsEntityDataFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.toLowerCase(Locale.ROOT).replace(InputCardNumberView.DIVIDER, '_'));
        sb.append("_channel_id");
        return sb.toString();
    }

    public boolean onAreNotificationsEnabled(String str) {
        if (this.getAuthRequestContext != null) {
            if (NotificationManagerCompat.MyBillsEntityDataFactory(this).BuiltInFictitiousFunctionClassFactory()) {
                if (Build.VERSION.SDK_INT < 26) {
                    return true;
                }
                return NotificationApiHelperForO.MyBillsEntityDataFactory(this.getAuthRequestContext, MyBillsEntityDataFactory(str));
            }
            return false;
        }
        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
    }

    public void onCancelNotification(String str, int i) {
        NotificationManager notificationManager = this.getAuthRequestContext;
        if (notificationManager != null) {
            notificationManager.cancel(str, i);
            return;
        }
        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
    }

    public Parcelable[] onGetActiveNotifications() {
        if (this.getAuthRequestContext != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return NotificationApiHelperForM.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            }
            throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
        }
        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
    }

    public boolean onNotifyNotificationWithChannel(String str, int i, Notification notification, String str2) {
        if (this.getAuthRequestContext != null) {
            if (NotificationManagerCompat.MyBillsEntityDataFactory(this).BuiltInFictitiousFunctionClassFactory()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    String MyBillsEntityDataFactory = MyBillsEntityDataFactory(str2);
                    notification = NotificationApiHelperForO.PlaceComponentResult(this, this.getAuthRequestContext, notification, MyBillsEntityDataFactory, str2);
                    if (!NotificationApiHelperForO.MyBillsEntityDataFactory(this.getAuthRequestContext, MyBillsEntityDataFactory)) {
                        return false;
                    }
                }
                this.getAuthRequestContext.notify(str, i, notification);
                return true;
            }
            return false;
        }
        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
    }
}
