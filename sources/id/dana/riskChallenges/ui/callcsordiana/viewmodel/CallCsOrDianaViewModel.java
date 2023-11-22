package id.dana.riskChallenges.ui.callcsordiana.viewmodel;

import androidx.view.ViewModel;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.featureconfig.interactor.CheckHelpButtonChatbotFeature;
import id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/interactor/CheckHelpButtonChatbotFeature;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/interactor/CheckHelpButtonChatbotFeature;", "Lkotlinx/coroutines/flow/StateFlow;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/StateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/domain/featureconfig/interactor/CheckHelpButtonChatbotFeature;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallCsOrDianaViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CheckHelpButtonChatbotFeature getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final StateFlow<CallCsOrDianaUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MutableStateFlow<CallCsOrDianaUiState> PlaceComponentResult;

    @Inject
    public CallCsOrDianaViewModel(CheckHelpButtonChatbotFeature checkHelpButtonChatbotFeature) {
        Intrinsics.checkNotNullParameter(checkHelpButtonChatbotFeature, "");
        this.getAuthRequestContext = checkHelpButtonChatbotFeature;
        MutableStateFlow<CallCsOrDianaUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(CallCsOrDianaUiState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ String BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        String str4 = str;
        if (!StringsKt.contains$default((CharSequence) str4, (CharSequence) "/i/dana-info/resolution-center/chatbot", false, 2, (Object) null)) {
            if (str4.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(str);
                return sb.toString();
            }
            return DanaUrl.DANA_OTP_ARTICLE;
        }
        String replace = new Regex("^(\\+628)").replace(str2, "62-8");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://m.dana.id");
        sb2.append(str);
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(replace);
        sb3.append("_forgotPinLogin_");
        sb3.append(str3);
        return StringsKt.replace$default(StringsKt.replace$default(obj, "{ymAuthenticationToken}", sb3.toString(), false, 4, (Object) null), "{phoneNumber}", replace, false, 4, (Object) null);
    }
}
