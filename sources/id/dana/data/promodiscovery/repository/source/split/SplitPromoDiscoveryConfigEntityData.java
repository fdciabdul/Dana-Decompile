package id.dana.data.promodiscovery.repository.source.split;

import android.media.AudioTrack;
import android.text.TextUtils;
import id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse;
import id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryConfigGenerator;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.E;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/split/SplitPromoDiscoveryConfigEntityData;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "", "userId", "Lio/reactivex/Observable;", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getFourKingsLocal", "(Ljava/lang/String;)Lio/reactivex/Observable;", "fourKingsTypes", "Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "getFourKingsPromo", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "searchCriteriaMap", "Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;", "getPromoDanaDeals", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "getPromoDiscoveryConfig", "()Lio/reactivex/Observable;", "fourKingsPromo", "", "setFourKingsLocal", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitPromoDiscoveryConfigEntityData implements PromoDiscoveryEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -580143351;
    private static int MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 13492;
    private static long getAuthRequestContext = 4360990799332652212L;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$hUURLSIW1oGaoZVHOzdOwX2HglI(BaseTrafficType baseTrafficType) {
        int i = MyBillsEntityDataFactory + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 == 0 ? '\b' : 'Q';
        ObservableSource m1643getPromoDiscoveryConfig$lambda0 = m1643getPromoDiscoveryConfig$lambda0(baseTrafficType);
        if (c != 'Q') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 73;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return m1643getPromoDiscoveryConfig$lambda0;
    }

    @Inject
    public SplitPromoDiscoveryConfigEntityData(SplitFacade splitFacade) {
        try {
            Intrinsics.checkNotNullParameter(splitFacade, "");
            try {
                this.splitFacade = splitFacade;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoDiscoveryEntity> getPromoDiscoveryConfig() {
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.promodiscovery.repository.source.split.SplitPromoDiscoveryConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitPromoDiscoveryConfigEntityData.$r8$lambda$hUURLSIW1oGaoZVHOzdOwX2HglI((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: getPromoDiscoveryConfig$lambda-0  reason: not valid java name */
    private static final ObservableSource m1643getPromoDiscoveryConfig$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final PromoDiscoveryEntity generatePromoDiscoveryConfig = PromoDiscoveryConfigGenerator.INSTANCE.generatePromoDiscoveryConfig();
        final boolean z = true;
        Object[] objArr = new Object[1];
        a(new char[]{724, 48949, 20302, 12939, 5513, 13251, 53480, 20648, 18900, 47046, 63045, 6854, 23420, 42292, 33136, 56275, 17915, 27141, 35974}, new char[]{57554, 20403, 49608, 19562}, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 27328), new char[]{0, 0, 0, 0}, (-934300704) - TextUtils.indexOf("", ""), objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.promodiscovery.repository.source.split.SplitPromoDiscoveryConfigEntityData$getPromoDiscoveryConfig$lambda-0$$inlined$getConfigCachedOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = generatePromoDiscoveryConfig;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, PromoDiscoveryEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.promodiscovery.repository.source.split.SplitPromoDiscoveryConfigEntityData$getPromoDiscoveryConfig$lambda-0$$inlined$getConfigCachedOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(value);
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
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
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
        int i = BuiltInFictitiousFunctionClassFactory + 19;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return observable;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<ProductInfoResponse> getPromoDanaDeals(Map<String, String> searchCriteriaMap) {
        Intrinsics.checkNotNullParameter(searchCriteriaMap, "");
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoFourKingsResponse> getFourKingsPromo(List<String> fourKingsTypes) {
        Intrinsics.checkNotNullParameter(fourKingsTypes, "");
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<List<FourKingsPromoModel>> getFourKingsLocal(String userId) {
        Intrinsics.checkNotNullParameter(userId, "");
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<Unit> setFourKingsLocal(String userId, List<FourKingsPromoModel> fourKingsPromo) {
        try {
            Intrinsics.checkNotNullParameter(userId, "");
            Intrinsics.checkNotNullParameter(fourKingsPromo, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 19 : Typography.amp) == '&') {
                break;
            }
            int i2 = $11 + 25;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i6 = $11 + 17;
        $10 = i6 % 128;
        if ((i6 % 2 != 0 ? (char) 7 : 'Q') != 7) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
