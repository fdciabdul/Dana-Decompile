package id.dana.sendmoney.ui.globalsend.landing;

import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendSortRecipientExtKt {
    public static final List<BeneficiaryInfoModel> MyBillsEntityDataFactory(List<BeneficiaryInfoModel> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, "ALPHABET")) {
            final Comparator<String> case_insensitive_order = StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE);
            return CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.sendmoney.ui.globalsend.landing.GlobalSendSortRecipientExtKt$sortRecipientBy$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return case_insensitive_order.compare(((BeneficiaryInfoModel) t).NetworkUserEntityData$$ExternalSyntheticLambda2, ((BeneficiaryInfoModel) t2).NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
            }));
        } else if (Intrinsics.areEqual(str, "RECENT")) {
            return CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.sendmoney.ui.globalsend.landing.GlobalSendSortRecipientExtKt$sortRecipientBy$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((BeneficiaryInfoModel) t2).DatabaseTableConfigUtil), Long.valueOf(((BeneficiaryInfoModel) t).DatabaseTableConfigUtil));
                }
            }));
        } else {
            return new ArrayList();
        }
    }
}
