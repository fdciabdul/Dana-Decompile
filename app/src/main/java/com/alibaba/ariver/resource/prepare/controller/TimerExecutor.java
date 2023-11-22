package com.alibaba.ariver.resource.prepare.controller;

/* loaded from: classes6.dex */
public interface TimerExecutor {
    void postDelayed(Runnable runnable, long j);

    void removeCallbacks(Runnable runnable);
}
