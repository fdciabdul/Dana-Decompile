package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

/* loaded from: classes.dex */
public class c implements ISGPluginInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f6792a;
    private String b;
    private ClassLoader c;
    private AssetManager d;
    private a e;
    private ISecurityGuardPlugin f;
    private ISGPluginManager g;

    public c(String str, ISGPluginManager iSGPluginManager, String str2, ClassLoader classLoader, a aVar, ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.f6792a = str;
        this.g = iSGPluginManager;
        this.b = str2;
        this.c = classLoader;
        this.e = aVar;
        this.f = iSecurityGuardPlugin;
    }

    public String a(String str) {
        return this.e.f6790a != null ? this.e.f6790a.applicationInfo.metaData.getString(str) : this.e.a(str);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public AssetManager getAssetManager() {
        AssetManager assetManager = this.d;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.newInstance();
            com.alibaba.wireless.security.framework.utils.d.a(assetManager2).a("addAssetPath", this.f6792a);
            this.d = assetManager2;
            return assetManager2;
        } catch (Exception e) {
            com.alibaba.wireless.security.framework.utils.a.a("", e);
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ClassLoader getClassLoader() {
        return this.c;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public PackageInfo getPackageInfo() {
        return this.e.f6790a;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginName() {
        return this.b;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginPath() {
        return this.f6792a;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISecurityGuardPlugin getSGPluginEntry() {
        return this.f;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISGPluginManager getSGPluginManager() {
        return this.g;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getVersion() {
        return this.e.f6790a != null ? this.e.f6790a.versionName : this.e.a("version");
    }
}
