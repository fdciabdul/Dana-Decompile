package id.dana.riskChallenges.ui.verifypin;

import androidx.view.ViewModel;
import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature;
import id.dana.riskChallenges.domain.verifypassword.interactor.VerifyPasswordObservable;
import id.dana.riskChallenges.ui.verifypin.VerifyPinUiState;
import id.dana.riskChallenges.ui.verifypin.model.VerifyPinModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;)V", "onCleared", "()V", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/CheckKnowledgeBasedAuthFeature;", "Ldagger/Lazy;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "lookAheadTest", "", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/domain/verifypassword/interactor/VerifyPasswordObservable;", "moveToNextValue", "scheduleImpl", "p1", "p2", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getErrorConfigVersion;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MutableStateFlow<VerifyPinUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final Lazy<VerifyPasswordObservable> moveToNextValue;
    public String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<CheckKnowledgeBasedAuthFeature> MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final StateFlow<VerifyPinUiState> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetPhoneNumber> getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String lookAheadTest;

    @Inject
    public VerifyPinViewModel(Lazy<CheckKnowledgeBasedAuthFeature> lazy, Lazy<VerifyPasswordObservable> lazy2, Lazy<GetPhoneNumber> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.MyBillsEntityDataFactory = lazy;
        this.moveToNextValue = lazy2;
        this.getAuthRequestContext = lazy3;
        MutableStateFlow<VerifyPinUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(VerifyPinUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void getAuthRequestContext() {
        MutableStateFlow<VerifyPinUiState> mutableStateFlow = this.BuiltInFictitiousFunctionClassFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), VerifyPinUiState.None.INSTANCE));
    }

    public final void PlaceComponentResult(final VerifyPinModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.get().execute(new DefaultObserver<String>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel$getPhoneNumber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                MutableStateFlow mutableStateFlow;
                Object value;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                mutableStateFlow = VerifyPinViewModel.this.BuiltInFictitiousFunctionClassFactory;
                VerifyPinModel verifyPinModel = p0;
                do {
                    value = mutableStateFlow.getValue();
                    VerifyPinUiState verifyPinUiState = (VerifyPinUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new VerifyPinUiState.VerifySuccess(verifyPinModel, str)));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(p02, "");
                mutableStateFlow = VerifyPinViewModel.this.BuiltInFictitiousFunctionClassFactory;
                VerifyPinModel verifyPinModel = p0;
                do {
                    value = mutableStateFlow.getValue();
                    VerifyPinUiState verifyPinUiState = (VerifyPinUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new VerifyPinUiState.VerifySuccess(verifyPinModel, "")));
            }
        });
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.MyBillsEntityDataFactory.get().dispose();
        this.moveToNextValue.get().dispose();
        this.getAuthRequestContext.get().dispose();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r0.equals("AE15102058020051") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if (r0.equals(id.dana.riskChallenges.ui.verifypin.VerifyPinErrorCode.ONE_HOUR_LOGIN_FREEZE) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
    
        r0 = id.dana.riskChallenges.ui.verifypin.VerifyPinUiState.VerifyPINOneHourLoginFreeze.INSTANCE;
     */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void getAuthRequestContext(id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel r14, java.lang.Throwable r15) {
        /*
            boolean r0 = r15 instanceof id.dana.network.exception.NoInternetConnectionException
            java.lang.String r1 = ""
            r2 = 2
            r3 = 0
            if (r0 == 0) goto L1a
            id.dana.utils.StringWrapper$ResValue r15 = new id.dana.utils.StringWrapper$ResValue
            int r0 = id.dana.riskChallenges.R.string.general_no_connection_error_message
            r15.<init>(r0, r3, r2, r3)
            id.dana.utils.StringWrapper r15 = (id.dana.utils.StringWrapper) r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed r0 = new id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed
            r0.<init>(r1, r15)
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
            goto La9
        L1a:
            boolean r0 = r15 instanceof id.dana.network.exception.NetworkException
            if (r0 == 0) goto L99
            id.dana.network.exception.NetworkException r15 = (id.dana.network.exception.NetworkException) r15
            java.lang.String r0 = r15.getErrorCode()
            if (r0 == 0) goto L80
            int r4 = r0.hashCode()
            switch(r4) {
                case -1813061125: goto L72;
                case 408588712: goto L51;
                case 1658411398: goto L37;
                case 1787494118: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L80
        L2e:
            java.lang.String r4 = "AE15102058020051"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L7a
            goto L80
        L37:
            java.lang.String r4 = "AE15002058020050"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L80
            id.dana.utils.StringWrapper$ResValue r15 = new id.dana.utils.StringWrapper$ResValue
            int r1 = id.dana.riskChallenges.R.string.res_0x7f13049c_kclassimpl_data_declarednonstaticmembers_2
            r15.<init>(r1, r3, r2, r3)
            id.dana.utils.StringWrapper r15 = (id.dana.utils.StringWrapper) r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyPINIncorrect r1 = new id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyPINIncorrect
            r1.<init>(r0, r15)
            r0 = r1
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
            goto La9
        L51:
            java.lang.String r4 = "AE15101858018086"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L80
            id.dana.riskChallenges.ui.verifypin.model.VerifyPinModel r15 = new id.dana.riskChallenges.ui.verifypin.model.VerifyPinModel
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 47
            r13 = 0
            java.lang.String r10 = "REJECT"
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r14.PlaceComponentResult(r15)
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$None r15 = id.dana.riskChallenges.ui.verifypin.VerifyPinUiState.None.INSTANCE
            r0 = r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
            goto La9
        L72:
            java.lang.String r4 = "AE15112158065808"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L80
        L7a:
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyPINOneHourLoginFreeze r15 = id.dana.riskChallenges.ui.verifypin.VerifyPinUiState.VerifyPINOneHourLoginFreeze.INSTANCE
            r0 = r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
            goto La9
        L80:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            id.dana.utils.StringWrapper$ResValue r1 = new id.dana.utils.StringWrapper$ResValue
            int r4 = id.dana.riskChallenges.R.string.general_error_message
            r1.<init>(r4, r3, r2, r3)
            id.dana.utils.StringWrapper r1 = (id.dana.utils.StringWrapper) r1
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed r2 = new id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed
            id.dana.utils.StringWrapper r15 = id.dana.riskChallenges.ui.util.StringWrapperExtKt.getAuthRequestContext(r15, r1)
            r2.<init>(r0, r15)
            r0 = r2
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
            goto La9
        L99:
            id.dana.utils.StringWrapper$ResValue r15 = new id.dana.utils.StringWrapper$ResValue
            int r0 = id.dana.riskChallenges.R.string.general_error_message
            r15.<init>(r0, r3, r2, r3)
            id.dana.utils.StringWrapper r15 = (id.dana.utils.StringWrapper) r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed r0 = new id.dana.riskChallenges.ui.verifypin.VerifyPinUiState$VerifyFailed
            r0.<init>(r1, r15)
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r0 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r0
        La9:
            kotlinx.coroutines.flow.MutableStateFlow<id.dana.riskChallenges.ui.verifypin.VerifyPinUiState> r14 = r14.BuiltInFictitiousFunctionClassFactory
        Lab:
            java.lang.Object r15 = r14.getValue()
            r1 = r15
            id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r1 = (id.dana.riskChallenges.ui.verifypin.VerifyPinUiState) r1
            boolean r15 = r14.compareAndSet(r15, r0)
            if (r15 == 0) goto Lab
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel.getAuthRequestContext(id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel, java.lang.Throwable):void");
    }
}
