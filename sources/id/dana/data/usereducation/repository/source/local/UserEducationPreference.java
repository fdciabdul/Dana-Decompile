package id.dana.data.usereducation.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.domain.usereducation.BottomSheetOnBoardingScenario;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0013\b\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/data/usereducation/repository/source/local/UserEducationPreference;", "", "", "phoneNumber", "", "checkMobileDataPermissionAccepted", "(Ljava/lang/String;)Z", "", "clearAll", "()V", "scenario", "getBottomSheetOnBoardingShow", "(Ljava/lang/String;Ljava/lang/String;)Z", "getToolTipShow", "key", "isShowDialog", "saveBottomSheetOnBoardingShow", ContainerUIProvider.KEY_SHOW, "saveShowDialog", "(ZLjava/lang/String;)Z", "hasShown", "saveToolTipShow", "(ZLjava/lang/String;Ljava/lang/String;)Z", "setMobileDataPermissionAccepted", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserEducationPreference {
    public static final String BOTTOM_SHEET_FAMILY_ACCOUNT_TOPUP_FIRST_TIMER = "bottom_sheet_family_account_topup_first_timer";
    public static final String BOTTOM_SHEET_LANDING_ON_BOARDING_GROUP_SEND = "bottom_sheet_landing_on_boarding_group_send";
    public static final String BOTTOM_SHEET_ON_BOARDING_DANA_FOOD = "bottom_sheet_on_boarding_dana_food";
    public static final String BOTTOM_SHEET_ON_BOARDING_DANA_KAGET = "bottom_sheet_on_boarding_dana_kaget";
    public static final String BOTTOM_SHEET_ON_BOARDING_FAVOURITE_QUICK_SEND = "bottom_sheet_on_boarding_favourite_quick_send";
    public static final String BOTTOM_SHEET_ON_BOARDING_FRIENDSHIP = "bottom_sheet_on_boarding_friendship";
    public static final String BOTTOM_SHEET_ON_BOARDING_GROUP_SEND = "bottom_sheet_on_boarding_group_send";
    public static final String BOTTOM_SHEET_ON_BOARDING_HIDE_FROM_QUICK_ACTION = "bottom_sheet_on_boarding_hide_from_qucik_action";
    public static final String BOTTOM_SHEET_ON_BOARDING_MY_BILLS = "bottom_sheet_on_boarding_my_bills";
    public static final String BOTTOM_SHEET_ON_BOARDING_PAYLATER_LOAN_PERSONAL = "bottom_sheet_on_boarding_paylater_loan_personal";
    public static final String BOTTOM_SHEET_ON_BOARDING_REQUEST_MONEY = "bottom_sheet_on_boarding_request_money";
    public static final String BOTTOM_SHEET_ON_BOARDING_SAVING_GOAL = "bottom_sheet_on boarding_saving_goal";
    public static final String BOTTOM_SHEET_ON_BOARDING_SCAN_QR = "bottom_sheet_on_boarding_scan_qr";
    public static final String BOTTOM_SHEET_ON_BOARDING_SEND_MONEY = "bottom_sheet_on_boarding_send_money";
    public static final String BOTTOM_SHEET_ON_BOARDING_SNAP_RECEIPT = "bottom_sheet_on_boarding_snap_receipt";
    public static final String BOTTOM_SHEET_ON_BOARDING_SPLIT_BILL = "bottom_sheet_on_boarding_split_bill";
    public static final String BOTTOM_SHEET_ON_BOARDING_TOP_UP = "bottom_sheet_on_boarding_top_up";
    public static final String BOTTOM_SHEET_ON_BOARDING_WALLET = "bottom_sheet_on_boarding_wallet";
    public static final String BOTTOM_SHEET_ON_BOARDING_WALLET_FAVORITE_CARDS = "bottom_sheet_on_boarding_wallet_favorite_cards";
    public static final String BOTTOM_SHEET_SEND_MONEY_CONTACT_PERMISSION = "bottom_sheet_send_money_contact_permission";
    public static final String CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP = "cashier_dana_cicil_available";
    public static final String CASHIER_HIGHLIGHT_TOOLTIP = "cashier_highlight_tooltip";
    public static final String CASHIER_INSUFFICIENT_BALANCE_TOOLTIP = "cashier_insufficient_balance";
    public static final String CASHIER_MIXPAY_AUTOSELECT = "cashier_mixpay_autoselect";
    public static final String CASHIER_SMARTPAY_AUTOSELECT_TOOLTIP = "cashier_smartpay_autoselect";
    public static final String CASHIER_SMARTPAY_AVAILABLE_TOOLTIP = "cashier_smartpay_available";
    public static final String DIALOG_SCENARIO = "dialog_scenario_%s";
    public static final String EDIT_FAVORITE_SERVICE_TOOLTIP = "edit_favorite_service_tooltip";
    public static final String LOTTIE_ON_BOARDING_STATEMENT = "lottie_on_boarding_statement";
    public static final String MOBILE_DATA_PERMISSION_ACCEPTED = "mobile_data_permission_accepted";
    public static final String PROFILE_COMPLETION_WIDGET_CLOSED = "profile_completion_widget_closed";
    public static final String PROFILE_COMPLETION_WIDGET_TOOLTIP = "profile_completion_widget";
    public static final String USER_EDUCATION_PREFERENCE = "UserEducationPreferenceproduction";
    public static final String USER_EDUCATION_TOOLTIP = "user_education_tooltip";
    public static final String WALLET_ADD_ASSET_TOOLTIP = "wallet_add_asset";
    public static final String WALLET_FINANCIAL_SECTION_TOOLTIP = "wallet_financial_section";
    public static final String WALLET_IDENTITY_SECTION_TOOLTIP = "wallet_identity_section";
    public static final String WALLET_LOYALTY_SECTION_TOOLTIP = "wallet_loyalty_section";
    public static final String WALLET_PAYMENT_SECTION_TOOLTIP = "wallet_payment_section";
    public static final String WALLET_TAB_MENU_TOOLTIP = "wallet_tab_menu";
    public static final String WALLET_VOUCHER_TICKET_SECTION_TOOLTIP = "wallet_voucher_ticket_section";
    private final PreferenceFacade preferenceFacade;

    @Inject
    public UserEducationPreference(Context context) {
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("UserEducationPreferenceproduction").setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData);
    }

    public final boolean getToolTipShow(String scenario, String phoneNumber) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        switch (scenario.hashCode()) {
            case -1872601359:
                if (scenario.equals("profile_completion_widget")) {
                    PreferenceFacade preferenceFacade = this.preferenceFacade;
                    StringBuilder sb = new StringBuilder();
                    sb.append("profile_completion_widget");
                    sb.append(phoneNumber);
                    Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool, "");
                    return bool.booleanValue();
                }
                break;
            case -1805593239:
                if (scenario.equals(WALLET_VOUCHER_TICKET_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade2 = this.preferenceFacade;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(WALLET_VOUCHER_TICKET_SECTION_TOOLTIP);
                    sb2.append(phoneNumber);
                    Boolean bool2 = preferenceFacade2.getBoolean(sb2.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool2, "");
                    return bool2.booleanValue();
                }
                break;
            case -1342055514:
                if (scenario.equals(WALLET_LOYALTY_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade3 = this.preferenceFacade;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(WALLET_LOYALTY_SECTION_TOOLTIP);
                    sb3.append(phoneNumber);
                    Boolean bool3 = preferenceFacade3.getBoolean(sb3.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool3, "");
                    return bool3.booleanValue();
                }
                break;
            case -1238681105:
                if (scenario.equals(CASHIER_SMARTPAY_AUTOSELECT_TOOLTIP)) {
                    PreferenceFacade preferenceFacade4 = this.preferenceFacade;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(CASHIER_SMARTPAY_AUTOSELECT_TOOLTIP);
                    sb4.append(phoneNumber);
                    Boolean bool4 = preferenceFacade4.getBoolean(sb4.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool4, "");
                    return bool4.booleanValue();
                }
                break;
            case -794915689:
                if (scenario.equals(CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP)) {
                    PreferenceFacade preferenceFacade5 = this.preferenceFacade;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP);
                    sb5.append(phoneNumber);
                    Boolean bool5 = preferenceFacade5.getBoolean(sb5.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool5, "");
                    return bool5.booleanValue();
                }
                break;
            case -621568446:
                if (scenario.equals(CASHIER_MIXPAY_AUTOSELECT)) {
                    PreferenceFacade preferenceFacade6 = this.preferenceFacade;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(CASHIER_MIXPAY_AUTOSELECT);
                    sb6.append(phoneNumber);
                    Boolean bool6 = preferenceFacade6.getBoolean(sb6.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool6, "");
                    return bool6.booleanValue();
                }
                break;
            case -365995612:
                if (scenario.equals(UserEducationScenarioKt.CARD_BINDING_ONBOARDING)) {
                    PreferenceFacade preferenceFacade7 = this.preferenceFacade;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
                    sb7.append(phoneNumber);
                    Boolean bool7 = preferenceFacade7.getBoolean(sb7.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool7, "");
                    return bool7.booleanValue();
                }
                break;
            case -186227545:
                if (scenario.equals(UserEducationScenarioKt.EDIT_FAVORITE_SERVICE)) {
                    PreferenceFacade preferenceFacade8 = this.preferenceFacade;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(EDIT_FAVORITE_SERVICE_TOOLTIP);
                    sb8.append(phoneNumber);
                    Boolean bool8 = preferenceFacade8.getBoolean(sb8.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool8, "");
                    return bool8.booleanValue();
                }
                break;
            case 188577036:
                if (scenario.equals(WALLET_ADD_ASSET_TOOLTIP)) {
                    PreferenceFacade preferenceFacade9 = this.preferenceFacade;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(WALLET_ADD_ASSET_TOOLTIP);
                    sb9.append(phoneNumber);
                    Boolean bool9 = preferenceFacade9.getBoolean(sb9.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool9, "");
                    return bool9.booleanValue();
                }
                break;
            case 824596458:
                if (scenario.equals(WALLET_IDENTITY_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade10 = this.preferenceFacade;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(WALLET_IDENTITY_SECTION_TOOLTIP);
                    sb10.append(phoneNumber);
                    Boolean bool10 = preferenceFacade10.getBoolean(sb10.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool10, "");
                    return bool10.booleanValue();
                }
                break;
            case 910318236:
                if (scenario.equals(CASHIER_INSUFFICIENT_BALANCE_TOOLTIP)) {
                    PreferenceFacade preferenceFacade11 = this.preferenceFacade;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(CASHIER_INSUFFICIENT_BALANCE_TOOLTIP);
                    sb11.append(phoneNumber);
                    Boolean bool11 = preferenceFacade11.getBoolean(sb11.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool11, "");
                    return bool11.booleanValue();
                }
                break;
            case 1129076988:
                if (scenario.equals(CASHIER_HIGHLIGHT_TOOLTIP)) {
                    PreferenceFacade preferenceFacade12 = this.preferenceFacade;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(CASHIER_HIGHLIGHT_TOOLTIP);
                    sb12.append(phoneNumber);
                    Boolean bool12 = preferenceFacade12.getBoolean(sb12.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool12, "");
                    return bool12.booleanValue();
                }
                break;
            case 1492777577:
                if (scenario.equals(WALLET_FINANCIAL_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade13 = this.preferenceFacade;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(WALLET_FINANCIAL_SECTION_TOOLTIP);
                    sb13.append(phoneNumber);
                    Boolean bool13 = preferenceFacade13.getBoolean(sb13.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool13, "");
                    return bool13.booleanValue();
                }
                break;
            case 1564689349:
                if (scenario.equals(CASHIER_SMARTPAY_AVAILABLE_TOOLTIP)) {
                    PreferenceFacade preferenceFacade14 = this.preferenceFacade;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(CASHIER_SMARTPAY_AVAILABLE_TOOLTIP);
                    sb14.append(phoneNumber);
                    Boolean bool14 = preferenceFacade14.getBoolean(sb14.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool14, "");
                    return bool14.booleanValue();
                }
                break;
            case 1733885562:
                if (scenario.equals(PROFILE_COMPLETION_WIDGET_CLOSED)) {
                    PreferenceFacade preferenceFacade15 = this.preferenceFacade;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(PROFILE_COMPLETION_WIDGET_CLOSED);
                    sb15.append(phoneNumber);
                    Boolean bool15 = preferenceFacade15.getBoolean(sb15.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool15, "");
                    return bool15.booleanValue();
                }
                break;
            case 1750239590:
                if (scenario.equals(WALLET_PAYMENT_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade16 = this.preferenceFacade;
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(WALLET_PAYMENT_SECTION_TOOLTIP);
                    sb16.append(phoneNumber);
                    Boolean bool16 = preferenceFacade16.getBoolean(sb16.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool16, "");
                    return bool16.booleanValue();
                }
                break;
            case 1997850959:
                if (scenario.equals(WALLET_TAB_MENU_TOOLTIP)) {
                    PreferenceFacade preferenceFacade17 = this.preferenceFacade;
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(WALLET_TAB_MENU_TOOLTIP);
                    sb17.append(phoneNumber);
                    Boolean bool17 = preferenceFacade17.getBoolean(sb17.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool17, "");
                    return bool17.booleanValue();
                }
                break;
            case 2118081007:
                if (scenario.equals(UserEducationScenarioKt.HOME_PAGE)) {
                    PreferenceFacade preferenceFacade18 = this.preferenceFacade;
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(USER_EDUCATION_TOOLTIP);
                    sb18.append(phoneNumber);
                    Boolean bool18 = preferenceFacade18.getBoolean(sb18.toString(), false);
                    Intrinsics.checkNotNullExpressionValue(bool18, "");
                    return bool18.booleanValue();
                }
                break;
        }
        return true;
    }

    public final boolean saveToolTipShow(boolean hasShown, String scenario, String phoneNumber) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        switch (scenario.hashCode()) {
            case -1872601359:
                if (scenario.equals("profile_completion_widget")) {
                    PreferenceFacade preferenceFacade = this.preferenceFacade;
                    StringBuilder sb = new StringBuilder();
                    sb.append("profile_completion_widget");
                    sb.append(phoneNumber);
                    preferenceFacade.saveData(sb.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -1805593239:
                if (scenario.equals(WALLET_VOUCHER_TICKET_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade2 = this.preferenceFacade;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(WALLET_VOUCHER_TICKET_SECTION_TOOLTIP);
                    sb2.append(phoneNumber);
                    preferenceFacade2.saveData(sb2.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -1342055514:
                if (scenario.equals(WALLET_LOYALTY_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade3 = this.preferenceFacade;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(WALLET_LOYALTY_SECTION_TOOLTIP);
                    sb3.append(phoneNumber);
                    preferenceFacade3.saveData(sb3.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -1238681105:
                if (scenario.equals(CASHIER_SMARTPAY_AUTOSELECT_TOOLTIP)) {
                    PreferenceFacade preferenceFacade4 = this.preferenceFacade;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(CASHIER_SMARTPAY_AUTOSELECT_TOOLTIP);
                    sb4.append(phoneNumber);
                    preferenceFacade4.saveData(sb4.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -794915689:
                if (scenario.equals(CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP)) {
                    PreferenceFacade preferenceFacade5 = this.preferenceFacade;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP);
                    sb5.append(phoneNumber);
                    preferenceFacade5.saveData(sb5.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -621568446:
                if (scenario.equals(CASHIER_MIXPAY_AUTOSELECT)) {
                    PreferenceFacade preferenceFacade6 = this.preferenceFacade;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(CASHIER_MIXPAY_AUTOSELECT);
                    sb6.append(phoneNumber);
                    preferenceFacade6.saveData(sb6.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -365995612:
                if (scenario.equals(UserEducationScenarioKt.CARD_BINDING_ONBOARDING)) {
                    PreferenceFacade preferenceFacade7 = this.preferenceFacade;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
                    sb7.append(phoneNumber);
                    preferenceFacade7.saveData(sb7.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case -186227545:
                if (scenario.equals(UserEducationScenarioKt.EDIT_FAVORITE_SERVICE)) {
                    PreferenceFacade preferenceFacade8 = this.preferenceFacade;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(EDIT_FAVORITE_SERVICE_TOOLTIP);
                    sb8.append(phoneNumber);
                    preferenceFacade8.saveData(sb8.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 188577036:
                if (scenario.equals(WALLET_ADD_ASSET_TOOLTIP)) {
                    PreferenceFacade preferenceFacade9 = this.preferenceFacade;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(WALLET_ADD_ASSET_TOOLTIP);
                    sb9.append(phoneNumber);
                    preferenceFacade9.saveData(sb9.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 824596458:
                if (scenario.equals(WALLET_IDENTITY_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade10 = this.preferenceFacade;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(WALLET_IDENTITY_SECTION_TOOLTIP);
                    sb10.append(phoneNumber);
                    preferenceFacade10.saveData(sb10.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 910318236:
                if (scenario.equals(CASHIER_INSUFFICIENT_BALANCE_TOOLTIP)) {
                    PreferenceFacade preferenceFacade11 = this.preferenceFacade;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(CASHIER_INSUFFICIENT_BALANCE_TOOLTIP);
                    sb11.append(phoneNumber);
                    preferenceFacade11.saveData(sb11.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1129076988:
                if (scenario.equals(CASHIER_HIGHLIGHT_TOOLTIP)) {
                    PreferenceFacade preferenceFacade12 = this.preferenceFacade;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(CASHIER_HIGHLIGHT_TOOLTIP);
                    sb12.append(phoneNumber);
                    preferenceFacade12.saveData(sb12.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1492777577:
                if (scenario.equals(WALLET_FINANCIAL_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade13 = this.preferenceFacade;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(WALLET_FINANCIAL_SECTION_TOOLTIP);
                    sb13.append(phoneNumber);
                    preferenceFacade13.saveData(sb13.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1564689349:
                if (scenario.equals(CASHIER_SMARTPAY_AVAILABLE_TOOLTIP)) {
                    PreferenceFacade preferenceFacade14 = this.preferenceFacade;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(CASHIER_SMARTPAY_AVAILABLE_TOOLTIP);
                    sb14.append(phoneNumber);
                    preferenceFacade14.saveData(sb14.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1733885562:
                if (scenario.equals(PROFILE_COMPLETION_WIDGET_CLOSED)) {
                    PreferenceFacade preferenceFacade15 = this.preferenceFacade;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(PROFILE_COMPLETION_WIDGET_CLOSED);
                    sb15.append(phoneNumber);
                    preferenceFacade15.saveData(sb15.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1750239590:
                if (scenario.equals(WALLET_PAYMENT_SECTION_TOOLTIP)) {
                    PreferenceFacade preferenceFacade16 = this.preferenceFacade;
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(WALLET_PAYMENT_SECTION_TOOLTIP);
                    sb16.append(phoneNumber);
                    preferenceFacade16.saveData(sb16.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 1997850959:
                if (scenario.equals(WALLET_TAB_MENU_TOOLTIP)) {
                    PreferenceFacade preferenceFacade17 = this.preferenceFacade;
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(WALLET_TAB_MENU_TOOLTIP);
                    sb17.append(phoneNumber);
                    preferenceFacade17.saveData(sb17.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            case 2118081007:
                if (scenario.equals(UserEducationScenarioKt.HOME_PAGE)) {
                    PreferenceFacade preferenceFacade18 = this.preferenceFacade;
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(USER_EDUCATION_TOOLTIP);
                    sb18.append(phoneNumber);
                    preferenceFacade18.saveData(sb18.toString(), Boolean.valueOf(hasShown));
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    public final boolean getBottomSheetOnBoardingShow(String scenario, String phoneNumber) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        switch (scenario.hashCode()) {
            case -2085148305:
                if (scenario.equals("statement")) {
                    PreferenceFacade preferenceFacade = this.preferenceFacade;
                    StringBuilder sb = new StringBuilder();
                    sb.append(LOTTIE_ON_BOARDING_STATEMENT);
                    sb.append(phoneNumber);
                    Boolean bool = preferenceFacade.getBoolean(sb.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool, "");
                    return bool.booleanValue();
                }
                break;
            case -1755748902:
                if (scenario.equals("friendship")) {
                    PreferenceFacade preferenceFacade2 = this.preferenceFacade;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(BOTTOM_SHEET_ON_BOARDING_FRIENDSHIP);
                    sb2.append(phoneNumber);
                    Boolean bool2 = preferenceFacade2.getBoolean(sb2.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool2, "");
                    return bool2.booleanValue();
                }
                break;
            case -1727902811:
                if (scenario.equals("group_send_contact_permission")) {
                    PreferenceFacade preferenceFacade3 = this.preferenceFacade;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(BOTTOM_SHEET_ON_BOARDING_GROUP_SEND);
                    sb3.append(phoneNumber);
                    Boolean bool3 = preferenceFacade3.getBoolean(sb3.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool3, "");
                    return bool3.booleanValue();
                }
                break;
            case -1444372797:
                if (scenario.equals("snap_receipt")) {
                    PreferenceFacade preferenceFacade4 = this.preferenceFacade;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(BOTTOM_SHEET_ON_BOARDING_SNAP_RECEIPT);
                    sb4.append(phoneNumber);
                    Boolean bool4 = preferenceFacade4.getBoolean(sb4.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool4, "");
                    return bool4.booleanValue();
                }
                break;
            case -1393841075:
                if (scenario.equals("dana_food")) {
                    PreferenceFacade preferenceFacade5 = this.preferenceFacade;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(BOTTOM_SHEET_ON_BOARDING_DANA_FOOD);
                    sb5.append(phoneNumber);
                    Boolean bool5 = preferenceFacade5.getBoolean(sb5.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool5, "");
                    return bool5.booleanValue();
                }
                break;
            case -1217577158:
                if (scenario.equals("family_account_topup_first_timer")) {
                    PreferenceFacade preferenceFacade6 = this.preferenceFacade;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(BOTTOM_SHEET_FAMILY_ACCOUNT_TOPUP_FIRST_TIMER);
                    sb6.append(phoneNumber);
                    Boolean bool6 = preferenceFacade6.getBoolean(sb6.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool6, "");
                    return bool6.booleanValue();
                }
                break;
            case -868043323:
                if (scenario.equals("top_up")) {
                    PreferenceFacade preferenceFacade7 = this.preferenceFacade;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(BOTTOM_SHEET_ON_BOARDING_TOP_UP);
                    sb7.append(phoneNumber);
                    Boolean bool7 = preferenceFacade7.getBoolean(sb7.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool7, "");
                    return bool7.booleanValue();
                }
                break;
            case -795192327:
                if (scenario.equals("wallet")) {
                    PreferenceFacade preferenceFacade8 = this.preferenceFacade;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(BOTTOM_SHEET_ON_BOARDING_WALLET);
                    sb8.append(phoneNumber);
                    Boolean bool8 = preferenceFacade8.getBoolean(sb8.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool8, "");
                    return bool8.booleanValue();
                }
                break;
            case -757939939:
                if (scenario.equals("favorite_quick_send")) {
                    PreferenceFacade preferenceFacade9 = this.preferenceFacade;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(BOTTOM_SHEET_ON_BOARDING_FAVOURITE_QUICK_SEND);
                    sb9.append(phoneNumber);
                    Boolean bool9 = preferenceFacade9.getBoolean(sb9.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool9, "");
                    return bool9.booleanValue();
                }
                break;
            case -711814856:
                if (scenario.equals("saving_goal")) {
                    PreferenceFacade preferenceFacade10 = this.preferenceFacade;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(BOTTOM_SHEET_ON_BOARDING_SAVING_GOAL);
                    sb10.append(phoneNumber);
                    Boolean bool10 = preferenceFacade10.getBoolean(sb10.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool10, "");
                    return bool10.booleanValue();
                }
                break;
            case -479929095:
                if (scenario.equals("my_bills")) {
                    PreferenceFacade preferenceFacade11 = this.preferenceFacade;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(BOTTOM_SHEET_ON_BOARDING_MY_BILLS);
                    sb11.append(phoneNumber);
                    Boolean bool11 = preferenceFacade11.getBoolean(sb11.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool11, "");
                    return bool11.booleanValue();
                }
                break;
            case -340352500:
                if (scenario.equals("split_bill")) {
                    PreferenceFacade preferenceFacade12 = this.preferenceFacade;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(BOTTOM_SHEET_ON_BOARDING_SPLIT_BILL);
                    sb12.append(phoneNumber);
                    Boolean bool12 = preferenceFacade12.getBoolean(sb12.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool12, "");
                    return bool12.booleanValue();
                }
                break;
            case -255207375:
                if (scenario.equals("dana_kaget")) {
                    PreferenceFacade preferenceFacade13 = this.preferenceFacade;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(BOTTOM_SHEET_ON_BOARDING_DANA_KAGET);
                    sb13.append(phoneNumber);
                    Boolean bool13 = preferenceFacade13.getBoolean(sb13.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool13, "");
                    return bool13.booleanValue();
                }
                break;
            case 387440132:
                if (scenario.equals("send_money_contact_permission")) {
                    PreferenceFacade preferenceFacade14 = this.preferenceFacade;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(BOTTOM_SHEET_SEND_MONEY_CONTACT_PERMISSION);
                    sb14.append(phoneNumber);
                    Boolean bool14 = preferenceFacade14.getBoolean(sb14.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool14, "");
                    return bool14.booleanValue();
                }
                break;
            case 821988681:
                if (scenario.equals("send_money")) {
                    PreferenceFacade preferenceFacade15 = this.preferenceFacade;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(BOTTOM_SHEET_ON_BOARDING_SEND_MONEY);
                    sb15.append(phoneNumber);
                    Boolean bool15 = preferenceFacade15.getBoolean(sb15.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool15, "");
                    return bool15.booleanValue();
                }
                break;
            case 1282459976:
                if (scenario.equals(BottomSheetOnBoardingScenario.GROUP_SEND)) {
                    PreferenceFacade preferenceFacade16 = this.preferenceFacade;
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(BOTTOM_SHEET_LANDING_ON_BOARDING_GROUP_SEND);
                    sb16.append(phoneNumber);
                    Boolean bool16 = preferenceFacade16.getBoolean(sb16.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool16, "");
                    return bool16.booleanValue();
                }
                break;
            case 1557329926:
                if (scenario.equals("wallet_favorite_cards")) {
                    PreferenceFacade preferenceFacade17 = this.preferenceFacade;
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(BOTTOM_SHEET_ON_BOARDING_WALLET_FAVORITE_CARDS);
                    sb17.append(phoneNumber);
                    Boolean bool17 = preferenceFacade17.getBoolean(sb17.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool17, "");
                    return bool17.booleanValue();
                }
                break;
            case 1740443408:
                if (scenario.equals("request_money")) {
                    PreferenceFacade preferenceFacade18 = this.preferenceFacade;
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(BOTTOM_SHEET_ON_BOARDING_REQUEST_MONEY);
                    sb18.append(phoneNumber);
                    Boolean bool18 = preferenceFacade18.getBoolean(sb18.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool18, "");
                    return bool18.booleanValue();
                }
                break;
            case 1910947619:
                if (scenario.equals("scan_qr")) {
                    PreferenceFacade preferenceFacade19 = this.preferenceFacade;
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(BOTTOM_SHEET_ON_BOARDING_SCAN_QR);
                    sb19.append(phoneNumber);
                    Boolean bool19 = preferenceFacade19.getBoolean(sb19.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool19, "");
                    return bool19.booleanValue();
                }
                break;
            case 2001936559:
                if (scenario.equals("loan_personal")) {
                    PreferenceFacade preferenceFacade20 = this.preferenceFacade;
                    StringBuilder sb20 = new StringBuilder();
                    sb20.append(BOTTOM_SHEET_ON_BOARDING_PAYLATER_LOAN_PERSONAL);
                    sb20.append(phoneNumber);
                    Boolean bool20 = preferenceFacade20.getBoolean(sb20.toString(), true);
                    Intrinsics.checkNotNullExpressionValue(bool20, "");
                    return bool20.booleanValue();
                }
                break;
        }
        return false;
    }

    public final boolean saveBottomSheetOnBoardingShow(String scenario, String phoneNumber) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        int hashCode = scenario.hashCode();
        Boolean bool = Boolean.FALSE;
        switch (hashCode) {
            case -2085148305:
                if (scenario.equals("statement")) {
                    PreferenceFacade preferenceFacade = this.preferenceFacade;
                    StringBuilder sb = new StringBuilder();
                    sb.append(LOTTIE_ON_BOARDING_STATEMENT);
                    sb.append(phoneNumber);
                    preferenceFacade.saveData(sb.toString(), bool);
                    return true;
                }
                return true;
            case -1755748902:
                if (scenario.equals("friendship")) {
                    PreferenceFacade preferenceFacade2 = this.preferenceFacade;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(BOTTOM_SHEET_ON_BOARDING_FRIENDSHIP);
                    sb2.append(phoneNumber);
                    preferenceFacade2.saveData(sb2.toString(), bool);
                    return true;
                }
                return true;
            case -1727902811:
                if (scenario.equals("group_send_contact_permission")) {
                    PreferenceFacade preferenceFacade3 = this.preferenceFacade;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(BOTTOM_SHEET_ON_BOARDING_GROUP_SEND);
                    sb3.append(phoneNumber);
                    preferenceFacade3.saveData(sb3.toString(), bool);
                    return true;
                }
                return true;
            case -1444372797:
                if (scenario.equals("snap_receipt")) {
                    PreferenceFacade preferenceFacade4 = this.preferenceFacade;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(BOTTOM_SHEET_ON_BOARDING_SNAP_RECEIPT);
                    sb4.append(phoneNumber);
                    preferenceFacade4.saveData(sb4.toString(), bool);
                    return true;
                }
                return true;
            case -1393841075:
                if (scenario.equals("dana_food")) {
                    PreferenceFacade preferenceFacade5 = this.preferenceFacade;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(BOTTOM_SHEET_ON_BOARDING_DANA_FOOD);
                    sb5.append(phoneNumber);
                    preferenceFacade5.saveData(sb5.toString(), bool);
                    return true;
                }
                return true;
            case -1259411291:
                if (scenario.equals("hide_quick_action")) {
                    PreferenceFacade preferenceFacade6 = this.preferenceFacade;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(BOTTOM_SHEET_ON_BOARDING_HIDE_FROM_QUICK_ACTION);
                    sb6.append(phoneNumber);
                    preferenceFacade6.saveData(sb6.toString(), bool);
                    return true;
                }
                return true;
            case -1217577158:
                if (scenario.equals("family_account_topup_first_timer")) {
                    PreferenceFacade preferenceFacade7 = this.preferenceFacade;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(BOTTOM_SHEET_FAMILY_ACCOUNT_TOPUP_FIRST_TIMER);
                    sb7.append(phoneNumber);
                    preferenceFacade7.saveData(sb7.toString(), bool);
                    return true;
                }
                return true;
            case -868043323:
                if (scenario.equals("top_up")) {
                    PreferenceFacade preferenceFacade8 = this.preferenceFacade;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(BOTTOM_SHEET_ON_BOARDING_TOP_UP);
                    sb8.append(phoneNumber);
                    preferenceFacade8.saveData(sb8.toString(), bool);
                    return true;
                }
                return true;
            case -795192327:
                if (scenario.equals("wallet")) {
                    PreferenceFacade preferenceFacade9 = this.preferenceFacade;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(BOTTOM_SHEET_ON_BOARDING_WALLET);
                    sb9.append(phoneNumber);
                    preferenceFacade9.saveData(sb9.toString(), bool);
                    return true;
                }
                return true;
            case -757939939:
                if (scenario.equals("favorite_quick_send")) {
                    PreferenceFacade preferenceFacade10 = this.preferenceFacade;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(BOTTOM_SHEET_ON_BOARDING_FAVOURITE_QUICK_SEND);
                    sb10.append(phoneNumber);
                    preferenceFacade10.saveData(sb10.toString(), bool);
                    return true;
                }
                return true;
            case -711814856:
                if (scenario.equals("saving_goal")) {
                    PreferenceFacade preferenceFacade11 = this.preferenceFacade;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(BOTTOM_SHEET_ON_BOARDING_SAVING_GOAL);
                    sb11.append(phoneNumber);
                    preferenceFacade11.saveData(sb11.toString(), bool);
                    return true;
                }
                return true;
            case -479929095:
                if (scenario.equals("my_bills")) {
                    PreferenceFacade preferenceFacade12 = this.preferenceFacade;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(BOTTOM_SHEET_ON_BOARDING_MY_BILLS);
                    sb12.append(phoneNumber);
                    preferenceFacade12.saveData(sb12.toString(), bool);
                    return true;
                }
                return true;
            case -340352500:
                if (scenario.equals("split_bill")) {
                    PreferenceFacade preferenceFacade13 = this.preferenceFacade;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(BOTTOM_SHEET_ON_BOARDING_SPLIT_BILL);
                    sb13.append(phoneNumber);
                    preferenceFacade13.saveData(sb13.toString(), bool);
                    return true;
                }
                return true;
            case -255207375:
                if (scenario.equals("dana_kaget")) {
                    PreferenceFacade preferenceFacade14 = this.preferenceFacade;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(BOTTOM_SHEET_ON_BOARDING_DANA_KAGET);
                    sb14.append(phoneNumber);
                    preferenceFacade14.saveData(sb14.toString(), bool);
                    return true;
                }
                return true;
            case 387440132:
                if (scenario.equals("send_money_contact_permission")) {
                    PreferenceFacade preferenceFacade15 = this.preferenceFacade;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(BOTTOM_SHEET_SEND_MONEY_CONTACT_PERMISSION);
                    sb15.append(phoneNumber);
                    preferenceFacade15.saveData(sb15.toString(), bool);
                    return true;
                }
                return true;
            case 821988681:
                if (scenario.equals("send_money")) {
                    PreferenceFacade preferenceFacade16 = this.preferenceFacade;
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(BOTTOM_SHEET_ON_BOARDING_SEND_MONEY);
                    sb16.append(phoneNumber);
                    preferenceFacade16.saveData(sb16.toString(), bool);
                    return true;
                }
                return true;
            case 1282459976:
                if (scenario.equals(BottomSheetOnBoardingScenario.GROUP_SEND)) {
                    PreferenceFacade preferenceFacade17 = this.preferenceFacade;
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(BOTTOM_SHEET_LANDING_ON_BOARDING_GROUP_SEND);
                    sb17.append(phoneNumber);
                    preferenceFacade17.saveData(sb17.toString(), bool);
                    return true;
                }
                return true;
            case 1557329926:
                if (scenario.equals("wallet_favorite_cards")) {
                    PreferenceFacade preferenceFacade18 = this.preferenceFacade;
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(BOTTOM_SHEET_ON_BOARDING_WALLET_FAVORITE_CARDS);
                    sb18.append(phoneNumber);
                    preferenceFacade18.saveData(sb18.toString(), bool);
                    return true;
                }
                return true;
            case 1740443408:
                if (scenario.equals("request_money")) {
                    PreferenceFacade preferenceFacade19 = this.preferenceFacade;
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(BOTTOM_SHEET_ON_BOARDING_REQUEST_MONEY);
                    sb19.append(phoneNumber);
                    preferenceFacade19.saveData(sb19.toString(), bool);
                    return true;
                }
                return true;
            case 1910947619:
                if (scenario.equals("scan_qr")) {
                    PreferenceFacade preferenceFacade20 = this.preferenceFacade;
                    StringBuilder sb20 = new StringBuilder();
                    sb20.append(BOTTOM_SHEET_ON_BOARDING_SCAN_QR);
                    sb20.append(phoneNumber);
                    preferenceFacade20.saveData(sb20.toString(), bool);
                    return true;
                }
                return true;
            case 2001936559:
                if (scenario.equals("loan_personal")) {
                    PreferenceFacade preferenceFacade21 = this.preferenceFacade;
                    StringBuilder sb21 = new StringBuilder();
                    sb21.append(BOTTOM_SHEET_ON_BOARDING_PAYLATER_LOAN_PERSONAL);
                    sb21.append(phoneNumber);
                    preferenceFacade21.saveData(sb21.toString(), bool);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    public final boolean setMobileDataPermissionAccepted(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(MOBILE_DATA_PERMISSION_ACCEPTED);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
        return true;
    }

    public final boolean checkMobileDataPermissionAccepted(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(MOBILE_DATA_PERMISSION_ACCEPTED);
        sb.append(phoneNumber);
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean isShowDialog(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        String format = String.format(DIALOG_SCENARIO, Arrays.copyOf(new Object[]{key}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        Boolean bool = preferenceFacade.getBoolean(format, true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean saveShowDialog(boolean show, String key) {
        Intrinsics.checkNotNullParameter(key, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        String format = String.format(DIALOG_SCENARIO, Arrays.copyOf(new Object[]{key}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        preferenceFacade.saveData(format, Boolean.valueOf(show));
        return true;
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
