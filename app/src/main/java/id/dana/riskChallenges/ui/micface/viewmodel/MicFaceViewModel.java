package id.dana.riskChallenges.ui.micface.viewmodel;

import androidx.view.ViewModel;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.riskChallenges.ui.micface.viewmodel.MicFaceUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0004\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0012\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "", "getAuthRequestContext", "()Z", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "p0", "", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "PlaceComponentResult", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "p1", "<init>", "(Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MicFaceViewModel extends ViewModel implements DanaVizTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final FaceAuthentication MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final StateFlow<MicFaceUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DanaVizTrackerImpl getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MutableStateFlow<MicFaceUiState> PlaceComponentResult;

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setSource(p0);
    }

    @Inject
    public MicFaceViewModel(FaceAuthentication faceAuthentication, DanaVizTrackerImpl danaVizTrackerImpl) {
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        this.MyBillsEntityDataFactory = faceAuthentication;
        this.getAuthRequestContext = danaVizTrackerImpl;
        MutableStateFlow<MicFaceUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(MicFaceUiState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow;
        this.BuiltInFictitiousFunctionClassFactory = FlowKt.asStateFlow(MutableStateFlow);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.length() == 0;
    }
}
