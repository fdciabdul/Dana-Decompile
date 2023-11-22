package id.dana.danah5.base;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.page.GriverInterceptUrlEvent;
import com.alibaba.griver.api.common.page.GriverPageHelperEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\fJ#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ#\u0010\u0012\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ#\u0010\u0016\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J+\u0010\u0019\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/danah5/base/UrlTransportEventHandler;", "Lcom/alibaba/griver/api/common/page/GriverPageHelperEvent;", "Lcom/alibaba/griver/api/common/page/GriverInterceptUrlEvent;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "url", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "", "onFinalized", "()V", "onInitialized", "onPageBacked", "(Lcom/alibaba/ariver/app/api/Page;)V", "onPageDestroy", "onPageExit", "onPageFinished", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)V", "onPagePause", "onPageResume", "onPageStarted", "", "p2", "onProgressChanged", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;I)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class UrlTransportEventHandler implements GriverPageHelperEvent, GriverInterceptUrlEvent {
    @Override // com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public boolean interceptUrl(Page page, String url) {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageBacked(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageDestroy(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageExit(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageFinished(Page page, String url) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPagePause(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageResume(Page page) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onPageStarted(Page page, String url) {
    }

    @Override // com.alibaba.griver.api.common.page.GriverPageHelperEvent
    public void onProgressChanged(Page page, String url, int p2) {
    }
}
