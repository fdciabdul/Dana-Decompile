package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class NotificationParams {
    private static final int COLOR_TRANSPARENT_IN_HEX = -16777216;
    private static final int EMPTY_JSON_ARRAY_LENGTH = 1;
    private static final String TAG = "NotificationParams";
    private static final int VISIBILITY_MAX = 1;
    private static final int VISIBILITY_MIN = -1;
    private final Bundle data;

    public NotificationParams(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.data = new Bundle(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getNotificationCount() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("notificationCount is invalid: ");
            sb.append(integer);
            sb.append(". Skipping setting notificationCount.");
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
            return null;
        }
        return integer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getNotificationPriority() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() < -2 || integer.intValue() > 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("notificationPriority is invalid ");
            sb.append(integer);
            sb.append(". Skipping setting notificationPriority.");
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
            return null;
        }
        return integer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer getVisibility() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.VISIBILITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() < -1 || integer.intValue() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("visibility is invalid: ");
            sb.append(integer);
            sb.append(". Skipping setting visibility.");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
        return integer;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            String keyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(keyWithOldPrefix)) {
                return keyWithOldPrefix;
            }
        }
        return str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return "1".equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't parse value of ");
            sb.append(userFriendlyKey(str));
            sb.append("(");
            sb.append(string);
            sb.append(") into an int");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(string));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't parse value of ");
            sb.append(userFriendlyKey(str));
            sb.append("(");
            sb.append(string);
            sb.append(") into a long");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
    }

    public String getLocalizationResourceForKey(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX);
        return getString(sb.toString());
    }

    public Object[] getLocalizationArgsForKey(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Constants.MessageNotificationKeys.TEXT_ARGS_SUFFIX);
        JSONArray jSONArray = getJSONArray(sb.toString());
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed JSON for key ");
            sb.append(userFriendlyKey(str));
            sb.append(": ");
            sb.append(string);
            sb.append(", falling back to default");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
    }

    private static String userFriendlyKey(String str) {
        return str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str.substring(6) : str;
    }

    public Uri getLink() {
        String string = getString(Constants.MessageNotificationKeys.LINK_ANDROID);
        if (TextUtils.isEmpty(string)) {
            string = getString(Constants.MessageNotificationKeys.LINK);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    public String getSoundResourceName() {
        String string = getString(Constants.MessageNotificationKeys.SOUND_2);
        return TextUtils.isEmpty(string) ? getString(Constants.MessageNotificationKeys.SOUND) : string;
    }

    public long[] getVibrateTimings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.VIBRATE_TIMINGS);
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(jSONArray);
            sb.append(". Skipping setting vibrateTimings.");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getLightSettings() {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.LIGHT_SETTINGS);
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = getLightColor(jSONArray.optString(0));
            iArr[1] = jSONArray.optInt(1);
            iArr[2] = jSONArray.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("LightSettings is invalid: ");
            sb.append(jSONArray);
            sb.append(". ");
            sb.append(e.getMessage());
            sb.append(". Skipping setting LightSettings");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        } catch (JSONException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("LightSettings is invalid: ");
            sb2.append(jSONArray);
            sb2.append(". Skipping setting LightSettings");
            InstrumentInjector.log_w(TAG, sb2.toString());
            return null;
        }
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (isReservedKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!isAnalyticsKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public String getLocalizedString(Resources resources, String str, String str2) {
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, "string", str);
        if (identifier == 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX);
            sb.append(userFriendlyKey(sb2.toString()));
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            InstrumentInjector.log_w(TAG, sb.toString());
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, localizationArgsForKey);
        } catch (MissingFormatArgumentException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing format argument for ");
            sb3.append(userFriendlyKey(str2));
            sb3.append(": ");
            sb3.append(Arrays.toString(localizationArgsForKey));
            sb3.append(" Default value will be used.");
            InstrumentInjector.log_w(TAG, sb3.toString(), e);
            return null;
        }
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        return !TextUtils.isEmpty(string) ? string : getLocalizedString(resources, str, str2);
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(getString(Constants.MessageNotificationKeys.IMAGE_URL));
    }

    public String getNotificationChannelId() {
        return getString(Constants.MessageNotificationKeys.CHANNEL);
    }

    private static boolean isAnalyticsKey(String str) {
        return str.startsWith(Constants.AnalyticsKeys.PREFIX) || str.equals("from");
    }

    private static boolean isReservedKey(String str) {
        return str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private static int getLightColor(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    public boolean isNotification() {
        return getBoolean(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION);
    }

    public static boolean isNotification(Bundle bundle) {
        return "1".equals(bundle.getString(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || "1".equals(bundle.getString(keyWithOldPrefix(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)));
    }

    private static String keyWithOldPrefix(String str) {
        return !str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str : str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }
}
