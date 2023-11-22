package id.dana.mybills.mapper;

import id.dana.domain.mybills.model.BizProductOrderRequest;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.model.BizProductModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/model/BizProductModel;", "", "p0", "p1", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "getAuthRequestContext", "(Lid/dana/mybills/model/BizProductModel;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/mybills/model/BizProductOrderRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductOrderRequestMapperKt {
    public static final BizProductOrderRequest getAuthRequestContext(BizProductModel bizProductModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(bizProductModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new BizProductOrderRequest(str, bizProductModel.getAuthRequestContext, str2, bizProductModel.MyBillsEntityDataFactory, new MoneyView(bizProductModel.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, bizProductModel.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, bizProductModel.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext));
    }
}
