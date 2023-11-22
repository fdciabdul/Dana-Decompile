package id.dana.myprofile;

import androidx.core.util.PatternsCompat;
import id.dana.base.AbstractContractKt;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.zendesk.interactor.CreateZendeskTicket;
import id.dana.domain.zendesk.model.ZendeskBasicTicket;
import id.dana.domain.zendesk.model.ZendeskBasicTicketResult;
import id.dana.social.contract.AccountDeactivationContract;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\t\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/myprofile/AccountDeactivationPresenter;", "Lid/dana/social/contract/AccountDeactivationContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/CharSequence;)Z", "Lio/reactivex/Observable;", "", "MyBillsEntityDataFactory", "(Lio/reactivex/Observable;)V", "()V", "Lid/dana/domain/zendesk/interactor/CreateZendeskTicket;", "Lid/dana/domain/zendesk/interactor/CreateZendeskTicket;", "", "getAuthRequestContext", "Ljava/lang/String;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/domain/account/interactor/GetUserId;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/social/contract/AccountDeactivationContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/contract/AccountDeactivationContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/social/contract/AccountDeactivationContract$View;Lid/dana/domain/zendesk/interactor/CreateZendeskTicket;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/domain/account/interactor/GetPhoneNumber;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountDeactivationPresenter implements AccountDeactivationContract.Presenter {
    private final AccountDeactivationContract.View BuiltInFictitiousFunctionClassFactory;
    private final GetUserId KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CreateZendeskTicket PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetPhoneNumber getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public AccountDeactivationPresenter(AccountDeactivationContract.View view, CreateZendeskTicket createZendeskTicket, GetUserId getUserId, GetPhoneNumber getPhoneNumber) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(createZendeskTicket, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = createZendeskTicket;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserId;
        this.getAuthRequestContext = getPhoneNumber;
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.social.contract.AccountDeactivationContract.Presenter
    public final void MyBillsEntityDataFactory(Observable<CharSequence> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.debounce(1000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DefaultObserver<CharSequence>() { // from class: id.dana.myprofile.AccountDeactivationPresenter$observeEmailAddress$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                CharSequence charSequence = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(charSequence, "");
                AccountDeactivationPresenter.MyBillsEntityDataFactory(AccountDeactivationPresenter.this, charSequence);
                AccountDeactivationPresenter.this.MyBillsEntityDataFactory = charSequence.toString();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                AccountDeactivationContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = AccountDeactivationPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(p02.getMessage());
            }
        });
    }

    private static boolean PlaceComponentResult(CharSequence p0) {
        return !(p0 == null || p0.length() == 0) && PatternsCompat.KClassImpl$Data$declaredNonStaticMembers$2.matcher(p0).matches();
    }

    @Override // id.dana.social.contract.AccountDeactivationContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.AccountDeactivationPresenter$sendTicketToZendesk$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                AccountDeactivationPresenter accountDeactivationPresenter = AccountDeactivationPresenter.this;
                final AccountDeactivationPresenter accountDeactivationPresenter2 = AccountDeactivationPresenter.this;
                accountDeactivationPresenter.getAuthRequestContext.execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.AccountDeactivationPresenter$getPhoneNumber$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj2) {
                        String str2 = (String) obj2;
                        Intrinsics.checkNotNullParameter(str2, "");
                        AccountDeactivationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(AccountDeactivationPresenter.this, str, str2);
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        r3.invoke();
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                AccountDeactivationContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                view = AccountDeactivationPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.PlaceComponentResult();
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final AccountDeactivationPresenter accountDeactivationPresenter, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Email Address: ");
        sb.append(accountDeactivationPresenter.MyBillsEntityDataFactory);
        sb.append("\nUser ID: ");
        sb.append(str);
        sb.append("\nPhone Number: ");
        sb.append(str2);
        accountDeactivationPresenter.PlaceComponentResult.execute(CreateZendeskTicket.Params.INSTANCE.create(new ZendeskBasicTicket("urgent", "Deactivate Account", sb.toString())), new Function1<ZendeskBasicTicketResult, Unit>() { // from class: id.dana.myprofile.AccountDeactivationPresenter$sendTicket$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ZendeskBasicTicketResult zendeskBasicTicketResult) {
                invoke2(zendeskBasicTicketResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ZendeskBasicTicketResult zendeskBasicTicketResult) {
                AccountDeactivationContract.View view;
                Intrinsics.checkNotNullParameter(zendeskBasicTicketResult, "");
                view = AccountDeactivationPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.AccountDeactivationPresenter$sendTicket$2
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
                AccountDeactivationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = AccountDeactivationPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.PlaceComponentResult();
            }
        });
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(AccountDeactivationPresenter accountDeactivationPresenter, CharSequence charSequence) {
        if (PlaceComponentResult(charSequence)) {
            accountDeactivationPresenter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        } else {
            accountDeactivationPresenter.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }
    }
}
