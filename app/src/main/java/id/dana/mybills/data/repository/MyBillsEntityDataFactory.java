package id.dana.mybills.data.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import id.dana.mybills.di.scope.MyBillsScope;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/mybills/data/repository/MyBillsEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/mybills/data/repository/source/MyBillsEntityData;Lid/dana/mybills/data/repository/source/MyBillsEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MyBillsScope
/* loaded from: classes5.dex */
public final class MyBillsEntityDataFactory extends AbstractEntityDataFactory<MyBillsEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MyBillsEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MyBillsEntityData PlaceComponentResult;

    @Inject
    public MyBillsEntityDataFactory(MyBillsEntityData myBillsEntityData, MyBillsEntityData myBillsEntityData2) {
        Intrinsics.checkNotNullParameter(myBillsEntityData, "");
        Intrinsics.checkNotNullParameter(myBillsEntityData2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myBillsEntityData;
        this.PlaceComponentResult = myBillsEntityData2;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final MyBillsEntityData createData2(String p0) {
        if (Intrinsics.areEqual(p0, "network")) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (Intrinsics.areEqual(p0, "split")) {
            return this.PlaceComponentResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown source ");
        sb.append(p0);
        throw new IllegalArgumentException(sb.toString());
    }
}
