package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class SystemManager {

    /* renamed from: a  reason: collision with root package name */
    public static SystemManager f7450a = new SystemManager();
    public static final Object b = new Object();
    public static SystemNotifier c = new a();

    public static SystemManager getInstance() {
        return f7450a;
    }

    public static SystemNotifier getSystemNotifier() {
        return c;
    }

    public final void notifyNoticeResult(int i) {
        c.notifyNoticeObservers(i);
    }

    public final void notifyResolutionResult(Intent intent, String str) {
        c.notifyObservers(intent, str);
    }

    public final void notifyUpdateResult(int i) {
        c.notifyObservers(i);
    }

    /* loaded from: classes7.dex */
    public static final class a implements SystemNotifier {

        /* renamed from: a  reason: collision with root package name */
        public final List<SystemObserver> f7451a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public final void notifyNoticeObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f7451a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public final void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f7451a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public final void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f7451a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.b) {
                this.f7451a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public final void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.b) {
                this.f7451a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public final void notifyObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f7451a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
