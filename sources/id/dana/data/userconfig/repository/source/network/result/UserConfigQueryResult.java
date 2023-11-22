package id.dana.data.userconfig.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class UserConfigQueryResult extends BaseRpcResult {
    private List<UserGeneralConfig> configs;
    private String etag;

    public UserConfigQueryResult() {
        this.configs = Collections.emptyList();
        this.etag = "";
    }

    public UserConfigQueryResult(List<UserGeneralConfig> list, String str, boolean z) {
        this.configs = list;
        this.etag = str;
        this.success = z;
    }

    public static UserConfigQueryResult empty() {
        return new UserConfigQueryResult(Collections.emptyList(), "", false);
    }

    public boolean isEmpty() {
        List<UserGeneralConfig> list = this.configs;
        return list == null || list.isEmpty();
    }

    public List<UserGeneralConfig> getConfigs() {
        return this.configs;
    }

    public void setConfigs(List<UserGeneralConfig> list) {
        this.configs = list;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }
}
