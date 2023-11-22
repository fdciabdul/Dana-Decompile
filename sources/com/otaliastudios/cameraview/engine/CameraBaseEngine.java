package com.otaliastudios.cameraview.engine;

import android.location.Location;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectors;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes8.dex */
public abstract class CameraBaseEngine extends CameraEngine {
    private FrameManager AppCompatEmojiTextHelper;
    protected float B;
    Task<Void> BottomSheetCardBindingView$watcherCardNumberView$1;
    private Audio BuiltInFictitiousFunctionClassFactory;
    Task<Void> C;
    protected Hdr DatabaseTableConfigUtil;
    private Mode F;
    protected boolean FragmentBottomSheetPaymentSettingBinding;
    private int G;
    protected Size GetContactSyncConfig;
    private int H;
    private int I;
    private Overlay J;
    private SizeSelector K;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    private int L;
    private SizeSelector M;
    private int MyBillsEntityDataFactory;
    private long N;
    Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    protected CameraPreview NetworkUserEntityData$$ExternalSyntheticLambda4;
    Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda5;
    protected PictureRecorder NetworkUserEntityData$$ExternalSyntheticLambda6;
    Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda7;
    Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int O;
    private int P;
    private Facing PlaceComponentResult;
    protected boolean PrepareContext;
    private SizeSelector Q;
    Task<Void> SubSequence;
    protected WhiteBalance VerifyPinStateManager$executeRiskChallenge$2$1;
    final Angles getAuthRequestContext;
    protected VideoRecorder getCallingPid;
    protected float getErrorConfigVersion;
    private int getNameOrBuilderList;
    protected VideoCodec getSupportButtonTintMode;
    protected int initRecordTimeStamp;
    protected PictureFormat isLayoutRequested;
    protected Size lookAheadTest;
    protected Flash moveToNextValue;
    protected Location newProxyInstance;
    protected Size readMicros;
    protected CameraOptions scheduleImpl;
    protected float whenAvailable;

    protected abstract void BuiltInFictitiousFunctionClassFactory();

    protected abstract FrameManager KClassImpl$Data$declaredNonStaticMembers$2(int i);

    protected abstract List<Size> MyBillsEntityDataFactory();

    protected abstract void MyBillsEntityDataFactory(PictureResult.Stub stub, AspectRatio aspectRatio, boolean z);

    protected abstract void PlaceComponentResult(VideoResult.Stub stub);

    protected abstract List<Size> getAuthRequestContext();

    protected abstract void getAuthRequestContext(PictureResult.Stub stub, boolean z);

    protected abstract void getAuthRequestContext(VideoResult.Stub stub, AspectRatio aspectRatio);

