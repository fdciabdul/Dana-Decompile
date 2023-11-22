package id.dana.richview.boundcard;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.afollestad.materialdialogs.MaterialDialog;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRichView;
import id.dana.cardbinding.activity.CardBindingActivity;
import id.dana.common.OverlapDecoration;
import id.dana.contract.boundcard.BoundCardContract;
import id.dana.contract.boundcard.BoundCardModule;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.BoundCardComponent;
import id.dana.di.component.DaggerBoundCardComponent;
import id.dana.model.UserInfo;
import id.dana.pay.PayCardInfo;
import id.dana.pay.model.PayCardConfigModel;
import id.dana.richview.boundcard.BoundCardAdapter;
import id.dana.richview.boundcard.mapper.BoundCardMapper;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes9.dex */
public class BoundCardView extends BaseRichView implements BoundCardContract.View {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private BoundCard DatabaseTableConfigUtil;
    private OnBoundCardViewListener GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private OverlapDecoration NetworkUserEntityData$$ExternalSyntheticLambda2;
    private List<BoundCard> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private boolean PlaceComponentResult;
    private String PrepareContext;
    @Inject
    BoundCardMapper boundCardMapper;
    @Inject
    DynamicUrlWrapper dynamicUrlWrapper;
    private BoundCardAdapter getAuthRequestContext;
    private List<BoundCard> getErrorConfigVersion;
    private LinearLayoutManager initRecordTimeStamp;
    private UserInfo isLayoutRequested;
    private BoundCardComponent lookAheadTest;
    private boolean moveToNextValue;
    private List<PayCardInfo> newProxyInstance;
    @Inject
    public BoundCardContract.Presenter presenter;
    @Inject
    QueryPayMethodContract.Presenter queryPayMethodPresenter;
    @BindView(R.id.rv_stack_view)
    RecyclerView rvStackView;
    private boolean scheduleImpl;
    @Inject
    GetUserInfoContract.Presenter userInfoPresenter;

    /* loaded from: classes9.dex */
    public interface OnBoundCardViewListener {
        void BuiltInFictitiousFunctionClassFactory(BoundCard boundCard);

        void getAuthRequestContext(BoundCard boundCard, View view);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_boundcard;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public BoundCardView(Context context) {
        super(context);
        this.scheduleImpl = false;
    }

    public BoundCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scheduleImpl = false;
    }

