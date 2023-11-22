package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.framework.d;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    boolean f6812a;
    private Set<IInitializeComponent.IInitFinishListener> b;
    private Object c;
    private String d;
    private ISGPluginManager e;

    public b() {
        this.b = new HashSet();
        this.c = new Object();
        this.d = null;
        this.e = null;
        this.f6812a = false;
    }

    public b(String str) {
        this.b = new HashSet();
        this.c = new Object();
        this.e = null;
        this.f6812a = false;
        this.d = str;
    }

    private void a(boolean z) {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.b) {
            if (z) {
                iInitFinishListener.onSuccess();
            } else {
                iInitFinishListener.onError();
            }
        }
    }

    private void b() {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.b) {
            if (iInitFinishListener instanceof IInitializeComponent.IInitFinishListenerV2) {
                ((IInitializeComponent.IInitFinishListenerV2) iInitFinishListener).onStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.c) {
            Iterator<IInitializeComponent.IInitFinishListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onError();
            }
        }
    }

    public int a(Context context, String str, boolean z, boolean z2) throws SecException {
        synchronized (this.c) {
            if (!this.f6812a) {
                b();
                if (context == null) {
                    throw new SecException(101);
                }
                long b = com.alibaba.wireless.security.framework.utils.a.b();
                d dVar = new d();
                dVar.a(context, this.d, str, z, new Object[0]);
                dVar.getPluginInfo(dVar.getMainPluginName());
                com.alibaba.wireless.security.framework.utils.a.a("main", "getInstance", "", b);
                this.e = dVar;
                this.f6812a = true;
                a(true);
            }
        }
        return !this.f6812a ? 1 : 0;
    }

    public ISGPluginManager a() {
        return this.e;
    }

    public void a(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.add(iInitFinishListener);
            }
        }
    }

    public boolean a(Context context) throws SecException {
        return true;
    }

    public void b(final Context context, final String str, final boolean z, final boolean z2) throws SecException {
        if (context == null) {
            throw new SecException(101);
        }
        new Thread(new Runnable() { // from class: com.alibaba.wireless.security.open.initialize.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a(context, str, z, z2);
                } catch (SecException unused) {
                    b.this.c();
                }
            }
        }).start();
    }

    public void b(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.c) {
                this.b.remove(iInitFinishListener);
            }
        }
    }
}
