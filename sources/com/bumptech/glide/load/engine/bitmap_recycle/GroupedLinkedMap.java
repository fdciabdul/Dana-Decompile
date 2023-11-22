package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedEntry<>();
    private final Map<K, LinkedEntry<K, V>> getAuthRequestContext = new HashMap();

    public final void MyBillsEntityDataFactory(K k, V v) {
        LinkedEntry<K, V> linkedEntry = this.getAuthRequestContext.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k);
            KClassImpl$Data$declaredNonStaticMembers$2(linkedEntry);
            this.getAuthRequestContext.put(k, linkedEntry);
        } else {
            k.BuiltInFictitiousFunctionClassFactory();
        }
        if (linkedEntry.PlaceComponentResult == null) {
            linkedEntry.PlaceComponentResult = new ArrayList();
        }
        linkedEntry.PlaceComponentResult.add(v);
    }

    public final V getAuthRequestContext(K k) {
        LinkedEntry<K, V> linkedEntry = this.getAuthRequestContext.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k);
            this.getAuthRequestContext.put(k, linkedEntry);
        } else {
            k.BuiltInFictitiousFunctionClassFactory();
        }
        MyBillsEntityDataFactory(linkedEntry);
        List<V> list = linkedEntry.PlaceComponentResult;
        int size = list != null ? list.size() : 0;
        if (size > 0) {
            return linkedEntry.PlaceComponentResult.remove(size - 1);
        }
        return null;
    }

    public final V PlaceComponentResult() {
        LinkedEntry linkedEntry = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        while (true) {
            if (linkedEntry.equals(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return null;
            }
            List<V> list = linkedEntry.PlaceComponentResult;
            int size = list != null ? list.size() : 0;
            V remove = size > 0 ? linkedEntry.PlaceComponentResult.remove(size - 1) : null;
            if (remove != null) {
                return remove;
            }
            linkedEntry.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2;
            linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = linkedEntry.getAuthRequestContext;
            this.getAuthRequestContext.remove(linkedEntry.BuiltInFictitiousFunctionClassFactory);
            ((Poolable) linkedEntry.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory();
            linkedEntry = linkedEntry.getAuthRequestContext;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (LinkedEntry linkedEntry = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2; !linkedEntry.equals(this.KClassImpl$Data$declaredNonStaticMembers$2); linkedEntry = linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2) {
            z = true;
            sb.append('{');
            sb.append(linkedEntry.BuiltInFictitiousFunctionClassFactory);
            sb.append(':');
            List<V> list = linkedEntry.PlaceComponentResult;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class LinkedEntry<K, V> {
        final K BuiltInFictitiousFunctionClassFactory;
        LinkedEntry<K, V> KClassImpl$Data$declaredNonStaticMembers$2;
        List<V> PlaceComponentResult;
        LinkedEntry<K, V> getAuthRequestContext;

        LinkedEntry() {
            this(null);
        }

        LinkedEntry(K k) {
            this.getAuthRequestContext = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            this.BuiltInFictitiousFunctionClassFactory = k;
        }
    }

    private void MyBillsEntityDataFactory(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = linkedEntry.getAuthRequestContext;
        linkedEntry.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = linkedEntry;
        linkedEntry.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = linkedEntry;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = linkedEntry.getAuthRequestContext;
        linkedEntry.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        linkedEntry.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = linkedEntry;
        linkedEntry.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = linkedEntry;
    }
}
