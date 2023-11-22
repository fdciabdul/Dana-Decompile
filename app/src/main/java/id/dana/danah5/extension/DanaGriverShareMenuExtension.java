package id.dana.danah5.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.ui.share.BaseShareItem;
import com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension;
import id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager;
import id.dana.danah5.customshareitem.CustomCopyLinkShareItem;
import id.dana.danah5.customshareitem.CustomMessageShareItem;
import id.dana.danah5.customshareitem.CustomMoreShareItem;
import id.dana.danah5.customshareitem.FeedsShareItem;
import id.dana.danah5.mixpanel.StrictBaseBridge;
import id.dana.danah5.mixpanel.model.JSApiStatus;
import id.dana.data.toggle.SplitFacade;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danah5/extension/DanaGriverShareMenuExtension;", "Lcom/alibaba/griver/api/ui/share/GriverShareMenu4PageExtension;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "Lcom/alibaba/griver/api/ui/share/BaseShareItem;", "getShareItems", "(Lcom/alibaba/ariver/app/api/Page;)Ljava/util/List;", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "bottomSheetManager", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaGriverShareMenuExtension implements GriverShareMenu4PageExtension {
    private final ShareFeedBottomSheetManager bottomSheetManager;
    private final SplitFacade splitFacade;

    @Inject
    public DanaGriverShareMenuExtension(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
        this.bottomSheetManager = new ShareFeedBottomSheetManager();
    }

    @Override // com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension
    public final List<BaseShareItem> getShareItems(Page page) {
        Intrinsics.checkNotNullParameter(page, "");
        List<BaseShareItem> mutableListOf = CollectionsKt.mutableListOf(new CustomMessageShareItem(), new CustomCopyLinkShareItem(), new CustomMoreShareItem());
        if (StrictBaseBridge.INSTANCE.canUse(this.splitFacade, "my.showSharePanel", page) == JSApiStatus.ENABLED) {
            mutableListOf.add(new FeedsShareItem(this.bottomSheetManager));
        }
        return mutableListOf;
    }
}
