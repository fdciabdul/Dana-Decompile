package id.dana.danapoly.data.config.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/DanapolyConfigDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyConfigDataFactory extends AbstractEntityDataFactory<DanapolyConfigData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DanapolyConfigData MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanapolyConfigData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DanapolyConfigDataFactory(DanapolyConfigData danapolyConfigData, DanapolyConfigData danapolyConfigData2) {
        Intrinsics.checkNotNullParameter(danapolyConfigData, "");
        Intrinsics.checkNotNullParameter(danapolyConfigData2, "");
        this.BuiltInFictitiousFunctionClassFactory = danapolyConfigData;
        this.MyBillsEntityDataFactory = danapolyConfigData2;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final DanapolyConfigData createData2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, "local")) {
            return this.MyBillsEntityDataFactory;
        }
        Intrinsics.areEqual(p0, "network");
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
