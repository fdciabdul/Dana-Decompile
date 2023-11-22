package id.dana.contract.deeplink.path;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.gson.Gson;
import dagger.Lazy;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.listener.DeeplinkFeatureListener;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckDeepLinkActionVisibility;
import id.dana.domain.featureconfig.interactor.CheckWhitelistedValidDomain;
import id.dana.domain.featureconfig.model.DeepLinkFeatureSwitchModel;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.version.interactor.GetUpdateAvailability;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.ipg.constant.IpgConstant;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.model.ThirdPartyService;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.UrlUtil;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.Typography;
import o.D;

@PerActivity
/* loaded from: classes4.dex */
public class FeaturePresenter implements FeatureContract.Presenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static long initRecordTimeStamp = -4474363723754011455L;
    private final Lazy<FeatureServicesHandler> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<FeatureContract.View> DatabaseTableConfigUtil;
    private final Lazy<CheckWhitelistedValidDomain> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<GetFeedConfig> MyBillsEntityDataFactory;
    private final Lazy<PushVerifyTracker> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<CheckDeepLinkActionVisibility> PlaceComponentResult;
    private final Lazy<CheckMyBillsVersionConfig> getAuthRequestContext;
    private final Lazy<GetUpdateAvailability> getErrorConfigVersion;
    private final Lazy<GetService> lookAheadTest;
    private final Lazy<GetPromoCenterVersion> moveToNextValue;
    private final Lazy<GetNearbyConfig> scheduleImpl;

    static /* synthetic */ Lazy PlaceComponentResult(FeaturePresenter featurePresenter) {
        Lazy<FeatureContract.View> lazy;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? (char) 30 : '3') != 30) {
            try {
                lazy = featurePresenter.DatabaseTableConfigUtil;
            } catch (Exception e) {
                throw e;
            }
        } else {
            lazy = featurePresenter.DatabaseTableConfigUtil;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if ((i2 % 2 == 0 ? JSONLexer.EOI : (char) 3) != 26) {
            return lazy;
        }
        obj.hashCode();
        return lazy;
    }

    static /* synthetic */ void PlaceComponentResult(FeaturePresenter featurePresenter, String str, Map map, String str2, boolean z, boolean z2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        featurePresenter.BuiltInFictitiousFunctionClassFactory(str, map, str2, z, z2);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 27 : '_') != 27) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Inject
    public FeaturePresenter(Lazy<FeatureContract.View> lazy, Lazy<FeatureServicesHandler> lazy2, Lazy<CheckDeepLinkActionVisibility> lazy3, Lazy<CheckWhitelistedValidDomain> lazy4, Lazy<GetNearbyConfig> lazy5, Lazy<GetFeedConfig> lazy6, Lazy<GetPromoCenterVersion> lazy7, Lazy<GetUpdateAvailability> lazy8, Lazy<CheckMyBillsVersionConfig> lazy9, Lazy<PushVerifyTracker> lazy10, Lazy<GetService> lazy11) {
        try {
            this.DatabaseTableConfigUtil = lazy;
            this.BuiltInFictitiousFunctionClassFactory = lazy2;
            this.PlaceComponentResult = lazy3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
            this.scheduleImpl = lazy5;
            this.MyBillsEntityDataFactory = lazy6;
            this.moveToNextValue = lazy7;
            this.getErrorConfigVersion = lazy8;
            this.getAuthRequestContext = lazy9;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy10;
            this.lookAheadTest = lazy11;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01db  */
    @Override // id.dana.contract.deeplink.path.FeatureContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.getAuthRequestContext(java.lang.String, java.util.Map, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x005a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r3) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r3.hashCode()     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = "promoquest"
            boolean r0 = r3.equals(r0)     // Catch: java.lang.Exception -> L79
            r1 = 44
            if (r0 != 0) goto L1a
            r0 = 26
            goto L1c
        L1a:
            r0 = 44
        L1c:
            r2 = 0
            if (r0 == r1) goto L5f
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L79
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "danapoly"
            boolean r3 = r3.equals(r1)
            if (r0 == 0) goto L42
            r2.hashCode()     // Catch: java.lang.Throwable -> L40
            r0 = 63
            if (r3 != 0) goto L3b
            r3 = 63
            goto L3d
        L3b:
            r3 = 90
        L3d:
            if (r3 == r0) goto L4d
            goto L5c
        L40:
            r3 = move-exception
            throw r3
        L42:
            r0 = 87
            if (r3 != 0) goto L49
            r3 = 80
            goto L4b
        L49:
            r3 = 87
        L4b:
            if (r3 == r0) goto L5c
        L4d:
            int r3 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r3 = r3 + 51
            int r0 = r3 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0
            int r3 = r3 % 2
            java.lang.String r3 = ""
            return r3
        L5a:
            r3 = move-exception
            throw r3
        L5c:
            java.lang.String r3 = "service_danapoly"
            return r3
        L5f:
            java.lang.String r3 = "service_promo_quest"
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L6f
            r0 = 1
            goto L70
        L6f:
            r0 = 0
        L70:
            if (r0 == 0) goto L78
            r2.hashCode()     // Catch: java.lang.Throwable -> L76
            return r3
        L76:
            r3 = move-exception
            throw r3
        L78:
            return r3
        L79:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):java.lang.String");
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.Presenter
    public final void getAuthRequestContext(DeeplinkFeatureListener deeplinkFeatureListener) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            try {
                this.DatabaseTableConfigUtil.get().PlaceComponentResult(deeplinkFeatureListener);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.Presenter
    public final void PlaceComponentResult(final String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(UrlUtil.NetworkUserEntityData$$ExternalSyntheticLambda0(str), new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(str, (Boolean) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 != 0 ? 'Q' : 'N') != 'Q') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r4 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ kotlin.Unit KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r3, java.lang.Boolean r4) {
        /*
            r2 = this;
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 71
            if (r0 != 0) goto L11
            r0 = 71
            goto L13
        L11:
            r0 = 63
        L13:
            if (r0 == r1) goto L27
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> L25
            r0 = 16
            if (r4 == 0) goto L20
            r4 = 13
            goto L22
        L20:
            r4 = 16
        L22:
            if (r4 == r0) goto L5a
            goto L31
        L25:
            r3 = move-exception
            goto L61
        L27:
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> L25
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L5f
            if (r4 == 0) goto L5a
        L31:
            int r4 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L5d
            int r4 = r4 + 55
            int r0 = r4 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0     // Catch: java.lang.Exception -> L5d
            int r4 = r4 % 2
            if (r4 != 0) goto L4f
            dagger.Lazy<id.dana.contract.deeplink.path.FeatureContract$View> r4 = r2.DatabaseTableConfigUtil
            java.lang.Object r4 = r4.get()
            id.dana.contract.deeplink.path.FeatureContract$View r4 = (id.dana.contract.deeplink.path.FeatureContract.View) r4
            r4.PlaceComponentResult(r3)
            r3 = 29
            int r3 = r3 / 0
            goto L5a
        L4d:
            r3 = move-exception
            throw r3
        L4f:
            dagger.Lazy<id.dana.contract.deeplink.path.FeatureContract$View> r4 = r2.DatabaseTableConfigUtil
            java.lang.Object r4 = r4.get()
            id.dana.contract.deeplink.path.FeatureContract$View r4 = (id.dana.contract.deeplink.path.FeatureContract.View) r4
            r4.PlaceComponentResult(r3)
        L5a:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L5d
            return r3
        L5d:
            r3 = move-exception
            throw r3
        L5f:
            r3 = move-exception
            throw r3
        L61:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.Boolean):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        DanaLog.BuiltInFictitiousFunctionClassFactory("FeaturePresenter", "Fail to get whitelisted domain", th);
        Unit unit = Unit.INSTANCE;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return unit;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map) {
        FeatureContract.View view;
        boolean z;
        boolean z2;
        boolean z3;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? '`' : ':') != ':') {
            view = this.DatabaseTableConfigUtil.get();
            z = false;
            z2 = true;
            z3 = true;
        } else {
            view = this.DatabaseTableConfigUtil.get();
            z = true;
            z2 = true;
            z3 = false;
        }
        view.MyBillsEntityDataFactory("profile", map, "", z, z2, z3);
    }

    private void lookAheadTest(Map<String, String> map) {
        FeatureContract.View view;
        boolean z;
        boolean z2;
        boolean z3;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 != 0 ? 'T' : (char) 3) != 'T') {
            view = this.DatabaseTableConfigUtil.get();
            z = true;
            z2 = true;
            z3 = false;
        } else {
            view = this.DatabaseTableConfigUtil.get();
            z = false;
            z2 = false;
            z3 = true;
        }
        view.MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.QR_BIND, map, "", z, z2, z3);
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if ((i2 % 2 == 0 ? '2' : 'G') != '2') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void MyBillsEntityDataFactory(Map<String, String> map) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (!(i % 2 == 0)) {
                try {
                    this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.KYBPAGE, map, "", false, true, true);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.KYBPAGE, map, "", true, true, false);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void getAuthRequestContext(Map<String, String> map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.KYB_TRANSACTION_LIST, map, "", true, true, false);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, Map<String, String> map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, false, false);
            return;
        }
        try {
            try {
                this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, true, false);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(final String str, final Map<String, String> map) {
        CheckMyBillsVersionConfig checkMyBillsVersionConfig = this.getAuthRequestContext.get();
        Object[] objArr = new Object[1];
        a((KeyEvent.getMaxKeyCode() >> 16) + 1, new char[]{62618, 62716, 50146, 2734, 10645, 48038, 41665, 53323, 63950, 59153, 3381, 31118, 48575, 6310, 24670, 23908, 39194, 15831, 48107}, objArr);
        checkMyBillsVersionConfig.execute(((String) objArr[0]).intern(), new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(map, str, (HashMap) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return FeaturePresenter.this.MyBillsEntityDataFactory(str, map);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Map map, String str, HashMap hashMap) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            String obj = Objects.requireNonNull(hashMap.get("enable")).toString();
            map.put("version", Objects.requireNonNull(hashMap.get("version")).toString());
            this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, Objects.equals(obj, SummaryActivity.CHECKED), false);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception unused) {
            this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, false, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit MyBillsEntityDataFactory(String str, Map map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (i % 2 != 0) {
        }
        this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, false, false);
        Unit unit = Unit.INSTANCE;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
        if ((i2 % 2 != 0 ? 'H' : InputCardNumberView.DIVIDER) != 'H') {
            return unit;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return unit;
    }

    private void PlaceComponentResult(Map<String, String> map) {
        String str;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Gson PlaceComponentResult = JSONExtKt.PlaceComponentResult();
        IpgConstant ipgConstant = IpgConstant.INSTANCE;
        str = IpgConstant.getAuthRequestContext;
        this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.IPGREGISTRATION, (Map) PlaceComponentResult.fromJson(map.get(str), Map.class), "", false, true, false);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'b' : '8') != 'b') {
            return;
        }
        int i4 = 11 / 0;
    }

    private void moveToNextValue(Map<String, String> map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(BranchLinkConstant.ActionTarget.PROFILE_QRIS_ALERT, map, "", true, true, false);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private void BuiltInFictitiousFunctionClassFactory(final String str, final Map<String, String> map, final String str2, final boolean z, final boolean z2) {
        this.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.BuiltInFictitiousFunctionClassFactory(str, map, str2, z, z2, (Integer) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(str, map, str2, z, z2);
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ kotlin.Unit BuiltInFictitiousFunctionClassFactory(java.lang.String r10, java.util.Map r11, java.lang.String r12, boolean r13, boolean r14, java.lang.Integer r15) {
        /*
            r9 = this;
            dagger.Lazy<id.dana.contract.deeplink.path.FeatureContract$View> r0 = r9.DatabaseTableConfigUtil     // Catch: java.lang.Exception -> L50
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L50
            r1 = r0
            id.dana.contract.deeplink.path.FeatureContract$View r1 = (id.dana.contract.deeplink.path.FeatureContract.View) r1     // Catch: java.lang.Exception -> L4e
            int r15 = r15.intValue()
            r0 = 52
            r8 = 2
            if (r8 != r15) goto L15
            r15 = 72
            goto L17
        L15:
            r15 = 52
        L17:
            r2 = 0
            if (r15 == r0) goto L29
            int r15 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r15 = r15 + 13
            int r0 = r15 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r15 = r15 % r8
            if (r15 != 0) goto L26
            goto L29
        L26:
            r15 = 1
            r7 = 1
            goto L2a
        L29:
            r7 = 0
        L2a:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.MyBillsEntityDataFactory(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            int r11 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L4e
            int r11 = r11 + 41
            int r12 = r11 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r12     // Catch: java.lang.Exception -> L4e
            int r11 = r11 % r8
            r12 = 38
            if (r11 != 0) goto L44
            r11 = 54
            goto L46
        L44:
            r11 = 38
        L46:
            if (r11 == r12) goto L4d
            r11 = 0
            int r11 = r11.length     // Catch: java.lang.Throwable -> L4b
            return r10
        L4b:
            r10 = move-exception
            throw r10
        L4d:
            return r10
        L4e:
            r10 = move-exception
            throw r10
        L50:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.util.Map, java.lang.String, boolean, boolean, java.lang.Integer):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(String str, Map map, String str2, boolean z, boolean z2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
        }
        this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, str2, z, z2, false);
        return Unit.INSTANCE;
    }

    private void BuiltInFictitiousFunctionClassFactory(final String str, final Map<String, String> map, final String str2) {
        this.PlaceComponentResult.get().execute(new DefaultObserver<DeepLinkFeatureSwitchModel>() { // from class: id.dana.contract.deeplink.path.FeaturePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                DeepLinkFeatureSwitchModel deepLinkFeatureSwitchModel = (DeepLinkFeatureSwitchModel) obj;
                if (deepLinkFeatureSwitchModel.isFeatureNonAmcs()) {
                    FeaturePresenter.PlaceComponentResult(FeaturePresenter.this, str, map, str2, true, true);
                    ((FeatureContract.View) FeaturePresenter.PlaceComponentResult(FeaturePresenter.this).get()).MyBillsEntityDataFactory(true);
                    return;
                }
                FeaturePresenter.PlaceComponentResult(FeaturePresenter.this, str, map, str2, false, deepLinkFeatureSwitchModel.isFeatureActive());
                ((FeatureContract.View) FeaturePresenter.PlaceComponentResult(FeaturePresenter.this).get()).MyBillsEntityDataFactory(deepLinkFeatureSwitchModel.isFeatureActive());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((FeatureContract.View) FeaturePresenter.PlaceComponentResult(FeaturePresenter.this).get()).MyBillsEntityDataFactory(true);
                ((FeatureContract.View) FeaturePresenter.PlaceComponentResult(FeaturePresenter.this).get()).dismissProgress();
                super.onError(th);
            }
        }, CheckDeepLinkActionVisibility.Params.forAction(str));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 != 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void MyBillsEntityDataFactory(final String str, final Map<String, String> map, final String str2) {
        this.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.PlaceComponentResult(map, str, str2, (NearbyConfig) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(map, str, str2);
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 121;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if (!(i % 2 == 0)) {
                    int i2 = 4 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit PlaceComponentResult(Map map, String str, String str2, NearbyConfig nearbyConfig) {
        map.put(FeatureParams.NEARBY_REVAMP, Boolean.toString(nearbyConfig.getNearbyRevamp()));
        if (nearbyConfig.getNearbyRevamp()) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 3;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(str), map, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Map map, String str, String str2) {
        Unit unit;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if ((i % 2 == 0 ? 'F' : (char) 27) != 'F') {
                try {
                    map.put(FeatureParams.NEARBY_REVAMP, Boolean.FALSE.toString());
                    BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(str), map, str2);
                    unit = Unit.INSTANCE;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                map.put(FeatureParams.NEARBY_REVAMP, Boolean.FALSE.toString());
                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(str), map, str2);
                unit = Unit.INSTANCE;
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            int i3 = i2 % 2;
            return unit;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void PlaceComponentResult(final String str, final Map<String, String> map, final String str2) {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.BuiltInFictitiousFunctionClassFactory(map, str, str2, (FeedConfig) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return FeaturePresenter.this.getAuthRequestContext(map, str, str2);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Map map, String str, String str2, FeedConfig feedConfig) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            map.put(FeatureParams.FEED_MAINTENANCE, Boolean.toString(feedConfig.isMaintenance()));
            map.put(FeatureParams.FEED_ENABLED, Boolean.toString(feedConfig.isFeedEnabled()));
            map.put("feed_revamp", KClassImpl$Data$declaredNonStaticMembers$2(feedConfig.getFeedVersion()));
            map.put(FeatureParams.FEED_REPLY_COMMENT_ENABLED, Boolean.toString(feedConfig.isReplyCommentEnabled()));
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            Unit unit = Unit.INSTANCE;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit getAuthRequestContext(Map map, String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        map.put(FeatureParams.FEED_MAINTENANCE, Boolean.FALSE.toString());
        map.put(FeatureParams.FEED_ENABLED, Boolean.FALSE.toString());
        map.put("feed_revamp", Boolean.FALSE.toString());
        map.put(FeatureParams.FEED_REPLY_COMMENT_ENABLED, Boolean.FALSE.toString());
        BuiltInFictitiousFunctionClassFactory(str, map, str2);
        Unit unit = Unit.INSTANCE;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
        return unit;
    }

    private void PlaceComponentResult(String str, final String str2, final Map<String, String> map, final String str3) {
        this.lookAheadTest.get().execute(str, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(map, str2, str3, (ThirdPartyServiceResponse) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return FeaturePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(str2, map, str3);
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Map map, String str, String str2, ThirdPartyServiceResponse thirdPartyServiceResponse) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? 'H' : (char) 25) != 'H') {
            map.put("service_status", PlaceComponentResult(thirdPartyServiceResponse));
            map.put("service_link", thirdPartyServiceResponse.getLink());
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            return Unit.INSTANCE;
        }
        try {
            map.put("service_status", PlaceComponentResult(thirdPartyServiceResponse));
            map.put("service_link", thirdPartyServiceResponse.getLink());
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            Unit unit = Unit.INSTANCE;
            Object[] objArr = null;
            int length = objArr.length;
            return unit;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(String str, Map map, String str2) {
        Unit unit;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 45;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 == 0 ? (char) 29 : (char) 16) != 16) {
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            try {
                unit = Unit.INSTANCE;
                int i2 = 30 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory(str, map, str2);
            unit = Unit.INSTANCE;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.dollar : (char) 3) != '$') {
            return unit;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return unit;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x0055
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String PlaceComponentResult(id.dana.domain.homeinfo.ThirdPartyServiceResponse r3) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            boolean r0 = r3.isEnable()     // Catch: java.lang.Exception -> L57
            r1 = 96
            if (r0 == 0) goto L15
            r0 = 59
            goto L17
        L15:
            r0 = 96
        L17:
            if (r0 == r1) goto L1c
            java.lang.String r3 = "enabled"
            return r3
        L1c:
            boolean r0 = r3.isEnable()
            if (r0 != 0) goto L52
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r1 = 79
            if (r0 == 0) goto L33
            r0 = 73
            goto L35
        L33:
            r0 = 79
        L35:
            r2 = 0
            if (r0 == r1) goto L44
            java.lang.String r3 = r3.getLink()     // Catch: java.lang.Exception -> L57
            r0 = 62
            int r0 = r0 / r2
            if (r3 == 0) goto L52
            goto L4f
        L42:
            r3 = move-exception
            throw r3
        L44:
            java.lang.String r3 = r3.getLink()
            r0 = 1
            if (r3 == 0) goto L4c
            goto L4d
        L4c:
            r2 = 1
        L4d:
            if (r2 == r0) goto L52
        L4f:
            java.lang.String r3 = "maintenance"
            return r3
        L52:
            java.lang.String r3 = "disabled"
            return r3
        L55:
            r3 = move-exception
            throw r3
        L57:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.PlaceComponentResult(id.dana.domain.homeinfo.ThirdPartyServiceResponse):java.lang.String");
    }

    private static String BuiltInFictitiousFunctionClassFactory(String str) {
        str.hashCode();
        if (!(str.equals(BranchLinkConstant.ActionTarget.NEARBY_ALL_SHOP))) {
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 113;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                if ((i % 2 == 0 ? '2' : 'C') == '2') {
                    int i2 = 26 / 0;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'E' : Typography.less) != 'E') {
            return BranchLinkConstant.ActionTarget.NEARBY_SHOP_LIST;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return BranchLinkConstant.ActionTarget.NEARBY_SHOP_LIST;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(final String str, final Map<String, String> map, final String str2) {
        try {
            this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeaturePresenter.this.MyBillsEntityDataFactory(map, str, str2, (Integer) obj);
                }
            }, new Function1() { // from class: id.dana.contract.deeplink.path.FeaturePresenter$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Throwable th = (Throwable) obj;
                    return FeaturePresenter.this.BuiltInFictitiousFunctionClassFactory(map, str, str2);
                }
            });
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 5;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                if ((i % 2 == 0 ? 'R' : '=') != '=') {
                    int i2 = 20 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit MyBillsEntityDataFactory(Map map, String str, String str2, Integer num) {
        Object obj;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getEdgeSlop() >> 16) + 1, new char[]{13640, 13624, 52826, 1793, 11706, 49031, 13027, 4483, 27125, 60051, 2322, 59791, 31854, 5380, 25720, 52548, 22779, 12386, 49116, 41184, 42923, 23761, 39690, 34704}, objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(0 % (ViewConfiguration.getEdgeSlop() << 120), new char[]{13640, 13624, 52826, 1793, 11706, 49031, 13027, 4483, 27125, 60051, 2322, 59791, 31854, 5380, 25720, 52548, 22779, 12386, 49116, 41184, 42923, 23761, 39690, 34704}, objArr2);
            obj = objArr2[0];
        }
        map.put(((String) obj).intern(), num.toString());
        BuiltInFictitiousFunctionClassFactory(str, map, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Map map, String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        String num = Integer.toString(1);
        Object[] objArr = new Object[1];
        a(ExpandableListView.getPackedPositionGroup(0L) + 1, new char[]{13640, 13624, 52826, 1793, 11706, 49031, 13027, 4483, 27125, 60051, 2322, 59791, 31854, 5380, 25720, 52548, 22779, 12386, 49116, 41184, 42923, 23761, 39690, 34704}, objArr);
        map.put(((String) objArr[0]).intern(), num);
        BuiltInFictitiousFunctionClassFactory(str, map, str2);
        Unit unit = Unit.INSTANCE;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return unit;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if ((r4 >= 5) != true) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r4 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
        id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r4 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
        id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4 % 128;
        r4 = r4 % 2;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if ((r4 >= 5 ? '0' : 'H') != '0') goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(int r4) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L3f
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L3f
            int r0 = r0 % 2
            r1 = 0
            r2 = 5
            r3 = 1
            if (r0 != 0) goto L1b
            r0 = 48
            if (r4 < r2) goto L16
            r4 = 48
            goto L18
        L16:
            r4 = 72
        L18:
            if (r4 == r0) goto L2d
            goto L22
        L1b:
            if (r4 < r2) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            if (r4 == r3) goto L2d
        L22:
            int r4 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r4 = r4 + 51
            int r0 = r4 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            int r4 = r4 % 2
            goto L38
        L2d:
            int r4 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r4 = r4 + 85
            int r0 = r4 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0
            int r4 = r4 % 2
            r1 = 1
        L38:
            java.lang.String r4 = java.lang.Boolean.toString(r1)     // Catch: java.lang.Exception -> L3d
            return r4
        L3d:
            r4 = move-exception
            throw r4
        L3f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.KClassImpl$Data$declaredNonStaticMembers$2(int):java.lang.String");
    }

    private void getErrorConfigVersion(Map<String, String> map) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 49;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            try {
                String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(map);
                map.put(FeatureParams.PUSH_VERIFY_ENTRY_POINT, BuiltInFictitiousFunctionClassFactory);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r5.equals(id.dana.feeds.ui.tracker.FeedsSourceType.FRIENDSHIP_MY_FEED) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r0 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        return "Inbox";
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r5.equals("Notification") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r5 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if ((r5 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        if (r3 == true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        r5 = r5.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return "Push Notification";
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return "Push Notification";
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5)) != true) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String BuiltInFictitiousFunctionClassFactory(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "Push Notification"
            java.lang.String r2 = "source"
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L29
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r2 = 71
            int r2 = r2 / r3
            if (r0 != 0) goto L23
            r0 = 0
            goto L24
        L23:
            r0 = 1
        L24:
            if (r0 == r4) goto L67
            goto L35
        L27:
            r5 = move-exception
            throw r5
        L29:
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L67
        L35:
            r5.hashCode()     // Catch: java.lang.Exception -> L65
            java.lang.String r0 = "Friendship My Feed"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> L65
            if (r0 != 0) goto L42
            r0 = 0
            goto L43
        L42:
            r0 = 1
        L43:
            if (r0 == 0) goto L48
            java.lang.String r1 = "Inbox"
            goto L69
        L48:
            java.lang.String r0 = "Notification"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L67
            int r5 = id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r5 = r5 + 87
            int r0 = r5 % 128
            id.dana.contract.deeplink.path.FeaturePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L5d
            goto L5e
        L5d:
            r3 = 1
        L5e:
            if (r3 == r4) goto L69
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L63
            goto L69
        L63:
            r5 = move-exception
            throw r5
        L65:
            r5 = move-exception
            throw r5
        L67:
            java.lang.String r1 = "Other"
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePresenter.BuiltInFictitiousFunctionClassFactory(java.util.Map):java.lang.String");
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.Presenter
    public final void getAuthRequestContext(String str, Map<String, String> map) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        this.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory(str, map, "", true, true, false);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 91;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 == 0 ? '`' : '\b') != '`') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult.get().dispose();
        FeatureServicesHandler featureServicesHandler = this.BuiltInFictitiousFunctionClassFactory.get();
        featureServicesHandler.getAuthRequestContext.dispose();
        featureServicesHandler.MyBillsEntityDataFactory.dispose();
        this.DatabaseTableConfigUtil.get().getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.scheduleImpl.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.moveToNextValue.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.lookAheadTest.get().dispose();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 7 : '3') != '3') {
            int i4 = 58 / 0;
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(Map<String, String> map) {
        String str;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            str = map.get("service");
            boolean isEmpty = TextUtils.isEmpty(str);
            Object obj = null;
            obj.hashCode();
            if (isEmpty) {
                return;
            }
        } else {
            str = map.get("service");
            if ((!TextUtils.isEmpty(str) ? '6' : 'G') == 'G') {
                return;
            }
        }
        String str2 = map.get("source");
        if (!(TextUtils.isEmpty(str2))) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            int i3 = i2 % 2;
            this.DatabaseTableConfigUtil.get().getAuthRequestContext(str2);
        }
        try {
            final FeatureServicesHandler featureServicesHandler = this.BuiltInFictitiousFunctionClassFactory.get();
            List asList = Arrays.asList(str.split(","));
            featureServicesHandler.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
            featureServicesHandler.MyBillsEntityDataFactory.execute(new DefaultObserver<List<ThirdPartyCategoryService>>() { // from class: id.dana.contract.deeplink.path.FeatureServicesHandler.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj2) {
                    List list = (List) obj2;
                    if (list == null || list.isEmpty() || ((ThirdPartyCategoryService) list.get(0)).getThirdPartyServices() == null || ((ThirdPartyCategoryService) list.get(0)).getThirdPartyServices().isEmpty()) {
                        FeatureServicesHandler.this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                        return;
                    }
                    FeatureServicesHandler featureServicesHandler2 = FeatureServicesHandler.this;
                    ThirdPartyServicesMapper unused = featureServicesHandler2.BuiltInFictitiousFunctionClassFactory;
                    ThirdPartyService MyBillsEntityDataFactory = ThirdPartyServicesMapper.MyBillsEntityDataFactory(((ThirdPartyCategoryService) list.get(0)).getThirdPartyServices().get(0));
                    if (MyBillsEntityDataFactory == null) {
                        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
                        builder.moveToNextValue = false;
                        MyBillsEntityDataFactory = builder.PlaceComponentResult();
                    }
                    FeatureServicesHandler.getAuthRequestContext(featureServicesHandler2, MyBillsEntityDataFactory);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    FeatureServicesHandler.this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                    super.onError(th);
                }
            }, GetServicesByKey.Params.forGetServicesByKey(asList));
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(initRecordTimeStamp ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 27;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (initRecordTimeStamp ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        try {
            int i4 = $11 + 87;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 15 : '6') != 15) {
                objArr[0] = str;
                return;
            }
            Object obj = null;
            obj.hashCode();
            objArr[0] = str;
        } catch (Exception e) {
            throw e;
        }
    }
}
