package id.dana.globalsearch.mapper;

import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.globalsearch.model.RecentAutoComplete;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\b0\u00002\u0006\u0010\u0004\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "", "Lid/dana/globalsearch/model/RecentAutoComplete;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Ljava/util/List;)V", "", "p1", "getAuthRequestContext", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertDataToRecentAutoCompleteKt {
    public static final void getAuthRequestContext(List<String> list, String str, List<RecentAutoComplete> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list2, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (StringsKt.contains$default((CharSequence) ((String) obj), (CharSequence) str, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            list2.add(new RecentAutoComplete((String) it.next(), null, "RECENT", 2, null));
        }
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(List<PaySearchInfo> list, List<RecentAutoComplete> list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        for (PaySearchInfo paySearchInfo : list) {
            list2.add(new RecentAutoComplete(paySearchInfo.getName(), paySearchInfo.getCategory(), "AUTOCOMPLETE"));
        }
    }
}
