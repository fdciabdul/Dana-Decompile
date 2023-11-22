package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: classes7.dex */
public class BindResolveClients {
    private static final Object LOCK_INST = new Object();
    private ArrayList<ResolveClientBean> mClientList;

    /* loaded from: classes7.dex */
    static class SingletonManager {
        private static final BindResolveClients INSTANCE = new BindResolveClients();

        private SingletonManager() {
        }
    }

    public static BindResolveClients getInstance() {
        return SingletonManager.INSTANCE;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (LOCK_INST) {
            contains = this.mClientList.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (LOCK_INST) {
            ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.mClientList.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (LOCK_INST) {
            if (!this.mClientList.contains(resolveClientBean)) {
                this.mClientList.add(resolveClientBean);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unRegister(com.huawei.hms.common.internal.ResolveClientBean r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.Object r0 = com.huawei.hms.common.internal.BindResolveClients.LOCK_INST
            monitor-enter(r0)
            java.util.ArrayList<com.huawei.hms.common.internal.ResolveClientBean> r1 = r3.mClientList     // Catch: java.lang.Throwable -> L29
            boolean r1 = r1.contains(r4)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.util.ArrayList<com.huawei.hms.common.internal.ResolveClientBean> r1 = r3.mClientList     // Catch: java.lang.Throwable -> L29
            java.util.ListIterator r1 = r1.listIterator()     // Catch: java.lang.Throwable -> L29
        L14:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L27
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L29
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L14
            r1.remove()     // Catch: java.lang.Throwable -> L29
        L27:
            monitor-exit(r0)
            return
        L29:
            r4 = move-exception
            monitor-exit(r0)
            goto L2d
        L2c:
            throw r4
        L2d:
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.internal.BindResolveClients.unRegister(com.huawei.hms.common.internal.ResolveClientBean):void");
    }

    public void unRegisterAll() {
        synchronized (LOCK_INST) {
            this.mClientList.clear();
        }
    }

    private BindResolveClients() {
        this.mClientList = new ArrayList<>();
    }
}
