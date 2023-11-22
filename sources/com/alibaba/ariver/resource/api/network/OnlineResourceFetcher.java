package com.alibaba.ariver.resource.api.network;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.NetworkStream;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.OnlineResource;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class OnlineResourceFetcher {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f6213a;
    private final Map<String, Resource> b = new HashMap();
    private boolean c = false;
    private FallbackListener d;

    /* loaded from: classes6.dex */
    public interface FallbackListener {
        void onFailed(String str);

        void onSuccess(String str, Resource resource);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6213a = arrayList;
        arrayList.add(RVConstants.FILE_API_PERMISSION);
        arrayList.add(RVConstants.FILE_APP_CONFIG);
        arrayList.add(RVConstants.FILE_TABBAR);
        arrayList.add("index.js");
        arrayList.add("index.worker.js");
        arrayList.add("index.html");
    }

    public void setFallbackListener(FallbackListener fallbackListener) {
        this.d = fallbackListener;
    }

    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.b.containsKey(str);
    }

    public boolean hasKeyResourceFallback() {
        return this.c;
    }

    public void startFallback(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null || TextUtils.isEmpty(appModel.getAppInfoModel().getFallbackBaseUrl())) {
            return;
        }
        String fallbackBaseUrl = appModel.getAppInfoModel().getFallbackBaseUrl();
        Iterator<String> it = f6213a.iterator();
        while (it.hasNext()) {
            prefetchUrl(FileUtils.combinePath(fallbackBaseUrl, it.next()));
        }
        this.c = true;
        RVLogger.d("AriverRes:OnlineResourceFetcher");
    }

    public void prefetchUrl(final String str) {
        if (TextUtils.isEmpty(str) || this.b.containsKey(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("prefetchUrl: ");
        sb.append(str);
        RVLogger.d("AriverRes:OnlineResourceFetcher", sb.toString());
        ExecutorUtils.runNotOnMain(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                OnlineResourceFetcher.this.getOnlineResource(str, false, null, false);
            }
        });
    }

    public Resource getOnlineResource(String str, boolean z, String str2, boolean z2) {
        Resource resource = this.b.get(str);
        if (resource != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("getOnlineResource hit cache: ");
            sb.append(str);
            RVLogger.d("AriverRes:OnlineResourceFetcher", sb.toString());
            return resource;
        }
        synchronized (this.b) {
            Resource resource2 = this.b.get(str);
            if (resource2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getOnlineResource miss cache: ");
                sb2.append(str);
                RVLogger.d("AriverRes:OnlineResourceFetcher", sb2.toString());
                if (!UrlUtils.isValidUrl(str) && !"YES".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_disableUrlCheck", null))) {
                    return null;
                }
                resource2 = createOnlineResource(str, z, str2, z2);
                this.b.put(str, resource2);
            }
            synchronized (this.b.get(str)) {
                byte[] bytes = resource2.getBytes();
                if (bytes != null && bytes.length != 0) {
                    resource2 = new OfflineResource(str, bytes);
                    FallbackListener fallbackListener = this.d;
                    if (fallbackListener != null) {
                        fallbackListener.onSuccess(str, resource2);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("getOnlineResource [");
                    sb3.append(str);
                    sb3.append("] got length: ");
                    sb3.append(bytes.length);
                    RVLogger.w("AriverRes:OnlineResourceFetcher", sb3.toString());
                }
                FallbackListener fallbackListener2 = this.d;
                if (fallbackListener2 != null) {
                    fallbackListener2.onFailed(str);
                }
                this.b.remove(str);
            }
            if (z) {
                resource2.setSourceType(ResourceSourceType.FALLBACK);
            }
            return resource2;
        }
    }

    protected Resource createOnlineResource(String str, boolean z, String str2, boolean z2) {
        OnlineResource onlineResource = new OnlineResource(str, new ResourceListener(str));
        if (!TextUtils.isEmpty(str2)) {
            onlineResource.addRequestHeader("x-mass-tappid", str2);
        }
        if (z2) {
            onlineResource.addRequestHeader(RVConstants.ONLY_IF_CACHED_KEY, "false");
        }
        onlineResource.setPackageRequest(z);
        return onlineResource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ResourceListener implements NetworkStream.Listener {

        /* renamed from: a  reason: collision with root package name */
        private final String f6214a;

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputClose(NetworkStream networkStream) {
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputOpen(NetworkStream networkStream) {
        }

        public ResourceListener(String str) {
            this.f6214a = str;
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onResourceError(NetworkStream networkStream, int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("online resource [");
            sb.append(this.f6214a);
            sb.append("] miss!");
            RVLogger.w("AriverRes:OnlineResourceFetcher", sb.toString());
            OnlineResourceFetcher.this.b.remove(this.f6214a);
        }

        @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
        public void onInputException() {
            StringBuilder sb = new StringBuilder();
            sb.append("online resource [");
            sb.append(this.f6214a);
            sb.append("] miss!");
            RVLogger.w("AriverRes:OnlineResourceFetcher", sb.toString());
            OnlineResourceFetcher.this.b.remove(this.f6214a);
        }
    }
}
