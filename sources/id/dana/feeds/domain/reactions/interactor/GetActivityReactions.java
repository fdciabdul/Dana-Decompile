package id.dana.feeds.domain.reactions.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import id.dana.feeds.domain.reactions.model.ActivityReactions;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/reactions/model/ActivityReactions;", "Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "getAuthRequestContext", "Lid/dana/domain/tracker/MixpanelRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/reactions/FeedsReactionRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetActivityReactions extends BaseUseCaseWithAnalytics<ActivityReactions, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedsReactionRepository getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MixpanelRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "alipayplus.mobilewallet.socialmedia.viewActivityReactions";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(params.getAuthRequestContext, params.MyBillsEntityDataFactory, params.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetActivityReactions(FeedsReactionRepository feedsReactionRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsReactionRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.getAuthRequestContext = feedsReactionRepository;
        this.PlaceComponentResult = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\r"}, d2 = {"Lid/dana/feeds/domain/reactions/interactor/GetActivityReactions$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.getAuthRequestContext.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        }
    }
}
