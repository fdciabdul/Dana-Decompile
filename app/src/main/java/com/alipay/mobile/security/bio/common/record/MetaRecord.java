package com.alipay.mobile.security.bio.common.record;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import java.util.Map;

/* loaded from: classes6.dex */
public class MetaRecord {
    public static final String BIZ_TYPE = "Biometrics";
    public static final String DEFAULT_LOG_CLASSIFIERS = "1#2";
    public static final String LOG_SEPARATOR = "#";
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = 3;
    public static final int PRIORITY_MIDDLE = 2;
    private String actionID;
    private String appID;
    private String bizType;
    private String caseID;
    private String classifier;
    private boolean enableSequence;
    private String param1;
    private String param2;
    private String param3;
    private Map<String, String> param4;
    private int priority;
    private String seedID;
    private int sequenceId;

    public MetaRecord() {
        this.bizType = BIZ_TYPE;
        this.enableSequence = true;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.priority = 2;
        this.classifier = "1";
    }

    public MetaRecord(String str, String str2, String str3, String str4) {
        this.bizType = BIZ_TYPE;
        this.enableSequence = true;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.priority = 2;
        this.classifier = "1";
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
    }

    public MetaRecord(String str, String str2, String str3, String str4, String str5) {
        this.bizType = BIZ_TYPE;
        this.enableSequence = true;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.priority = 2;
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
        this.classifier = str5;
    }

    public MetaRecord(String str, String str2, String str3, String str4, int i) {
        this.bizType = BIZ_TYPE;
        this.enableSequence = true;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.classifier = "1";
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
        this.priority = i;
    }

    public MetaRecord(String str, String str2, String str3, String str4, int i, String str5) {
        this.bizType = BIZ_TYPE;
        this.enableSequence = true;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
        this.priority = i;
        this.classifier = str5;
    }

    public MetaRecord(String str, String str2, String str3, String str4, boolean z) {
        this.bizType = BIZ_TYPE;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.priority = 2;
        this.classifier = "1";
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
        this.enableSequence = z;
    }

    public MetaRecord(String str, String str2, String str3, String str4, boolean z, int i) {
        this.bizType = BIZ_TYPE;
        this.param1 = "";
        this.param2 = "";
        this.param3 = "";
        this.classifier = "1";
        this.caseID = str;
        this.actionID = str2;
        this.appID = str3;
        this.seedID = str4;
        this.enableSequence = z;
        this.priority = i;
    }

    public String getCaseID() {
        return this.caseID;
    }

    public void setCaseID(String str) {
        this.caseID = str;
    }

    public String getActionID() {
        return this.actionID;
    }

    public void setActionID(String str) {
        this.actionID = str;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public String getSeedID() {
        return this.seedID;
    }

    public void setSeedID(String str) {
        this.seedID = str;
    }

    public int getSequenceId() {
        return this.sequenceId;
    }

    public void setSequenceId(int i) {
        this.sequenceId = i;
    }

    public String getParam1() {
        return this.param1;
    }

    public void setParam1(String str) {
        this.param1 = str;
    }

    public String getParam2() {
        return this.param2;
    }

    public void setParam2(String str) {
        this.param2 = str;
    }

    public String getParam3() {
        return this.param3;
    }

    public void setParam3(String str) {
        this.param3 = str;
    }

    public Map<String, String> getParam4() {
        return this.param4;
    }

    public void setParam4(Map<String, String> map) {
        this.param4 = map;
    }

    public boolean isEnableSequence() {
        return this.enableSequence;
    }

    public void setEnableSequence(boolean z) {
        this.enableSequence = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("caseID:");
        sb2.append(this.caseID);
        sb2.append("#");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("actionID:");
        sb3.append(this.actionID);
        sb3.append("#");
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("appID:");
        sb4.append(this.appID);
        sb4.append("#");
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("seedID:");
        sb5.append(this.seedID);
        sb5.append("#");
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("bizType:");
        sb6.append(this.bizType);
        sb6.append("#");
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("priority:");
        sb7.append(this.priority);
        sb7.append("#");
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("classifier:");
        sb8.append(this.classifier);
        sb8.append("#");
        sb.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("param1:");
        sb9.append(this.param1);
        sb9.append("#");
        sb.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("param2:");
        sb10.append(this.param2);
        sb10.append("#");
        sb.append(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("param3:");
        sb11.append(this.param3);
        sb11.append("#");
        sb.append(sb11.toString());
        sb.append("param4:");
        Map<String, String> map = this.param4;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb12 = new StringBuilder();
                sb12.append(AUScreenAdaptTool.PREFIX_ID);
                sb12.append((Object) key);
                sb12.append("=");
                sb12.append((Object) value);
                sb.append(sb12.toString());
            }
        }
        return sb.toString();
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getClassifier() {
        return this.classifier;
    }

    public void setClassifier(String str) {
        this.classifier = str;
    }
}
