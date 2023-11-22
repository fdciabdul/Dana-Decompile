package id.dana.data.content.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.content.source.network.result.CdpContentEntity;
import id.dana.domain.promotion.CdpContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ContentEntityMapper extends BaseMapper<List<CdpContentEntity>, List<CdpContent>> {
    @Inject
    public ContentEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<CdpContent> map(List<CdpContentEntity> list) {
        return transform(list);
    }

    private List<CdpContent> transform(List<CdpContentEntity> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CdpContentEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    private CdpContent transform(CdpContentEntity cdpContentEntity) {
        if (cdpContentEntity != null) {
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
            cdpContent.setContentName(cdpContentEntity.getContentName());
            cdpContent.setLanguage(cdpContentEntity.getLanguage());
            cdpContent.setGmtModified(cdpContentEntity.getGmtModified());
            cdpContent.setGmtCreate(cdpContentEntity.getGmtCreate());
            cdpContent.setPriority(cdpContentEntity.getPriority());
            cdpContent.setEffectiveDate(cdpContentEntity.getEffectiveDate());
            cdpContent.setExpireDate(cdpContentEntity.getExpireDate());
            cdpContent.setSelectRule(cdpContentEntity.getSelectRule());
            cdpContent.setBizType(cdpContentEntity.getBizType());
            cdpContent.setExtendInfo(cdpContentEntity.getExtendInfo());
            return cdpContent;
        }
        return null;
    }
}
