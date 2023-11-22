package id.dana.data.requestmoney.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.requestmoney.repository.source.local.DefaultRequestMoneyEntityData;
import id.dana.data.requestmoney.repository.source.split.SplitRequestMoneyEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/requestmoney/repository/RequestMoneyEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "Lid/dana/data/requestmoney/repository/source/local/DefaultRequestMoneyEntityData;", "defaultRequestMoneyEntityData", "Lid/dana/data/requestmoney/repository/source/local/DefaultRequestMoneyEntityData;", "Lid/dana/data/requestmoney/repository/source/split/SplitRequestMoneyEntityData;", "splitRequestMoneyEntityData", "Lid/dana/data/requestmoney/repository/source/split/SplitRequestMoneyEntityData;", "<init>", "(Lid/dana/data/requestmoney/repository/source/split/SplitRequestMoneyEntityData;Lid/dana/data/requestmoney/repository/source/local/DefaultRequestMoneyEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestMoneyEntityDataFactory extends AbstractEntityDataFactory<RequestMoneyEntityData> {
    private final DefaultRequestMoneyEntityData defaultRequestMoneyEntityData;
    private final SplitRequestMoneyEntityData splitRequestMoneyEntityData;

    @Inject
    public RequestMoneyEntityDataFactory(SplitRequestMoneyEntityData splitRequestMoneyEntityData, DefaultRequestMoneyEntityData defaultRequestMoneyEntityData) {
        Intrinsics.checkNotNullParameter(splitRequestMoneyEntityData, "");
        Intrinsics.checkNotNullParameter(defaultRequestMoneyEntityData, "");
        this.splitRequestMoneyEntityData = splitRequestMoneyEntityData;
        this.defaultRequestMoneyEntityData = defaultRequestMoneyEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final RequestMoneyEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        if (Intrinsics.areEqual("split", source)) {
            return this.splitRequestMoneyEntityData;
        }
        return this.defaultRequestMoneyEntityData;
    }
}
