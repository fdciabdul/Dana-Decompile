package id.dana.sendmoney.ui.groupsend.recipient.datasource;

import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.ui.groupsend.recipient.model.Recipient;
import id.dana.sendmoney.ui.groupsend.recipient.model.decorator.SearchDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.model.decorator.SectionDecorator;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\b\u001a\u00020\n*\u00020\fH\u0002¢\u0006\u0004\b\b\u0010\u0015R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/datasource/ContactDataSourceFactoryV3;", "Lid/dana/sendmoney/ui/groupsend/recipient/datasource/RecipientDataSourceFactoryV3;", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "PlaceComponentResult", "()Landroidx/paging/PagingSource;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "p0", "", "p1", "p2", "p3", "", "p4", "", "getAuthRequestContext", "(ZLjava/lang/String;ZZLjava/util/List;)V", "(Ljava/lang/String;)Z", "Ljava/util/List;", "MyBillsEntityDataFactory", "Z", "BuiltInFictitiousFunctionClassFactory", "<init>", "(ZZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactDataSourceFactoryV3 extends RecipientDataSourceFactoryV3 {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private List<? extends RecipientViewModel> getAuthRequestContext;

    public ContactDataSourceFactoryV3() {
        this(false, false, null, 7, null);
    }

    public /* synthetic */ ContactDataSourceFactoryV3(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    private ContactDataSourceFactoryV3(boolean z, boolean z2, List<? extends RecipientViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.PlaceComponentResult = z2;
        this.getAuthRequestContext = list;
    }

    public final void getAuthRequestContext(boolean p0, String p1, boolean p2, boolean p3, List<? extends RecipientViewModel> p4) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p4, "");
        BuiltInFictitiousFunctionClassFactory(p0);
        PlaceComponentResult(p1);
        this.BuiltInFictitiousFunctionClassFactory = p2;
        this.PlaceComponentResult = p3;
        this.getAuthRequestContext = p4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b0, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r9, (java.lang.CharSequence) getBuiltInFictitiousFunctionClassFactory(), true) == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00c7, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) getBuiltInFictitiousFunctionClassFactory(), false, 2, (java.lang.Object) null) != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00c9, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x003e A[SYNTHETIC] */
    @Override // id.dana.sendmoney.ui.groupsend.recipient.datasource.RecipientDataSourceFactoryV3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.paging.PagingSource<java.lang.Integer, id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel> PlaceComponentResult() {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.recipient.datasource.ContactDataSourceFactoryV3.PlaceComponentResult():androidx.paging.PagingSource");
    }

    private List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        return new SectionDecorator(new SearchDecorator(new Recipient(), getMyBillsEntityDataFactory()), 1, !getMyBillsEntityDataFactory(), getBuiltInFictitiousFunctionClassFactory()).MyBillsEntityDataFactory();
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        List<? extends RecipientViewModel> list = this.getAuthRequestContext;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(NumberUtils.replaceIndoPhoneNumberPrefixWithZero(((RecipientViewModel) it.next()).DatabaseTableConfigUtil), NumberUtils.replaceIndoPhoneNumberPrefixWithZero(str))) {
                return true;
            }
        }
        return false;
    }
}
