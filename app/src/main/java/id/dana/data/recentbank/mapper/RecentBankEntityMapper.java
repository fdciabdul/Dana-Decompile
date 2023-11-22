package id.dana.data.recentbank.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentbank.model.RecentBank;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RecentBankEntityMapper extends BaseMapper<List<SecureRecentBankEntity>, List<RecentBank>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public RecentBankEntityMapper() {
    }

    public RecentBank apply(RecentRecipientEntity recentRecipientEntity) {
        return map(recentRecipientEntity);
    }

    public SecureRecentBankEntity apply(RecentBank recentBank) {
        return map(recentBank);
    }

    @Override // id.dana.data.base.BaseMapper
    public List<RecentBank> apply(List<SecureRecentBankEntity> list) {
        return map(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<RecentBank> map(List<SecureRecentBankEntity> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (SecureRecentBankEntity secureRecentBankEntity : list) {
                if (isValidSecureRecentBank(secureRecentBankEntity.getCardIndexNo())) {
                    RecentBank recentBank = new RecentBank();
                    recentBank.setBankNumber(secureRecentBankEntity.getBankNumber());
                    recentBank.setBankName(secureRecentBankEntity.getBankName());
                    recentBank.setBankLogo(secureRecentBankEntity.getBankLogo());
                    recentBank.setAlias(secureRecentBankEntity.getAlias());
                    recentBank.setRecipientName(secureRecentBankEntity.getRecipientName());
                    recentBank.setLastUpdated(secureRecentBankEntity.getLastUpdated());
                    recentBank.setInstId(secureRecentBankEntity.getInstId());
                    recentBank.setInstLocalName(secureRecentBankEntity.getInstLocalName());
                    recentBank.setPayMethod(secureRecentBankEntity.getPayMethod());
                    recentBank.setPayOption(secureRecentBankEntity.getPayOption());
                    recentBank.setSenderName(secureRecentBankEntity.getSenderName());
                    recentBank.setCardIndexNo(secureRecentBankEntity.getCardIndexNo());
                    recentBank.setPrefix(secureRecentBankEntity.getPrefix());
                    recentBank.setTransactionCount(secureRecentBankEntity.getTransactionCount());
                    recentBank.setFavorite(secureRecentBankEntity.isFavorite());
                    arrayList.add(recentBank);
                }
            }
            return arrayList;
        }
        return null;
    }

    private SecureRecentBankEntity map(RecentBank recentBank) {
        if (recentBank != null) {
            SecureRecentBankEntity secureRecentBankEntity = new SecureRecentBankEntity(recentBank.getCardIndexNo());
            secureRecentBankEntity.setBankNumber(recentBank.getBankNumber());
            secureRecentBankEntity.setBankName(recentBank.getBankName());
            secureRecentBankEntity.setBankLogo(recentBank.getBankLogo());
            secureRecentBankEntity.setAlias(recentBank.getAlias());
            secureRecentBankEntity.setRecipientName(recentBank.getRecipientName());
            secureRecentBankEntity.setLastUpdated(recentBank.getLastUpdated());
            secureRecentBankEntity.setInstId(recentBank.getInstId());
            secureRecentBankEntity.setInstLocalName(recentBank.getInstLocalName());
            secureRecentBankEntity.setPayMethod(recentBank.getPayMethod());
            secureRecentBankEntity.setPayOption(recentBank.getPayOption());
            secureRecentBankEntity.setSenderName(recentBank.getSenderName());
            secureRecentBankEntity.setCardIndexNo(recentBank.getCardIndexNo());
            secureRecentBankEntity.setPrefix(recentBank.getPrefix());
            secureRecentBankEntity.setTransactionCount(recentBank.getTransactionCount());
            secureRecentBankEntity.setFavorite(recentBank.isFavorite());
            return secureRecentBankEntity;
        }
        return null;
    }

    private RecentBank map(RecentRecipientEntity recentRecipientEntity) {
        if (recentRecipientEntity != null) {
            RecentBank recentBank = new RecentBank();
            recentBank.setInstId(recentRecipientEntity.getId());
            recentBank.setAlias(recentRecipientEntity.getAlias());
            recentBank.setBankName(recentRecipientEntity.getRecipientName());
            recentBank.setRecipientName(recentRecipientEntity.getRecipientName());
            recentBank.setBankLogo(recentRecipientEntity.getImageUrl());
            recentBank.setBankNumber(recentRecipientEntity.getNumber());
            recentBank.setLastUpdated(recentRecipientEntity.getLastUpdated());
            recentBank.setInstLocalName(recentRecipientEntity.getInstLocalName());
            recentBank.setPayMethod(recentRecipientEntity.getPayMethod());
            recentBank.setPayOption(recentRecipientEntity.getPayOption());
            recentBank.setSenderName(recentRecipientEntity.getSenderName());
            recentBank.setCardIndexNo(recentRecipientEntity.getCardIndexNo());
            return recentBank;
        }
        return null;
    }

    private boolean isValidSecureRecentBank(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 16;
    }
}
