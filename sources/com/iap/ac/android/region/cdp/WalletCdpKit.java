package com.iap.ac.android.region.cdp;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.component.AmcsConfigComponent;
import com.iap.ac.android.region.cdp.component.BehaviorComponent;
import com.iap.ac.android.region.cdp.component.FatigueComponent;
import com.iap.ac.android.region.cdp.component.GetSpaceInfoComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.component.RemoteDataSourceComponent;
import com.iap.ac.android.region.cdp.component.UpdatePolicyComponent;
import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import com.iap.ac.android.region.cdp.component.callback.FetchBadgeViewWithCodesCallback;
import com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback;
import com.iap.ac.android.region.cdp.component.defaults.DefaultAmcsConfigComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultBehaviorComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultFatigueComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultGetSpaceInfoComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultLocalStorageComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultRemoteDataSourceComponent;
import com.iap.ac.android.region.cdp.component.defaults.DefaultUpdatePolicyComponent;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.ui.badge.BadgeView;
import com.iap.ac.android.region.cdp.ui.badge.BadgeWrapperLayout;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.SpProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class WalletCdpKit {
    public Context mApplicationContext;
    public long mTimeInMillis;
    public TimeZone mTimezone;
    public static final String TAG = CdpUtils.logTag("WalletCdpKit");
    public static final WalletCdpKit INSTANCE = new WalletCdpKit();
    public final Map<Class<?>, Object> mRegisteredComponents = new HashMap();
    public final Map<String, WeakReference<BadgeView>> spaceCodeBadgeViewMap = new HashMap();
    public boolean isInitialed = false;

    public static WalletCdpKit getInstance() {
        return INSTANCE;
    }

    private void initIfNeed(Context context) {
        synchronized (this) {
            if (this.isInitialed) {
                return;
            }
            this.isInitialed = true;
            this.mApplicationContext = context.getApplicationContext();
            initComponents();
        }
    }

    private <T> void setComponent(Class<T> cls, T t) {
        synchronized (this) {
            Object put = this.mRegisteredComponents.put(cls, t);
            if (put == null) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("set component of type ");
                sb.append(cls);
                sb.append(" successful, no previous component is replaced");
                ACLog.d(str, sb.toString());
            } else {
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("set component of type ");
                sb2.append(cls);
                sb2.append(" successful, the previous component ");
                sb2.append(put);
                sb2.append(" is replaced");
                ACLog.d(str2, sb2.toString());
            }
        }
    }

    public void addFatigueAction(Context context, String str, String str2, String str3, AddFatigueActionCallback addFatigueActionCallback) {
        initIfNeed(context);
        BehaviorComponent behaviorComponent = (BehaviorComponent) getComponent(BehaviorComponent.class);
        if (behaviorComponent != null) {
            behaviorComponent.addBehavior(str, str2, str3, false, addFatigueActionCallback);
        }
    }

    public String appendSourceInfoForUrlBySpaceCode(String str, String str2) {
        BadgeView badgeView;
        WeakReference<BadgeView> weakReference = this.spaceCodeBadgeViewMap.get(str2);
        return (weakReference == null || (badgeView = weakReference.get()) == null) ? str : badgeView.appendSourceInfoForUrl(str);
    }

    public BadgeWrapperLayout attachContainerToBadge(View view, String str) {
        initIfNeed(view.getContext());
        return BadgeWrapperLayout.attachToRightTop(view, str, true, new Point());
    }

    public Map<String, BadgeView> fetchBadgeViewWithCodes(Context context, List<String> list) {
        return fetchBadgeViewWithCodes(context, list, null);
    }

    public Context getApplicationContextOrThrow() {
        Context context = this.mApplicationContext;
        if (context != null) {
            return context;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(WalletCdpKit.class.getName());
        sb.append(" has not initialized");
        throw new IllegalStateException(sb.toString());
    }

    public <T> T getComponent(Class<T> cls) {
        T t;
        synchronized (this) {
            t = (T) this.mRegisteredComponents.get(cls);
        }
        return t;
    }

    public void getSpaceInfoMap(Context context, List<String> list, GetSpaceInfoCallback getSpaceInfoCallback) {
        initIfNeed(context);
        if (RegionRPCConfigCenter.INSTANCE.getRegionBizToggle() && isCdpEnable()) {
            GetSpaceInfoComponent getSpaceInfoComponent = (GetSpaceInfoComponent) getComponent(GetSpaceInfoComponent.class);
            if (getSpaceInfoComponent != null) {
                getSpaceInfoComponent.getSpaceInfoMap(list, null, getSpaceInfoCallback);
                return;
            } else {
                getSpaceInfoCallback.onFailure(new RuntimeException("GetSpaceInfoComponent not exists!"));
                return;
            }
        }
        getSpaceInfoCallback.onFailure(new Exception("the wallet cdp is disabled in amcs."));
    }

    public long getTimeInMillis() {
        return this.mTimeInMillis;
    }

    public TimeZone getTimezone() {
        TimeZone timeZone = this.mTimezone;
        return timeZone != null ? timeZone : TimeZone.getDefault();
    }

    public String getTrackingCodeQueryPairBySpaceCode(String str) {
        BadgeView badgeView;
        WeakReference<BadgeView> weakReference = this.spaceCodeBadgeViewMap.get(str);
        if (weakReference == null || (badgeView = weakReference.get()) == null) {
            return null;
        }
        return badgeView.getTrackingCodeQueryPair();
    }

    public void initComponents() {
        synchronized (this) {
            setComponent(RemoteDataSourceComponent.class, new DefaultRemoteDataSourceComponent());
            setComponent(GetSpaceInfoComponent.class, new DefaultGetSpaceInfoComponent());
            setComponent(UpdatePolicyComponent.class, new DefaultUpdatePolicyComponent());
            setComponent(LocalStorageComponent.class, new DefaultLocalStorageComponent());
            setComponent(AmcsConfigComponent.class, new DefaultAmcsConfigComponent());
            setComponent(FatigueComponent.class, new DefaultFatigueComponent());
            setComponent(BehaviorComponent.class, new DefaultBehaviorComponent());
        }
    }

    public boolean isCdpEnable() {
        AmcsConfigComponent amcsConfigComponent = (AmcsConfigComponent) getComponent(AmcsConfigComponent.class);
        return amcsConfigComponent == null || amcsConfigComponent.isCdpEnable();
    }

    public void removeContainerWithBadgeView(View view) {
        initIfNeed(view.getContext());
        BadgeWrapperLayout.removeBadgeView(view);
    }

    public void reportClickAction(String str) {
        BadgeView badgeView;
        WeakReference<BadgeView> weakReference = this.spaceCodeBadgeViewMap.get(str);
        if (weakReference == null || (badgeView = weakReference.get()) == null) {
            return;
        }
        badgeView.reportClickAction();
    }

    public void setTimeInMillis(long j) {
        if (j > 0) {
            this.mTimeInMillis = j;
        } else {
            this.mTimeInMillis = System.currentTimeMillis();
        }
        SpProvider.getInstance().saveHttpRespTimeMillis(this.mTimeInMillis);
        SpProvider.getInstance().saveHttpRespTimeMillisStart();
    }

    public void setTimezone(TimeZone timeZone) {
        this.mTimezone = timeZone;
    }

    public Map<String, BadgeView> fetchBadgeViewWithCodes(Context context, List<String> list, final FetchBadgeViewWithCodesCallback fetchBadgeViewWithCodesCallback) {
        BadgeView badgeView;
        initIfNeed(context);
        final HashMap hashMap = new HashMap();
        for (String str : list) {
            WeakReference<BadgeView> weakReference = this.spaceCodeBadgeViewMap.get(str);
            if (weakReference != null && weakReference.get() != null && weakReference.get().getParent() == null) {
                badgeView = weakReference.get();
            } else {
                badgeView = new BadgeView(context);
                this.spaceCodeBadgeViewMap.put(str, new WeakReference<>(badgeView));
            }
            hashMap.put(str, badgeView);
        }
        getSpaceInfoMap(context, list, new GetSpaceInfoCallback() { // from class: com.iap.ac.android.region.cdp.WalletCdpKit.1
            @Override // com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback
            public void onFailure(Exception exc) {
                FetchBadgeViewWithCodesCallback fetchBadgeViewWithCodesCallback2 = fetchBadgeViewWithCodesCallback;
                if (fetchBadgeViewWithCodesCallback2 != null) {
                    fetchBadgeViewWithCodesCallback2.onFailure(exc);
                }
            }

            @Override // com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback
            public void onSuccess(Map<String, CdpSpaceInfo> map) {
                for (CdpSpaceInfo cdpSpaceInfo : map.values()) {
                    BadgeView badgeView2 = (BadgeView) hashMap.get(cdpSpaceInfo.spaceCode);
                    if (badgeView2 != null) {
                        badgeView2.renderWithSpaceInfo(cdpSpaceInfo);
                    }
                }
                FetchBadgeViewWithCodesCallback fetchBadgeViewWithCodesCallback2 = fetchBadgeViewWithCodesCallback;
                if (fetchBadgeViewWithCodesCallback2 != null) {
                    fetchBadgeViewWithCodesCallback2.onSuccess(hashMap);
                }
            }
        });
        return hashMap;
    }

    public BadgeWrapperLayout attachContainerToBadge(View view, String str, boolean z, Point point) {
        initIfNeed(view.getContext());
        return BadgeWrapperLayout.attachToRightTop(view, str, z, point);
    }

    public void addFatigueAction(Context context, String str, String str2, String str3, boolean z, AddFatigueActionCallback addFatigueActionCallback) {
        initIfNeed(context);
        BehaviorComponent behaviorComponent = (BehaviorComponent) getComponent(BehaviorComponent.class);
        if (behaviorComponent != null) {
            behaviorComponent.addBehavior(str, str2, str3, z, addFatigueActionCallback);
        }
    }
}
