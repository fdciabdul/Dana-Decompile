package id.dana.domain.merchant.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.merchant.model.MerchantCategory;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/merchant/interactor/GetNewMerchantCategories;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/merchant/model/MerchantCategory;", "Lid/dana/domain/merchant/interactor/GetNewMerchantCategories$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/merchant/interactor/GetNewMerchantCategories$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/merchant/MerchantCategoriesRepository;", "merchantCategoriesRepository", "Lid/dana/domain/merchant/MerchantCategoriesRepository;", "<init>", "(Lid/dana/domain/merchant/MerchantCategoriesRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNewMerchantCategories extends BaseUseCase<List<? extends MerchantCategory>, Params> {
    private final MerchantCategoriesRepository merchantCategoriesRepository;

    @Inject
    public GetNewMerchantCategories(MerchantCategoriesRepository merchantCategoriesRepository) {
        Intrinsics.checkNotNullParameter(merchantCategoriesRepository, "");
        this.merchantCategoriesRepository = merchantCategoriesRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<MerchantCategory>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<MerchantCategory>> newMerchantCategories = this.merchantCategoriesRepository.getNewMerchantCategories(params.getType());
        Intrinsics.checkNotNullExpressionValue(newMerchantCategories, "");
        return newMerchantCategories;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/merchant/interactor/GetNewMerchantCategories$Params;", "", "Lid/dana/domain/merchant/MerchantCategoryType;", "component1", "()Lid/dana/domain/merchant/MerchantCategoryType;", "type", "copy", "(Lid/dana/domain/merchant/MerchantCategoryType;)Lid/dana/domain/merchant/interactor/GetNewMerchantCategories$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/merchant/MerchantCategoryType;", "getType", "<init>", "(Lid/dana/domain/merchant/MerchantCategoryType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final MerchantCategoryType type;

        public static /* synthetic */ Params copy$default(Params params, MerchantCategoryType merchantCategoryType, int i, Object obj) {
            if ((i & 1) != 0) {
                merchantCategoryType = params.type;
            }
            return params.copy(merchantCategoryType);
        }

        /* renamed from: component1  reason: from getter */
        public final MerchantCategoryType getType() {
            return this.type;
        }

        public final Params copy(MerchantCategoryType type) {
            Intrinsics.checkNotNullParameter(type, "");
            return new Params(type);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && this.type == ((Params) other).type;
        }

        public final int hashCode() {
            return this.type.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(type=");
            sb.append(this.type);
            sb.append(')');
            return sb.toString();
        }

        public Params(MerchantCategoryType merchantCategoryType) {
            Intrinsics.checkNotNullParameter(merchantCategoryType, "");
            this.type = merchantCategoryType;
        }

        @JvmName(name = "getType")
        public final MerchantCategoryType getType() {
            return this.type;
        }
    }
}
