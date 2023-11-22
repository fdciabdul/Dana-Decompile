package id.dana.sendmoney_v2.recipient.datasource;

import android.content.ContentResolver;
import androidx.paging.DataSource;
import id.dana.sendmoney.contact.provider.NoContactDataSource;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney_v2.recipient.decorator.BankDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchSectionDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SectionDecorator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\f\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/BankDataSourceFactory;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "", "p0", "", "(Ljava/util/List;)V", "Landroid/content/ContentResolver;", "PlaceComponentResult", "Landroid/content/ContentResolver;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Z", "", "Lid/dana/sendmoney/model/RecentBankModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "<init>", "(Landroid/content/ContentResolver;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankDataSourceFactory extends RecipientDataSourceFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<RecentBankModel> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ContentResolver KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory
    public final void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0) {
    }

    public BankDataSourceFactory(ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = contentResolver;
        this.getAuthRequestContext = CollectionsKt.emptyList();
    }

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        return new NoContactDataSource(new BankDecorator(new SectionDecorator(new SearchSectionDecorator(new Recipient(), false), 10, false, this.getAuthRequestContext), this.getAuthRequestContext, getMyBillsEntityDataFactory(), this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
