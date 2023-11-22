package id.dana.explore.domain.sku.interactor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0005\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00040\u0004*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00040\u00040\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "services", "Lio/reactivex/Observable;", "", BridgeDSL.INVOKE, "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class GetSkuExplore$populateSkuWithLastTransactionData$1 extends Lambda implements Function1<List<ThirdPartyServiceResponse>, Observable<List<? extends ThirdPartyServiceResponse>>> {
    final /* synthetic */ GetSkuExplore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSkuExplore$populateSkuWithLastTransactionData$1(GetSkuExplore getSkuExplore) {
        super(1);
        this.this$0 = getSkuExplore;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<List<ThirdPartyServiceResponse>> invoke(final List<ThirdPartyServiceResponse> list) {
        GlobalSearchRepository globalSearchRepository;
        Intrinsics.checkNotNullParameter(list, "");
        globalSearchRepository = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
        Observable<List<ProductBizId>> authRequestContext = globalSearchRepository.getAuthRequestContext(GetSkuExplore.MyBillsEntityDataFactory(list));
        final GetSkuExplore getSkuExplore = this.this$0;
        return authRequestContext.map(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$populateSkuWithLastTransactionData$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2580invoke$lambda0;
                m2580invoke$lambda0 = GetSkuExplore$populateSkuWithLastTransactionData$1.m2580invoke$lambda0(GetSkuExplore.this, list, (List) obj);
                return m2580invoke$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List m2580invoke$lambda0(GetSkuExplore getSkuExplore, List list, List list2) {
        Intrinsics.checkNotNullParameter(getSkuExplore, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        return GetSkuExplore.BuiltInFictitiousFunctionClassFactory(list, list2);
    }
}
