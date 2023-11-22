package id.dana.domain.promocenter.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promocenter.model.PromoResult;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promocenter/model/PromoResult;", "Lid/dana/domain/promocenter/interactor/GetPromoList$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promocenter/interactor/GetPromoList$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "promoCenterRepository", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "<init>", "(Lid/dana/domain/promocenter/repository/PromoCenterRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPromoList extends BaseUseCase<PromoResult, Params> {
    private final PromoCenterRepository promoCenterRepository;

    @Inject
    public GetPromoList(PromoCenterRepository promoCenterRepository) {
        Intrinsics.checkNotNullParameter(promoCenterRepository, "");
        this.promoCenterRepository = promoCenterRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PromoResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoCenterRepository.getPromoList(params.getPageSize(), params.getPageNumber(), params.getSortBy());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B#\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoList$Params;", "", "", ZdocRecordService.PAGE_NUMBER, "I", "getPageNumber$domain_productionRelease", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize$domain_productionRelease", "", "sortBy", "Ljava/lang/String;", "getSortBy$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(IILjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int pageNumber;
        private final int pageSize;
        private final String sortBy;

        public /* synthetic */ Params(int i, int i2, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, str);
        }

        private Params(int i, int i2, String str) {
            this.pageSize = i;
            this.pageNumber = i2;
            this.sortBy = str;
        }

        @JvmName(name = "getPageSize$domain_productionRelease")
        /* renamed from: getPageSize$domain_productionRelease  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getPageNumber$domain_productionRelease")
        /* renamed from: getPageNumber$domain_productionRelease  reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        @JvmName(name = "getSortBy$domain_productionRelease")
        /* renamed from: getSortBy$domain_productionRelease  reason: from getter */
        public final String getSortBy() {
            return this.sortBy;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoList$Params$Companion;", "", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "", "sortBy", "Lid/dana/domain/promocenter/interactor/GetPromoList$Params;", "forGetPromo", "(IILjava/lang/String;)Lid/dana/domain/promocenter/interactor/GetPromoList$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forGetPromo(int pageSize, int pageNumber, String sortBy) {
                return new Params(pageSize, pageNumber, sortBy, null);
            }
        }
    }
}
