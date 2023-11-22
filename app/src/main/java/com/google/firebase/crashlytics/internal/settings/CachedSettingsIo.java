package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class CachedSettingsIo {
    private static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
    private final File cachedSettingsFile;

    public CachedSettingsIo(FileStore fileStore) {
        this.cachedSettingsFile = fileStore.getCommonFile(SETTINGS_CACHE_FILENAME);
    }

    private File getSettingsFile() {
        return this.cachedSettingsFile;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:21:0x0049 */
    public JSONObject readCachedSettings() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObject;
        Logger.getLogger().d("Checking for cached settings...");
        FileInputStream fileInputStream3 = null;
        try {
            try {
                File settingsFile = getSettingsFile();
                if (settingsFile.exists()) {
                    fileInputStream = new FileInputStream(settingsFile);
                    try {
                        jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
                        fileInputStream3 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        Logger.getLogger().e("Failed to fetch cached settings", e);
                        CommonUtils.closeOrLog(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    Logger.getLogger().v("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.closeOrLog(fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeOrLog(fileInputStream3, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream3 = fileInputStream2;
            CommonUtils.closeOrLog(fileInputStream3, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void writeCachedSettings(long j, JSONObject jSONObject) {
        Throwable th;
        FileWriter fileWriter;
        Exception e;
        Logger.getLogger().v("Writing settings to cache file...");
        if (jSONObject == null) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(getSettingsFile());
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    Logger.getLogger().e("Failed to cache settings", e);
                    CommonUtils.closeOrLog(fileWriter2, "Failed to close settings writer.");
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
