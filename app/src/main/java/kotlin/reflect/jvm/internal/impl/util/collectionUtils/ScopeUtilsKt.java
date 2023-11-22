package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* loaded from: classes.dex */
public final class ScopeUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        SmartList<MemberScope> smartList = new SmartList<>();
        for (MemberScope memberScope : iterable) {
            MemberScope memberScope2 = memberScope;
            if ((memberScope2 == null || memberScope2 == MemberScope.Empty.INSTANCE) ? false : true) {
                smartList.add(memberScope);
            }
        }
        return smartList;
    }
}
