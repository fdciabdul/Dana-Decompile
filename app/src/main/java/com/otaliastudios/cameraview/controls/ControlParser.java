package com.otaliastudios.cameraview.controls;

import android.content.Context;
import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R;

/* loaded from: classes2.dex */
public class ControlParser {
    public int BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int NetworkUserEntityData$$ExternalSyntheticLambda1;
    public int PlaceComponentResult;
    public int getAuthRequestContext;
    public int getErrorConfigVersion;
    public int lookAheadTest;
    public int moveToNextValue;
    public int scheduleImpl;

    public ControlParser(Context context, TypedArray typedArray) {
        this.scheduleImpl = typedArray.getInteger(R.styleable.H, Preview.DEFAULT.value());
        this.getAuthRequestContext = typedArray.getInteger(R.styleable.initRecordTimeStamp, Facing.DEFAULT(context).value());
        this.BuiltInFictitiousFunctionClassFactory = typedArray.getInteger(R.styleable.GetContactSyncConfig, Flash.DEFAULT.value());
        this.PlaceComponentResult = typedArray.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6, Grid.DEFAULT.value());
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getInteger(R.styleable.U, WhiteBalance.DEFAULT.value());
        this.lookAheadTest = typedArray.getInteger(R.styleable.SubSequence, Mode.DEFAULT.value());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getInteger(R.styleable.getSupportButtonTintMode, Hdr.DEFAULT.value());
        this.MyBillsEntityDataFactory = typedArray.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, Audio.DEFAULT.value());
        this.getErrorConfigVersion = typedArray.getInteger(R.styleable.getNameOrBuilderList, VideoCodec.DEFAULT.value());
        this.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getInteger(R.styleable.moveToNextValue, Engine.DEFAULT.value());
        this.moveToNextValue = typedArray.getInteger(R.styleable.getCallingPid, PictureFormat.DEFAULT.value());
    }
}
