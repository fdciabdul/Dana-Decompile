package id.dana.domain.announcement.interactor;

import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.announcement.model.AnnouncementsInfo;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/announcement/interactor/GetAnnouncements;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/announcement/model/AnnouncementsInfo;", "Lid/dana/domain/announcement/interactor/GetAnnouncements$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/announcement/interactor/GetAnnouncements$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/announcement/AnnouncementRepository;", "announcementRepository", "Lid/dana/domain/announcement/AnnouncementRepository;", "<init>", "(Lid/dana/domain/announcement/AnnouncementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAnnouncements extends BaseUseCase<AnnouncementsInfo, Params> {
    private final AnnouncementRepository announcementRepository;

    @Inject
    public GetAnnouncements(AnnouncementRepository announcementRepository) {
        Intrinsics.checkNotNullParameter(announcementRepository, "");
        this.announcementRepository = announcementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<AnnouncementsInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.announcementRepository.getAnnouncements(params.getType(), params.getExtendInfo());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/announcement/interactor/GetAnnouncements$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Map;", "type", "extendInfo", "copy", "(Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/announcement/interactor/GetAnnouncements$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getExtendInfo", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final Map<String, String> extendInfo;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.type;
            }
            if ((i & 2) != 0) {
                map = params.extendInfo;
            }
            return params.copy(str, map);
        }

        /* renamed from: component1  reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Map<String, String> component2() {
            return this.extendInfo;
        }

        public final Params copy(String type, Map<String, String> extendInfo) {
            Intrinsics.checkNotNullParameter(type, "");
            Intrinsics.checkNotNullParameter(extendInfo, "");
            return new Params(type, extendInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.type, params.type) && Intrinsics.areEqual(this.extendInfo, params.extendInfo);
            }
            return false;
        }

        public final int hashCode() {
            return (this.type.hashCode() * 31) + this.extendInfo.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(type=");
            sb.append(this.type);
            sb.append(", extendInfo=");
            sb.append(this.extendInfo);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.type = str;
            this.extendInfo = map;
        }

        @JvmName(name = "getExtendInfo")
        public final Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        @JvmName(name = "getType")
        public final String getType() {
            return this.type;
        }
    }
}
