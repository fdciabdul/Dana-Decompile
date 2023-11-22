package id.dana.data.config.source.sharedpreference;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "", "", "Lid/dana/data/config/source/sharedpreference/SocialFeedModelEntityData;", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "", "fromCache", "Z", "getFromCache", "()Z", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SocialFeedWrapperModelEntityData {
    public List<SocialFeedModelEntityData> data;
    public boolean fromCache;

    public /* synthetic */ SocialFeedWrapperModelEntityData() {
    }

    public SocialFeedWrapperModelEntityData(List<SocialFeedModelEntityData> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.data = list;
        this.fromCache = z;
    }

    public /* synthetic */ SocialFeedWrapperModelEntityData(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getData")
    public final List<SocialFeedModelEntityData> getData() {
        return this.data;
    }

    @JvmName(name = "getFromCache")
    public final boolean getFromCache() {
        return this.fromCache;
    }
}
