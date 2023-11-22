package com.zoloz.android.phone.zdoc.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView;
import com.zoloz.android.phone.zdoc.R;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes8.dex */
public abstract class BaseCameraPermissionFragment extends BaseFragment implements PermissionDialogEvent {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
    private boolean isFirst = true;
    private CameraSurfaceView mCameraSurfaceView;
    protected View mRootView;

    protected abstract void alertCameraNoPermissionDialog(PermissionDialogEvent permissionDialogEvent);

    protected abstract void alertSystemError();

    protected abstract int getLayoutId();

    protected abstract void onCameraInit();

    protected abstract void onInitView();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.mRootView;
        if (view == null) {
            try {
                this.mRootView = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            } catch (Exception unused) {
                alertSystemError();
            }
            initView();
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mRootView);
            }
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        CameraSurfaceView cameraSurfaceView = (CameraSurfaceView) findViewById(R.id.surface);
        this.mCameraSurfaceView = cameraSurfaceView;
        cameraSurfaceView.setVisibility(4);
        this.mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.surface);
        onInitView();
        onCameraInit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mCameraSurfaceView.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mCameraSurfaceView.setVisibility(4);
    }

    public void checkCameraPermission() {
        if (!this.isFirst) {
            alertCameraNoPermissionDialog(this);
            return;
        }
        this.isFirst = false;
        if (hasCameraPermission()) {
            dealCameraHasPermission();
        } else {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasCameraPermission() {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getActivity(), "android.permission.CAMERA") == 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                dealCameraHasPermission();
            } else {
                alertCameraNoPermissionDialog(this);
            }
        }
    }

    protected void dealCameraHasPermission() {
        if (this.mCameraSurfaceView != null) {
            onCameraInit();
            this.mCameraSurfaceView.setVisibility(0);
        }
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.PermissionDialogEvent
    public void execute() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(getContext().getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View findViewById(int i) {
        return this.mRootView.findViewById(i);
    }
}
