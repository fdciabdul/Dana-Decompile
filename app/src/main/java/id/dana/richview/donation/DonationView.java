package id.dana.richview.donation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDonationComponent;
import id.dana.di.modules.DonationModule;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import id.dana.donation.DonationContract;
import id.dana.donation.mapper.DonationCampaignModelMapperKt;
import id.dana.donation.model.DonationCampaignModel;
import id.dana.richview.widgetcard.WidgetCardView;
import id.dana.richview.widgetcard.WidgetItem;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 B+\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0015\u001a\u00020\u00188\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019"}, d2 = {"Lid/dana/richview/donation/DonationView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "Lid/dana/donation/DonationContract$Presenter;", "donatinPresenter", "Lid/dana/donation/DonationContract$Presenter;", "getDonatinPresenter", "()Lid/dana/donation/DonationContract$Presenter;", "setDonatinPresenter", "(Lid/dana/donation/DonationContract$Presenter;)V", "", "Lid/dana/donation/model/DonationCampaignModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "MyBillsEntityDataFactory", "", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DonationView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<DonationCampaignModel> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DonationContract.Presenter donatinPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DonationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DonationView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_donation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ DonationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getDonatinPresenter")
    public final DonationContract.Presenter getDonatinPresenter() {
        DonationContract.Presenter presenter = this.donatinPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDonatinPresenter")
    public final void setDonatinPresenter(DonationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.donatinPresenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        WidgetCardView widgetCardView = (WidgetCardView) _$_findCachedViewById(R.id.GriverStartClientProxy);
        widgetCardView.setActionButtonListener(new View.OnClickListener() { // from class: id.dana.richview.donation.DonationView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonationView.m2837$r8$lambda$rVWzcvQCRj2KCTvkIjyNDtZw3E(DonationView.this, view);
            }
        });
        widgetCardView.setOnItemClickListener(new WidgetCardView.OnItemClickListener() { // from class: id.dana.richview.donation.DonationView$setup$1$2
            @Override // id.dana.richview.widgetcard.WidgetCardView.OnItemClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, WidgetItem p1) {
                List list;
                Intrinsics.checkNotNullParameter(p1, "");
                DonationContract.Presenter donatinPresenter = DonationView.this.getDonatinPresenter();
                list = DonationView.this.MyBillsEntityDataFactory;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    list = null;
                }
                donatinPresenter.BuiltInFictitiousFunctionClassFactory((DonationCampaignModel) list.get(p0));
            }
        });
        getDonatinPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        super.injectComponent(applicationComponent);
        DaggerDonationComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerDonationComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (DonationModule) Preconditions.getAuthRequestContext(new DonationModule(new DonationContract.View() { // from class: id.dana.richview.donation.DonationView$injectComponent$1
            @Override // id.dana.donation.DonationContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<DonationCampaignModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DonationView.this.MyBillsEntityDataFactory = p0;
                ((WidgetCardView) DonationView.this._$_findCachedViewById(R.id.GriverStartClientProxy)).setWidgets(DonationCampaignModelMapperKt.PlaceComponentResult(p0));
            }

            @Override // id.dana.donation.DonationContract.View
            public final void MyBillsEntityDataFactory(DonationCampaignConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((WidgetCardView) DonationView.this._$_findCachedViewById(R.id.GriverStartClientProxy)).setVisibility(0);
                DonationView donationView = DonationView.this;
                String authRequestContext = UrlUtil.getAuthRequestContext(p0.getRedirectUrl());
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                donationView.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
            }

            @Override // id.dana.donation.DonationContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String authRequestContext = UrlUtil.getAuthRequestContext(p0);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, DonationModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerDonationComponent.DonationComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    /* renamed from: $r8$lambda$rVWzcvQCRj-2KCTvkIjyNDtZw3E  reason: not valid java name */
    public static /* synthetic */ void m2837$r8$lambda$rVWzcvQCRj2KCTvkIjyNDtZw3E(DonationView donationView, View view) {
        Intrinsics.checkNotNullParameter(donationView, "");
        String str = donationView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(str);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }
}
