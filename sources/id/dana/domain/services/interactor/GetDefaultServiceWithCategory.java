package id.dana.domain.services.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.services.Category;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/services/ServicesRepository;", "servicesRepository", "Lid/dana/domain/services/ServicesRepository;", "<init>", "(Lid/dana/domain/services/ServicesRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDefaultServiceWithCategory extends BaseUseCase<List<? extends ThirdPartyCategoryService>, Params> {
    private final ServicesRepository servicesRepository;

    @Inject
    public GetDefaultServiceWithCategory(ServicesRepository servicesRepository) {
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        this.servicesRepository = servicesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<ThirdPartyCategoryService>> buildUseCase(Params params) {
        Observable<List<ThirdPartyCategoryService>> servicesByCategoryKeyDefault;
        Intrinsics.checkNotNullParameter(params, "");
        String categoryKey = params.getCategoryKey();
        if (categoryKey == null || categoryKey.length() == 0) {
            servicesByCategoryKeyDefault = this.servicesRepository.getAllDefaultServices();
        } else if (Intrinsics.areEqual(params.getCategoryKey(), Category.FEATURED)) {
            servicesByCategoryKeyDefault = this.servicesRepository.getServicesByCategoryKeyDefault(CollectionsKt.listOf(Category.FEATURED));
        } else {
            servicesByCategoryKeyDefault = this.servicesRepository.getServicesByCategoryKeyDefault(params.getCategories$domain_productionRelease());
        }
        Intrinsics.checkNotNullExpressionValue(servicesByCategoryKeyDefault, "");
        return servicesByCategoryKeyDefault;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;", "", "", "", "categories", "Ljava/util/List;", "getCategories$domain_productionRelease", "()Ljava/util/List;", "categoryKey", "Ljava/lang/String;", "getCategoryKey$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<String> categories;
        private final String categoryKey;

        public /* synthetic */ Params(List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(list);
        }

        private Params(List<String> list) {
            this.categories = list;
            this.categoryKey = (String) CollectionsKt.firstOrNull((List) list);
        }

        @JvmName(name = "getCategories$domain_productionRelease")
        public final List<String> getCategories$domain_productionRelease() {
            return this.categories;
        }

        @JvmName(name = "getCategoryKey$domain_productionRelease")
        /* renamed from: getCategoryKey$domain_productionRelease  reason: from getter */
        public final String getCategoryKey() {
            return this.categoryKey;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params$Companion;", "", "", "categoryKey", "Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;", "forFilterCategory", "(Ljava/lang/String;)Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;", "", "categories", "(Ljava/util/List;)Lid/dana/domain/services/interactor/GetDefaultServiceWithCategory$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forFilterCategory(String categoryKey) {
                Intrinsics.checkNotNullParameter(categoryKey, "");
                return forFilterCategory(CollectionsKt.listOf(categoryKey));
            }

            public final Params forFilterCategory(List<String> categories) {
                Intrinsics.checkNotNullParameter(categories, "");
                return new Params(categories, null);
            }
        }
    }
}
