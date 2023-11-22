package id.dana.data.miniprogram.source.split;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import id.dana.data.miniprogram.model.StoreStateConfigData;
import id.dana.data.miniprogram.source.ConfigStoreStateData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o.whenAvailable;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007"}, d2 = {"Lid/dana/data/miniprogram/source/split/SplitConfigStoreStateEntityData;", "Lid/dana/data/miniprogram/source/ConfigStoreStateData;", "Lio/reactivex/Observable;", "Lid/dana/data/miniprogram/model/StoreStateConfigData;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitConfigStoreStateEntityData implements ConfigStoreStateData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SplitFacade PlaceComponentResult;
    private static char[] getAuthRequestContext = {22926, 36628, 62642, 55813, 907, 26927, 24251, 33847, 60804, 54063, 14545, 28239, 22467, 48477};
    private static long BuiltInFictitiousFunctionClassFactory = -7241925454391794231L;

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Object obj = null;
        ObservableSource PlaceComponentResult2 = PlaceComponentResult(baseTrafficType);
        if (!z) {
            obj.hashCode();
        }
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 == 0 ? '_' : '\n') != '_') {
                return PlaceComponentResult2;
            }
            obj.hashCode();
            return PlaceComponentResult2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitConfigStoreStateEntityData(SplitFacade splitFacade) {
        try {
            Intrinsics.checkNotNullParameter(splitFacade, "");
            this.PlaceComponentResult = splitFacade;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Observable<StoreStateConfigData> MyBillsEntityDataFactory() {
        try {
            try {
                Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.miniprogram.source.split.SplitConfigStoreStateEntityData$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitConfigStoreStateEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BaseTrafficType) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource PlaceComponentResult(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final StoreStateConfigData storeStateConfigData = new StoreStateConfigData();
        Object[] objArr = new Object[1];
        a((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 14 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 43693), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.miniprogram.source.split.SplitConfigStoreStateEntityData$getConfig$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $MyBillsEntityDataFactory = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = storeStateConfigData;
                final boolean z = this.$MyBillsEntityDataFactory;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, StoreStateConfigData.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.miniprogram.source.split.SplitConfigStoreStateEntityData$getConfig$lambda-0$$inlined$getConfigOnceReady$default$1.1
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
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'D' : '4') != 'D') {
            return observable;
        }
        Object obj = null;
        obj.hashCode();
        return observable;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                try {
                    if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'S' : (char) 5) != 'S') {
                        break;
                    }
                    int i3 = $10 + 45;
                    $11 = i3 % 128;
                    int i4 = i3 % 2;
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            char[] cArr = new char[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '\f' : 'H') != '\f') {
                    objArr[0] = new String(cArr);
                    return;
                }
                int i5 = $11 + 53;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
