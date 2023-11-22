package com.alibaba.griver.core.liteprocess;

import android.content.ServiceConnection;
import java.util.Observable;

/* loaded from: classes3.dex */
public class LiteProcess extends Observable {
    public static final int READY = 1;
    public static final int RUNNING = 2;
    public static final int TERMINATED = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f6430a;
    private int b;
    private int c;
    private long d = -1;
    private String e;
    private ServiceConnection f;

    public int getLpid() {
        return this.f6430a;
    }

    public void setLpid(int i) {
        this.f6430a = i;
    }

    public int getPid() {
        return this.b;
    }

    public void setPid(int i) {
        this.b = i;
    }

    public int getState() {
        return this.c;
    }

    public void setState(int i) {
        this.c = i;
    }

    public long getStartToken() {
        return this.d;
    }

    public void setStartToken(long j) {
        this.d = j;
    }

    public String getAppId() {
        return this.e;
    }

    public void setAppId(String str) {
        this.e = str;
    }

    public ServiceConnection getServiceConnection() {
        return this.f;
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        this.f = serviceConnection;
    }

    public void reset() {
        this.b = -1;
        this.d = -1L;
        this.e = null;
        this.c = 0;
    }
}
