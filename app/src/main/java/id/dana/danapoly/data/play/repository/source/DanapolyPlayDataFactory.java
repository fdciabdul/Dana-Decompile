package id.dana.danapoly.data.play.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/data/play/repository/source/DanapolyPlayDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "PlaceComponentResult", "Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyPlayDataFactory extends AbstractEntityDataFactory<DanapolyPlayData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DanapolyPlayData getAuthRequestContext;

    @Inject
    public DanapolyPlayDataFactory(DanapolyPlayData danapolyPlayData) {
        Intrinsics.checkNotNullParameter(danapolyPlayData, "");
        this.getAuthRequestContext = danapolyPlayData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ DanapolyPlayData createData(String str) {
        return this.getAuthRequestContext;
    }
}
