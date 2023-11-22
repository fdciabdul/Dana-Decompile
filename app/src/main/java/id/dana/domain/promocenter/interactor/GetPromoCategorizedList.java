package id.dana.domain.promocenter.interactor;

import android.text.TextUtils;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.domain.promocenter.model.PromoCategoryRequest;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promocenter/model/CategoryPromo;", "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "promoCenterRepository", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "<init>", "(Lid/dana/domain/promocenter/repository/PromoCenterRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPromoCategorizedList extends BaseUseCase<CategoryPromo, Params> {
    private final PromoCenterRepository promoCenterRepository;

    @Inject
    public GetPromoCategorizedList(PromoCenterRepository promoCenterRepository) {
        Intrinsics.checkNotNullParameter(promoCenterRepository, "");
        this.promoCenterRepository = promoCenterRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CategoryPromo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoCenterRepository.getPromoCategorizedList(params.getPromoCategoryRequest());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BK\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params;", "", "Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "promoCategoryRequest", "Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "getPromoCategoryRequest$domain_productionRelease", "()Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "", "", "categories", "sortBy", "filterOption", "", "lat", MapConstant.EXTRA_LON, "<init>", "(IILjava/util/List;Ljava/lang/String;Ljava/lang/String;DD)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PromoCategoryRequest promoCategoryRequest;

        public /* synthetic */ Params(int i, int i2, List list, String str, String str2, double d, double d2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, list, str, str2, d, d2);
        }

        private Params(int i, int i2, List<String> list, String str, String str2, double d, double d2) {
            this.promoCategoryRequest = new PromoCategoryRequest(i, i2, list, str, str2, d, d2);
        }

        @JvmName(name = "getPromoCategoryRequest$domain_productionRelease")
        /* renamed from: getPromoCategoryRequest$domain_productionRelease  reason: from getter */
        public final PromoCategoryRequest getPromoCategoryRequest() {
            return this.promoCategoryRequest;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params$Companion;", "", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "", "category", "sortBy", "filterOption", "", "lat", MapConstant.EXTRA_LON, "Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params;", "forGetPromoCategorizedList", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)Lid/dana/domain/promocenter/interactor/GetPromoCategorizedList$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params forGetPromoCategorizedList$default(Companion companion, int i, int i2, String str, String str2, String str3, double d, double d2, int i3, Object obj) {
                return companion.forGetPromoCategorizedList(i, i2, str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, d, d2);
            }

            public final Params forGetPromoCategorizedList(int pageSize, int pageNumber, String category, String sortBy, String filterOption, double lat, double lon) {
                Intrinsics.checkNotNullParameter(category, "");
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(category)) {
                    arrayList.add(category);
                }
                return new Params(pageSize, pageNumber, arrayList, sortBy, filterOption, lat, lon, null);
            }
        }
    }
}
