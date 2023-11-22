package id.dana.data.userconfig.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.userconfig.repository.source.local.UserConfigEntity;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserConfigQueryResultMapper extends BaseMapper<UserConfigEntity, UserConfigQueryResult> {
    @Inject
    public UserConfigQueryResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public UserConfigQueryResult map(UserConfigEntity userConfigEntity) {
        if (userConfigEntity.isEmpty()) {
            return UserConfigQueryResult.empty();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(userConfigEntity.config);
        return new UserConfigQueryResult(arrayList, userConfigEntity.etag, true);
    }
}
