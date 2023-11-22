package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
final class DiskCacheWriteLocker {
    final Map<String, WriteLock> PlaceComponentResult = new HashMap();
    final WriteLockPool getAuthRequestContext = new WriteLockPool();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.PlaceComponentResult(this.PlaceComponentResult.get(str));
            if (writeLock.MyBillsEntityDataFactory <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot release a lock that is not held, safeKey: ");
                sb.append(str);
                sb.append(", interestedThreads: ");
                sb.append(writeLock.MyBillsEntityDataFactory);
                throw new IllegalStateException(sb.toString());
            }
            writeLock.MyBillsEntityDataFactory--;
            if (writeLock.MyBillsEntityDataFactory == 0) {
                WriteLock remove = this.PlaceComponentResult.remove(str);
                if (!remove.equals(writeLock)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Removed the wrong lock, expected to remove: ");
                    sb2.append(writeLock);
                    sb2.append(", but actually removed: ");
                    sb2.append(remove);
                    sb2.append(", safeKey: ");
                    sb2.append(str);
                    throw new IllegalStateException(sb2.toString());
                }
                WriteLockPool writeLockPool = this.getAuthRequestContext;
                synchronized (writeLockPool.MyBillsEntityDataFactory) {
                    if (writeLockPool.MyBillsEntityDataFactory.size() < 10) {
                        writeLockPool.MyBillsEntityDataFactory.offer(remove);
                    }
                }
            }
        }
        writeLock.PlaceComponentResult.unlock();
    }

    /* loaded from: classes3.dex */
    static class WriteLock {
        int MyBillsEntityDataFactory;
        final Lock PlaceComponentResult = new ReentrantLock();

        WriteLock() {
        }
    }

    /* loaded from: classes3.dex */
    static class WriteLockPool {
        final Queue<WriteLock> MyBillsEntityDataFactory = new ArrayDeque();

        WriteLockPool() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final WriteLock MyBillsEntityDataFactory() {
            WriteLock poll;
            synchronized (this.MyBillsEntityDataFactory) {
                poll = this.MyBillsEntityDataFactory.poll();
            }
            return poll == null ? new WriteLock() : poll;
        }
    }
}
