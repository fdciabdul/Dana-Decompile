package com.otaliastudios.cameraview.engine.meter;

import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.metering.Camera2MeteringTransform;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class MeterAction extends ActionWrapper {
    private static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("MeterAction");
    private final MeteringRegions BuiltInFictitiousFunctionClassFactory;
    private final CameraEngine KClassImpl$Data$declaredNonStaticMembers$2;
    private BaseAction MyBillsEntityDataFactory;
    private List<BaseMeter> getAuthRequestContext;
    private final boolean moveToNextValue;

    public MeterAction(CameraEngine cameraEngine, MeteringRegions meteringRegions, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = meteringRegions;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cameraEngine;
        this.moveToNextValue = z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    public final BaseAction BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final boolean MyBillsEntityDataFactory() {
        Iterator<BaseMeter> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            if (!it.next().BuiltInFictitiousFunctionClassFactory()) {
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "isSuccessful:", "returning false.");
                return false;
            }
        }
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "isSuccessful:", "returning true.");
        return true;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        CameraLogger cameraLogger = PlaceComponentResult;
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStart:", "initializing.");
        List arrayList = new ArrayList();
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            Angles PrepareContext = this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext();
            CameraPreview onBoardingScenario = this.KClassImpl$Data$declaredNonStaticMembers$2.getOnBoardingScenario();
            Camera2MeteringTransform camera2MeteringTransform = new Camera2MeteringTransform(PrepareContext, new Size(onBoardingScenario.getErrorConfigVersion, onBoardingScenario.scheduleImpl), this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(Reference.VIEW), this.KClassImpl$Data$declaredNonStaticMembers$2.getOnBoardingScenario().BuiltInFictitiousFunctionClassFactory(), actionHolder.DatabaseTableConfigUtil(), actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2());
            arrayList = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(camera2MeteringTransform).PlaceComponentResult(Integer.MAX_VALUE, camera2MeteringTransform);
        }
        ExposureMeter exposureMeter = new ExposureMeter(arrayList, this.moveToNextValue);
        FocusMeter focusMeter = new FocusMeter(arrayList, this.moveToNextValue);
        WhiteBalanceMeter whiteBalanceMeter = new WhiteBalanceMeter(arrayList, this.moveToNextValue);
        this.getAuthRequestContext = Arrays.asList(exposureMeter, focusMeter, whiteBalanceMeter);
        this.MyBillsEntityDataFactory = Actions.KClassImpl$Data$declaredNonStaticMembers$2(exposureMeter, focusMeter, whiteBalanceMeter);
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStart:", "initialized.");
        super.MyBillsEntityDataFactory(actionHolder);
    }
}
