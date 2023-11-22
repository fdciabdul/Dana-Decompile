package org.yaml.snakeyaml.util;

import java.util.AbstractList;

/* loaded from: classes9.dex */
public class ArrayUtils {
    private ArrayUtils() {
    }

    /* loaded from: classes9.dex */
    static class UnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] BuiltInFictitiousFunctionClassFactory;

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            E[] eArr = this.BuiltInFictitiousFunctionClassFactory;
            if (i >= eArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Index: ");
                sb.append(i);
                sb.append(", Size: ");
                sb.append(size());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            return eArr[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.BuiltInFictitiousFunctionClassFactory.length;
        }
    }

    /* loaded from: classes9.dex */
    static class CompositeUnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] KClassImpl$Data$declaredNonStaticMembers$2;
        private final E[] MyBillsEntityDataFactory;

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            E[] eArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i < eArr.length) {
                return eArr[i];
            }
            int length = eArr.length;
            E[] eArr2 = this.MyBillsEntityDataFactory;
            if (i - length < eArr2.length) {
                return eArr2[i - eArr.length];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Index: ");
            sb.append(i);
            sb.append(", Size: ");
            sb.append(size());
            throw new IndexOutOfBoundsException(sb.toString());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.length + this.MyBillsEntityDataFactory.length;
        }
    }
}
