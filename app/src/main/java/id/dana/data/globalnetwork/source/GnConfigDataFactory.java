package id.dana.data.globalnetwork.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.globalnetwork.source.local.PreferenceGnConfigEntityData;
import id.dana.data.globalnetwork.source.split.SplitGnConfigEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/globalnetwork/source/GnConfigDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/globalnetwork/source/GnConfigEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/globalnetwork/source/GnConfigEntityData;", "Lid/dana/data/globalnetwork/source/local/PreferenceGnConfigEntityData;", "preferenceGnConfigEntityData", "Lid/dana/data/globalnetwork/source/local/PreferenceGnConfigEntityData;", "Lid/dana/data/globalnetwork/source/split/SplitGnConfigEntityData;", "splitGnConfigEntityData", "Lid/dana/data/globalnetwork/source/split/SplitGnConfigEntityData;", "<init>", "(Lid/dana/data/globalnetwork/source/split/SplitGnConfigEntityData;Lid/dana/data/globalnetwork/source/local/PreferenceGnConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GnConfigDataFactory extends AbstractEntityDataFactory<GnConfigEntityData> {
    private final PreferenceGnConfigEntityData preferenceGnConfigEntityData;
    private final SplitGnConfigEntityData splitGnConfigEntityData;

    @Inject
    public GnConfigDataFactory(SplitGnConfigEntityData splitGnConfigEntityData, PreferenceGnConfigEntityData preferenceGnConfigEntityData) {
        Intrinsics.checkNotNullParameter(splitGnConfigEntityData, "");
        Intrinsics.checkNotNullParameter(preferenceGnConfigEntityData, "");
        this.splitGnConfigEntityData = splitGnConfigEntityData;
        this.preferenceGnConfigEntityData = preferenceGnConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final GnConfigEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "local") ? this.preferenceGnConfigEntityData : this.splitGnConfigEntityData;
    }
}
