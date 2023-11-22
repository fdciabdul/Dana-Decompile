package id.dana.domain.home.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.home.HomeWidgetRepository;
import io.reactivex.Completable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence$Params;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence$Params;)Lio/reactivex/Completable;", "Lid/dana/domain/home/HomeWidgetRepository;", "homeWidgetRepository", "Lid/dana/domain/home/HomeWidgetRepository;", "<init>", "(Lid/dana/domain/home/HomeWidgetRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveNewsWidgetActivitiesIntoPersistence extends CompletableUseCase<Params> {
    private final HomeWidgetRepository homeWidgetRepository;

    @Inject
    public SaveNewsWidgetActivitiesIntoPersistence(HomeWidgetRepository homeWidgetRepository) {
        Intrinsics.checkNotNullParameter(homeWidgetRepository, "");
        this.homeWidgetRepository = homeWidgetRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeWidgetRepository.saveNewsWidgetActivitiesIntoPersistence(params.getActivityDataList());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence$Params;", "", "", "Lid/dana/domain/feeds/model/ActivityData;", "component1", "()Ljava/util/List;", "activityDataList", "copy", "(Ljava/util/List;)Lid/dana/domain/home/interactor/SaveNewsWidgetActivitiesIntoPersistence$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getActivityDataList", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final List<ActivityData> activityDataList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = params.activityDataList;
            }
            return params.copy(list);
        }

        public final List<ActivityData> component1() {
            return this.activityDataList;
        }

        public final Params copy(List<? extends ActivityData> activityDataList) {
            Intrinsics.checkNotNullParameter(activityDataList, "");
            return new Params(activityDataList);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.activityDataList, ((Params) other).activityDataList);
        }

        public final int hashCode() {
            return this.activityDataList.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(activityDataList=");
            sb.append(this.activityDataList);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Params(List<? extends ActivityData> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.activityDataList = list;
        }

        @JvmName(name = "getActivityDataList")
        public final List<ActivityData> getActivityDataList() {
            return this.activityDataList;
        }
    }
}
