package com.iap.ac.android.diagnoselog.upload;

import com.google.common.net.HttpHeaders;
import com.iap.ac.android.diagnoselog.api.OnLogUploadListener;
import com.iap.ac.android.diagnoselog.core.UserDiagnosing;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class OSSUploader implements IDiagnoseUploader {

    /* renamed from: a  reason: collision with root package name */
    public UserDiagnosing.UploadStatusChangeListener f7576a;
    public OnLogUploadListener b;
    public ThreadPoolExecutor c;

    public OSSUploader(ThreadPoolExecutor threadPoolExecutor, UserDiagnosing.UploadStatusChangeListener uploadStatusChangeListener, OnLogUploadListener onLogUploadListener) {
        this.c = threadPoolExecutor;
        this.f7576a = uploadStatusChangeListener;
        this.b = onLogUploadListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x025f A[Catch: all -> 0x0290, TRY_ENTER, TryCatch #0 {all -> 0x0290, blocks: (B:52:0x0251, B:56:0x0274, B:55:0x025f), top: B:73:0x0251 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0285 A[Catch: all -> 0x0289, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0289, blocks: (B:38:0x023a, B:59:0x0285), top: B:81:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.io.File r20, com.iap.ac.android.diagnoselog.core.UserDiagnosing.DiagnoseTask r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.diagnoselog.upload.OSSUploader.a(java.io.File, com.iap.ac.android.diagnoselog.core.UserDiagnosing$DiagnoseTask, boolean):boolean");
    }

    public final Map<String, String> a(JSONObject jSONObject, String str) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            hashMap.put("key", jSONObject.optString("key"));
            hashMap.put("OSSAccessKeyId", jSONObject.optString("OSSAccessKeyId"));
            hashMap.put("policy", jSONObject.optString("policy"));
            hashMap.put("Signature", jSONObject.optString("Signature"));
            StringBuilder sb = new StringBuilder();
            sb.append("attachment;filename=");
            sb.append(str);
            sb.append(".zip");
            hashMap.put(HttpHeaders.CONTENT_DISPOSITION, sb.toString());
        }
        return hashMap;
    }
}
