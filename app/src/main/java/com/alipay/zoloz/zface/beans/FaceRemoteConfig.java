package com.alipay.zoloz.zface.beans;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.config.bean.FaceTips;
import com.alipay.mobile.security.bio.config.bean.SceneEnv;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;

/* loaded from: classes7.dex */
public class FaceRemoteConfig {
    private JSONObject algorithm;
    private SceneEnv sceneEnv = new SceneEnv();
    private Coll coll = new Coll();
    private JSONObject upload = null;
    private FaceTips faceTips = new FaceTips();
    private DeviceSetting[] deviceSettings = new DeviceSetting[0];
    private int env = 0;
    private int ui = 991;
    private String verifyMode = "normal";

    public void setSceneEnv(SceneEnv sceneEnv) {
        this.sceneEnv = sceneEnv;
    }

    public SceneEnv getSceneEnv() {
        return this.sceneEnv;
    }

    public void setColl(Coll coll) {
        this.coll = coll;
    }

    public Coll getColl() {
        return this.coll;
    }

    public void setUpload(JSONObject jSONObject) {
        this.upload = jSONObject;
    }

    public JSONObject getUpload() {
        return this.upload;
    }

    public void setAlgorithm(JSONObject jSONObject) {
        this.algorithm = jSONObject;
    }

    public JSONObject getAlgorithm() {
        return this.algorithm;
    }

    public void setEnv(int i) {
        this.env = i;
    }

    public int getEnv() {
        return this.env;
    }

    public void setUi(int i) {
        this.ui = i;
    }

    public int getUi() {
        return this.ui;
    }

    public FaceTips getFaceTips() {
        return this.faceTips;
    }

    public void setFaceTips(FaceTips faceTips) {
        this.faceTips = faceTips;
    }

    public DeviceSetting[] getDeviceSettings() {
        return this.deviceSettings;
    }

    public void setDeviceSettings(DeviceSetting[] deviceSettingArr) {
        this.deviceSettings = deviceSettingArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FaceRemoteConfig{sceneEnv=");
        sb.append(this.sceneEnv);
        sb.append(", coll=");
        sb.append(this.coll);
        sb.append(", upload=");
        sb.append(this.upload);
        sb.append(", algorithm=");
        sb.append(this.algorithm);
        sb.append(", faceTips=");
        sb.append(this.faceTips);
        sb.append(", deviceSettings=");
        sb.append(StringUtil.array2String(this.deviceSettings));
        sb.append(", env=");
        sb.append(this.env);
        sb.append(", ui=");
        sb.append(this.ui);
        sb.append('}');
        return sb.toString();
    }

    public String getVerifyMode() {
        return this.verifyMode;
    }

    public void setVerifyMode(String str) {
        this.verifyMode = str;
    }
}
