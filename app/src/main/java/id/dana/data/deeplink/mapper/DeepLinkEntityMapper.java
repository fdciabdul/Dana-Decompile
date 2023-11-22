package id.dana.data.deeplink.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import id.dana.domain.deeplink.model.DeepLink;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class DeepLinkEntityMapper extends BaseMapper<DeepLinkEntity, DeepLink> {
    @Inject
    public DeepLinkEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public DeepLink map(DeepLinkEntity deepLinkEntity) {
        if (deepLinkEntity != null) {
            return new DeepLink(deepLinkEntity.getLink());
        }
        return null;
    }
}
