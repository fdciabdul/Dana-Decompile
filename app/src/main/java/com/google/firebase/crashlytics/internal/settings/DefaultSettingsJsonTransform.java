package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return defaultSettings(currentTimeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        return new Settings(3600000 + currentTimeProvider.getCurrentTimeMillis(), new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false), 0, 3600, 10.0d, 1.2d, 60);
    }
}
