package com.ipification.mobile.sdk.android;

import android.net.Uri;
import android.util.Base64;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.sendmoney.summary.SummaryActivity;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u0000 A2\u00020\u0001:\u0002ABB\t\b\u0002¢\u0006\u0004\b?\u0010@J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0003\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\n\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0012\u0010\u000f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0012\u0010\u0011\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0012\u0010\u0012\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0012\u0010\u0014\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0012\u0010\u0013\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007R\u0012\u0010\u0017\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0012\u0010\u0015\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u001a\u0010\u001c\u001a\u00020\u00188\u0007X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001bR\u0012\u0010 \u001a\u00020\u001dX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010\u001e\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\rR\u001a\u0010\"\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\u0011\u0010\u001bR\u0012\u0010#\u001a\u00020\tX\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010\u000bR\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020$X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u0012\u0010)\u001a\u00020'X\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010(R\u0012\u0010*\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010\rR\u0014\u0010+\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010\u0007R\u0012\u0010,\u001a\u00020'X\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010(R\u0012\u0010-\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010\rR\u0012\u0010.\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010\rR\u0012\u0010/\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b/\u0010\rR\u0012\u00100\u001a\u00020'X\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010(R\u0012\u00101\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b-\u0010\rR\u0012\u00102\u001a\u00020\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\b1\u0010\u001aR\u0012\u00103\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b0\u0010\rR\u0012\u00104\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b2\u0010\rR\u001a\u00106\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b5\u0010\u001a\u001a\u0004\b\b\u0010\u001bR\u001a\u00108\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b7\u0010\u001a\u001a\u0004\b\u0006\u0010\u001bR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u00105\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b\f\u0010\u001bR\u001a\u00107\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b;\u0010\u001a\u001a\u0004\b\u0012\u0010\u001bR\u0012\u0010<\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b6\u0010\rR\u0012\u0010!\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b4\u0010\rR\u001a\u0010:\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b=\u0010\u001a\u001a\u0004\b\u000e\u0010\u001bR\u0012\u0010=\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010\rR\u0012\u0010>\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b<\u0010\r"}, d2 = {"Lcom/ipification/mobile/sdk/android/IPConfiguration;", "", "", "getAuthRequestContext", "()Ljava/lang/String;", "Landroid/net/Uri;", "BuiltInFictitiousFunctionClassFactory", "Landroid/net/Uri;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "J", "MyBillsEntityDataFactory", "Ljava/lang/String;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "moveToNextValue", "scheduleImpl", "initRecordTimeStamp", "DatabaseTableConfigUtil", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "getOnBoardingScenario", "Z", "()Z", "isLayoutRequested", "Lcom/ipification/mobile/sdk/android/IPEnvironment;", "PrepareContext", "Lcom/ipification/mobile/sdk/android/IPEnvironment;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "E", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "", "[Ljava/lang/String;", "FragmentBottomSheetPaymentSettingBinding", "", "I", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "whenAvailable", "getSupportButtonTintMode", "getCallingPid", "SubSequence", "readMicros", "A", "VerifyPinStateManager$executeRiskChallenge$2$1", "C", "getValueOfTouchPositionAbsolute", "BottomSheetCardBindingView$watcherCardNumberView$1", "VerifyPinStateManager$executeRiskChallenge$2$2", DiskFormatter.B, "Ljava/lang/Boolean;", "AppCompatEmojiTextHelper", DiskFormatter.GB, SummaryActivity.DAYS, LogConstants.RESULT_FALSE, SummaryActivity.HOURS, "<init>", "()V", "Companion", "Holder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IPConfiguration {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A  reason: from kotlin metadata */
    public String C;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private boolean getValueOfTouchPositionAbsolute;

    /* renamed from: B  reason: from kotlin metadata */
    public Boolean getOnBoardingScenario;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public String D;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Uri KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: C  reason: from kotlin metadata */
    public String E;

    /* renamed from: D  reason: from kotlin metadata */
    public String H;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: E  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: F  reason: from kotlin metadata */
    private boolean AppCompatEmojiTextHelper;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public String whenAvailable;

    /* renamed from: G  reason: from kotlin metadata */
    private boolean VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    long initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String GetContactSyncConfig;
    Uri NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public String getSupportButtonTintMode;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public Uri NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda3;
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public long getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public IPEnvironment NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public String VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    public String F;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private boolean B;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public long PlaceComponentResult;
    public String getCallingPid;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private final boolean isLayoutRequested;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    public int SubSequence;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public String[] FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String lookAheadTest;
    public long newProxyInstance;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public boolean A;
    long scheduleImpl;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    String readMicros;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/ipification/mobile/sdk/android/IPConfiguration$Companion;", "", "Lcom/ipification/mobile/sdk/android/IPConfiguration;", "MyBillsEntityDataFactory", "()Lcom/ipification/mobile/sdk/android/IPConfiguration;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static IPConfiguration MyBillsEntityDataFactory() {
            Holder holder = Holder.getAuthRequestContext;
            return Holder.MyBillsEntityDataFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\b\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ipification/mobile/sdk/android/IPConfiguration$Holder;", "", "()V", "INSTANCE", "Lcom/ipification/mobile/sdk/android/IPConfiguration;", "getINSTANCE", "()Lcom/ipification/mobile/sdk/android/IPConfiguration;", "INSTANCE$1", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final Holder getAuthRequestContext = new Holder();
        public static final IPConfiguration MyBillsEntityDataFactory = new IPConfiguration(null);
    }

    private IPConfiguration() {
        this.H = "com.whatsapp";
        this.D = AppPackageName.TELEGRAM;
        this.E = "org.telegram.messenger.web";
        this.F = "com.viber.voip";
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = IPEnvironment.SANDBOX;
        this.newProxyInstance = 2000L;
        this.FragmentBottomSheetPaymentSettingBinding = new String[0];
        this.isLayoutRequested = true;
        this.SubSequence = 128;
        this.AppCompatEmojiTextHelper = true;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = "";
        this.C = "";
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = true;
        this.readMicros = "ipification-services.json";
        this.moveToNextValue = "";
        this.getCallingPid = "https://stage.ipification.com";
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = "https://api.ipification.com";
        this.lookAheadTest = "/auth/realms/ipification/coverage";
        this.DatabaseTableConfigUtil = "/1.2.3.4";
        this.MyBillsEntityDataFactory = "/auth/realms/ipification/protocol/openid-connect/auth";
        this.PrepareContext = "https://stage.ipification.com";
        this.GetContactSyncConfig = "https://stage.ipification.com/auth/realms/ipification/coverage";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "https://api.ipification.com/auth/realms/ipification/coverage";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "https://stage.ipification.com/auth/realms/ipification/protocol/openid-connect/auth";
        this.BuiltInFictitiousFunctionClassFactory = "https://api.ipification.com/auth/realms/ipification/protocol/openid-connect/auth";
        this.getSupportButtonTintMode = "https://stage.ipification.com/auth/realms/ipification/sdk";
        this.whenAvailable = "https://api.ipification.com/auth/realms/ipification/sdk";
        this.initRecordTimeStamp = 10000L;
        this.scheduleImpl = 10000L;
        this.PlaceComponentResult = 10000L;
        this.getAuthRequestContext = 10000L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = RequestConstants.VerifyCallAllStart;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 2101;
        this.getErrorConfigVersion = "ipconsent001eng";
    }

    public /* synthetic */ IPConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getB() {
        return this.B;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getBottomSheetCardBindingView$watcherCardNumberView$1() {
        return this.BottomSheetCardBindingView$watcherCardNumberView$1;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetValueOfTouchPositionAbsolute() {
        return this.getValueOfTouchPositionAbsolute;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getIsLayoutRequested() {
        return this.isLayoutRequested;
    }

    public final String getAuthRequestContext() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[this.SubSequence];
        secureRandom.nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        int length = encodeToString.length();
        int i = this.SubSequence;
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "");
        if (length > i) {
            String substring = encodeToString.substring(0, this.SubSequence);
            Intrinsics.checkExpressionValueIsNotNull(substring, "");
            return substring;
        }
        return encodeToString;
    }

    @JvmName(name = "lookAheadTest")
    /* renamed from: lookAheadTest  reason: from getter */
    public final boolean getAppCompatEmojiTextHelper() {
        return this.AppCompatEmojiTextHelper;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final boolean getVerifyPinStateManager$executeRiskChallenge$2$2() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$2;
    }
}
