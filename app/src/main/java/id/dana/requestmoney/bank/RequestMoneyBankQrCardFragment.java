package id.dana.requestmoney.bank;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.CardQrRequestMoneyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerUserBankCardComponent;
import id.dana.di.modules.RequestMoneyQrModule;
import id.dana.di.modules.UserBankModule;
import id.dana.di.modules.UserBankQrModule;
import id.dana.extension.lang.StringExtKt;
import id.dana.model.HomeInfo;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.requestmoney.BaseRequestMoneyQrCardFragment;
import id.dana.requestmoney.RequestMoneyActivity;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$requestListener$2;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.bank.UserBankQrContract;
import id.dana.requestmoney.model.QrUserBankModel;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.richview.QRView;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.TextUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0013\u0010\f\u001a\u00020\u0002*\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0012X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/requestmoney/bank/RequestMoneyBankQrCardFragment;", "Lid/dana/requestmoney/BaseRequestMoneyQrCardFragment;", "", "FragmentBottomSheetPaymentSettingBinding", "()V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "lookAheadTest", "onDestroy", "onDestroyView", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/requestmoney/model/UserBankModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/requestmoney/model/UserBankModel;)V", "Landroid/os/CountDownTimer;", "MyBillsEntityDataFactory", "Landroid/os/CountDownTimer;", "BuiltInFictitiousFunctionClassFactory", "Lcom/afollestad/materialdialogs/MaterialDialog;", "moveToNextValue", "Lkotlin/Lazy;", "Lid/dana/requestmoney/bank/RequestMoneyBankQrCardFragment$requestListener$2$1;", "PlaceComponentResult", "getErrorConfigVersion", "Lid/dana/requestmoney/model/UserBankModel;", "getAuthRequestContext", "Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "userBankPresenter", "Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "Lid/dana/requestmoney/bank/UserBankQrContract$Presenter;", "userBankQrPresenter", "Lid/dana/requestmoney/bank/UserBankQrContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyBankQrCardFragment extends BaseRequestMoneyQrCardFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private CountDownTimer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private UserBankModel getAuthRequestContext;
    @Inject
    public UserBankContract.Presenter userBankPresenter;
    @Inject
    public UserBankQrContract.Presenter userBankQrPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$deleteDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            Context context = RequestMoneyBankQrCardFragment.this.getContext();
            if (context != null) {
                final RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment = RequestMoneyBankQrCardFragment.this;
                CustomDialog.Builder builder = new CustomDialog.Builder(context);
                builder.SubSequence = requestMoneyBankQrCardFragment.getString(R.string.request_money_delete_dialog_title);
                builder.GetContactSyncConfig = requestMoneyBankQrCardFragment.getString(R.string.request_money_delete_dialog_message);
                String string = requestMoneyBankQrCardFragment.getString(R.string.option_no);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                String upperCase = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
                CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(upperCase, new Function1<View, Unit>() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$deleteDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        MaterialDialog KClassImpl$Data$declaredNonStaticMembers$22 = RequestMoneyBankQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBankQrCardFragment.this);
                        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                            KClassImpl$Data$declaredNonStaticMembers$22.dismiss();
                        }
                    }
                });
                String string2 = requestMoneyBankQrCardFragment.getString(R.string.option_yes);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                Locale locale2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale2, "");
                String upperCase2 = string2.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "");
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(upperCase2, new Function1<View, Unit>() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$deleteDialog$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        UserBankModel userBankModel;
                        Intrinsics.checkNotNullParameter(view, "");
                        userBankModel = RequestMoneyBankQrCardFragment.this.getAuthRequestContext;
                        if (userBankModel != null) {
                            UserBankContract.Presenter presenter = RequestMoneyBankQrCardFragment.this.userBankPresenter;
                            if (presenter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                presenter = null;
                            }
                            presenter.getAuthRequestContext(userBankModel);
                        }
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            }
            return null;
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<RequestMoneyBankQrCardFragment$requestListener$2.AnonymousClass1>() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$requestListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$requestListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment = RequestMoneyBankQrCardFragment.this;
            return new RequestListener<Drawable>() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$requestListener$2.1
                @Override // com.bumptech.glide.request.RequestListener
                public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                    return MyBillsEntityDataFactory();
                }

                @Override // com.bumptech.glide.request.RequestListener
                public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                    UserBankModel userBankModel;
                    VB vb = RequestMoneyBankQrCardFragment.this.PlaceComponentResult;
                    if (vb != 0) {
                        AppCompatTextView appCompatTextView = ((CardQrRequestMoneyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda2;
                        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                        AppCompatTextView appCompatTextView2 = appCompatTextView;
                        userBankModel = RequestMoneyBankQrCardFragment.this.getAuthRequestContext;
                        String str = userBankModel != null ? userBankModel.BuiltInFictitiousFunctionClassFactory : null;
                        RequestMoneyBankQrCardFragment.MyBillsEntityDataFactory(appCompatTextView2, str != null ? str : "");
                        return false;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }

                private boolean MyBillsEntityDataFactory() {
                    VB vb = RequestMoneyBankQrCardFragment.this.PlaceComponentResult;
                    if (vb != 0) {
                        AppCompatTextView appCompatTextView = ((CardQrRequestMoneyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda2;
                        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                        appCompatTextView.setVisibility(8);
                        return false;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            };
        }
    });

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            UserBankModel userBankModel = (UserBankModel) arguments.getParcelable("extra_user_bank_model");
            if (userBankModel != null) {
                VB vb = this.PlaceComponentResult;
                if (vb != 0) {
                    CardQrRequestMoneyBinding cardQrRequestMoneyBinding = (CardQrRequestMoneyBinding) vb;
                    cardQrRequestMoneyBinding.newProxyInstance.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(userBankModel.getAuthRequestContext));
                    cardQrRequestMoneyBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(userBankModel.PlaceComponentResult);
                    AppCompatImageView appCompatImageView = cardQrRequestMoneyBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    if ((!StringsKt.isBlank(userBankModel.MyBillsEntityDataFactory)) == true) {
                        String str2 = userBankModel.MyBillsEntityDataFactory;
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "");
                        String lowerCase = str2.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                        str = String.format(DanaUrl.BANK_LOGO_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "");
                    } else {
                        str = "";
                    }
                    GlideApp.getAuthRequestContext(appCompatImageView2.getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.ic_other_bank).PlaceComponentResult((int) R.drawable.ic_other_bank).PlaceComponentResult((RequestListener<Drawable>) ((RequestMoneyBankQrCardFragment$requestListener$2.AnonymousClass1) this.PlaceComponentResult.getValue())).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
                    cardQrRequestMoneyBinding.initRecordTimeStamp.displayUserAvatar(userBankModel.BuiltInFictitiousFunctionClassFactory());
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                userBankModel = null;
            }
            this.getAuthRequestContext = userBankModel;
        }
        super.FragmentBottomSheetPaymentSettingBinding();
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            CardQrRequestMoneyBinding cardQrRequestMoneyBinding2 = (CardQrRequestMoneyBinding) vb2;
            FloatingActionButton floatingActionButton = cardQrRequestMoneyBinding2.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(floatingActionButton, "");
            FloatingActionButton floatingActionButton2 = floatingActionButton;
            floatingActionButton2.setVisibility(0);
            floatingActionButton2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestMoneyBankQrCardFragment.getAuthRequestContext(RequestMoneyBankQrCardFragment.this);
                }
            });
            cardQrRequestMoneyBinding2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestMoneyBankQrCardFragment.MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment.this);
                }
            });
            PlaceComponentResult(new RequestMoneyInfoModel(10000, 20000000));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_USER_BANK);
        UserBankModel userBankModel = this.getAuthRequestContext;
        if (userBankModel != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(userBankModel);
        }
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        UserBankModel userBankModel = this.getAuthRequestContext;
        if (userBankModel != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(userBankModel);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(UserBankModel userBankModel) {
        isLayoutRequested();
        UserBankQrContract.Presenter presenter = this.userBankQrPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(userBankModel, getKClassImpl$Data$declaredNonStaticMembers$2(), getScheduleImpl());
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment
    public final void initRecordTimeStamp() {
        DaggerUserBankCardComponent.Builder MyBillsEntityDataFactory = DaggerUserBankCardComponent.MyBillsEntityDataFactory();
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        MyBillsEntityDataFactory.PlaceComponentResult = (RequestMoneyQrModule) Preconditions.getAuthRequestContext(new RequestMoneyQrModule(new RequestMoneyQrContract.View() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$getRequestMoneyModule$1
            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(QrisTciCoConfigModel p0) {
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(RequestMoneyInfoModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final /* bridge */ /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Long l) {
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void MyBillsEntityDataFactory(Long p0) {
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void PlaceComponentResult(HomeInfo p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4) {
            }

            @Override // id.dana.requestmoney.RequestMoneyQrContract.View
            public final void getAuthRequestContext(boolean p0) {
                RequestMoneyBankQrCardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(new GenerateDeepLinkModule(new GenerateDeepLinkContract.ProfileView() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$getGenerateDeepLinkModule$1
            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(Long l) {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBankQrCardFragment.MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment.this, p0);
            }
        }, new GenerateDeepLinkContract.TransferView() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$getGenerateDeepLinkModule$2
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.TransferView
            public final /* bridge */ /* synthetic */ void getAuthRequestContext(Long l) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.TransferView
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBankQrCardFragment.MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment.this, p0);
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (UserBankModule) Preconditions.getAuthRequestContext(new UserBankModule(new UserBankContract.View() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$getUserBankModule$1
            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0, UserBankModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                if (p0) {
                    FragmentActivity activity2 = RequestMoneyBankQrCardFragment.this.getActivity();
                    RequestMoneyActivity requestMoneyActivity = activity2 instanceof RequestMoneyActivity ? (RequestMoneyActivity) activity2 : null;
                    if (requestMoneyActivity != null) {
                        requestMoneyActivity.onBankDeleted(p1);
                    }
                }
            }
        }));
        MyBillsEntityDataFactory.moveToNextValue = (UserBankQrModule) Preconditions.getAuthRequestContext(new UserBankQrModule(new UserBankQrContract.View() { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$getUserBankQrModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.requestmoney.bank.UserBankQrContract.View
            public final void MyBillsEntityDataFactory(QrUserBankModel p0) {
                UserBankModel userBankModel;
                long myBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBankQrCardFragment.lookAheadTest(RequestMoneyBankQrCardFragment.this);
                RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment = RequestMoneyBankQrCardFragment.this;
                VB vb = requestMoneyBankQrCardFragment.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((CardQrRequestMoneyBinding) vb).isLayoutRequested;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    RequestMoneyBankQrCardFragment.getAuthRequestContext(requestMoneyBankQrCardFragment, textView, p0);
                    RequestMoneyBankQrCardFragment.this.PlaceComponentResult(p0.KClassImpl$Data$declaredNonStaticMembers$2);
                    VB vb2 = RequestMoneyBankQrCardFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        QRView qRView = ((CardQrRequestMoneyBinding) vb2).initRecordTimeStamp;
                        userBankModel = RequestMoneyBankQrCardFragment.this.getAuthRequestContext;
                        String BuiltInFictitiousFunctionClassFactory = userBankModel != null ? userBankModel.BuiltInFictitiousFunctionClassFactory() : null;
                        qRView.displayUserAvatar(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
                        RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment2 = RequestMoneyBankQrCardFragment.this;
                        myBillsEntityDataFactory = requestMoneyBankQrCardFragment2.getMyBillsEntityDataFactory();
                        requestMoneyBankQrCardFragment2.MyBillsEntityDataFactory(true, myBillsEntityDataFactory, requestMoneyBankQrCardFragment2.getBuiltInFictitiousFunctionClassFactory(), false);
                        RequestMoneyBankQrCardFragment.this.getAuthRequestContext(false);
                        RequestMoneyBankQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBankQrCardFragment.this, p0);
                        RequestMoneyBankQrCardFragment.this.MyBillsEntityDataFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.requestmoney.bank.UserBankQrContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                long myBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment = RequestMoneyBankQrCardFragment.this;
                myBillsEntityDataFactory = requestMoneyBankQrCardFragment.getMyBillsEntityDataFactory();
                requestMoneyBankQrCardFragment.MyBillsEntityDataFactory(false, myBillsEntityDataFactory, requestMoneyBankQrCardFragment.getBuiltInFictitiousFunctionClassFactory(), false);
                RequestMoneyBankQrCardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
            }

            @Override // id.dana.requestmoney.bank.UserBankQrContract.View
            public final void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p3, "");
                Intrinsics.checkNotNullParameter(p4, "");
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBankQrCardFragment.this.getContext(), p3, p0, p2, p1, TrackerDataKey.Source.REQUEST_MONEY, p4);
            }

            @Override // id.dana.requestmoney.bank.UserBankQrContract.View
            public final void getAuthRequestContext(long p0) {
                RequestMoneyBankQrCardFragment.this.getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_USER_BANK);
                RequestMoneyBankQrCardFragment.this.getAuthRequestContext(p0);
            }

            @Override // id.dana.requestmoney.bank.UserBankQrContract.View
            public final void PlaceComponentResult(long p0) {
                RequestMoneyBankQrCardFragment.this.getAuthRequestContext(TrackerKey.RequestMoneyProperties.QR_TRANSFER_BANK);
                RequestMoneyBankQrCardFragment.this.getAuthRequestContext(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, RequestMoneyQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, GenerateDeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, UserBankModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.moveToNextValue, UserBankQrModule.class);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerUserBankCardComponent.UserBankCardComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0).getAuthRequestContext(this);
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        UserBankContract.Presenter presenter = this.userBankPresenter;
        GenerateDeepLinkContract.ProfilePresenter profilePresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        UserBankQrContract.Presenter presenter2 = this.userBankQrPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.onDestroy();
        RequestMoneyQrContract.Presenter presenter3 = this.requestMoneyQrPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.onDestroy();
        GenerateDeepLinkContract.TransferPresenter transferPresenter = this.transferDeepLinkPresenter;
        if (transferPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transferPresenter = null;
        }
        transferPresenter.onDestroy();
        GenerateDeepLinkContract.ProfilePresenter profilePresenter2 = this.profileDeeplinkPresenter;
        if (profilePresenter2 != null) {
            profilePresenter = profilePresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        profilePresenter.onDestroy();
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/requestmoney/bank/RequestMoneyBankQrCardFragment$Companion;", "", "Lid/dana/requestmoney/model/UserBankModel;", "p0", "Lid/dana/requestmoney/bank/RequestMoneyBankQrCardFragment;", "MyBillsEntityDataFactory", "(Lid/dana/requestmoney/model/UserBankModel;)Lid/dana/requestmoney/bank/RequestMoneyBankQrCardFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RequestMoneyBankQrCardFragment MyBillsEntityDataFactory(UserBankModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment = new RequestMoneyBankQrCardFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_user_bank_model", p0);
            requestMoneyBankQrCardFragment.setArguments(bundle);
            return requestMoneyBankQrCardFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
        Intrinsics.checkNotNullParameter(requestMoneyBankQrCardFragment, "");
        MaterialDialog materialDialog = (MaterialDialog) requestMoneyBankQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (materialDialog != null) {
            materialDialog.show();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
        Intrinsics.checkNotNullParameter(requestMoneyBankQrCardFragment, "");
        UserBankModel userBankModel = requestMoneyBankQrCardFragment.getAuthRequestContext;
        if (userBankModel != null) {
            requestMoneyBankQrCardFragment.isLayoutRequested();
            UserBankQrContract.Presenter presenter = requestMoneyBankQrCardFragment.userBankQrPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(userBankModel, requestMoneyBankQrCardFragment.getKClassImpl$Data$declaredNonStaticMembers$2(), requestMoneyBankQrCardFragment.getScheduleImpl());
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment, TextView textView, QrUserBankModel qrUserBankModel) {
        Locale locale;
        textView.setVisibility(0);
        locale = Locale.getDefault();
        String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd MMM yyyy HH:mm", locale, qrUserBankModel.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        String string = requestMoneyBankQrCardFragment.getString(R.string.request_money_expiry_refresh_time);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{BuiltInFictitiousFunctionClassFactory}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(StringExtKt.MyBillsEntityDataFactory(format, BuiltInFictitiousFunctionClassFactory));
    }

    public static final /* synthetic */ MaterialDialog KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
        return (MaterialDialog) requestMoneyBankQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void lookAheadTest(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
        VB vb = requestMoneyBankQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp.hideSkeleton();
            VB vb2 = requestMoneyBankQrCardFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).GetContactSyncConfig.setEnableShareButton(true);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void moveToNextValue(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment) {
        VB vb = requestMoneyBankQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((CardQrRequestMoneyBinding) vb).isLayoutRequested;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setText(requestMoneyBankQrCardFragment.getString(R.string.request_money_expiry_expired));
            requestMoneyBankQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
            requestMoneyBankQrCardFragment.getAuthRequestContext(true);
            requestMoneyBankQrCardFragment.BuiltInFictitiousFunctionClassFactory(false);
            VB vb2 = requestMoneyBankQrCardFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).GetContactSyncConfig.setEnableShareButton(false);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TextView textView, String str) {
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment, QrUserBankModel qrUserBankModel) {
        CountDownTimer countDownTimer = requestMoneyBankQrCardFragment.BuiltInFictitiousFunctionClassFactory;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        final long millis = TimeUnit.SECONDS.toMillis(qrUserBankModel.getAuthRequestContext);
        final long millis2 = TimeUnit.SECONDS.toMillis(1L);
        CountDownTimer countDownTimer2 = new CountDownTimer(millis, millis2) { // from class: id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment$startCountdownTimer$1
            @Override // android.os.CountDownTimer
            public final void onTick(long p0) {
            }

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                RequestMoneyBankQrCardFragment.moveToNextValue(RequestMoneyBankQrCardFragment.this);
            }
        };
        requestMoneyBankQrCardFragment.BuiltInFictitiousFunctionClassFactory = countDownTimer2;
        countDownTimer2.start();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment, String str) {
        requestMoneyBankQrCardFragment.PlaceComponentResult(str);
        VB vb = requestMoneyBankQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).GetContactSyncConfig.setSharingMessage(requestMoneyBankQrCardFragment.getString(R.string.share_request_money_link), str);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.requestmoney.BaseRequestMoneyQrCardFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        CountDownTimer countDownTimer = this.BuiltInFictitiousFunctionClassFactory;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                countDownTimer = null;
            }
            countDownTimer.cancel();
        }
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
