package com.otaliastudios.cameraview;

import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class CameraOptions {
    protected boolean BuiltInFictitiousFunctionClassFactory;
    protected float KClassImpl$Data$declaredNonStaticMembers$2;
    protected float MyBillsEntityDataFactory;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected float PlaceComponentResult;
    protected boolean getAuthRequestContext;
    protected float lookAheadTest;
    protected Set<WhiteBalance> isLayoutRequested = new HashSet(5);
    protected Set<Facing> getErrorConfigVersion = new HashSet(2);
    protected Set<Flash> NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashSet(4);
    protected Set<Hdr> scheduleImpl = new HashSet(2);
    protected Set<Size> NetworkUserEntityData$$ExternalSyntheticLambda1 = new HashSet(15);
    protected Set<Size> GetContactSyncConfig = new HashSet(5);
    protected Set<AspectRatio> DatabaseTableConfigUtil = new HashSet(4);
    protected Set<AspectRatio> NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashSet(3);
    protected Set<PictureFormat> initRecordTimeStamp = new HashSet(2);
    protected Set<Integer> moveToNextValue = new HashSet(2);

    public final boolean PlaceComponentResult(Control control) {
        Collection emptyList;
        Class<?> cls = control.getClass();
        if (cls.equals(Audio.class)) {
            emptyList = Arrays.asList(Audio.values());
        } else if (!cls.equals(Facing.class)) {
            if (!cls.equals(Flash.class)) {
                if (cls.equals(Grid.class)) {
                    emptyList = Arrays.asList(Grid.values());
                } else if (!cls.equals(Hdr.class)) {
                    if (cls.equals(Mode.class)) {
                        emptyList = Arrays.asList(Mode.values());
                    } else if (cls.equals(VideoCodec.class)) {
                        emptyList = Arrays.asList(VideoCodec.values());
                    } else if (!cls.equals(WhiteBalance.class)) {
                        if (cls.equals(Engine.class)) {
                            emptyList = Arrays.asList(Engine.values());
                        } else if (cls.equals(Preview.class)) {
                            emptyList = Arrays.asList(Preview.values());
                        } else if (!cls.equals(PictureFormat.class)) {
                            emptyList = Collections.emptyList();
                        } else {
                            emptyList = Collections.unmodifiableSet(this.initRecordTimeStamp);
                        }
                    } else {
                        emptyList = Collections.unmodifiableSet(this.isLayoutRequested);
                    }
                } else {
                    emptyList = Collections.unmodifiableSet(this.scheduleImpl);
                }
            } else {
                emptyList = Collections.unmodifiableSet(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        } else {
            emptyList = Collections.unmodifiableSet(this.getErrorConfigVersion);
        }
        return emptyList.contains(control);
    }

    /* renamed from: com.otaliastudios.cameraview.CameraOptions$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[GestureAction.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[GestureAction.AUTO_FOCUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.TAKE_PICTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.FILTER_CONTROL_1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.FILTER_CONTROL_2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.ZOOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[GestureAction.EXPOSURE_CORRECTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public final Collection<Size> BuiltInFictitiousFunctionClassFactory() {
        return Collections.unmodifiableSet(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    public final Collection<Size> moveToNextValue() {
        return Collections.unmodifiableSet(this.GetContactSyncConfig);
    }

    public final boolean scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public final boolean lookAheadTest() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.getAuthRequestContext;
    }

    public final float getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    public final float PlaceComponentResult() {
        return this.lookAheadTest;
    }

    public final float MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
