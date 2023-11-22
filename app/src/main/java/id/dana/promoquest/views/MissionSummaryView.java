package id.dana.promoquest.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMissionSummaryComponent;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.promoquest.adapter.MissionSummaryAdapter;
import id.dana.promoquest.model.MissionModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 B+\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\"J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004R\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/promoquest/views/MissionSummaryView;", "Lid/dana/base/BaseRichView;", "", "checkPromoQuest", "()V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "onViewAllClicked", "setup", "unregisterReceiver", "Lid/dana/contract/promoquest/quest/MissionSummaryContract$Presenter;", "missionSummaryPresenter", "Lid/dana/contract/promoquest/quest/MissionSummaryContract$Presenter;", "getMissionSummaryPresenter", "()Lid/dana/contract/promoquest/quest/MissionSummaryContract$Presenter;", "setMissionSummaryPresenter", "(Lid/dana/contract/promoquest/quest/MissionSummaryContract$Presenter;)V", "Landroid/content/BroadcastReceiver;", "getAuthRequestContext", "Landroid/content/BroadcastReceiver;", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MissionSummaryView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private BroadcastReceiver PlaceComponentResult;
    @Inject
    public MissionSummaryContract.Presenter missionSummaryPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissionSummaryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissionSummaryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_promo_quest;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionSummaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MissionSummaryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionSummaryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getMissionSummaryPresenter")
    public final MissionSummaryContract.Presenter getMissionSummaryPresenter() {
        MissionSummaryContract.Presenter presenter = this.missionSummaryPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMissionSummaryPresenter")
    public final void setMissionSummaryPresenter(MissionSummaryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.missionSummaryPresenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMissionSummaryComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMissionSummaryComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (MissionSummaryModule) Preconditions.getAuthRequestContext(new MissionSummaryModule(new MissionSummaryContract.View() { // from class: id.dana.promoquest.views.MissionSummaryView$getSummaryModule$1
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

            @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
            public final void MyBillsEntityDataFactory(List<MissionModel> p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((ConstraintLayout) MissionSummaryView.this._$_findCachedViewById(R.id.rl_promo_container)).setVisibility(r2 ? 0 : 8);
                MissionSummaryView.access$updateData(MissionSummaryView.this, p0);
            }

            @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
            public final void getAuthRequestContext() {
                ((ConstraintLayout) MissionSummaryView.this._$_findCachedViewById(R.id.rl_promo_container)).setVisibility(r2 ? 0 : 8);
            }

            @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                if (p0) {
                    MissionSummaryView.this.getMissionSummaryPresenter().BuiltInFictitiousFunctionClassFactory();
                } else {
                    ((ConstraintLayout) MissionSummaryView.this._$_findCachedViewById(R.id.rl_promo_container)).setVisibility(r2 ? 0 : 8);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, MissionSummaryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerMissionSummaryComponent.MissionSummaryComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getMissionSummaryPresenter());
    }

    public final void checkPromoQuest() {
        getMissionSummaryPresenter().MyBillsEntityDataFactory();
    }

    public final void unregisterReceiver() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        BroadcastReceiver broadcastReceiver = this.PlaceComponentResult;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            broadcastReceiver = null;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    @OnClick({R.id.btn_view_all})
    public final void onViewAllClicked() {
        Intent intent = new Intent(getBaseActivity(), MissionListActivity.class);
        intent.putExtra("source", TrackerKey.SourceType.PROMO_QUEST_AT_HOME);
        getContext().startActivity(intent);
    }

    public static final /* synthetic */ void access$updateData(MissionSummaryView missionSummaryView, List list) {
        RecyclerView recyclerView = (RecyclerView) missionSummaryView._$_findCachedViewById(R.id.res_0x7f0a116a_deletecolumn_entries);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MissionSummaryAdapter missionSummaryAdapter = adapter instanceof MissionSummaryAdapter ? (MissionSummaryAdapter) adapter : null;
        if (missionSummaryAdapter != null) {
            missionSummaryAdapter.setItems(list);
        }
    }

    public static final /* synthetic */ void access$updateMission(MissionSummaryView missionSummaryView, MissionModel missionModel) {
        List<MissionModel> items;
        RecyclerView recyclerView = (RecyclerView) missionSummaryView._$_findCachedViewById(R.id.res_0x7f0a116a_deletecolumn_entries);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MissionSummaryAdapter missionSummaryAdapter = adapter instanceof MissionSummaryAdapter ? (MissionSummaryAdapter) adapter : null;
        if (missionSummaryAdapter == null || (items = missionSummaryAdapter.getItems()) == null) {
            return;
        }
        Iterator<MissionModel> it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().initRecordTimeStamp, missionModel.initRecordTimeStamp)) {
                break;
            } else {
                i++;
            }
        }
        Integer valueOf = Integer.valueOf(i);
        Integer num = valueOf.intValue() >= 0 ? valueOf : null;
        if (num != null) {
            int intValue = num.intValue();
            List<MissionModel> items2 = missionSummaryAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            List mutableList = CollectionsKt.toMutableList((Collection) items2);
            mutableList.set(intValue, missionModel);
            missionSummaryAdapter.setItems(mutableList);
            missionSummaryAdapter.notifyItemInserted(intValue);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        new PagerSnapHelper().KClassImpl$Data$declaredNonStaticMembers$2((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a116a_deletecolumn_entries));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a116a_deletecolumn_entries);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setClipToPadding(false);
        recyclerView.setAdapter(new MissionSummaryAdapter());
        checkPromoQuest();
        this.PlaceComponentResult = new BroadcastReceiver() { // from class: id.dana.promoquest.views.MissionSummaryView$setupReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent, "");
                MissionModel missionModel = (MissionModel) intent.getParcelableExtra("PromoQuest.mission");
                if (missionModel == null) {
                    return;
                }
                MissionSummaryView.access$updateMission(MissionSummaryView.this, missionModel);
            }
        };
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        BroadcastReceiver broadcastReceiver = this.PlaceComponentResult;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            broadcastReceiver = null;
        }
        localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter("PromoQuest.RECEIVE_MISSION"));
    }
}
