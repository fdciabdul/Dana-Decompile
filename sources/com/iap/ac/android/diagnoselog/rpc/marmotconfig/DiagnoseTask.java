package com.iap.ac.android.diagnoselog.rpc.marmotconfig;

/* loaded from: classes8.dex */
public class DiagnoseTask {
    public String appId;
    public long endTime;
    public long startTime;
    public String taskId;
    public UploadParams uploadParams;
    public String uploadUrl;

    /* loaded from: classes8.dex */
    public static class UploadParams {
        public String OSSAccessKeyId;
        public String Signature;
        public String key;
        public String policy;
    }
}
