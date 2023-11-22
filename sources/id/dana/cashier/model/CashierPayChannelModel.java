package id.dana.cashier.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.domain.payasset.model.Institution;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.model.PayMethodRiskModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001b\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010\u001b\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010%\u0012\u000e\b\u0002\u0010z\u001a\b\u0012\u0004\u0012\u00020N0\u001b\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010A\u0012\u0010\b\u0002\u0010}\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010~\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u001eX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\r\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b#\u0010 R\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u001eX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0013\u0010$\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b$\u0010 R\u0013\u0010(\u001a\u0004\u0018\u00010%X\u0006¢\u0006\u0006\n\u0004\b&\u0010'R\u0013\u0010*\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b)\u0010!R\u0013\u0010+\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b(\u0010 R\u0013\u0010&\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b*\u0010 R\u0013\u0010)\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b+\u0010!R\u0013\u0010/\u001a\u0004\u0018\u00010,X\u0006¢\u0006\u0006\n\u0004\b-\u0010.R\u0013\u00101\u001a\u0004\u0018\u00010\u001eX\u0006¢\u0006\u0006\n\u0004\b0\u0010\u001fR\u0013\u00100\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b2\u0010 R\u0013\u00102\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b1\u0010 R\u0013\u0010-\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b/\u0010 R\u0013\u00104\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b3\u0010!R\u0013\u00103\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b5\u0010!R\u001a\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u001bX\u0086\u0002¢\u0006\u0006\n\u0004\b4\u0010\u001dR\u0013\u00108\u001a\u0004\u0018\u000107X\u0006¢\u0006\u0006\n\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b:\u0010;R\u0013\u0010=\u001a\u0004\u0018\u000107X\u0006¢\u0006\u0006\n\u0004\b<\u00109R\u0013\u0010?\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b>\u0010 R\u0013\u0010@\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b?\u0010 R\u0013\u0010>\u001a\u0004\u0018\u00010AX\u0006¢\u0006\u0006\n\u0004\b@\u0010BR\u0013\u0010<\u001a\u0004\u0018\u00010CX\u0006¢\u0006\u0006\n\u0004\b=\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bE\u0010 R\u0013\u0010I\u001a\u0004\u0018\u00010FX\u0006¢\u0006\u0006\n\u0004\bG\u0010HR\u0013\u0010J\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bI\u0010 R\u0013\u0010G\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\bK\u0010!R\u0013\u0010K\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bJ\u0010 R\u0013\u0010M\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\bL\u0010!R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020N0\u001bX\u0006¢\u0006\u0006\n\u0004\bO\u0010\u001dR\u0013\u0010O\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bM\u0010 R\u0013\u0010Q\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bP\u0010 R\u0013\u0010L\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bQ\u0010 R\u0019\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\bR\u0010\u001dR\u0013\u0010T\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\bT\u0010 R\u0019\u0010R\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010\u001bX\u0006¢\u0006\u0006\n\u0004\bV\u0010\u001d"}, d2 = {"Lid/dana/cashier/model/CashierPayChannelModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "PlaceComponentResult", "()Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "lookAheadTest", "scheduleImpl", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lid/dana/cashier/model/AddOnChannelSupportInfo;", "Ljava/util/List;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Ljava/lang/String;", "Ljava/lang/Boolean;", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cashier/model/DanaCreditModel;", "DatabaseTableConfigUtil", "Lid/dana/cashier/model/DanaCreditModel;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/cashier/model/ExtendCashierModel;", "isLayoutRequested", "Lid/dana/cashier/model/ExtendCashierModel;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/cashier/model/LoanCreditChannelInfoModel;", "Lid/dana/model/CurrencyAmountModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/model/CurrencyAmountModel;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Ljava/lang/Integer;", "readMicros", "getCallingPid", "getSupportButtonTintMode", "whenAvailable", "SubSequence", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "Lid/dana/data/config/model/PayLaterMethodConfig;", "Lid/dana/data/config/model/PayLaterMethodConfig;", DiskFormatter.B, "Lid/dana/sendmoney/model/PayMethodRiskModel;", "A", "Lid/dana/sendmoney/model/PayMethodRiskModel;", "VerifyPinStateManager$executeRiskChallenge$2$1", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "VerifyPinStateManager$executeRiskChallenge$2$2", SummaryActivity.DAYS, "Lid/dana/cashier/model/RepaymentPlanModel;", "E", "getValueOfTouchPositionAbsolute", "getOnBoardingScenario", "I", LogConstants.RESULT_FALSE, "AppCompatEmojiTextHelper", "Lid/dana/cashier/model/VoucherCashierModel;", SummaryActivity.HOURS, "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "p36", "p37", "p38", "p39", "p40", "p41", "p42", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/model/ExtendCashierModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/model/PayMethodRiskModel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/DanaCreditModel;Ljava/util/List;Lid/dana/data/config/model/PayLaterMethodConfig;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;Ljava/util/List;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CashierPayChannelModel implements Parcelable {
    public static final Parcelable.Creator<CashierPayChannelModel> CREATOR = new Creator();

    /* renamed from: A  reason: from kotlin metadata */
    public final PayMethodRiskModel VerifyPinStateManager$executeRiskChallenge$2$1;
    public final String AppCompatEmojiTextHelper;
    public final String B;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public final String C;
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: C  reason: from kotlin metadata */
    public final Boolean A;

    /* renamed from: D */
    public final String E;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final DanaCreditModel initRecordTimeStamp;

    /* renamed from: E  reason: from kotlin metadata */
    public final List<RepaymentPlanModel> getValueOfTouchPositionAbsolute;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: H */
    public final List<VoucherCashierModel> I;

    /* renamed from: I  reason: from kotlin metadata */
    final List<String> com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String;
    public List<AddOnChannelSupportInfo> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final Boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    final Boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    List<LoanCreditChannelInfoModel> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public final Boolean FragmentBottomSheetPaymentSettingBinding;
    public final CurrencyAmountModel NetworkUserEntityData$$ExternalSyntheticLambda5;
    public final Integer NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final String PrepareContext;
    public final MoneyViewModel PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public final PaylaterCicilMethodConfig getSupportButtonTintMode;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    public final String BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    public final Boolean id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    final PayLaterMethodConfig readMicros;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final MoneyViewModel lookAheadTest;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    public final String VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    public final String whenAvailable;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    public final String getOnBoardingScenario;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final ExtendCashierModel newProxyInstance;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final List<String> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String isLayoutRequested;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public final CurrencyAmountModel getCallingPid;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Boolean getErrorConfigVersion;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    final String SubSequence;

    public CashierPayChannelModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2047, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierPayChannelModel) {
            CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierPayChannelModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, cashierPayChannelModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, cashierPayChannelModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, cashierPayChannelModel.lookAheadTest) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierPayChannelModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, cashierPayChannelModel.getErrorConfigVersion) && Intrinsics.areEqual(this.scheduleImpl, cashierPayChannelModel.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, cashierPayChannelModel.moveToNextValue) && Intrinsics.areEqual(this.GetContactSyncConfig, cashierPayChannelModel.GetContactSyncConfig) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, cashierPayChannelModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.newProxyInstance, cashierPayChannelModel.newProxyInstance) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.PrepareContext, cashierPayChannelModel.PrepareContext) && Intrinsics.areEqual(this.isLayoutRequested, cashierPayChannelModel.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda3, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda3) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.whenAvailable, cashierPayChannelModel.whenAvailable) && Intrinsics.areEqual(this.B, cashierPayChannelModel.B) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$1, cashierPayChannelModel.VerifyPinStateManager$executeRiskChallenge$2$1) && Intrinsics.areEqual(this.C, cashierPayChannelModel.C) && Intrinsics.areEqual(this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String, cashierPayChannelModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String) && Intrinsics.areEqual(this.getOnBoardingScenario, cashierPayChannelModel.getOnBoardingScenario) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$2, cashierPayChannelModel.VerifyPinStateManager$executeRiskChallenge$2$2) && Intrinsics.areEqual(this.AppCompatEmojiTextHelper, cashierPayChannelModel.AppCompatEmojiTextHelper) && Intrinsics.areEqual(this.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String, cashierPayChannelModel.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String) && Intrinsics.areEqual(this.I, cashierPayChannelModel.I) && Intrinsics.areEqual(this.A, cashierPayChannelModel.A) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda5) && Intrinsics.areEqual(this.getCallingPid, cashierPayChannelModel.getCallingPid) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, cashierPayChannelModel.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.SubSequence, cashierPayChannelModel.SubSequence) && Intrinsics.areEqual(this.BottomSheetCardBindingView$watcherCardNumberView$1, cashierPayChannelModel.BottomSheetCardBindingView$watcherCardNumberView$1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.E, cashierPayChannelModel.E) && Intrinsics.areEqual(this.initRecordTimeStamp, cashierPayChannelModel.initRecordTimeStamp) && Intrinsics.areEqual(this.getValueOfTouchPositionAbsolute, cashierPayChannelModel.getValueOfTouchPositionAbsolute) && Intrinsics.areEqual(this.readMicros, cashierPayChannelModel.readMicros) && Intrinsics.areEqual(this.getSupportButtonTintMode, cashierPayChannelModel.getSupportButtonTintMode) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierPayChannelModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, cashierPayChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyViewModel moneyViewModel = this.PlaceComponentResult;
        int hashCode3 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.lookAheadTest;
        int hashCode4 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.getErrorConfigVersion;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str4 = this.scheduleImpl;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        List<String> list = this.moveToNextValue;
        int hashCode8 = list == null ? 0 : list.hashCode();
        Boolean bool2 = this.GetContactSyncConfig;
        int hashCode9 = bool2 == null ? 0 : bool2.hashCode();
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.DatabaseTableConfigUtil;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        Boolean bool3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode12 = bool3 == null ? 0 : bool3.hashCode();
        ExtendCashierModel extendCashierModel = this.newProxyInstance;
        int hashCode13 = extendCashierModel == null ? 0 : extendCashierModel.hashCode();
        String str7 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.PrepareContext;
        int hashCode15 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.isLayoutRequested;
        int hashCode16 = str9 == null ? 0 : str9.hashCode();
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int hashCode17 = bool4 == null ? 0 : bool4.hashCode();
        Integer num = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int hashCode18 = num == null ? 0 : num.hashCode();
        String str10 = this.whenAvailable;
        int hashCode19 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.B;
        int hashCode20 = str11 == null ? 0 : str11.hashCode();
        PayMethodRiskModel payMethodRiskModel = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        int hashCode21 = payMethodRiskModel == null ? 0 : payMethodRiskModel.hashCode();
        String str12 = this.C;
        int hashCode22 = str12 == null ? 0 : str12.hashCode();
        Boolean bool5 = this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
        int hashCode23 = bool5 == null ? 0 : bool5.hashCode();
        String str13 = this.getOnBoardingScenario;
        int hashCode24 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        int hashCode25 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.AppCompatEmojiTextHelper;
        int hashCode26 = str15 == null ? 0 : str15.hashCode();
        List<String> list2 = this.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String;
        int hashCode27 = list2 == null ? 0 : list2.hashCode();
        List<VoucherCashierModel> list3 = this.I;
        int hashCode28 = list3 == null ? 0 : list3.hashCode();
        Boolean bool6 = this.A;
        int hashCode29 = bool6 == null ? 0 : bool6.hashCode();
        CurrencyAmountModel currencyAmountModel = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int hashCode30 = currencyAmountModel == null ? 0 : currencyAmountModel.hashCode();
        CurrencyAmountModel currencyAmountModel2 = this.getCallingPid;
        int hashCode31 = currencyAmountModel2 == null ? 0 : currencyAmountModel2.hashCode();
        Boolean bool7 = this.FragmentBottomSheetPaymentSettingBinding;
        int hashCode32 = bool7 == null ? 0 : bool7.hashCode();
        String str16 = this.SubSequence;
        int hashCode33 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        int hashCode34 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode35 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.E;
        int hashCode36 = str19 == null ? 0 : str19.hashCode();
        DanaCreditModel danaCreditModel = this.initRecordTimeStamp;
        int hashCode37 = danaCreditModel == null ? 0 : danaCreditModel.hashCode();
        int hashCode38 = this.getValueOfTouchPositionAbsolute.hashCode();
        PayLaterMethodConfig payLaterMethodConfig = this.readMicros;
        int hashCode39 = payLaterMethodConfig == null ? 0 : payLaterMethodConfig.hashCode();
        PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.getSupportButtonTintMode;
        int hashCode40 = paylaterCicilMethodConfig == null ? 0 : paylaterCicilMethodConfig.hashCode();
        List<AddOnChannelSupportInfo> list4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode41 = list4 == null ? 0 : list4.hashCode();
        List<LoanCreditChannelInfoModel> list5 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int hashCode42 = list5 == null ? 0 : list5.hashCode();
        MoneyViewModel moneyViewModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + hashCode42) * 31) + (moneyViewModel3 != null ? moneyViewModel3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayChannelModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", whenAvailable=");
        sb.append(this.whenAvailable);
        sb.append(", B=");
        sb.append(this.B);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$1=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        sb.append(", C=");
        sb.append(this.C);
        sb.append(", D=");
        sb.append(this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String);
        sb.append(", getOnBoardingScenario=");
        sb.append(this.getOnBoardingScenario);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$2=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        sb.append(", AppCompatEmojiTextHelper=");
        sb.append(this.AppCompatEmojiTextHelper);
        sb.append(", F=");
        sb.append(this.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String);
        sb.append(", I=");
        sb.append(this.I);
        sb.append(", A=");
        sb.append(this.A);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda5=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        sb.append(", getCallingPid=");
        sb.append(this.getCallingPid);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", SubSequence=");
        sb.append(this.SubSequence);
        sb.append(", BottomSheetCardBindingView$watcherCardNumberView$1=");
        sb.append(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", E=");
        sb.append(this.E);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", getValueOfTouchPositionAbsolute=");
        sb.append(this.getValueOfTouchPositionAbsolute);
        sb.append(", readMicros=");
        sb.append(this.readMicros);
        sb.append(", getSupportButtonTintMode=");
        sb.append(this.getSupportButtonTintMode);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        MoneyViewModel moneyViewModel = this.PlaceComponentResult;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel2 = this.lookAheadTest;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        Boolean bool = this.getErrorConfigVersion;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.scheduleImpl);
        p0.writeStringList(this.moveToNextValue);
        Boolean bool2 = this.GetContactSyncConfig;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.DatabaseTableConfigUtil);
        Boolean bool3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bool3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        ExtendCashierModel extendCashierModel = this.newProxyInstance;
        if (extendCashierModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            extendCashierModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.isLayoutRequested);
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (bool4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Integer num = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        p0.writeString(this.whenAvailable);
        p0.writeString(this.B);
        p0.writeParcelable(this.VerifyPinStateManager$executeRiskChallenge$2$1, p1);
        p0.writeString(this.C);
        Boolean bool5 = this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
        if (bool5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getOnBoardingScenario);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        p0.writeString(this.AppCompatEmojiTextHelper);
        p0.writeStringList(this.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String);
        List<VoucherCashierModel> list = this.I;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<VoucherCashierModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        Boolean bool6 = this.A;
        if (bool6 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        p0.writeParcelable(this.NetworkUserEntityData$$ExternalSyntheticLambda5, p1);
        p0.writeParcelable(this.getCallingPid, p1);
        Boolean bool7 = this.FragmentBottomSheetPaymentSettingBinding;
        if (bool7 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.SubSequence);
        p0.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.E);
        DanaCreditModel danaCreditModel = this.initRecordTimeStamp;
        if (danaCreditModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            danaCreditModel.writeToParcel(p0, p1);
        }
        List<RepaymentPlanModel> list2 = this.getValueOfTouchPositionAbsolute;
        p0.writeInt(list2.size());
        Iterator<RepaymentPlanModel> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(p0, p1);
        }
        p0.writeParcelable(this.readMicros, p1);
        p0.writeParcelable(this.getSupportButtonTintMode, p1);
        List<AddOnChannelSupportInfo> list3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list3.size());
            Iterator<AddOnChannelSupportInfo> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(p0, p1);
            }
        }
        List<LoanCreditChannelInfoModel> list4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (list4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list4.size());
            Iterator<LoanCreditChannelInfoModel> it4 = list4.iterator();
            while (it4.hasNext()) {
                it4.next().writeToParcel(p0, p1);
            }
        }
        MoneyViewModel moneyViewModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        moneyViewModel3.writeToParcel(p0, p1);
    }

    public CashierPayChannelModel(String str, String str2, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str3, Boolean bool, String str4, List<String> list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendCashierModel extendCashierModel, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRiskModel payMethodRiskModel, String str12, Boolean bool5, String str13, String str14, String str15, List<String> list2, List<VoucherCashierModel> list3, Boolean bool6, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, Boolean bool7, String str16, String str17, String str18, String str19, DanaCreditModel danaCreditModel, List<RepaymentPlanModel> list4, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, List<AddOnChannelSupportInfo> list5, List<LoanCreditChannelInfoModel> list6, MoneyViewModel moneyViewModel3) {
        Intrinsics.checkNotNullParameter(list4, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = moneyViewModel;
        this.lookAheadTest = moneyViewModel2;
        this.MyBillsEntityDataFactory = str3;
        this.getErrorConfigVersion = bool;
        this.scheduleImpl = str4;
        this.moveToNextValue = list;
        this.GetContactSyncConfig = bool2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5;
        this.DatabaseTableConfigUtil = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bool3;
        this.newProxyInstance = extendCashierModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str7;
        this.PrepareContext = str8;
        this.isLayoutRequested = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = bool4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = num;
        this.whenAvailable = str10;
        this.B = str11;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = payMethodRiskModel;
        this.C = str12;
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = bool5;
        this.getOnBoardingScenario = str13;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str14;
        this.AppCompatEmojiTextHelper = str15;
        this.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String = list2;
        this.I = list3;
        this.A = bool6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = currencyAmountModel;
        this.getCallingPid = currencyAmountModel2;
        this.FragmentBottomSheetPaymentSettingBinding = bool7;
        this.SubSequence = str16;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str17;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str18;
        this.E = str19;
        this.initRecordTimeStamp = danaCreditModel;
        this.getValueOfTouchPositionAbsolute = list4;
        this.readMicros = payLaterMethodConfig;
        this.getSupportButtonTintMode = paylaterCicilMethodConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = list6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = moneyViewModel3;
    }

    public /* synthetic */ CashierPayChannelModel(String str, String str2, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str3, Boolean bool, String str4, List list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendCashierModel extendCashierModel, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRiskModel payMethodRiskModel, String str12, Boolean bool5, String str13, String str14, String str15, List list2, List list3, Boolean bool6, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, Boolean bool7, String str16, String str17, String str18, String str19, DanaCreditModel danaCreditModel, List list4, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, List list5, List list6, MoneyViewModel moneyViewModel3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : moneyViewModel, (i & 8) != 0 ? null : moneyViewModel2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : bool3, (i & 4096) != 0 ? null : extendCashierModel, (i & 8192) != 0 ? null : str7, (i & 16384) != 0 ? null : str8, (i & 32768) != 0 ? null : str9, (i & 65536) != 0 ? null : bool4, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : num, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? null : str11, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : payMethodRiskModel, (i & 2097152) != 0 ? null : str12, (i & 4194304) != 0 ? null : bool5, (i & 8388608) != 0 ? null : str13, (i & 16777216) != 0 ? null : str14, (i & 33554432) != 0 ? null : str15, (i & 67108864) != 0 ? null : list2, (i & 134217728) != 0 ? null : list3, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : bool6, (i & 536870912) != 0 ? null : currencyAmountModel, (i & 1073741824) != 0 ? null : currencyAmountModel2, (i & Integer.MIN_VALUE) != 0 ? null : bool7, (i2 & 1) != 0 ? null : str16, (i2 & 2) != 0 ? null : str17, (i2 & 4) != 0 ? null : str18, (i2 & 8) != 0 ? null : str19, (i2 & 16) != 0 ? null : danaCreditModel, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 64) != 0 ? null : payLaterMethodConfig, (i2 & 128) != 0 ? null : paylaterCicilMethodConfig, (i2 & 256) != 0 ? null : list5, (i2 & 512) != 0 ? null : list6, (i2 & 1024) != 0 ? null : moneyViewModel3);
    }

    public final boolean PlaceComponentResult() {
        return Intrinsics.areEqual("BALANCE", this.B);
    }

    public final boolean getAuthRequestContext() {
        return Intrinsics.areEqual("BALANCE", this.B) && Intrinsics.areEqual(PayMethod.BALANCE_FAMILY, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual(PayMethod.LOAN_CREDIT, this.B);
    }

    public final boolean scheduleImpl() {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            List<LoanCreditChannelInfoModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            Object obj = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((LoanCreditChannelInfoModel) next).KClassImpl$Data$declaredNonStaticMembers$2, Boolean.FALSE)) {
                        obj = next;
                        break;
                    }
                }
                obj = (LoanCreditChannelInfoModel) obj;
            }
            return obj != null;
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        return Intrinsics.areEqual("ONLINE_CREDIT", this.B);
    }

    public final boolean lookAheadTest() {
        Boolean bool = this.A;
        return (bool != null ? bool.booleanValue() : false) || StringsKt.equals(Institution.BCA_ONEKLIK, this.PrepareContext, true);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return Intrinsics.areEqual("COUPON", this.B);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CashierPayChannelModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CashierPayChannelModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            ArrayList arrayList;
            Boolean valueOf6;
            Boolean valueOf7;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel2 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString4 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            ExtendCashierModel createFromParcel3 = parcel.readInt() == 0 ? null : ExtendCashierModel.CREATOR.createFromParcel(parcel);
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Integer valueOf8 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            PayMethodRiskModel payMethodRiskModel = (PayMethodRiskModel) parcel.readParcelable(CashierPayChannelModel.class.getClassLoader());
            String readString12 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                int i = 0;
                while (i != readInt) {
                    arrayList.add(VoucherCashierModel.CREATOR.createFromParcel(parcel));
                    i++;
                    readInt = readInt;
                }
            }
            ArrayList arrayList4 = arrayList;
            if (parcel.readInt() == 0) {
                valueOf6 = null;
            } else {
                valueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            CurrencyAmountModel currencyAmountModel = (CurrencyAmountModel) parcel.readParcelable(CashierPayChannelModel.class.getClassLoader());
            CurrencyAmountModel currencyAmountModel2 = (CurrencyAmountModel) parcel.readParcelable(CashierPayChannelModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf7 = null;
            } else {
                valueOf7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            DanaCreditModel createFromParcel4 = parcel.readInt() == 0 ? null : DanaCreditModel.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(readInt2);
            int i2 = 0;
            while (i2 != readInt2) {
                arrayList5.add(RepaymentPlanModel.CREATOR.createFromParcel(parcel));
                i2++;
                readInt2 = readInt2;
            }
            ArrayList arrayList6 = arrayList5;
            PayLaterMethodConfig payLaterMethodConfig = (PayLaterMethodConfig) parcel.readParcelable(CashierPayChannelModel.class.getClassLoader());
            PaylaterCicilMethodConfig paylaterCicilMethodConfig = (PaylaterCicilMethodConfig) parcel.readParcelable(CashierPayChannelModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList2 = new ArrayList(readInt3);
                int i3 = 0;
                while (i3 != readInt3) {
                    arrayList2.add(AddOnChannelSupportInfo.CREATOR.createFromParcel(parcel));
                    i3++;
                    readInt3 = readInt3;
                }
            }
            ArrayList arrayList7 = arrayList2;
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int readInt4 = parcel.readInt();
                arrayList3 = new ArrayList(readInt4);
                int i4 = 0;
                while (i4 != readInt4) {
                    arrayList3.add(LoanCreditChannelInfoModel.CREATOR.createFromParcel(parcel));
                    i4++;
                    readInt4 = readInt4;
                }
            }
            return new CashierPayChannelModel(readString, readString2, createFromParcel, createFromParcel2, readString3, valueOf, readString4, createStringArrayList, valueOf2, readString5, readString6, valueOf3, createFromParcel3, readString7, readString8, readString9, valueOf4, valueOf8, readString10, readString11, payMethodRiskModel, readString12, valueOf5, readString13, readString14, readString15, createStringArrayList2, arrayList4, valueOf6, currencyAmountModel, currencyAmountModel2, valueOf7, readString16, readString17, readString18, readString19, createFromParcel4, arrayList6, payLaterMethodConfig, paylaterCicilMethodConfig, arrayList7, arrayList3, parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CashierPayChannelModel[] newArray(int i) {
            return new CashierPayChannelModel[i];
        }
    }
}
