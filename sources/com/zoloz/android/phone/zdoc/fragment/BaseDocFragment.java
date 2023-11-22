package com.zoloz.android.phone.zdoc.fragment;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadCallBack;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.service.BioUploadService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;
import com.alipay.zoloz.hardware.camera.CameraData;
import com.alipay.zoloz.hardware.camera.ICameraCallback;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView;
import com.alipay.zoloz.toyger.algorithm.TGFrame;
import com.alipay.zoloz.toyger.blob.BitmapHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.zoloz.android.phone.zdoc.R;
import com.zoloz.android.phone.zdoc.R2;
import com.zoloz.android.phone.zdoc.cardmanager.FalconTaskManager;
import com.zoloz.android.phone.zdoc.cardmanager.ZdocResponse;
import com.zoloz.android.phone.zdoc.module.CollModule;
import com.zoloz.android.phone.zdoc.module.ZdocRemoteConfig;
import com.zoloz.android.phone.zdoc.render.MaskViewRender;
import com.zoloz.android.phone.zdoc.render.MessageViewRender;
import com.zoloz.android.phone.zdoc.render.TitleBarRender;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import com.zoloz.android.phone.zdoc.ui.BaseMaskView;
import com.zoloz.android.phone.zdoc.ui.IMessageView;
import com.zoloz.android.phone.zdoc.ui.UIFacade;
import com.zoloz.android.phone.zdoc.ui.UIState;
import com.zoloz.android.phone.zdoc.upload.UploadManager;
import com.zoloz.android.phone.zdoc.utils.ZdocRecordManager;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import zoloz.ap.com.toolkit.R2;
import zoloz.ap.com.toolkit.ui.DialogHelper;
import zoloz.ap.com.toolkit.ui.TitleBar;

