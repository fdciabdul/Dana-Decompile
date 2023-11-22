package id.dana.data.services.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.model.CategoryServices;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003*\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/services/repository/source/model/CategoryServices;", "categoryKey", "Lkotlin/Pair;", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", BridgeDSL.INVOKE, "(Lid/dana/data/services/repository/source/model/CategoryServices;)Lkotlin/Pair;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesEntityRepository$getAllMapServices$1$2 extends Lambda implements Function1<CategoryServices, Pair<? extends CategoryServices, ? extends List<? extends ThirdPartyEntity>>> {
    final /* synthetic */ ServicesEntityRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesEntityRepository$getAllMapServices$1$2(ServicesEntityRepository servicesEntityRepository) {
        super(1);
        this.this$0 = servicesEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Pair<CategoryServices, List<ThirdPartyEntity>> invoke(final CategoryServices categoryServices) {
        Intrinsics.checkNotNullParameter(categoryServices, "");
        return (Pair) this.this$0.getListOfService(categoryServices.getCategory()).map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getAllMapServices$1$2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Pair m1998invoke$lambda0;
                m1998invoke$lambda0 = ServicesEntityRepository$getAllMapServices$1$2.m1998invoke$lambda0(CategoryServices.this, (List) obj);
                return m1998invoke$lambda0;
            }
        }).blockingFirst();
    }

    /* renamed from: invoke$lambda-0 */
    public static final Pair m1998invoke$lambda0(CategoryServices categoryServices, List list) {
        Intrinsics.checkNotNullParameter(categoryServices, "");
        Intrinsics.checkNotNullParameter(list, "");
        return new Pair(categoryServices, list);
    }
}
