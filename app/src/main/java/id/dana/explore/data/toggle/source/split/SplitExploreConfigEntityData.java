package id.dana.explore.data.toggle.source.split;

import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.reflect.TypeToken;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.data.toggle.ExploreConfigEntityData;
import id.dana.explore.data.toggle.source.DefaultExploreGenerator;
import id.dana.explore.domain.globalsearch.model.GlobalSearchCategory;
import id.dana.explore.domain.sku.model.CategoryExploreModel;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.C;

@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015"}, d2 = {"Lid/dana/explore/data/toggle/source/split/SplitExploreConfigEntityData;", "Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "Lio/reactivex/Observable;", "", "Lid/dana/explore/domain/sku/model/CategoryExploreModel;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchCategory;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Lid/dana/explore/data/globalsearch/model/GlobalSearchConfigResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitExploreConfigEntityData implements ExploreConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 9250;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 24886;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static char PlaceComponentResult = 59837;
    private static char getAuthRequestContext = 64501;
    private static int getErrorConfigVersion = 1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SplitFacade PlaceComponentResult;

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 59;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        ObservableSource GetContactSyncConfig = GetContactSyncConfig(baseTrafficType);
        try {
            int i3 = getErrorConfigVersion + 61;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return GetContactSyncConfig;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(BaseTrafficType baseTrafficType) {
        int i = getErrorConfigVersion + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        boolean z = i % 2 == 0;
        ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1(baseTrafficType);
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public static /* synthetic */ Map KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 != 0;
        Map PlaceComponentResult2 = PlaceComponentResult(str);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return PlaceComponentResult2;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 63;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2(baseTrafficType);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
            try {
                getErrorConfigVersion = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return NetworkUserEntityData$$ExternalSyntheticLambda2;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return NetworkUserEntityData$$ExternalSyntheticLambda2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list) {
        List PlaceComponentResult2;
        int i = getErrorConfigVersion + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (!(i % 2 != 0)) {
            PlaceComponentResult2 = PlaceComponentResult(list);
        } else {
            try {
                PlaceComponentResult2 = PlaceComponentResult(list);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 91;
        getErrorConfigVersion = i2 % 128;
        if ((i2 % 2 == 0 ? '7' : (char) 31) != 31) {
            int i3 = 50 / 0;
            return PlaceComponentResult2;
        }
        return PlaceComponentResult2;
    }

    public static /* synthetic */ GlobalSearchConfigResponse NetworkUserEntityData$$ExternalSyntheticLambda0(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 != 0;
        GlobalSearchConfigResponse initRecordTimeStamp = initRecordTimeStamp(baseTrafficType);
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        return initRecordTimeStamp;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 != 0;
        ObservableSource moveToNextValue = moveToNextValue(baseTrafficType);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getErrorConfigVersion + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return moveToNextValue;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda7 = NetworkUserEntityData$$ExternalSyntheticLambda7(baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? InputCardNumberView.DIVIDER : '#') != ' ') {
            return NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
        Object obj = null;
        obj.hashCode();
        return NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    public static /* synthetic */ List getAuthRequestContext(List list) {
        int i = getErrorConfigVersion + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        char c = i % 2 != 0 ? 'H' : Typography.quote;
        List KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(list);
        if (c == 'H') {
            int i2 = 79 / 0;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public static /* synthetic */ ObservableSource getErrorConfigVersion(BaseTrafficType baseTrafficType) {
        int i = getErrorConfigVersion + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource lookAheadTest = lookAheadTest(baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return lookAheadTest;
    }

    public static /* synthetic */ ObservableSource scheduleImpl(BaseTrafficType baseTrafficType) {
        try {
            int i = getErrorConfigVersion + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            char c = i % 2 != 0 ? '[' : 'I';
            ObservableSource DatabaseTableConfigUtil = DatabaseTableConfigUtil(baseTrafficType);
            if (c == '[') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            return DatabaseTableConfigUtil;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitExploreConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.PlaceComponentResult = splitFacade;
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<GlobalSearchConfigResponse> KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            Observable<R> map = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitExploreConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0((BaseTrafficType) obj);
                }
            });
            SplitConfigEntityData.Companion companion = SplitConfigEntityData.INSTANCE;
            DefaultExploreGenerator defaultExploreGenerator = DefaultExploreGenerator.INSTANCE;
            Observable<GlobalSearchConfigResponse> onErrorResumeNext = map.onErrorResumeNext(companion.onJSONErrorReturnDefault(DefaultExploreGenerator.MyBillsEntityDataFactory()));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
            getErrorConfigVersion = i % 128;
            if (i % 2 != 0) {
                return onErrorResumeNext;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return onErrorResumeNext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<List<String>> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        try {
            try {
                Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda4
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitExploreConfigEntityData.BuiltInFictitiousFunctionClassFactory((BaseTrafficType) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
                getErrorConfigVersion = i % 128;
                if ((i % 2 == 0 ? 'A' : '5') != 'A') {
                    return flatMap;
                }
                Object obj = null;
                obj.hashCode();
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource GetContactSyncConfig(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultExploreGenerator defaultExploreGenerator = DefaultExploreGenerator.INSTANCE;
        final List<String> KClassImpl$Data$declaredNonStaticMembers$22 = DefaultExploreGenerator.KClassImpl$Data$declaredNonStaticMembers$2();
        final String str = "trending_keywords_regex";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getTrendingKeywordRegex$lambda-1$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = KClassImpl$Data$declaredNonStaticMembers$22;
                final boolean z = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getTrendingKeywordRegex$lambda-1$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? (char) 3 : '\n') != '\n') {
            Object obj = null;
            obj.hashCode();
            return observable;
        }
        return observable;
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<Boolean> lookAheadTest() {
        try {
            Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitExploreConfigEntityData.MyBillsEntityDataFactory((BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = getErrorConfigVersion + 101;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (i % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<Map<String, GlobalSearchCategory>> MyBillsEntityDataFactory() {
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.PlaceComponentResult((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 109;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            return flatMap;
        }
        Object obj = null;
        obj.hashCode();
        return flatMap;
    }

    private static final ObservableSource moveToNextValue(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultExploreGenerator defaultExploreGenerator = DefaultExploreGenerator.INSTANCE;
        final String authRequestContext = DefaultExploreGenerator.getAuthRequestContext();
        final String str = "feature_global_search_categories";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getFeatureGlobalSearchCategories$lambda-4$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $PlaceComponentResult = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = authRequestContext;
                final boolean z = this.$PlaceComponentResult;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, String.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getFeatureGlobalSearchCategories$lambda-4$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable map = create.map(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2((String) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return map;
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<Boolean> getErrorConfigVersion() {
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.getAuthRequestContext((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = getErrorConfigVersion + 125;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (i % 2 != 0) {
                int i2 = 71 / 0;
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<List<CategoryExploreModel>> BuiltInFictitiousFunctionClassFactory() {
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.getErrorConfigVersion((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = getErrorConfigVersion + 79;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource lookAheadTest(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultExploreGenerator defaultExploreGenerator = DefaultExploreGenerator.INSTANCE;
        final List<JSONObject> BuiltInFictitiousFunctionClassFactory2 = DefaultExploreGenerator.BuiltInFictitiousFunctionClassFactory();
        final String str = "category_explore";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getCategoryExplore$lambda-8$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory3 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = BuiltInFictitiousFunctionClassFactory2;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory3, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getCategoryExplore$lambda-8$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable map = create.map(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.MyBillsEntityDataFactory((List) obj);
            }
        });
        int i = getErrorConfigVersion + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? '6' : 'C') != '6') {
            return map;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return map;
    }

    private static final List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        int i = getErrorConfigVersion + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        while (true) {
            if (it.hasNext()) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                arrayList.add((CategoryExploreModel) JSONObject.parseObject(((JSONObject) it.next()).toJSONString(), CategoryExploreModel.class));
            } else {
                return arrayList;
            }
        }
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<List<SkuExploreConfig>> getAuthRequestContext() {
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.scheduleImpl((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
            int i2 = 49 / 0;
            return flatMap;
        }
        return flatMap;
    }

    private static final ObservableSource DatabaseTableConfigUtil(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        DefaultExploreGenerator defaultExploreGenerator = DefaultExploreGenerator.INSTANCE;
        final List<JSONObject> PlaceComponentResult2 = DefaultExploreGenerator.PlaceComponentResult();
        final String str = "sku_explore";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getSkuExplore$lambda-11$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = PlaceComponentResult2;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getSkuExplore$lambda-11$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable map = create.map(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.getAuthRequestContext((List) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return map;
    }

    private static final List KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            while (true) {
                if ((it.hasNext() ? 'B' : '5') != 'B') {
                    break;
                }
                arrayList.add((SkuExploreConfig) JSON.parseObject(((JSONObject) it.next()).toJSONString(), SkuExploreConfig.class));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return arrayList2;
            }
            return arrayList2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.explore.data.toggle.ExploreConfigEntityData
    public final Observable<Boolean> PlaceComponentResult() {
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitExploreConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = getErrorConfigVersion + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        if (id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class.isAssignableFrom(org.json.JSONArray.class) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if ((id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class.isAssignableFrom(org.json.JSONArray.class) ? '_' : 31) != '_') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r5 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        r5 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5, null), (java.lang.Class<java.lang.Object>) id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        if (r5 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r0 = (id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse) new org.json.JSONArray(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse initRecordTimeStamp(id.dana.data.toggle.traffictype.BaseTrafficType r5) {
        /*
            int r0 = id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L91
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L91
            int r0 = r0 % 2
            r1 = 71
            if (r0 != 0) goto L11
            r0 = 25
            goto L13
        L11:
            r0 = 71
        L13:
            java.lang.String r2 = "global_search_config"
            java.lang.String r3 = ""
            if (r0 == r1) goto L34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)     // Catch: java.lang.Exception -> L32
            id.dana.explore.data.toggle.source.DefaultExploreGenerator r0 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.INSTANCE     // Catch: java.lang.Exception -> L32
            id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse r0 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> L32
            r4 = 1
            java.lang.String r5 = r5.getAuthRequestContext(r2, r4)     // Catch: java.lang.Exception -> L32
            java.lang.Class<id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse> r2 = id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class
            java.lang.Class<org.json.JSONArray> r4 = org.json.JSONArray.class
            boolean r2 = r2.isAssignableFrom(r4)     // Catch: java.lang.Exception -> L32
            if (r2 == 0) goto L55
            goto L82
        L32:
            r5 = move-exception
            throw r5
        L34:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            id.dana.explore.data.toggle.source.DefaultExploreGenerator r0 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.INSTANCE
            id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse r0 = id.dana.explore.data.toggle.source.DefaultExploreGenerator.MyBillsEntityDataFactory()
            r4 = 0
            java.lang.String r5 = r5.getAuthRequestContext(r2, r4)
            java.lang.Class<id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse> r2 = id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class
            java.lang.Class<org.json.JSONArray> r4 = org.json.JSONArray.class
            boolean r2 = r2.isAssignableFrom(r4)
            r4 = 95
            if (r2 == 0) goto L51
            r2 = 95
            goto L53
        L51:
            r2 = 31
        L53:
            if (r2 == r4) goto L82
        L55:
            if (r5 == 0) goto L8e
            r2 = 0
            com.google.gson.Gson r3 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L67
            java.lang.String r5 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5, r2)     // Catch: java.lang.Exception -> L67
            java.lang.Class<id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse> r4 = id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse.class
            java.lang.Object r5 = r3.fromJson(r5, r4)     // Catch: java.lang.Exception -> L67
            goto L68
        L67:
            r5 = r2
        L68:
            r3 = 60
            if (r5 != 0) goto L6e
            r1 = 60
        L6e:
            if (r1 == r3) goto L72
            r0 = r5
            goto L8e
        L72:
            int r5 = id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r5 = r5 + 85
            int r1 = r5 % 128
            id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData.getErrorConfigVersion = r1
            int r5 = r5 % 2
            if (r5 != 0) goto L8e
            int r5 = r2.length     // Catch: java.lang.Throwable -> L80
            goto L8e
        L80:
            r5 = move-exception
            throw r5
        L82:
            if (r5 != 0) goto L85
            goto L86
        L85:
            r3 = r5
        L86:
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>(r3)
            r0 = r5
            id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse r0 = (id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse) r0
        L8e:
            id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse r0 = (id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse) r0
            return r0
        L91:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData.initRecordTimeStamp(id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse");
    }

    private static final ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda2(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Boolean bool = Boolean.FALSE;
        final String str = "feature_global_search";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$isGlobalSearchEnabled$lambda-2$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $KClassImpl$Data$declaredNonStaticMembers$2 = true;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$KClassImpl$Data$declaredNonStaticMembers$2;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$isGlobalSearchEnabled$lambda-2$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = getErrorConfigVersion + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? 'R' : 'c') != 'c') {
            Object obj = null;
            obj.hashCode();
            return observable;
        }
        return observable;
    }

    private static final Map PlaceComponentResult(String str) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(str, "");
        Object obj = null;
        try {
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str, null), new TypeToken<Map<String, ? extends GlobalSearchCategory>>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getFeatureGlobalSearchCategories$lambda-4$lambda-3$$inlined$toMap$default$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            emptyMap = (Map) fromJson;
        } catch (Exception unused) {
            emptyMap = MapsKt.emptyMap();
        }
        try {
            int i = getErrorConfigVersion + 61;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if (!(i % 2 == 0)) {
                    obj.hashCode();
                    return emptyMap;
                }
                return emptyMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda7(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final Boolean bool = Boolean.FALSE;
        final String str = "feature_explore_personalization";
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$isUserPersonalizationEnabled$lambda-5$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $PlaceComponentResult = true;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$PlaceComponentResult;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$isUserPersonalizationEnabled$lambda-5$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            return observable;
        }
        int i2 = 88 / 0;
        return observable;
    }

    private static final ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda1(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getTapTimeout() >> 16) + 22, new char[]{51920, 58865, 25225, 1828, 50399, 12707, 61302, 17290, 1534, 15994, 41943, 17583, 59900, 22538, 62081, 16774, 27354, 5032, 11574, 33211, 39739, 1188}, objArr);
        final String intern = ((String) objArr[0]).intern();
        final Boolean bool = Boolean.FALSE;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getGlobalSearchBarHomeConfig$lambda-12$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = true;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData$getGlobalSearchBarHomeConfig$lambda-12$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str4 = str2;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str4));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = getErrorConfigVersion + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return observable;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'S' : 'W') != 'W') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = $11 + 9;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = 0;
                while (true) {
                    if (!(i5 >= 16)) {
                        int i6 = $10 + 13;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                        i2 -= 40503;
                        i5++;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
