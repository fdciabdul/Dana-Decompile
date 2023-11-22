package com.alibaba.ariver.resource.api.content;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes6.dex */
public class OfflineResource extends AbstractResource {

    /* renamed from: a  reason: collision with root package name */
    private String f6206a;
    private ResourcePackage b;
    private byte[] c;

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public boolean isLocal() {
        return true;
    }

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

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource
    public /* bridge */ /* synthetic */ Map getRequestHeadersMap() {
        return super.getRequestHeadersMap();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public /* bridge */ /* synthetic */ void setSourceType(ResourceSourceType resourceSourceType) {
        super.setSourceType(resourceSourceType);
    }

    public OfflineResource(String str, byte[] bArr) {
        super(str);
        this.f6206a = null;
        this.c = bArr;
        this.mSourceType = ResourceSourceType.OFFLINE;
    }

    public OfflineResource(String str, byte[] bArr, String str2) {
        super(str);
        this.c = bArr;
        this.f6206a = str2;
        this.mSourceType = ResourceSourceType.OFFLINE;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public InputStream getStream() {
        return new ByteArrayInputStream(this.c);
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public String getMimeType() {
        if (TextUtils.isEmpty(this.f6206a)) {
            return super.getMimeType();
        }
        return this.f6206a;
    }

    @Override // com.alibaba.ariver.resource.api.content.AbstractResource, com.alibaba.ariver.engine.api.resources.Resource
    public ResourceSourceType getSourceType() {
        return this.mSourceType;
    }

    public ResourcePackage getBelongsPackage() {
        return this.b;
    }

    public void setBelongsPackage(ResourcePackage resourcePackage) {
        this.b = resourcePackage;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public byte[] getBytes() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setBytes(byte[] bArr) {
        this.c = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OfflineResource(");
        sb.append(getUrl());
        sb.append(") size: ");
        sb.append(this.c.length);
        return sb.toString();
    }
}
