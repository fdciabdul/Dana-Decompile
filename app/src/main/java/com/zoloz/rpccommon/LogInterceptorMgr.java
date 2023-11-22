package com.zoloz.rpccommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class LogInterceptorMgr implements LogInterceptor {
    private List<LogInterceptor> mInterceptors;

    public static LogInterceptorMgr get() {
        return Holder.MANAGER;
    }

    private LogInterceptorMgr() {
    }

    public void addInterceptor(LogInterceptor logInterceptor) {
        if (this.mInterceptors == null) {
            this.mInterceptors = new ArrayList();
        }
        this.mInterceptors.add(logInterceptor);
    }

    public void removeInterceptor(LogInterceptor logInterceptor) {
        List<LogInterceptor> list = this.mInterceptors;
        if (list != null) {
            list.remove(logInterceptor);
        }
    }

    @Override // com.zoloz.rpccommon.LogInterceptor
    public void addEvent(String str, HashMap<String, String> hashMap) {
        List<LogInterceptor> list = this.mInterceptors;
        if (list != null) {
            Iterator<LogInterceptor> it = list.iterator();
            while (it.hasNext()) {
                it.next().addEvent(str, hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    static class Holder {
        static final LogInterceptorMgr MANAGER = new LogInterceptorMgr();

        Holder() {
        }
    }
}
