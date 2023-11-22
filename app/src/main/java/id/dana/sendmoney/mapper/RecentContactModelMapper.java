package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.recentcontact.model.RecentContact;
import id.dana.sendmoney.model.RecentContactModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class RecentContactModelMapper extends BaseMapper<List<RecentContact>, List<RecentContactModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentContactModel> apply(List<RecentContact> list) {
        return PlaceComponentResult(list);
    }

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecentContactModel> map(List<RecentContact> list) {
        return PlaceComponentResult(list);
    }

    @Inject
    public RecentContactModelMapper() {
    }

    private static List<RecentContactModel> PlaceComponentResult(List<RecentContact> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (RecentContact recentContact : list) {
                RecentContactModel recentContactModel = new RecentContactModel();
                recentContactModel.MyBillsEntityDataFactory = recentContact.getUserId();
                recentContactModel.KClassImpl$Data$declaredNonStaticMembers$2 = recentContact.getUserNickName();
                recentContactModel.PlaceComponentResult = recentContact.getUserAvatar();
                recentContactModel.getErrorConfigVersion = recentContact.getUserPhoneNumber();
                recentContactModel.moveToNextValue = 2;
                arrayList.add(recentContactModel);
            }
            return arrayList;
        }
        return null;
    }
}
