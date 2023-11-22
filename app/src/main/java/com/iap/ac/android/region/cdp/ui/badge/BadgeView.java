package com.iap.ac.android.region.cdp.ui.badge;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.acs.operation.R;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import com.iap.ac.android.region.cdp.delegate.ImageService;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.ui.CdpUiDelegateHost;
import com.iap.ac.android.region.cdp.ui.ICdpView;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BadgeView extends RelativeLayout implements ICdpView {
    public static final String KEY_SOURCE_INFO = "sourceInfo";
    public static final String KEY_TRACKING_CODE = "trackingCode";
    public static final String TAG = CdpUtils.logTag("BadgeWrapperLayout");
    public ImageView ivBadge;
    public String lastImageUrl;
    public CdpContentInfo mCdpContentInfo;
    public TextView tvBadge;

    public BadgeView(Context context) {
        this(context, null);
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.acplugin_layout_cover_view, (ViewGroup) this, false);
        this.ivBadge = (ImageView) inflate.findViewById(R.id.iv_badge);
        this.tvBadge = (TextView) inflate.findViewById(R.id.tv_badge);
        addView(inflate);
    }

    private void renderBadge(CdpContentInfo cdpContentInfo, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(cdpContentInfo.contentData);
        } catch (Exception e) {
            ACLog.w(TAG, String.format("contentData parse to json error, error: %s, contentData: %s", e.getMessage(), cdpContentInfo.contentData));
        }
        if ("TEXT".equals(cdpContentInfo.contentType)) {
            renderBadgeWithText(jSONObject);
        } else if (CdpContentInfo.CONTENT_TYPE_IMAGE.equals(cdpContentInfo.contentType)) {
            renderBadgeWithImage(jSONObject, i, i2);
        } else {
            StringBuilder a2 = a.a("contentType ");
            a2.append(cdpContentInfo.contentType);
            a2.append(" is not supported by ");
            a2.append(BadgeView.class.getName());
            String obj = a2.toString();
            ACLog.e(TAG, obj);
            ACLogEvent.newLogger("mini_program_operation", CdpConstants.SEED_ID_EXCEPTION_TRIGGERED).addParams("spaceCode", cdpContentInfo.spaceCode).addParams("contentInfo", cdpContentInfo).addParams("errorMessage", obj).event("region_biz");
        }
    }

    private void renderBadgeWithImage(JSONObject jSONObject, int i, int i2) {
        if (i2 > 0 && i > 0) {
            setWidthHeight(i, i2);
        }
        String optString = jSONObject.optString(CdpConstants.CONTENT_IMAGE_URL);
        if (!TextUtils.isEmpty(optString) && !optString.equals(this.lastImageUrl)) {
            ImageService imageService = CdpUiDelegateHost.getInstance().getImageService();
            if (imageService == null) {
                return;
            }
            this.ivBadge.setVisibility(0);
            this.tvBadge.setVisibility(8);
            imageService.loadImage(getContext(), optString, this.ivBadge, null);
            this.lastImageUrl = optString;
        }
        WalletCdpKit walletCdpKit = WalletCdpKit.getInstance();
        Context context = getContext();
        CdpContentInfo cdpContentInfo = this.mCdpContentInfo;
        walletCdpKit.addFatigueAction(context, cdpContentInfo.spaceCode, cdpContentInfo.deliverId, CdpFatigueInfo.ACTION_EXPOSURE, null);
    }

    private void renderBadgeWithText(JSONObject jSONObject) {
        String optString = jSONObject.optString("text");
        double optDouble = jSONObject.optDouble(CdpConstants.CONTENT_FONT_SIZE, 11.0d);
        int strColorToInt = CdpUtils.strColorToInt(jSONObject.optString(CdpConstants.CONTENT_TEXT_COLOR), -1);
        int dp2px = (int) CdpUtils.dp2px(getContext(), jSONObject.optInt(CdpConstants.CONTENT_PADDING_VERTICAL, 2));
        int dp2px2 = (int) CdpUtils.dp2px(getContext(), jSONObject.optInt(CdpConstants.CONTENT_PADDING_HORIZONTAL, 3));
        int strColorToInt2 = CdpUtils.strColorToInt(jSONObject.optString("backgroundColor"), -65536);
        float dp2px3 = (float) CdpUtils.dp2px(getContext(), jSONObject.optDouble(CdpConstants.CONTENT_CORNER_RADIUS, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        this.ivBadge.setVisibility(8);
        this.tvBadge.setVisibility(0);
        this.tvBadge.setText(optString);
        this.tvBadge.setTextSize((float) optDouble);
        this.tvBadge.setTextColor(strColorToInt);
        this.tvBadge.setPadding(dp2px2, dp2px, dp2px2, dp2px);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.mutate();
        gradientDrawable.setColor(strColorToInt2);
        gradientDrawable.setCornerRadius(dp2px3);
        if (Build.VERSION.SDK_INT > 15) {
            this.tvBadge.setBackground(gradientDrawable);
        } else {
            this.tvBadge.setBackgroundDrawable(gradientDrawable);
        }
        WalletCdpKit walletCdpKit = WalletCdpKit.getInstance();
        Context context = getContext();
        CdpContentInfo cdpContentInfo = this.mCdpContentInfo;
        walletCdpKit.addFatigueAction(context, cdpContentInfo.spaceCode, cdpContentInfo.deliverId, CdpFatigueInfo.ACTION_EXPOSURE, null);
    }

    public String appendSourceInfoForUrl(String str) {
        if (this.mCdpContentInfo == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("sourceInfo");
        String trackingCodeQueryPair = getTrackingCodeQueryPair();
        if (queryParameter != null) {
            Uri.Builder buildUpon = CdpUtils.removeQueryParameterFromUri(parse, "sourceInfo").buildUpon();
            StringBuilder sb = new StringBuilder();
            sb.append(queryParameter);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(trackingCodeQueryPair);
            return buildUpon.appendQueryParameter("sourceInfo", sb.toString()).build().toString();
        }
        return parse.buildUpon().appendQueryParameter("sourceInfo", trackingCodeQueryPair).build().toString();
    }

    public String getTrackingCodeQueryPair() {
        CdpContentInfo cdpContentInfo = this.mCdpContentInfo;
        if (cdpContentInfo != null) {
            String str = cdpContentInfo.trackingCode;
            StringBuilder sb = new StringBuilder();
            sb.append("trackingCode=");
            sb.append(str);
            return sb.toString();
        }
        return "";
    }

    @Override // com.iap.ac.android.region.cdp.ui.ICdpView
    public String getType() {
        return CdpSpaceInfo.SPACE_TYPE_BADGE;
    }

    @Override // com.iap.ac.android.region.cdp.ui.ICdpView
    public void renderWithSpaceInfo(CdpSpaceInfo cdpSpaceInfo) {
        if (!getType().equals(cdpSpaceInfo.type)) {
            setVisibility(8);
            String str = TAG;
            StringBuilder a2 = a.a("type ");
            a2.append(cdpSpaceInfo.type);
            a2.append(" is not supported by ");
            a2.append("BadgeView");
            ACLog.e(str, a2.toString());
        } else if (CdpUtils.isEmpty(cdpSpaceInfo.contentInfos)) {
            setVisibility(8);
            String str2 = TAG;
            StringBuilder a3 = a.a("spaceCode: %s, contentInfo is empty in  ");
            a3.append("BadgeView");
            ACLog.w(str2, String.format(a3.toString(), cdpSpaceInfo.spaceCode));
        } else {
            setVisibility(0);
            CdpContentInfo cdpContentInfo = cdpSpaceInfo.contentInfos.get(0);
            this.mCdpContentInfo = cdpContentInfo;
            renderBadge(cdpContentInfo, cdpSpaceInfo.width, cdpSpaceInfo.height);
        }
    }

    public void reportClickAction() {
        if (this.mCdpContentInfo != null) {
            WalletCdpKit walletCdpKit = WalletCdpKit.getInstance();
            Context context = getContext();
            CdpContentInfo cdpContentInfo = this.mCdpContentInfo;
            walletCdpKit.addFatigueAction(context, cdpContentInfo.spaceCode, cdpContentInfo.deliverId, CdpFatigueInfo.ACTION_CLICK, new AddFatigueActionCallback() { // from class: com.iap.ac.android.region.cdp.ui.badge.BadgeView.1
                @Override // com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback
                public void onFailure(Exception exc) {
                }

                @Override // com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback
                public void onSuccess(boolean z) {
                    if (z) {
                        BadgeView.this.setVisibility(8);
                    }
                }
            });
        }
    }

    public void setWidthHeight(int i, int i2) {
        int dp2px = (int) CdpUtils.dp2px(getContext(), i);
        int dp2px2 = (int) CdpUtils.dp2px(getContext(), i2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(dp2px, dp2px2);
        } else {
            layoutParams.width = dp2px;
            layoutParams.height = dp2px2;
        }
        setLayoutParams(layoutParams);
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
