package com.airbnb.lottie.parser.moshi;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        public /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    Node<K, V>[] table;
    int threshold;

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 ^ (i2 >>> 7)) ^ (i2 >>> 4);
    }

    LinkedHashTreeMap() {
        this(null);
    }

    LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new Node<>();
        this.table = new Node[16];
        this.threshold = 12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.scheduleImpl;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        Node<K, V> find = find(k, true);
        V v2 = find.scheduleImpl;
        find.scheduleImpl = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        Node<K, V> node2 = node.PlaceComponentResult;
        while (node2 != node) {
            Node<K, V> node3 = node2.PlaceComponentResult;
            node2.lookAheadTest = null;
            node2.PlaceComponentResult = null;
            node2 = node3;
        }
        node.lookAheadTest = node;
        node.PlaceComponentResult = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.scheduleImpl;
        }
        return null;
    }

    final Node<K, V> find(K k, boolean z) {
        Node<K, V> node;
        int i;
        Node<K, V> node2;
        int compare;
        Comparator<? super K> comparator = this.comparator;
        Node<K, V>[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(node3.getAuthRequestContext);
                } else {
                    compare = comparator.compare(k, (K) node3.getAuthRequestContext);
                }
                if (compare != 0) {
                    Node<K, V> node4 = compare < 0 ? node3.BuiltInFictitiousFunctionClassFactory : node3.getErrorConfigVersion;
                    if (node4 == null) {
                        node = node3;
                        i = compare;
                        break;
                    }
                    node3 = node4;
                } else {
                    return node3;
                }
            }
        } else {
            node = node3;
            i = 0;
        }
        if (z) {
            Node<K, V> node5 = this.header;
            if (node == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(k.getClass().getName());
                    sb.append(" is not Comparable");
                    throw new ClassCastException(sb.toString());
                }
                node2 = new Node<>(node, k, secondaryHash, node5, node5.lookAheadTest);
                nodeArr[length] = node2;
            } else {
                node2 = new Node<>(node, k, secondaryHash, node5, node5.lookAheadTest);
                if (i < 0) {
                    node.BuiltInFictitiousFunctionClassFactory = node2;
                } else {
                    node.getErrorConfigVersion = node2;
                }
                rebalance(node, true);
            }
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 > this.threshold) {
                doubleCapacity();
            }
            this.modCount++;
            return node2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final Node<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    final Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.scheduleImpl, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    final void removeInternal(Node<K, V> node, boolean z) {
        Node<K, V> node2;
        Node<K, V> node3;
        int i;
        if (z) {
            node.lookAheadTest.PlaceComponentResult = node.PlaceComponentResult;
            node.PlaceComponentResult.lookAheadTest = node.lookAheadTest;
            node.lookAheadTest = null;
            node.PlaceComponentResult = null;
        }
        Node<K, V> node4 = node.BuiltInFictitiousFunctionClassFactory;
        Node<K, V> node5 = node.getErrorConfigVersion;
        Node<K, V> node6 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i2 = 0;
        if (node4 != null && node5 != null) {
            if (node4.KClassImpl$Data$declaredNonStaticMembers$2 > node5.KClassImpl$Data$declaredNonStaticMembers$2) {
                Node<K, V> node7 = node4.getErrorConfigVersion;
                while (true) {
                    Node<K, V> node8 = node7;
                    node3 = node4;
                    node4 = node8;
                    if (node4 == null) {
                        break;
                    }
                    node7 = node4.getErrorConfigVersion;
                }
            } else {
                Node<K, V> node9 = node5.BuiltInFictitiousFunctionClassFactory;
                while (true) {
                    node2 = node5;
                    node5 = node9;
                    if (node5 == null) {
                        break;
                    }
                    node9 = node5.BuiltInFictitiousFunctionClassFactory;
                }
                node3 = node2;
            }
            removeInternal(node3, false);
            Node<K, V> node10 = node.BuiltInFictitiousFunctionClassFactory;
            if (node10 != null) {
                i = node10.KClassImpl$Data$declaredNonStaticMembers$2;
                node3.BuiltInFictitiousFunctionClassFactory = node10;
                node10.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
                node.BuiltInFictitiousFunctionClassFactory = null;
            } else {
                i = 0;
            }
            Node<K, V> node11 = node.getErrorConfigVersion;
            if (node11 != null) {
                i2 = node11.KClassImpl$Data$declaredNonStaticMembers$2;
                node3.getErrorConfigVersion = node11;
                node11.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
                node.getErrorConfigVersion = null;
            }
            node3.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(i, i2) + 1;
            replaceInParent(node, node3);
            return;
        }
        if (node4 != null) {
            replaceInParent(node, node4);
            node.BuiltInFictitiousFunctionClassFactory = null;
        } else if (node5 != null) {
            replaceInParent(node, node5);
            node.getErrorConfigVersion = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node6, false);
        this.size--;
        this.modCount++;
    }

    final Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
        node.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        if (node2 != null) {
            node2.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
        }
        if (node3 != null) {
            if (node3.BuiltInFictitiousFunctionClassFactory == node) {
                node3.BuiltInFictitiousFunctionClassFactory = node2;
                return;
            } else {
                node3.getErrorConfigVersion = node2;
                return;
            }
        }
        int i = node.MyBillsEntityDataFactory;
        this.table[i & (r0.length - 1)] = node2;
    }

    private void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.BuiltInFictitiousFunctionClassFactory;
            Node<K, V> node3 = node.getErrorConfigVersion;
            int i = node2 != null ? node2.KClassImpl$Data$declaredNonStaticMembers$2 : 0;
            int i2 = node3 != null ? node3.KClassImpl$Data$declaredNonStaticMembers$2 : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node<K, V> node4 = node3.BuiltInFictitiousFunctionClassFactory;
                Node<K, V> node5 = node3.getErrorConfigVersion;
                int i4 = (node4 != null ? node4.KClassImpl$Data$declaredNonStaticMembers$2 : 0) - (node5 != null ? node5.KClassImpl$Data$declaredNonStaticMembers$2 : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(node3);
                }
                rotateLeft(node);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node<K, V> node6 = node2.BuiltInFictitiousFunctionClassFactory;
                Node<K, V> node7 = node2.getErrorConfigVersion;
                int i5 = (node6 != null ? node6.KClassImpl$Data$declaredNonStaticMembers$2 : 0) - (node7 != null ? node7.KClassImpl$Data$declaredNonStaticMembers$2 : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(node2);
                }
                rotateRight(node);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.BuiltInFictitiousFunctionClassFactory;
        Node<K, V> node3 = node.getErrorConfigVersion;
        Node<K, V> node4 = node3.BuiltInFictitiousFunctionClassFactory;
        Node<K, V> node5 = node3.getErrorConfigVersion;
        node.getErrorConfigVersion = node4;
        if (node4 != null) {
            node4.NetworkUserEntityData$$ExternalSyntheticLambda0 = node;
        }
        replaceInParent(node, node3);
        node3.BuiltInFictitiousFunctionClassFactory = node;
        node.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
        node.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(node2 != null ? node2.KClassImpl$Data$declaredNonStaticMembers$2 : 0, node4 != null ? node4.KClassImpl$Data$declaredNonStaticMembers$2 : 0) + 1;
        node3.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(node.KClassImpl$Data$declaredNonStaticMembers$2, node5 != null ? node5.KClassImpl$Data$declaredNonStaticMembers$2 : 0) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.BuiltInFictitiousFunctionClassFactory;
        Node<K, V> node3 = node.getErrorConfigVersion;
        Node<K, V> node4 = node2.BuiltInFictitiousFunctionClassFactory;
        Node<K, V> node5 = node2.getErrorConfigVersion;
        node.BuiltInFictitiousFunctionClassFactory = node5;
        if (node5 != null) {
            node5.NetworkUserEntityData$$ExternalSyntheticLambda0 = node;
        }
        replaceInParent(node, node2);
        node2.getErrorConfigVersion = node;
        node.NetworkUserEntityData$$ExternalSyntheticLambda0 = node2;
        node.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(node3 != null ? node3.KClassImpl$Data$declaredNonStaticMembers$2 : 0, node5 != null ? node5.KClassImpl$Data$declaredNonStaticMembers$2 : 0) + 1;
        node2.KClassImpl$Data$declaredNonStaticMembers$2 = Math.max(node.KClassImpl$Data$declaredNonStaticMembers$2, node4 != null ? node4.KClassImpl$Data$declaredNonStaticMembers$2 : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedHashTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        Node<K, V> BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        Node<K, V> NetworkUserEntityData$$ExternalSyntheticLambda0;
        Node<K, V> PlaceComponentResult;
        final K getAuthRequestContext;
        Node<K, V> getErrorConfigVersion;
        Node<K, V> lookAheadTest;
        V scheduleImpl;

        Node() {
            this.getAuthRequestContext = null;
            this.MyBillsEntityDataFactory = -1;
            this.lookAheadTest = this;
            this.PlaceComponentResult = this;
        }

        Node(Node<K, V> node, K k, int i, Node<K, V> node2, Node<K, V> node3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = node;
            this.getAuthRequestContext = k;
            this.MyBillsEntityDataFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            this.PlaceComponentResult = node2;
            this.lookAheadTest = node3;
            node3.PlaceComponentResult = this;
            node2.lookAheadTest = this;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.getAuthRequestContext;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.scheduleImpl;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = this.scheduleImpl;
            this.scheduleImpl = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.getAuthRequestContext;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.scheduleImpl;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k = this.getAuthRequestContext;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.scheduleImpl;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getAuthRequestContext);
            sb.append("=");
            sb.append(this.scheduleImpl);
            return sb.toString();
        }
    }

    private void doubleCapacity() {
        Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArr) {
        Node<K, V> node;
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[length * 2];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i = 0; i < length; i++) {
            Node<K, V> node2 = nodeArr[i];
            if (node2 != null) {
                Node<K, V> node3 = null;
                Node<K, V> node4 = null;
                for (Node<K, V> node5 = node2; node5 != null; node5 = node5.BuiltInFictitiousFunctionClassFactory) {
                    node5.NetworkUserEntityData$$ExternalSyntheticLambda0 = node4;
                    node4 = node5;
                }
                avlIterator.getAuthRequestContext = node4;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Node<K, V> authRequestContext = avlIterator.getAuthRequestContext();
                    if (authRequestContext == null) {
                        break;
                    } else if ((authRequestContext.MyBillsEntityDataFactory & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.MyBillsEntityDataFactory(i2);
                avlBuilder2.MyBillsEntityDataFactory(i3);
                Node<K, V> node6 = null;
                while (node2 != null) {
                    node2.NetworkUserEntityData$$ExternalSyntheticLambda0 = node6;
                    node6 = node2;
                    node2 = node2.BuiltInFictitiousFunctionClassFactory;
                }
                avlIterator.getAuthRequestContext = node6;
                while (true) {
                    Node<K, V> authRequestContext2 = avlIterator.getAuthRequestContext();
                    if (authRequestContext2 == null) {
                        break;
                    } else if ((authRequestContext2.MyBillsEntityDataFactory & length) == 0) {
                        avlBuilder.PlaceComponentResult(authRequestContext2);
                    } else {
                        avlBuilder2.PlaceComponentResult(authRequestContext2);
                    }
                }
                if (i2 > 0) {
                    node = avlBuilder.BuiltInFictitiousFunctionClassFactory;
                    if (node.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                        throw new IllegalStateException();
                    }
                } else {
                    node = null;
                }
                nodeArr2[i] = node;
                if (i3 > 0) {
                    node3 = avlBuilder2.BuiltInFictitiousFunctionClassFactory;
                    if (node3.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                        throw new IllegalStateException();
                    }
                }
                nodeArr2[i + length] = node3;
            }
        }
        return nodeArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class AvlIterator<K, V> {
        Node<K, V> getAuthRequestContext;

        AvlIterator() {
        }

        public final Node<K, V> getAuthRequestContext() {
            Node<K, V> node = this.getAuthRequestContext;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            node.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            for (Node<K, V> node3 = node.getErrorConfigVersion; node3 != null; node3 = node3.BuiltInFictitiousFunctionClassFactory) {
                node3.NetworkUserEntityData$$ExternalSyntheticLambda0 = node2;
                node2 = node3;
            }
            this.getAuthRequestContext = node2;
            return node;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class AvlBuilder<K, V> {
        Node<K, V> BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private int MyBillsEntityDataFactory;
        private int getAuthRequestContext;

        AvlBuilder() {
        }

        final void MyBillsEntityDataFactory(int i) {
            this.getAuthRequestContext = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.MyBillsEntityDataFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.BuiltInFictitiousFunctionClassFactory = null;
        }

        final void PlaceComponentResult(Node<K, V> node) {
            node.getErrorConfigVersion = null;
            node.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            node.BuiltInFictitiousFunctionClassFactory = null;
            node.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            int i = this.getAuthRequestContext;
            if (i > 0) {
                int i2 = this.MyBillsEntityDataFactory;
                if ((i2 & 1) == 0) {
                    this.MyBillsEntityDataFactory = i2 + 1;
                    this.getAuthRequestContext = i - 1;
                    this.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            node.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = node;
            int i3 = this.MyBillsEntityDataFactory + 1;
            this.MyBillsEntityDataFactory = i3;
            int i4 = this.getAuthRequestContext;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.MyBillsEntityDataFactory = i3 + 1;
                this.getAuthRequestContext = i4 - 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.MyBillsEntityDataFactory & i6) != i6) {
                    return;
                }
                int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i7 == 0) {
                    Node<K, V> node2 = this.BuiltInFictitiousFunctionClassFactory;
                    Node<K, V> node3 = node2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Node<K, V> node4 = node3.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    node3.NetworkUserEntityData$$ExternalSyntheticLambda0 = node4.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    this.BuiltInFictitiousFunctionClassFactory = node3;
                    node3.BuiltInFictitiousFunctionClassFactory = node4;
                    node3.getErrorConfigVersion = node2;
                    node3.KClassImpl$Data$declaredNonStaticMembers$2 = node2.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                    node4.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
                    node2.NetworkUserEntityData$$ExternalSyntheticLambda0 = node3;
                } else if (i7 == 1) {
                    Node<K, V> node5 = this.BuiltInFictitiousFunctionClassFactory;
                    Node<K, V> node6 = node5.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    this.BuiltInFictitiousFunctionClassFactory = node6;
                    node6.getErrorConfigVersion = node5;
                    node6.KClassImpl$Data$declaredNonStaticMembers$2 = node5.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                    node5.NetworkUserEntityData$$ExternalSyntheticLambda0 = node6;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                } else if (i7 == 2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                }
                i5 *= 2;
            }
        }
    }

    /* loaded from: classes6.dex */
    abstract class LinkedTreeMapIterator<T> implements Iterator<T>, j$.util.Iterator {
        int BuiltInFictitiousFunctionClassFactory;
        Node<K, V> MyBillsEntityDataFactory = null;
        Node<K, V> getAuthRequestContext;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        LinkedTreeMapIterator() {
            this.getAuthRequestContext = LinkedHashTreeMap.this.header.PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.getAuthRequestContext != LinkedHashTreeMap.this.header;
        }

        final Node<K, V> PlaceComponentResult() {
            Node<K, V> node = this.getAuthRequestContext;
            if (node == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.modCount != this.BuiltInFictitiousFunctionClassFactory) {
                throw new ConcurrentModificationException();
            }
            this.getAuthRequestContext = node.PlaceComponentResult;
            this.MyBillsEntityDataFactory = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.MyBillsEntityDataFactory;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(node, true);
            this.MyBillsEntityDataFactory = null;
            this.BuiltInFictitiousFunctionClassFactory = LinkedHashTreeMap.this.modCount;
        }
    }

    /* loaded from: classes6.dex */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.EntrySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public /* synthetic */ Object next() {
                    return PlaceComponentResult();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Node<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedHashTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    /* loaded from: classes6.dex */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final java.util.Iterator<K> iterator() {
            return new LinkedTreeMapIterator() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.KeySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return PlaceComponentResult().getAuthRequestContext;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
