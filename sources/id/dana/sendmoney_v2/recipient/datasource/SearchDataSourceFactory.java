package id.dana.sendmoney_v2.recipient.datasource;

import android.content.ContentResolver;
import androidx.paging.DataSource;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.contact.provider.ContactDataSource;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.contact.provider.NoContactDataSource;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney_v2.recipient.decorator.SearchBankDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchRecentRecipientDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchSectionDecorator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0005\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0012\u0010\u000b\u001a\u00020\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\b\u001a\u00020\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/SearchDataSourceFactory;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "", "PlaceComponentResult", "()Ljava/util/List;", "Lid/dana/sendmoney/contact/provider/NoContactDataSource;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/contact/provider/NoContactDataSource;", "p0", "", "(Ljava/util/List;)V", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "", "Lid/dana/sendmoney/model/RecentBankModel;", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/sendmoney/model/RecentRecipientModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SearchDataSourceFactory extends RecipientDataSourceFactory {
    public final ContentResolver BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<RecentBankModel> getAuthRequestContext;
    public boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<? extends RecentRecipientModel> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory
    public final void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0) {
    }

    private List<RecipientViewModel> PlaceComponentResult() {
        return new SearchBankDecorator(new SearchRecentRecipientDecorator(new SearchSectionDecorator(new Recipient(), false), this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.PlaceComponentResult), this.getAuthRequestContext, this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final NoContactDataSource MyBillsEntityDataFactory() {
        this.PlaceComponentResult = true;
        List<RecipientViewModel> PlaceComponentResult = PlaceComponentResult();
        PlaceComponentResult.add(new RecipientViewModel(22));
        return new NoContactDataSource(PlaceComponentResult);
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        if (!NumberUtils.isValidShowPhoneNumber(this.getAuthRequestContext)) {
            if (this.MyBillsEntityDataFactory) {
                if (!(this.getAuthRequestContext.length() > 0)) {
                    return MyBillsEntityDataFactory();
                }
                ContactProvider contactProvider = new ContactProvider(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
                if (contactProvider.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    return MyBillsEntityDataFactory();
                }
                this.PlaceComponentResult = false;
                List<RecipientViewModel> PlaceComponentResult = PlaceComponentResult();
                PlaceComponentResult.add(new RecipientViewModel(21, this.getAuthRequestContext));
                return new ContactDataSource(contactProvider, PlaceComponentResult, null, 0);
            }
            return new NoContactDataSource(PlaceComponentResult());
        }
        String str = this.getAuthRequestContext;
        this.PlaceComponentResult = false;
        List<RecipientViewModel> PlaceComponentResult2 = PlaceComponentResult();
        PlaceComponentResult2.add(new RecipientViewModel(21, str));
        PlaceComponentResult2.add(new RecipientViewModel(8, str));
        return new NoContactDataSource(PlaceComponentResult2);
    }
}
