package id.dana.kyb.data.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.kyb.data.KybConfigEntityData;
import id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/data/repository/source/KybConfigEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/kyb/data/KybConfigEntityData;", "Lid/dana/kyb/data/repository/source/split/SplitKybConfigEntityData;", "getAuthRequestContext", "Lid/dana/kyb/data/repository/source/split/SplitKybConfigEntityData;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/kyb/data/repository/source/split/SplitKybConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KybConfigEntityDataFactory extends AbstractEntityDataFactory<KybConfigEntityData> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SplitKybConfigEntityData MyBillsEntityDataFactory;

    @Inject
    public KybConfigEntityDataFactory(SplitKybConfigEntityData splitKybConfigEntityData) {
        Intrinsics.checkNotNullParameter(splitKybConfigEntityData, "");
        this.MyBillsEntityDataFactory = splitKybConfigEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ KybConfigEntityData createData2(String str) {
        return this.MyBillsEntityDataFactory;
    }
}
