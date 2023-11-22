package com.iap.ac.android.biz.common.model.acl;

import com.iap.ac.android.biz.accommon.a.a;
import java.util.Map;

/* loaded from: classes3.dex */
public class AclAPIContext {
    public static final String API_SOURCE_AC = "AlipayConnect";
    public AclMiniProgramMetaData aclMiniProgramMetaData;
    public Map<String, String> extendedInfo;
    public String source;

    public AclAPIContext(String str, AclMiniProgramMetaData aclMiniProgramMetaData, Map<String, String> map) {
        this.source = str;
        this.aclMiniProgramMetaData = aclMiniProgramMetaData;
        this.extendedInfo = map;
    }

    public AclMiniProgramMetaData getAclMiniProgramMetaData() {
        return this.aclMiniProgramMetaData;
    }

    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public String getSource() {
        return this.source;
    }

    public void setAclMiniProgramMetaData(AclMiniProgramMetaData aclMiniProgramMetaData) {
        this.aclMiniProgramMetaData = aclMiniProgramMetaData;
    }

    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("AclAPIContext{source='");
        a2.append(this.source);
        a2.append('\'');
        a2.append(", aclMiniProgramMetaData=");
        a2.append(this.aclMiniProgramMetaData);
        a2.append(", extendedInfo=");
        a2.append(this.extendedInfo);
        a2.append('}');
        return a2.toString();
    }
}
