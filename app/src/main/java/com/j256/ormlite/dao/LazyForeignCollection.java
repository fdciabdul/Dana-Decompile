package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.IOUtils;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes8.dex */
public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    @Override // com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return false;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() {
        return 0;
    }

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return closeableIterator(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iterator(int i) {
        return closeableIterator(i);
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return closeableIterator(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> closeableIterator(int i) {
        try {
            return iteratorThrow(i);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build lazy iterator for ");
            sb.append(this.dao.getDataClass());
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() throws SQLException {
        return iteratorThrow(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow(int i) throws SQLException {
        CloseableIterator<T> seperateIteratorThrow = seperateIteratorThrow(i);
        this.lastIterator = seperateIteratorThrow;
        return seperateIteratorThrow;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return getWrappedIterable(-1);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable(final int i) {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() { // from class: com.j256.ormlite.dao.LazyForeignCollection.1
            {
                LazyForeignCollection.this = this;
            }

            @Override // java.lang.Iterable
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow(i);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build lazy iterator for ");
                    sb.append(LazyForeignCollection.this.dao.getDataClass());
                    throw new IllegalStateException(sb.toString(), e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() throws IOException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // java.util.Collection
    public int size() {
        CloseableIterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            try {
                it.moveToNext();
                i++;
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        return i;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        CloseableIterator<T> it = iterator();
        try {
            boolean hasNext = it.hasNext();
            IOUtils.closeQuietly(it);
            return !hasNext;
        } catch (Throwable th) {
            IOUtils.closeQuietly(it);
            throw th;
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean z;
        CloseableIterator<T> it = iterator();
        while (true) {
            try {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().equals(obj)) {
                    z = true;
                    break;
                }
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                hashSet.remove(it.next());
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        return hashSet.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0014, code lost:
    
        r0.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0017, code lost:
    
        r3 = true;
     */
    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r3) {
        /*
            r2 = this;
            com.j256.ormlite.dao.CloseableIterator r0 = r2.iterator()
        L4:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L19
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L1e
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L4
            r0.remove()     // Catch: java.lang.Throwable -> L1e
            r3 = 1
            goto L1a
        L19:
            r3 = 0
        L1a:
            com.j256.ormlite.misc.IOUtils.closeQuietly(r0)
            return r3
        L1e:
            r3 = move-exception
            com.j256.ormlite.misc.IOUtils.closeQuietly(r0)
            goto L24
        L23:
            throw r3
        L24:
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.dao.LazyForeignCollection.remove(java.lang.Object):boolean");
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        CloseableIterator<T> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator<T> it = iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next());
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        return arrayList.toArray();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        CloseableIterator<T> it = iterator();
        ArrayList arrayList = null;
        int i = 0;
        while (it.hasNext()) {
            try {
                T next = it.next();
                if (i >= eArr.length) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        for (E e : eArr) {
                            arrayList.add(e);
                        }
                    }
                    arrayList.add(next);
                } else {
                    eArr[i] = next;
                }
                i++;
            } finally {
                IOUtils.closeQuietly(it);
            }
        }
        if (arrayList == null) {
            if (i < eArr.length - 1) {
                eArr[i] = 0;
            }
            return eArr;
        }
        return (E[]) arrayList.toArray(eArr);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return super.hashCode();
    }

    public CloseableIterator<T> seperateIteratorThrow(int i) throws SQLException {
        if (this.dao == null) {
            throw new IllegalStateException("Internal DAO object is null.  Maybe the collection was deserialized or otherwise constructed wrongly.  Use dao.assignEmptyForeignCollection(...) or dao.getEmptyForeignCollection(...) instead");
        }
        return this.dao.iterator(getPreparedQuery(), i);
    }
}
