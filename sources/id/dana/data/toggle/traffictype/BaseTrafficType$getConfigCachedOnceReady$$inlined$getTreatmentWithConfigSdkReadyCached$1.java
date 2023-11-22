package id.dana.data.toggle.traffictype;

import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006*\u00028\u00008\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lio/reactivex/ObservableEmitter;", "p0", "", "subscribe", "(Lio/reactivex/ObservableEmitter;)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes8.dex */
public final class BaseTrafficType$getConfigCachedOnceReady$$inlined$getTreatmentWithConfigSdkReadyCached$1<T> implements ObservableOnSubscribe {
    final /* synthetic */ String $BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ boolean $PlaceComponentResult;
    final /* synthetic */ Object $getAuthRequestContext;
    final /* synthetic */ BaseTrafficType KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<T> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.$BuiltInFictitiousFunctionClassFactory);
        ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
        String str = this.$BuiltInFictitiousFunctionClassFactory;
        String BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.reifiedOperationMarker(4, "T");
        Object obj = this.$getAuthRequestContext;
        final boolean z = this.$PlaceComponentResult;
        final BaseTrafficType baseTrafficType = this.KClassImpl$Data$declaredNonStaticMembers$2;
        final String str2 = this.$BuiltInFictitiousFunctionClassFactory;
        MyBillsEntityDataFactory.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory, Object.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigCachedOnceReady$$inlined$getTreatmentWithConfigSdkReadyCached$1.1
            @Override // id.dana.lib.toggle.ToggleCallback
            public final void onComplete(String p0, T p1) {
                Unit unit;
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 != null) {
                    boolean z2 = z;
                    BaseTrafficType baseTrafficType2 = baseTrafficType;
                    String str3 = str2;
                    ObservableEmitter observableEmitter2 = observableEmitter;
                    if (z2 && Intrinsics.areEqual(p0, "control")) {
                        baseTrafficType2.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter2.onError(new UnexpectedTreatment(str3));
                    } else {
                        baseTrafficType2.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Received", ConfigType.ASYNC);
                        observableEmitter2.onNext(p1);
                        observableEmitter2.onComplete();
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    BaseTrafficType baseTrafficType3 = baseTrafficType;
                    String str4 = str2;
                    ObservableEmitter observableEmitter3 = observableEmitter;
                    baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                    observableEmitter3.onError(new SplitNull(str4));
                }
            }

            @Override // id.dana.lib.toggle.ToggleCallback
            public final void onError() {
                baseTrafficType.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                observableEmitter.onError(new SplitException("Error when get toggle config"));
            }
        }, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
    }
}
