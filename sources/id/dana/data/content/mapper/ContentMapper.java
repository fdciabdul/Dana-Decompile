package id.dana.data.content.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.content.source.network.result.CdpContentEntity;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.domain.promotion.CdpContent;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ContentMapper extends BaseMapper<SpaceRpcResult, CdpContent> {
    @Inject
    public ContentEntityMapper contentEntityMapper;

    @Inject
    public ContentMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public CdpContent map(SpaceRpcResult spaceRpcResult) {
        return transform(spaceRpcResult.getCdpContents().get(0));
    }

    private CdpContent transform(CdpContentEntity cdpContentEntity) {
        CdpContent cdpContent = new CdpContent();
        cdpContent.setContentId(cdpContentEntity.getContentId());
        cdpContent.setContentName(cdpContentEntity.getContentName());
        cdpContent.setContentType(cdpContentEntity.getContentType());
        cdpContent.setContentValue(cdpContentEntity.getContentValue());
        cdpContent.setRedirectUrl(cdpContentEntity.getRedirectUrl());
        cdpContent.setSpaceCode(cdpContentEntity.getSpaceCode());
        cdpContent.setEnvType(cdpContentEntity.getEnvType());
        cdpContent.setStatus(cdpContentEntity.getStatus());
        cdpContent.setTenantId(cdpContentEntity.getTenantId());
        cdpContent.setLanguage(cdpContentEntity.getLanguage());
        cdpContent.setGmtModified(cdpContentEntity.getGmtModified());
        cdpContent.setGmtCreate(cdpContentEntity.getGmtCreate());
        cdpContent.setPriority(cdpContentEntity.getPriority());
        cdpContent.setEffectiveDate(cdpContentEntity.getEffectiveDate());
        cdpContent.setExpireDate(cdpContentEntity.getExpireDate());
        cdpContent.setSelectRule(cdpContentEntity.getSelectRule());
        cdpContent.setBizType(cdpContentEntity.getBizType());
        return cdpContent;
    }
}
