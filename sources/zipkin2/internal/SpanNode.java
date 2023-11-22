package zipkin2.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import zipkin2.Endpoint;
import zipkin2.Span;

/* loaded from: classes9.dex */
public final class SpanNode {
    static final Comparator<SpanNode> BuiltInFictitiousFunctionClassFactory = new Comparator<SpanNode>() { // from class: zipkin2.internal.SpanNode.1
        @Override // java.util.Comparator
        public /* synthetic */ int compare(SpanNode spanNode, SpanNode spanNode2) {
            long timestampAsLong = spanNode.KClassImpl$Data$declaredNonStaticMembers$2.timestampAsLong();
            long timestampAsLong2 = spanNode2.KClassImpl$Data$declaredNonStaticMembers$2.timestampAsLong();
            if (timestampAsLong < timestampAsLong2) {
                return -1;
            }
            return timestampAsLong == timestampAsLong2 ? 0 : 1;
        }
    };
    @Nullable
    Span KClassImpl$Data$declaredNonStaticMembers$2;
    List<SpanNode> MyBillsEntityDataFactory;
    @Nullable
    SpanNode getAuthRequestContext;

    public static Builder PlaceComponentResult(Logger logger) {
        return new Builder(logger);
    }

    /* loaded from: classes9.dex */
    static final class BreadthFirstIterator implements Iterator<SpanNode>, j$.util.Iterator {
        final ArrayDeque<SpanNode> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super SpanNode> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public final /* synthetic */ SpanNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            SpanNode remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove();
            int size = remove.MyBillsEntityDataFactory.size();
            for (int i = 0; i < size; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(remove.MyBillsEntityDataFactory.get(i));
            }
            return remove;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Builder {
        final Logger BuiltInFictitiousFunctionClassFactory;
        SpanNode getAuthRequestContext = null;
        Map<Object, SpanNode> MyBillsEntityDataFactory = new LinkedHashMap();
        Map<Object, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

        Builder(Logger logger) {
            this.BuiltInFictitiousFunctionClassFactory = logger;
        }
    }

    /* loaded from: classes9.dex */
    static final class SharedKey {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        @Nullable
        final Endpoint MyBillsEntityDataFactory;

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SharedKey{id=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", endpoint=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("}");
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SharedKey) {
                SharedKey sharedKey = (SharedKey) obj;
                return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(sharedKey.KClassImpl$Data$declaredNonStaticMembers$2) && getAuthRequestContext(this.MyBillsEntityDataFactory, sharedKey.MyBillsEntityDataFactory);
            }
            return false;
        }

        private static boolean getAuthRequestContext(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        public final int hashCode() {
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            Endpoint endpoint = this.MyBillsEntityDataFactory;
            return ((hashCode ^ 1000003) * 1000003) ^ (endpoint == null ? 0 : endpoint.hashCode());
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int size = this.MyBillsEntityDataFactory.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.MyBillsEntityDataFactory.get(i).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SpanNode{parent=");
        SpanNode spanNode = this.getAuthRequestContext;
        sb.append(spanNode != null ? spanNode.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        sb.append(", span=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", children=");
        sb.append(arrayList);
        sb.append("}");
        return sb.toString();
    }
}
