package id.dana.data.miniprogram.source.network;

import com.alibaba.griver.core.model.applist.FetchAppInfo;
import com.alibaba.griver.core.model.applist.FetchAppsResult;
import id.dana.data.miniprogram.MiniProgramMapperKt;
import id.dana.data.miniprogram.model.MiniProgramEntity;
import id.dana.data.miniprogram.source.MiniProgramEntityData;
import id.dana.lib.gcontainer.GContainer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/miniprogram/source/network/NetworkMiniPrograms;", "Lid/dana/data/miniprogram/source/MiniProgramEntityData;", "Lio/reactivex/Observable;", "", "Lid/dana/data/miniprogram/model/MiniProgramEntity;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkMiniPrograms implements MiniProgramEntityData {
    @Inject
    public NetworkMiniPrograms() {
    }

    public static Observable<List<MiniProgramEntity>> MyBillsEntityDataFactory() {
        Observable<List<MiniProgramEntity>> map = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.miniprogram.source.network.NetworkMiniPrograms$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NetworkMiniPrograms.PlaceComponentResult(observableEmitter);
            }
        }).map(new Function() { // from class: id.dana.data.miniprogram.source.network.NetworkMiniPrograms$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkMiniPrograms.MyBillsEntityDataFactory((FetchAppsResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(FetchAppsResult fetchAppsResult) {
        Intrinsics.checkNotNullParameter(fetchAppsResult, "");
        List<FetchAppInfo> list = fetchAppsResult.appInfoList;
        Intrinsics.checkNotNullExpressionValue(list, "");
        List<FetchAppInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FetchAppInfo fetchAppInfo : list2) {
            Intrinsics.checkNotNullExpressionValue(fetchAppInfo, "");
            arrayList.add(MiniProgramMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(fetchAppInfo));
        }
        return arrayList;
    }

    public static /* synthetic */ void PlaceComponentResult(final ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        GContainer.fetchMiniPrograms$default(0, 100, new Function1<FetchAppsResult, Unit>() { // from class: id.dana.data.miniprogram.source.network.NetworkMiniPrograms$getMiniPrograms$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FetchAppsResult fetchAppsResult) {
                invoke2(fetchAppsResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FetchAppsResult fetchAppsResult) {
                Intrinsics.checkNotNullParameter(fetchAppsResult, "");
                observableEmitter.onNext(fetchAppsResult);
            }
        }, new Function2<Integer, String, Unit>() { // from class: id.dana.data.miniprogram.source.network.NetworkMiniPrograms$getMiniPrograms$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, String str) {
                observableEmitter.onError(new Exception(str));
            }
        }, 1, null);
    }
}
