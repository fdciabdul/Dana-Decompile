package id.dana.utils;

import android.app.Activity;
import android.provider.Settings;
import android.view.WindowManager;
import id.dana.constants.Variables;

/* loaded from: classes5.dex */
public class BrightnessUtil {
    private BrightnessUtil() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        float MyBillsEntityDataFactory = MyBillsEntityDataFactory(activity);
        float floatValue = Variables.getAuthRequestContext.floatValue();
        if (MyBillsEntityDataFactory < floatValue) {
            attributes.screenBrightness = floatValue;
            activity.getWindow().setAttributes(attributes);
        }
    }

    private static float MyBillsEntityDataFactory(Activity activity) {
        try {
            return Settings.System.getInt(activity.getContentResolver(), "screen_brightness") / 255.0f;
        } catch (Settings.SettingNotFoundException unused) {
            return 0.0f;
        }
    }
}
