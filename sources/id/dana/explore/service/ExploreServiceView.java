package id.dana.explore.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerExploreServiceComponent;
import id.dana.di.modules.ExploreServiceModule;
import id.dana.di.modules.OauthModule;
import id.dana.explore.adapter.ExploreServiceAdapter;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import id.dana.explore.service.ExploreServiceContract;
import id.dana.explore.utils.ExploreUtils;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.ThirdPartyService;
import id.dana.service.ServicesActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.C;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0004\b0\u00101J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\u0010\u001a\u00020'8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0010\u0010(R\u0016\u0010\u0012\u001a\u00020)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010*"}, d2 = {"Lid/dana/explore/service/ExploreServiceView;", "Lid/dana/base/BaseRichView;", "Lid/dana/explore/service/ExploreServiceContract$View;", "", "fetchData", "()V", "", "getLayout", "()I", "MyBillsEntityDataFactory", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/explore/domain/sku/model/ExploreServiceModel;)V", "BuiltInFictitiousFunctionClassFactory", "", "list", "onGetExploreService", "(Ljava/util/List;)V", "setup", "getAuthRequestContext", "Lid/dana/explore/service/ExploreServiceContract$Presenter;", "presenter", "Lid/dana/explore/service/ExploreServiceContract$Presenter;", "getPresenter", "()Lid/dana/explore/service/ExploreServiceContract$Presenter;", "setPresenter", "(Lid/dana/explore/service/ExploreServiceContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/explore/adapter/ExploreServiceAdapter;", "Lid/dana/explore/adapter/ExploreServiceAdapter;", "", "Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServiceView extends BaseRichView implements ExploreServiceContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 20355;
    private static char MyBillsEntityDataFactory = 1921;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char PlaceComponentResult = 49238;
    private static int getErrorConfigVersion = 0;
    private static char moveToNextValue = 17008;
    private ExploreServiceAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ExploreServiceContract.Presenter presenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;

    public static /* synthetic */ void $r8$lambda$8CETuKTUNN62foGYAjGPosc41PA(ExploreServiceAdapter exploreServiceAdapter, ExploreServiceView exploreServiceView, int i) {
        try {
            int i2 = getErrorConfigVersion + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                try {
                    PlaceComponentResult(exploreServiceAdapter, exploreServiceView, i);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            PlaceComponentResult(exploreServiceAdapter, exploreServiceView, i);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$L8kdwseJva0p_SEZdMcFM_01GqU(ExploreServiceView exploreServiceView, View view) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
        getErrorConfigVersion = i % 128;
        if ((i % 2 != 0 ? (char) 19 : (char) 22) == 19) {
            PlaceComponentResult(exploreServiceView);
            int i2 = 71 / 0;
            return;
        }
        try {
            PlaceComponentResult(exploreServiceView);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreServiceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreServiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        int i = getErrorConfigVersion + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 15 : '7') != '7') {
            this._$_findViewCache.clear();
            int length = objArr.length;
        } else {
            try {
                this._$_findViewCache.clear();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getErrorConfigVersion + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        objArr.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if ((r1 != null ? '!' : 'M') != 'M') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r6 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion + 7;
        id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            android.view.View r1 = (android.view.View) r1
            r2 = 78
            if (r1 != 0) goto L13
            r3 = 86
            goto L15
        L13:
            r3 = 78
        L15:
            r4 = 0
            if (r3 == r2) goto L52
            int r1 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion
            int r1 = r1 + 111
            int r2 = r1 % 128
            id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L2e
            android.view.View r1 = r5.findViewById(r6)
            int r2 = r4.length     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L47
            goto L3d
        L2c:
            r6 = move-exception
            throw r6
        L2e:
            android.view.View r1 = r5.findViewById(r6)
            r2 = 77
            if (r1 == 0) goto L39
            r3 = 33
            goto L3b
        L39:
            r3 = 77
        L3b:
            if (r3 == r2) goto L47
        L3d:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L45
            r0.put(r6, r1)     // Catch: java.lang.Exception -> L45
            goto L52
        L45:
            r6 = move-exception
            throw r6
        L47:
            int r6 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion
            int r6 = r6 + 7
            int r0 = r6 % 128
            id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r6 = r6 % 2
            r1 = r4
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        try {
            int i = getErrorConfigVersion + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            boolean z = i % 2 != 0;
            AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        int i = getErrorConfigVersion + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
        try {
            int i3 = getErrorConfigVersion + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        int i3 = getErrorConfigVersion + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.view_explore_service;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 77;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 == 0;
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
        if (z) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            AbstractContractKt.AbstractView.CC.PlaceComponentResult();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreServiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ExploreServiceView(android.content.Context r3, android.util.AttributeSet r4, int r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 2
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L8
            r7 = 1
            goto L9
        L8:
            r7 = 0
        L9:
            if (r7 == 0) goto L2c
            int r4 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion
            int r4 = r4 + 35
            int r7 = r4 % 128
            id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r7
            int r4 = r4 % 2
            if (r4 != 0) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L21
            r4 = 42
            int r4 = r4 / r1
            goto L21
        L1f:
            r3 = move-exception
            throw r3
        L21:
            r4 = 0
            int r7 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 + 49
            int r0 = r7 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r0
            int r7 = r7 % 2
        L2c:
            r6 = r6 & 4
            if (r6 == 0) goto L31
            r5 = 0
        L31:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getReadDeepLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadDeepLinkPropertiesPresenter() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        ReadLinkPropertiesContract.Presenter presenter = this.readDeepLinkPropertiesPresenter;
        Object obj = null;
        if (!(presenter != null)) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getErrorConfigVersion + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? '*' : 'J') != '*') {
            return presenter;
        }
        obj.hashCode();
        return presenter;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x0030
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @kotlin.jvm.JvmName(name = "setReadDeepLinkPropertiesPresenter")
    public final void setReadDeepLinkPropertiesPresenter(id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter r3) {
        /*
            r2 = this;
            int r0 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L2e
            r2.readDeepLinkPropertiesPresenter = r3     // Catch: java.lang.Exception -> L2e
            int r3 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L2e
            int r3 = r3 + 55
            int r0 = r3 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r0     // Catch: java.lang.Exception -> L2e
            int r3 = r3 % 2
            r0 = 88
            if (r3 == 0) goto L22
            r3 = 88
            goto L24
        L22:
            r3 = 11
        L24:
            if (r3 == r0) goto L27
            return
        L27:
            r3 = 84
            int r3 = r3 / 0
            return
        L2c:
            r3 = move-exception
            throw r3
        L2e:
            r3 = move-exception
            throw r3
        L30:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.setReadDeepLinkPropertiesPresenter(id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter):void");
    }

    @JvmName(name = "getPresenter")
    public final ExploreServiceContract.Presenter getPresenter() {
        ExploreServiceContract.Presenter presenter = this.presenter;
        Object[] objArr = null;
        if ((presenter != null ? 'L' : ':') == ':') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            return null;
        }
        try {
            int i3 = getErrorConfigVersion + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return presenter;
            }
            int length = objArr.length;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ExploreServiceContract.Presenter presenter) {
        int i = getErrorConfigVersion + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
            try {
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
            getErrorConfigVersion = i % 128;
            if ((i % 2 != 0 ? (char) 15 : 'b') != 15) {
                MyBillsEntityDataFactory();
                getAuthRequestContext();
                KClassImpl$Data$declaredNonStaticMembers$2();
                getPresenter().BuiltInFictitiousFunctionClassFactory();
                return;
            }
            MyBillsEntityDataFactory();
            getAuthRequestContext();
            KClassImpl$Data$declaredNonStaticMembers$2();
            getPresenter().BuiltInFictitiousFunctionClassFactory();
            int i2 = 73 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r0.setOnClickListener(new id.dana.explore.service.ExploreServiceView$$ExternalSyntheticLambda0(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r0 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r3 = this;
            int r0 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 49
            if (r0 == 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 30
        L13:
            r2 = 0
            if (r0 == r1) goto L21
            int r0 = id.dana.R.id.tv_all_service
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L36
            goto L2e
        L21:
            int r0 = id.dana.R.id.tv_all_service
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.hashCode()     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L36
        L2e:
            id.dana.explore.service.ExploreServiceView$$ExternalSyntheticLambda0 r1 = new id.dana.explore.service.ExploreServiceView$$ExternalSyntheticLambda0
            r1.<init>()
            r0.setOnClickListener(r1)
        L36:
            int r0 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 43
            if (r0 == 0) goto L47
            r0 = 43
            goto L49
        L47:
            r0 = 25
        L49:
            if (r0 == r1) goto L4c
            return
        L4c:
            int r0 = r2.length     // Catch: java.lang.Throwable -> L4e
            return
        L4e:
            r0 = move-exception
            throw r0
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    private static final void PlaceComponentResult(ExploreServiceView exploreServiceView) {
        Intrinsics.checkNotNullParameter(exploreServiceView, "");
        exploreServiceView.getContext().startActivity(new Intent(exploreServiceView.getContext(), ServicesActivity.class));
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 111;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void getAuthRequestContext() {
        int i = getErrorConfigVersion + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 != 0 ? Build.VERSION.SDK_INT < 28 : Build.VERSION.SDK_INT < 121) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_explore_service_container);
            if ((constraintLayout != null ? ')' : 'U') != 'U') {
                ViewExtKt.PlaceComponentResult(constraintLayout, 4.0f);
            }
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_explore_service_container);
            if ((constraintLayout2 != null ? (char) 19 : (char) 6) == 19) {
                int i2 = getErrorConfigVersion + 85;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                if (i2 % 2 != 0) {
                    constraintLayout2.setElevation(constraintLayout2.getResources().getDimension(R.dimen.f28052131165274));
                    constraintLayout2.setOutlineAmbientShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout2.getContext(), R.color.f25472131100154));
                    constraintLayout2.setOutlineSpotShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout2.getContext(), R.color.f25472131100154));
                    return;
                }
                constraintLayout2.setElevation(constraintLayout2.getResources().getDimension(R.dimen.f28052131165274));
                constraintLayout2.setOutlineAmbientShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout2.getContext(), R.color.f25472131100154));
                constraintLayout2.setOutlineSpotShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout2.getContext(), R.color.f25472131100154));
                Object[] objArr = null;
                int length = objArr.length;
                return;
            }
        }
        int i3 = getErrorConfigVersion + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 21 / 0;
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerExploreServiceComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerExploreServiceComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getBaseActivity();
        Object[] objArr = new Object[1];
        a(8 - TextUtils.indexOf("", ""), new char[]{12788, 51975, 34560, 48664, 51501, 47952, 47054, 6382}, objArr);
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.explore.service.ExploreServiceView$injectComponent$1
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
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ExploreServiceModule) Preconditions.getAuthRequestContext(new ExploreServiceModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, OauthModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = new ServicesModule();
            int i = getErrorConfigVersion + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ExploreServiceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerExploreServiceComponent.ExploreServiceComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getPresenter(), getReadDeepLinkPropertiesPresenter());
    }

    private final void MyBillsEntityDataFactory() {
        final ExploreServiceAdapter exploreServiceAdapter = new ExploreServiceAdapter();
        exploreServiceAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.explore.service.ExploreServiceView$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ExploreServiceView.$r8$lambda$8CETuKTUNN62foGYAjGPosc41PA(ExploreServiceAdapter.this, this, i);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = exploreServiceAdapter;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1193_access_openbottomsheetonboardingviewlist);
        ExploreServiceAdapter exploreServiceAdapter2 = null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            ExploreServiceAdapter exploreServiceAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (exploreServiceAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                exploreServiceAdapter3 = null;
            }
            try {
                try {
                    recyclerView.setAdapter(exploreServiceAdapter3);
                    int i = getErrorConfigVersion + 121;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ExploreServiceAdapter exploreServiceAdapter4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (exploreServiceAdapter4 == null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                exploreServiceAdapter2.hashCode();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
        } else {
            exploreServiceAdapter2 = exploreServiceAdapter4;
        }
        exploreServiceAdapter2.getAuthRequestContext();
    }

    private static final void PlaceComponentResult(ExploreServiceAdapter exploreServiceAdapter, ExploreServiceView exploreServiceView, int i) {
        try {
            int i2 = getErrorConfigVersion + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            Intrinsics.checkNotNullParameter(exploreServiceAdapter, "");
            Intrinsics.checkNotNullParameter(exploreServiceView, "");
            Object[] objArr = null;
            if ((exploreServiceAdapter.getItem(i).BuiltInFictitiousFunctionClassFactory.isEnable() ? 'E' : '=') != 'E') {
                KClassImpl$Data$declaredNonStaticMembers$2(exploreServiceAdapter.getItem(i).BuiltInFictitiousFunctionClassFactory);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
                getErrorConfigVersion = i4 % 128;
                if ((i4 % 2 != 0 ? 'b' : '6') != 'b') {
                    return;
                }
                objArr.hashCode();
                return;
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
            getErrorConfigVersion = i5 % 128;
            if (!(i5 % 2 == 0)) {
                exploreServiceView.BuiltInFictitiousFunctionClassFactory(exploreServiceAdapter.getItem(i).BuiltInFictitiousFunctionClassFactory);
                int length = objArr.length;
            } else {
                exploreServiceView.BuiltInFictitiousFunctionClassFactory(exploreServiceAdapter.getItem(i).BuiltInFictitiousFunctionClassFactory);
            }
            int i6 = getErrorConfigVersion + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
            if (i6 % 2 == 0) {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(ExploreServiceModel p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 == 0)) {
            ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter = getReadDeepLinkPropertiesPresenter();
            ExploreUtils exploreUtils = ExploreUtils.INSTANCE;
            readDeepLinkPropertiesPresenter.MyBillsEntityDataFactory(ExploreUtils.getAuthRequestContext(p0.getKey()));
            int i2 = 4 / 0;
        } else {
            try {
                ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter2 = getReadDeepLinkPropertiesPresenter();
                ExploreUtils exploreUtils2 = ExploreUtils.INSTANCE;
                readDeepLinkPropertiesPresenter2.MyBillsEntityDataFactory(ExploreUtils.getAuthRequestContext(p0.getKey()));
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getErrorConfigVersion + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? '!' : '\\') != '!') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r3 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        if ((r3 != null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        r3 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r3 % 128;
        r3 = r3 % 2;
        r3 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.domain.sku.model.ExploreServiceModel r3) {
        /*
            int r0 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L3b
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L3b
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1e
            java.lang.String r3 = r3.getName()
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1c
            if (r3 != 0) goto L35
            goto L29
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L39
            if (r3 != 0) goto L25
            goto L26
        L25:
            r1 = 1
        L26:
            if (r1 == 0) goto L29
            goto L35
        L29:
            int r3 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r3 = r3 + 13
            int r0 = r3 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r0
            int r3 = r3 % 2
            java.lang.String r3 = ""
        L35:
            id.dana.service.ServiceMaintenanceUtil.getAuthRequestContext(r3)
            return
        L39:
            r3 = move-exception
            throw r3
        L3b:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.domain.sku.model.ExploreServiceModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
    
        if (r6 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
    
        if ((r6 < 0 ? 'I' : '`') != '`') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
    
        kotlin.collections.CollectionsKt.throwIndexOverflow();
     */
    @Override // id.dana.explore.service.ExploreServiceContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onGetExploreService(java.util.List<id.dana.explore.domain.sku.model.ExploreServiceModel> r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.onGetExploreService(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if ((r0 == null ? 'B' : 'T') != 'T') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if ((r0 == null ? 11 : 20) != 20) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void fetchData() {
        /*
            r3 = this;
            int r0 = id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L56
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L56
            int r0 = r0 % 2
            boolean r0 = r3.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L55
            int r0 = id.dana.explore.service.ExploreServiceView.getErrorConfigVersion     // Catch: java.lang.Exception -> L53
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.explore.service.ExploreServiceView.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L53
            int r0 = r0 % 2
            if (r0 != 0) goto L2e
            id.dana.explore.adapter.ExploreServiceAdapter r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 52
            int r1 = r1 / 0
            r1 = 84
            if (r0 != 0) goto L27
            r2 = 66
            goto L29
        L27:
            r2 = 84
        L29:
            if (r2 == r1) goto L41
            goto L3b
        L2c:
            r0 = move-exception
            throw r0
        L2e:
            id.dana.explore.adapter.ExploreServiceAdapter r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 20
            if (r0 != 0) goto L37
            r2 = 11
            goto L39
        L37:
            r2 = 20
        L39:
            if (r2 == r1) goto L41
        L3b:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L41:
            java.util.List r1 = r0.getItems()
            r1.clear()
            r0.getAuthRequestContext()
            id.dana.explore.service.ExploreServiceContract$Presenter r0 = r3.getPresenter()
            r0.BuiltInFictitiousFunctionClassFactory()
            goto L55
        L53:
            r0 = move-exception
            throw r0
        L55:
            return
        L56:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.service.ExploreServiceView.fetchData():void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $10 + 85;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                int i4 = $10 + 81;
                $11 = i4 % 128;
                int i5 = 58224;
                if (i4 % 2 != 0) {
                    cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                    cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                } else {
                    cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                    cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory / 1];
                }
                for (int i6 = 0; i6 < 16; i6++) {
                    int i7 = $10 + 23;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i5) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i5) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                    i5 -= 40503;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
