package id.dana.richview.contactselector;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import androidx.paging.DataSource;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.contact.provider.ContactDataSource;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.NoContactDataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactDataSourceFactory extends DataSource.Factory<Integer, RecipientViewModel> {
    String BuiltInFictitiousFunctionClassFactory;
    List<String> KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory = true;
    boolean PlaceComponentResult;
    int getAuthRequestContext;
    private final ContentResolver moveToNextValue;
    private boolean scheduleImpl;

    public ContactDataSourceFactory(Context context) {
        this.moveToNextValue = context.getContentResolver();
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult) {
            ContactProvider contactProvider = new ContactProvider(this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory);
            this.scheduleImpl = contactProvider.KClassImpl$Data$declaredNonStaticMembers$2();
            if (contactProvider.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (NumberUtils.isValidIndoPhoneNumber(this.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory) {
                    return getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
                }
                List<RecipientViewModel> authRequestContext = getAuthRequestContext();
                authRequestContext.add(new RecipientViewModel(4));
                return new NoContactDataSource(authRequestContext);
            }
            return new ContactDataSource(contactProvider, getAuthRequestContext(), this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
        } else if (NumberUtils.isValidIndoPhoneNumber(this.BuiltInFictitiousFunctionClassFactory)) {
            return getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        } else {
            List<RecipientViewModel> authRequestContext2 = getAuthRequestContext();
            authRequestContext2.add(new RecipientViewModel(5));
            return new NoContactDataSource(authRequestContext2);
        }
    }

    private NoContactDataSource getAuthRequestContext(String str) {
        List<RecipientViewModel> authRequestContext = getAuthRequestContext();
        RecipientViewModel recipientViewModel = new RecipientViewModel(8);
        recipientViewModel.getErrorConfigVersion = str;
        authRequestContext.add(recipientViewModel);
        return new NoContactDataSource(authRequestContext);
    }

    private List<RecipientViewModel> getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RecipientViewModel(15));
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            arrayList.add(new RecipientViewModel(7));
        }
        if (this.MyBillsEntityDataFactory) {
            if (!this.scheduleImpl) {
                arrayList.add(new RecipientViewModel(1, this.BuiltInFictitiousFunctionClassFactory));
            }
            if (TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                arrayList.add(new RecipientViewModel(11));
            }
        }
        return arrayList;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return !TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory);
    }
}