    public CameraBaseEngine(CameraEngine.Callback callback) {
        super(callback);
        this.getAuthRequestContext = new Angles();
        this.C = Tasks.forResult(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Tasks.forResult(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Tasks.forResult(null);
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = Tasks.forResult(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = Tasks.forResult(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = Tasks.forResult(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Tasks.forResult(null);
        this.SubSequence = Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Angles PrepareContext() {
        return this.getAuthRequestContext;
    }

    public FrameManager KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.AppCompatEmojiTextHelper == null) {
            this.AppCompatEmojiTextHelper = KClassImpl$Data$declaredNonStaticMembers$2(this.H);
        }
        return this.AppCompatEmojiTextHelper;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final CameraOptions NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.scheduleImpl;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(CameraPreview cameraPreview) {
        CameraPreview cameraPreview2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (cameraPreview2 != null) {
            cameraPreview2.getAuthRequestContext(null);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = cameraPreview;
        cameraPreview.getAuthRequestContext(this);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final CameraPreview getOnBoardingScenario() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(Overlay overlay) {
        this.J = overlay;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Overlay B() {
        return this.J;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SizeSelector sizeSelector) {
        this.K = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(SizeSelector sizeSelector) {
        this.M = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final SizeSelector VerifyPinStateManager$executeRiskChallenge$2$2() {
        return this.M;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(SizeSelector sizeSelector) {
        this.Q = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final SizeSelector getNameOrBuilderList() {
        return this.Q;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(long j) {
        this.N = j;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long K() {
        return this.N;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void initRecordTimeStamp(int i) {
        this.O = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int J() {
        return this.O;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(VideoCodec videoCodec) {
        this.getSupportButtonTintMode = videoCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final VideoCodec AppCompatEmojiTextHelper() {
        return this.getSupportButtonTintMode;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void lookAheadTest(int i) {
        this.P = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int G() {
        return this.P;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int FragmentBottomSheetPaymentSettingBinding() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getErrorConfigVersion(int i) {
        this.getNameOrBuilderList = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int I() {
        return this.getNameOrBuilderList;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        this.L = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int H() {
        return this.L;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void moveToNextValue(int i) {
        this.G = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getCallingPid() {
        return this.G;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(int i) {
        this.I = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int SubSequence() {
        return this.I;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getSupportButtonTintMode() {
        return this.initRecordTimeStamp;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void scheduleImpl(int i) {
        this.H = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int C() {
        return this.H;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(long j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean SummaryVoucherView$$ExternalSyntheticLambda1() {
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return j > 0 && j != LongCompanionObject.MAX_VALUE;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void MyBillsEntityDataFactory(final Facing facing) {
        final Facing facing2 = this.PlaceComponentResult;
        if (facing != facing2) {
            this.PlaceComponentResult = facing;
            CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator.PlaceComponentResult("facing", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.1
                {
                    CameraBaseEngine.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (CameraBaseEngine.this.PlaceComponentResult(facing)) {
                        CameraBaseEngine.this.V();
                        return;
                    }
                    CameraBaseEngine.this.PlaceComponentResult = facing2;
                }
            })));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Facing readMicros() {
        return this.PlaceComponentResult;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(Audio audio) {
        if (this.BuiltInFictitiousFunctionClassFactory != audio) {
            if (SummaryVoucherView$$ExternalSyntheticLambda0()) {
                A.KClassImpl$Data$declaredNonStaticMembers$2(2, "Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.BuiltInFictitiousFunctionClassFactory = audio;
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Audio NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(Mode mode) {
        if (mode != this.F) {
            this.F = mode;
            CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
            cameraStateOrchestrator.PlaceComponentResult("mode", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.ENGINE, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.2
                {
                    CameraBaseEngine.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CameraBaseEngine.this.V();
                }
            })));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Mode VerifyPinStateManager$executeRiskChallenge$2$1() {
        return this.F;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float L() {
        return this.B;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.getErrorConfigVersion;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Flash whenAvailable() {
        return this.moveToNextValue;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final WhiteBalance M() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Hdr BottomSheetCardBindingView$watcherCardNumberView$1() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Location A() {
        return this.newProxyInstance;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final PictureFormat E() {
        return this.isLayoutRequested;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float F() {
        return this.whenAvailable;
    }

    public final boolean O() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.PrepareContext = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean D() {
        return this.PrepareContext;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void getAuthRequestContext(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getValueOfTouchPositionAbsolute() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean P() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6 != null;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(final PictureResult.Stub stub) {
        final boolean z = this.PrepareContext;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("take picture", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.3
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.P()));
                if (CameraBaseEngine.this.P()) {
                    return;
                }
                if (CameraBaseEngine.this.F == Mode.VIDEO) {
                    throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
                }
                stub.PlaceComponentResult = false;
                stub.MyBillsEntityDataFactory = CameraBaseEngine.this.newProxyInstance;
                stub.getAuthRequestContext = CameraBaseEngine.this.PlaceComponentResult;
                stub.KClassImpl$Data$declaredNonStaticMembers$2 = CameraBaseEngine.this.isLayoutRequested;
                CameraBaseEngine.this.getAuthRequestContext(stub, z);
            }
        })));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final PictureResult.Stub stub) {
        final boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("take picture snapshot", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.4
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.P()));
                if (CameraBaseEngine.this.P()) {
                    return;
                }
                stub.MyBillsEntityDataFactory = CameraBaseEngine.this.newProxyInstance;
                stub.PlaceComponentResult = true;
                stub.getAuthRequestContext = CameraBaseEngine.this.PlaceComponentResult;
                stub.KClassImpl$Data$declaredNonStaticMembers$2 = PictureFormat.JPEG;
                CameraBaseEngine.this.MyBillsEntityDataFactory(stub, AspectRatio.MyBillsEntityDataFactory(CameraBaseEngine.this.MyBillsEntityDataFactory(Reference.OUTPUT)), z);
            }
        })));
    }

    public void getAuthRequestContext(PictureResult.Stub stub, Exception exc) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        if (stub != null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2.getAuthRequestContext(stub);
            return;
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onPictureResult", "result is null: something went wrong.", exc);
        this.VerifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory(new CameraException(exc, 4));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean SummaryVoucherView$$ExternalSyntheticLambda0() {
        VideoRecorder videoRecorder = this.getCallingPid;
        return videoRecorder != null && videoRecorder.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    protected final void Q() {
        VideoRecorder videoRecorder = this.getCallingPid;
        if (videoRecorder != null) {
            videoRecorder.MyBillsEntityDataFactory(false);
        }
    }

    public void PlaceComponentResult(VideoResult.Stub stub, Exception exc) {
        this.getCallingPid = null;
        if (stub != null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2(stub);
            return;
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onVideoResult", "result is null: something went wrong.", exc);
        this.VerifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory(new CameraException(exc, 5));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void N() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onSurfaceChanged:", "Size is", MyBillsEntityDataFactory(Reference.VIEW));
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("surface changed", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.8
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Size newProxyInstance = CameraBaseEngine.this.newProxyInstance();
                if (newProxyInstance.equals(CameraBaseEngine.this.readMicros)) {
                    CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
                    return;
                }
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
                CameraBaseEngine.this.readMicros = newProxyInstance;
                CameraBaseEngine.this.BuiltInFictitiousFunctionClassFactory();
            }
        })));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Size KClassImpl$Data$declaredNonStaticMembers$2(Reference reference) {
        Size size = this.lookAheadTest;
        if (size == null || this.F == Mode.VIDEO) {
            return null;
        }
        return this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, reference) ? new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory) : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Size PlaceComponentResult(Reference reference) {
        Size size = this.lookAheadTest;
        if (size == null || this.F == Mode.PICTURE) {
            return null;
        }
        return this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, reference) ? new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory) : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Size BuiltInFictitiousFunctionClassFactory(Reference reference) {
        Size size = this.readMicros;
        if (size == null) {
            return null;
        }
        return this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, reference) ? new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory) : size;
    }

    public Size MyBillsEntityDataFactory(Reference reference) {
        CameraPreview cameraPreview = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (cameraPreview == null) {
            return null;
        }
        if (this.getAuthRequestContext.PlaceComponentResult(Reference.VIEW, reference)) {
            Size size = new Size(cameraPreview.getErrorConfigVersion, cameraPreview.scheduleImpl);
            return new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
        }
        return new Size(cameraPreview.getErrorConfigVersion, cameraPreview.scheduleImpl);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final Size getAuthRequestContext(Reference reference) {
        Size BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(reference);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        boolean PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(reference, Reference.VIEW);
        int i = PlaceComponentResult ? this.L : this.getNameOrBuilderList;
        int i2 = PlaceComponentResult ? this.getNameOrBuilderList : this.L;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        AspectRatio MyBillsEntityDataFactory = AspectRatio.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
        float f = MyBillsEntityDataFactory.getAuthRequestContext / MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        AspectRatio BuiltInFictitiousFunctionClassFactory2 = AspectRatio.BuiltInFictitiousFunctionClassFactory(i, i2);
        if (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext / BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory >= f) {
            return new Size((int) Math.floor(r6 * f), Math.min(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, i2));
        }
        return new Size(Math.min(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, i), (int) Math.floor(r6 / f));
    }

    public final Size NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return KClassImpl$Data$declaredNonStaticMembers$2(this.F);
    }

    public final Size newProxyInstance() {
        List<Size> MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        boolean PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, Reference.VIEW);
        List<Size> arrayList = new ArrayList<>(MyBillsEntityDataFactory.size());
        for (Size size : MyBillsEntityDataFactory) {
            if (PlaceComponentResult) {
                size = new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
            }
            arrayList.add(size);
        }
        Size MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(Reference.VIEW);
        if (MyBillsEntityDataFactory2 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest.getAuthRequestContext);
        if (PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "computePreviewStreamSize:", "targetRatio:", BuiltInFictitiousFunctionClassFactory, "targetMinSize:", MyBillsEntityDataFactory2);
        SizeSelector MyBillsEntityDataFactory3 = SizeSelectors.MyBillsEntityDataFactory(SizeSelectors.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory), SizeSelectors.PlaceComponentResult());
        SizeSelector MyBillsEntityDataFactory4 = SizeSelectors.MyBillsEntityDataFactory(SizeSelectors.getAuthRequestContext(MyBillsEntityDataFactory2.getAuthRequestContext), SizeSelectors.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory), SizeSelectors.MyBillsEntityDataFactory());
        SizeSelector PlaceComponentResult2 = SizeSelectors.PlaceComponentResult(SizeSelectors.MyBillsEntityDataFactory(MyBillsEntityDataFactory3, MyBillsEntityDataFactory4), MyBillsEntityDataFactory4, MyBillsEntityDataFactory3, SizeSelectors.PlaceComponentResult());
        SizeSelector sizeSelector = this.K;
        if (sizeSelector != null) {
            PlaceComponentResult2 = SizeSelectors.PlaceComponentResult(sizeSelector, PlaceComponentResult2);
        }
        Size size2 = PlaceComponentResult2.PlaceComponentResult(arrayList).get(0);
        if (!arrayList.contains(size2)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (PlaceComponentResult) {
            size2 = new Size(size2.getAuthRequestContext, size2.BuiltInFictitiousFunctionClassFactory);
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "computePreviewStreamSize:", "result:", size2, "flip:", Boolean.valueOf(PlaceComponentResult));
        return size2;
    }

    public final Size NetworkUserEntityData$$ExternalSyntheticLambda8() {
        List<Size> authRequestContext = getAuthRequestContext();
        boolean PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, Reference.VIEW);
        List<Size> arrayList = new ArrayList<>(authRequestContext.size());
        for (Size size : authRequestContext) {
            if (PlaceComponentResult) {
                size = new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
            }
            arrayList.add(size);
        }
        AspectRatio BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(this.readMicros.BuiltInFictitiousFunctionClassFactory, this.readMicros.getAuthRequestContext);
        if (PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory = AspectRatio.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
        }
        int i = this.G;
        int i2 = this.I;
        if (i <= 0 || i == Integer.MAX_VALUE) {
            i = 640;
        }
        if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
            i2 = 640;
        }
        Size size2 = new Size(i, i2);
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "computeFrameProcessingSize:", "targetRatio:", BuiltInFictitiousFunctionClassFactory, "targetMaxSize:", size2);
        SizeSelector authRequestContext2 = SizeSelectors.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
        SizeSelector MyBillsEntityDataFactory = SizeSelectors.MyBillsEntityDataFactory(SizeSelectors.BuiltInFictitiousFunctionClassFactory(size2.getAuthRequestContext), SizeSelectors.PlaceComponentResult(size2.BuiltInFictitiousFunctionClassFactory), SizeSelectors.PlaceComponentResult());
        Size size3 = SizeSelectors.PlaceComponentResult(SizeSelectors.MyBillsEntityDataFactory(authRequestContext2, MyBillsEntityDataFactory), MyBillsEntityDataFactory, SizeSelectors.MyBillsEntityDataFactory()).PlaceComponentResult(arrayList).get(0);
        if (!arrayList.contains(size3)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (PlaceComponentResult) {
            size3 = new Size(size3.getAuthRequestContext, size3.BuiltInFictitiousFunctionClassFactory);
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "computeFrameProcessingSize:", "result:", size3, "flip:", Boolean.valueOf(PlaceComponentResult));
        return size3;
    }

    public final Size KClassImpl$Data$declaredNonStaticMembers$2(Mode mode) {
        SizeSelector sizeSelector;
        Collection<Size> moveToNextValue;
        boolean PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(Reference.SENSOR, Reference.VIEW);
        if (mode == Mode.PICTURE) {
            sizeSelector = this.M;
            moveToNextValue = this.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
        } else {
            sizeSelector = this.Q;
            moveToNextValue = this.scheduleImpl.moveToNextValue();
        }
        SizeSelector PlaceComponentResult2 = SizeSelectors.PlaceComponentResult(sizeSelector, SizeSelectors.PlaceComponentResult());
        List<Size> arrayList = new ArrayList<>(moveToNextValue);
        Size size = PlaceComponentResult2.PlaceComponentResult(arrayList).get(0);
        if (!arrayList.contains(size)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "computeCaptureSize:", "result:", size, "flip:", Boolean.valueOf(PlaceComponentResult), "mode:", mode);
        return PlaceComponentResult ? new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory) : size;
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public final void PlaceComponentResult(boolean z) {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.getAuthRequestContext(!z);
    }

    public void isLayoutRequested() {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public final void SummaryVoucherView$$ExternalSyntheticLambda2() {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void isAuth() {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("stop video", true, new CameraOrchestrator.AnonymousClass1(new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.7
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "stopVideo", "running. isTakingVideo?", Boolean.valueOf(CameraBaseEngine.this.SummaryVoucherView$$ExternalSyntheticLambda0()));
                CameraBaseEngine.this.Q();
            }
        }));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void PlaceComponentResult(final VideoResult.Stub stub, final File file, final FileDescriptor fileDescriptor) {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("take video", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.5
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "takeVideo:", "running. isTakingVideo:", Boolean.valueOf(CameraBaseEngine.this.SummaryVoucherView$$ExternalSyntheticLambda0()));
                if (CameraBaseEngine.this.SummaryVoucherView$$ExternalSyntheticLambda0()) {
                    return;
                }
                if (CameraBaseEngine.this.F == Mode.PICTURE) {
                    throw new IllegalStateException("Can't record video while in PICTURE mode");
                }
                File file2 = file;
                if (file2 != null) {
                    stub.MyBillsEntityDataFactory = file2;
                } else {
                    FileDescriptor fileDescriptor2 = fileDescriptor;
                    if (fileDescriptor2 != null) {
                        stub.NetworkUserEntityData$$ExternalSyntheticLambda0 = fileDescriptor2;
                    } else {
                        throw new IllegalStateException("file and fileDescriptor are both null.");
                    }
                }
                stub.scheduleImpl = false;
                stub.NetworkUserEntityData$$ExternalSyntheticLambda2 = CameraBaseEngine.this.getSupportButtonTintMode;
                stub.getErrorConfigVersion = CameraBaseEngine.this.newProxyInstance;
                stub.PlaceComponentResult = CameraBaseEngine.this.PlaceComponentResult;
                stub.BuiltInFictitiousFunctionClassFactory = CameraBaseEngine.this.BuiltInFictitiousFunctionClassFactory;
                stub.moveToNextValue = CameraBaseEngine.this.N;
                stub.lookAheadTest = CameraBaseEngine.this.O;
                stub.GetContactSyncConfig = CameraBaseEngine.this.P;
                stub.KClassImpl$Data$declaredNonStaticMembers$2 = CameraBaseEngine.this.MyBillsEntityDataFactory;
                CameraBaseEngine.this.PlaceComponentResult(stub);
            }
        })));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void BuiltInFictitiousFunctionClassFactory(final VideoResult.Stub stub, final File file) {
        CameraStateOrchestrator cameraStateOrchestrator = this.getValueOfTouchPositionAbsolute;
        cameraStateOrchestrator.PlaceComponentResult("take video snapshot", true, new CameraOrchestrator.AnonymousClass1(new CameraStateOrchestrator.AnonymousClass3(CameraState.BIND, new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraBaseEngine.6
            {
                CameraBaseEngine.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(1, "takeVideoSnapshot:", "running. isTakingVideo:", Boolean.valueOf(CameraBaseEngine.this.SummaryVoucherView$$ExternalSyntheticLambda0()));
                stub.MyBillsEntityDataFactory = file;
                stub.scheduleImpl = true;
                stub.NetworkUserEntityData$$ExternalSyntheticLambda2 = CameraBaseEngine.this.getSupportButtonTintMode;
                stub.getErrorConfigVersion = CameraBaseEngine.this.newProxyInstance;
                stub.PlaceComponentResult = CameraBaseEngine.this.PlaceComponentResult;
                stub.GetContactSyncConfig = CameraBaseEngine.this.P;
                stub.KClassImpl$Data$declaredNonStaticMembers$2 = CameraBaseEngine.this.MyBillsEntityDataFactory;
                stub.BuiltInFictitiousFunctionClassFactory = CameraBaseEngine.this.BuiltInFictitiousFunctionClassFactory;
                stub.moveToNextValue = CameraBaseEngine.this.N;
                stub.lookAheadTest = CameraBaseEngine.this.O;
                CameraBaseEngine.this.getAuthRequestContext(stub, AspectRatio.MyBillsEntityDataFactory(CameraBaseEngine.this.MyBillsEntityDataFactory(Reference.OUTPUT)));
            }
        })));
    }
}
