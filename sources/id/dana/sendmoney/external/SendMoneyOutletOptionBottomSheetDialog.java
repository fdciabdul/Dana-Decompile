package id.dana.sendmoney.external;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.danah5.DanaH5;
import id.dana.sendmoney.external.outlet.AddOutletReceiverActivity;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.ImageUtil;
import id.dana.utils.TagFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyOutletOptionBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "scheduleImpl", "Z", "moveToNextValue", "PlaceComponentResult", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyOutletOptionBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ExternalWithdrawChannelModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    private View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_outlet_option_coordinator;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        final ExternalWithdrawChannelModel externalWithdrawChannelModel;
        super.init();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.PlaceComponentResult = arguments.getBoolean("isUserKyc");
            this.MyBillsEntityDataFactory = arguments.getBoolean("isSendEnabled");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ExternalWithdrawChannelModel) arguments.getParcelable("outletModel");
        }
        TextView textView = (TextView) getAuthRequestContext(R.id.getLogSourceName);
        if (textView != null) {
            ExternalWithdrawChannelModel externalWithdrawChannelModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String str = externalWithdrawChannelModel2 != null ? externalWithdrawChannelModel2.moveToNextValue : null;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) getAuthRequestContext(R.id._release);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SendMoneyOutletOptionBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SendMoneyOutletOptionBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(SendMoneyOutletOptionBottomSheetDialog.this);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) getAuthRequestContext(R.id.ll_send_cash);
        if (linearLayout != null) {
            if (!this.MyBillsEntityDataFactory) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) getAuthRequestContext(R.id.iv_send_cash);
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
                ImageUtil.BuiltInFictitiousFunctionClassFactory(appCompatImageView2);
                linearLayout.setClickable(false);
                linearLayout.setFocusable(false);
                if (Build.VERSION.SDK_INT >= 23) {
                    linearLayout.setForeground(null);
                }
            } else {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SendMoneyOutletOptionBottomSheetDialog$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SendMoneyOutletOptionBottomSheetDialog.getAuthRequestContext(SendMoneyOutletOptionBottomSheetDialog.this);
                    }
                });
            }
        }
        LinearLayout linearLayout2 = (LinearLayout) getAuthRequestContext(R.id.displayLocationMerchantSearchView);
        if (linearLayout2 == null || (externalWithdrawChannelModel = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        if (Intrinsics.areEqual(externalWithdrawChannelModel.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE) && !externalWithdrawChannelModel.PlaceComponentResult()) {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) getAuthRequestContext(R.id.setEmojiReplaceStrategy);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
            ImageUtil imageUtil2 = ImageUtil.PlaceComponentResult;
            ImageUtil.BuiltInFictitiousFunctionClassFactory(appCompatImageView3);
            linearLayout2.setClickable(false);
            linearLayout2.setFocusable(false);
            if (Build.VERSION.SDK_INT >= 23) {
                linearLayout2.setForeground(null);
                return;
            }
            return;
        }
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.SendMoneyOutletOptionBottomSheetDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendMoneyOutletOptionBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyOutletOptionBottomSheetDialog.this, externalWithdrawChannelModel);
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    private final void MyBillsEntityDataFactory(String p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.SEND_AND_WITHDRAW_SELECT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Transaction Type", p0);
        ExternalWithdrawChannelModel externalWithdrawChannelModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = externalWithdrawChannelModel != null ? externalWithdrawChannelModel.moveToNextValue : null;
        if (str == null) {
            str = "";
        }
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SEND_AND_WITHDRAW_CHANNEL, str).BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyOutletOptionBottomSheetDialog$Companion;", "", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "p0", "", "p1", "p2", "Lid/dana/sendmoney/external/SendMoneyOutletOptionBottomSheetDialog;", "getAuthRequestContext", "(Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;ZZ)Lid/dana/sendmoney/external/SendMoneyOutletOptionBottomSheetDialog;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SendMoneyOutletOptionBottomSheetDialog getAuthRequestContext(ExternalWithdrawChannelModel p0, boolean p1, boolean p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            SendMoneyOutletOptionBottomSheetDialog sendMoneyOutletOptionBottomSheetDialog = new SendMoneyOutletOptionBottomSheetDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isUserKyc", p2);
            bundle.putBoolean("isSendEnabled", p1);
            bundle.putParcelable("outletModel", p0);
            sendMoneyOutletOptionBottomSheetDialog.setArguments(bundle);
            return sendMoneyOutletOptionBottomSheetDialog;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyOutletOptionBottomSheetDialog sendMoneyOutletOptionBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(sendMoneyOutletOptionBottomSheetDialog, "");
        sendMoneyOutletOptionBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyOutletOptionBottomSheetDialog sendMoneyOutletOptionBottomSheetDialog, ExternalWithdrawChannelModel externalWithdrawChannelModel) {
        Intrinsics.checkNotNullParameter(sendMoneyOutletOptionBottomSheetDialog, "");
        Intrinsics.checkNotNullParameter(externalWithdrawChannelModel, "");
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/withdraw/otctoken?instId={instId}&errCode={errCode}&KYCStatus={KYCStatus}").MyBillsEntityDataFactory("instId", externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory("errCode", externalWithdrawChannelModel.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory("KYCStatus", sendMoneyOutletOptionBottomSheetDialog.PlaceComponentResult ? "KYC1" : "KYC0").MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        DanaH5.startContainerFullUrl(MyBillsEntityDataFactory);
        sendMoneyOutletOptionBottomSheetDialog.MyBillsEntityDataFactory(TrackerKey.TransactionType.WITHDRAW);
    }

    public static /* synthetic */ void getAuthRequestContext(SendMoneyOutletOptionBottomSheetDialog sendMoneyOutletOptionBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(sendMoneyOutletOptionBottomSheetDialog, "");
        ExternalWithdrawChannelModel externalWithdrawChannelModel = sendMoneyOutletOptionBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2;
        if (externalWithdrawChannelModel != null) {
            AddOutletReceiverActivity.Companion companion = AddOutletReceiverActivity.INSTANCE;
            FragmentActivity activity = sendMoneyOutletOptionBottomSheetDialog.getActivity();
            String source = ((BaseActivity) sendMoneyOutletOptionBottomSheetDialog.requireActivity()).getSource();
            Intrinsics.checkNotNullExpressionValue(source, "");
            AddOutletReceiverActivity.Companion.PlaceComponentResult(activity, externalWithdrawChannelModel, source);
        }
        sendMoneyOutletOptionBottomSheetDialog.MyBillsEntityDataFactory(TrackerKey.TransactionType.SEND_TO_CASH);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) getAuthRequestContext(R.id.phoneNumber);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
