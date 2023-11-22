package id.dana.danah5.customshareitem;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.utils.android.IntentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/customshareitem/CustomMoreShareItem;", "Lid/dana/danah5/customshareitem/CustomBaseOutShareItem;", "Lcom/alibaba/griver/api/ui/share/ShareParam;", "params", "Lcom/alibaba/griver/api/ui/share/ShareResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "doShare", "(Lcom/alibaba/griver/api/ui/share/ShareParam;Lcom/alibaba/griver/api/ui/share/ShareResultListener;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CustomMoreShareItem extends CustomBaseOutShareItem {
    public CustomMoreShareItem() {
        this.channelName = ShareItemChannel.MORE;
        this.iconDrawable = R.drawable.griver_core_share_more;
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem
    public final void doShare(ShareParam params, ShareResultListener listener) {
        Intrinsics.checkNotNullParameter(params, "");
        String pureDeeplink = getPureDeeplink(params);
        try {
            params.activity.startActivity(Intent.createChooser(IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(pureDeeplink), params.activity.getString(R.string.share)));
            if (listener != null) {
                listener.success(pureDeeplink);
            }
        } catch (ActivityNotFoundException e) {
            if (listener != null) {
                listener.fail(this.channelName, "", e.getMessage());
            }
        }
    }
}
