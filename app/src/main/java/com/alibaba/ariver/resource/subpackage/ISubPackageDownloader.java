package com.alibaba.ariver.resource.subpackage;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface ISubPackageDownloader {

    /* loaded from: classes6.dex */
    public interface Callback {
        void onFail(String str);

        void onSuccess(String str);
    }

    void prepareSubpackage(Bundle bundle, App app, AppModel appModel, JSONObject jSONObject, String str, Callback callback);
}
