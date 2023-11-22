package id.dana.data.recentrecipient.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentrecipient.model.RecentBankRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class RecentBankMapper extends BaseMapper<RecentRecipient, SecureRecentBankEntity> {
    private final RecentRecipientEntityMapper recentRecipientEntityMapper;

    @Inject
    public RecentBankMapper(RecentRecipientEntityMapper recentRecipientEntityMapper) {
        this.recentRecipientEntityMapper = recentRecipientEntityMapper;
    }

    public SecureRecentBankEntity apply(RecentRecipientEntity recentRecipientEntity) {
        return map(this.recentRecipientEntityMapper.apply((RecentRecipientEntityMapper) recentRecipientEntity));
    }

    public List<SecureRecentBankEntity> apply(List<RecentRecipient> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (RecentRecipient recentRecipient : list) {
            if (recentRecipient.getType() == 1) {
                arrayList.add(map(recentRecipient));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public SecureRecentBankEntity map(RecentRecipient recentRecipient) {
        if (recentRecipient == null || TextUtils.isEmpty(recentRecipient.getCardIndexNo())) {
            return null;
        }
        SecureRecentBankEntity secureRecentBankEntity = new SecureRecentBankEntity(recentRecipient.getCardIndexNo());
        secureRecentBankEntity.setRecipientName(recentRecipient.getRecipientName());
        secureRecentBankEntity.setAlias(recentRecipient.getAlias());
        secureRecentBankEntity.setInstId(recentRecipient.getId());
        secureRecentBankEntity.setBankLogo(recentRecipient.getImageUrl());
        secureRecentBankEntity.setInstLocalName(recentRecipient.getInstLocalName());
        secureRecentBankEntity.setLastUpdated(recentRecipient.getLastUpdated());
        secureRecentBankEntity.setBankName(recentRecipient.getName());
        secureRecentBankEntity.setBankNumber(recentRecipient.getNumber());
        secureRecentBankEntity.setPayMethod(recentRecipient.getPayMethod());
        secureRecentBankEntity.setPayOption(recentRecipient.getPayOption());
        secureRecentBankEntity.setSenderName(recentRecipient.getSenderName());
        secureRecentBankEntity.setPrefix(recentRecipient.getPrefix());
        secureRecentBankEntity.setTransactionCount(recentRecipient.getTransactionCount());
        secureRecentBankEntity.setFavorite(recentRecipient.isFavorite());
        return secureRecentBankEntity;
    }

    public RecentBankRecipient getMaskingData(RecentBankRecipient recentBankRecipient) {
        recentBankRecipient.setNumber(recentBankRecipient.getFormattedMaskNumber());
        return recentBankRecipient;
    }
}
