package com.rd.draw.controller;

import com.fullstory.instrumentation.FSDraw;
import com.rd.animation.data.Value;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.Drawer;

/* loaded from: classes3.dex */
public class DrawController implements FSDraw {
    public ClickListener BuiltInFictitiousFunctionClassFactory;
    public Value MyBillsEntityDataFactory;
    public Indicator PlaceComponentResult;
    public Drawer getAuthRequestContext;

    /* loaded from: classes3.dex */
    public interface ClickListener {
    }

    public DrawController(Indicator indicator) {
        this.PlaceComponentResult = indicator;
        this.getAuthRequestContext = new Drawer(indicator);
    }

    /* renamed from: com.rd.draw.controller.DrawController$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[AnimationType.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[AnimationType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.WORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.FILL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.THIN_WORM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.DROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[AnimationType.SCALE_DOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
