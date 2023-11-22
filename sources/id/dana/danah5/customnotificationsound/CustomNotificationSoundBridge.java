package id.dana.danah5.customnotificationsound;

import android.media.MediaPlayer;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import id.dana.R;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/customnotificationsound/CustomNotificationSoundBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.CUSTOM_NOTIFICATION_SOUND, "(Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomNotificationSoundBridge extends SimpleBridgeExtension {
    public static final String CUSTOM_NOTIFICATION_SOUND_EVENT = "playCustomNotificationSound";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void customNotificationSound(@BindingParam(name = {"event"}) String eventName, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(page, "");
        if (Intrinsics.areEqual(eventName, CUSTOM_NOTIFICATION_SOUND_EVENT)) {
            MediaPlayer.create(BridgeExtensionExtKt.getContext(page), (int) R.raw.f47082131886125).start();
        }
    }
}
