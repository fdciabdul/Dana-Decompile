package id.dana.data.globalnetwork.mapper;

import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.domain.globalnetwork.model.Auth;
import java.util.Set;

/* loaded from: classes4.dex */
public class GnAuthMapper {
    private GnAuthMapper() {
    }

    public static Auth transform(GnAuthResult gnAuthResult) {
        Auth auth = new Auth();
        auth.setClientId(gnAuthResult.getClientId());
        auth.setScope(getScopeString(gnAuthResult.getScopes()));
        auth.setAuthCallback(gnAuthResult.getCallback());
        auth.setAppName(gnAuthResult.getAppName());
        auth.setIconUrl(gnAuthResult.getIconUrl());
        return auth;
    }

    private static String getScopeString(Set<String> set) {
        return set == null ? "" : set.toString().replace("[", "").replace("]", "").replace(", ", ",");
    }
}
