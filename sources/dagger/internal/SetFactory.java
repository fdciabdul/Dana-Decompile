package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> getAuthRequestContext = InstanceFactory.MyBillsEntityDataFactory(Collections.emptySet());
    private final List<Provider<Collection<T>>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final List<Provider<T>> MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    public static final class Builder<T> {
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        int size = this.MyBillsEntityDataFactory.size();
        ArrayList arrayList = new ArrayList(this.KClassImpl$Data$declaredNonStaticMembers$2.size());
        int size2 = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet MyBillsEntityDataFactory = DaggerCollections.MyBillsEntityDataFactory(size);
        int size3 = this.MyBillsEntityDataFactory.size();
        for (int i2 = 0; i2 < size3; i2++) {
            MyBillsEntityDataFactory.add(Preconditions.getAuthRequestContext(this.MyBillsEntityDataFactory.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            Iterator it = ((Collection) arrayList.get(i3)).iterator();
            while (it.hasNext()) {
                MyBillsEntityDataFactory.add(Preconditions.getAuthRequestContext(it.next()));
            }
        }
        return Collections.unmodifiableSet(MyBillsEntityDataFactory);
    }
}
