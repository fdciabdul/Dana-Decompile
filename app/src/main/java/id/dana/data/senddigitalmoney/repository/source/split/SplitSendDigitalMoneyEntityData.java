package id.dana.data.senddigitalmoney.repository.source.split;

import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData;
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
import o.A;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000b"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/source/split/SplitSendDigitalMoneyEntityData;", "Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;", "p0", "Lid/dana/data/senddigitalmoney/repository/model/result/CardPrefixQueryResult;", "(Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;)Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitSendDigitalMoneyEntityData implements SendDigitalMoneyEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 269894804;
    private static int PlaceComponentResult = 1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SplitFacade BuiltInFictitiousFunctionClassFactory;

    public static /* synthetic */ ObservableSource PlaceComponentResult(BaseTrafficType baseTrafficType) {
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(baseTrafficType);
        int i3 = PlaceComponentResult + 121;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 == 0) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        Object obj = null;
        obj.hashCode();
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Inject
    public SplitSendDigitalMoneyEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.BuiltInFictitiousFunctionClassFactory = splitFacade;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x000f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData
    public final io.reactivex.Observable<id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult> KClassImpl$Data$declaredNonStaticMembers$2(id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> Ld
            kotlin.NotImplementedError r3 = new kotlin.NotImplementedError
            r0 = 1
            r1 = 0
            r3.<init>(r1, r0, r1)
            throw r3
        Ld:
            r3 = move-exception
            throw r3
        Lf:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest):io.reactivex.Observable");
    }

    @Override // id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable flatMap = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSendDigitalMoneyEntityData.PlaceComponentResult((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = PlaceComponentResult + 19;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object[] objArr = new Object[1];
        a(new char[]{65528, 11, '\f', '\t', 65532, 65526, 65530, 65528, '\t', 65531, 65526, 5, 6, 65526, 7, '\t', 65532, 65533, 0, 15, 65533, 65532}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 282, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 21, false, 20 - KeyEvent.keyCodeFromString(""), objArr);
        final String intern = ((String) objArr[0]).intern();
        final Boolean bool = Boolean.FALSE;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData$isCardNoPrefixEnabled$lambda-0$$inlined$getConfigOnceReady$1
            final /* synthetic */ boolean $getAuthRequestContext = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = bool;
                final boolean z = this.$getAuthRequestContext;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, Boolean.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData$isCardNoPrefixEnabled$lambda-0$$inlined$getConfigOnceReady$1.1
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
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return observable;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if (a2.MyBillsEntityDataFactory >= i2) {
                break;
            }
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
                int i5 = $10 + 105;
                $11 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i3 > 0) {
            int i7 = $10 + 65;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? JSONLexer.EOI : (char) 6) != 6) {
            char[] cArr4 = new char[i2];
            try {
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2);
    }
}
