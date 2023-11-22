package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b<\u0018\u00002\u00020\u0001BÙ\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010S\u001a\u00020\u000b\u0012\b\b\u0002\u0010T\u001a\u00020\u000b\u0012\b\b\u0002\u0010U\u001a\u00020\u000b\u0012\b\b\u0002\u0010V\u001a\u00020\u000b\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010[\u001a\u00020\u0005\u0012\b\b\u0002\u0010\\\u001a\u00020\u0005\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010^\u001a\u00020\u000b\u0012\b\b\u0002\u0010_\u001a\u00020\u000b\u0012\b\b\u0002\u0010`\u001a\u00020\u000b\u0012\b\b\u0002\u0010a\u001a\u00020\u000b\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010i\u001a\u00020\u000b\u0012\b\b\u0002\u0010j\u001a\u00020\u000b\u0012\b\b\u0002\u0010k\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010l\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u000109\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010p\u001a\u00020\u0005\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010t\u001a\u00020\u0005\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010y\u001a\u00020\u0005\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010}\u001a\u00020\u000b\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u000b\u0012\u0011\b\u0002\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109\u0012\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0018\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000b\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\b\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\u000eJ \u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0014\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\b\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0012\u0010\t\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0012\u0010\u0017\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0012\u0010\u0019\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0012\u0010\u001e\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0013R\u001a\u0010 \u001a\u00020\u00058\u0007X\u0086\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010!\u001a\u00020\u00058\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001f\u0010\"\u001a\u0004\b\u0014\u0010\u0007R\u0014\u0010$\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u001a\u0010#\u001a\u00020\u00058\u0007X\u0087\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010&\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u001a\u0010'\u001a\u00020\u00058\u0007X\u0087\u0006¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b\u0016\u0010\u0007R\u0012\u0010%\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0014\u0010)\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0014\u0010*\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0014\u0010+\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010\u0013R\u0012\u0010(\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010\"R\u0012\u0010,\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0012\u0010.\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b-\u0010\u0013R\u0014\u00100\u001a\u0004\u0018\u00010/X\u0087\u0002¢\u0006\u0006\n\u0004\b0\u00101R\u0012\u00102\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010\u0013R\u0014\u00103\u001a\u0004\u0018\u00010\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010\u001aR\u0014\u0010-\u001a\u0004\u0018\u00010/X\u0087\u0002¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00105\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b4\u0010\u0013R\u0012\u00107\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b6\u0010\u0013R\u0012\u00104\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b8\u0010\u0013R\u0012\u00106\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b7\u0010\u0013R\u001a\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0087\u0002¢\u0006\u0006\n\u0004\b5\u0010;R\u0014\u0010=\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b<\u0010\u0013R\u0014\u0010<\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b=\u0010\u0013R\u0014\u0010>\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b>\u0010\u0013R\u0014\u0010B\u001a\u0004\u0018\u00010?X\u0087\u0002¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010@\u001a\u0004\u0018\u00010\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\bB\u0010\u001aR\u001a\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u000109X\u0087\u0002¢\u0006\u0006\n\u0004\bC\u0010;R\u0014\u0010H\u001a\u0004\u0018\u00010EX\u0087\u0002¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010F\u001a\u0004\u0018\u00010IX\u0087\u0002¢\u0006\u0006\n\u0004\bH\u0010JR\u0014\u0010C\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bK\u0010\u0013R\u0014\u0010K\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bD\u0010\u0013R\u0014\u0010M\u001a\u0004\u0018\u00010\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\bL\u0010\u001aR\u0014\u0010L\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bN\u0010\u0013R\u0012\u0010P\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bO\u0010\u0013R\u0014\u0010N\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bP\u0010\u0013R\u0014\u0010O\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\bM\u0010\u0013R\u0014\u0010R\u001a\u0004\u0018\u00010/X\u0087\u0002¢\u0006\u0006\n\u0004\bQ\u00101"}, d2 = {"Lid/dana/cashier/model/PayResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "moveToNextValue", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "", "p0", "", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "p1", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/Boolean;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getSupportButtonTintMode", "readMicros", "", "getCallingPid", "Ljava/lang/Long;", "SubSequence", "whenAvailable", DiskFormatter.B, "VerifyPinStateManager$executeRiskChallenge$2$1", "A", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "", "Lid/dana/cashier/model/CashierPayChannelModel;", "Ljava/util/List;", "getValueOfTouchPositionAbsolute", SummaryActivity.DAYS, "VerifyPinStateManager$executeRiskChallenge$2$2", "Lid/dana/cashier/model/RepaymentPlanModel;", "getOnBoardingScenario", "Lid/dana/cashier/model/RepaymentPlanModel;", "E", SummaryActivity.HOURS, DiskFormatter.GB, "Lid/dana/cashier/model/VoucherCashierModel;", "I", "Lid/dana/cashier/model/VoucherCashierModel;", LogConstants.RESULT_FALSE, "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "AppCompatEmojiTextHelper", DiskFormatter.MB, DiskFormatter.KB, "L", "getNameOrBuilderList", "J", "N", "P", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "p36", "p37", "p38", "p39", "p40", "p41", "p42", "p43", "p44", "p45", "p46", "p47", "p48", "p49", "p50", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/VoucherCashierModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/RepaymentPlanModel;Ljava/lang/Boolean;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZLid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/Long;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayResultModel implements Parcelable {
    public static final Parcelable.Creator<PayResultModel> CREATOR = new Creator();

    /* renamed from: A  reason: from kotlin metadata */
    public String BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    public String H;

    /* renamed from: B  reason: from kotlin metadata */
    public String VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public String A;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: C  reason: from kotlin metadata */
    public String B;

    /* renamed from: D  reason: from kotlin metadata */
    public String getValueOfTouchPositionAbsolute;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public boolean initRecordTimeStamp;

    /* renamed from: E  reason: from kotlin metadata */
    public MoneyViewModel getOnBoardingScenario;

    /* renamed from: F  reason: from kotlin metadata */
    public CashierPayMethodModel I;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: G  reason: from kotlin metadata */
    public String AppCompatEmojiTextHelper;
    public String GetContactSyncConfig;

    /* renamed from: H  reason: from kotlin metadata */
    public List<String> G;

    /* renamed from: I  reason: from kotlin metadata */
    public VoucherCashierModel F;

    /* renamed from: J  reason: from kotlin metadata */
    public String L;

    /* renamed from: K  reason: from kotlin metadata */
    public String getNameOrBuilderList;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: L  reason: from kotlin metadata */
    public String M;

    /* renamed from: M  reason: from kotlin metadata */
    public MoneyViewModel K;
    public String MyBillsEntityDataFactory;

    /* renamed from: N  reason: from kotlin metadata */
    public Long P;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public boolean DatabaseTableConfigUtil;
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public Boolean isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public Long getSupportButtonTintMode;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    public List<CashierPayChannelModel> C;
    public String VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    public Long getCallingPid;
    public String getErrorConfigVersion;

    /* renamed from: getNameOrBuilderList  reason: from kotlin metadata */
    public String J;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    public RepaymentPlanModel E;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    public String readMicros;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    public String D;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Boolean moveToNextValue;
    public boolean newProxyInstance;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public String SubSequence;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String lookAheadTest;
    public MoneyViewModel whenAvailable;

    public PayResultModel() {
        this(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getValueOfTouchPositionAbsolute);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        p0.writeString(this.readMicros);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda6 ? 1 : 0);
        p0.writeInt(this.newProxyInstance ? 1 : 0);
        p0.writeString(this.AppCompatEmojiTextHelper);
        p0.writeString(this.SubSequence);
        p0.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.writeString(this.A);
        p0.writeString(this.B);
        p0.writeString(this.M);
        Boolean bool = this.isLayoutRequested;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.L);
        p0.writeString(this.getAuthRequestContext);
        VoucherCashierModel voucherCashierModel = this.F;
        if (voucherCashierModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            voucherCashierModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.J);
        p0.writeStringList(this.G);
        p0.writeParcelable(this.I, p1);
        RepaymentPlanModel repaymentPlanModel = this.E;
        if (repaymentPlanModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            repaymentPlanModel.writeToParcel(p0, p1);
        }
        Boolean bool2 = this.moveToNextValue;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda7 ? 1 : 0);
        Long l = this.getCallingPid;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        Long l2 = this.getSupportButtonTintMode;
        if (l2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l2.longValue());
        }
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        p0.writeInt(this.initRecordTimeStamp ? 1 : 0);
        MoneyViewModel moneyViewModel = this.getOnBoardingScenario;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.D);
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeInt(this.DatabaseTableConfigUtil ? 1 : 0);
        MoneyViewModel moneyViewModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        Long l3 = this.P;
        if (l3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l3.longValue());
        }
        MoneyViewModel moneyViewModel3 = this.K;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel3.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.H);
        List<CashierPayChannelModel> list = this.C;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<CashierPayChannelModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        MoneyViewModel moneyViewModel4 = this.whenAvailable;
        if (moneyViewModel4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel4.writeToParcel(p0, p1);
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.getNameOrBuilderList);
    }

    public PayResultModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, String str11, String str12, String str13, String str14, String str15, String str16, Boolean bool, String str17, String str18, String str19, String str20, VoucherCashierModel voucherCashierModel, String str21, String str22, String str23, List<String> list, CashierPayMethodModel cashierPayMethodModel, RepaymentPlanModel repaymentPlanModel, Boolean bool2, boolean z3, Long l, Long l2, String str24, boolean z4, MoneyViewModel moneyViewModel, String str25, String str26, String str27, boolean z5, MoneyViewModel moneyViewModel2, Long l3, MoneyViewModel moneyViewModel3, String str28, String str29, String str30, List<CashierPayChannelModel> list2, MoneyViewModel moneyViewModel4, String str31, String str32) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str21, "");
        Intrinsics.checkNotNullParameter(str22, "");
        Intrinsics.checkNotNullParameter(str23, "");
        Intrinsics.checkNotNullParameter(str28, "");
        this.getValueOfTouchPositionAbsolute = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getErrorConfigVersion = str3;
        this.PrepareContext = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str5;
        this.readMicros = str6;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
        this.newProxyInstance = z2;
        this.AppCompatEmojiTextHelper = str11;
        this.SubSequence = str12;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str13;
        this.A = str14;
        this.B = str15;
        this.M = str16;
        this.isLayoutRequested = bool;
        this.GetContactSyncConfig = str17;
        this.scheduleImpl = str18;
        this.L = str19;
        this.getAuthRequestContext = str20;
        this.F = voucherCashierModel;
        this.PlaceComponentResult = str21;
        this.lookAheadTest = str22;
        this.J = str23;
        this.G = list;
        this.I = cashierPayMethodModel;
        this.E = repaymentPlanModel;
        this.moveToNextValue = bool2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z3;
        this.getCallingPid = l;
        this.getSupportButtonTintMode = l2;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str24;
        this.initRecordTimeStamp = z4;
        this.getOnBoardingScenario = moneyViewModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str25;
        this.D = str26;
        this.FragmentBottomSheetPaymentSettingBinding = str27;
        this.DatabaseTableConfigUtil = z5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = moneyViewModel2;
        this.P = l3;
        this.K = moneyViewModel3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str28;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str29;
        this.H = str30;
        this.C = list2;
        this.whenAvailable = moneyViewModel4;
        this.MyBillsEntityDataFactory = str31;
        this.getNameOrBuilderList = str32;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getNewProxyInstance() {
        return this.newProxyInstance;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ PayResultModel(java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, boolean r63, boolean r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.Boolean r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, java.lang.String r75, id.dana.cashier.model.VoucherCashierModel r76, java.lang.String r77, java.lang.String r78, java.lang.String r79, java.util.List r80, id.dana.cashier.model.CashierPayMethodModel r81, id.dana.cashier.model.RepaymentPlanModel r82, java.lang.Boolean r83, boolean r84, java.lang.Long r85, java.lang.Long r86, java.lang.String r87, boolean r88, id.dana.nearbyme.merchantdetail.model.MoneyViewModel r89, java.lang.String r90, java.lang.String r91, java.lang.String r92, boolean r93, id.dana.nearbyme.merchantdetail.model.MoneyViewModel r94, java.lang.Long r95, id.dana.nearbyme.merchantdetail.model.MoneyViewModel r96, java.lang.String r97, java.lang.String r98, java.lang.String r99, java.util.List r100, id.dana.nearbyme.merchantdetail.model.MoneyViewModel r101, java.lang.String r102, java.lang.String r103, int r104, int r105, kotlin.jvm.internal.DefaultConstructorMarker r106) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.PayResultModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, id.dana.cashier.model.VoucherCashierModel, java.lang.String, java.lang.String, java.lang.String, java.util.List, id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.RepaymentPlanModel, java.lang.Boolean, boolean, java.lang.Long, java.lang.Long, java.lang.String, boolean, id.dana.nearbyme.merchantdetail.model.MoneyViewModel, java.lang.String, java.lang.String, java.lang.String, boolean, id.dana.nearbyme.merchantdetail.model.MoneyViewModel, java.lang.Long, id.dana.nearbyme.merchantdetail.model.MoneyViewModel, java.lang.String, java.lang.String, java.lang.String, java.util.List, id.dana.nearbyme.merchantdetail.model.MoneyViewModel, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getErrorConfigVersion")
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getInitRecordTimeStamp() {
        return this.initRecordTimeStamp;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String str = p0;
        if (str == null || str.length() == 0) {
            return;
        }
        this.AppCompatEmojiTextHelper = p0;
    }

    public final boolean moveToNextValue() {
        MoneyViewModel moneyViewModel = this.K;
        String str = moneyViewModel != null ? moneyViewModel.PlaceComponentResult : null;
        return !(str == null || str.length() == 0);
    }

    public final boolean scheduleImpl() {
        CashierPayMethodModel cashierPayMethodModel = this.I;
        if (cashierPayMethodModel != null) {
            return CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda8(cashierPayMethodModel);
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.F == null && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) ? false : true;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        String str = this.AppCompatEmojiTextHelper;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
                return z && !Intrinsics.areEqual(this.AppCompatEmojiTextHelper, "0");
            }
        }
        z = false;
        if (z) {
            return false;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PayResultModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PayResultModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            ArrayList arrayList;
            String str;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString17 = parcel.readString();
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            String readString20 = parcel.readString();
            VoucherCashierModel createFromParcel = parcel.readInt() == 0 ? null : VoucherCashierModel.CREATOR.createFromParcel(parcel);
            String readString21 = parcel.readString();
            String readString22 = parcel.readString();
            String readString23 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) parcel.readParcelable(PayResultModel.class.getClassLoader());
            RepaymentPlanModel createFromParcel2 = parcel.readInt() == 0 ? null : RepaymentPlanModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            boolean z3 = parcel.readInt() != 0;
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString24 = parcel.readString();
            boolean z4 = parcel.readInt() != 0;
            MoneyViewModel createFromParcel3 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString25 = parcel.readString();
            String readString26 = parcel.readString();
            String readString27 = parcel.readString();
            boolean z5 = parcel.readInt() != 0;
            MoneyViewModel createFromParcel4 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            MoneyViewModel createFromParcel5 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString28 = parcel.readString();
            String readString29 = parcel.readString();
            String readString30 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = readString11;
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                str = readString11;
                int i = 0;
                while (i != readInt) {
                    arrayList.add(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
                    i++;
                    readInt = readInt;
                }
            }
            return new PayResultModel(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, z, z2, str, readString12, readString13, readString14, readString15, readString16, valueOf, readString17, readString18, readString19, readString20, createFromParcel, readString21, readString22, readString23, createStringArrayList, cashierPayMethodModel, createFromParcel2, valueOf2, z3, valueOf3, valueOf4, readString24, z4, createFromParcel3, readString25, readString26, readString27, z5, createFromParcel4, valueOf5, createFromParcel5, readString28, readString29, readString30, arrayList, parcel.readInt() != 0 ? MoneyViewModel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PayResultModel[] newArray(int i) {
            return new PayResultModel[i];
        }
    }
}
