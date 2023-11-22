package id.dana.onlinemerchant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerOnlineMerchantListViewComponent;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.model.ThirdPartyService;
import id.dana.onlinemerchant.adapter.OnlineMerchantAdapter;
import id.dana.onlinemerchant.model.OnlineMerchantWrapper;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;
import id.dana.utils.KeyboardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001DB%\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010CJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\n\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\n\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u001b\u0010\u001a\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0010J\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0010J\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0010R\"\u0010!\u001a\u00020\u001e8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010\u0019\u001a\u00020%8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0016\u0010&R$\u0010.\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<"}, d2 = {"Lid/dana/onlinemerchant/view/OnlineMerchantListView;", "Lid/dana/base/BaseRichView;", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "merchantList", "", "appendMerchantListItem", "(Ljava/util/List;)V", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "getLayout", "()I", "hideLargeSkeleton", "()V", "hideSmallSkeleton", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "PlaceComponentResult", "Landroidx/recyclerview/widget/GridLayoutManager;", "()Landroidx/recyclerview/widget/GridLayoutManager;", "BuiltInFictitiousFunctionClassFactory", "setMerchantListItem", "setup", "showLargeSkeleton", "showSmallSkeleton", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "isKeyboardShown", "()Z", "setKeyboardShown", "(Z)V", "Lid/dana/onlinemerchant/adapter/OnlineMerchantAdapter;", "Lid/dana/onlinemerchant/adapter/OnlineMerchantAdapter;", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "getAuthRequestContext", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "getOnlineMerchantItemListener", "()Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "setOnlineMerchantItemListener", "(Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;)V", "onlineMerchantItemListener", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "tracker", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "getTracker", "()Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "setTracker", "(Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnlineMerchantItemListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantListView extends BaseRichView {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 3395795826469762761L;
    private static int MyBillsEntityDataFactory = 0;
    private static int moveToNextValue = 1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean isKeyboardShown;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnlineMerchantAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private OnlineMerchantItemListener onlineMerchantItemListener;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    @Inject
    public OnlineMerchantAnalyticTracker tracker;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/globalsearch/model/PaySearchInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnlineMerchantItemListener {
        void getAuthRequestContext(PaySearchInfoModel p0);
    }

    public static /* synthetic */ void $r8$lambda$MEbWdVkcYUltVGw4dpdQQ_85aWY(OnlineMerchantListView onlineMerchantListView, int i) {
        try {
            int i2 = MyBillsEntityDataFactory + 107;
            moveToNextValue = i2 % 128;
            int i3 = i2 % 2;
            PlaceComponentResult(onlineMerchantListView, i);
            int i4 = moveToNextValue + 13;
            MyBillsEntityDataFactory = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = 69 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        try {
            int i = MyBillsEntityDataFactory + 89;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            this._$_findViewCache.clear();
            int i3 = MyBillsEntityDataFactory + 93;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final View _$_findCachedViewById(int i) {
        int i2;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if ((view == null ? '6' : (char) 7) == '6') {
            try {
                view = findViewById(i);
                if ((view != null ? (char) 19 : (char) 22) != 19) {
                    view = null;
                    i2 = moveToNextValue + 25;
                } else {
                    int i3 = MyBillsEntityDataFactory + 121;
                    moveToNextValue = i3 % 128;
                    int i4 = i3 % 2;
                    map.put(Integer.valueOf(i), view);
                    i2 = moveToNextValue + 69;
                }
                MyBillsEntityDataFactory = i2 % 128;
                int i5 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        int i = moveToNextValue + 115;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        int i3 = MyBillsEntityDataFactory + 117;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.view_online_merchant_list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineMerchantListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ OnlineMerchantListView(android.content.Context r3, android.util.AttributeSet r4, int r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 2
            r0 = 1
            if (r7 == 0) goto Lf
            r4 = 0
            int r7 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory
            int r7 = r7 + r0
            int r1 = r7 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1
            int r7 = r7 % 2
        Lf:
            r6 = r6 & 4
            r7 = 0
            if (r6 == 0) goto L16
            r6 = 0
            goto L17
        L16:
            r6 = 1
        L17:
            if (r6 == 0) goto L1a
            goto L29
        L1a:
            int r5 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L2d
            int r5 = r5 + 119
            int r6 = r5 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r6     // Catch: java.lang.Exception -> L2d
            int r5 = r5 % 2
            if (r5 != 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 0
        L29:
            r2.<init>(r3, r4, r5)
            return
        L2d:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final /* synthetic */ OnlineMerchantAdapter access$getOnlineMerchantAdapter$p(OnlineMerchantListView onlineMerchantListView) {
        try {
            int i = MyBillsEntityDataFactory + 39;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            OnlineMerchantAdapter onlineMerchantAdapter = onlineMerchantListView.BuiltInFictitiousFunctionClassFactory;
            try {
                int i3 = MyBillsEntityDataFactory + 79;
                moveToNextValue = i3 % 128;
                if (i3 % 2 != 0) {
                    return onlineMerchantAdapter;
                }
                Object obj = null;
                obj.hashCode();
                return onlineMerchantAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        try {
            int i = MyBillsEntityDataFactory + 29;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            try {
                ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
                Object[] objArr = null;
                if (!(presenter == null)) {
                    int i3 = moveToNextValue + 75;
                    MyBillsEntityDataFactory = i3 % 128;
                    if ((i3 % 2 != 0 ? ';' : (char) 21) == ';') {
                        int length = objArr.length;
                    }
                    return presenter;
                }
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i4 = MyBillsEntityDataFactory + 73;
                moveToNextValue = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 31 / 0;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = moveToNextValue + 103;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
        } else {
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.readLinkPropertiesPresenter = presenter;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = MyBillsEntityDataFactory + 21;
        moveToNextValue = i2 % 128;
        if ((i2 % 2 == 0 ? 'Z' : (char) 7) != 'Z') {
            return;
        }
        int i3 = 60 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if ((r0 != null ? 19 : 0) != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        r4 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue + 7;
        id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if ((r4 % 2) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if (r1 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory + 17;
        id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if ((r0 % 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0051, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if ((r0 != null) != false) goto L18;
     */
    @kotlin.jvm.JvmName(name = "getTracker")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker getTracker() {
        /*
            r6 = this;
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r0 = r0 + 69
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1c
            id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker r0 = r6.tracker
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L16
            r4 = 1
            goto L17
        L16:
            r4 = 0
        L17:
            if (r4 == 0) goto L3c
            goto L26
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker r0 = r6.tracker
            if (r0 == 0) goto L23
            r4 = 19
            goto L24
        L23:
            r4 = 0
        L24:
            if (r4 == 0) goto L3c
        L26:
            int r4 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r4 = r4 + 7
            int r5 = r4 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L33
            r1 = 0
        L33:
            if (r1 == 0) goto L36
            return r0
        L36:
            r3.hashCode()     // Catch: java.lang.Throwable -> L3a
            return r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L51
            int r0 = r3.length     // Catch: java.lang.Throwable -> L4f
            return r3
        L4f:
            r0 = move-exception
            throw r0
        L51:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.getTracker():id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker");
    }

    @JvmName(name = "setTracker")
    public final void setTracker(OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        int i = moveToNextValue + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(onlineMerchantAnalyticTracker, "");
            this.tracker = onlineMerchantAnalyticTracker;
            int i3 = moveToNextValue + 63;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getOnlineMerchantItemListener")
    public final OnlineMerchantItemListener getOnlineMerchantItemListener() {
        int i = moveToNextValue + 39;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            try {
                return this.onlineMerchantItemListener;
            } catch (Exception e) {
                throw e;
            }
        }
        OnlineMerchantItemListener onlineMerchantItemListener = this.onlineMerchantItemListener;
        Object obj = null;
        obj.hashCode();
        return onlineMerchantItemListener;
    }

    @JvmName(name = "setOnlineMerchantItemListener")
    public final void setOnlineMerchantItemListener(OnlineMerchantItemListener onlineMerchantItemListener) {
        int i = MyBillsEntityDataFactory + 1;
        moveToNextValue = i % 128;
        if ((i % 2 == 0 ? ']' : (char) 28) == 28) {
            this.onlineMerchantItemListener = onlineMerchantItemListener;
            return;
        }
        try {
            this.onlineMerchantItemListener = onlineMerchantItemListener;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "isKeyboardShown")
    public final boolean isKeyboardShown() {
        int i = MyBillsEntityDataFactory + 29;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        boolean z = this.isKeyboardShown;
        int i3 = MyBillsEntityDataFactory + 107;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    @JvmName(name = "setKeyboardShown")
    public final void setKeyboardShown(boolean z) {
        int i = moveToNextValue + 37;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        this.isKeyboardShown = z;
        int i3 = moveToNextValue + 53;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r1 = new id.dana.onlinemerchant.adapter.OnlineMerchantAdapter();
        r2.BuiltInFictitiousFunctionClassFactory = r1;
        r0.setAdapter(r1);
        r0.setLayoutManager(MyBillsEntityDataFactory());
        r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory + 99;
        id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r0 % 128;
        r0 = r0 % 2;
     */
    @Override // id.dana.base.BaseRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setup() {
        /*
            r2 = this;
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue     // Catch: java.lang.Exception -> L54
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L54
            int r0 = r0 % 2
            r1 = 76
            if (r0 == 0) goto L11
            r0 = 76
            goto L13
        L11:
            r0 = 68
        L13:
            if (r0 == r1) goto L20
            int r0 = id.dana.R.id.ExcludeFromJacocoGeneratedReport
            android.view.View r0 = r2._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            if (r0 == 0) goto L4b
            goto L2c
        L20:
            int r0 = id.dana.R.id.ExcludeFromJacocoGeneratedReport
            android.view.View r0 = r2._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L4b
        L2c:
            id.dana.onlinemerchant.adapter.OnlineMerchantAdapter r1 = new id.dana.onlinemerchant.adapter.OnlineMerchantAdapter
            r1.<init>()
            r2.BuiltInFictitiousFunctionClassFactory = r1
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r0.setAdapter(r1)
            androidx.recyclerview.widget.GridLayoutManager r1 = r2.MyBillsEntityDataFactory()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r0.setLayoutManager(r1)
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1
            int r0 = r0 % 2
        L4b:
            r2.BuiltInFictitiousFunctionClassFactory()
            r2.PlaceComponentResult()
            return
        L52:
            r0 = move-exception
            throw r0
        L54:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.setup():void");
    }

    private final void PlaceComponentResult() {
        KeyboardHelper.PlaceComponentResult(this, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onlinemerchant.view.OnlineMerchantListView$setKeyboardVisibilityListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                OnlineMerchantListView.this.setKeyboardShown(true);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                OnlineMerchantListView.this.setKeyboardShown(false);
            }
        });
        try {
            int i = MyBillsEntityDataFactory + 63;
            try {
                moveToNextValue = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerOnlineMerchantListViewComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerOnlineMerchantListViewComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getBaseActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        a(KeyEvent.normalizeMetaState(0) + 8563, new char[]{10201, 1692, 25886, 17317, 41519, 32982, 61277, 52700}, objArr);
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.onlinemerchant.view.OnlineMerchantListView$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = new ServicesModule();
            int i = MyBillsEntityDataFactory + 101;
            moveToNextValue = i % 128;
            int i2 = i % 2;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new OnlineMerchantAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerOnlineMerchantListViewComponent.OnlineMerchantListViewComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).getAuthRequestContext(this);
        int i3 = moveToNextValue + 97;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 != 0 ? 'T' : (char) 1) != 1) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private final GridLayoutManager MyBillsEntityDataFactory() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.onlinemerchant.view.OnlineMerchantListView$setLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public final int PlaceComponentResult(int p0) {
                OnlineMerchantAdapter access$getOnlineMerchantAdapter$p = OnlineMerchantListView.access$getOnlineMerchantAdapter$p(OnlineMerchantListView.this);
                if (access$getOnlineMerchantAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    access$getOnlineMerchantAdapter$p = null;
                }
                int itemViewType = access$getOnlineMerchantAdapter$p.getItemViewType(p0);
                if (itemViewType != 0) {
                    if (itemViewType != 2) {
                        return 1;
                    }
                    return gridLayoutManager.getErrorConfigVersion;
                }
                return gridLayoutManager.getErrorConfigVersion;
            }
        };
        int i = moveToNextValue + 65;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? ',' : '+') != '+') {
            Object obj = null;
            obj.hashCode();
            return gridLayoutManager;
        }
        return gridLayoutManager;
    }

    public final void showSmallSkeleton() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
        if (recyclerView != null) {
            int i = MyBillsEntityDataFactory + 27;
            moveToNextValue = i % 128;
            if (i % 2 == 0) {
                recyclerView.setNestedScrollingEnabled(true);
            } else {
                recyclerView.setNestedScrollingEnabled(false);
            }
        }
        OnlineMerchantAdapter onlineMerchantAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if ((onlineMerchantAdapter == null ? '6' : 'M') != 'M') {
            int i2 = moveToNextValue + 123;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            onlineMerchantAdapter = null;
            int i4 = moveToNextValue + 9;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
        }
        onlineMerchantAdapter.setItems(CollectionsKt.mutableListOf(new OnlineMerchantWrapper(0, new PaySearchInfoModel(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, false, false, 1048575, null))));
    }

    public final void hideSmallSkeleton() {
        OnlineMerchantAdapter onlineMerchantAdapter = this.BuiltInFictitiousFunctionClassFactory;
        Object[] objArr = null;
        if ((onlineMerchantAdapter == null ? Typography.less : '-') != '-') {
            int i = MyBillsEntityDataFactory + 19;
            moveToNextValue = i % 128;
            if (i % 2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i2 = 59 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            onlineMerchantAdapter = null;
        }
        try {
            List<OnlineMerchantWrapper> items = onlineMerchantAdapter.getItems();
            try {
                Intrinsics.checkNotNullExpressionValue(items, "");
                CollectionsKt.removeAll((List) items, (Function1) new Function1<OnlineMerchantWrapper, Boolean>() { // from class: id.dana.onlinemerchant.adapter.OnlineMerchantAdapter$hideTrendingLoadingSkeleton$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(OnlineMerchantWrapper onlineMerchantWrapper) {
                        return Boolean.valueOf(onlineMerchantWrapper.getAuthRequestContext == 0);
                    }
                });
                onlineMerchantAdapter.notifyDataSetChanged();
                int i3 = moveToNextValue + 57;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 != 0 ? 'a' : '^') != '^') {
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void showLargeSkeleton() {
        int i = moveToNextValue + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
        if ((recyclerView != null ? 'Q' : (char) 6) == 'Q') {
            int i3 = MyBillsEntityDataFactory + 95;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            recyclerView.setNestedScrollingEnabled(false);
        }
        OnlineMerchantAdapter onlineMerchantAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (onlineMerchantAdapter == null) {
            int i5 = MyBillsEntityDataFactory + 101;
            moveToNextValue = i5 % 128;
            int i6 = i5 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
            onlineMerchantAdapter = null;
            int i7 = MyBillsEntityDataFactory + 81;
            moveToNextValue = i7 % 128;
            int i8 = i7 % 2;
        }
        onlineMerchantAdapter.setItems(CollectionsKt.mutableListOf(new OnlineMerchantWrapper(2, new PaySearchInfoModel(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, false, false, 1048575, null))));
    }

    public final void setMerchantListItem(List<PaySearchInfoModel> merchantList) {
        RecyclerView recyclerView;
        int i;
        try {
            int i2 = MyBillsEntityDataFactory + 9;
            try {
                moveToNextValue = i2 % 128;
                int i3 = i2 % 2;
                Intrinsics.checkNotNullParameter(merchantList, "");
                if (merchantList.isEmpty()) {
                    int i4 = moveToNextValue + 93;
                    MyBillsEntityDataFactory = i4 % 128;
                    if (i4 % 2 != 0) {
                        recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
                        i = 86;
                    } else {
                        recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
                        i = 8;
                    }
                    recyclerView.setVisibility(i);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = merchantList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new OnlineMerchantWrapper(1, (PaySearchInfoModel) it.next()));
                }
                OnlineMerchantAdapter onlineMerchantAdapter = this.BuiltInFictitiousFunctionClassFactory;
                Object obj = null;
                if (!(onlineMerchantAdapter != null)) {
                    int i5 = MyBillsEntityDataFactory + 91;
                    moveToNextValue = i5 % 128;
                    int i6 = i5 % 2;
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int i7 = MyBillsEntityDataFactory + 67;
                    moveToNextValue = i7 % 128;
                    int i8 = i7 % 2;
                    onlineMerchantAdapter = null;
                }
                onlineMerchantAdapter.setItems(arrayList);
                int i9 = MyBillsEntityDataFactory + 37;
                moveToNextValue = i9 % 128;
                if ((i9 % 2 == 0 ? 'B' : (char) 17) != 17) {
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        if ((r0 == null ? 'Y' : 'A') != 'A') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002f, code lost:
    
        if ((r0 == null ? 4 : '\t') != '\t') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0031, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r4 = this;
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L4d
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1     // Catch: java.lang.Exception -> L4d
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r1 = 0
            if (r0 == 0) goto L25
            id.dana.onlinemerchant.adapter.OnlineMerchantAdapter r0 = r4.BuiltInFictitiousFunctionClassFactory
            r1.hashCode()     // Catch: java.lang.Throwable -> L23
            r2 = 65
            if (r0 != 0) goto L1e
            r3 = 89
            goto L20
        L1e:
            r3 = 65
        L20:
            if (r3 == r2) goto L39
            goto L31
        L23:
            r0 = move-exception
            throw r0
        L25:
            id.dana.onlinemerchant.adapter.OnlineMerchantAdapter r0 = r4.BuiltInFictitiousFunctionClassFactory
            r2 = 9
            if (r0 != 0) goto L2d
            r3 = 4
            goto L2f
        L2d:
            r3 = 9
        L2f:
            if (r3 == r2) goto L39
        L31:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L37
            goto L3a
        L37:
            r0 = move-exception
            throw r0
        L39:
            r1 = r0
        L3a:
            id.dana.onlinemerchant.view.OnlineMerchantListView$$ExternalSyntheticLambda0 r0 = new id.dana.onlinemerchant.view.OnlineMerchantListView$$ExternalSyntheticLambda0
            r0.<init>()
            r1.setOnItemClickListener(r0)
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return
        L4d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.BuiltInFictitiousFunctionClassFactory():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if ((!r4.isKeyboardShown ? 'a' : 31) != 'a') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r4.isKeyboardShown == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r0 = r4.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r0 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue + 115;
        id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        r5 = r0.getItem(r5).MyBillsEntityDataFactory;
        r4.MyBillsEntityDataFactory(r5.NetworkUserEntityData$$ExternalSyntheticLambda7.get("REDIRECT_URL"));
        r4 = r4.onlineMerchantItemListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r4 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        r1 = 'B';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        r1 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        if (r1 == 'B') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r4.getAuthRequestContext(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        id.dana.utils.KeyboardHelper.BuiltInFictitiousFunctionClassFactory(r4);
        r4.isKeyboardShown = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void PlaceComponentResult(id.dana.onlinemerchant.view.OnlineMerchantListView r4, int r5) {
        /*
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            if (r0 != 0) goto L25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            boolean r0 = r4.isKeyboardShown
            r3 = 77
            int r3 = r3 / r1
            r3 = 97
            if (r0 != 0) goto L1e
            r0 = 97
            goto L20
        L1e:
            r0 = 31
        L20:
            if (r0 == r3) goto L2c
            goto L67
        L23:
            r4 = move-exception
            throw r4
        L25:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)     // Catch: java.lang.Exception -> L70
            boolean r0 = r4.isKeyboardShown     // Catch: java.lang.Exception -> L70
            if (r0 != 0) goto L67
        L2c:
            id.dana.onlinemerchant.adapter.OnlineMerchantAdapter r0 = r4.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L65
            if (r0 != 0) goto L3e
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = 0
        L3e:
            java.lang.Object r5 = r0.getItem(r5)
            id.dana.onlinemerchant.model.OnlineMerchantWrapper r5 = (id.dana.onlinemerchant.model.OnlineMerchantWrapper) r5
            id.dana.globalsearch.model.PaySearchInfoModel r5 = r5.MyBillsEntityDataFactory
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda7
            java.lang.String r1 = "REDIRECT_URL"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r4.MyBillsEntityDataFactory(r0)
            id.dana.onlinemerchant.view.OnlineMerchantListView$OnlineMerchantItemListener r4 = r4.onlineMerchantItemListener
            r0 = 66
            if (r4 == 0) goto L5c
            r1 = 66
            goto L5e
        L5c:
            r1 = 22
        L5e:
            if (r1 == r0) goto L61
            goto L6f
        L61:
            r4.getAuthRequestContext(r5)     // Catch: java.lang.Exception -> L70
            return
        L65:
            r4 = move-exception
            throw r4
        L67:
            r5 = r4
            android.view.View r5 = (android.view.View) r5
            id.dana.utils.KeyboardHelper.BuiltInFictitiousFunctionClassFactory(r5)
            r4.isKeyboardShown = r1
        L6f:
            return
        L70:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.PlaceComponentResult(id.dana.onlinemerchant.view.OnlineMerchantListView, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        if ((r7 == null) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue + 81;
        id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        if ((r0 % 2) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        if (r0 == true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) id.dana.extension.lang.StringExtKt.PlaceComponentResult(r7), (java.lang.CharSequence) id.dana.data.constant.DanaUrl.DEEPLINK_URL, false, 2, (java.lang.Object) null) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        if (r2 == true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) id.dana.extension.lang.StringExtKt.PlaceComponentResult(r7), (java.lang.CharSequence) id.dana.data.constant.DanaUrl.DEEPLINK_URL, true, 4, (java.lang.Object) null) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
    
        getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        r7 = id.dana.utils.UrlUtil.getAuthRequestContext(r7);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "");
        id.dana.danah5.DanaH5.startContainerFullUrl(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        r7 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue + 81;
        id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r7 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 0
            if (r0 == r3) goto L1a
            int r0 = r4.length     // Catch: java.lang.Throwable -> L18
            if (r7 == 0) goto L6c
            goto L22
        L18:
            r7 = move-exception
            throw r7
        L1a:
            if (r7 == 0) goto L1e
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == 0) goto L22
            goto L6c
        L22:
            int r0 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r0 = r0 + 81
            int r5 = r0 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r5
            int r0 = r0 % r1
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            java.lang.String r5 = "https://link.dana.id/"
            if (r0 == r3) goto L49
            java.lang.String r0 = id.dana.extension.lang.StringExtKt.PlaceComponentResult(r7)     // Catch: java.lang.Exception -> L47
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L47
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Exception -> L47
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r2, r1, r4)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L43
            goto L44
        L43:
            r2 = 1
        L44:
            if (r2 == r3) goto L60
            goto L58
        L47:
            r7 = move-exception
            throw r7
        L49:
            java.lang.String r0 = id.dana.extension.lang.StringExtKt.PlaceComponentResult(r7)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2 = 4
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r3, r2, r4)
            if (r0 == 0) goto L60
        L58:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r6.getReadLinkPropertiesPresenter()
            r0.MyBillsEntityDataFactory(r7)
            return
        L60:
            java.lang.String r7 = id.dana.utils.UrlUtil.getAuthRequestContext(r7)
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            id.dana.danah5.DanaH5.startContainerFullUrl(r7)
        L6c:
            int r7 = id.dana.onlinemerchant.view.OnlineMerchantListView.moveToNextValue
            int r7 = r7 + 81
            int r0 = r7 % 128
            id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory = r0
            int r7 = r7 % r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.view.OnlineMerchantListView.MyBillsEntityDataFactory(java.lang.String):void");
    }

    public final void appendMerchantListItem(List<PaySearchInfoModel> merchantList) {
        OnlineMerchantAdapter onlineMerchantAdapter;
        PaySearchInfoModel paySearchInfoModel;
        RecyclerView recyclerView;
        int i;
        Intrinsics.checkNotNullParameter(merchantList, "");
        if (merchantList.isEmpty()) {
            int i2 = moveToNextValue + 85;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 != 0 ? 'D' : 'H') != 'H') {
                recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
                i = 54;
            } else {
                recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ExcludeFromJacocoGeneratedReport);
                i = 8;
            }
            recyclerView.setVisibility(i);
            return;
        }
        try {
            Iterator<T> it = merchantList.iterator();
            while (true) {
                try {
                    onlineMerchantAdapter = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    int i3 = moveToNextValue + 29;
                    MyBillsEntityDataFactory = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        paySearchInfoModel = (PaySearchInfoModel) it.next();
                        OnlineMerchantAdapter onlineMerchantAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
                        if (onlineMerchantAdapter2 != null) {
                            onlineMerchantAdapter = onlineMerchantAdapter2;
                            int i4 = MyBillsEntityDataFactory + 89;
                            moveToNextValue = i4 % 128;
                            int i5 = i4 % 2;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        paySearchInfoModel = (PaySearchInfoModel) it.next();
                        OnlineMerchantAdapter onlineMerchantAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
                        int i6 = 7 / 0;
                        if (!(onlineMerchantAdapter3 == null)) {
                            onlineMerchantAdapter = onlineMerchantAdapter3;
                            int i42 = MyBillsEntityDataFactory + 89;
                            moveToNextValue = i42 % 128;
                            int i52 = i42 % 2;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    onlineMerchantAdapter.getItems().add(new OnlineMerchantWrapper(1, paySearchInfoModel));
                } catch (Exception e) {
                    throw e;
                }
            }
            OnlineMerchantAdapter onlineMerchantAdapter4 = this.BuiltInFictitiousFunctionClassFactory;
            if (onlineMerchantAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                onlineMerchantAdapter = onlineMerchantAdapter4;
            }
            onlineMerchantAdapter.notifyDataSetChanged();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void hideLargeSkeleton() {
        try {
            int i = MyBillsEntityDataFactory + 57;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            OnlineMerchantAdapter onlineMerchantAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if ((onlineMerchantAdapter == null ? 'a' : '?') != '?') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onlineMerchantAdapter = null;
                int i3 = MyBillsEntityDataFactory + 27;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
            }
            List<OnlineMerchantWrapper> items = onlineMerchantAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            CollectionsKt.removeAll((List) items, (Function1) new Function1<OnlineMerchantWrapper, Boolean>() { // from class: id.dana.onlinemerchant.adapter.OnlineMerchantAdapter$hideOnlineLoadingSkeleton$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(OnlineMerchantWrapper onlineMerchantWrapper) {
                    return Boolean.valueOf(onlineMerchantWrapper.getAuthRequestContext == 2);
                }
            });
            onlineMerchantAdapter.notifyDataSetChanged();
            int i5 = moveToNextValue + 37;
            MyBillsEntityDataFactory = i5 % 128;
            if ((i5 % 2 != 0 ? 'W' : 'a') != 'W') {
                return;
            }
            int i6 = 36 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                break;
            }
            int i2 = $10 + 45;
            $11 = i2 % 128;
            if ((i2 % 2 == 0 ? 'a' : (char) 3) != 3) {
                try {
                    jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L | BuiltInFictitiousFunctionClassFactory) & (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext + getonboardingscenario.MyBillsEntityDataFactory));
                    getonboardingscenario.getAuthRequestContext %= 1;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ BuiltInFictitiousFunctionClassFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                getonboardingscenario.getAuthRequestContext++;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i3 = $11 + 77;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 0 : '\f') == '\f') {
                objArr[0] = new String(cArr2);
                return;
            }
            int i5 = $10 + 87;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
    }
}
