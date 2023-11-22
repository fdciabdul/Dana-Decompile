package id.dana.data.recentrecipient.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import id.dana.domain.recentcontact.model.RecentContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RecentRecipientPayerEntityMapper extends BaseMapper<List<RecentPayerSplitBillEntity>, List<RecentContact>> {
    @Inject
    public RecentRecipientPayerEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<RecentContact> map(List<RecentPayerSplitBillEntity> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<RecentPayerSplitBillEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(map(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private RecentContact map(RecentPayerSplitBillEntity recentPayerSplitBillEntity) {
        RecentContact recentContact = new RecentContact();
        recentContact.setUserId(recentPayerSplitBillEntity.getUserId());
        recentContact.setLastUpdated(recentPayerSplitBillEntity.getLastUpdated());
        recentContact.setUserAvatar(recentPayerSplitBillEntity.getAvatar());
        if (!TextUtils.isEmpty(recentPayerSplitBillEntity.getUserNickname())) {
            recentContact.setUserNickName(recentPayerSplitBillEntity.getUserNickname());
        } else {
            recentContact.setUserNickName(recentPayerSplitBillEntity.getShownName());
        }
        if (!TextUtils.isEmpty(recentPayerSplitBillEntity.getUserPhoneNumber())) {
            recentContact.setUserPhoneNumber(recentPayerSplitBillEntity.getUserPhoneNumber());
        } else {
            recentContact.setUserPhoneNumber(recentPayerSplitBillEntity.getShownNumber());
        }
        return recentContact;
    }
}
