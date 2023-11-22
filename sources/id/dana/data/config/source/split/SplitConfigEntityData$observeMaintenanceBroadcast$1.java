package id.dana.data.config.source.split;

import android.text.AndroidCharacter;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/reactivex/Observable;", "Lid/dana/data/config/source/amcs/result/MaintenanceBroadcastResult;", BridgeDSL.INVOKE, "()Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SplitConfigEntityData$observeMaintenanceBroadcast$1 extends Lambda implements Function0<Observable<MaintenanceBroadcastResult>> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int $getAuthRequestContext = 1;
    private static char MyBillsEntityDataFactory = 42065;
    private static char[] PlaceComponentResult = {37290, 37286, 37280, 37293, 37291, 37292, 37264, 37309, 37288, 37282, 37294, 37281, 37289, 37306, 37308, 37307};
    final /* synthetic */ SplitConfigEntityData this$0;

    /* renamed from: $r8$lambda$sSMwHCm-qICqg8lU9Dov8ctCAiw  reason: not valid java name */
    public static /* synthetic */ ObservableSource m1160$r8$lambda$sSMwHCmqICqg8lU9Dov8ctCAiw(BaseTrafficType baseTrafficType) {
        try {
            int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 21;
            try {
                $getAuthRequestContext = i % 128;
                int i2 = i % 2;
                ObservableSource m1161invoke$lambda0 = m1161invoke$lambda0(baseTrafficType);
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 95;
                $getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return m1161invoke$lambda0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitConfigEntityData$observeMaintenanceBroadcast$1(SplitConfigEntityData splitConfigEntityData) {
        super(0);
        this.this$0 = splitConfigEntityData;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Observable<MaintenanceBroadcastResult> invoke() {
        int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        $getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Observable<MaintenanceBroadcastResult> invoke = invoke();
        int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        $getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return invoke;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Observable<MaintenanceBroadcastResult> invoke() {
        Observable<MaintenanceBroadcastResult> onErrorResumeNext = SplitConfigEntityData.access$getSplitFacade$p(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitConfigEntityData$observeMaintenanceBroadcast$1.m1160$r8$lambda$sSMwHCmqICqg8lU9Dov8ctCAiw((BaseTrafficType) obj);
            }
        }).onErrorResumeNext(SplitConfigEntityData.INSTANCE.onJSONErrorReturnDefault(MaintenanceBroadcastResult.createDefault()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        int i = $getAuthRequestContext + 57;
        $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final ObservableSource m1161invoke$lambda0(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final MaintenanceBroadcastResult createDefault = MaintenanceBroadcastResult.createDefault();
        final boolean z = false;
        Object[] objArr = new Object[1];
        a(new char[]{0, 4, 11, 14, 15, 5, 2, 4, '\n', 11, 3, '\t', '\f', 3, '\b', 11, '\t', 7, 2, 4, 7, 11, 6, 14, 5, 6, 14, 2, '\r', 3, '\b', '\t'}, (byte) (24 - TextUtils.getOffsetAfter("", 0)), AndroidCharacter.getMirror('0') - 16, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1$invoke$lambda-0$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = createDefault;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, MaintenanceBroadcastResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1$invoke$lambda-0$$inlined$getConfigOnceReady$1.1
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
        int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        $getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '?' : (char) 23) != 23) {
            Object[] objArr2 = null;
            int length = objArr2.length;
            return observable;
        }
        return observable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c1, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ec, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
    
        r7 = id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1.$10 + 31;
        id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1.$11 = r7 % 128;
        r7 = r7 % 2;
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0128, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012a, code lost:
    
        r7 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012d, code lost:
    
        r7 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012f, code lost:
    
        if (r7 == 14) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0131, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014d, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.config.source.split.SplitConfigEntityData$observeMaintenanceBroadcast$1.a(char[], byte, int, java.lang.Object[]):void");
    }
}
