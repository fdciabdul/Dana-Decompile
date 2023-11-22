package id.dana.data.recentrecipient.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentbank.model.RecentBank;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class RecentRecipientBankEntityMapper extends BaseMapper<List<RecentBank>, List<RecentRecipient>> {
    @Inject
    public RecentRecipientBankEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<RecentRecipient> map(List<RecentBank> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<RecentBank> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private RecentRecipient map(RecentBank recentBank) {
        if (recentBank != null) {
            RecentRecipient recentRecipient = new RecentRecipient();
            recentRecipient.setId(recentBank.getInstId());
            recentRecipient.setName(recentBank.getRecipientName());
            recentRecipient.setImageUrl(recentBank.getBankLogo());
            recentRecipient.setNumber(recentBank.getBankNumber());
            recentRecipient.setAlias(recentBank.getAlias());
            recentRecipient.setRecipientName(recentBank.getRecipientName());
            recentRecipient.setSenderName(recentBank.getSenderName());
            recentRecipient.setLastUpdated(recentBank.getLastUpdated());
            recentRecipient.setInstLocalName(recentBank.getInstLocalName());
            recentRecipient.setPayMethod(recentBank.getPayMethod());
            recentRecipient.setPayOption(recentBank.getPayOption());
            recentRecipient.setType(1);
            recentRecipient.setPrefix(recentBank.getPrefix());
            return recentRecipient;
        }
        return null;
    }
}
