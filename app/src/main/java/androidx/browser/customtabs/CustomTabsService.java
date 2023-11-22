package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsService;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_SUCCESS = "androidx.browser.customtabs.SUCCESS";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";
    final SimpleArrayMap<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new SimpleArrayMap<>();
    private ICustomTabsService.Stub PlaceComponentResult = new AnonymousClass1();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Result {
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    protected abstract Bundle extraCommand(String str, Bundle bundle);

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

    protected abstract boolean mayLaunchUrl(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean newSession(CustomTabsSessionToken customTabsSessionToken);

    protected abstract int postMessage(CustomTabsSessionToken customTabsSessionToken, String str, Bundle bundle);

    protected abstract boolean receiveFile(CustomTabsSessionToken customTabsSessionToken, Uri uri, int i, Bundle bundle);

    protected abstract boolean requestPostMessageChannel(CustomTabsSessionToken customTabsSessionToken, Uri uri);

    protected abstract boolean updateVisuals(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    protected abstract boolean validateRelationship(CustomTabsSessionToken customTabsSessionToken, int i, Uri uri, Bundle bundle);

    protected abstract boolean warmup(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.browser.customtabs.CustomTabsService$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 extends ICustomTabsService.Stub {
        AnonymousClass1() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j) {
            return CustomTabsService.this.warmup(j);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            return BuiltInFictitiousFunctionClassFactory(iCustomTabsCallback, null);
        }

        private boolean BuiltInFictitiousFunctionClassFactory(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.CustomTabsService$1$$ExternalSyntheticLambda0
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        CustomTabsService.AnonymousClass1.this.m5x67c68af6(customTabsSessionToken);
                    }
                };
                synchronized (CustomTabsService.this.mDeathRecipientMap) {
                    iCustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.mDeathRecipientMap.put(iCustomTabsCallback.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$newSessionInternal$0$androidx-browser-customtabs-CustomTabsService$1  reason: not valid java name */
        public /* synthetic */ void m5x67c68af6(CustomTabsSessionToken customTabsSessionToken) {
            CustomTabsService.this.cleanUpSession(customTabsSessionToken);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.mayLaunchUrl(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.extraCommand(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.updateVisuals(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(iCustomTabsCallback, null), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.requestPostMessageChannel(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.postMessage(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.validateRelationship(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), i, uri, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i, Bundle bundle) {
            PendingIntent pendingIntent;
            CustomTabsService customTabsService = CustomTabsService.this;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return customTabsService.receiveFile(new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent), uri, i, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            PendingIntent pendingIntent;
            if (bundle == null) {
                pendingIntent = null;
            } else {
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
                bundle.remove("android.support.customtabs.extra.SESSION_ID");
                pendingIntent = pendingIntent2;
            }
            return BuiltInFictitiousFunctionClassFactory(iCustomTabsCallback, pendingIntent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.PlaceComponentResult;
    }

    protected boolean cleanUpSession(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.mDeathRecipientMap) {
                ICustomTabsCallback iCustomTabsCallback = customTabsSessionToken.PlaceComponentResult;
                IBinder asBinder = iCustomTabsCallback == null ? null : iCustomTabsCallback.asBinder();
                if (asBinder == null) {
                    return false;
                }
                asBinder.unlinkToDeath(this.mDeathRecipientMap.get(asBinder), 0);
                this.mDeathRecipientMap.remove(asBinder);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}
