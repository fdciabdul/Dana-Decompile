package id.dana.kyb.data.repository.source.split;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import id.dana.challenge.ChallengeControl;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.kyb.data.KybConfigEntityData;
import id.dana.kyb.data.model.KybServiceResult;
import id.dana.kyb.data.model.KybStartupConfigResult;
import id.dana.kyb.data.model.KybUrlsConfigWrapperResult;
import id.dana.kyb.domain.constant.KybDefaultServices;
import id.dana.kyb.domain.constant.KybServiceCategory;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.whenAvailable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018"}, d2 = {"Lid/dana/kyb/data/repository/source/split/SplitKybConfigEntityData;", "Lid/dana/kyb/data/KybConfigEntityData;", "Lio/reactivex/Observable;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "getAuthRequestContext", "p0", "Lid/dana/kyb/data/model/KybServiceResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/model/KybStartupConfigResult;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;", "MyBillsEntityDataFactory", "", "getErrorConfigVersion", "scheduleImpl", "p1", "Lio/reactivex/Completable;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitKybConfigEntityData implements KybConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SplitFacade KClassImpl$Data$declaredNonStaticMembers$2;
    private static char[] getAuthRequestContext = {62245, 6368, 9346, 12436, 23649, 26648, 29750, 33241, 44447, 47522, 50509, 53548, 64825, 2756, 5880, 8882, 20057, 23142, 26146, 29634, 40925, 43916, 46936, 50035, 7030, 61602, 52447, 55521, 46137, 32849, 40063, 27054, 17859, 20966, 11540, 14706, 5493, 57993, 62245, 6368, 9346, 12436, 23649, 26633, 29733, 33245, 44418, 47540, 50520, 53548, 64825, 2762, 5858, 8881, 20055, 23150, 62245, 6368, 9346, 12436, 23649, 26648, 29750, 33241, 44447, 47522, 50509, 53548, 64825, 2756, 5880, 8882, 20057, 23142, 26146, 29634, 40925, 43929, 46939, 50031, 62245, 6368, 9346, 12436, 23655, 26639, 29736, 33244, 62248, 6396, 9345, 12479, 23655, 26639, 29729, 33264, 44445, 47544, 50506, 53548, 64820, 2756, 5880, 8894, 20040, 23148, 62248, 6396, 9345, 12479, 23655, 26639, 29729, 33264, 44423, 47539, 50497, 53504, 64773, 2758, 5869, 8868, 20054, 23136, 26165, 29641, 40925, 43933, 46933, 50022, 61195, 62676, 246, 11415};
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 7187220490827339929L;

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(BaseTrafficType baseTrafficType) {
        ObservableSource scheduleImpl;
        int i = PlaceComponentResult + 53;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? (char) 7 : (char) 28) != 7) {
            try {
                scheduleImpl = scheduleImpl(baseTrafficType);
            } catch (Exception e) {
                throw e;
            }
        } else {
            scheduleImpl = scheduleImpl(baseTrafficType);
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 89;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return scheduleImpl;
        }
        obj.hashCode();
        return scheduleImpl;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 113;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        ObservableSource GetContactSyncConfig = GetContactSyncConfig(baseTrafficType);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return GetContactSyncConfig;
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(BaseTrafficType baseTrafficType) {
        Boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 101;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1(baseTrafficType);
                int i2 = 42 / 0;
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1(baseTrafficType);
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 109;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(String str, BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, baseTrafficType);
        int i3 = PlaceComponentResult + 89;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? (char) 24 : (char) 20;
        Object[] objArr = null;
        Boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2(baseTrafficType);
        if (c == 24) {
            objArr.hashCode();
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 49;
            try {
                PlaceComponentResult = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    return NetworkUserEntityData$$ExternalSyntheticLambda2;
                }
                int length = objArr.length;
                return NetworkUserEntityData$$ExternalSyntheticLambda2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(SplitKybConfigEntityData splitKybConfigEntityData, String str, String str2) {
        int i = PlaceComponentResult + 105;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        getAuthRequestContext(splitKybConfigEntityData, str, str2);
        int i3 = PlaceComponentResult + 91;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.less : (char) 6) != 6) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(BaseTrafficType baseTrafficType) {
        ObservableSource moveToNextValue;
        try {
            int i = PlaceComponentResult + 97;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                try {
                    moveToNextValue = moveToNextValue(baseTrafficType);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                moveToNextValue = moveToNextValue(baseTrafficType);
                Object obj = null;
                obj.hashCode();
            }
            int i2 = PlaceComponentResult + 49;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return moveToNextValue;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource getErrorConfigVersion(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 13;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource initRecordTimeStamp = initRecordTimeStamp(baseTrafficType);
        int i3 = BuiltInFictitiousFunctionClassFactory + 51;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '_' : ',') != '_') {
            return initRecordTimeStamp;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return initRecordTimeStamp;
    }

    public static /* synthetic */ ObservableSource lookAheadTest(BaseTrafficType baseTrafficType) {
        try {
            int i = PlaceComponentResult + 89;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                boolean z = i % 2 != 0;
                ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(baseTrafficType);
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = BuiltInFictitiousFunctionClassFactory + 117;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                return NetworkUserEntityData$$ExternalSyntheticLambda0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Inject
    public SplitKybConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitFacade;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<Boolean> getErrorConfigVersion() {
        try {
            try {
                Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitKybConfigEntityData.MyBillsEntityDataFactory((BaseTrafficType) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                int i = BuiltInFictitiousFunctionClassFactory + 75;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final Boolean NetworkUserEntityData$$ExternalSyntheticLambda1(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 59;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '9' : '?') != '9') {
            try {
                Intrinsics.checkNotNullParameter(baseTrafficType, "");
                Object[] objArr = new Object[1];
                a(88 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), objArr);
                return Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), true, true));
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object[] objArr2 = new Object[1];
        a(10 >>> Drawable.resolveOpacity(1, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 119) + 126, (char) (0 >>> (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), objArr2);
        return Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) objArr2[0]).intern(), false, true));
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<KybStartupConfigResult> PlaceComponentResult() {
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.lookAheadTest((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 17;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    private static final ObservableSource NetworkUserEntityData$$ExternalSyntheticLambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        ?? r3 = 0;
        final KybStartupConfigResult kybStartupConfigResult = new KybStartupConfigResult(r3, 1, r3);
        Object[] objArr = new Object[1];
        a(38 - Color.red(0), 18 - View.MeasureSpec.getMode(0), (char) Drawable.resolveOpacity(0, 0), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybStartupConfig$lambda-1$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = kybStartupConfigResult;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, KybStartupConfigResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybStartupConfig$lambda-1$$inlined$getConfigOnceReady$1.1
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
        int i = PlaceComponentResult + 5;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return observable;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<KybCompressQrConfig> getAuthRequestContext() {
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.getAuthRequestContext((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return flatMap;
        }
        return flatMap;
    }

    private static final ObservableSource moveToNextValue(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final KybCompressQrConfig kybCompressQrConfig = KybCompressQrConfig.INSTANCE.getDefault();
        Object[] objArr = new Object[1];
        a(24 - (Process.myPid() >> 22), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 14, (char) (59487 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybCompressQrConfig$lambda-2$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = kybCompressQrConfig;
                final boolean z = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, KybCompressQrConfig.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybCompressQrConfig$lambda-2$$inlined$getConfigOnceReady$1.1
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
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return observable;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<Boolean> scheduleImpl() {
        Observable map = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.PlaceComponentResult((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 79;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    private static final Boolean NetworkUserEntityData$$ExternalSyntheticLambda2(BaseTrafficType baseTrafficType) {
        Boolean valueOf;
        int i = PlaceComponentResult + 77;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'K' : 'U') != 'K') {
            try {
                Intrinsics.checkNotNullParameter(baseTrafficType, "");
                Object[] objArr = new Object[1];
                a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 106, 28 - KeyEvent.normalizeMetaState(0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr);
                valueOf = Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), false, true));
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getKeyRepeatTimeout() % 61) * 98, KeyEvent.normalizeMetaState(1) + 25, (char) (ExpandableListView.getPackedPositionForGroup(1) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(1) == 0L ? 0 : -1)), objArr2);
            valueOf = Boolean.valueOf(baseTrafficType.getAuthRequestContext(((String) objArr2[0]).intern(), false, true));
        }
        int i2 = PlaceComponentResult + 17;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 != 0) {
            return valueOf;
        }
        Object[] objArr3 = null;
        int length = objArr3.length;
        return valueOf;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<KybUrlsConfigWrapperResult> MyBillsEntityDataFactory() {
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.getErrorConfigVersion((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = BuiltInFictitiousFunctionClassFactory + 109;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 88 / 0;
            return flatMap;
        }
        return flatMap;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [id.dana.kyb.data.model.KybUrlsConfigResult, kotlin.jvm.internal.DefaultConstructorMarker] */
    private static final ObservableSource initRecordTimeStamp(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        ?? r3 = 0;
        final KybUrlsConfigWrapperResult kybUrlsConfigWrapperResult = new KybUrlsConfigWrapperResult(r3, 1, r3);
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getScrollBarSize() >> 8) + 80, ((Process.getThreadPriority(0) + 20) >> 6) + 8, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getUrlsConfig$lambda-4$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = kybUrlsConfigWrapperResult;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, KybUrlsConfigWrapperResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getUrlsConfig$lambda-4$$inlined$getConfigOnceReady$1.1
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
        try {
            int i = PlaceComponentResult + 95;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 == 0 ? 0 : 1) != 0) {
                    return observable;
                }
                int length = r3.length;
                return observable;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<List<String>> BuiltInFictitiousFunctionClassFactory() {
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'S' : (char) 31) != 31) {
            Object[] objArr = null;
            int length = objArr.length;
            return flatMap;
        }
        return flatMap;
    }

    private static final ObservableSource GetContactSyncConfig(final BaseTrafficType baseTrafficType) {
        final List<String> listOf;
        try {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
            listOf = CollectionsKt.listOf((Object[]) new String[]{KybServiceCategory.REQUEST_PAYMENT, KybServiceCategory.PRODUCT_CATALOG, KybServiceCategory.QRIS_BUSINESS});
            Object[] objArr = new Object[1];
            a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 56, 24 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr);
            final String intern = ((String) objArr[0]).intern();
            Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybTopServiceCategories$lambda-5$$inlined$getConfigOnceReady$1
                final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                    Intrinsics.checkNotNullParameter(observableEmitter, "");
                    BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                    ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                    String str = intern;
                    String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                    Object obj = listOf;
                    final boolean z = this.$MyBillsEntityDataFactory;
                    final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                    final String str2 = intern;
                    MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybTopServiceCategories$lambda-5$$inlined$getConfigOnceReady$1.1
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
            int i = BuiltInFictitiousFunctionClassFactory + 89;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return observable;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<List<String>> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.BuiltInFictitiousFunctionClassFactory((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 99;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    private static final ObservableSource scheduleImpl(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
        final List<String> PlaceComponentResult2 = KybDefaultServices.PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(ViewConfiguration.getJumpTapTimeout() >> 16, (ViewConfiguration.getTouchSlop() >> 8) + 24, (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybAllServiceCategories$lambda-6$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $BuiltInFictitiousFunctionClassFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = PlaceComponentResult2;
                final boolean z = this.$BuiltInFictitiousFunctionClassFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, List.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybAllServiceCategories$lambda-6$$inlined$getConfigOnceReady$1.1
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
        int i = PlaceComponentResult + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return observable;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Observable<KybServiceResult> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitKybConfigEntityData.PlaceComponentResult(p0, (BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 65 / 0;
            return flatMap;
        }
        return flatMap;
    }

    private static final ObservableSource MyBillsEntityDataFactory(final String str, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final KybServiceResult kybServiceResult = new KybServiceResult(Boolean.FALSE, null, null, null, null, 30, null);
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybServiceByCategory$lambda-7$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $PlaceComponentResult = true;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = kybServiceResult;
                final boolean z = this.$PlaceComponentResult;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory2, KybServiceResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$getKybServiceByCategory$lambda-7$$inlined$getConfigOnceReady$1.1
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
        int i = BuiltInFictitiousFunctionClassFactory + 31;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return observable;
    }

    @Override // id.dana.kyb.data.KybConfigEntityData
    public final Completable KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Completable PlaceComponentResult2 = Completable.PlaceComponentResult(new Action() { // from class: id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Action
                public final void run() {
                    SplitKybConfigEntityData.PlaceComponentResult(SplitKybConfigEntityData.this, p0, p1);
                }
            });
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            int i = PlaceComponentResult + 67;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return PlaceComponentResult2;
            }
            return PlaceComponentResult2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void getAuthRequestContext(SplitKybConfigEntityData splitKybConfigEntityData, String str, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(splitKybConfigEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SplitFacade splitFacade = splitKybConfigEntityData.KClassImpl$Data$declaredNonStaticMembers$2;
        SplitFacade.PlaceComponentResult(ChallengeControl.Key.MERCHANT_ID, str);
        SplitFacade.PlaceComponentResult("kyb_tier", str2);
        int i3 = BuiltInFictitiousFunctionClassFactory + 3;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            try {
                int i3 = $11 + 87;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'A' : (char) 23) != 'A') {
                    break;
                }
                int i5 = $11 + 69;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
            String str = new String(cArr);
            int i7 = $10 + 37;
            $11 = i7 % 128;
            if (i7 % 2 != 0) {
                objArr[0] = str;
                return;
            }
            int i8 = 68 / 0;
            objArr[0] = str;
        } catch (Exception e2) {
            throw e2;
        }
    }
}
