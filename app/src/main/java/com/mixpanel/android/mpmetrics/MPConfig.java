package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.OfflineMode;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class MPConfig {
    public static boolean MyBillsEntityDataFactory = false;
    private static MPConfig PrepareContext;
    private static final Object isLayoutRequested = new Object();
    private final boolean A;
    private SSLSocketFactory B;
    private OfflineMode BottomSheetCardBindingView$watcherCardNumberView$1;
    final int BuiltInFictitiousFunctionClassFactory;
    final int DatabaseTableConfigUtil;
    private final boolean FragmentBottomSheetPaymentSettingBinding;
    final int GetContactSyncConfig;
    final String[] KClassImpl$Data$declaredNonStaticMembers$2;
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    final String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;
    String NetworkUserEntityData$$ExternalSyntheticLambda8;
    final long PlaceComponentResult;
    private final boolean SubSequence;
    private final boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    String getAuthRequestContext;
    private final boolean getCallingPid;
    public final String getErrorConfigVersion;
    private final int getSupportButtonTintMode;
    final int initRecordTimeStamp;
    String lookAheadTest;
    final int moveToNextValue;
    final int newProxyInstance;
    private final boolean readMicros;
    String scheduleImpl;
    private final boolean whenAvailable;

    public static MPConfig getAuthRequestContext(Context context) {
        synchronized (isLayoutRequested) {
            if (PrepareContext == null) {
                PrepareContext = MyBillsEntityDataFactory(context.getApplicationContext());
            }
        }
        return PrepareContext;
    }

    private MPConfig(Bundle bundle, Context context) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            MPLog.PlaceComponentResult("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", e);
        }
        this.B = sSLSocketFactory;
        boolean z = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        MyBillsEntityDataFactory = z;
        if (z) {
            MPLog.PlaceComponentResult();
        }
        if (bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.BuiltInFictitiousFunctionClassFactory = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.moveToNextValue = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.SubSequence = bundle.getBoolean("com.mixpanel.android.MPConfig.FlushOnBackground", true);
        this.initRecordTimeStamp = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.getCallingPid = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.readMicros = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.FragmentBottomSheetPaymentSettingBinding = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableExceptionHandler", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bundle.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
        this.whenAvailable = bundle.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.GetContactSyncConfig = bundle.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
        this.DatabaseTableConfigUtil = bundle.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.newProxyInstance = bundle.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Integer.MAX_VALUE);
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = bundle.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        this.A = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        this.getSupportButtonTintMode = bundle.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
        Object obj = bundle.get("com.mixpanel.android.MPConfig.DataExpiration");
        long j = 432000000;
        if (obj != null) {
            try {
                if (obj instanceof Integer) {
                    j = ((Integer) obj).intValue();
                } else if (obj instanceof Float) {
                    j = ((Float) obj).floatValue();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(obj.toString());
                    sb.append(" is not a number.");
                    throw new NumberFormatException(sb.toString());
                }
            } catch (Exception e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Conf", "Error parsing com.mixpanel.android.MPConfig.DataExpiration meta-data value", e2);
            }
        }
        this.PlaceComponentResult = j;
        String string = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string == null ? "mp" : string;
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2 == null ? SystemInformation.KClassImpl$Data$declaredNonStaticMembers$2(context).PlaceComponentResult : string2;
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string3 != null) {
            this.scheduleImpl = string3;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://api.mixpanel.com/track?ip=");
            sb2.append(GetContactSyncConfig() ? "1" : "0");
            this.scheduleImpl = sb2.toString();
        }
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (string4 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = string4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://api.mixpanel.com/engage?ip=");
            sb3.append(GetContactSyncConfig() ? "1" : "0");
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = sb3.toString();
        }
        String string5 = bundle.getString("com.mixpanel.android.MPConfig.GroupsEndpoint");
        if (string5 != null) {
            this.lookAheadTest = string5;
        } else {
            this.lookAheadTest = "https://api.mixpanel.com/groups";
        }
        String string6 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (string6 != null) {
            this.getAuthRequestContext = string6;
        } else {
            this.getAuthRequestContext = "https://decide.mixpanel.com/decide";
        }
        String string7 = bundle.getString("com.mixpanel.android.MPConfig.EditorUrl");
        this.getErrorConfigVersion = string7 == null ? "wss://switchboard.mixpanel.com/connect/" : string7;
        int i = bundle.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
        if (i != -1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getResources().getStringArray(i);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new String[0];
        }
        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Conf", toString());
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.SubSequence;
    }

    public final boolean moveToNextValue() {
        return this.getCallingPid;
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public final boolean getErrorConfigVersion() {
        return this.readMicros;
    }

    public final boolean DatabaseTableConfigUtil() {
        return this.A;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    public final boolean lookAheadTest() {
        return this.whenAvailable;
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    private boolean GetContactSyncConfig() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    public final SSLSocketFactory initRecordTimeStamp() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (this) {
            sSLSocketFactory = this.B;
        }
        return sSLSocketFactory;
    }

    public final OfflineMode scheduleImpl() {
        OfflineMode offlineMode;
        synchronized (this) {
            offlineMode = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        }
        return offlineMode;
    }

    private static MPConfig MyBillsEntityDataFactory(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new MPConfig(bundle, context);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't configure Mixpanel with package name ");
            sb.append(packageName);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mixpanel (5.8.4) configured with:\n    AutoShowMixpanelUpdates ");
        sb.append(BuiltInFictitiousFunctionClassFactory());
        sb.append("\n    BulkUploadLimit ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("\n    FlushInterval ");
        sb.append(this.moveToNextValue);
        sb.append("\n    DataExpiration ");
        sb.append(this.PlaceComponentResult);
        sb.append("\n    MinimumDatabaseLimit ");
        sb.append(this.initRecordTimeStamp);
        sb.append("\n    DisableAppOpenEvent ");
        sb.append(MyBillsEntityDataFactory());
        sb.append("\n    DisableViewCrawler ");
        sb.append(getErrorConfigVersion());
        sb.append("\n    DisableGestureBindingUI ");
        sb.append(moveToNextValue());
        sb.append("\n    DisableEmulatorBindingUI ");
        sb.append(getAuthRequestContext());
        sb.append("\n    EnableDebugLogging ");
        sb.append(MyBillsEntityDataFactory);
        sb.append("\n    TestMode ");
        sb.append(DatabaseTableConfigUtil());
        sb.append("\n    EventsEndpoint ");
        sb.append(this.scheduleImpl);
        sb.append("\n    PeopleEndpoint ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append("\n    DecideEndpoint ");
        sb.append(this.getAuthRequestContext);
        sb.append("\n    EditorUrl ");
        sb.append(this.getErrorConfigVersion);
        sb.append("\n    ImageCacheMaxMemoryFactor ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append("\n    DisableDecideChecker ");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append("\n    IgnoreInvisibleViewsEditor ");
        sb.append(lookAheadTest());
        sb.append("\n    NotificationDefaults ");
        sb.append(this.GetContactSyncConfig);
        sb.append("\n    MinimumSessionDuration: ");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append("\n    SessionTimeoutDuration: ");
        sb.append(this.newProxyInstance);
        sb.append("\n    DisableExceptionHandler: ");
        sb.append(PlaceComponentResult());
        sb.append("\n    NotificationChannelId: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append("\n    NotificationChannelName: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append("\n    NotificationChannelImportance: ");
        sb.append(this.getSupportButtonTintMode);
        sb.append("\n    FlushOnBackground: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0());
        return sb.toString();
    }
}
