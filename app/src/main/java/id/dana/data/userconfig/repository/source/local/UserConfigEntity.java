package id.dana.data.userconfig.repository.source.local;

import android.text.TextUtils;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;

/* loaded from: classes4.dex */
public class UserConfigEntity {
    public final UserGeneralConfig config;
    public final String etag;

    private UserConfigEntity(String str, UserGeneralConfig userGeneralConfig) {
        this.etag = str;
        this.config = userGeneralConfig;
    }

    public static UserConfigEntity fromPreference(PreferenceFacade preferenceFacade, String str) {
        UserGeneralConfig fromPreference = UserGeneralConfig.fromPreference(preferenceFacade, str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(UserConfigPreference.ETAG);
        return new UserConfigEntity(preferenceFacade.getString(sb.toString()), fromPreference);
    }

    public boolean isEmpty() {
        UserGeneralConfig userGeneralConfig = this.config;
        return (userGeneralConfig == null || userGeneralConfig.isEmpty()) && TextUtils.isEmpty(this.etag);
    }
}
