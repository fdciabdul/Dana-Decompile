package com.alibaba.ariver.resource.api.appinfo;

import android.os.Bundle;
import androidx.core.util.Pair;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import java.util.Map;

/* loaded from: classes3.dex */
public class UpdateAppParam {

    /* renamed from: a  reason: collision with root package name */
    private Pair<String, String> f6202a;
    private Map<String, String> b;
    private AppInfoScene c;
    private UpdateMode d;
    private boolean e;
    private Bundle f = new Bundle();

    public UpdateAppParam(String str, String str2) {
        this.f6202a = new Pair<>(str, str2);
    }

    public Pair<String, String> getRequestMainPackage() {
        return this.f6202a;
    }

    public boolean isForce() {
        return this.e;
    }

    public void setForce(boolean z) {
        this.e = z;
    }

    public Map<String, String> getRequestApps() {
        return this.b;
    }

    public void setRequestApps(Map<String, String> map) {
        this.b = map;
    }

    public AppInfoScene getQueryScene() {
        return this.c;
    }

    public void setQueryScene(AppInfoScene appInfoScene) {
        this.c = appInfoScene;
    }

    public void setExtras(Bundle bundle) {
        this.f = bundle;
    }

    public String getExtra(String str) {
        return (String) this.f.get(str);
    }

    public Bundle getExtras() {
        return this.f;
    }

    public UpdateMode getUpdateMode() {
        return this.d;
    }

    public void setUpdateMode(UpdateMode updateMode) {
        this.d = updateMode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateAppParam{mRequestMainPackage=");
        sb.append(this.f6202a);
        sb.append(", mQueryScene=");
        sb.append(this.c);
        sb.append(", mUpdateMode=");
        sb.append(this.d);
        sb.append(", mForce=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }
}
