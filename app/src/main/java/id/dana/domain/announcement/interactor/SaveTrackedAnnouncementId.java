package id.dana.domain.announcement.interactor;

import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/announcement/interactor/SaveTrackedAnnouncementId;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/announcement/interactor/SaveTrackedAnnouncementId$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/announcement/interactor/SaveTrackedAnnouncementId$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/announcement/AnnouncementRepository;", "announcementRepository", "Lid/dana/domain/announcement/AnnouncementRepository;", "<init>", "(Lid/dana/domain/announcement/AnnouncementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveTrackedAnnouncementId extends BaseUseCase<Boolean, Params> {
    private final AnnouncementRepository announcementRepository;

    @Inject
    public SaveTrackedAnnouncementId(AnnouncementRepository announcementRepository) {
        Intrinsics.checkNotNullParameter(announcementRepository, "");
        this.announcementRepository = announcementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.announcementRepository.saveTrackedAnnouncementGnId(params.getId());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/announcement/interactor/SaveTrackedAnnouncementId$Params;", "", "", "component1", "()Ljava/lang/String;", "id", "copy", "(Ljava/lang/String;)Lid/dana/domain/announcement/interactor/SaveTrackedAnnouncementId$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String id;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.id;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Params copy(String id2) {
            Intrinsics.checkNotNullParameter(id2, "");
            return new Params(id2);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.id, ((Params) other).id);
        }

        public final int hashCode() {
            return this.id.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(id=");
            sb.append(this.id);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.id = str;
        }

        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }
    }
}
