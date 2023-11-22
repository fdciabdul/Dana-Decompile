package id.dana.sendmoney_v2.recipient.datasource;

import androidx.paging.DataSource;
import id.dana.R;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.contact.provider.NoContactDataSource;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney_v2.recipient.decorator.SearchSectionDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SectionDecorator;
import id.dana.sendmoney_v2.recipient.model.EmptyStateViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006*\u00020\u00040\u00040\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0005\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0007\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0012\u0010\u0012\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/NewContactDataSourceFactory;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "p0", "", "(Ljava/util/List;)V", "", "", "(Ljava/lang/String;)Z", "", "getAuthRequestContext", "Ljava/util/List;", "Z", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewContactDataSourceFactory extends RecipientDataSourceFactory {
    public boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<? extends RecipientViewModel> BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        if (this.MyBillsEntityDataFactory) {
            return MyBillsEntityDataFactory();
        }
        if (this.getAuthRequestContext.length() > 0) {
            return MyBillsEntityDataFactory();
        }
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = new Recipient().KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.add(new EmptyStateViewModel(5, R.drawable.res_0x7f0808e8_networkuserentitydata_externalsyntheticlambda5, R.string.contact_no_permission_title, R.string.contact_no_permission_desc, R.string.res_0x7f13050c_verifypinstatemanager_executeriskchallenge_2_2, true));
        return new NoContactDataSource(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        return new SectionDecorator(new SearchSectionDecorator(new Recipient(), getMyBillsEntityDataFactory()), 1, !getMyBillsEntityDataFactory(), this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory
    public final void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0) {
        if (p0 != null) {
            this.BuiltInFictitiousFunctionClassFactory = p0;
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        List<? extends RecipientViewModel> list = this.BuiltInFictitiousFunctionClassFactory;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(NumberUtils.replaceIndoPhoneNumberPrefixWithZero(((RecipientViewModel) it.next()).getErrorConfigVersion), NumberUtils.replaceIndoPhoneNumberPrefixWithZero(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x00a9, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r9, (java.lang.CharSequence) r11.getAuthRequestContext, true) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00be, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r11.getAuthRequestContext, false, 2, (java.lang.Object) null) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00c0, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.paging.DataSource<java.lang.Integer, id.dana.sendmoney.model.RecipientViewModel> MyBillsEntityDataFactory() {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.datasource.NewContactDataSourceFactory.MyBillsEntityDataFactory():androidx.paging.DataSource");
    }
}
