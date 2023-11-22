package id.dana.sync_engine.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lid/dana/sync_engine/domain/model/UserContact;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserContactKt {
    public static final List<UserContact> MyBillsEntityDataFactory(List<UserContact> list, List<String> list2) {
        boolean z;
        UserContact BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        List<UserContact> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (UserContact userContact : list3) {
            List<String> list4 = list2;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator<T> it = list4.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), userContact.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                BuiltInFictitiousFunctionClassFactory = UserContact.BuiltInFictitiousFunctionClassFactory(userContact, Boolean.TRUE);
            } else {
                BuiltInFictitiousFunctionClassFactory = UserContact.BuiltInFictitiousFunctionClassFactory(userContact, Boolean.FALSE);
            }
            arrayList.add(BuiltInFictitiousFunctionClassFactory);
        }
        return arrayList;
    }
}
