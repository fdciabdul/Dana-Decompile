package com.alipay.mobile.security.faceauth.api.login;

import com.alipay.mobile.security.faceauth.api.AntDetectParameter;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import java.util.Map;

/* loaded from: classes7.dex */
public class AntFaceLoginParameter extends AntDetectParameter {
    private static final long serialVersionUID = 2;
    private String headImageUrl = "";

    public AntFaceLoginParameter() {
        setAction(AntDetector.ACTION_ID_LOGIN);
    }

    public String getHeadImageUrl() {
        return this.headImageUrl;
    }

    public void setHeadImageUrl(String str) {
        this.headImageUrl = str;
    }

    public void clone(AntDetectParameter antDetectParameter) {
        setAction(antDetectParameter.getAction());
        setAppID(antDetectParameter.getAppID());
        setExtJson(antDetectParameter.getExtJson());
        setApdid(antDetectParameter.getApdid());
        setTag(antDetectParameter.getTag());
        setRemoteUrl(antDetectParameter.getRemoteUrl());
        setAutoClose(antDetectParameter.isAutoClose());
        setScene(antDetectParameter.getScene());
        setEnableNavPage(antDetectParameter.enableNavPage());
        setEnablePrePoseAlert(antDetectParameter.enablePrePoseAlert());
        setProtocol(antDetectParameter.getProtocol());
        for (Map.Entry<String, String> entry : antDetectParameter.getExtProperty().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                addExtProperty(key.toString(), value.toString());
            }
        }
    }
}
