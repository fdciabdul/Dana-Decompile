package id.dana.sendmoney_v2.recipient.datasource;

import android.content.ContentResolver;
import androidx.paging.DataSource;
import id.dana.R;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.contact.provider.ContactDataSource;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.NoContactDataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney_v2.recipient.decorator.SearchSectionDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SectionDecorator;
import id.dana.sendmoney_v2.recipient.model.EmptyStateViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\fR\u0011\u0010\b\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/ContactDataSourceFactory;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "", "MyBillsEntityDataFactory", "()Ljava/util/List;", "p0", "", "(Ljava/util/List;)V", "Landroid/content/ContentResolver;", "getAuthRequestContext", "Landroid/content/ContentResolver;", "", "Z", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ContactDataSourceFactory extends RecipientDataSourceFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ContentResolver MyBillsEntityDataFactory;

    @Override // id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory
    public final void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0) {
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult) {
            ContactProvider contactProvider = new ContactProvider(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
            if (getMyBillsEntityDataFactory() && this.BuiltInFictitiousFunctionClassFactory) {
                return new NoContactDataSource(CollectionsKt.emptyList());
            }
            if (contactProvider.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (!getMyBillsEntityDataFactory() || !NumberUtils.isValidShowPhoneNumber(this.getAuthRequestContext)) {
                    if (getMyBillsEntityDataFactory()) {
                        List<RecipientViewModel> MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                        MyBillsEntityDataFactory.add(new EmptyStateViewModel(4, R.drawable.res_0x7f0808e8_networkuserentitydata_externalsyntheticlambda5, R.string.contact_not_found_title, R.string.contact_not_found_desc, 0, false, 48, null));
                        return new NoContactDataSource(MyBillsEntityDataFactory);
                    }
                    List<RecipientViewModel> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
                    MyBillsEntityDataFactory2.add(new EmptyStateViewModel(19, R.drawable.res_0x7f0808e8_networkuserentitydata_externalsyntheticlambda5, R.string.contact_not_available_title, R.string.contact_not_available_desc, 0, false, 48, null));
                    return new NoContactDataSource(MyBillsEntityDataFactory2);
                }
                String str = this.getAuthRequestContext;
                List<RecipientViewModel> MyBillsEntityDataFactory3 = MyBillsEntityDataFactory();
                MyBillsEntityDataFactory3.add(new RecipientViewModel(8, str));
                return new NoContactDataSource(MyBillsEntityDataFactory3);
            }
            return new ContactDataSource(contactProvider, MyBillsEntityDataFactory(), null, 0);
        }
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = new Recipient().KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.add(new EmptyStateViewModel(5, R.drawable.res_0x7f0808e8_networkuserentitydata_externalsyntheticlambda5, R.string.contact_no_permission_title, R.string.contact_no_permission_desc, R.string.res_0x7f13050c_verifypinstatemanager_executeriskchallenge_2_2, true));
        return new NoContactDataSource(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private List<RecipientViewModel> MyBillsEntityDataFactory() {
        return new SectionDecorator(new SearchSectionDecorator(new Recipient(), getMyBillsEntityDataFactory()), 1, !getMyBillsEntityDataFactory(), this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
