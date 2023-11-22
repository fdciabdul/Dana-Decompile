package id.dana.sendmoney_v2.recipient.decorator;

import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.decorator.recipient.Recipient;
import id.dana.sendmoney.recipient.decorator.recipient.RecipientDecorator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0006\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/recipient/decorator/SearchContactDecorator;", "Lid/dana/sendmoney/recipient/decorator/recipient/RecipientDecorator;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;", "", "", "(Ljava/lang/String;)Z", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/sendmoney/recipient/decorator/recipient/Recipient;Ljava/util/List;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchContactDecorator extends RecipientDecorator {
    private final List<RecipientViewModel> BuiltInFictitiousFunctionClassFactory;
    private final Recipient KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchContactDecorator(Recipient recipient, List<? extends RecipientViewModel> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipient;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.getAuthRequestContext = str;
        if (z) {
            String str2 = str;
            if (!(str2.length() > 0) || !list.isEmpty()) {
                if (str2.length() == 0) {
                    KClassImpl$Data$declaredNonStaticMembers$2(new RecipientViewModel(22));
                    return;
                }
                List<RecipientViewModel> mutableList = CollectionsKt.toMutableList((Collection) this.BuiltInFictitiousFunctionClassFactory);
                if ((!mutableList.isEmpty()) != false) {
                    mutableList.add(0, new RecipientViewModel(21));
                    PlaceComponentResult(mutableList);
                }
                getAuthRequestContext(mutableList);
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = this.getAuthRequestContext.length();
            if (8 <= length && length < 14) {
                if (new Regex("^(?:\\+?62|0)[2-9]\\d{0,11}$").matches(this.getAuthRequestContext)) {
                    arrayList.add(0, new RecipientViewModel(21));
                    PlaceComponentResult(arrayList);
                }
            }
            getAuthRequestContext(arrayList);
        }
    }

    private final List<RecipientViewModel> PlaceComponentResult(List<RecipientViewModel> list) {
        if (NumberUtils.isValidShowPhoneNumber(this.getAuthRequestContext) && !PlaceComponentResult(this.getAuthRequestContext)) {
            list.add(new RecipientViewModel(8, this.getAuthRequestContext));
        }
        return list;
    }

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        List<RecipientViewModel> list = this.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(list, "");
        KClassImpl$Data$declaredNonStaticMembers$2.addAll(list);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private final boolean PlaceComponentResult(String str) {
        List<RecipientViewModel> list = this.BuiltInFictitiousFunctionClassFactory;
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
}
