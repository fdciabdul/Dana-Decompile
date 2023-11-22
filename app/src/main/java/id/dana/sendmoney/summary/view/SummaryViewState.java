package id.dana.sendmoney.summary.view;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.recipient.RecipientType;
import id.dana.sendmoney_v2.x2l.SocialLinkUtil;
import id.dana.utils.TextUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u0006*\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\t\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007J\u0017\u0010\t\u001a\u0006*\u00020\u00050\u0005*\u00020\u0011H\u0002¢\u0006\u0004\b\t\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u000e\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0010\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0012\u0010\u0018\u001a\u00020\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0012\u0010\u0016\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0012\u0010\u0015\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u001a"}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryViewState;", "", "", "moveToNextValue", "()Z", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "p0", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/sendmoney/model/RecipientModel;", "(Lid/dana/sendmoney/model/RecipientModel;)Ljava/lang/String;", "PlaceComponentResult", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/sendmoney/model/RecipientModel;", "Ljava/lang/String;", "p1", "p2", "<init>", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryViewState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public RecipientModel scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    String lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public SummaryViewState(RecipientModel recipientModel, String str, boolean z) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.scheduleImpl = recipientModel;
        this.lookAheadTest = str;
        this.PlaceComponentResult = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "lookAheadTest")
    public final boolean lookAheadTest() {
        return Intrinsics.areEqual(this.scheduleImpl.readMicros, "bank");
    }

    @JvmName(name = "getErrorConfigVersion")
    public final boolean getErrorConfigVersion() {
        return Intrinsics.areEqual(this.scheduleImpl.readMicros, "contact");
    }

    @JvmName(name = "scheduleImpl")
    public final boolean scheduleImpl() {
        return Intrinsics.areEqual(this.scheduleImpl.readMicros, "link");
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.scheduleImpl.moveToNextValue();
    }

    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        return moveToNextValue();
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.scheduleImpl.readMicros;
        if (!Intrinsics.areEqual(str, "link")) {
            return Intrinsics.areEqual(str, "bank") ? R.drawable.ic_other_bank : R.drawable.ic_avatar_grey_default;
        }
        SocialLinkUtil socialLinkUtil = SocialLinkUtil.INSTANCE;
        String BuiltInFictitiousFunctionClassFactory = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return SocialLinkUtil.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
    }

    public final String getAuthRequestContext() {
        String str = this.scheduleImpl.readMicros;
        if (str != null) {
            switch (str.hashCode()) {
                case 110366:
                    if (str.equals(RecipientType.OTC)) {
                        return "OTC";
                    }
                    break;
                case 3016252:
                    if (str.equals("bank")) {
                        return "BANK_TRANSFER";
                    }
                    break;
                case 3321850:
                    if (str.equals("link")) {
                        return "LINK";
                    }
                    break;
                case 951526432:
                    if (str.equals("contact")) {
                        return "BALANCE";
                    }
                    break;
            }
        }
        return "Not Supported";
    }

    public final String MyBillsEntityDataFactory(Context p0) {
        if (scheduleImpl()) {
            return KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
        if (lookAheadTest()) {
            String format = String.format("%s | %s", Arrays.copyOf(new Object[]{KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl), this.scheduleImpl.BuiltInFictitiousFunctionClassFactory}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        } else if (getErrorConfigVersion() && !NetworkUserEntityData$$ExternalSyntheticLambda0() && Intrinsics.areEqual(this.scheduleImpl.SubSequence, "Manual Input")) {
            String str = this.scheduleImpl.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str, "");
            return str;
        } else {
            String PlaceComponentResult = this.scheduleImpl.PlaceComponentResult();
            if (PlaceComponentResult == null || PlaceComponentResult.length() == 0) {
                String str2 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (str2 == null || str2.length() == 0) {
                    String str3 = this.scheduleImpl.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    return str3;
                }
            }
            if (Intrinsics.areEqual(this.scheduleImpl.PlaceComponentResult(), this.scheduleImpl.BuiltInFictitiousFunctionClassFactory)) {
                String str4 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (str4 == null) {
                    str4 = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
                }
                Intrinsics.checkNotNullExpressionValue(str4, "");
                return str4;
            }
            String str5 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if ((str5 == null || str5.length() == 0) || Intrinsics.areEqual(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5, this.scheduleImpl.getErrorConfigVersion)) {
                String PlaceComponentResult2 = this.scheduleImpl.PlaceComponentResult();
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                return PlaceComponentResult2;
            }
            String str6 = this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5;
            Intrinsics.checkNotNullExpressionValue(str6, "");
            return str6;
        }
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        String lookAheadTest = this.scheduleImpl.lookAheadTest();
        if (lookAheadTest != null) {
            if ((!StringsKt.isBlank(lookAheadTest)) == false) {
                lookAheadTest = null;
            }
            if (lookAheadTest != null) {
                return lookAheadTest;
            }
        }
        String string = p0 != null ? p0.getString(R.string.send_as_link) : null;
        return string == null ? "" : string;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        String str;
        if (lookAheadTest()) {
            str = NetworkUserEntityData$$ExternalSyntheticLambda2();
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else if (scheduleImpl()) {
            return "";
        } else {
            if (getErrorConfigVersion() && !NetworkUserEntityData$$ExternalSyntheticLambda0() && Intrinsics.areEqual(this.scheduleImpl.SubSequence, "Manual Input")) {
                return "";
            }
            if (Intrinsics.areEqual(this.scheduleImpl.SubSequence, "Manual Input") && getErrorConfigVersion() && NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                NumberUtil numberUtil = NumberUtil.INSTANCE;
                str = NumberUtil.getAuthRequestContext(this.scheduleImpl.getErrorConfigVersion);
                if (str == null) {
                    return "";
                }
            } else {
                str = this.scheduleImpl.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(str, "");
            }
        }
        return str;
    }

    private final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (!Intrinsics.areEqual(this.scheduleImpl.SubSequence, "Manual Input")) {
            return TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.MyBillsEntityDataFactory(this.scheduleImpl.getErrorConfigVersion));
        }
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = this.scheduleImpl.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return NumberUtil.moveToNextValue(str);
    }

    private final boolean moveToNextValue() {
        return (Intrinsics.areEqual("split_bill", this.scheduleImpl.B) || Intrinsics.areEqual("request_money", this.scheduleImpl.B)) && !TextUtils.isEmpty(this.scheduleImpl.PrepareContext);
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel) {
        String str = recipientModel.getAuthRequestContext;
        return str == null || str.length() == 0 ? recipientModel.PlaceComponentResult() : recipientModel.getAuthRequestContext;
    }
}
