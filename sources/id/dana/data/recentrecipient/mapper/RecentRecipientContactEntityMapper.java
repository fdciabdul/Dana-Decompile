package id.dana.data.recentrecipient.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentcontact.model.RecentContact;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RecentRecipientContactEntityMapper extends BaseMapper<List<RecentContact>, List<RecentRecipient>> {
    @Inject
    public RecentRecipientContactEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<RecentRecipient> map(List<RecentContact> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<RecentContact> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private RecentRecipient map(RecentContact recentContact) {
        if (recentContact != null) {
            RecentRecipient recentRecipient = new RecentRecipient();
            recentRecipient.setId(recentContact.getUserId());
            recentRecipient.setName(recentContact.getUserNickName());
            recentRecipient.setRecipientName(recentContact.getUserNickName());
            recentRecipient.setNumber(recentContact.getUserPhoneNumber());
            recentRecipient.setImageUrl(recentContact.getUserAvatar());
            recentRecipient.setLastUpdated(recentContact.getLastUpdated());
            recentRecipient.setType(0);
            return recentRecipient;
        }
        return null;
    }
}
