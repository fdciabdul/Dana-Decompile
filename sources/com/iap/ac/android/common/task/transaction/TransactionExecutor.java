package com.iap.ac.android.common.task.transaction;

import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TransactionExecutor {
    public static final String TAG = "TransactionExecutor";
    public volatile Transaction mActive;
    public final ArrayDeque<Transaction> mTransactions = new ArrayDeque<>();

    private void scheduleNext() {
        Transaction transaction;
        synchronized (this.mTransactions) {
            this.mActive = this.mTransactions.poll();
            transaction = this.mActive;
        }
        if (this.mActive != null) {
            ACLog.d(TAG, "TransactionExecutor.scheduleNext()");
            transaction.run();
            return;
        }
        ACLog.d(TAG, "TransactionExecutor.scheduleNext(mTransactions is empty)");
    }

    public String addTransaction(Transaction transaction) {
        synchronized (this.mTransactions) {
            this.mTransactions.offer(transaction);
        }
        if (this.mActive == null) {
            scheduleNext();
        } else {
            ACLog.v(TAG, "TransactionExecutor.execute(a transaction is running, so don't call scheduleNext())");
        }
        return transaction.f7551id;
    }

    public void removeTransaction(String str) {
        Iterator<Transaction> it = this.mTransactions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Transaction next = it.next();
            if (next.f7551id.equals(str)) {
                synchronized (this.mTransactions) {
                    this.mTransactions.remove(next);
                    break;
                }
            }
        }
        if (this.mActive != null && this.mActive.f7551id.equals(str)) {
            this.mActive = null;
        }
        if (this.mActive == null) {
            scheduleNext();
        } else {
            ACLog.v(TAG, "TransactionExecutor.execute(a transaction is running, so don't call scheduleNext())");
        }
    }

    public void shutdown() {
        this.mTransactions.clear();
    }
}
