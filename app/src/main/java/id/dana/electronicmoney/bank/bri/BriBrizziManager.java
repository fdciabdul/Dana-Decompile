package id.dana.electronicmoney.bank.bri;

import android.content.Context;
import android.content.Intent;
import id.co.bri.brizzi.Brizzi;
import id.co.bri.brizzi.BrizziHistory;
import id.co.bri.brizzi.Callback;
import id.co.bri.brizzi.CardData;
import id.co.bri.brizzi.exception.BrizziException;
import id.dana.domain.electronicmoney.interactor.GetBrizziAccessToken;
import id.dana.domain.electronicmoney.model.response.BrizziAccessTokenInfo;
import id.dana.electronicmoney.BalanceResult;
import id.dana.electronicmoney.BaseElectronicMoneyManager;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import id.dana.electronicmoney.activity.ElectronicMoneyActivity;
import id.dana.electronicmoney.constants.ElectronicMoneyName;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import id.dana.utils.RSAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\u0005\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0005\u001a\"\u0012\u000b\u0012\t\u0018\u00010\n¢\u0006\u0002\b\u000b\u0012\u000b\u0012\t\u0018\u00010\f¢\u0006\u0002\b\u000b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u0016\u0010\u0007\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0012\u0010\u0017\u001a\u00020\u0016X\u0087\"¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\r\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001d"}, d2 = {"Lid/dana/electronicmoney/bank/bri/BriBrizziManager;", "Lid/dana/electronicmoney/BaseElectronicMoneyManager;", "Landroid/content/Intent;", "p0", "Lid/dana/electronicmoney/ElectronicMoneyCallback;", "p1", "", "PlaceComponentResult", "(Landroid/content/Intent;Lid/dana/electronicmoney/ElectronicMoneyCallback;)V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function2;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/co/bri/brizzi/Brizzi;", "MyBillsEntityDataFactory", "Lid/co/bri/brizzi/Brizzi;", "Landroid/content/Context;", "Landroid/content/Context;", "getAuthRequestContext", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "electronicMoneyMixpanelTracker", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "Lid/dana/domain/electronicmoney/interactor/GetBrizziAccessToken;", "Lid/dana/domain/electronicmoney/interactor/GetBrizziAccessToken;", "Ljava/lang/Boolean;", "", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lid/dana/domain/electronicmoney/interactor/GetBrizziAccessToken;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BriBrizziManager implements BaseElectronicMoneyManager {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Brizzi PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context getAuthRequestContext;
    @Inject
    public ElectronicMoneyAnalyticTracker electronicMoneyMixpanelTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetBrizziAccessToken KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public BriBrizziManager(Context context, GetBrizziAccessToken getBrizziAccessToken) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getBrizziAccessToken, "");
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getBrizziAccessToken;
        this.BuiltInFictitiousFunctionClassFactory = Boolean.FALSE;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Intent p0, final Function2<? super Boolean, ? super Throwable, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        if (bool == null) {
            return;
        }
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = null;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            p1.invoke(Boolean.TRUE, null);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        String stringExtra = p0.getStringExtra(ElectronicMoneyActivity.EXTRA_SOURCE_CLICK);
        if (stringExtra != null) {
            ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker2 = this.electronicMoneyMixpanelTracker;
            if (electronicMoneyAnalyticTracker2 != null) {
                electronicMoneyAnalyticTracker = electronicMoneyAnalyticTracker2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(stringExtra);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(RSAUtil.getAuthRequestContext(), new Function1<BrizziAccessTokenInfo, Unit>() { // from class: id.dana.electronicmoney.bank.bri.BriBrizziManager$setup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BrizziAccessTokenInfo brizziAccessTokenInfo) {
                invoke2(brizziAccessTokenInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BrizziAccessTokenInfo brizziAccessTokenInfo) {
                Context context;
                Intrinsics.checkNotNullParameter(brizziAccessTokenInfo, "");
                BriBrizziManager briBrizziManager = BriBrizziManager.this;
                Brizzi brizzi = new Brizzi(brizziAccessTokenInfo.getConsumerKey(), brizziAccessTokenInfo.getConsumerSecret());
                BriBrizziManager briBrizziManager2 = BriBrizziManager.this;
                brizzi.setToken(brizziAccessTokenInfo.getAccessToken());
                brizzi.setUsername(brizziAccessTokenInfo.getUsername());
                context = briBrizziManager2.getAuthRequestContext;
                brizzi.setNFCAdapter(context);
                briBrizziManager.PlaceComponentResult = brizzi;
                BriBrizziManager.this.MyBillsEntityDataFactory = brizziAccessTokenInfo.getReffNumber();
                BriBrizziManager briBrizziManager3 = BriBrizziManager.this;
                Boolean bool2 = Boolean.TRUE;
                briBrizziManager3.BuiltInFictitiousFunctionClassFactory = bool2;
                p1.invoke(bool2, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.bri.BriBrizziManager$setup$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                BriBrizziManager briBrizziManager = BriBrizziManager.this;
                Boolean bool2 = Boolean.FALSE;
                briBrizziManager.BuiltInFictitiousFunctionClassFactory = bool2;
                p1.invoke(bool2, th);
            }
        });
    }

    @Override // id.dana.electronicmoney.BaseElectronicMoneyManager
    public final void BuiltInFictitiousFunctionClassFactory(final Intent p0, final ElectronicMoneyCallback p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, new Function2<Boolean, Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.bri.BriBrizziManager$updateAndReadBalance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Boolean bool, Throwable th) {
                invoke(bool.booleanValue(), th);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, Throwable th) {
                Brizzi brizzi;
                String str;
                if (z) {
                    brizzi = BriBrizziManager.this.PlaceComponentResult;
                    String str2 = null;
                    if (brizzi == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        brizzi = null;
                    }
                    Intent intent = p0;
                    str = BriBrizziManager.this.MyBillsEntityDataFactory;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        str2 = str;
                    }
                    final BriBrizziManager briBrizziManager = BriBrizziManager.this;
                    final ElectronicMoneyCallback electronicMoneyCallback = p1;
                    final Intent intent2 = p0;
                    brizzi.updateBalancePartner(intent, str2, new Callback() { // from class: id.dana.electronicmoney.bank.bri.BriBrizziManager$updateAndReadBalance$1.1
                        @Override // id.co.bri.brizzi.Callback
                        public final void onSuccess(CardData<?> p02) {
                            Intrinsics.checkNotNullParameter(p02, "");
                            BriBrizziManager.PlaceComponentResult(BriBrizziManager.this);
                            BriBrizziManager.BuiltInFictitiousFunctionClassFactory(BriBrizziManager.this);
                            BriBrizziManager.KClassImpl$Data$declaredNonStaticMembers$2(p02, electronicMoneyCallback);
                        }

                        @Override // id.co.bri.brizzi.Callback
                        public final void onFailure(BrizziException p02) {
                            BriBrizziManager.BuiltInFictitiousFunctionClassFactory(BriBrizziManager.this, p02);
                            BriBrizziManager.KClassImpl$Data$declaredNonStaticMembers$2(BriBrizziManager.this, p02);
                            if (!Intrinsics.areEqual(p02 != null ? p02.getErrorCode() : null, "04")) {
                                BuildersKt__Builders_commonKt.launch$default(r1.getAuthRequestContext, Dispatchers.getMain(), null, new BriBrizziManager$postErrorCallback$$inlined$postToUi$1(null, electronicMoneyCallback, p02, BriBrizziManager.this), 2, null);
                                return;
                            }
                            BriBrizziManager briBrizziManager2 = BriBrizziManager.this;
                            Intent intent3 = intent2;
                            ElectronicMoneyCallback electronicMoneyCallback2 = electronicMoneyCallback;
                            Intrinsics.checkNotNullParameter(intent3, "");
                            Intrinsics.checkNotNullParameter(electronicMoneyCallback2, "");
                            briBrizziManager2.KClassImpl$Data$declaredNonStaticMembers$2(intent3, new BriBrizziManager$readBalance$1(briBrizziManager2, intent3, electronicMoneyCallback2));
                        }
                    });
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(r0.getAuthRequestContext, Dispatchers.getMain(), null, new BriBrizziManager$postErrorCallback$$inlined$postToUi$1(null, p1, BriBrizziManager.getAuthRequestContext(th), BriBrizziManager.this), 2, null);
            }
        });
    }

    @Override // id.dana.electronicmoney.BaseElectronicMoneyManager
    public final void PlaceComponentResult(Intent p0, ElectronicMoneyCallback p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, new BriBrizziManager$readBalance$1(this, p0, p1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0 == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ id.co.bri.brizzi.exception.BrizziException getAuthRequestContext(java.lang.Throwable r5) {
        /*
            boolean r0 = r5 instanceof id.dana.network.exception.NetworkException
            if (r0 != 0) goto L2c
            boolean r0 = r5 instanceof com.alipay.imobile.network.quake.exception.ClientException
            if (r0 == 0) goto L24
            com.alipay.imobile.network.quake.exception.ClientException r5 = (com.alipay.imobile.network.quake.exception.ClientException) r5
            java.lang.String r5 = r5.getMessage()
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L22
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r2 = "network is not available"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 2
            r4 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r2, r0, r3, r4)
            if (r5 == r1) goto L21
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 != 0) goto L2c
        L24:
            id.co.bri.brizzi.exception.BrizziException r5 = new id.co.bri.brizzi.exception.BrizziException
            java.lang.String r0 = "92"
            r5.<init>(r0)
            goto L33
        L2c:
            id.co.bri.brizzi.exception.BrizziException r5 = new id.co.bri.brizzi.exception.BrizziException
            java.lang.String r0 = "01"
            r5.<init>(r0)
        L33:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.bri.BriBrizziManager.getAuthRequestContext(java.lang.Throwable):id.co.bri.brizzi.exception.BrizziException");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CardData cardData, ElectronicMoneyCallback electronicMoneyCallback) {
        BrizziHistory brizziHistory;
        String cardBalance = cardData.getCardBalance();
        Intrinsics.checkNotNullExpressionValue(cardBalance, "");
        String cardNumber = cardData.getCardNumber();
        Intrinsics.checkNotNullExpressionValue(cardNumber, "");
        ArrayList<BrizziHistory> cardHistory = cardData.getCardHistory();
        String trxDate = (cardHistory == null || (brizziHistory = (BrizziHistory) CollectionsKt.firstOrNull((List) cardHistory)) == null) ? null : brizziHistory.getTrxDate();
        String str = trxDate == null ? "" : trxDate;
        String pendingBalance = cardData.getPendingBalance();
        String str2 = pendingBalance == null ? "" : pendingBalance;
        String activatedBalance = cardData.getActivatedBalance();
        BuildersKt__Builders_commonKt.launch$default(electronicMoneyCallback.getAuthRequestContext, Dispatchers.getMain(), null, new BriBrizziManager$postSuccessCallback$$inlined$postToUi$1(null, electronicMoneyCallback, new BalanceResult(true, ElectronicMoneyName.BRIZZI, cardBalance, cardNumber, str, null, false, str2, activatedBalance == null ? "" : activatedBalance, 96, null)), 2, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0.equals("06") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        if (r0.equals("03") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r0.equals("93") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0067, code lost:
    
        if (r0.equals("92") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        if (r0.equals("98") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
    
        if (r0.equals("97") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008d, code lost:
    
        if (r0.equals("96") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
    
        if (r0.equals("09") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009f, code lost:
    
        if (r0.equals("08") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a1, code lost:
    
        r0 = "011";
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b5, code lost:
    
        if (r0.equals("64") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
    
        r0 = "005";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ id.dana.electronicmoney.ElectronicMoneyException PlaceComponentResult(id.co.bri.brizzi.exception.BrizziException r3) {
        /*
            if (r3 == 0) goto Ld1
            java.lang.String r0 = r3.getErrorCode()
            if (r0 == 0) goto Lc5
            int r1 = r0.hashCode()
            r2 = 1537(0x601, float:2.154E-42)
            if (r1 == r2) goto Lba
            r2 = 1726(0x6be, float:2.419E-42)
            if (r1 == r2) goto Laf
            r2 = 1785(0x6f9, float:2.501E-42)
            if (r1 == r2) goto La4
            r2 = 1544(0x608, float:2.164E-42)
            if (r1 == r2) goto L99
            r2 = 1545(0x609, float:2.165E-42)
            if (r1 == r2) goto L90
            switch(r1) {
                case 1539: goto L4d;
                case 1540: goto L41;
                case 1541: goto L35;
                case 1542: goto L2b;
                default: goto L23;
            }
        L23:
            switch(r1) {
                case 1816: goto L6a;
                case 1817: goto L61;
                case 1818: goto L57;
                default: goto L26;
            }
        L26:
            switch(r1) {
                case 1821: goto L87;
                case 1822: goto L7e;
                case 1823: goto L75;
                default: goto L29;
            }
        L29:
            goto Lc5
        L2b:
            java.lang.String r1 = "06"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto La1
            goto Lc5
        L35:
            java.lang.String r1 = "05"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "013"
            goto Lc7
        L41:
            java.lang.String r1 = "04"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "001"
            goto Lc7
        L4d:
            java.lang.String r1 = "03"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L57:
            java.lang.String r1 = "93"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L61:
            java.lang.String r1 = "92"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L6a:
            java.lang.String r1 = "91"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "007"
            goto Lc7
        L75:
            java.lang.String r1 = "98"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            goto Lb7
        L7e:
            java.lang.String r1 = "97"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L87:
            java.lang.String r1 = "96"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L90:
            java.lang.String r1 = "09"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb7
            goto Lc5
        L99:
            java.lang.String r1 = "08"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
        La1:
            java.lang.String r0 = "011"
            goto Lc7
        La4:
            java.lang.String r1 = "81"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "003"
            goto Lc7
        Laf:
            java.lang.String r1 = "64"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
        Lb7:
            java.lang.String r0 = "005"
            goto Lc7
        Lba:
            java.lang.String r1 = "01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc5
            java.lang.String r0 = "014"
            goto Lc7
        Lc5:
            java.lang.String r0 = "012"
        Lc7:
            id.dana.electronicmoney.ElectronicMoneyException r1 = new id.dana.electronicmoney.ElectronicMoneyException
            java.lang.String r3 = r3.getMessage()
            r1.<init>(r0, r3)
            goto Ld2
        Ld1:
            r1 = 0
        Ld2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.bri.BriBrizziManager.PlaceComponentResult(id.co.bri.brizzi.exception.BrizziException):id.dana.electronicmoney.ElectronicMoneyException");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BriBrizziManager briBrizziManager, BrizziException brizziException) {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = briBrizziManager.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        String errorCode = brizziException != null ? brizziException.getErrorCode() : null;
        if (errorCode == null) {
            errorCode = "";
        }
        String message = brizziException != null ? brizziException.getMessage() : null;
        electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory("BRI", "failed", errorCode, message != null ? message : "");
    }

    public static final /* synthetic */ void PlaceComponentResult(BriBrizziManager briBrizziManager) {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = briBrizziManager.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        electronicMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory("BRI", "success", "", "");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BriBrizziManager briBrizziManager, BrizziException brizziException) {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = briBrizziManager.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        String errorCode = brizziException != null ? brizziException.getErrorCode() : null;
        if (errorCode == null) {
            errorCode = "";
        }
        String message = brizziException != null ? brizziException.getMessage() : null;
        electronicMoneyAnalyticTracker.getAuthRequestContext("Brizzi", "Failed", errorCode, message != null ? message : "");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BriBrizziManager briBrizziManager) {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = briBrizziManager.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            electronicMoneyAnalyticTracker = null;
        }
        electronicMoneyAnalyticTracker.getAuthRequestContext("Brizzi", "Success", "", "");
    }
}
