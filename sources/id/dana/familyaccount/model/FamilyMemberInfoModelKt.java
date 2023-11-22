package id.dana.familyaccount.model;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyMemberInfoModelKt {
    public static final boolean MyBillsEntityDataFactory(List<FamilyMemberInfoModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = ((FamilyMemberInfoModel) it.next()).MyBillsEntityDataFactory;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            if (Intrinsics.areEqual(upperCase, "MEMBER")) {
                z = true;
            }
        }
        return z;
    }
}
