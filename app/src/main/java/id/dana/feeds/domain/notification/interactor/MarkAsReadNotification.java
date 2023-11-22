package id.dana.feeds.domain.notification.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/tracker/MixpanelRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/notification/FeedsNotificationRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MarkAsReadNotification extends BaseUseCaseWithAnalytics<Boolean, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MixpanelRepository PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsNotificationRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.markNotificationAsRead";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(params.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MarkAsReadNotification(FeedsNotificationRepository feedsNotificationRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsNotificationRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = feedsNotificationRepository;
        this.PlaceComponentResult = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final List<String> BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Params) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Params) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }
}
