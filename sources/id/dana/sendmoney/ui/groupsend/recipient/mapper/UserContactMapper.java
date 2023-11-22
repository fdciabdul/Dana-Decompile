package id.dana.sendmoney.ui.groupsend.recipient.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sync_engine.domain.model.UserContact;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/mapper/UserContactMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserContactMapper extends BaseMapper<List<UserContact>, List<RecipientViewModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<RecipientViewModel> map(List<UserContact> list) {
        ArrayList arrayList;
        List<UserContact> list2 = list;
        if (list2 != null) {
            List<UserContact> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (UserContact userContact : list3) {
                RecipientViewModel recipientViewModel = new RecipientViewModel(3);
                recipientViewModel.PlaceComponentResult = String.valueOf(userContact.KClassImpl$Data$declaredNonStaticMembers$2);
                String str = userContact.scheduleImpl;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                recipientViewModel.initRecordTimeStamp = str;
                recipientViewModel.DatabaseTableConfigUtil = NumberUtils.getCleanSpaceAndDash(userContact.lookAheadTest);
                Boolean bool = userContact.BuiltInFictitiousFunctionClassFactory;
                recipientViewModel.moveToNextValue = bool != null ? bool.booleanValue() : false;
                Long l = userContact.getErrorConfigVersion;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = l != null ? l.longValue() : 0L;
                String str3 = userContact.getAuthRequestContext;
                if (str3 != null) {
                    str2 = str3;
                }
                recipientViewModel.scheduleImpl = str2;
                arrayList2.add(recipientViewModel);
            }
            arrayList = arrayList2;
        } else {
            arrayList = new ArrayList();
        }
        return TypeIntrinsics.asMutableList(arrayList);
    }

    @Inject
    public UserContactMapper() {
    }
}
