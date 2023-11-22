package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private static final String SYNTHETIC_FID_PREFIX = "SYN_";
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final InstallerPackageNameProvider installerPackageNameProvider;
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.appContext = context;
        this.appIdentifier = str;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.installerPackageNameProvider = new InstallerPackageNameProvider();
    }

    private static String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public String getCrashlyticsInstallId() {
        synchronized (this) {
            String str = this.crashlyticsInstallId;
            if (str != null) {
                return str;
            }
            Logger.getLogger().v("Determining Crashlytics installation ID...");
            SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
            String string = sharedPrefs.getString(PREFKEY_FIREBASE_IID, null);
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Cached Firebase Installation ID: ");
            sb.append(string);
            logger.v(sb.toString());
            if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                String fetchTrueFid = fetchTrueFid();
                Logger logger2 = Logger.getLogger();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fetched Firebase Installation ID: ");
                sb2.append(fetchTrueFid);
                logger2.v(sb2.toString());
                if (fetchTrueFid == null) {
                    fetchTrueFid = string == null ? createSyntheticFid() : string;
                }
                if (fetchTrueFid.equals(string)) {
                    this.crashlyticsInstallId = readCachedCrashlyticsInstallId(sharedPrefs);
                } else {
                    this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(fetchTrueFid, sharedPrefs);
                }
            } else if (isSyntheticFid(string)) {
                this.crashlyticsInstallId = readCachedCrashlyticsInstallId(sharedPrefs);
            } else {
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs);
            }
            if (this.crashlyticsInstallId == null) {
                Logger.getLogger().w("Unable to determine Crashlytics Install Id, creating a new one.");
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs);
            }
            Logger logger3 = Logger.getLogger();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Crashlytics installation ID: ");
            sb3.append(this.crashlyticsInstallId);
            logger3.v(sb3.toString());
            return this.crashlyticsInstallId;
        }
    }

    static String createSyntheticFid() {
        StringBuilder sb = new StringBuilder();
        sb.append(SYNTHETIC_FID_PREFIX);
        sb.append(UUID.randomUUID().toString());
        return sb.toString();
    }

    static boolean isSyntheticFid(String str) {
        return str != null && str.startsWith(SYNTHETIC_FID_PREFIX);
    }

    private String readCachedCrashlyticsInstallId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String fetchTrueFid() {
        try {
            return (String) Utils.awaitEvenIfOnMainThread(this.firebaseInstallationsApi.getId());
        } catch (Exception e) {
            Logger.getLogger().w("Failed to retrieve Firebase Installations ID.", e);
            return null;
        }
    }

    private String createAndCacheCrashlyticsInstallId(String str, SharedPreferences sharedPreferences) {
        String formatId;
        synchronized (this) {
            formatId = formatId(UUID.randomUUID().toString());
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Created new Crashlytics installation ID: ");
            sb.append(formatId);
            sb.append(" for FID: ");
            sb.append(str);
            logger.v(sb.toString());
            sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString(PREFKEY_FIREBASE_IID, str).apply();
        }
        return formatId;
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL));
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }
}
