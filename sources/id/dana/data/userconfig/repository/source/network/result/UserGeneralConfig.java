package id.dana.data.userconfig.repository.source.network.result;

import android.text.TextUtils;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.userconfig.repository.source.local.UserConfigPreference;

/* loaded from: classes4.dex */
public class UserGeneralConfig {
    private String bizType;
    private String content;
    private long lastUpdatedTime;

    public UserGeneralConfig() {
        this.lastUpdatedTime = -1L;
        this.bizType = "";
        this.content = "";
    }

    public UserGeneralConfig(String str, String str2, long j) {
        this.bizType = str;
        this.content = str2;
        this.lastUpdatedTime = j;
    }

    public static UserGeneralConfig fromPreference(PreferenceFacade preferenceFacade, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(UserConfigPreference.CONTENT);
        String string = preferenceFacade.getString(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(UserConfigPreference.LAST_UPDATED_TIME);
        return new UserGeneralConfig(str, string, preferenceFacade.getLong(sb2.toString()).longValue());
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(getContent()) && getLastUpdatedTime() == -1;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setLastUpdatedTime(long j) {
        this.lastUpdatedTime = j;
    }
}
