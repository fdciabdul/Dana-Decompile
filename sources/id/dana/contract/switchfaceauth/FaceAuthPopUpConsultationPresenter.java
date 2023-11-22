package id.dana.contract.switchfaceauth;

import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ConsultFaceAuthPopUp;
import id.dana.domain.auth.face.interactor.IsNeedToSuggestFaceAuth;
import id.dana.domain.auth.face.interactor.IsNeverShowFaceAuthSuggestion;
import id.dana.domain.auth.face.interactor.SaveFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.SaveNeverShowFaceAuthSuggestion;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0015\u001a\u00020\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationPresenter;", "Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/domain/auth/face/interactor/IsNeedToSuggestFaceAuth;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/auth/face/interactor/IsNeedToSuggestFaceAuth;", "getAuthRequestContext", "Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;", "Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp;", "MyBillsEntityDataFactory", "Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp;", "Lid/dana/domain/auth/face/interactor/SaveFaceAuthSuggestionState;", "PlaceComponentResult", "Lid/dana/domain/auth/face/interactor/SaveFaceAuthSuggestionState;", "Lid/dana/domain/auth/face/interactor/SaveNeverShowFaceAuthSuggestion;", "Lid/dana/domain/auth/face/interactor/SaveNeverShowFaceAuthSuggestion;", "Lid/dana/domain/auth/face/interactor/IsNeverShowFaceAuthSuggestion;", "lookAheadTest", "Lid/dana/domain/auth/face/interactor/IsNeverShowFaceAuthSuggestion;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationContract$View;", "scheduleImpl", "Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationContract$View;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Lid/dana/contract/switchfaceauth/FaceAuthPopUpConsultationContract$View;Lid/dana/domain/auth/face/interactor/ConsultFaceAuthPopUp;Lid/dana/domain/auth/face/interactor/IsNeedToSuggestFaceAuth;Lid/dana/domain/auth/face/interactor/SaveFaceAuthSuggestionState;Lid/dana/domain/auth/face/interactor/ClearFaceAuthSuggestionState;Lid/dana/domain/auth/face/interactor/SaveNeverShowFaceAuthSuggestion;Lid/dana/domain/auth/face/interactor/IsNeverShowFaceAuthSuggestion;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FaceAuthPopUpConsultationPresenter implements FaceAuthPopUpConsultationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final IsNeedToSuggestFaceAuth getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ClearFaceAuthSuggestionState BuiltInFictitiousFunctionClassFactory;
    final ConsultFaceAuthPopUp MyBillsEntityDataFactory;
    private final SaveFaceAuthSuggestionState PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SaveNeverShowFaceAuthSuggestion KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final IsNeverShowFaceAuthSuggestion NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final FaceAuthPopUpConsultationContract.View lookAheadTest;

    @Inject
    public FaceAuthPopUpConsultationPresenter(FaceAuthPopUpConsultationContract.View view, ConsultFaceAuthPopUp consultFaceAuthPopUp, IsNeedToSuggestFaceAuth isNeedToSuggestFaceAuth, SaveFaceAuthSuggestionState saveFaceAuthSuggestionState, ClearFaceAuthSuggestionState clearFaceAuthSuggestionState, SaveNeverShowFaceAuthSuggestion saveNeverShowFaceAuthSuggestion, IsNeverShowFaceAuthSuggestion isNeverShowFaceAuthSuggestion) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(consultFaceAuthPopUp, "");
        Intrinsics.checkNotNullParameter(isNeedToSuggestFaceAuth, "");
        Intrinsics.checkNotNullParameter(saveFaceAuthSuggestionState, "");
        Intrinsics.checkNotNullParameter(clearFaceAuthSuggestionState, "");
        Intrinsics.checkNotNullParameter(saveNeverShowFaceAuthSuggestion, "");
        Intrinsics.checkNotNullParameter(isNeverShowFaceAuthSuggestion, "");
        this.lookAheadTest = view;
        this.MyBillsEntityDataFactory = consultFaceAuthPopUp;
        this.getAuthRequestContext = isNeedToSuggestFaceAuth;
        this.PlaceComponentResult = saveFaceAuthSuggestionState;
        this.BuiltInFictitiousFunctionClassFactory = clearFaceAuthSuggestionState;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = saveNeverShowFaceAuthSuggestion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = isNeverShowFaceAuthSuggestion;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