/* loaded from: classes8.dex */
public class BaseDocFragment extends BaseCameraPermissionFragment implements ICameraCallback {
    private static final String TAG = "ZdocCaptureActivity";
    protected BioAppDescription mBioAppDescription;
    protected BioUploadService mBioUploadService;
    protected String mBisToken;
    protected ICameraInterface mCameraInterface;
    protected CameraSurfaceView mCameraSurfaceView;
    protected byte[] mContent;
    protected int mCurrentPageNumber;
    protected int mCurrentPageNumberIndex;
    protected int mCurrentRetryTimes;
    protected BaseMaskView mDefaultMaskView;
    protected DialogHelper mDialogHelper;
    protected String mDocType;
    protected boolean mIsUTF8;
    protected byte[] mKey;
    protected int mMaxRetryTimes;
    protected IMessageView mMessageView;
    protected ImageView mPhotoImageView;
    protected ZdocRecordManager mRecordManager;
    protected TitleBar mTitleBar;
    protected int mUiType;
    protected UploadManager mUploadManager;
    protected ZdocRemoteConfig mZdocRemoteConfig;
    public static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 91;
    public static final byte[] PlaceComponentResult = {18, -87, -121, -123, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 110;
    private Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    protected boolean mShowFrame = false;
    protected UIState mCurrentState = UIState.CAPTURE;
    protected boolean needRecordImageSize = true;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 105
            byte[] r0 = com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.PlaceComponentResult
            int r9 = r9 * 3
            int r9 = r9 + 16
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            int r6 = r6 * 2
            int r6 = 75 - r6
            int r7 = r7 * 3
            int r7 = r7 + 42
            byte[] r0 = com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.b(short, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSuccess() {
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceDestroyed() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (KeyEvent.getMaxKeyCode() >> 16), 4 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ExpandableListView.getPackedPositionType(0L));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1133290882, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, TextUtils.indexOf("", "") + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(bundle);
                if (BioServiceManager.getCurrentInstance() == null) {
                    new IllegalStateException("null == BioServiceManager.getCurrentInstance()");
                    getActivity().finish();
                    return;
                }
                initData();
                initUpload();
                this.mCurrentPageNumberIndex = 0;
                this.mRecordManager = new ZdocRecordManager();
                formatConfigs();
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    private void initData() {
        this.mBioAppDescription = (BioAppDescription) getArguments().getSerializable("bio");
        ZdocRemoteConfig zdocRemoteConfig = (ZdocRemoteConfig) getArguments().getSerializable("config");
        this.mZdocRemoteConfig = zdocRemoteConfig;
        BioAppDescription bioAppDescription = this.mBioAppDescription;
        if (bioAppDescription == null || zdocRemoteConfig == null) {
            return;
        }
        this.mBisToken = bioAppDescription.getBistoken();
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseCameraPermissionFragment
    protected int getLayoutId() {
        return UIFacade.getLayoutId(getActivity(), this.mUiType, this.mDocType, this.mCurrentPageNumber);
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseCameraPermissionFragment
    protected void alertSystemError() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null || dialogHelper.isShowing()) {
            return;
        }
        this.mRecordManager.recordAlertAppear(ZdocRecordService.SYSTEM_EXCEPTION_ERROR);
        this.mDialogHelper.alert(R2.string.system_error_title(), R2.string.system_error_msg(), R2.string.system_error_got_it(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.1
            {
                BaseDocFragment.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.SYSTEM_EXCEPTION_ERROR, Integer.toString(1));
                dialogInterface.dismiss();
                BaseDocFragment.this.responseWithCode(205, null);
            }
        }, null, null);
    }

    protected void alertSystemError(String str) {
        this.mRecordManager.recordSystemError(str);
        alertSystemError();
    }

    public Rect mappingToPic(Rect rect) {
        int previewHeight = CameraSurfaceView.getCameraImpl(getActivity()).getPreviewHeight();
        int previewWidth = CameraSurfaceView.getCameraImpl(getActivity()).getPreviewWidth();
        if (previewHeight >= previewWidth) {
            previewWidth = previewHeight;
            previewHeight = previewWidth;
        }
        int height = this.mCameraSurfaceView.getHeight();
        int width = this.mCameraSurfaceView.getWidth();
        int width2 = (width - this.mDefaultMaskView.getWidth()) / 2;
        int height2 = (height - this.mDefaultMaskView.getHeight()) / 2;
        Rect rect2 = new Rect(rect.left + width2, rect.top + height2, rect.right + width2, rect.bottom + height2);
        float f = previewHeight / width;
        int i = rect2.left;
        int i2 = rect2.right;
        int i3 = rect2.top;
        int i4 = rect2.bottom;
        rect2.left = (int) (rect2.left * f);
        float f2 = (previewWidth - (height * f)) / 2.0f;
        rect2.top = (int) ((rect2.top * f) + f2);
        rect2.right = (int) (rect2.right * f);
        rect2.bottom = (int) ((f * rect2.bottom) + f2);
        int i5 = rect2.left;
        int i6 = rect2.right;
        int i7 = rect2.top;
        int i8 = rect2.bottom;
        return rect2;
    }

    protected void formatConfigs() {
        ZdocRemoteConfig zdocRemoteConfig = this.mZdocRemoteConfig;
        if (zdocRemoteConfig == null) {
            return;
        }
        CollModule coll = zdocRemoteConfig.getModules().get(this.mCurrentPageNumberIndex).getColl();
        this.mUiType = coll.getUiType();
        this.mDocType = coll.getDocType();
        this.mCurrentPageNumber = coll.getPageNo();
        this.mCurrentRetryTimes = 0;
        this.mMaxRetryTimes = coll.getRetryLimit();
        this.mRecordManager.updatePageNumber(this.mCurrentPageNumber);
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseFragment
    public boolean onBackPressed() {
        interrupt();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mCurrentPageNumberIndex = 0;
        this.mCurrentPageNumber = 0;
        this.mCurrentRetryTimes = 0;
        this.mContent = null;
        this.mKey = null;
        IMessageView iMessageView = this.mMessageView;
        if (iMessageView != null) {
            iMessageView.clearClickListener();
        }
        TitleBar titleBar = this.mTitleBar;
        if (titleBar != null) {
            titleBar.setClickListener(null);
        }
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.forceDismissDialog();
            this.mDialogHelper.release();
            this.mDialogHelper = null;
        }
        ICameraInterface iCameraInterface = this.mCameraInterface;
        if (iCameraInterface != null) {
            iCameraInterface.releaseCamera();
        }
        if (this.mUploadManager != null) {
            this.mUploadManager = null;
        }
        this.mBioUploadService = null;
        ZdocRecordManager zdocRecordManager = this.mRecordManager;
        if (zdocRecordManager != null) {
            zdocRecordManager.destory();
        }
        super.onDestroy();
    }

    public void onWindowFocusChanged(boolean z) {
        if (!z || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.mMessageView.setUiLocation(this.mUiType, this.mDocType, this.mCurrentPageNumber, this.mCameraSurfaceView.getHeight(), this.mDefaultMaskView.getTipsBottomMargin(), this.mDefaultMaskView.getInvisibleHeight());
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceCreated() {
        this.mRecordManager.recordAuthCheck(1);
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onSurfaceChanged(final double d, final double d2) {
        this.mMainThreadHandler.post(new Runnable() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.2
            {
                BaseDocFragment.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseDocFragment.this.adjustPreview(d, d2);
            }
        });
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onError(int i) {
        if (i == -1) {
            this.mCameraSurfaceView.setVisibility(4);
            checkCameraPermission();
        } else if (i != 0) {
            this.mCameraSurfaceView.setVisibility(4);
            alertSystemError();
        }
    }

    @Override // com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onPreviewFrame(CameraData cameraData) {
        if (this.mShowFrame) {
            showPreviewImg(createTGFrame(cameraData));
            this.mShowFrame = false;
        }
        if (this.needRecordImageSize) {
            this.mRecordManager.recordImageSize(cameraData.getPreviewWidth(), cameraData.getPreviewHeight());
            this.needRecordImageSize = false;
        }
    }

    protected void adjustPreview(double d, double d2) {
        CameraSurfaceView cameraSurfaceView = this.mCameraSurfaceView;
        if (cameraSurfaceView != null) {
            ViewGroup.LayoutParams layoutParams = cameraSurfaceView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.mPhotoImageView.getLayoutParams();
            int width = this.mCameraSurfaceView.getWidth();
            int height = this.mCameraSurfaceView.getHeight();
            double d3 = width;
            Double.isNaN(d3);
            int i = (int) ((d3 / d) * d2);
            if (i >= height) {
                layoutParams.height = i;
                layoutParams2.height = i;
            } else {
                double d4 = height;
                Double.isNaN(d4);
                int i2 = (int) ((d4 / d2) * d);
                if (i2 >= width) {
                    layoutParams.width = i2;
                    layoutParams2.width = i2;
                }
            }
            this.mCameraSurfaceView.setLayoutParams(layoutParams);
            this.mPhotoImageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseCameraPermissionFragment
    protected void alertCameraNoPermissionDialog(final PermissionDialogEvent permissionDialogEvent) {
        ZdocRecordManager zdocRecordManager = this.mRecordManager;
        if (zdocRecordManager != null) {
            zdocRecordManager.recordAuthCheck(0);
        }
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.alert(R2.string.zdoc_camera_permission_title(), R2.string.zdoc_camera_permission_msg(), R2.string.zdoc_camera_permission_settings(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.3
                {
                    BaseDocFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    permissionDialogEvent.execute();
                }
            }, R2.string.zdoc_camera_permission_not_allow(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.4
                {
                    BaseDocFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.CAMERA_ERROR, Integer.toString(1));
                    BaseDocFragment.this.responseWithCode(100, null);
                }
            });
        }
    }

    private void initUpload() {
        if (this.mBioAppDescription == null || this.mZdocRemoteConfig == null) {
            return;
        }
        UploadManager uploadManager = new UploadManager(getActivity(), this.mBioAppDescription, this.mZdocRemoteConfig);
        this.mUploadManager = uploadManager;
        uploadManager.init();
        if (BioServiceManager.getCurrentInstance() == null) {
            new IllegalStateException("null == BioServiceManager.getCurrentInstance()");
            getActivity().finish();
            return;
        }
        BioUploadService bioUploadService = (BioUploadService) BioServiceManager.getCurrentInstance().getBioService(BioUploadService.class);
        this.mBioUploadService = bioUploadService;
        bioUploadService.clearUp();
        this.mBioUploadService.addCallBack(new BioUploadCallBack() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.5
            {
                BaseDocFragment.this = this;
            }

            @Override // com.alipay.mobile.security.bio.service.BioUploadCallBack
            public boolean onResponse(final BioUploadResult bioUploadResult) {
                BaseDocFragment.this.mRecordManager.recordBasicCheck();
                int i = bioUploadResult.productRetCode;
                if (i == 1001) {
                    BaseDocFragment.this.mRecordManager.recordUploadEnd(1, 1, 1001);
                    BaseDocFragment.this.updateUI(UIState.UPLOAD_END_SUCCESS);
                    new Handler().postDelayed(new Runnable() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.5.1
                        {
                            AnonymousClass5.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (BaseDocFragment.this.mDialogHelper != null) {
                                BaseDocFragment.this.mDialogHelper.dismissDialog();
                            }
                            BaseDocFragment.this.responseWithCode(500, bioUploadResult);
                        }
                    }, 800L);
                } else if (i == 1002) {
                    BaseDocFragment.this.handleSuccContinue();
                } else if (i == 2001) {
                    BaseDocFragment.this.mRecordManager.recordUploadEnd(1, 0, bioUploadResult.productRetCode);
                    BaseDocFragment.this.updateUI(UIState.UPLOAD_END_FAIL);
                    BaseDocFragment.this.failQuit(bioUploadResult);
                } else if (i == 2002) {
                    BaseDocFragment.this.handleFailRetry(bioUploadResult);
                } else if (i == 3001 || i == 3002) {
                    BaseDocFragment.this.handleNetWorkError();
                } else {
                    BaseDocFragment.this.mRecordManager.recordUploadEnd(1, 0, bioUploadResult.productRetCode);
                    BaseDocFragment.this.updateUI(UIState.UPLOAD_END_FAIL);
                    BaseDocFragment.this.updateUI(UIState.ALERT);
                    BaseDocFragment.this.alertSystemError();
                }
                return false;
            }
        });
    }

    public void handleFailRetry(final BioUploadResult bioUploadResult) {
        HashMap hashMap = new HashMap(bioUploadResult.extParams);
        char c = 0;
        this.mRecordManager.recordUploadEnd(1, 0, 2002);
        updateUI(UIState.UPLOAD_END_FAIL);
        this.mRecordManager.retry();
        this.mRecordManager.recordAlertAppear(ZdocRecordService.SERVER_QUALITY_ERROR);
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null || dialogHelper.isShowing()) {
            return;
        }
        updateUI(UIState.ALERT);
        if (this.mCurrentRetryTimes < this.mMaxRetryTimes) {
            String zdoc_unknow_title = R2.string.zdoc_unknow_title();
            String zdoc_unknow_msg = R2.string.zdoc_unknow_msg();
            try {
                String str = (String) JSON.parseObject((String) hashMap.get("clientExtInfo")).get("detectCode");
                if (!StringUtil.isNullorEmpty(str)) {
                    switch (str.hashCode()) {
                        case -2003602871:
                            if (str.equals("IMPERFECT")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1437569509:
                            if (str.equals("NO_FACE")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1143378681:
                            if (str.equals(CdpFatigueInfo.ACTION_EXPOSURE)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2041959:
                            if (str.equals("BLUR")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 228486029:
                            if (str.equals("WRONG_DOCUMENT")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 666915289:
                            if (str.equals("NO_DOCUMENT")) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 735991061:
                            if (str.equals("EXPIRED_DOCUMENT")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            zdoc_unknow_title = R2.string.zdoc_no_document_title();
                            zdoc_unknow_msg = R2.string.zdoc_no_document_msg();
                            break;
                        case 1:
                            zdoc_unknow_title = R2.string.zdoc_imperfect_title();
                            zdoc_unknow_msg = R2.string.zdoc_imperfect_msg();
                            break;
                        case 2:
                            zdoc_unknow_title = R2.string.zdoc_blur_title();
                            zdoc_unknow_msg = R2.string.zdoc_blur_msg();
                            break;
                        case 3:
                            zdoc_unknow_title = R2.string.zdoc_exposure_title();
                            zdoc_unknow_msg = R2.string.zdoc_exposure_msg();
                            break;
                        case 4:
                            zdoc_unknow_title = R2.string.zdoc_noface_title();
                            zdoc_unknow_msg = R2.string.zdoc_noface_msg();
                            break;
                        case 5:
                            zdoc_unknow_title = R2.string.zdoc_wrong_document_title();
                            zdoc_unknow_msg = R2.string.zdoc_wrong_document_msg();
                            break;
                        case 6:
                            zdoc_unknow_title = R2.string.zdoc_expired_document_title();
                            zdoc_unknow_msg = R2.string.zdoc_expired_document_msg();
                            break;
                    }
                }
            } catch (Exception unused) {
            }
            this.mDialogHelper.alert(zdoc_unknow_title, zdoc_unknow_msg, R2.string.zdoc_dialog_retry(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.6
                {
                    BaseDocFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseDocFragment.this.mCurrentRetryTimes++;
                    dialogInterface.dismiss();
                    BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.SERVER_QUALITY_ERROR, Integer.toString(1));
                    BaseDocFragment.this.retry();
                }
            }, R2.string.zdoc_dialog_close(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.7
                {
                    BaseDocFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.SERVER_QUALITY_ERROR, Integer.toString(0));
                    BaseDocFragment.this.responseWithCode(208, bioUploadResult);
                }
            });
            return;
        }
        failQuit(null);
    }

    protected void retry() {
        updateUI(UIState.CAPTURE);
    }

    public void handleSuccContinue() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.dismissDialog();
        }
        this.mCurrentRetryTimes = 0;
        this.mRecordManager.recordUploadEnd(1, 1, 1002);
        updateUI(UIState.UPLOAD_END_SUCCESS);
        int i = this.mCurrentPageNumberIndex + 1;
        this.mCurrentPageNumberIndex = i;
        if (i < this.mZdocRemoteConfig.getModules().size()) {
            new Handler().postDelayed(new Runnable() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.8
                {
                    BaseDocFragment.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    BaseDocFragment.this.updateUI(UIState.CAPTURE);
                    BaseDocFragment.this.formatConfigs();
                }
            }, 1000L);
        } else {
            this.mCurrentPageNumberIndex--;
        }
    }

    public void handleNetWorkError() {
        this.mRecordManager.recordUploadEnd(0, 0, 999);
        updateUI(UIState.UPLOAD_END_FAIL);
        this.mRecordManager.recordAlertAppear(ZdocRecordService.NETWORK_ERROR);
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null || dialogHelper.isShowing()) {
            return;
        }
        updateUI(UIState.ALERT);
        this.mDialogHelper.alert(R2.string.network_error_title(), R2.string.network_error_msg(), R2.string.network_error_retry(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.9
            {
                BaseDocFragment.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.NETWORK_ERROR, Integer.toString(1));
                BaseDocFragment.this.updateUI(UIState.UPLOADING);
                BaseDocFragment.this.upLoadImage();
            }
        }, R2.string.network_error_exit(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.10
            {
                BaseDocFragment.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.NETWORK_ERROR, Integer.toString(0));
                BaseDocFragment.this.responseWithCode(207, null);
            }
        });
    }

    public void upLoadImage() {
        if (this.mContent != null) {
            this.mRecordManager.recordUploadStart(r0.length);
            UploadManager uploadManager = this.mUploadManager;
            if (uploadManager != null) {
                uploadManager.setRetryTimes(this.mCurrentRetryTimes);
                this.mUploadManager.upload(this.mContent, this.mKey, this.mIsUTF8);
                return;
            }
            return;
        }
        alertSystemError();
    }

    public void responseWithCode(int i, BioUploadResult bioUploadResult) {
        ZdocResponse zdocResponse = new ZdocResponse();
        zdocResponse.retCode = i;
        zdocResponse.bioUploadResult = bioUploadResult;
        FalconTaskManager.getInstance().transResult(zdocResponse);
    }

    public void failQuit(final BioUploadResult bioUploadResult) {
        this.mRecordManager.recordAlertAppear(ZdocRecordService.OVER_THRESHOLD_ERROR);
        this.mRecordManager.recordOverThreshold();
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.alert(R2.string.zdoc_retry_max_title(), R2.string.zdoc_retry_max_msg(), R2.string.zdoc_retry_max_got_it(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.11
                {
                    BaseDocFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.OVER_THRESHOLD_ERROR, Integer.toString(1));
                    BaseDocFragment.this.responseWithCode(209, bioUploadResult);
                }
            }, null, null);
        }
    }

    public void interrupt() {
        boolean z;
        try {
            z = getResources().getBoolean(R.bool.show_exit_dialog);
        } catch (Exception unused) {
            z = true;
        }
        if (!z) {
            responseWithCode(301, null);
            return;
        }
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null || dialogHelper.isShowing()) {
            return;
        }
        this.mRecordManager.recordAlertAppear(ZdocRecordService.ACTIVE_EXIT);
        final UIState uIState = this.mCurrentState;
        updateUI(UIState.ALERT);
        this.mDialogHelper.alert(R2.string.zdoc_user_cancel_title(), R2.string.zdoc_user_cancel_msg(), R2.string.zdoc_user_cancel_stay(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.12
            {
                BaseDocFragment.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.ACTIVE_EXIT, Integer.toString(1));
                if (uIState == UIState.CAPTURE) {
                    BaseDocFragment.this.updateUI(UIState.CAPTURE);
                }
            }
        }, R2.string.zdoc_user_cancel_quit(), new DialogInterface.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.13
            {
                BaseDocFragment.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                BaseDocFragment.this.mRecordManager.recordAlertChoose(ZdocRecordService.ACTIVE_EXIT, Integer.toString(0));
                BaseDocFragment.this.responseWithCode(301, null);
            }
        });
    }

    /* renamed from: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment$15 */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState;

        static {
            int[] iArr = new int[UIState.values().length];
            $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState = iArr;
            try {
                iArr[UIState.CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.SCANNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.SCAN_TASK_OK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.USER_CONFIRM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.UPLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.UPLOAD_END_SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.UPLOAD_END_FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[UIState.ALERT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public void updateUI(UIState uIState) {
        IMessageView iMessageView;
        switch (AnonymousClass15.$SwitchMap$com$zoloz$android$phone$zdoc$ui$UIState[uIState.ordinal()]) {
            case 1:
                handleCapture();
                break;
            case 2:
                handleCapture();
                break;
            case 3:
                handleScanTaskOK();
                break;
            case 4:
                handleUserConfirm();
                break;
            case 5:
                handleUploading();
                break;
            case 6:
                DialogHelper dialogHelper = this.mDialogHelper;
                if (dialogHelper != null) {
                    dialogHelper.showSuccessDialog(false, null);
                    break;
                }
                break;
            case 7:
                DialogHelper dialogHelper2 = this.mDialogHelper;
                if (dialogHelper2 != null) {
                    dialogHelper2.dismissDialog();
                    break;
                }
                break;
            case 8:
                handleAlert(this.mCurrentState);
                break;
        }
        this.mCurrentState = uIState;
        ZdocRemoteConfig zdocRemoteConfig = this.mZdocRemoteConfig;
        if (zdocRemoteConfig == null || (iMessageView = this.mMessageView) == null) {
            return;
        }
        iMessageView.updateUI(uIState, zdocRemoteConfig.getShowPowerByZoloz(), -1);
    }

    private void handleScanTaskOK() {
        this.mShowFrame = true;
    }

    protected void handleUserConfirm() {
        this.mShowFrame = true;
    }

    public void handleUploading() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.showProgressDialog("", false, null, true);
        }
    }

    protected void handleAlert(UIState uIState) {
        if (uIState == UIState.CAPTURE) {
            this.mShowFrame = true;
            this.mRecordManager.recordBasicCheck();
        }
    }

    public void handleCapture() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.dismissDialog();
        }
        this.mPhotoImageView.setVisibility(4);
        this.mCameraSurfaceView.setVisibility(0);
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseCameraPermissionFragment
    protected void onInitView() {
        this.mDialogHelper = new DialogHelper(getActivity());
        this.mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.surface);
        this.mPhotoImageView = (ImageView) findViewById(R.id.iv_photo);
        this.mTitleBar = (TitleBar) findViewById(R.id.layout_titlebar);
        IMessageView iMessageView = (IMessageView) findViewById(R.id.layout_message);
        this.mMessageView = iMessageView;
        if (this.mZdocRemoteConfig != null) {
            iMessageView.updateUI(UIState.CAPTURE, this.mZdocRemoteConfig.getShowPowerByZoloz(), -1);
        }
        this.mTitleBar.setClickListener(new View.OnClickListener() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocFragment.14
            {
                BaseDocFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDocFragment.this.mRecordManager.recordClickButton(BaseDocFragment.this.mCurrentState.toString(), ZdocRecordService.GO_BACK);
                BaseDocFragment.this.interrupt();
            }
        });
        BaseMaskView baseMaskView = (BaseMaskView) findViewById(R.id.layout_mask_view);
        this.mDefaultMaskView = baseMaskView;
        baseMaskView.setLayerType(1, null);
        if (this.mBioAppDescription == null || this.mZdocRemoteConfig == null) {
            alertSystemError();
        }
        hotReloadUI();
    }

    private void hotReloadUI() {
        new TitleBarRender(this.mTitleBar).render();
        new MessageViewRender(this.mMessageView).render();
        new MaskViewRender(this.mDefaultMaskView).render();
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseCameraPermissionFragment
    protected void onCameraInit() {
        ICameraInterface cameraImpl = CameraSurfaceView.getCameraImpl(getActivity());
        this.mCameraInterface = cameraImpl;
        if (cameraImpl != null) {
            cameraImpl.setCallback(this);
            this.mCameraInterface.initCamera(getCurrentDeviceSetting());
        } else {
            alertSystemError();
        }
        CameraSurfaceView cameraSurfaceView = this.mCameraSurfaceView;
        if (cameraSurfaceView != null) {
            cameraSurfaceView.setCameraCallback(this);
            this.mCameraSurfaceView.setVisibility(0);
            updateUI(UIState.CAPTURE);
        }
    }

    protected DeviceSetting getCurrentDeviceSetting() {
        DeviceSetting deviceSetting = new DeviceSetting();
        deviceSetting.setCameraAuto(false);
        deviceSetting.setCameraID(findBackCameraId());
        return deviceSetting;
    }

    private int findBackCameraId() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    return i;
                }
            }
        } catch (RuntimeException unused) {
            this.mRecordManager.record("camera not found");
        }
        return 0;
    }

    public TGFrame createTGFrame(CameraData cameraData) {
        TGFrame tGFrame = new TGFrame();
        tGFrame.data = cameraData.getColorData().array();
        tGFrame.width = cameraData.getColorWidth();
        tGFrame.height = cameraData.getColorHeight();
        tGFrame.frameMode = 0;
        tGFrame.rotation = CameraSurfaceView.getCameraImpl(getContext()).getCameraViewRotation() % AUScreenAdaptTool.WIDTH_BASE;
        return tGFrame;
    }

    protected void showPreviewImg(TGFrame tGFrame) {
        try {
            this.mPhotoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Bitmap rotateBitmap = BitmapHelper.rotateBitmap(BitmapHelper.bytes2Bitmap(tGFrame.data, tGFrame.width, tGFrame.height, tGFrame.frameMode), tGFrame.rotation);
            if (rotateBitmap != null) {
                this.mPhotoImageView.setImageBitmap(BitmapHelper.resize(rotateBitmap, (int) (rotateBitmap.getWidth() * 0.8f), (int) (rotateBitmap.getHeight() * 0.8f)));
                this.mPhotoImageView.setVisibility(0);
            }
        } catch (OutOfMemoryError unused) {
            this.mRecordManager.record("zdoc_out_of_memory");
            System.gc();
        }
    }
}
