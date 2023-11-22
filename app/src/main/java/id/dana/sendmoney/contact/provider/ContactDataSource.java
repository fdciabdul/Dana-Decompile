package id.dana.sendmoney.contact.provider;

import androidx.paging.PageKeyedDataSource;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.mapper.ContactToRecipientViewModelMapper;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactDataSource extends PageKeyedDataSource<Integer, RecipientViewModel> {
    private final ContactProvider MyBillsEntityDataFactory;
    private final List<String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ContactToRecipientViewModelMapper getAuthRequestContext = new ContactToRecipientViewModelMapper();
    private final int lookAheadTest;
    private final List<RecipientViewModel> moveToNextValue;

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadParams<Integer> loadParams, PageKeyedDataSource.LoadCallback<Integer, RecipientViewModel> loadCallback) {
    }

    public ContactDataSource(ContactProvider contactProvider, List<RecipientViewModel> list, List<String> list2, int i) {
        this.MyBillsEntityDataFactory = contactProvider;
        this.moveToNextValue = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = list2;
        this.lookAheadTest = i;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void PlaceComponentResult(PageKeyedDataSource.LoadInitialParams<Integer> loadInitialParams, PageKeyedDataSource.LoadInitialCallback<Integer, RecipientViewModel> loadInitialCallback) {
        List<RecipientViewModel> apply = this.getAuthRequestContext.apply(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(loadInitialParams.PlaceComponentResult, 0));
        KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, apply);
        apply.addAll(0, this.moveToNextValue);
        loadInitialCallback.MyBillsEntityDataFactory(apply, 1, 4);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PageKeyedDataSource.LoadParams<Integer> loadParams, PageKeyedDataSource.LoadCallback<Integer, RecipientViewModel> loadCallback) {
        int i = 0;
        int intValue = (loadParams.KClassImpl$Data$declaredNonStaticMembers$2 * (loadParams.MyBillsEntityDataFactory.intValue() - 1)) + 0 + 1;
        List<RecipientViewModel> apply = this.getAuthRequestContext.apply(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(loadParams.KClassImpl$Data$declaredNonStaticMembers$2, intValue));
        KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, apply);
        while (apply.isEmpty() && PlaceComponentResult(intValue, loadParams.KClassImpl$Data$declaredNonStaticMembers$2)) {
            i++;
            intValue = (loadParams.KClassImpl$Data$declaredNonStaticMembers$2 * ((loadParams.MyBillsEntityDataFactory.intValue() - 1) + i)) + 1;
            apply.clear();
            apply = this.getAuthRequestContext.apply(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(loadParams.KClassImpl$Data$declaredNonStaticMembers$2, intValue));
            KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest, apply);
        }
        if (!apply.isEmpty()) {
            loadCallback.getAuthRequestContext(apply, Integer.valueOf(loadParams.MyBillsEntityDataFactory.intValue() + 1 + i));
        } else {
            loadCallback.getAuthRequestContext(apply, null);
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(RecipientViewModel recipientViewModel, List<String> list) {
        for (String str : list) {
            if (NumberUtils.getClearPhoneNumber(recipientViewModel.getErrorConfigVersion).equals(str) || recipientViewModel.getErrorConfigVersion.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i, List<RecipientViewModel> list) {
        if (i == 1) {
            if (getAuthRequestContext()) {
                ArrayList arrayList = new ArrayList();
                for (RecipientViewModel recipientViewModel : list) {
                    if (!BuiltInFictitiousFunctionClassFactory(recipientViewModel, this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        arrayList.add(recipientViewModel);
                    }
                }
                list.removeAll(arrayList);
            }
        } else if (i == 2 && getAuthRequestContext()) {
            ArrayList arrayList2 = new ArrayList();
            for (RecipientViewModel recipientViewModel2 : list) {
                if (BuiltInFictitiousFunctionClassFactory(recipientViewModel2, this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                    arrayList2.add(recipientViewModel2);
                }
                if (!NumberUtils.isValidIndoPhoneNumber(recipientViewModel2.getErrorConfigVersion)) {
                    arrayList2.add(recipientViewModel2);
                }
            }
            list.removeAll(arrayList2);
        }
    }

    private boolean PlaceComponentResult(int i, int i2) {
        return i + i2 < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }

    private boolean getAuthRequestContext() {
        List<String> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
