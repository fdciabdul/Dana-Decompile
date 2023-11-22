package id.dana.promoquest.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRichView;
import id.dana.base.SingleClickListener;
import id.dana.promoquest.PromoQuestListener;
import id.dana.promoquest.adapter.MissionDetailQuestAdapter;
import id.dana.promoquest.handler.PromoQuestActionFactory;
import id.dana.promoquest.handler.PromoQuestActionHandler;
import id.dana.promoquest.model.QuestActionType;
import id.dana.promoquest.model.QuestModel;
import id.dana.promoquest.views.QuestView;
import id.dana.richview.LogoProgressView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class QuestView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private PromoQuestListener.QuestAction KClassImpl$Data$declaredNonStaticMembers$2;
    private PromoQuestActionHandler MyBillsEntityDataFactory;
    private QuestModel PlaceComponentResult;
    @BindView(R.id.btn_quest_action)
    Button btnQuestAction;
    private PromoQuestActionFactory getAuthRequestContext;
    private MissionDetailQuestAdapter.RedeemQuestListener getErrorConfigVersion;
    @BindView(R.id.iv_quest_status)
    ImageView ivQuestIconState;
    @BindView(R.id.lpv_quest_loading)
    LogoProgressView lpvLoading;
    @BindView(R.id.tv_quest_description)
    TextView questDescription;
    @BindView(R.id.tv_quest_title)
    TextView questTitle;
    @BindView(R.id.vg_quest_view_root)
    ConstraintLayout vgQuestViewRoot;
    @BindView(R.id.vg_quest_action)
    LinearLayout viewAction;
    @BindView(R.id.view_quest_separator)
    View viewQuestSeparator;
    @BindView(R.id.view_track_line)
    View viewTrackLine;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_quest_mission_detail;
    }

    @Inject
    public QuestView(Context context) {
        super(context);
    }

    public QuestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QuestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.btnQuestAction.setOnClickListener(new SingleClickListener(getBaseActivity()) { // from class: id.dana.promoquest.views.QuestView.1
            @Override // id.dana.base.SingleClickListener
            public final void PlaceComponentResult(View view) {
                if (QuestView.this.PlaceComponentResult != null) {
                    QuestView.access$100(QuestView.this);
                }
            }
        });
    }

    public void showProgress() {
        this.viewAction.setEnabled(false);
        this.btnQuestAction.setVisibility(8);
        this.lpvLoading.startRefresh();
        this.lpvLoading.setVisibility(0);
    }

    public void dismissProgress() {
        this.lpvLoading.setVisibility(8);
        this.lpvLoading.stopRefresh();
        this.btnQuestAction.setVisibility(0);
        this.viewAction.setEnabled(true);
    }

    public void setQuest(QuestModel questModel, int i, PromoQuestListener.QuestAction questAction) {
        if (questModel != null) {
            if (!isViewBinded()) {
                onAttachedToWindow();
            }
            this.PlaceComponentResult = questModel;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = questAction;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (questModel != null) {
                this.questTitle.setText(questModel.lookAheadTest);
                this.questDescription.setText(questModel.KClassImpl$Data$declaredNonStaticMembers$2);
                if (questModel.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    InstrumentInjector.Resources_setImageResource(this.ivQuestIconState, this.PlaceComponentResult.getAuthRequestContext());
                    String str = questModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case 2252048:
                            if (str.equals("INIT")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 64218584:
                            if (str.equals("CLOSE")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 183181625:
                            if (str.equals("COMPLETE")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1925346054:
                            if (str.equals("ACTIVE")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 2073854099:
                            if (str.equals("FINISH")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    if (c != 0 && c != 1) {
                        if (c == 2) {
                            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f4992130772046);
                            loadAnimation.setAnimationListener(new AnonymousClass4(loadAnimation));
                            this.ivQuestIconState.startAnimation(loadAnimation);
                            this.btnQuestAction.setVisibility(0);
                            this.btnQuestAction.setText(getContext().getString(R.string.redeem));
                            this.btnQuestAction.setVisibility(0);
                            return;
                        } else if (c == 3) {
                            this.btnQuestAction.setVisibility(0);
                            this.btnQuestAction.setText(QuestActionType.GO);
                            this.btnQuestAction.setVisibility(0);
                            return;
                        } else if (c != 4) {
                            return;
                        }
                    }
                    this.btnQuestAction.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.promoquest.views.QuestView$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements Animation.AnimationListener {
        final /* synthetic */ Animation KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass4(Animation animation) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(final Animation animation) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setAnimationListener(this);
            QuestView.this.addDisposable(Observable.timer(2L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.promoquest.views.QuestView$4$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QuestView.AnonymousClass4 anonymousClass4 = QuestView.AnonymousClass4.this;
                    Long l = (Long) obj;
                    QuestView.access$600(QuestView.this, animation);
                }
            }));
        }
    }

    public void setActionFactory(PromoQuestActionFactory promoQuestActionFactory) {
        this.getAuthRequestContext = promoQuestActionFactory;
    }

    public void setRedeemQuestListener(MissionDetailQuestAdapter.RedeemQuestListener redeemQuestListener) {
        this.getErrorConfigVersion = redeemQuestListener;
    }

    public void setCardBehavior(boolean z, int i, int i2, boolean z2) {
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), z ? R.drawable.view_active_quest_divider_sequential_background : R.drawable.view_item_quest_horizontal_divider_sequential_background);
        if (z2) {
            return;
        }
        this.viewTrackLine.setVisibility(i >= i2 ? 4 : 0);
        this.viewTrackLine.setBackground(PlaceComponentResult);
        this.viewQuestSeparator.setVisibility(i >= i2 ? 8 : 0);
    }

    static /* synthetic */ void access$100(QuestView questView) {
        if (questView.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            String upperCase = questView.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.toUpperCase();
            upperCase.hashCode();
            if (!upperCase.equals("COMPLETE")) {
                if (!upperCase.equals("ACTIVE") || questView.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                    return;
                }
                String upperCase2 = questView.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.toUpperCase();
                upperCase2.hashCode();
                char c = 65535;
                int hashCode = upperCase2.hashCode();
                byte b = 0;
                if (hashCode != -1138821620) {
                    if (hashCode != 2280) {
                        if (hashCode == 80083243 && upperCase2.equals(QuestActionType.TRACK)) {
                            c = 2;
                        }
                    } else if (upperCase2.equals(QuestActionType.GO)) {
                        c = 1;
                    }
                } else if (upperCase2.equals(QuestActionType.GO_AND_TRACK)) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1) {
                        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(questView.getBaseActivity().getApplicationContext());
                        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_QUEST_TASK_EXECUTE;
                        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.QUEST_DESCRIPTION, questView.PlaceComponentResult.lookAheadTest);
                        MyBillsEntityDataFactory.PlaceComponentResult();
                        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
                        String str = questView.PlaceComponentResult.moveToNextValue;
                        QuestModel questModel = questView.PlaceComponentResult;
                        Intrinsics.checkNotNullParameter(TopupSource.PROMO_QUEST, "");
                        String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(questModel.scheduleImpl, TopupSource.PROMO_QUEST);
                        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                        PromoQuestActionHandler MyBillsEntityDataFactory2 = questView.getAuthRequestContext.MyBillsEntityDataFactory(str, BuiltInFictitiousFunctionClassFactory);
                        questView.MyBillsEntityDataFactory = MyBillsEntityDataFactory2;
                        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    } else if (c != 2) {
                        return;
                    }
                }
                if (questView.PlaceComponentResult.getErrorConfigVersion != null) {
                    questView.showProgress();
                    questView.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(questView.PlaceComponentResult.getErrorConfigVersion, questView.PlaceComponentResult.getMyBillsEntityDataFactory(), new PromoQuestListener.TrackQuestResultListener() { // from class: id.dana.promoquest.views.QuestView.3
                        @Override // id.dana.promoquest.PromoQuestListener.TrackQuestResultListener
                        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                            QuestView.access$200(QuestView.this);
                            QuestView.this.btnQuestAction.setVisibility(0);
                        }

                        @Override // id.dana.promoquest.PromoQuestListener.TrackQuestResultListener
                        public final void MyBillsEntityDataFactory() {
                            QuestView.access$200(QuestView.this);
                        }

                        @Override // id.dana.promoquest.PromoQuestListener.TrackQuestResultListener
                        public final void getAuthRequestContext() {
                            QuestView.access$200(QuestView.this);
                        }

                        @Override // id.dana.promoquest.PromoQuestListener.TrackQuestResultListener
                        public final void PlaceComponentResult() {
                            QuestView.access$200(QuestView.this);
                            QuestView.access$300(QuestView.this);
                        }
                    });
                }
            } else if (questView.KClassImpl$Data$declaredNonStaticMembers$2 == null || questView.PlaceComponentResult.getErrorConfigVersion == null) {
            } else {
                questView.showProgress();
                questView.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(questView.PlaceComponentResult.getErrorConfigVersion, questView.BuiltInFictitiousFunctionClassFactory, new PromoQuestListener.RedeemQuestResult() { // from class: id.dana.promoquest.views.QuestView.2
                    @Override // id.dana.promoquest.PromoQuestListener.RedeemQuestResult
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        QuestView.access$200(QuestView.this);
                        QuestView.access$300(QuestView.this);
                        QuestView.access$400(QuestView.this);
                    }

                    @Override // id.dana.promoquest.PromoQuestListener.RedeemQuestResult
                    public final void MyBillsEntityDataFactory() {
                        QuestView.access$200(QuestView.this);
                        QuestView.this.btnQuestAction.setVisibility(0);
                    }
                });
            }
        }
    }

    static /* synthetic */ void access$200(QuestView questView) {
        questView.dismissProgress();
        questView.enableClick();
    }

    static /* synthetic */ void access$300(QuestView questView) {
        questView.btnQuestAction.setVisibility(8);
    }

    static /* synthetic */ void access$400(QuestView questView) {
        if (questView.getErrorConfigVersion == null || questView.PlaceComponentResult.getErrorConfigVersion == null) {
            return;
        }
        questView.getErrorConfigVersion.getAuthRequestContext(questView.PlaceComponentResult.getErrorConfigVersion);
    }

    static /* synthetic */ void access$500(QuestView questView, String str) {
        questView.btnQuestAction.setText(str);
        questView.btnQuestAction.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$600(QuestView questView, Animation animation) {
        ImageView imageView = questView.ivQuestIconState;
        if (imageView != null) {
            imageView.startAnimation(animation);
        }
    }
}
