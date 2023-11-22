package com.alipay.iap.android.common.product.delegate;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class UserInfoManager implements IAPUserDelegate {
    private static final String SEED_ID_LOGIN = "iap_common_user_login";
    private static final String SEED_ID_LOGOUT = "iap_common_user_logout";
    private static final String TAG = "com.alipay.iap.android.common.product.delegate.UserInfoManager";
    private static UserInfoManager instance;
    private ICheckPermission checkPermissionCallback;
    private IAPLoginUserInfo currentLoginUser;
    private final Object observersLock = new Object();
    private ArrayList<IAPUserChangeObserver> userChangeObservers = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface ICheckPermission {
        boolean checkPermission(IAPLoginUserInfo iAPLoginUserInfo);
    }

    private UserInfoManager() {
    }

    public static UserInfoManager instance() {
        UserInfoManager userInfoManager;
        synchronized (UserInfoManager.class) {
            if (instance == null) {
                instance = new UserInfoManager();
            }
            userInfoManager = instance;
        }
        return userInfoManager;
    }

    public void release() {
        instance = null;
        synchronized (this.observersLock) {
            ArrayList<IAPUserChangeObserver> arrayList = this.userChangeObservers;
            if (arrayList != null) {
                arrayList.clear();
                this.userChangeObservers = null;
            }
        }
    }

    public void loginNotify(IAPLoginUserInfo iAPLoginUserInfo) {
        synchronized (this) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("valid", iAPLoginUserInfo == null ? "0" : "1");
            hashMap.put("userID", iAPLoginUserInfo == null ? "" : iAPLoginUserInfo.userID);
            hashMap.put("loginID", iAPLoginUserInfo == null ? "" : iAPLoginUserInfo.loginID);
            MonitorWrapper.behaviour(SEED_ID_LOGIN, hashMap);
            if (iAPLoginUserInfo == null) {
                LoggerWrapper.e(TAG, "login notify: with a null user info");
                return;
            }
            IAPLoginUserInfo iAPLoginUserInfo2 = this.currentLoginUser;
            if (iAPLoginUserInfo2 == null) {
                notifyUserLogin(iAPLoginUserInfo, false);
            } else if (iAPLoginUserInfo.equals(iAPLoginUserInfo2)) {
            } else {
                if (!TextUtils.isEmpty(iAPLoginUserInfo.userID)) {
                    if (!TextUtils.equals(iAPLoginUserInfo.userID, this.currentLoginUser.userID)) {
                        notifyUserLogin(iAPLoginUserInfo, true);
                    } else if (!TextUtils.equals(iAPLoginUserInfo.sessionID, this.currentLoginUser.sessionID)) {
                        notifyUserLogin(iAPLoginUserInfo, false);
                    } else {
                        LoggerWrapper.w(TAG, "login notify: user id and session id is the same but with a different login id");
                    }
                } else if (!TextUtils.isEmpty(this.currentLoginUser.userID)) {
                    LoggerWrapper.w(TAG, "login notify: the user id of the input user info is null");
                } else if (!TextUtils.isEmpty(iAPLoginUserInfo.loginID)) {
                    if (!TextUtils.equals(iAPLoginUserInfo.loginID, this.currentLoginUser.loginID)) {
                        notifyUserLogin(iAPLoginUserInfo, true);
                    } else {
                        notifyUserLogin(iAPLoginUserInfo, false);
                    }
                }
            }
        }
    }

    public void logoutNotify() {
        LoggerWrapper.i(TAG, "notify user logout");
        synchronized (this) {
            this.currentLoginUser = null;
            MonitorWrapper.behaviour(SEED_ID_LOGOUT, null);
            new AsyncTask<Void, Void, Void>() { // from class: com.alipay.iap.android.common.product.delegate.UserInfoManager.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        synchronized (UserInfoManager.this.observersLock) {
                            if (UserInfoManager.this.userChangeObservers != null) {
                                Iterator it = UserInfoManager.this.userChangeObservers.iterator();
                                while (it.hasNext()) {
                                    ((IAPUserChangeObserver) it.next()).onUserLogout();
                                }
                            }
                        }
                        return null;
                    } catch (Exception e) {
                        LoggerWrapper.e(UserInfoManager.TAG, "logout notify", e);
                        return null;
                    }
                }
            }.execute(new Void[0]);
        }
    }

    private void notifyUserLogin(final IAPLoginUserInfo iAPLoginUserInfo, boolean z) {
        this.currentLoginUser = iAPLoginUserInfo.m80clone();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("notify user login with isUserChanged=");
        sb.append(z);
        LoggerWrapper.i(str, sb.toString());
        new AsyncTask<Boolean, Void, Void>() { // from class: com.alipay.iap.android.common.product.delegate.UserInfoManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Boolean... boolArr) {
                boolean booleanValue = boolArr[0].booleanValue();
                try {
                    synchronized (UserInfoManager.this.observersLock) {
                        if (UserInfoManager.this.userChangeObservers != null) {
                            Iterator it = UserInfoManager.this.userChangeObservers.iterator();
                            if (booleanValue) {
                                while (it.hasNext()) {
                                    ((IAPUserChangeObserver) it.next()).onUserChanged(iAPLoginUserInfo);
                                }
                            } else {
                                while (it.hasNext()) {
                                    ((IAPUserChangeObserver) it.next()).onUserLogin(iAPLoginUserInfo);
                                }
                            }
                        }
                    }
                    return null;
                } catch (Exception e) {
                    LoggerWrapper.e(UserInfoManager.TAG, "login notify", e);
                    return null;
                }
            }
        }.execute(Boolean.valueOf(z));
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public String getUserId() {
        synchronized (this) {
            IAPLoginUserInfo iAPLoginUserInfo = this.currentLoginUser;
            if (iAPLoginUserInfo != null) {
                return iAPLoginUserInfo.userID;
            }
            return null;
        }
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public String getLoginId() {
        synchronized (this) {
            IAPLoginUserInfo iAPLoginUserInfo = this.currentLoginUser;
            if (iAPLoginUserInfo != null) {
                return iAPLoginUserInfo.loginID;
            }
            return null;
        }
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public IAPLoginUserInfo getUserInfo() {
        return this.currentLoginUser;
    }

    public void setICheckPermissionCallback(ICheckPermission iCheckPermission) {
        this.checkPermissionCallback = iCheckPermission;
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public boolean checkPermission() {
        ICheckPermission iCheckPermission = this.checkPermissionCallback;
        if (iCheckPermission == null) {
            return this.currentLoginUser != null;
        }
        return iCheckPermission.checkPermission(this.currentLoginUser);
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public void addUserChangeObserver(IAPUserChangeObserver iAPUserChangeObserver) {
        synchronized (this.observersLock) {
            if (iAPUserChangeObserver != null) {
                ArrayList<IAPUserChangeObserver> arrayList = this.userChangeObservers;
                if (arrayList != null && !arrayList.contains(iAPUserChangeObserver)) {
                    this.userChangeObservers.add(iAPUserChangeObserver);
                }
            }
        }
    }

    @Override // com.alipay.iap.android.common.product.delegate.IAPUserDelegate
    public void removeUserChangeObserver(IAPUserChangeObserver iAPUserChangeObserver) {
        if (iAPUserChangeObserver == null) {
            return;
        }
        synchronized (this.observersLock) {
            this.userChangeObservers.remove(iAPUserChangeObserver);
        }
    }
}
