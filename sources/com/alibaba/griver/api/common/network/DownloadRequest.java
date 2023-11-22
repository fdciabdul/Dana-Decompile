package com.alibaba.griver.api.common.network;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DownloadRequest implements Serializable {
    public String appId;
    public String deployVersion;
    public String downloadFilePath;
    public String downloadUrl;
    public int retryTime;
    public boolean urgent;
    public String version;
}
