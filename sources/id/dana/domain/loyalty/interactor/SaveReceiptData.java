package id.dana.domain.loyalty.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.loyalty.LoyaltyRepository;
import id.dana.domain.loyalty.model.FileOcrReceiptLoyalty;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/loyalty/interactor/SaveReceiptData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/LoyaltyRepository;", "loyaltyRepository", "Lid/dana/domain/loyalty/LoyaltyRepository;", "<init>", "(Lid/dana/domain/loyalty/LoyaltyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SaveReceiptData extends BaseUseCase<Boolean, Params> {
    private final LoyaltyRepository loyaltyRepository;

    @Inject
    public SaveReceiptData(LoyaltyRepository loyaltyRepository) {
        Intrinsics.checkNotNullParameter(loyaltyRepository, "");
        this.loyaltyRepository = loyaltyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.loyaltyRepository.saveReceiptData(params.getFileOcrReceiptLoyalty());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params;", "", "Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "fileOcrReceiptLoyalty", "Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "getFileOcrReceiptLoyalty$domain_productionRelease", "()Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "<init>", "(Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FileOcrReceiptLoyalty fileOcrReceiptLoyalty;

        public /* synthetic */ Params(FileOcrReceiptLoyalty fileOcrReceiptLoyalty, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileOcrReceiptLoyalty);
        }

        @JvmStatic
        public static final Params create(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
            return INSTANCE.create(fileOcrReceiptLoyalty);
        }

        private Params(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
            this.fileOcrReceiptLoyalty = fileOcrReceiptLoyalty;
        }

        @JvmName(name = "getFileOcrReceiptLoyalty$domain_productionRelease")
        /* renamed from: getFileOcrReceiptLoyalty$domain_productionRelease  reason: from getter */
        public final FileOcrReceiptLoyalty getFileOcrReceiptLoyalty() {
            return this.fileOcrReceiptLoyalty;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params$Companion;", "", "Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "fileOcrReceiptLoyalty", "Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;)Lid/dana/domain/loyalty/interactor/SaveReceiptData$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
                Intrinsics.checkNotNullParameter(fileOcrReceiptLoyalty, "");
                return new Params(fileOcrReceiptLoyalty, null);
            }
        }
    }
}
