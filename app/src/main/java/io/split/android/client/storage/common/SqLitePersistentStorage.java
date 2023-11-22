package io.split.android.client.storage.common;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class SqLitePersistentStorage<E extends Identifiable, M extends Identifiable> {
    protected static final int MAX_ROWS_PER_QUERY = 100;
    protected long mExpirationPeriod;

    protected abstract void deleteById(List<Long> list);

    protected abstract int deleteByStatus(int i, long j);

    protected abstract void deleteOutdated(long j);

    protected abstract E entityForModel(M m);

    protected abstract M entityToModel(E e) throws JsonParseException;

    protected abstract void insert(E e);

    protected abstract void insert(List<E> list);

    protected abstract void runInTransaction(List<E> list, int i, long j);

    protected abstract void updateStatus(List<Long> list, int i);

    public SqLitePersistentStorage(long j) {
        this.mExpirationPeriod = j;
    }

    public void push(M m) {
        E entityForModel;
        if (m == null || (entityForModel = entityForModel(m)) == null) {
            return;
        }
        insert((SqLitePersistentStorage<E, M>) entityForModel);
    }

    public void pushMany(List<M> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<E> arrayList = new ArrayList<>();
        Iterator<M> it = list.iterator();
        while (it.hasNext()) {
            E entityForModel = entityForModel(it.next());
            if (entityForModel != null) {
                arrayList.add(entityForModel);
            }
        }
        insert(arrayList);
    }

    public List<M> pop(int i) {
        List<E> arrayList = new ArrayList<>();
        do {
            int min = Math.min(100, i);
            ArrayList arrayList2 = new ArrayList();
            runInTransaction(arrayList2, min, this.mExpirationPeriod);
            int size = arrayList2.size();
            i -= size;
            arrayList.addAll(arrayList2);
            if (size <= 0) {
                break;
            }
        } while (i > 0);
        return entitiesToModels(arrayList);
    }

    public void setActive(List<M> list) {
        Preconditions.checkNotNull(list);
        if (list.size() == 0) {
            return;
        }
        Iterator<List<Long>> it = getIdInChunks(list).iterator();
        while (it.hasNext()) {
            updateStatus(it.next(), 0);
        }
    }

    public List<KeyImpression> getCritical() {
        return new ArrayList();
    }

    public void delete(List<M> list) {
        Preconditions.checkNotNull(list);
        if (list.size() == 0) {
            return;
        }
        Iterator<List<Long>> it = getIdInChunks(list).iterator();
        while (it.hasNext()) {
            deleteById(it.next());
        }
    }

    public void deleteInvalid(long j) {
        int i = 1;
        while (i > 0) {
            i = deleteByStatus(1, j);
        }
        deleteOutdated(expirationTime());
    }

    private long expirationTime() {
        return (System.currentTimeMillis() / 1000) - this.mExpirationPeriod;
    }

    private List<M> entitiesToModels(List<E> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(entityToModel(it.next()));
            } catch (JsonParseException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error parsing stored entity: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(sb.toString());
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown error parsing stored entity: ");
                sb2.append(e2.getLocalizedMessage());
                Logger.e(sb2.toString());
            }
        }
        return arrayList;
    }

    private List<List<Long>> getIdInChunks(List<M> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return new ArrayList();
        }
        Iterator<M> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getId()));
        }
        return Lists.partition(arrayList, 100);
    }

    /* loaded from: classes6.dex */
    public static abstract class GetAndUpdateTransaction<E extends Identifiable, M> implements Runnable {
        int mCount;
        List<E> mEntities;
        long mExpirationPeriod;

        protected abstract List<E> getBy(long j, int i, int i2);

        protected abstract void updateStatus(List<Long> list, int i);

        public GetAndUpdateTransaction(List<E> list, int i, long j) {
            this.mEntities = (List) Preconditions.checkNotNull(list);
            this.mCount = i;
            this.mExpirationPeriod = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mEntities.addAll(getBy((System.currentTimeMillis() / 1000) - this.mExpirationPeriod, 0, this.mCount));
            updateStatus(getEntitiesId(this.mEntities), 1);
        }

        private List<Long> getEntitiesId(List<E> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                return arrayList;
            }
            Iterator<E> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().getId()));
            }
            return arrayList;
        }
    }
}
