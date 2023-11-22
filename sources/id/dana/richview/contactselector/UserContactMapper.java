package id.dana.richview.contactselector;

import id.dana.data.base.BaseMapper;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sync_engine.domain.model.UserContact;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/richview/contactselector/UserContactMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "Lid/dana/sendmoney/model/RecipientViewModel;", "p0", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserContactMapper extends BaseMapper<List<UserContact>, List<RecipientViewModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<RecipientViewModel> map(List<UserContact> list) {
        return getAuthRequestContext(list);
    }

    @Inject
    public UserContactMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<RecipientViewModel> getAuthRequestContext(List<UserContact> p0) {
        ArrayList arrayList;
        if (p0 != null) {
            List<UserContact> list = p0;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (UserContact userContact : list) {
                RecipientViewModel recipientViewModel = new RecipientViewModel(3);
                recipientViewModel.MyBillsEntityDataFactory = String.valueOf(userContact.KClassImpl$Data$declaredNonStaticMembers$2);
                String str = userContact.scheduleImpl;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                recipientViewModel.scheduleImpl = str;
                recipientViewModel.getErrorConfigVersion = NumberUtils.getCleanSpaceAndDash(userContact.lookAheadTest);
                Boolean bool = userContact.BuiltInFictitiousFunctionClassFactory;
                recipientViewModel.KClassImpl$Data$declaredNonStaticMembers$2 = bool != null ? bool.booleanValue() : false;
                Long l = userContact.getErrorConfigVersion;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = l != null ? l.longValue() : 0L;
                String str3 = userContact.getAuthRequestContext;
                if (str3 != null) {
                    str2 = str3;
                }
                recipientViewModel.PlaceComponentResult = str2;
                arrayList2.add(recipientViewModel);
            }
            arrayList = arrayList2;
        } else {
            arrayList = new ArrayList();
        }
        return TypeIntrinsics.asMutableList(arrayList);
    }
}
