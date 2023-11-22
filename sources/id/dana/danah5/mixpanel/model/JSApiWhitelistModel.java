package id.dana.danah5.mixpanel.model;

import com.iap.ac.android.acs.operation.interceptor.Interceptor4reorderFavoriteApps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/danah5/mixpanel/model/JSApiWhitelistModel;", "", "", "", Interceptor4reorderFavoriteApps.KEY_APP_IDS, "Ljava/util/List;", "getAppIds", "()Ljava/util/List;", "serviceKeys", "getServiceKeys", "<init>", "(Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JSApiWhitelistModel {
    public List<String> appIds;
    public List<String> serviceKeys;

    public /* synthetic */ JSApiWhitelistModel() {
    }

    public JSApiWhitelistModel(List<String> list, List<String> list2) {
        this.serviceKeys = list;
        this.appIds = list2;
    }

    @JvmName(name = "getServiceKeys")
    public final List<String> getServiceKeys() {
        return this.serviceKeys;
    }

    @JvmName(name = "getAppIds")
    public final List<String> getAppIds() {
        return this.appIds;
    }
}
