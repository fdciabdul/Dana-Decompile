package id.dana.data.lazada.model;

import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.domain.userconfig.model.StoreConfig;

/* loaded from: classes4.dex */
public class UserConfigLazada extends StoreConfig<UserConfigContentLazada> {
    private static final String FEATURE_SYNC_LAZADA_CONSENT = "feature_sync_lazada_user_consent";

    public UserConfigLazada(UserConfigContentLazada userConfigContentLazada) {
        super(UserConfigBizTypeConstant.CONFIG_LAZADA_JKT_CONSENT, FEATURE_SYNC_LAZADA_CONSENT, userConfigContentLazada);
    }
}
