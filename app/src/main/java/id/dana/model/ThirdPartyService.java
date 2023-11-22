package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.data.config.source.sharedpreference.BannerLottieEntityData;
import id.dana.data.config.source.sharedpreference.SkuAttributeModelEntityData;
import id.dana.data.config.source.sharedpreference.SpmIdEntityData;
import id.dana.data.config.source.sharedpreference.ThirdPartyServiceEntityData;
import id.dana.model.BannerLottieModel;
import id.dana.model.SkuAttributeModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\b\u0086\b\u0018\u0000 t2\u00020\u0001:\u0005utvwxBõ\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010M\u001a\u00020\u0007\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010V\u001a\u00020\u0007\u0012\b\b\u0002\u0010W\u001a\u00020\u0002\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010`\u001a\u00020\u0007\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010g\u001a\u00020\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010j\u001a\u00020\u0007\u0012\b\b\u0002\u0010k\u001a\u00020\u0002\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010p\u001a\u00020\n\u0012\b\b\u0002\u0010q\u001a\u00020\u0007¢\u0006\u0004\br\u0010sJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\fJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0016\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010 \u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0013\u0010!\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0013\u0010\"\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010&\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b#\u0010%R\u001a\u0010(\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010$\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010*\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b\u001d\u0010\u000fR\u001a\u0010,\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b+\u0010\u001a\u001a\u0004\b\u001e\u0010\u000fR\u0012\u0010-\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010.\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u001a\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/X\u0087\u0002¢\u0006\u0006\n\u0004\b-\u00100R\u0014\u00102\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b1\u0010\u0017R\u0014\u00103\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010\u0017R\u0014\u00104\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010\u0017R\u0014\u00105\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b4\u0010\u0017R\u0014\u00106\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010\u0017R\u001a\u00108\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b7\u0010\u001a\u001a\u0004\b\u0018\u0010\u000fR\u0014\u00109\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b5\u0010\u0017R\u0014\u0010:\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b6\u0010\u0017R\u0014\u0010;\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b2\u0010\u0017R\u0012\u0010<\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b;\u0010\u0017R\u0012\u0010?\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b8\u0010=R\u0014\u0010@\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b:\u0010\u0017R\u0014\u0010A\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b9\u0010\u0017R\u0014\u0010C\u001a\u0004\u0018\u00010BX\u0087\u0002¢\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010E\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010/X\u0087\u0002¢\u0006\u0006\n\u0004\bA\u00100R\u0014\u0010'\u001a\u0004\u0018\u00010FX\u0087\u0002¢\u0006\u0006\n\u0004\b?\u0010GR\u0014\u0010)\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b>\u0010\u0017R\u0014\u0010H\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b@\u0010\u0017R\u0012\u0010I\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\bI\u0010=R\u0012\u0010+\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\bE\u0010\u0017R\u0014\u00107\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\bH\u0010\u0017"}, d2 = {"Lid/dana/model/ThirdPartyService;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "hashCode", "getErrorConfigVersion", "()Z", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Z", "Lid/dana/model/BannerLottieModel;", "Lid/dana/model/BannerLottieModel;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Integer;", "initRecordTimeStamp", "E", "DatabaseTableConfigUtil", "VerifyPinStateManager$executeRiskChallenge$2$2", "NetworkUserEntityData$$ExternalSyntheticLambda7", LogConstants.RESULT_FALSE, "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "", "Ljava/util/List;", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "AppCompatEmojiTextHelper", "SubSequence", "getSupportButtonTintMode", "whenAvailable", "getCallingPid", "readMicros", "I", DiskFormatter.B, "BottomSheetCardBindingView$watcherCardNumberView$1", "VerifyPinStateManager$executeRiskChallenge$2$1", "C", "Lid/dana/model/SkuAttributeModel;", "A", "Lid/dana/model/SkuAttributeModel;", "getOnBoardingScenario", "Lid/dana/model/ThirdPartyService$SpmId;", "Lid/dana/model/ThirdPartyService$SpmId;", "getValueOfTouchPositionAbsolute", SummaryActivity.DAYS, "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "p36", "p37", "p38", "p39", "p40", "p41", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/model/ThirdPartyService$SpmId;ZLid/dana/model/SkuAttributeModel;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;ZILjava/lang/String;Lid/dana/model/BannerLottieModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "Builder", "SpmId", "UIVersion", "Variant"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ThirdPartyService implements Parcelable {
    public SkuAttributeModel A;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private boolean SubSequence;

    /* renamed from: B  reason: from kotlin metadata */
    public String VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public SpmId E;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: C  reason: from kotlin metadata */
    public List<String> getOnBoardingScenario;
    public int D;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: E  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: F  reason: from kotlin metadata */
    private boolean isLayoutRequested;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public Integer initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final BannerLottieModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public String getSupportButtonTintMode;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public String whenAvailable;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public String getCallingPid;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public String newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public List<String> PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public int BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    public String getValueOfTouchPositionAbsolute;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    public String B;
    public String getErrorConfigVersion;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    public String F;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    public String C;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    public String AppCompatEmojiTextHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public String FragmentBottomSheetPaymentSettingBinding;
    public int readMicros;
    public final String scheduleImpl;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    public String VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ThirdPartyService> CREATOR = new Creator();

    public ThirdPartyService() {
        this(null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, false, null, null, null, null, 0, null, null, false, 0, null, null, null, null, null, false, -1, 1023, null);
    }

    @JvmStatic
    public static final List<ThirdPartyService> BuiltInFictitiousFunctionClassFactory(List<ThirdPartyServiceEntityData> list) {
        return Companion.KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdPartyService(NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", whenAvailable=");
        sb.append(this.whenAvailable);
        sb.append(", getCallingPid=");
        sb.append(this.getCallingPid);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$1=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", D=");
        sb.append(this.D);
        sb.append(", AppCompatEmojiTextHelper=");
        sb.append(this.AppCompatEmojiTextHelper);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getValueOfTouchPositionAbsolute=");
        sb.append(this.getValueOfTouchPositionAbsolute);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$2=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", B=");
        sb.append(this.B);
        sb.append(", E=");
        sb.append(this.E);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", A=");
        sb.append(this.A);
        sb.append(", SubSequence=");
        sb.append(this.SubSequence);
        sb.append(", getOnBoardingScenario=");
        sb.append(this.getOnBoardingScenario);
        sb.append(", C=");
        sb.append(this.C);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getSupportButtonTintMode=");
        sb.append(this.getSupportButtonTintMode);
        sb.append(", readMicros=");
        sb.append(this.readMicros);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda5=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", BottomSheetCardBindingView$watcherCardNumberView$1=");
        sb.append(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", F=");
        sb.append(this.F);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? 1 : 0);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        p0.writeString(this.whenAvailable);
        p0.writeString(this.getCallingPid);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        p0.writeInt(this.isLayoutRequested ? 1 : 0);
        p0.writeInt(this.D);
        p0.writeString(this.AppCompatEmojiTextHelper);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.getValueOfTouchPositionAbsolute);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        p0.writeStringList(this.PrepareContext);
        p0.writeString(this.B);
        SpmId spmId = this.E;
        if (spmId == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            spmId.writeToParcel(p0, p1);
        }
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda7 ? 1 : 0);
        SkuAttributeModel skuAttributeModel = this.A;
        if (skuAttributeModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            skuAttributeModel.writeToParcel(p0, p1);
        }
        p0.writeInt(this.SubSequence ? 1 : 0);
        p0.writeStringList(this.getOnBoardingScenario);
        p0.writeString(this.C);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getSupportButtonTintMode);
        p0.writeInt(this.readMicros);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        Integer num = this.initRecordTimeStamp;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeInt(this.DatabaseTableConfigUtil ? 1 : 0);
        p0.writeInt(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        BannerLottieModel bannerLottieModel = this.getAuthRequestContext;
        if (bannerLottieModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            bannerLottieModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.F);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
    }

    public ThirdPartyService(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z2, int i, String str14, String str15, String str16, String str17, String str18, List<String> list, String str19, SpmId spmId, boolean z3, SkuAttributeModel skuAttributeModel, boolean z4, List<String> list2, String str20, String str21, String str22, int i2, String str23, Integer num, boolean z5, int i3, String str24, BannerLottieModel bannerLottieModel, String str25, String str26, String str27, boolean z6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str27, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
        this.newProxyInstance = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.moveToNextValue = str4;
        this.PlaceComponentResult = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
        this.GetContactSyncConfig = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str7;
        this.FragmentBottomSheetPaymentSettingBinding = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str10;
        this.whenAvailable = str11;
        this.getCallingPid = str12;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = str13;
        this.isLayoutRequested = z2;
        this.D = i;
        this.AppCompatEmojiTextHelper = str14;
        this.lookAheadTest = str15;
        this.getValueOfTouchPositionAbsolute = str16;
        this.getErrorConfigVersion = str17;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str18;
        this.PrepareContext = list;
        this.B = str19;
        this.E = spmId;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z3;
        this.A = skuAttributeModel;
        this.SubSequence = z4;
        this.getOnBoardingScenario = list2;
        this.C = str20;
        this.MyBillsEntityDataFactory = str21;
        this.getSupportButtonTintMode = str22;
        this.readMicros = i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str23;
        this.initRecordTimeStamp = num;
        this.DatabaseTableConfigUtil = z5;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = i3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str24;
        this.getAuthRequestContext = bannerLottieModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str25;
        this.scheduleImpl = str26;
        this.F = str27;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z6;
    }

    public /* synthetic */ ThirdPartyService(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z2, int i, String str14, String str15, String str16, String str17, String str18, List list, String str19, SpmId spmId, boolean z3, SkuAttributeModel skuAttributeModel, boolean z4, List list2, String str20, String str21, String str22, int i2, String str23, Integer num, boolean z5, int i3, String str24, BannerLottieModel bannerLottieModel, String str25, String str26, String str27, boolean z6, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? null : str6, (i4 & 128) != 0 ? null : str7, (i4 & 256) != 0 ? null : str8, (i4 & 512) != 0 ? null : str9, (i4 & 1024) != 0 ? null : str10, (i4 & 2048) != 0 ? null : str11, (i4 & 4096) != 0 ? null : str12, (i4 & 8192) != 0 ? null : str13, (i4 & 16384) != 0 ? false : z2, (i4 & 32768) != 0 ? 0 : i, (i4 & 65536) != 0 ? null : str14, (i4 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str15, (i4 & 262144) != 0 ? null : str16, (i4 & 524288) != 0 ? null : str17, (i4 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str18, (i4 & 2097152) != 0 ? null : list, (i4 & 4194304) != 0 ? null : str19, (i4 & 8388608) != 0 ? null : spmId, (i4 & 16777216) != 0 ? false : z3, (i4 & 33554432) != 0 ? null : skuAttributeModel, (i4 & 67108864) != 0 ? false : z4, (i4 & 134217728) != 0 ? null : list2, (i4 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str20, (i4 & 536870912) != 0 ? null : str21, (i4 & 1073741824) != 0 ? null : str22, (i4 & Integer.MIN_VALUE) != 0 ? -1 : i2, (i5 & 1) != 0 ? null : str23, (i5 & 2) != 0 ? null : num, (i5 & 4) != 0 ? false : z5, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? null : str24, (i5 & 32) != 0 ? null : bannerLottieModel, (i5 & 64) != 0 ? null : str25, (i5 & 128) != 0 ? null : str26, (i5 & 256) != 0 ? UIVersion.VERSION_1 : str27, (i5 & 512) != 0 ? false : z6);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final boolean getIsLayoutRequested() {
        return this.isLayoutRequested;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getSubSequence() {
        return this.SubSequence;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    public final String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("icn-");
        sb.append(StringsKt.replace$default(this.NetworkUserEntityData$$ExternalSyntheticLambda8, "_", "-", false, 4, (Object) null));
        return sb.toString();
    }

    public final int hashCode() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
    }

    public final boolean equals(Object p0) {
        return this == p0 || ((p0 instanceof ThirdPartyService) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, ((ThirdPartyService) p0).NetworkUserEntityData$$ExternalSyntheticLambda8));
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/model/ThirdPartyService$Variant;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Variant {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
        public static final int EDIT = 5;
        public static final int EMPTY = 6;
        public static final int FEATURE = 2;
        public static final int HEADER = 3;
        public static final int ITEM = 0;
        public static final int MORE = 1;
        public static final int SPACE = 4;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/model/ThirdPartyService$Variant$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/model/ThirdPartyService$UIVersion;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface UIVersion {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
        public static final String VERSION_1 = "Version 1";
        public static final String VERSION_2 = "Version 2";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/model/ThirdPartyService$UIVersion$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

            private Companion() {
            }
        }
    }

    public final boolean getErrorConfigVersion() {
        return StringsKt.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_paylater_loan_personal", true);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\tR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0006R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010!R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0006R\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0006R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0006R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0006R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\tR\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0006R\u0018\u0010(\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0006R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0006R\u0018\u0010'\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0006R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0006R\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0006R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010!R\u0018\u0010-\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00105R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0006R\u0018\u00106\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010\u0006R\u0016\u00108\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010,R\u0018\u00107\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0006"}, d2 = {"Lid/dana/model/ThirdPartyService$Builder;", "", "Lid/dana/model/ThirdPartyService;", "PlaceComponentResult", "()Lid/dana/model/ThirdPartyService;", "", "Ljava/lang/String;", "getAuthRequestContext", "", "Z", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/model/BannerLottieModel;", "Lid/dana/model/BannerLottieModel;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "DatabaseTableConfigUtil", "", "PrepareContext", "Ljava/lang/Integer;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "getSupportButtonTintMode", "readMicros", "whenAvailable", "getCallingPid", "SubSequence", "I", DiskFormatter.B, "C", "Lid/dana/model/SkuAttributeModel;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/model/SkuAttributeModel;", "A", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/model/ThirdPartyService$SpmId;", "Lid/dana/model/ThirdPartyService$SpmId;", "E", "getValueOfTouchPositionAbsolute", SummaryActivity.DAYS, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: A  reason: from kotlin metadata */
        public List<String> VerifyPinStateManager$executeRiskChallenge$2$1;

        /* renamed from: B  reason: from kotlin metadata */
        public String C;
        public SkuAttributeModel BottomSheetCardBindingView$watcherCardNumberView$1;

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: C  reason: from kotlin metadata */
        public String A;

        /* renamed from: D  reason: from kotlin metadata */
        public String getValueOfTouchPositionAbsolute;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String E;
        public String FragmentBottomSheetPaymentSettingBinding;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public String initRecordTimeStamp;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public BannerLottieModel BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public String DatabaseTableConfigUtil;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public boolean GetContactSyncConfig;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda4;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda5;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda3;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public String isLayoutRequested = "";

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public Integer newProxyInstance;

        /* renamed from: SubSequence  reason: from kotlin metadata */
        public int whenAvailable;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
        public SpmId B;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public boolean MyBillsEntityDataFactory;

        /* renamed from: getCallingPid  reason: from kotlin metadata */
        public String SubSequence;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public String scheduleImpl;

        /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
        public String readMicros;

        /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
        public int D;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public String PrepareContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String lookAheadTest;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public List<String> NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: readMicros  reason: from kotlin metadata */
        public String getSupportButtonTintMode;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public boolean moveToNextValue;

        /* renamed from: whenAvailable  reason: from kotlin metadata */
        public String getCallingPid;

        public final ThirdPartyService PlaceComponentResult() {
            String str = this.isLayoutRequested;
            String str2 = this.getAuthRequestContext;
            String str3 = this.getErrorConfigVersion;
            String str4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z = this.moveToNextValue;
            String str5 = this.initRecordTimeStamp;
            String str6 = this.PrepareContext;
            String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            String str9 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            String str10 = this.readMicros;
            String str11 = this.getCallingPid;
            String str12 = this.SubSequence;
            int i = this.D;
            String str13 = this.getValueOfTouchPositionAbsolute;
            String str14 = this.scheduleImpl;
            String str15 = this.E;
            String str16 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str17 = this.A;
            List<String> list = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String str18 = this.getSupportButtonTintMode;
            return new ThirdPartyService(str, null, str2, str3, str4, z, str5, str6, str7, str8, str9, str10, str11, str12, this.GetContactSyncConfig, i, str13, str14, str15, str16, str17, list, str18, this.B, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.BottomSheetCardBindingView$watcherCardNumberView$1, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.VerifyPinStateManager$executeRiskChallenge$2$1, this.C, this.PlaceComponentResult, this.FragmentBottomSheetPaymentSettingBinding, 0, null, this.newProxyInstance, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.whenAvailable, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.DatabaseTableConfigUtil, null, this.MyBillsEntityDataFactory, -2147483646, DeepRecoverARiverProxy.TYPE_ENTITY_APP, null);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/model/ThirdPartyService$SpmId;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SpmId implements Parcelable {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String getAuthRequestContext;

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<SpmId> CREATOR = new Creator();

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public SpmId() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.model.ThirdPartyService.SpmId.<init>():void");
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeString(this.getAuthRequestContext);
        }

        public SpmId(String str, String str2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = str2;
        }

        public /* synthetic */ SpmId(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (Intrinsics.areEqual(getClass(), p0 != null ? p0.getClass() : null)) {
                if (p0 != null) {
                    SpmId spmId = (SpmId) p0;
                    return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, spmId.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, spmId.getAuthRequestContext);
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.model.ThirdPartyService.SpmId");
            }
            return false;
        }

        public final int hashCode() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.getAuthRequestContext;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/model/ThirdPartyService$SpmId$Companion;", "", "Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;", "p0", "Lid/dana/model/ThirdPartyService$SpmId;", "PlaceComponentResult", "(Lid/dana/data/config/source/sharedpreference/SpmIdEntityData;)Lid/dana/model/ThirdPartyService$SpmId;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static SpmId PlaceComponentResult(SpmIdEntityData p0) {
                if (p0 != null) {
                    return new SpmId(p0.getHome(), p0.getAll());
                }
                return null;
            }
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<SpmId> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SpmId createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new SpmId(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SpmId[] newArray(int i) {
                return new SpmId[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Lid/dana/model/ThirdPartyService$Companion;", "", "", "Lid/dana/data/config/source/sharedpreference/ThirdPartyServiceEntityData;", "p0", "", "Lid/dana/model/ThirdPartyService;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static List<ThirdPartyServiceEntityData> PlaceComponentResult(List<ThirdPartyService> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<ThirdPartyService> list = p0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ThirdPartyService.KClassImpl$Data$declaredNonStaticMembers$2((ThirdPartyService) it.next()));
            }
            return arrayList;
        }

        @JvmStatic
        public static List<ThirdPartyService> KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyServiceEntityData> p0) {
            if (p0 != null) {
                List<ThirdPartyServiceEntityData> list = p0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ThirdPartyServiceEntityData thirdPartyServiceEntityData : list) {
                    Companion companion = ThirdPartyService.INSTANCE;
                    Intrinsics.checkNotNullParameter(thirdPartyServiceEntityData, "");
                    String key = thirdPartyServiceEntityData.getKey();
                    String str = key == null ? "" : key;
                    String action = thirdPartyServiceEntityData.getAction();
                    String clientId = thirdPartyServiceEntityData.getClientId();
                    String appId = thirdPartyServiceEntityData.getAppId();
                    Boolean isEnable = thirdPartyServiceEntityData.getIsEnable();
                    boolean booleanValue = isEnable != null ? isEnable.booleanValue() : false;
                    String icon = thirdPartyServiceEntityData.getIcon();
                    String link = thirdPartyServiceEntityData.getLink();
                    String name = thirdPartyServiceEntityData.getName();
                    String nameInd = thirdPartyServiceEntityData.getNameInd();
                    String nameTag = thirdPartyServiceEntityData.getNameTag();
                    String operationType = thirdPartyServiceEntityData.getOperationType();
                    String redirectUrl = thirdPartyServiceEntityData.getRedirectUrl();
                    String scopes = thirdPartyServiceEntityData.getScopes();
                    Integer type = thirdPartyServiceEntityData.getType();
                    int intValue = type != null ? type.intValue() : 0;
                    String userAction = thirdPartyServiceEntityData.getUserAction();
                    String description = thirdPartyServiceEntityData.getDescription();
                    String subtitleColor = thirdPartyServiceEntityData.getSubtitleColor();
                    String buttonTitle = thirdPartyServiceEntityData.getButtonTitle();
                    String subtitleBorderColor = thirdPartyServiceEntityData.getSubtitleBorderColor();
                    List<String> keywords = thirdPartyServiceEntityData.getKeywords();
                    String ribbonText = thirdPartyServiceEntityData.getRibbonText();
                    Boolean isShowRedDot = thirdPartyServiceEntityData.getIsShowRedDot();
                    boolean booleanValue2 = isShowRedDot != null ? isShowRedDot.booleanValue() : false;
                    SpmId.Companion companion2 = SpmId.INSTANCE;
                    SpmId PlaceComponentResult = SpmId.Companion.PlaceComponentResult(thirdPartyServiceEntityData.getSpmId());
                    Boolean isFeatured = thirdPartyServiceEntityData.getIsFeatured();
                    boolean booleanValue3 = isFeatured != null ? isFeatured.booleanValue() : false;
                    Boolean needConsult = thirdPartyServiceEntityData.getNeedConsult();
                    boolean booleanValue4 = needConsult != null ? needConsult.booleanValue() : false;
                    List<String> spaceCodes = thirdPartyServiceEntityData.getSpaceCodes();
                    SkuAttributeModel.Companion companion3 = SkuAttributeModel.INSTANCE;
                    SkuAttributeModel KClassImpl$Data$declaredNonStaticMembers$2 = SkuAttributeModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyServiceEntityData.getSkuAttributeModel());
                    String screenOrientation = thirdPartyServiceEntityData.getScreenOrientation();
                    String bizType = thirdPartyServiceEntityData.getBizType();
                    String needOauth = thirdPartyServiceEntityData.getNeedOauth();
                    Boolean isBiller = thirdPartyServiceEntityData.getIsBiller();
                    boolean booleanValue5 = isBiller != null ? isBiller.booleanValue() : false;
                    int remainingDueDays = thirdPartyServiceEntityData.getRemainingDueDays();
                    String loanStatus = thirdPartyServiceEntityData.getLoanStatus();
                    Integer indexOfHighlighted = thirdPartyServiceEntityData.getIndexOfHighlighted();
                    Integer rotationDelayTime = thirdPartyServiceEntityData.getRotationDelayTime();
                    int intValue2 = rotationDelayTime != null ? rotationDelayTime.intValue() : 0;
                    BannerLottieModel.Companion companion4 = BannerLottieModel.INSTANCE;
                    arrayList.add(new ThirdPartyService(str, null, action, clientId, appId, booleanValue, icon, link, name, nameInd, nameTag, operationType, redirectUrl, scopes, booleanValue2, intValue, userAction, description, subtitleColor, buttonTitle, subtitleBorderColor, keywords, ribbonText, PlaceComponentResult, booleanValue3, KClassImpl$Data$declaredNonStaticMembers$2, booleanValue4, spaceCodes, screenOrientation, bizType, needOauth, remainingDueDays, loanStatus, indexOfHighlighted, booleanValue5, intValue2, null, BannerLottieModel.Companion.getAuthRequestContext(thirdPartyServiceEntityData.getBannerLottie()), thirdPartyServiceEntityData.getIconLottie(), thirdPartyServiceEntityData.getHeaderBackgroundColor(), null, thirdPartyServiceEntityData.getAlwaysConsult(), 2, LZMA_Base.kNumLenSymbols, null));
                }
                return arrayList;
            }
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ThirdPartyService> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ThirdPartyService createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ThirdPartyService(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() == 0 ? null : SpmId.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() == 0 ? null : SkuAttributeModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? BannerLottieModel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ThirdPartyService[] newArray(int i) {
            return new ThirdPartyService[i];
        }
    }

    public static final /* synthetic */ ThirdPartyServiceEntityData KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService thirdPartyService) {
        String str;
        String str2;
        SpmIdEntityData spmIdEntityData;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        SkuAttributeModelEntityData skuAttributeModelEntityData;
        String str9;
        BannerLottieEntityData bannerLottieEntityData;
        String str10 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str11 = thirdPartyService.newProxyInstance;
        String str12 = thirdPartyService.BuiltInFictitiousFunctionClassFactory;
        String str13 = thirdPartyService.moveToNextValue;
        String str14 = thirdPartyService.PlaceComponentResult;
        boolean z = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str15 = thirdPartyService.GetContactSyncConfig;
        String str16 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
        String str17 = thirdPartyService.FragmentBottomSheetPaymentSettingBinding;
        String str18 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda3;
        String str19 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str20 = thirdPartyService.whenAvailable;
        String str21 = thirdPartyService.getCallingPid;
        String str22 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$1;
        boolean z2 = thirdPartyService.isLayoutRequested;
        int i = thirdPartyService.D;
        String str23 = thirdPartyService.AppCompatEmojiTextHelper;
        String str24 = thirdPartyService.lookAheadTest;
        String str25 = thirdPartyService.getValueOfTouchPositionAbsolute;
        String str26 = thirdPartyService.getErrorConfigVersion;
        String str27 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$2;
        List<String> list = thirdPartyService.PrepareContext;
        String str28 = thirdPartyService.B;
        SpmId spmId = thirdPartyService.E;
        if (spmId != null) {
            str2 = str28;
            str = str20;
            spmIdEntityData = new SpmIdEntityData(spmId.KClassImpl$Data$declaredNonStaticMembers$2, spmId.getAuthRequestContext);
        } else {
            str = str20;
            str2 = str28;
            spmIdEntityData = null;
        }
        boolean z3 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda7;
        SkuAttributeModel skuAttributeModel = thirdPartyService.A;
        if (skuAttributeModel != null) {
            str8 = str19;
            str7 = str18;
            str6 = str17;
            str5 = str16;
            str4 = str15;
            str3 = str14;
            skuAttributeModelEntityData = new SkuAttributeModelEntityData(skuAttributeModel.NetworkUserEntityData$$ExternalSyntheticLambda0, skuAttributeModel.BuiltInFictitiousFunctionClassFactory, skuAttributeModel.getAuthRequestContext, skuAttributeModel.KClassImpl$Data$declaredNonStaticMembers$2, skuAttributeModel.lookAheadTest, skuAttributeModel.PlaceComponentResult, skuAttributeModel.MyBillsEntityDataFactory, skuAttributeModel.getErrorConfigVersion);
        } else {
            str3 = str14;
            str4 = str15;
            str5 = str16;
            str6 = str17;
            str7 = str18;
            str8 = str19;
            skuAttributeModelEntityData = null;
        }
        boolean z4 = thirdPartyService.SubSequence;
        List<String> list2 = thirdPartyService.getOnBoardingScenario;
        String str29 = thirdPartyService.C;
        String str30 = thirdPartyService.MyBillsEntityDataFactory;
        String str31 = thirdPartyService.getSupportButtonTintMode;
        Integer num = thirdPartyService.initRecordTimeStamp;
        boolean z5 = thirdPartyService.DatabaseTableConfigUtil;
        int i2 = thirdPartyService.readMicros;
        String str32 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i3 = thirdPartyService.BottomSheetCardBindingView$watcherCardNumberView$1;
        BannerLottieModel bannerLottieModel = thirdPartyService.getAuthRequestContext;
        if (bannerLottieModel != null) {
            str9 = str30;
            bannerLottieEntityData = new BannerLottieEntityData(bannerLottieModel.getAuthRequestContext, bannerLottieModel.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            str9 = str30;
            bannerLottieEntityData = null;
        }
        return new ThirdPartyServiceEntityData(str10, str11, str12, str13, str3, Boolean.valueOf(z), str4, str5, str6, str7, str8, str, str21, str22, Boolean.valueOf(z2), Integer.valueOf(i), str23, str24, str25, str26, str27, list, str2, spmIdEntityData, Boolean.valueOf(z3), skuAttributeModelEntityData, Boolean.valueOf(z4), list2, str29, str9, str31, num, Boolean.valueOf(z5), i2, str32, Integer.valueOf(i3), bannerLottieEntityData, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda2, thirdPartyService.scheduleImpl, thirdPartyService.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static /* synthetic */ ThirdPartyService getAuthRequestContext(ThirdPartyService thirdPartyService, String str) {
        String str2 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8;
        String str3 = thirdPartyService.newProxyInstance;
        String str4 = thirdPartyService.BuiltInFictitiousFunctionClassFactory;
        String str5 = thirdPartyService.moveToNextValue;
        String str6 = thirdPartyService.PlaceComponentResult;
        boolean z = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str7 = thirdPartyService.GetContactSyncConfig;
        String str8 = thirdPartyService.FragmentBottomSheetPaymentSettingBinding;
        String str9 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda3;
        String str10 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str11 = thirdPartyService.whenAvailable;
        String str12 = thirdPartyService.getCallingPid;
        String str13 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$1;
        boolean z2 = thirdPartyService.isLayoutRequested;
        int i = thirdPartyService.D;
        String str14 = thirdPartyService.AppCompatEmojiTextHelper;
        String str15 = thirdPartyService.lookAheadTest;
        String str16 = thirdPartyService.getValueOfTouchPositionAbsolute;
        String str17 = thirdPartyService.getErrorConfigVersion;
        String str18 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$2;
        List<String> list = thirdPartyService.PrepareContext;
        String str19 = thirdPartyService.B;
        SpmId spmId = thirdPartyService.E;
        boolean z3 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda7;
        SkuAttributeModel skuAttributeModel = thirdPartyService.A;
        boolean z4 = thirdPartyService.SubSequence;
        List<String> list2 = thirdPartyService.getOnBoardingScenario;
        String str20 = thirdPartyService.C;
        String str21 = thirdPartyService.MyBillsEntityDataFactory;
        String str22 = thirdPartyService.getSupportButtonTintMode;
        int i2 = thirdPartyService.readMicros;
        String str23 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda5;
        Integer num = thirdPartyService.initRecordTimeStamp;
        boolean z5 = thirdPartyService.DatabaseTableConfigUtil;
        int i3 = thirdPartyService.BottomSheetCardBindingView$watcherCardNumberView$1;
        String str24 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0;
        BannerLottieModel bannerLottieModel = thirdPartyService.getAuthRequestContext;
        String str25 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str26 = thirdPartyService.scheduleImpl;
        String str27 = thirdPartyService.F;
        boolean z6 = thirdPartyService.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str27, "");
        return new ThirdPartyService(str2, str3, str4, str5, str6, z, str7, str, str8, str9, str10, str11, str12, str13, z2, i, str14, str15, str16, str17, str18, list, str19, spmId, z3, skuAttributeModel, z4, list2, str20, str21, str22, i2, str23, num, z5, i3, str24, bannerLottieModel, str25, str26, str27, z6);
    }
}
