package id.dana.sendmoney_v2.x2l.contract;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.x2l.interactor.GetSocialLinks;
import id.dana.domain.sendmoney.x2l.model.SocialLink;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;
import id.dana.sendmoney_v2.x2l.model.SocialLinkModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorPresenter;", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Lid/dana/domain/sendmoney/x2l/interactor/GetSocialLinks;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/sendmoney/x2l/interactor/GetSocialLinks;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$View;", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$View;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$View;Lid/dana/domain/sendmoney/x2l/interactor/GetSocialLinks;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendToLinkSelectorPresenter implements SendToLinkSelectorContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SendToLinkSelectorContract.View MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetSocialLinks BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SendToLinkSelectorPresenter(SendToLinkSelectorContract.View view, GetSocialLinks getSocialLinks) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSocialLinks, "");
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = getSocialLinks;
    }

    @Override // id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<List<? extends SocialLink>, Unit>() { // from class: id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorPresenter$getSocialLinks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends SocialLink> list) {
                invoke2((List<SocialLink>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<SocialLink> list) {
                SendToLinkSelectorContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = SendToLinkSelectorPresenter.this.MyBillsEntityDataFactory;
                view.BuiltInFictitiousFunctionClassFactory(SocialLinkModelKt.BuiltInFictitiousFunctionClassFactory(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorPresenter$getSocialLinks$2
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
                SendToLinkSelectorContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SendToLinkSelectorPresenter.this.MyBillsEntityDataFactory;
                view.onError(th.getMessage());
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SENDMONEY_SOCIAL_LINK_TAG, message != null ? message : "", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
