package id.dana.feeds.data.activation.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.feeds.data.activation.source.local.PreferenceFeedInitEntityData;
import id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "Lid/dana/feeds/data/activation/source/network/NetworkFeedInitEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/data/activation/source/network/NetworkFeedInitEntityData;", "Lid/dana/feeds/data/activation/source/local/PreferenceFeedInitEntityData;", "getAuthRequestContext", "Lid/dana/feeds/data/activation/source/local/PreferenceFeedInitEntityData;", "p1", "<init>", "(Lid/dana/feeds/data/activation/source/local/PreferenceFeedInitEntityData;Lid/dana/feeds/data/activation/source/network/NetworkFeedInitEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedInitEntityDataFactory extends AbstractEntityDataFactory<FeedInitEntityData> {
    private final NetworkFeedInitEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PreferenceFeedInitEntityData MyBillsEntityDataFactory;

    @Inject
    public FeedInitEntityDataFactory(PreferenceFeedInitEntityData preferenceFeedInitEntityData, NetworkFeedInitEntityData networkFeedInitEntityData) {
        Intrinsics.checkNotNullParameter(preferenceFeedInitEntityData, "");
        Intrinsics.checkNotNullParameter(networkFeedInitEntityData, "");
        this.MyBillsEntityDataFactory = preferenceFeedInitEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkFeedInitEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final FeedInitEntityData createData2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, "network")) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return this.MyBillsEntityDataFactory;
    }
}
