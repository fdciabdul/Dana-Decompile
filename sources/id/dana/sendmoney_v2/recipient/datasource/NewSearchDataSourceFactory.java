package id.dana.sendmoney_v2.recipient.datasource;

import androidx.paging.DataSource;
import id.dana.richview.contactselector.NewContactDataSource;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney_v2.recipient.decorator.SearchBankDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchContactDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchGroupSendDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchRecentRecipientDecorator;
import id.dana.sendmoney_v2.recipient.decorator.SearchSectionDecorator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/sendmoney_v2/recipient/datasource/NewSearchDataSourceFactory;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Landroidx/paging/DataSource;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "", "MyBillsEntityDataFactory", "()Ljava/util/List;", "p0", "", "(Ljava/util/List;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "getAuthRequestContext", "", "Z", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/model/RecentBankModel;", "Lid/dana/sendmoney/model/RecentRecipientModel;", "lookAheadTest", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSearchDataSourceFactory extends RecipientDataSourceFactory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<RecentBankModel> MyBillsEntityDataFactory = CollectionsKt.emptyList();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<? extends RecentRecipientModel> lookAheadTest = CollectionsKt.emptyList();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<? extends RecentRecipientModel> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public List<? extends RecipientViewModel> getAuthRequestContext = new ArrayList();

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, RecipientViewModel> BuiltInFictitiousFunctionClassFactory() {
        return new NewContactDataSource(new SearchBankDecorator(new SearchContactDecorator(new SearchGroupSendDecorator(new SearchRecentRecipientDecorator(new SearchSectionDecorator(new Recipient(), false), this.lookAheadTest, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory), this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext), MyBillsEntityDataFactory(), this.getAuthRequestContext, this.PlaceComponentResult), this.MyBillsEntityDataFactory, this.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(), null, false, 2, null);
    }

    @Override // id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory
    public final void BuiltInFictitiousFunctionClassFactory(List<RecipientViewModel> p0) {
        if (p0 != null) {
            this.getAuthRequestContext = p0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x008f, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r9, (java.lang.CharSequence) r11.getAuthRequestContext, true) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a4, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r11.getAuthRequestContext, false, 2, (java.lang.Object) null) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<id.dana.sendmoney.model.RecipientViewModel> MyBillsEntityDataFactory() {
        /*
            r11 = this;
            java.lang.String r0 = r11.getAuthRequestContext
            boolean r0 = id.dana.data.util.NumberUtils.isPhoneNumberPrefix(r0)
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            java.lang.String r5 = ""
            if (r0 == 0) goto L5c
            java.util.List<? extends id.dana.sendmoney.model.RecipientViewModel> r0 = r11.getAuthRequestContext
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r0 = r0.iterator()
        L1d:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L53
            java.lang.Object r7 = r0.next()
            r8 = r7
            id.dana.sendmoney.model.RecipientViewModel r8 = (id.dana.sendmoney.model.RecipientViewModel) r8
            java.lang.String r9 = r8.getErrorConfigVersion
            if (r9 == 0) goto L4c
            java.lang.String r8 = r8.getErrorConfigVersion
            java.lang.String r8 = id.dana.data.util.NumberUtils.replaceIndoPhoneNumberPrefixWithZero(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r9 = r11.getAuthRequestContext
            java.lang.String r9 = id.dana.data.util.NumberUtils.replaceIndoPhoneNumberPrefixWithZero(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r8 = kotlin.text.StringsKt.contains$default(r8, r9, r4, r2, r1)
            if (r8 == 0) goto L4c
            r8 = 1
            goto L4d
        L4c:
            r8 = 0
        L4d:
            if (r8 == 0) goto L1d
            r6.add(r7)
            goto L1d
        L53:
            java.util.List r6 = (java.util.List) r6
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r6)
            goto Lb7
        L5c:
            java.util.List<? extends id.dana.sendmoney.model.RecipientViewModel> r0 = r11.getAuthRequestContext
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto Laf
            java.lang.Object r7 = r0.next()
            r8 = r7
            id.dana.sendmoney.model.RecipientViewModel r8 = (id.dana.sendmoney.model.RecipientViewModel) r8
            java.lang.String r9 = r8.PlaceComponentResult()
            if (r9 == 0) goto L91
            java.lang.String r9 = r8.PlaceComponentResult()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = r11.getAuthRequestContext
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r9 = kotlin.text.StringsKt.contains(r9, r10, r3)
            if (r9 != 0) goto La6
        L91:
            java.lang.String r9 = r8.getErrorConfigVersion
            if (r9 == 0) goto La8
            java.lang.String r8 = r8.getErrorConfigVersion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r9 = r11.getAuthRequestContext
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r8 = kotlin.text.StringsKt.contains$default(r8, r9, r4, r2, r1)
            if (r8 == 0) goto La8
        La6:
            r8 = 1
            goto La9
        La8:
            r8 = 0
        La9:
            if (r8 == 0) goto L6b
            r6.add(r7)
            goto L6b
        Laf:
            java.util.List r6 = (java.util.List) r6
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r6)
        Lb7:
            boolean r1 = r0.isEmpty()
            r11.BuiltInFictitiousFunctionClassFactory = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.datasource.NewSearchDataSourceFactory.MyBillsEntityDataFactory():java.util.List");
    }
}
