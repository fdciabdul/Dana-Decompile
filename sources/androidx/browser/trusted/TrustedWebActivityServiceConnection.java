package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;

/* loaded from: classes6.dex */
public final class TrustedWebActivityServiceConnection {
    private final ComponentName KClassImpl$Data$declaredNonStaticMembers$2;
    private final ITrustedWebActivityService getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrustedWebActivityServiceConnection(ITrustedWebActivityService iTrustedWebActivityService, ComponentName componentName) {
        this.getAuthRequestContext = iTrustedWebActivityService;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = componentName;
    }

    /* loaded from: classes6.dex */
    static class NotifyNotificationArgs {
        public final Notification BuiltInFictitiousFunctionClassFactory;
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public final String getAuthRequestContext;

        private NotifyNotificationArgs(String str, int i, Notification notification, String str2) {
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory = notification;
            this.MyBillsEntityDataFactory = str2;
        }

        public static NotifyNotificationArgs BuiltInFictitiousFunctionClassFactory(Bundle bundle) {
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    /* loaded from: classes6.dex */
    static class CancelNotificationArgs {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;
        public final int MyBillsEntityDataFactory;

        private CancelNotificationArgs(String str, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = i;
        }

        public static CancelNotificationArgs getAuthRequestContext(Bundle bundle) {
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    /* loaded from: classes6.dex */
    static class ResultArgs {
        public final boolean PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ResultArgs(boolean z) {
            this.PlaceComponentResult = z;
        }
    }

    /* loaded from: classes6.dex */
    static class ActiveNotificationsArgs {
        public final Parcelable[] getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.getAuthRequestContext = parcelableArr;
        }
    }

    /* loaded from: classes6.dex */
    static class NotificationsEnabledArgs {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        private NotificationsEnabledArgs(String str) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }

        public static NotificationsEnabledArgs KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
            TrustedWebActivityServiceConnection.getAuthRequestContext(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    static void getAuthRequestContext(Bundle bundle, String str) {
        if (bundle.containsKey(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle must contain ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: androidx.browser.trusted.TrustedWebActivityServiceConnection$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends ITrustedWebActivityCallback.Stub {
        final /* synthetic */ TrustedWebActivityCallback val$callback;

        @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        }

        AnonymousClass1(TrustedWebActivityCallback trustedWebActivityCallback) {
            this.val$callback = trustedWebActivityCallback;
        }
    }
}
