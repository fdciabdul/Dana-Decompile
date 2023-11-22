package com.iap.ac.android.common.container.model;

import android.os.Bundle;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.container.constant.StartMethod;

/* loaded from: classes3.dex */
public class ContainerParams {
    public String appId;
    public Bundle containerBundle;
    public String postParams;
    public StartMethod startMethod = StartMethod.GET;
    public String url;

    public ContainerParams(String str) {
        this.url = str;
    }

    public static ContainerParams createForMniProgram(String str) {
        ContainerParams containerParams = new ContainerParams("");
        containerParams.appId = str;
        return containerParams;
    }

    public String toString() {
        StringBuilder a2 = a.a("ContainerParams{appId='");
        a2.append(this.appId);
        a2.append('\'');
        a2.append(", containerBundle=");
        a2.append(this.containerBundle);
        a2.append(", postParams='");
        a2.append(this.postParams);
        a2.append('\'');
        a2.append(", startMethod=");
        a2.append(this.startMethod);
        a2.append(", url='");
        a2.append(this.url);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
