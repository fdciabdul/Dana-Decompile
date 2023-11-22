package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.resource.api.content.NetworkStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes6.dex */
public class OnlineResource extends AbstractResource {

    /* renamed from: a  reason: collision with root package name */
    private NetworkStream.Listener f6207a;
    private byte[] b;
    private boolean c;
    private NetworkStream d;

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ void addRequestHeader(String str, String str2) {
        super.addRequestHeader(str, str2);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getEncoding() {
        return super.getEncoding();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getMimeType() {
        return super.getMimeType();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ Map getRequestHeadersMap() {
        return super.getRequestHeadersMap();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ ResourceSourceType getSourceType() {
        return super.getSourceType();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ boolean isLocal() {
        return super.isLocal();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void setSourceType(ResourceSourceType resourceSourceType) {
        super.setSourceType(resourceSourceType);
    }

    public OnlineResource(String str, NetworkStream.Listener listener) {
        super(str);
        this.b = null;
        this.c = false;
        this.d = null;
        this.f6207a = listener;
        this.mSourceType = ResourceSourceType.ONLINE;
    }

    public boolean isPackageRequest() {
        return this.c;
    }

    public void setPackageRequest(boolean z) {
        this.c = z;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public InputStream getStream() {
        NetworkStream networkStream;
        synchronized (this) {
            if (this.b != null) {
                byte[] bArr = this.b;
                return new ByteArrayInputStream(bArr, 0, bArr.length);
            }
            NetworkStream networkStream2 = this.d;
            if (networkStream2 != null) {
                return networkStream2;
            }
            synchronized (this) {
                if (this.d == null) {
                    this.d = new NetworkStream(getOriginUrl(), this.c, this.f6207a, getRequestHeadersMap());
                }
                networkStream = this.d;
            }
            return networkStream;
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public byte[] getBytes() {
        synchronized (this) {
            byte[] bArr = this.b;
            if (bArr != null) {
                return bArr;
            }
            InputStream inputStream = null;
            try {
                inputStream = getStream();
                byte[] readToByte = IOUtils.readToByte(inputStream);
                this.b = readToByte;
                return readToByte;
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setBytes(byte[] bArr) {
        this.b = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnlineResource(");
        sb.append(getOriginUrl());
        sb.append(")");
        return sb.toString();
    }
}
