package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.activation.interactor.SetDeviceFeedFeatureSwitch;
import id.dana.feeds.domain.activation.interactor.UpdateFeedUserConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.social.contract.PrivacySettingContract;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001b¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006*\u00020\u00060\u00060\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/social/contract/PrivacySettingPresenter;", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "onDestroy", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "PlaceComponentResult", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "getAuthRequestContext", "Lid/dana/feeds/domain/activation/interactor/SetDeviceFeedFeatureSwitch;", "Lid/dana/feeds/domain/activation/interactor/SetDeviceFeedFeatureSwitch;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/feeds/domain/activation/interactor/UpdateFeedUserConfig;", "moveToNextValue", "Lid/dana/feeds/domain/activation/interactor/UpdateFeedUserConfig;", "getErrorConfigVersion", "Lid/dana/social/contract/PrivacySettingContract$View;", "scheduleImpl", "Lid/dana/social/contract/PrivacySettingContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;Lid/dana/feeds/domain/activation/interactor/SetDeviceFeedFeatureSwitch;Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;Lid/dana/feeds/domain/activation/interactor/UpdateFeedUserConfig;Lid/dana/social/contract/PrivacySettingContract$View;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrivacySettingPresenter implements PrivacySettingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SaveShareFeedConsent getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetShareFeedConsent PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SetDeviceFeedFeatureSwitch BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CompositeDisposable MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PublishSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final UpdateFeedUserConfig getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final PrivacySettingContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public PrivacySettingPresenter(GetShareFeedConsent getShareFeedConsent, SetDeviceFeedFeatureSwitch setDeviceFeedFeatureSwitch, SaveShareFeedConsent saveShareFeedConsent, UpdateFeedUserConfig updateFeedUserConfig, PrivacySettingContract.View view) {
        Intrinsics.checkNotNullParameter(getShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(setDeviceFeedFeatureSwitch, "");
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(updateFeedUserConfig, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getShareFeedConsent;
        this.BuiltInFictitiousFunctionClassFactory = setDeviceFeedFeatureSwitch;
        this.getAuthRequestContext = saveShareFeedConsent;
        this.getErrorConfigVersion = updateFeedUserConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.MyBillsEntityDataFactory = compositeDisposable;
        compositeDisposable.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.debounce(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.social.contract.PrivacySettingPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PrivacySettingPresenter.getAuthRequestContext(PrivacySettingPresenter.this, (Boolean) obj);
            }
        }));
    }

    @Override // id.dana.social.contract.PrivacySettingContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$getShareFeedConsent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                PrivacySettingContract.View view;
                view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$getShareFeedConsent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                PrivacySettingContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.KClassImpl$Data$declaredNonStaticMembers$2(true);
            }
        });
    }

    @Override // id.dana.social.contract.PrivacySettingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.valueOf(p0));
    }

    @Override // id.dana.social.contract.PrivacySettingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        final boolean z = false;
        this.BuiltInFictitiousFunctionClassFactory.execute(Boolean.FALSE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$setFeedFeatureSwitch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                PrivacySettingContract.View view;
                view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.getAuthRequestContext(z2);
                CompletableUseCase.execute$default(PrivacySettingPresenter.this.getErrorConfigVersion, NoParams.INSTANCE, null, null, 6, null);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$setFeedFeatureSwitch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                PrivacySettingContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.getErrorConfigVersion.dispose();
    }

    public static /* synthetic */ void getAuthRequestContext(final PrivacySettingPresenter privacySettingPresenter, Boolean bool) {
        Intrinsics.checkNotNullParameter(privacySettingPresenter, "");
        if (bool != null) {
            final boolean booleanValue = bool.booleanValue();
            privacySettingPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.showProgress();
            privacySettingPresenter.getAuthRequestContext.execute(Boolean.valueOf(booleanValue), new Function1<Unit, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$toggleShareFeedConsent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Unit unit) {
                    PrivacySettingContract.View view;
                    PrivacySettingContract.View view2;
                    Intrinsics.checkNotNullParameter(unit, "");
                    view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.dismissProgress();
                    view2 = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.BuiltInFictitiousFunctionClassFactory(booleanValue);
                }
            }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.PrivacySettingPresenter$toggleShareFeedConsent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                    invoke2(exc);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Exception exc) {
                    PrivacySettingContract.View view;
                    PrivacySettingContract.View view2;
                    Intrinsics.checkNotNullParameter(exc, "");
                    view = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.dismissProgress();
                    view2 = PrivacySettingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.MyBillsEntityDataFactory(booleanValue);
                }
            });
        }
    }
}
