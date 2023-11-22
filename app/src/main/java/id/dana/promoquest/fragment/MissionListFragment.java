package id.dana.promoquest.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.OnClick;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseFragment;
import id.dana.common.DividerItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.promoquest.adapter.MissionsAdapter;
import id.dana.promoquest.model.MissionModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u000bH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0!R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lid/dana/promoquest/fragment/MissionListFragment;", "Lid/dana/base/BaseFragment;", "()V", "isMissionsEmpty", "", "()Z", "receiver", "Landroid/content/BroadcastReceiver;", "skeleton", "Lcom/ethanhua/skeleton/SkeletonScreen;", "disableSwipeRefresh", "", "enable", "dismissProgress", "displayErrorPage", "fetchMissions", "getLayout", "", "handleMissionUpdate", "intent", "Landroid/content/Intent;", IAPSyncCommand.COMMAND_INIT, "onDestroyView", "setMissionWarningVisibility", MaintenanceBroadcastResult.KEY_VISIBLE, "warningType", "setupReceiver", "showProgress", "updateMission", "newMission", "Lid/dana/promoquest/model/MissionModel;", "updateMissions", "missionModels", "", "Companion", "MissionWarningType", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MissionListFragment extends BaseFragment {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion(null);
    private BroadcastReceiver MyBillsEntityDataFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    private SkeletonScreen getErrorConfigVersion;

    public final View MyBillsEntityDataFactory(int i) {
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

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_promo_quest_mission_list;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        BroadcastReceiver broadcastReceiver = this.MyBillsEntityDataFactory;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            broadcastReceiver = null;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }

    @OnClick({R.id.f3534res_0x7f0a023f_apistatus_availablesince})
    public final void fetchMissions() {
        FragmentActivity activity = getActivity();
        MissionListActivity missionListActivity = activity instanceof MissionListActivity ? (MissionListActivity) activity : null;
        if (missionListActivity == null) {
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
            swipeRefreshLayout.setEnabled(true);
        }
        Bundle arguments = getArguments();
        missionListActivity.reloadMissions(arguments != null ? arguments.getString("TabAdapter.key") : null);
    }

    public final void getAuthRequestContext(List<MissionModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MissionsAdapter missionsAdapter = adapter instanceof MissionsAdapter ? (MissionsAdapter) adapter : null;
        if (missionsAdapter == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(list, "");
        missionsAdapter.BuiltInFictitiousFunctionClassFactory = list;
        missionsAdapter.notifyDataSetChanged();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getErrorConfigVersion == null) {
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries));
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = ((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries)).getAdapter();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.layout_promo_quest_mission_card_skeleton;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 2;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            this.getErrorConfigVersion = recyclerViewSkeletonScreen;
        }
    }

    public final void PlaceComponentResult() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.getErrorConfigVersion = null;
    }

    @JvmName(name = "isMissionsEmpty")
    public final boolean MyBillsEntityDataFactory() {
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        MissionsAdapter missionsAdapter = adapter instanceof MissionsAdapter ? (MissionsAdapter) adapter : null;
        return missionsAdapter == null || missionsAdapter.BuiltInFictitiousFunctionClassFactory.isEmpty();
    }

    public static /* synthetic */ void getAuthRequestContext(MissionListFragment missionListFragment) {
        missionListFragment.getAuthRequestContext(false, 0);
    }

    public final void getAuthRequestContext(boolean z, int i) {
        if (!z) {
            RelativeLayout relativeLayout = (RelativeLayout) MyBillsEntityDataFactory(R.id.layout_mission_list_warning);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 0) {
            ImageView imageView = (ImageView) MyBillsEntityDataFactory(R.id.iv_icon_warning);
            if (imageView != null) {
                InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_problem);
            }
            TextView textView = (TextView) MyBillsEntityDataFactory(R.id.tv_warning);
            if (textView != null) {
                textView.setText(getString(R.string.promo_quest_error_mission_title));
            }
            TextView textView2 = (TextView) MyBillsEntityDataFactory(R.id.tv_warning_note);
            if (textView2 != null) {
                textView2.setText(getString(R.string.promo_quest_error_mission_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.res_0x7f0a023f_apistatus_availablesince);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setVisibility(0);
            }
        } else if (i == 1) {
            ImageView imageView2 = (ImageView) MyBillsEntityDataFactory(R.id.iv_icon_warning);
            if (imageView2 != null) {
                InstrumentInjector.Resources_setImageResource(imageView2, R.drawable.ic_new_quest);
            }
            TextView textView3 = (TextView) MyBillsEntityDataFactory(R.id.tv_warning);
            if (textView3 != null) {
                textView3.setText(getString(R.string.promo_quest_no_active_mission_title));
            }
            TextView textView4 = (TextView) MyBillsEntityDataFactory(R.id.tv_warning_note);
            if (textView4 != null) {
                textView4.setText(getString(R.string.promo_quest_no_active_mission_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.res_0x7f0a023f_apistatus_availablesince);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setVisibility(8);
            }
        } else if (i == 2) {
            ImageView imageView3 = (ImageView) MyBillsEntityDataFactory(R.id.iv_icon_warning);
            if (imageView3 != null) {
                InstrumentInjector.Resources_setImageResource(imageView3, R.drawable.history);
            }
            TextView textView5 = (TextView) MyBillsEntityDataFactory(R.id.tv_warning);
            if (textView5 != null) {
                textView5.setText(getString(R.string.promo_quest_no_completed_mission_title));
            }
            TextView textView6 = (TextView) MyBillsEntityDataFactory(R.id.tv_warning_note);
            if (textView6 != null) {
                textView6.setText(getString(R.string.promo_quest_no_completed_mission_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.res_0x7f0a023f_apistatus_availablesince);
            if (danaButtonPrimaryView3 != null) {
                danaButtonPrimaryView3.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) MyBillsEntityDataFactory(R.id.layout_mission_list_warning);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        RecyclerView recyclerView2 = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(4);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/promoquest/fragment/MissionListFragment$MissionWarningType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MissionWarningType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
        public static final int MISSION_ERROR = 0;
        public static final int NO_ACTIVE_MISSION = 1;
        public static final int NO_PAST_MISSION = 2;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promoquest/fragment/MissionListFragment$MissionWarningType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promoquest/fragment/MissionListFragment$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MissionListFragment missionListFragment) {
        Intrinsics.checkNotNullParameter(missionListFragment, "");
        missionListFragment.fetchMissions();
        new Handler().postDelayed(new Runnable() { // from class: id.dana.promoquest.fragment.MissionListFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MissionListFragment.KClassImpl$Data$declaredNonStaticMembers$2(MissionListFragment.this);
            }
        }, 1000L);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MissionListFragment missionListFragment) {
        Intrinsics.checkNotNullParameter(missionListFragment, "");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) missionListFragment.MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            ((SwipeRefreshLayout) missionListFragment.MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1)).setRefreshing(false);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MissionListFragment missionListFragment, Intent intent) {
        int i = 0;
        if (intent.getBooleanExtra("PromoQuest.isNeedRefreshWholeList", false)) {
            FragmentActivity activity = missionListFragment.getActivity();
            MissionListActivity missionListActivity = activity instanceof MissionListActivity ? (MissionListActivity) activity : null;
            if (missionListActivity != null) {
                missionListActivity.reloadBothMissions();
                return;
            }
            return;
        }
        MissionModel missionModel = (MissionModel) intent.getParcelableExtra("PromoQuest.mission");
        if (missionModel != null) {
            RecyclerView recyclerView = (RecyclerView) missionListFragment.MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
            RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            MissionsAdapter missionsAdapter = adapter instanceof MissionsAdapter ? adapter : null;
            if (missionsAdapter != null) {
                Iterator<MissionModel> it = missionsAdapter.BuiltInFictitiousFunctionClassFactory.iterator();
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
                if (i >= 0) {
                    List<MissionModel> mutableList = CollectionsKt.toMutableList((Collection) missionsAdapter.BuiltInFictitiousFunctionClassFactory);
                    mutableList.set(i, missionModel);
                    Intrinsics.checkNotNullParameter(mutableList, "");
                    missionsAdapter.BuiltInFictitiousFunctionClassFactory = mutableList;
                    missionsAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // id.dana.base.BaseFragment
    public final void init() {
        this.MyBillsEntityDataFactory = new BroadcastReceiver() { // from class: id.dana.promoquest.fragment.MissionListFragment$setupReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent, "");
                MissionListFragment.MyBillsEntityDataFactory(MissionListFragment.this, intent);
            }
        };
        Context context = getContext();
        ?? r1 = 0;
        if (context != null) {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            BroadcastReceiver broadcastReceiver = this.MyBillsEntityDataFactory;
            if (broadcastReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                broadcastReceiver = null;
            }
            localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter("PromoQuest.RECEIVE_MISSION"));
        }
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a116a_deletecolumn_entries);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), R.dimen.getAuthRequestContext_res_0x7f070052));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new MissionsAdapter(r1, 1, r1));
        KClassImpl$Data$declaredNonStaticMembers$2();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.BuiltInFictitiousFunctionClassFactory(swipeRefreshLayout.getContext(), R.color.f23182131099816));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: id.dana.promoquest.fragment.MissionListFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void MyBillsEntityDataFactory() {
                MissionListFragment.MyBillsEntityDataFactory(MissionListFragment.this);
            }
        });
    }
}
