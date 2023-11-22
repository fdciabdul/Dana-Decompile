package id.dana.data.sendmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sendmoney.BillerX2BEntityData;
import id.dana.data.sendmoney.repository.source.local.DefaultBillerX2BEntityData;
import id.dana.data.sendmoney.repository.source.split.SplitBillerX2BEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/sendmoney/repository/source/BillerX2BEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/sendmoney/BillerX2BEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/sendmoney/BillerX2BEntityData;", "Lid/dana/data/sendmoney/repository/source/local/DefaultBillerX2BEntityData;", "defaultAllBillerX2BEntityData", "Lid/dana/data/sendmoney/repository/source/local/DefaultBillerX2BEntityData;", "Lid/dana/data/sendmoney/repository/source/split/SplitBillerX2BEntityData;", "splitAllBillerX2BEntityData", "Lid/dana/data/sendmoney/repository/source/split/SplitBillerX2BEntityData;", "<init>", "(Lid/dana/data/sendmoney/repository/source/local/DefaultBillerX2BEntityData;Lid/dana/data/sendmoney/repository/source/split/SplitBillerX2BEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillerX2BEntityDataFactory extends AbstractEntityDataFactory<BillerX2BEntityData> {
    private final DefaultBillerX2BEntityData defaultAllBillerX2BEntityData;
    private final SplitBillerX2BEntityData splitAllBillerX2BEntityData;

    @Inject
    public BillerX2BEntityDataFactory(DefaultBillerX2BEntityData defaultBillerX2BEntityData, SplitBillerX2BEntityData splitBillerX2BEntityData) {
        Intrinsics.checkNotNullParameter(defaultBillerX2BEntityData, "");
        Intrinsics.checkNotNullParameter(splitBillerX2BEntityData, "");
        this.defaultAllBillerX2BEntityData = defaultBillerX2BEntityData;
        this.splitAllBillerX2BEntityData = splitBillerX2BEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final BillerX2BEntityData createData2(String source) {
        return Intrinsics.areEqual(source, "split") ? this.splitAllBillerX2BEntityData : this.defaultAllBillerX2BEntityData;
    }
}
