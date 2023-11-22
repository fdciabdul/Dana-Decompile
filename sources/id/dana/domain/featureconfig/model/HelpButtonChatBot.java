package id.dana.domain.featureconfig.model;

import com.alibaba.griver.api.common.config.GriverConfigConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/featureconfig/model/HelpButtonChatBot;", "", "", "type", "Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "getHelpButtonConfigByType", "(Ljava/lang/String;)Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "", GriverConfigConstants.KEY_CCDN_H5_CONFIG_URLS, "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HelpButtonChatBot {
    public List<HelpButtonConfig> urls;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HelpButtonChatBot() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.featureconfig.model.HelpButtonChatBot.<init>():void");
    }

    public HelpButtonChatBot(List<HelpButtonConfig> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.urls = list;
    }

    public /* synthetic */ HelpButtonChatBot(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getUrls")
    public final List<HelpButtonConfig> getUrls() {
        return this.urls;
    }

    @JvmName(name = "setUrls")
    public final void setUrls(List<HelpButtonConfig> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.urls = list;
    }

    public final HelpButtonConfig getHelpButtonConfigByType(String type) {
        Object obj;
        Intrinsics.checkNotNullParameter(type, "");
        Iterator<T> it = this.urls.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((HelpButtonConfig) obj).getType(), type)) {
                break;
            }
        }
        return (HelpButtonConfig) obj;
    }
}
