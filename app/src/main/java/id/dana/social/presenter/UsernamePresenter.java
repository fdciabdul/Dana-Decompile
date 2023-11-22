package id.dana.social.presenter;

import com.alipay.imobile.network.quake.exception.ClientException;
import com.jakewharton.rxbinding2.InitialValueObservable;
import id.dana.base.AbstractContractKt;
import id.dana.data.R;
import id.dana.domain.DefaultObserver;
import id.dana.feeds.data.username.UsernameCheckManager;
import id.dana.feeds.data.username.model.UsernameCheck;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.username.interactor.ChangeUsername;
import id.dana.feeds.domain.username.interactor.CheckUsername;
import id.dana.feeds.domain.username.model.UserProfileResponse;
import id.dana.social.contract.UsernameContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017"}, d2 = {"Lid/dana/social/presenter/UsernamePresenter;", "Lid/dana/social/contract/UsernameContract$Presenter;", "Lcom/jakewharton/rxbinding2/InitialValueObservable;", "", "p0", "", "MyBillsEntityDataFactory", "(Lcom/jakewharton/rxbinding2/InitialValueObservable;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Lid/dana/feeds/domain/username/interactor/ChangeUsername;", "PlaceComponentResult", "Lid/dana/feeds/domain/username/interactor/ChangeUsername;", "Lid/dana/feeds/domain/username/interactor/CheckUsername;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/username/interactor/CheckUsername;", "getAuthRequestContext", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "Lid/dana/feeds/data/username/UsernameCheckManager;", "Lid/dana/feeds/data/username/UsernameCheckManager;", "Lid/dana/social/contract/UsernameContract$View;", "Lid/dana/social/contract/UsernameContract$View;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/social/contract/UsernameContract$View;Lid/dana/feeds/data/username/UsernameCheckManager;Lid/dana/feeds/domain/username/interactor/CheckUsername;Lid/dana/feeds/domain/username/interactor/ChangeUsername;Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UsernamePresenter implements UsernameContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CheckUsername getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final InitFeedWithoutContact BuiltInFictitiousFunctionClassFactory;
    private final UsernameCheckManager MyBillsEntityDataFactory;
    private final ChangeUsername PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final UsernameContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public UsernamePresenter(UsernameContract.View view, UsernameCheckManager usernameCheckManager, CheckUsername checkUsername, ChangeUsername changeUsername, InitFeedWithoutContact initFeedWithoutContact) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(usernameCheckManager, "");
        Intrinsics.checkNotNullParameter(checkUsername, "");
        Intrinsics.checkNotNullParameter(changeUsername, "");
        Intrinsics.checkNotNullParameter(initFeedWithoutContact, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = usernameCheckManager;
        this.getAuthRequestContext = checkUsername;
        this.PlaceComponentResult = changeUsername;
        this.BuiltInFictitiousFunctionClassFactory = initFeedWithoutContact;
    }

    @Override // id.dana.social.contract.UsernameContract.Presenter
    public final void MyBillsEntityDataFactory(InitialValueObservable<CharSequence> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.skipInitialValue().doOnNext(new Consumer() { // from class: id.dana.social.presenter.UsernamePresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CharSequence charSequence = (CharSequence) obj;
                UsernamePresenter.PlaceComponentResult(UsernamePresenter.this);
            }
        }).debounce(1500L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.social.presenter.UsernamePresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UsernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2((CharSequence) obj);
            }
        }).map(new Function() { // from class: id.dana.social.presenter.UsernamePresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UsernamePresenter.PlaceComponentResult(UsernamePresenter.this, (String) obj);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DefaultObserver<UsernameCheck>() { // from class: id.dana.social.presenter.UsernamePresenter$observeUsername$4
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UsernameCheck usernameCheck = (UsernameCheck) obj;
                Intrinsics.checkNotNullParameter(usernameCheck, "");
                UsernamePresenter.BuiltInFictitiousFunctionClassFactory(UsernamePresenter.this, usernameCheck);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                UsernamePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onError(p02.getMessage());
            }
        });
    }

    @Override // id.dana.social.contract.UsernameContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.invoke(p0, new Function1<UserProfileResponse, Unit>() { // from class: id.dana.social.presenter.UsernamePresenter$submitUsername$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserProfileResponse userProfileResponse) {
                invoke2(userProfileResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserProfileResponse userProfileResponse) {
                Intrinsics.checkNotNullParameter(userProfileResponse, "");
                UsernamePresenter.PlaceComponentResult(UsernamePresenter.this, userProfileResponse);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.UsernamePresenter$submitUsername$2
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
                Intrinsics.checkNotNullParameter(exc, "");
                UsernamePresenter.PlaceComponentResult(UsernamePresenter.this, exc);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(UsernamePresenter usernamePresenter) {
        Intrinsics.checkNotNullParameter(usernamePresenter, "");
        usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ UsernameCheck PlaceComponentResult(UsernamePresenter usernamePresenter, String str) {
        Intrinsics.checkNotNullParameter(usernamePresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        UsernameCheckManager usernameCheckManager = usernamePresenter.MyBillsEntityDataFactory;
        UsernameCheck usernameCheck = new UsernameCheck(str, "");
        Intrinsics.checkNotNullParameter(usernameCheck, "");
        usernameCheckManager.KClassImpl$Data$declaredNonStaticMembers$2(usernameCheck);
        return usernameCheck;
    }

    public static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        String obj = charSequence.toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    public static final /* synthetic */ void PlaceComponentResult(UsernamePresenter usernamePresenter, String str, UserProfileResponse userProfileResponse) {
        if (Intrinsics.areEqual(userProfileResponse.getErrorCode(), "AE15112158172914")) {
            UsernameContract.View view = usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            UsernameCheckManager usernameCheckManager = usernamePresenter.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(str, "");
            String string = usernameCheckManager.MyBillsEntityDataFactory.getString(R.string.error_username_taken);
            Intrinsics.checkNotNullExpressionValue(string, "");
            view.KClassImpl$Data$declaredNonStaticMembers$2(new UsernameCheck(str, string));
        } else if (userProfileResponse.getSuccess()) {
            usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        } else {
            usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new UsernameCheck(str, userProfileResponse.getErrorMessage()));
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(UsernamePresenter usernamePresenter, String str, Exception exc) {
        Throwable cause;
        if (exc.getCause() instanceof ClientException) {
            usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        } else {
            UsernameContract.View view = usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            Throwable cause2 = exc.getCause();
            String message = (cause2 == null || (cause = cause2.getCause()) == null) ? null : cause.getMessage();
            if (message == null) {
                message = "";
            }
            view.KClassImpl$Data$declaredNonStaticMembers$2(new UsernameCheck(str, message));
        }
        String name = UsernamePresenter.class.getName();
        String message2 = exc.getMessage();
        DanaLog.BuiltInFictitiousFunctionClassFactory(name, message2 != null ? message2 : "", exc);
    }

    public static final /* synthetic */ void PlaceComponentResult(UsernamePresenter usernamePresenter, UserProfileResponse userProfileResponse) {
        if (userProfileResponse.getSuccess()) {
            usernamePresenter.BuiltInFictitiousFunctionClassFactory.execute(null, new UsernamePresenter$onSubmitUsername$1(usernamePresenter), new UsernamePresenter$onSubmitUsername$2(usernamePresenter));
            usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
            return;
        }
        usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(userProfileResponse.getErrorCode(), userProfileResponse.getErrorMessage());
    }

    public static final /* synthetic */ void PlaceComponentResult(UsernamePresenter usernamePresenter, Exception exc) {
        usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        String name = UsernamePresenter.class.getName();
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(name, message, exc);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final UsernamePresenter usernamePresenter, UsernameCheck usernameCheck) {
        if (usernameCheck.MyBillsEntityDataFactory.length() > 0) {
            if (usernameCheck.PlaceComponentResult.length() > 0) {
                usernamePresenter.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(usernameCheck);
                return;
            }
        }
        if (usernameCheck.MyBillsEntityDataFactory.length() == 0) {
            if (usernameCheck.PlaceComponentResult.length() > 0) {
                final String str = usernameCheck.PlaceComponentResult;
                Intrinsics.checkNotNullParameter(str, "");
                usernamePresenter.getAuthRequestContext.invoke(str, new Function1<UserProfileResponse, Unit>() { // from class: id.dana.social.presenter.UsernamePresenter$checkUsername$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(UserProfileResponse userProfileResponse) {
                        invoke2(userProfileResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(UserProfileResponse userProfileResponse) {
                        Intrinsics.checkNotNullParameter(userProfileResponse, "");
                        UsernamePresenter.PlaceComponentResult(UsernamePresenter.this, str, userProfileResponse);
                    }
                }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.UsernamePresenter$checkUsername$2
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
                        Intrinsics.checkNotNullParameter(exc, "");
                        UsernamePresenter.PlaceComponentResult(UsernamePresenter.this, str, exc);
                    }
                });
            }
        }
    }
}
