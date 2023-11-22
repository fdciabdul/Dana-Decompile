package id.dana.promoquest.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.wireless.security.SecExceptionCode;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.extension.view.ViewExtKt;
import id.dana.promoquest.activity.MissionDetailActivity;
import id.dana.promoquest.adapter.HorizontalQuestAdapter;
import id.dana.promoquest.model.MissionModel;
import id.dana.promoquest.model.QuestModel;
import id.dana.utils.DateTimeUtil;
import io.reactivex.disposables.Disposable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002QRB'\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010L\u001a\u00020\u0005¢\u0006\u0004\bM\u0010NB+\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010L\u001a\u00020\u0005\u0012\u0006\u0010O\u001a\u00020\u0005¢\u0006\u0004\bM\u0010PJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R.\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0019R.\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0007@GX\u0086\u000e¢\u0006\u0018\n\u0004\b$\u0010%\u0012\u0004\b*\u0010\u0004\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u00102\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R0\u0010:\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00058\u0007@GX\u0086\u000e¢\u0006\u0018\n\u0004\b4\u00105\u0012\u0004\b9\u0010\u0004\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u00108R\u0011\u0010>\u001a\u00020;8G¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0018\u0010$\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010AR0\u0010G\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058\u0007@GX\u0086\u000e¢\u0006\u0018\n\u0004\bC\u00105\u0012\u0004\bF\u0010\u0004\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u00108"}, d2 = {"Lid/dana/promoquest/views/MissionCardView;", "Lid/dana/base/BaseRichView;", "", "dispose", "()V", "", "getLayout", "()I", "", "isForRecyclerViewholder", "()Z", "setup", "Ljava/util/Date;", MaintenanceBroadcastResult.KEY_DATE, "MyBillsEntityDataFactory", "Ljava/util/Date;", "getExpiresIn", "()Ljava/util/Date;", "setExpiresIn", "(Ljava/util/Date;)V", "expiresIn", "getAuthRequestContext", "Z", "isQuestsVisible", "setQuestsVisible", "(Z)V", "Lid/dana/promoquest/model/MissionModel;", "mission", "PlaceComponentResult", "Lid/dana/promoquest/model/MissionModel;", "getMission", "()Lid/dana/promoquest/model/MissionModel;", "setMission", "(Lid/dana/promoquest/model/MissionModel;)V", "", "status", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getMissionStatus", "()Ljava/lang/String;", "setMissionStatus", "(Ljava/lang/String;)V", "getMissionStatus$annotations", "missionStatus", "", "title", "getMissionTitle", "()Ljava/lang/CharSequence;", "setMissionTitle", "(Ljava/lang/CharSequence;)V", "missionTitle", "type", "BuiltInFictitiousFunctionClassFactory", "I", "getMissionType", "setMissionType", "(I)V", "getMissionType$annotations", "missionType", "Lid/dana/promoquest/adapter/HorizontalQuestAdapter;", "getQuestAdapter", "()Lid/dana/promoquest/adapter/HorizontalQuestAdapter;", "questAdapter", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "Lcom/ethanhua/skeleton/SkeletonScreen;", "cardSize", "lookAheadTest", "getSize", "setSize", "getSize$annotations", GriverMonitorConstants.KEY_SIZE, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "CardSize", "MissionType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MissionCardView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int missionType;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String missionStatus;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Date expiresIn;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MissionModel mission;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isQuestsVisible;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int size;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissionCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissionCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static /* synthetic */ void getMissionStatus$annotations() {
    }

    public static /* synthetic */ void getMissionType$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
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
        return R.layout.view_item_promo_quest_mission_card;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        ((ConstraintLayout) _$_findCachedViewById(R.id.cv_content)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.views.MissionCardView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionCardView.$r8$lambda$XmQy96HGy3fZXAzD6g4ncko24dQ(MissionCardView.this, view);
            }
        });
        this.missionStatus = "INIT";
        this.size = 1;
    }

    public /* synthetic */ MissionCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        ((ConstraintLayout) _$_findCachedViewById(R.id.cv_content)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promoquest.views.MissionCardView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionCardView.$r8$lambda$XmQy96HGy3fZXAzD6g4ncko24dQ(MissionCardView.this, view);
            }
        });
        this.missionStatus = "INIT";
        this.size = 1;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setClipToPadding(false);
        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay);
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a17cf_pinfamilyaccountpresenter_removefamilyaccount_1);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        recyclerView.setAdapter(new HorizontalQuestAdapter(textView));
    }

    @Override // id.dana.base.BaseRichView
    public final void dispose() {
        Disposable disposable = getQuestAdapter().BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @JvmName(name = "getMission")
    public final MissionModel getMission() {
        return this.mission;
    }

    @JvmName(name = "setMission")
    public final void setMission(MissionModel missionModel) {
        String str;
        String str2;
        this.mission = missionModel;
        setMissionTitle(missionModel != null ? missionModel.DatabaseTableConfigUtil : null);
        if (missionModel == null || (str = missionModel.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
            str = "INIT";
        }
        setMissionStatus(str);
        setExpiresIn(missionModel != null ? missionModel.lookAheadTest : null);
        if (missionModel != null) {
            str2 = missionModel.MyBillsEntityDataFactory() ? missionModel.GetContactSyncConfig : missionModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str2 == null) {
                str2 = "";
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str2).getErrorConfigVersion((int) R.drawable.banner_placeholder).PlaceComponentResult((int) R.drawable.banner_placeholder).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.CashierEntityDataFactory_Factory));
        MissionModel missionModel2 = this.mission;
        byte b = 0;
        if (missionModel2 != null && missionModel2.BuiltInFictitiousFunctionClassFactory()) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.CashierEntityDataFactory_Factory);
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(imageView);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.CashierEntityDataFactory_Factory)).clearColorFilter();
        }
        if (this.isQuestsVisible) {
            List<QuestModel> list = missionModel != null ? missionModel.newProxyInstance : null;
            if (list == null || list.isEmpty()) {
                _$_findCachedViewById(R.id.RedeemQuestEntityMapper_Factory).setVisibility(0);
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(_$_findCachedViewById(R.id.RedeemQuestEntityMapper_Factory));
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.layout_quest_horizontal_list_skeleton;
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = SecExceptionCode.SEC_ERROR_MALDETECT;
                    BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                    ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
                    viewSkeletonScreen.MyBillsEntityDataFactory();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = viewSkeletonScreen;
                }
            } else {
                SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                MissionModel missionModel3 = this.mission;
                if (missionModel3 == null) {
                    getQuestAdapter().PlaceComponentResult(CollectionsKt.emptyList());
                } else {
                    getQuestAdapter().PlaceComponentResult = missionModel3.getPlaceComponentResult() ? 1 : 0;
                    getQuestAdapter().PlaceComponentResult(missionModel3.newProxyInstance);
                }
            }
            ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay)).setVisibility(0);
            post(new Runnable() { // from class: id.dana.promoquest.views.MissionCardView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MissionCardView.m2791$r8$lambda$MGkfOnkdS5ssnBlJMLfk9vmii4(MissionCardView.this);
                }
            });
            return;
        }
        _$_findCachedViewById(R.id.RedeemQuestEntityMapper_Factory).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay)).setVisibility(8);
        HorizontalQuestAdapter questAdapter = getQuestAdapter();
        questAdapter.getAuthRequestContext.clear();
        questAdapter.notifyDataSetChanged();
    }

    @JvmName(name = "getMissionTitle")
    public final CharSequence getMissionTitle() {
        return ((TextView) _$_findCachedViewById(R.id.res_0x7f0a17cf_pinfamilyaccountpresenter_removefamilyaccount_1)).getText();
    }

    @JvmName(name = "setMissionTitle")
    public final void setMissionTitle(CharSequence charSequence) {
        ((TextView) _$_findCachedViewById(R.id.res_0x7f0a17cf_pinfamilyaccountpresenter_removefamilyaccount_1)).setText(charSequence);
    }

    @JvmName(name = "isQuestsVisible")
    /* renamed from: isQuestsVisible  reason: from getter */
    public final boolean getIsQuestsVisible() {
        return this.isQuestsVisible;
    }

    @JvmName(name = "setQuestsVisible")
    public final void setQuestsVisible(boolean z) {
        this.isQuestsVisible = z;
    }

    @JvmName(name = "getMissionStatus")
    public final String getMissionStatus() {
        return this.missionStatus;
    }

    @JvmName(name = "setMissionStatus")
    public final void setMissionStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.missionStatus = str;
        switch (str.hashCode()) {
            case 64218584:
                if (str.equals("CLOSE")) {
                    InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.setProxyNotificationsInitialized), R.drawable.ic_promo_quest_mission_expired);
                    ((TextView) _$_findCachedViewById(R.id.tv_expire_time)).setText(getResources().getString(R.string.mission_expired));
                    return;
                }
                return;
            case 183181625:
                if (!str.equals("COMPLETE")) {
                    return;
                }
                break;
            case 1925346054:
                if (str.equals("ACTIVE")) {
                    InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.setProxyNotificationsInitialized), R.drawable.ic_promo_quest_mission_active);
                    Date date = this.expiresIn;
                    setExpiresIn(new Date(date != null ? date.getTime() : 0L));
                    return;
                }
                return;
            case 2073854099:
                if (!str.equals("FINISH")) {
                    return;
                }
                break;
            default:
                return;
        }
        InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.setProxyNotificationsInitialized), R.drawable.ic_promo_quest_mission_completed);
        ((TextView) _$_findCachedViewById(R.id.tv_expire_time)).setText(getResources().getString(R.string.mission_completed));
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    @JvmName(name = "setSize")
    public final void setSize(int i) {
        this.size = i;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.CashierEntityDataFactory_Factory);
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        ViewExtKt.BuiltInFictitiousFunctionClassFactory(imageView, Float.valueOf(i != 0 ? i != 2 ? 165.0f : 171.0f : 154.0f));
        if (i == 0) {
            MissionCardView missionCardView = this;
            ViewExtKt.MyBillsEntityDataFactory(missionCardView, Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.f33802131166079)), (Integer) null);
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(missionCardView, Float.valueOf(4.0f), null, Float.valueOf(4.0f), null, 10);
        } else if (i == 2) {
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this, Float.valueOf(4.0f), null, Float.valueOf(4.0f), null, 10);
        } else {
            ViewExtKt.MyBillsEntityDataFactory(this, Float.valueOf(16.0f), Float.valueOf(5.0f), Float.valueOf(16.0f), Float.valueOf(5.0f));
        }
    }

    @JvmName(name = "getMissionType")
    public final int getMissionType() {
        return this.missionType;
    }

    @JvmName(name = "setMissionType")
    public final void setMissionType(int i) {
        this.missionType = i;
        getQuestAdapter().PlaceComponentResult = i;
        getQuestAdapter().notifyDataSetChanged();
    }

    @JvmName(name = "getQuestAdapter")
    public final HorizontalQuestAdapter getQuestAdapter() {
        RecyclerView.Adapter adapter = ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay)).getAdapter();
        if (adapter != null) {
            return (HorizontalQuestAdapter) adapter;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.promoquest.adapter.HorizontalQuestAdapter");
    }

    @JvmName(name = "getExpiresIn")
    public final Date getExpiresIn() {
        return this.expiresIn;
    }

    @JvmName(name = "setExpiresIn")
    public final void setExpiresIn(Date date) {
        String string;
        String str;
        this.expiresIn = date;
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_expire_time);
        if (date != null) {
            int PlaceComponentResult = (int) DateTimeUtil.PlaceComponentResult(date);
            if (PlaceComponentResult > 0) {
                string = getResources().getQuantityString(R.plurals.f46632131820547, PlaceComponentResult, Integer.valueOf(PlaceComponentResult));
            } else {
                int MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(date);
                if (MyBillsEntityDataFactory > 0) {
                    string = getResources().getQuantityString(R.plurals.f46642131820548, MyBillsEntityDataFactory, Integer.valueOf(MyBillsEntityDataFactory));
                } else if (MyBillsEntityDataFactory >= 0) {
                    string = getResources().getString(R.string.expiring_soon);
                } else {
                    string = getResources().getString(R.string.mission_expired);
                }
            }
            str = string;
        }
        textView.setText(str);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/promoquest/views/MissionCardView$CardSize;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CardSize {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
        public static final int LARGE = 2;
        public static final int MEDIUM = 1;
        public static final int SMALL = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promoquest/views/MissionCardView$CardSize$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/promoquest/views/MissionCardView$MissionType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MissionType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
        public static final int FLEXIBLE = 1;
        public static final int SEQUENTIAL = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promoquest/views/MissionCardView$MissionType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

            private Companion() {
            }
        }
    }

    /* renamed from: $r8$lambda$MGkfOnkdS5ss-nBlJMLfk9vmii4  reason: not valid java name */
    public static /* synthetic */ void m2791$r8$lambda$MGkfOnkdS5ssnBlJMLfk9vmii4(MissionCardView missionCardView) {
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(missionCardView, "");
        RecyclerView recyclerView = (RecyclerView) missionCardView._$_findCachedViewById(R.id.res_0x7f0a117f_access_resumesliderwithdelay);
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    public static /* synthetic */ void $r8$lambda$XmQy96HGy3fZXAzD6g4ncko24dQ(MissionCardView missionCardView, View view) {
        Intrinsics.checkNotNullParameter(missionCardView, "");
        MissionModel missionModel = missionCardView.mission;
        if (missionModel != null) {
            MissionDetailActivity.Companion companion = MissionDetailActivity.INSTANCE;
            Context context = missionCardView.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            Activity activity = (Activity) context;
            Intrinsics.checkNotNullParameter(activity, "");
            Intrinsics.checkNotNullParameter(missionModel, "");
            activity.startActivity(MissionDetailActivity.Companion.BuiltInFictitiousFunctionClassFactory(activity, missionModel));
        }
    }
}
