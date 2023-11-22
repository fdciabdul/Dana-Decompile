package id.dana.social.contract.share;

import id.dana.base.AbstractContractKt;
import id.dana.base.BasePresenter;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.social.contract.share.ShareToFeedsContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\t\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/social/contract/share/ShareToFeedsPresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "", "dispose", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "onDestroy", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;", "Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;", "Lid/dana/feeds/domain/share/interactor/GetFeedsSharingLastCheckedState;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/interactor/GetFeedsSharingLastCheckedState;", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "getAuthRequestContext", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "Lid/dana/feeds/domain/share/interactor/SaveFeedsSharingLastCheckedState;", "Lid/dana/feeds/domain/share/interactor/SaveFeedsSharingLastCheckedState;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/social/contract/share/ShareToFeedsContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/contract/share/ShareToFeedsContract$View;", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;Lid/dana/feeds/domain/share/interactor/GetFeedsSharingLastCheckedState;Lid/dana/feeds/domain/share/interactor/SaveFeedsSharingLastCheckedState;Lid/dana/social/contract/share/ShareToFeedsContract$View;Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareToFeedsPresenter extends BasePresenter implements ShareToFeedsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SaveShareFeedConsent PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SaveFeedsSharingLastCheckedState getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final GetFeedsSharingLastCheckedState BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ShareToFeedsContract.View getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetFeedStatus KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetShareFeedConsent MyBillsEntityDataFactory;

    @Inject
    public ShareToFeedsPresenter(GetShareFeedConsent getShareFeedConsent, SaveShareFeedConsent saveShareFeedConsent, GetFeedsSharingLastCheckedState getFeedsSharingLastCheckedState, SaveFeedsSharingLastCheckedState saveFeedsSharingLastCheckedState, ShareToFeedsContract.View view, GetFeedStatus getFeedStatus) {
        Intrinsics.checkNotNullParameter(getShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(getFeedsSharingLastCheckedState, "");
        Intrinsics.checkNotNullParameter(saveFeedsSharingLastCheckedState, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getFeedStatus, "");
        this.MyBillsEntityDataFactory = getShareFeedConsent;
        this.PlaceComponentResult = saveShareFeedConsent;
        this.BuiltInFictitiousFunctionClassFactory = getFeedsSharingLastCheckedState;
        this.getAuthRequestContext = saveFeedsSharingLastCheckedState;
        this.getErrorConfigVersion = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getFeedStatus;
    }

    @Override // id.dana.social.contract.share.ShareToFeedsContract.Presenter
    public final void PlaceComponentResult() {
        this.getErrorConfigVersion.showProgress();
        this.MyBillsEntityDataFactory.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$initShareToFeeds$1
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
                ShareToFeedsContract.View view;
                view = ShareToFeedsPresenter.this.getErrorConfigVersion;
                view.BuiltInFictitiousFunctionClassFactory(z);
                if (z) {
                    final ShareToFeedsPresenter shareToFeedsPresenter = ShareToFeedsPresenter.this;
                    shareToFeedsPresenter.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$getLastCheckedState$1
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
                            ShareToFeedsContract.View view2;
                            ShareToFeedsContract.View view3;
                            view2 = ShareToFeedsPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = ShareToFeedsPresenter.this.getErrorConfigVersion;
                            view3.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$getLastCheckedState$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            ShareToFeedsContract.View view2;
                            ShareToFeedsContract.View view3;
                            Intrinsics.checkNotNullParameter(th, "");
                            view2 = ShareToFeedsPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = ShareToFeedsPresenter.this.getErrorConfigVersion;
                            view3.KClassImpl$Data$declaredNonStaticMembers$2();
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_TO_FEEDS_TAG, th.getMessage(), th);
                        }
                    });
                }
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$initShareToFeeds$2
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
                ShareToFeedsContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = ShareToFeedsPresenter.this.getErrorConfigVersion;
                view.BuiltInFictitiousFunctionClassFactory(false);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_TO_FEEDS_TAG, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.social.contract.share.ShareToFeedsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.execute(Boolean.TRUE, new Function1<Unit, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$setShareFeedConfigToTrue$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$setShareFeedConfigToTrue$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_TO_FEEDS_TAG, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.social.contract.share.ShareToFeedsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$getFeedStatus$1
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
                ShareToFeedsContract.View view;
                view = ShareToFeedsPresenter.this.getErrorConfigVersion;
                view.getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.share.ShareToFeedsPresenter$getFeedStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ShareToFeedsContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = ShareToFeedsPresenter.this.getErrorConfigVersion;
                view.getAuthRequestContext(false);
            }
        });
    }

    @Override // id.dana.base.BasePresenter
    public final void dispose() {
        super.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        dispose();
    }
}
