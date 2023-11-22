package com.iap.ac.android.acs.operation.biz.region.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.iap.ac.android.acs.operation.R;
import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.operation.biz.region.bean.HeartBeatResult;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;
import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import com.iap.ac.android.acs.operation.biz.region.menu.repository.AddFavoriteRepository;
import com.iap.ac.android.acs.operation.biz.region.menu.repository.HeartBeatRepository;
import com.iap.ac.android.acs.operation.biz.region.menu.repository.RemoveFavoriteRepository;
import com.iap.ac.android.acs.operation.biz.region.utils.ToastUtils;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.container.provider.ui.AppFavoriteStatus;
import com.iap.ac.android.common.container.provider.ui.ContainerMoreMenuItemType;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RegionMenuProvider extends ContainerUIProvider implements IContainerListener {
    public static final long DELAY_TIME = 3000;
    public static final String H5_APP_ID = "null_online";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_BIZ_QUERY = "bizQuery";
    public static final String KEY_CONTAINER_VERSION = "containerVersion";
    public static final String KEY_PATH = "path";
    public static final String KEY_SOURCE_INFO = "sourceInfo";
    public HeartBeatResult mMenuExtraInfoResult;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public boolean hasReachedFavoriteLimit = false;
    public String notificationBoxItemAppId = "";
    public String feedbackItemAppId = "";
    public String subscriptionAppId = "";

    /* renamed from: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$common$container$provider$ui$AppFavoriteStatus;
        public static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType;

        static {
            int[] iArr = new int[ContainerMoreMenuItemType.values().length];
            $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType = iArr;
            try {
                iArr[ContainerMoreMenuItemType.Notification.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Subscription.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Feedback.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Favorite.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[AppFavoriteStatus.values().length];
            $SwitchMap$com$iap$ac$android$common$container$provider$ui$AppFavoriteStatus = iArr2;
            try {
                iArr2[AppFavoriteStatus.Unknow.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$AppFavoriteStatus[AppFavoriteStatus.Uncollected.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$AppFavoriteStatus[AppFavoriteStatus.Collected.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void showToast(Context context, int i, int i2) {
        ToastUtils.showToast(context, context.getResources().getString(i), i2, 0, 0, 0);
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public boolean itemShowFilter(String str, ContainerMoreMenuItemType containerMoreMenuItemType) {
        int i = AnonymousClass4.$SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[containerMoreMenuItemType.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public boolean itemShowRedDot(String str, ContainerMoreMenuItemType containerMoreMenuItemType) {
        if (AnonymousClass4.$SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[containerMoreMenuItemType.ordinal()] != 1) {
            return false;
        }
        return RegionRPCConfigCenter.INSTANCE.getNotificationBoxRedDotEnabled();
    }

    @Override // com.iap.ac.android.common.container.event.IContainerListener
    public void onContainerCreated(final Bundle bundle) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider.3
            @Override // java.lang.Runnable
            public void run() {
                if (RegionRPCConfigCenter.INSTANCE.heartBeatEnabled()) {
                    String string = bundle.getString("appId");
                    if (!TextUtils.isEmpty(string) && !"null_online".equals(string)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("appId", string);
                        if (bundle.containsKey("containerVersion")) {
                            hashMap.put("containerVersion", bundle.getString("containerVersion", ""));
                        }
                        if (bundle.containsKey("path")) {
                            hashMap.put("path", bundle.getString("path", ""));
                        }
                        if (bundle.containsKey("sourceInfo")) {
                            hashMap.put("sourceInfo", bundle.getString("sourceInfo", ""));
                        }
                        if (bundle.containsKey(RegionMenuProvider.KEY_BIZ_QUERY)) {
                            hashMap.put(RegionMenuProvider.KEY_BIZ_QUERY, bundle.getString(RegionMenuProvider.KEY_BIZ_QUERY, ""));
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(MenuExtraInfo.MENU_ID_COLLECT);
                        arrayList.add(MenuExtraInfo.MENU_ID_NOTIFICATION);
                        arrayList.add(MenuExtraInfo.MENU_ID_FEEDBACK);
                        arrayList.add(MenuExtraInfo.MENU_ID_SUBSCRIPTION);
                        arrayList.add(MenuExtraInfo.MENU_ID_PANEL_COLLECT);
                        arrayList.add(MenuExtraInfo.MENU_ID_TITLE_BAR_COLLECT);
                        HeartBeatRepository heartBeatRepository = new HeartBeatRepository();
                        RegionMenuProvider.this.mMenuExtraInfoResult = heartBeatRepository.heartBeat(string, hashMap, arrayList);
                        if (RegionMenuProvider.this.mMenuExtraInfoResult == null || !RegionMenuProvider.this.mMenuExtraInfoResult.success) {
                            return;
                        }
                        for (Map.Entry<String, MenuExtraInfo> entry : RegionMenuProvider.this.mMenuExtraInfoResult.menuExtraInfos.entrySet()) {
                            String key = entry.getKey();
                            key.hashCode();
                            char c = 65535;
                            switch (key.hashCode()) {
                                case -1307328690:
                                    if (key.equals(MenuExtraInfo.MENU_ID_NOTIFICATION)) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case -389793064:
                                    if (key.equals(MenuExtraInfo.MENU_ID_PANEL_COLLECT)) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 1265220823:
                                    if (key.equals(MenuExtraInfo.MENU_ID_FEEDBACK)) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 1331507567:
                                    if (key.equals(MenuExtraInfo.MENU_ID_SUBSCRIPTION)) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 1953607805:
                                    if (key.equals(MenuExtraInfo.MENU_ID_TITLE_BAR_COLLECT)) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                            }
                            if (c == 0) {
                                RegionMenuProvider.this.notificationBoxItemAppId = entry.getValue().appId;
                                RegionMenuProvider.this.setShowRedDot(string, ContainerMoreMenuItemType.Notification, entry.getValue().showRedDot);
                                RegionMenuProvider.this.setShowMenuItem(string, ContainerMoreMenuItemType.Notification, entry.getValue().showMenuItem, entry.getValue().itemInfos);
                            } else if (c == 1) {
                                Object obj = entry.getValue().customData.get(MenuExtraInfo.CUSTOM_DATA_COLLECTED_STATUS);
                                Object obj2 = entry.getValue().customData.get(MenuExtraInfo.CUSTOM_DATA_COLLECTED_REACHED_LIMIT);
                                if (obj instanceof Boolean) {
                                    if (((Boolean) obj).booleanValue()) {
                                        RegionMenuProvider.this.setFavoriteStatus(string, AppFavoriteStatus.Collected);
                                    } else {
                                        RegionMenuProvider.this.setFavoriteStatus(string, AppFavoriteStatus.Uncollected);
                                    }
                                }
                                if (obj2 != null && (obj2 instanceof Boolean)) {
                                    RegionMenuProvider.this.hasReachedFavoriteLimit = ((Boolean) obj2).booleanValue();
                                }
                                RegionMenuProvider.this.setShowMenuItem(string, ContainerMoreMenuItemType.Favorite, entry.getValue().showMenuItem, entry.getValue().itemInfos);
                            } else if (c == 2) {
                                RegionMenuProvider.this.feedbackItemAppId = entry.getValue().appId;
                                RegionMenuProvider.this.setShowMenuItem(string, ContainerMoreMenuItemType.Feedback, entry.getValue().showMenuItem, entry.getValue().itemInfos);
                            } else if (c == 3) {
                                RegionMenuProvider.this.subscriptionAppId = entry.getValue().appId;
                                RegionMenuProvider.this.setShowRedDot(string, ContainerMoreMenuItemType.Subscription, entry.getValue().showRedDot);
                                RegionMenuProvider.this.setShowMenuItem(string, ContainerMoreMenuItemType.Subscription, entry.getValue().showMenuItem, entry.getValue().itemInfos);
                            } else if (c == 4) {
                                Object obj3 = entry.getValue().customData.get(MenuExtraInfo.CUSTOM_DATA_COLLECTED_STATUS);
                                Object obj4 = entry.getValue().customData.get(MenuExtraInfo.CUSTOM_DATA_COLLECTED_REACHED_LIMIT);
                                if (obj3 instanceof Boolean) {
                                    if (((Boolean) obj3).booleanValue()) {
                                        RegionMenuProvider.this.setFavoriteStatus(string, AppFavoriteStatus.Collected);
                                    } else {
                                        RegionMenuProvider.this.setFavoriteStatus(string, AppFavoriteStatus.Uncollected);
                                    }
                                }
                                if (obj4 != null && (obj4 instanceof Boolean)) {
                                    RegionMenuProvider.this.hasReachedFavoriteLimit = ((Boolean) obj4).booleanValue();
                                }
                                RegionMenuProvider.this.setShowTitleItem(string, ContainerMoreMenuItemType.Favorite, entry.getValue().showMenuItem, entry.getValue().itemInfos);
                            }
                        }
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Report mini program open record failed, because appId is empty or app is h5, appId=");
                    sb.append(string);
                    ACLog.i("IAPConnectPlugin", sb.toString());
                }
            }
        });
    }

    @Override // com.iap.ac.android.common.container.event.IContainerListener
    public void onContainerDestroyed(Bundle bundle) {
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public void onContainerFavoriteMenuClick(final String str, String str2, AppFavoriteStatus appFavoriteStatus, Bundle bundle) {
        int i = AnonymousClass4.$SwitchMap$com$iap$ac$android$common$container$provider$ui$AppFavoriteStatus[appFavoriteStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.hasReachedFavoriteLimit = false;
                    setFavoriteStatus(str, AppFavoriteStatus.Uncollected);
                    this.handler.removeCallbacksAndMessages(null);
                    this.handler.postDelayed(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    new RemoveFavoriteRepository().removeFavorite(str);
                                }
                            });
                        }
                    }, 3000L);
                    return;
                }
                return;
            }
            Context context = RegionManager.getInstance().getContext();
            if (this.hasReachedFavoriteLimit) {
                showToast(context, R.string.favority_max, 0);
                return;
            }
            showToast(context, R.string.add_favority, R.drawable.core_toast_ok);
            setFavoriteStatus(str, AppFavoriteStatus.Collected);
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.operation.biz.region.menu.RegionMenuProvider.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            new AddFavoriteRepository().addFavorite(str);
                        }
                    });
                }
            }, 3000L);
        }
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public void onContainerFeedbackMenuClick(String str, String str2, Bundle bundle) {
        Context context = RegionManager.getInstance().getContext();
        if (TextUtils.isEmpty(this.feedbackItemAppId) || context == null) {
            return;
        }
        ContainerParams createForMniProgram = ContainerParams.createForMniProgram(this.feedbackItemAppId);
        createForMniProgram.containerBundle = new Bundle();
        Bundle bundle2 = createForMniProgram.containerBundle;
        StringBuilder sb = new StringBuilder();
        sb.append("appId=");
        sb.append(str);
        sb.append("&appName=");
        sb.append(str2);
        bundle2.putString("query", sb.toString());
        WebContainer.getInstance("ac_biz").startContainer(context, createForMniProgram);
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public void onContainerNotificationMenuClick(String str, String str2, Bundle bundle) {
        Context context = RegionManager.getInstance().getContext();
        if (TextUtils.isEmpty(this.notificationBoxItemAppId) || context == null) {
            return;
        }
        ContainerParams createForMniProgram = ContainerParams.createForMniProgram(this.notificationBoxItemAppId);
        createForMniProgram.containerBundle = new Bundle();
        Bundle bundle2 = createForMniProgram.containerBundle;
        StringBuilder sb = new StringBuilder();
        sb.append("appId=");
        sb.append(str);
        sb.append("&appName=");
        sb.append(str2);
        bundle2.putString("query", sb.toString());
        WebContainer.getInstance("ac_biz").startContainer(context, createForMniProgram);
        setShowRedDot(str, ContainerMoreMenuItemType.Notification, false);
    }

    @Override // com.iap.ac.android.common.container.provider.ui.ContainerUIProvider
    public void onContainerSubscriptionMenuClick(String str, String str2, Bundle bundle) {
        Context context = RegionManager.getInstance().getContext();
        if (TextUtils.isEmpty(this.subscriptionAppId) || context == null) {
            return;
        }
        ContainerParams createForMniProgram = ContainerParams.createForMniProgram(this.subscriptionAppId);
        createForMniProgram.containerBundle = new Bundle();
        Bundle bundle2 = createForMniProgram.containerBundle;
        StringBuilder sb = new StringBuilder();
        sb.append("appId=");
        sb.append(str);
        sb.append("&notificationBoxAppId=");
        sb.append(this.notificationBoxItemAppId);
        bundle2.putString("query", sb.toString());
        WebContainer.getInstance("ac_biz").startContainer(context, createForMniProgram);
    }
}
