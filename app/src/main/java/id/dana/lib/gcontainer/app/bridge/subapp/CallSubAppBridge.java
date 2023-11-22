package id.dana.lib.gcontainer.app.bridge.subapp;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import id.dana.lib.gcontainer.GContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/subapp/CallSubAppBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "url", "", "callSubApp", "(Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class CallSubAppBridge extends SimpleBridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void callSubApp(@BindingParam(name = {"url"}) String url) {
        Intrinsics.checkNotNullParameter(url, "");
        GContainer.openUrl$default(url, null, null, null, 14, null);
    }
}