    public BoundCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scheduleImpl = false;
    }

    public BoundCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.scheduleImpl = false;
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        super.injectComponent(applicationComponent);
        if (this.lookAheadTest == null) {
            DaggerBoundCardComponent.Builder PlaceComponentResult = DaggerBoundCardComponent.PlaceComponentResult();
            PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (BoundCardModule) Preconditions.getAuthRequestContext(new BoundCardModule(this));
            PlaceComponentResult.MyBillsEntityDataFactory = (QueryPayMethodModule) Preconditions.getAuthRequestContext(new QueryPayMethodModule(new QueryPayMethodContract.View() { // from class: id.dana.richview.boundcard.BoundCardView.1
                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void MyBillsEntityDataFactory(int i) {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void PlaceComponentResult(PayCardConfigModel payCardConfigModel) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void getAuthRequestContext() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void MyBillsEntityDataFactory(Boolean bool) {
                    BoundCardView.this.setAddNewCardEnabled(bool.booleanValue());
                }

                @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<PayCardInfo> list) {
                    BoundCardView.access$000(BoundCardView.this, list);
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, DanaLogConstants.Prefix.QRCODE_QUERY_PAY_METHOD_PREFIX, str);
                }
            }));
            PlaceComponentResult.getAuthRequestContext = (GetUserInfoModule) Preconditions.getAuthRequestContext(new GetUserInfoModule(new GetUserInfoContract.View() { // from class: id.dana.richview.boundcard.BoundCardView.2
                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                @Override // id.dana.contract.user.GetUserInfoContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(UserInfo userInfo) {
                    BoundCardView.this.isLayoutRequested = userInfo;
                    BoundCardView.access$200(BoundCardView.this);
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, BoundCardModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, QueryPayMethodModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, GetUserInfoModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, ApplicationComponent.class);
            this.lookAheadTest = new DaggerBoundCardComponent.BoundCardComponentImpl(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.PlaceComponentResult, (byte) 0);
        }
        this.lookAheadTest.MyBillsEntityDataFactory(this);
        registerPresenter(this.presenter, this.queryPayMethodPresenter, this.userInfoPresenter);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        super.injected(z);
        if (z) {
            this.getAuthRequestContext = new BoundCardAdapter(new BoundCardAdapter.OnBoundCardClickListener() { // from class: id.dana.richview.boundcard.BoundCardView$$ExternalSyntheticLambda1
                @Override // id.dana.richview.boundcard.BoundCardAdapter.OnBoundCardClickListener
                public final void PlaceComponentResult(View view, int i) {
                    BoundCardView.this.m2827x8ec61fbd(view, i);
                }
            });
            this.presenter.BuiltInFictitiousFunctionClassFactory();
            getBoundCards();
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.initRecordTimeStamp = new LinearLayoutManager(getContext());
        initAnimationListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initBoundCardAdapter$0$id-dana-richview-boundcard-BoundCardView  reason: not valid java name */
    public /* synthetic */ void m2827x8ec61fbd(View view, int i) {
        int itemViewType = this.getAuthRequestContext.getItemViewType(i);
        if (itemViewType != 1 && itemViewType != 2) {
            this.MyBillsEntityDataFactory = true;
            gotoAddNewCard();
            return;
        }
        OnBoundCardViewListener onBoundCardViewListener = this.GetContactSyncConfig;
        if (onBoundCardViewListener != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
            this.moveToNextValue = true;
            onBoundCardViewListener.getAuthRequestContext(this.getErrorConfigVersion.get(i), view);
        }
    }

    public void getBoundCards() {
        this.presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        this.presenter.PlaceComponentResult();
        this.queryPayMethodPresenter.getAuthRequestContext();
        this.queryPayMethodPresenter.BuiltInFictitiousFunctionClassFactory(false);
        this.userInfoPresenter.PlaceComponentResult(false);
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onGetBoundCardsSuccess(List<BoundCard> list) {
        Boolean bool;
        if (!this.PlaceComponentResult) {
            if (this.getErrorConfigVersion != null) {
                Iterator<BoundCard> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BoundCard next = it.next();
                    if (next.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        Iterator<BoundCard> it2 = this.getErrorConfigVersion.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                BoundCard next2 = it2.next();
                                if (!TextUtils.isEmpty(next2.KClassImpl$Data$declaredNonStaticMembers$2) && next2.KClassImpl$Data$declaredNonStaticMembers$2.equals(next.KClassImpl$Data$declaredNonStaticMembers$2)) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                            } else {
                                bool = Boolean.FALSE;
                                break;
                            }
                        }
                        if (!bool.booleanValue()) {
                            this.presenter.PlaceComponentResult(next.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    }
                }
            }
            if (isViewBinded()) {
                if (!list.isEmpty()) {
                    if (this.BuiltInFictitiousFunctionClassFactory) {
                        BoundCard boundCard = new BoundCard();
                        boundCard.BuiltInFictitiousFunctionClassFactory = "ADD_CARD";
                        boundCard.scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        boundCard.NetworkUserEntityData$$ExternalSyntheticLambda7 = "DEBIT_CARD";
                        list.add(boundCard);
                    }
                    this.getErrorConfigVersion = list;
                    int i = 0;
                    list.get(0).isLayoutRequested = this.PrepareContext;
                    if (!this.getErrorConfigVersion.isEmpty()) {
                        String str = this.getErrorConfigVersion.get(0).initRecordTimeStamp;
                        if (str == null) {
                            str = "";
                        }
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
                    }
                    this.getAuthRequestContext.setItems(this.getErrorConfigVersion);
                    this.presenter.getAuthRequestContext();
                    OverlapDecoration overlapDecoration = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (overlapDecoration == null) {
                        initOverLapDecoration((int) getResources().getDimension(R.dimen.f30322131165588));
                    } else {
                        this.rvStackView.removeItemDecoration(overlapDecoration);
                    }
                    this.rvStackView.addItemDecoration(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    this.rvStackView.setLayoutManager(this.initRecordTimeStamp);
                    this.rvStackView.setAdapter(this.getAuthRequestContext);
                    OnBoundCardViewListener onBoundCardViewListener = this.GetContactSyncConfig;
                    if (onBoundCardViewListener != null) {
                        if (this.DatabaseTableConfigUtil != null) {
                            while (true) {
                                if (i < this.getErrorConfigVersion.size()) {
                                    BoundCard boundCard2 = this.getErrorConfigVersion.get(i);
                                    if ((this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2() && boundCard2.KClassImpl$Data$declaredNonStaticMembers$2()) || PlaceComponentResult(boundCard2)) {
                                        break;
                                    }
                                    i++;
                                } else {
                                    i = this.getErrorConfigVersion.size() - 1;
                                    break;
                                }
                            }
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
                        } else if (BuiltInFictitiousFunctionClassFactory() && this.getErrorConfigVersion.get(0).KClassImpl$Data$declaredNonStaticMembers$2()) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 1;
                        }
                        onBoundCardViewListener.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion.get(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
                        PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
                return;
            }
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = list;
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onErrorGetCard(String str) {
        new MaterialDialog(getContext(), MaterialDialog.getDEFAULT_BEHAVIOR()).cancelOnTouchOutside(false).message(null, str, null).positiveButton(Integer.valueOf((int) R.string.retry), null, new Function1() { // from class: id.dana.richview.boundcard.BoundCardView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoundCardView.this.m2828lambda$onErrorGetCard$1$iddanarichviewboundcardBoundCardView((MaterialDialog) obj);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onErrorGetCard$1$id-dana-richview-boundcard-BoundCardView  reason: not valid java name */
    public /* synthetic */ Unit m2828lambda$onErrorGetCard$1$iddanarichviewboundcardBoundCardView(MaterialDialog materialDialog) {
        this.presenter.MyBillsEntityDataFactory();
        return null;
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onGetDefaultCardSuccess(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            boolean z = false;
            while (true) {
                if (i >= this.getErrorConfigVersion.size()) {
                    break;
                }
                z = MyBillsEntityDataFactory(i, str);
                if (z) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                    setSelectedCardPosition(i);
                    break;
                }
                i++;
            }
            if (z) {
                return;
            }
        }
        setSelectedCardPosition(0);
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onGetPhoneNumberSuccess(String str) {
        this.PrepareContext = str;
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onCheckEnableExpressPayFeature(Boolean bool) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bool.booleanValue();
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.View
    public void onGetIsCardBindingV2Enabled(Boolean bool) {
        this.scheduleImpl = bool.booleanValue();
    }

    public void initOverLapDecoration(int i) {
        double d = i;
        Double.isNaN(d);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new OverlapDecoration(((int) (d * 0.35d)) - i);
    }

    private boolean PlaceComponentResult(BoundCard boundCard) {
        return !TextUtils.isEmpty(this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2) && this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.equals(boundCard.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private void PlaceComponentResult(int i) {
        BoundCard boundCard = this.getErrorConfigVersion.get(i);
        BoundCard boundCard2 = this.DatabaseTableConfigUtil;
        if (boundCard2 != null && this.moveToNextValue) {
            this.getErrorConfigVersion.set(i, boundCard2);
            this.moveToNextValue = false;
        } else {
            this.getErrorConfigVersion.remove(i);
        }
        this.DatabaseTableConfigUtil = boundCard;
        this.getAuthRequestContext.notifyDataSetChanged();
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.rvStackView.smoothScrollToPosition(this.getErrorConfigVersion.size() - 1);
            this.MyBillsEntityDataFactory = false;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.equals("KYC0") || this.NetworkUserEntityData$$ExternalSyntheticLambda1.equals("KYC1");
    }

    public void gotoAddNewCard() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            if (this.scheduleImpl) {
                gotoCardBindingV2();
            } else {
                gotoCardBindingH5();
            }
        }
    }

    public void gotoCardBindingV2() {
        getBaseActivity().startActivity(CardBindingActivity.createCardBindingActivityIntent(getContext(), TrackerKey.CardBindingSourceType.WALLET));
    }

    public void gotoCardBindingH5() {
        DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/bankcardadd?isClosable=true", new DanaH5Listener() { // from class: id.dana.richview.boundcard.BoundCardView.3
            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerDestroyed(Bundle bundle) {
                BoundCardView.this.getBoundCards();
                BoundCardView.this.queryPayMethodPresenter.BuiltInFictitiousFunctionClassFactory(false);
            }
        });
    }

    public void gotoKYCPage() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.dynamicUrlWrapper.getKycFromSendMoneyUrl());
        DanaH5.startContainerFullUrl(sb.toString());
    }

    public void setSelectedCardPosition(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
    }

    private boolean MyBillsEntityDataFactory(int i, String str) {
        if (this.getErrorConfigVersion.isEmpty()) {
            return false;
        }
        String str2 = this.getErrorConfigVersion.get(i).KClassImpl$Data$declaredNonStaticMembers$2;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(str);
    }

    public void setAddNewCardEnabled(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public void initListener(OnBoundCardViewListener onBoundCardViewListener) {
        this.GetContactSyncConfig = onBoundCardViewListener;
    }

    public BoundCard getCurrentCard() {
        if (!TextUtils.isEmpty(this.getErrorConfigVersion.get(this.NetworkUserEntityData$$ExternalSyntheticLambda8).BuiltInFictitiousFunctionClassFactory) || !BuiltInFictitiousFunctionClassFactory()) {
            return this.getErrorConfigVersion.get(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        new MaterialDialog(getContext(), MaterialDialog.getDEFAULT_BEHAVIOR()).cancelOnTouchOutside(false).message(Integer.valueOf((int) R.string.payment_method_need_premium_message), null, null).positiveButton(Integer.valueOf((int) R.string.upgrade), null, new Function1() { // from class: id.dana.richview.boundcard.BoundCardView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoundCardView.this.m2829x49ce3f28((MaterialDialog) obj);
            }
        }).negativeButton(null, null, new Function1() { // from class: id.dana.richview.boundcard.BoundCardView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoundCardView.this.m2830x51337447((MaterialDialog) obj);
            }
        }).show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$openKycMessageDialog$2$id-dana-richview-boundcard-BoundCardView  reason: not valid java name */
    public /* synthetic */ Unit m2829x49ce3f28(MaterialDialog materialDialog) {
        setSelectedCardPosition(this.KClassImpl$Data$declaredNonStaticMembers$2);
        gotoKYCPage();
        materialDialog.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$openKycMessageDialog$3$id-dana-richview-boundcard-BoundCardView  reason: not valid java name */
    public /* synthetic */ Unit m2830x51337447(MaterialDialog materialDialog) {
        setSelectedCardPosition(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return null;
    }

    public void initAnimationListener() {
        this.rvStackView.setLayoutAnimationListener(new Animation.AnimationListener() { // from class: id.dana.richview.boundcard.BoundCardView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BoundCardView.this.PlaceComponentResult = false;
                if (BoundCardView.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                    BoundCardView boundCardView = BoundCardView.this;
                    boundCardView.onGetBoundCardsSuccess(boundCardView.NetworkUserEntityData$$ExternalSyntheticLambda7);
                }
            }
        });
    }

    public void startExpandingAnimation() {
        this.PlaceComponentResult = true;
        this.rvStackView.startLayoutAnimation();
    }

    public void onCardSwapped() {
        PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    public void startCloseAnimation() {
        this.rvStackView.startLayoutAnimation();
    }

    public void setCloseAnimation() {
        this.rvStackView.clearAnimation();
        this.rvStackView.getLayoutAnimation().getAnimation().cancel();
        this.rvStackView.setLayoutAnimation(null);
        this.rvStackView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.f4622130772001));
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        List<BoundCard> list;
        return (!this.MyBillsEntityDataFactory || (list = this.getErrorConfigVersion) == null || list.isEmpty()) ? false : true;
    }

    public void setEntryPoint(String str) {
        this.getAuthRequestContext.MyBillsEntityDataFactory = str;
    }

    static /* synthetic */ void access$000(BoundCardView boundCardView, List list) {
        boundCardView.newProxyInstance = list;
        if (list == null) {
            boundCardView.newProxyInstance = new ArrayList();
        }
        List<PayCardInfo> list2 = boundCardView.newProxyInstance;
        if (list2 != null) {
            BoundCardMapper boundCardMapper = boundCardView.boundCardMapper;
            boundCardView.onGetBoundCardsSuccess(BoundCardMapper.getAuthRequestContext(list2, boundCardView.isLayoutRequested));
        }
    }

    static /* synthetic */ void access$200(BoundCardView boundCardView) {
        List<PayCardInfo> list = boundCardView.newProxyInstance;
        if (list != null) {
            BoundCardMapper boundCardMapper = boundCardView.boundCardMapper;
            boundCardView.onGetBoundCardsSuccess(BoundCardMapper.getAuthRequestContext(list, boundCardView.isLayoutRequested));
        }
    }
}
