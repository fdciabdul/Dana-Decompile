package com.alipay.zoloz.config;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.security.bio.runtime.FrameworkDesc;
import com.alipay.zoloz.config.util.ConfigLog;
import com.alipay.zoloz.config.util.FileUtil;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ConfigDataParser {
    private static final String FILE_SUBFIX_FRAMEWORK = "/FrameworkConfig/framework.json";
    private static final String FILE_SUBFIX_H5_CONFIG = "/H5Config/business.json";
    private static final String FILE_SUBFIX_OFF_WEB_CONFIG = "/ekyc_web.zip";
    public static final String FILE_SUBFIX_UI_CONFIG = "/";
    public static final String TAG = "ConfigDataParser";
    private static final String webEndPath = "/zoloz/web";
    private String baseTargetPath;
    private String feUIConfig;
    private String uiConfigPath;
    private HashMap<String, Object> frameworkConfigs = new HashMap<>();
    private HashMap<String, Object> h5Configs = new HashMap<>();
    private HashMap<String, Object> bizConfig = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean parseAndVerifyConfig(IConfigCenterCallback iConfigCenterCallback) {
        boolean parseUIConfig = parseUIConfig();
        boolean parseFrameworkConfig = parseFrameworkConfig();
        boolean parseH5Config = parseH5Config();
        parseFeUIConfig();
        if (parseUIConfig && parseFrameworkConfig && parseH5Config) {
            iConfigCenterCallback.onConfigSuccess();
        } else {
            StringBuilder sb = new StringBuilder("");
            if (!parseUIConfig) {
                sb.append("ui config wrong");
            } else if (!parseFrameworkConfig) {
                sb.append("framework config wrong");
            } else if (!parseH5Config) {
                sb.append("H5 config wrong");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error: ");
            sb2.append((Object) sb);
            ConfigLog.e(TAG, sb2.toString());
            iConfigCenterCallback.onConfigFail(sb.toString());
        }
        return parseFrameworkConfig && parseUIConfig && parseH5Config;
    }

    private boolean parseH5Config() {
        synchronized (this) {
            ConfigLog.d(TAG, "parseH5Config for web config");
            StringBuilder sb = new StringBuilder();
            sb.append(this.baseTargetPath);
            sb.append(FILE_SUBFIX_H5_CONFIG);
            String obj = sb.toString();
            if (FileUtil.exists(obj)) {
                this.h5Configs = (HashMap) JSON.parseObject(FileUtil.getText(obj), HashMap.class);
                return true;
            }
            return true;
        }
    }

    private boolean parseFrameworkConfig() {
        synchronized (this) {
            ConfigLog.d(TAG, "parseFrameworkConfig");
            StringBuilder sb = new StringBuilder();
            sb.append(this.baseTargetPath);
            sb.append(FILE_SUBFIX_FRAMEWORK);
            String obj = sb.toString();
            if (FileUtil.exists(obj)) {
                String text = FileUtil.getText(obj);
                if (text != null) {
                    this.frameworkConfigs.putAll((HashMap) JSON.parseObject(text, HashMap.class));
                }
                return true;
            }
            this.frameworkConfigs.putAll((HashMap) JSON.parseObject(new String(com.alipay.mobile.security.bio.utils.FileUtil.getAssetsData(ConfigCenter.getInstance().getApplicationContext().getResources(), FrameworkDesc.ASSETS_NAME_ZOLOZ_FRAMEWORK)), HashMap.class));
            return verifyFrameworkParams(this.frameworkConfigs);
        }
    }

    private void parseFeUIConfig() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.baseTargetPath);
            sb.append("/");
            sb.append("/feuiconfig.json");
            String obj = sb.toString();
            if (FileUtil.exists(obj)) {
                this.feUIConfig = FileUtil.getText(obj);
            }
        }
    }

    private boolean verifyFrameworkParams(HashMap hashMap) {
        return hashMap.get(ConfigConstants.BIO_SDK_VERSION) != null;
    }

    private boolean parseUIConfig() {
        ConfigLog.d(TAG, "parseUIConfig");
        boolean isUIConfigExist = ConfigCenter.getInstance().isUIConfigExist();
        StringBuilder sb = new StringBuilder();
        sb.append(this.baseTargetPath);
        sb.append("/");
        String obj = sb.toString();
        this.uiConfigPath = obj;
        if (!FileUtil.exists(obj)) {
            return !isUIConfigExist;
        }
        ConfigCenter.getInstance().setUiConfigPath(this.uiConfigPath);
        return true;
    }

    public void setBaseTargetPath(String str) {
        this.baseTargetPath = str;
    }

    public String getBaseTargetPath() {
        return this.baseTargetPath;
    }

    public Object getValueFromFramework(String str) {
        Object obj;
        synchronized (this) {
            obj = this.frameworkConfigs.get(str);
        }
        return obj;
    }

    public Object getValueFromH5(String str) {
        Object obj;
        synchronized (this) {
            obj = this.h5Configs.get(str);
        }
        return obj;
    }

    public void addAll(HashMap hashMap) {
        synchronized (this) {
            this.frameworkConfigs.putAll(hashMap);
        }
    }

    public void disable() {
        synchronized (this) {
            this.frameworkConfigs.clear();
            this.h5Configs.clear();
        }
    }

    public void addOne(String str, Object obj) {
        synchronized (this) {
            this.frameworkConfigs.put(str, obj);
        }
    }

    public HashMap<String, Object> getBizConfig() {
        return this.bizConfig;
    }

    public HashMap<String, Object> getFrameworkConfigs() {
        return this.frameworkConfigs;
    }

    public void setBizConfig(HashMap<String, Object> hashMap) {
        this.bizConfig = hashMap;
    }

    public String getFeUIConfig() {
        return this.feUIConfig;
    }
}
