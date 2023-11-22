package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

/* loaded from: classes.dex */
public class a implements IInitializeComponent {

    /* renamed from: a  reason: collision with root package name */
    b f6811a;

    public a() {
        this.f6811a = new b();
    }

    public a(String str) {
        this.f6811a = new b(str);
    }

    public ISGPluginManager a() {
        return this.f6811a.a();
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int initialize(Context context) throws SecException {
        return loadLibrarySync(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void initializeAsync(Context context) {
        try {
            loadLibraryAsync(context);
        } catch (SecException unused) {
        }
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public boolean isSoValid(Context context) throws SecException {
        return this.f6811a.a(context);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context) throws SecException {
        this.f6811a.b(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context) throws SecException {
        return this.f6811a.a(context, null, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) throws SecException {
        return this.f6811a.a(context, str, true, false);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.f6811a.a(iInitFinishListener);
    }

    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        this.f6811a.b(iInitFinishListener);
    }
}
