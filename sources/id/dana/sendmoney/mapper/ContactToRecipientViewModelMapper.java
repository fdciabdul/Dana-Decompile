package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.sendmoney.contact.provider.ContactModel;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactToRecipientViewModelMapper extends BaseMapper<List<ContactModel>, List<RecipientViewModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<RecipientViewModel> map(List<ContactModel> list) {
        RecipientViewModel recipientViewModel;
        ArrayList arrayList = new ArrayList();
        for (ContactModel contactModel : list) {
            if (contactModel != null) {
                recipientViewModel = new RecipientViewModel(3);
                recipientViewModel.MyBillsEntityDataFactory = contactModel.getErrorConfigVersion;
                recipientViewModel.scheduleImpl = contactModel.KClassImpl$Data$declaredNonStaticMembers$2;
                recipientViewModel.getErrorConfigVersion = contactModel.getErrorConfigVersion;
                recipientViewModel.PlaceComponentResult = contactModel.PlaceComponentResult;
            } else {
                recipientViewModel = null;
            }
            arrayList.add(recipientViewModel);
        }
        return arrayList;
    }
}
