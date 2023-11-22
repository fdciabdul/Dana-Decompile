package id.dana.domain.recentcontact.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.model.RecentContactRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "repository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "getRepository", "()Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "setRepository", "(Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V", "<init>", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RemoveRecentSavedContact extends BaseUseCase<Boolean, Params> {
    private RecentRecipientRepository repository;

    @JvmName(name = "getRepository")
    public final RecentRecipientRepository getRepository() {
        return this.repository;
    }

    @JvmName(name = "setRepository")
    public final void setRepository(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.repository = recentRecipientRepository;
    }

    @Inject
    public RemoveRecentSavedContact(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.repository = recentRecipientRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params;", "", "Lid/dana/domain/recentrecipient/model/RecentContactRecipient;", "recentContact", "Lid/dana/domain/recentrecipient/model/RecentContactRecipient;", "getRecentContact$domain_productionRelease", "()Lid/dana/domain/recentrecipient/model/RecentContactRecipient;", "<init>", "(Lid/dana/domain/recentrecipient/model/RecentContactRecipient;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final RecentContactRecipient recentContact;

        public /* synthetic */ Params(RecentContactRecipient recentContactRecipient, DefaultConstructorMarker defaultConstructorMarker) {
            this(recentContactRecipient);
        }

        @JvmStatic
        public static final Params create(RecentContactRecipient recentContactRecipient) {
            return INSTANCE.create(recentContactRecipient);
        }

        private Params(RecentContactRecipient recentContactRecipient) {
            this.recentContact = recentContactRecipient;
        }

        @JvmName(name = "getRecentContact$domain_productionRelease")
        /* renamed from: getRecentContact$domain_productionRelease  reason: from getter */
        public final RecentContactRecipient getRecentContact() {
            return this.recentContact;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params$Companion;", "", "Lid/dana/domain/recentrecipient/model/RecentContactRecipient;", "recentContact", "Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Lid/dana/domain/recentrecipient/model/RecentContactRecipient;)Lid/dana/domain/recentcontact/interactor/RemoveRecentSavedContact$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(RecentContactRecipient recentContact) {
                Intrinsics.checkNotNullParameter(recentContact, "");
                return new Params(recentContact, null);
            }
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> removeRecentContact = this.repository.removeRecentContact(params.getRecentContact());
        Intrinsics.checkNotNullExpressionValue(removeRecentContact, "");
        return removeRecentContact;
    }
}
