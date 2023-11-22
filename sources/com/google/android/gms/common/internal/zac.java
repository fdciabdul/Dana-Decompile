package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.base.Ascii;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zac {
    private static Locale zab;
    public static final byte[] PlaceComponentResult = {44, 104, -53, -66, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int BuiltInFictitiousFunctionClassFactory = 193;
    private static final SimpleArrayMap<String, String> zaa = new SimpleArrayMap<>();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.common.internal.zac.PlaceComponentResult
            int r8 = r8 * 6
            int r8 = r8 + 97
            int r7 = r7 * 22
            int r7 = r7 + 4
            int r6 = r6 * 5
            int r6 = r6 + 18
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + (-8)
            int r6 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zac.a(byte, byte, byte, java.lang.Object[]):void");
    }

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            try {
                return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory & 7);
                byte b2 = PlaceComponentResult[41];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = PlaceComponentResult[41];
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                String str = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).name;
                return TextUtils.isEmpty(str) ? packageName : str;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return resources.getString(R.string.common_google_play_services_enable_button);
                }
                return resources.getString(17039370);
            }
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        return resources.getString(R.string.common_google_play_services_install_button);
    }

    public static String zad(Context context, int i) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i != 1) {
            if (i == 2) {
                return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, zaa2);
            } else if (i != 3) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 9) {
                            if (i == 20) {
                                return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                            }
                            switch (i) {
                                case 16:
                                    return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                                case 17:
                                    return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                                case 18:
                                    return resources.getString(R.string.common_google_play_services_updating_text, zaa2);
                                default:
                                    return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, zaa2);
                            }
                        }
                        return resources.getString(R.string.common_google_play_services_unsupported_text, zaa2);
                    }
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                return resources.getString(R.string.common_google_play_services_enable_text, zaa2);
            }
        }
        return resources.getString(R.string.common_google_play_services_install_text, zaa2);
    }

    public static String zaf(Context context, int i) {
        String zag;
        if (i == 6) {
            zag = zai(context, "common_google_play_services_resolution_required_title");
        } else {
            zag = zag(context, i);
        }
        return zag == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zag;
    }

    public static String zag(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                InstrumentInjector.log_e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                InstrumentInjector.log_e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                InstrumentInjector.log_e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                InstrumentInjector.log_e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                InstrumentInjector.log_e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                InstrumentInjector.log_e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                InstrumentInjector.log_e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                InstrumentInjector.log_e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                InstrumentInjector.log_e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                InstrumentInjector.log_e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zai(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, str2);
    }

    private static String zai(Context context, String str) {
        SimpleArrayMap<String, String> simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            Locale BuiltInFictitiousFunctionClassFactory2 = ConfigurationCompat.PlaceComponentResult(context.getResources().getConfiguration()).BuiltInFictitiousFunctionClassFactory(0);
            if (!BuiltInFictitiousFunctionClassFactory2.equals(zab)) {
                simpleArrayMap.clear();
                zab = BuiltInFictitiousFunctionClassFactory2;
            }
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                InstrumentInjector.log_w("GoogleApiAvailability", str.length() != 0 ? "Missing resource: ".concat(str) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                InstrumentInjector.log_w("GoogleApiAvailability", str.length() != 0 ? "Got empty resource: ".concat(str) : new String("Got empty resource: "));
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }

    public static String zae(Context context, int i) {
        if (i == 6 || i == 19) {
            return zah(context, "common_google_play_services_resolution_required_text", zaa(context));
        }
        return zad(context, i);
    }
}
