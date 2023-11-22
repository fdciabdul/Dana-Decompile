package id.dana.data.content.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.domain.promotion.Space;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SpaceResultMapper extends BaseMapper<SpaceRpcResult, Space> {
    @Inject
    public ContentEntityMapper contentEntityMapper;

    @Inject
    public SpaceResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public Space map(SpaceRpcResult spaceRpcResult) {
        return transform(spaceRpcResult);
    }

    private Space transform(SpaceRpcResult spaceRpcResult) {
        if (spaceRpcResult != null) {
            Space space = new Space();
            space.setSpaceCode(spaceRpcResult.getSpaceCode());
            space.setSpaceName(spaceRpcResult.getSpaceName());
            space.setStatus(spaceRpcResult.getStatus());
            space.setGmtModified(spaceRpcResult.getGmtModified());
            space.setGmtCreate(spaceRpcResult.getGmtCreate());
            space.setPlatform(spaceRpcResult.getPlatform());
            space.setSpaceType(spaceRpcResult.getSpaceType());
            space.setAllowedContent(spaceRpcResult.getAllowedContent());
            space.setDisplayStrategy(spaceRpcResult.getDisplayStrategy());
            space.setMarqueeTime(spaceRpcResult.getMarqueeTime());
            space.setContentNumLimit(spaceRpcResult.getContentNumLimit());
            space.setContentTextLimit(spaceRpcResult.getContentTextLimit());
            space.setSpm(spaceRpcResult.getSpm());
            space.setWhiteList(spaceRpcResult.getWhiteList());
            space.setDefaultLang(spaceRpcResult.getDefaultLang());
            space.setCdpContents(this.contentEntityMapper.apply(spaceRpcResult.getCdpContents()));
            return space;
        }
        return null;
    }
}
