package id.dana.data.services.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.services.repository.source.local.DefaultServicesEntityData;
import id.dana.data.services.repository.source.split.SplitServicesEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/services/repository/source/ServicesEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/services/repository/source/ServicesEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/services/repository/source/ServicesEntityData;", "Lid/dana/data/services/repository/source/local/DefaultServicesEntityData;", "defaultServicesEntityData", "Lid/dana/data/services/repository/source/local/DefaultServicesEntityData;", "Lid/dana/data/services/repository/source/split/SplitServicesEntityData;", "splitServicesEntityData", "Lid/dana/data/services/repository/source/split/SplitServicesEntityData;", "<init>", "(Lid/dana/data/services/repository/source/split/SplitServicesEntityData;Lid/dana/data/services/repository/source/local/DefaultServicesEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesEntityDataFactory extends AbstractEntityDataFactory<ServicesEntityData> {
    private final DefaultServicesEntityData defaultServicesEntityData;
    private final SplitServicesEntityData splitServicesEntityData;

    @Inject
    public ServicesEntityDataFactory(SplitServicesEntityData splitServicesEntityData, DefaultServicesEntityData defaultServicesEntityData) {
        Intrinsics.checkNotNullParameter(splitServicesEntityData, "");
        Intrinsics.checkNotNullParameter(defaultServicesEntityData, "");
        this.splitServicesEntityData = splitServicesEntityData;
        this.defaultServicesEntityData = defaultServicesEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final ServicesEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "split") ? this.splitServicesEntityData : this.defaultServicesEntityData;
    }
}
