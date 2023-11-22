package id.dana.data.userconfig.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class UserConfigQueryRequest extends BaseRpcRequest {
    private final List<String> bizTypes;
    private final String etag;

    public UserConfigQueryRequest(List<String> list, String str) {
        this.bizTypes = list;
        this.etag = str;
    }

    public static UserConfigQueryRequest empty() {
        return new UserConfigQueryRequest(Collections.emptyList(), "");
    }

    public static UserConfigQueryRequest fromSingleBiztype(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return new UserConfigQueryRequest(arrayList, str2);
    }

    public List<String> getBizTypes() {
        return this.bizTypes;
    }

    public String getEtag() {
        return this.etag;
    }
}
