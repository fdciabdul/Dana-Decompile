package id.dana.sendmoney.data.repository.globalsend.source;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p1", "p2", "p3", "<init>", "(Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;Lid/dana/sendmoney/data/repository/globalsend/source/GlobalSendEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSendEntityDataFactory extends AbstractEntityDataFactory<GlobalSendEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GlobalSendEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GlobalSendEntityData BuiltInFictitiousFunctionClassFactory;
    private final GlobalSendEntityData MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GlobalSendEntityData PlaceComponentResult;

    @Inject
    public GlobalSendEntityDataFactory(GlobalSendEntityData globalSendEntityData, GlobalSendEntityData globalSendEntityData2, GlobalSendEntityData globalSendEntityData3, GlobalSendEntityData globalSendEntityData4) {
        Intrinsics.checkNotNullParameter(globalSendEntityData, "");
        Intrinsics.checkNotNullParameter(globalSendEntityData2, "");
        Intrinsics.checkNotNullParameter(globalSendEntityData3, "");
        Intrinsics.checkNotNullParameter(globalSendEntityData4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSendEntityData;
        this.MyBillsEntityDataFactory = globalSendEntityData2;
        this.PlaceComponentResult = globalSendEntityData3;
        this.BuiltInFictitiousFunctionClassFactory = globalSendEntityData4;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final GlobalSendEntityData createData2(String p0) {
        if (p0 != null) {
            switch (p0.hashCode()) {
                case 3357066:
                    if (p0.equals("mock")) {
                        return this.BuiltInFictitiousFunctionClassFactory;
                    }
                    break;
                case 103145323:
                    if (p0.equals("local")) {
                        return this.MyBillsEntityDataFactory;
                    }
                    break;
                case 109648666:
                    if (p0.equals("split")) {
                        return this.PlaceComponentResult;
                    }
                    break;
                case 1843485230:
                    if (p0.equals("network")) {
                        return this.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown source ");
        sb.append(p0);
        throw new IllegalArgumentException(sb.toString());
    }
}
