package id.dana.data.services.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.model.CategoryServices;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0006*\u00020\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "categoryKey", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", BridgeDSL.INVOKE, "(Ljava/lang/String;)Lid/dana/domain/services/model/ThirdPartyCategoryService;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesEntityRepository$getServicesByCategoryKey$2$1 extends Lambda implements Function1<String, ThirdPartyCategoryService> {
    final /* synthetic */ List<CategoryServices> $$sections;
    final /* synthetic */ ServicesEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesEntityRepository$getServicesByCategoryKey$2$1(List<CategoryServices> list, ServicesEntityRepository servicesEntityRepository) {
        super(1);
        this.$$sections = list;
        this.this$0 = servicesEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ThirdPartyCategoryService invoke(final String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "");
        List<CategoryServices> list = this.$$sections;
        Intrinsics.checkNotNullExpressionValue(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CategoryServices) obj).getCategory(), str)) {
                break;
            }
        }
        final CategoryServices categoryServices = (CategoryServices) obj;
        Observable<List<ThirdPartyEntity>> listOfService = this.this$0.getListOfService(str);
        final ServicesEntityRepository servicesEntityRepository = this.this$0;
        return (ThirdPartyCategoryService) listOfService.map(new Function() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getServicesByCategoryKey$2$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                ThirdPartyCategoryService m2001invoke$lambda1;
                m2001invoke$lambda1 = ServicesEntityRepository$getServicesByCategoryKey$2$1.m2001invoke$lambda1(ServicesEntityRepository.this, categoryServices, str, (List) obj2);
                return m2001invoke$lambda1;
            }
        }).blockingFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final ThirdPartyCategoryService m2001invoke$lambda1(ServicesEntityRepository servicesEntityRepository, CategoryServices categoryServices, String str, List list) {
        Intrinsics.checkNotNullParameter(servicesEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<ThirdPartyServiceResponse> transform = ServicesEntityRepository.access$getHomeInfoResultMapper$p(servicesEntityRepository).transform(list);
        if (categoryServices != null) {
            return ServicesEntityRepository.access$getHomeInfoResultMapper$p(servicesEntityRepository).transform(transform, categoryServices);
        }
        return ServicesEntityRepository.access$getHomeInfoResultMapper$p(servicesEntityRepository).transform(transform, str);
    }
}
