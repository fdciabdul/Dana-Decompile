package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Direct {
    private static BasicMeasure.Measure getAuthRequestContext = new BasicMeasure.Measure();
    private static int PlaceComponentResult = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    private static void MyBillsEntityDataFactory(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        if (constraintWidget.isLayoutRequested()) {
            return;
        }
        PlaceComponentResult++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda3() && getAuthRequestContext(constraintWidget)) {
            ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory = constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory2 = constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
        int i2 = !BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        int i3 = !BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult;
        if (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory != null && BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
            Iterator<ConstraintAnchor> it = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.lookAheadTest;
                int i4 = i + 1;
                boolean authRequestContext = getAuthRequestContext(constraintWidget2);
                if (constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda3() && authRequestContext) {
                    ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                boolean z2 = (next == constraintWidget2.I && constraintWidget2.c.moveToNextValue != null && constraintWidget2.c.moveToNextValue.getAuthRequestContext()) || (next == constraintWidget2.c && constraintWidget2.I.moveToNextValue != null && constraintWidget2.I.moveToNextValue.getAuthRequestContext());
                if (constraintWidget2.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || authRequestContext) {
                    if (!constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                        if (next == constraintWidget2.I && constraintWidget2.c.moveToNextValue == null) {
                            int MyBillsEntityDataFactory = constraintWidget2.I.MyBillsEntityDataFactory() + i2;
                            constraintWidget2.PlaceComponentResult(MyBillsEntityDataFactory, (constraintWidget2.h == 8 ? 0 : constraintWidget2.FlowViewUtil$textChanges$2) + MyBillsEntityDataFactory);
                            MyBillsEntityDataFactory(i4, constraintWidget2, measurer, z);
                        } else if (next == constraintWidget2.c && constraintWidget2.I.moveToNextValue == null) {
                            int MyBillsEntityDataFactory2 = i2 - constraintWidget2.c.MyBillsEntityDataFactory();
                            constraintWidget2.PlaceComponentResult(MyBillsEntityDataFactory2 - (constraintWidget2.h == 8 ? 0 : constraintWidget2.FlowViewUtil$textChanges$2), MyBillsEntityDataFactory2);
                            MyBillsEntityDataFactory(i4, constraintWidget2, measurer, z);
                        } else if (z2 && !constraintWidget2.newProxyInstance()) {
                            BuiltInFictitiousFunctionClassFactory(i4, measurer, constraintWidget2, z);
                        }
                    }
                } else if (constraintWidget2.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.O >= 0 && constraintWidget2.P >= 0 && ((constraintWidget2.h == 8 || (constraintWidget2.N == 0 && constraintWidget2.SubSequence == 0.0f)) && !constraintWidget2.newProxyInstance() && !constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda6() && z2 && !constraintWidget2.newProxyInstance())) {
                    KClassImpl$Data$declaredNonStaticMembers$2(i4, constraintWidget, measurer, constraintWidget2, z);
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory != null && BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext()) {
            Iterator<ConstraintAnchor> it2 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.lookAheadTest;
                int i5 = i + 1;
                boolean authRequestContext2 = getAuthRequestContext(constraintWidget3);
                if (constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda3() && authRequestContext2) {
                    ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                boolean z3 = (next2 == constraintWidget3.I && constraintWidget3.c.moveToNextValue != null && constraintWidget3.c.moveToNextValue.getAuthRequestContext()) || (next2 == constraintWidget3.c && constraintWidget3.I.moveToNextValue != null && constraintWidget3.I.moveToNextValue.getAuthRequestContext());
                if (constraintWidget3.getNameOrBuilderList[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || authRequestContext2) {
                    if (!constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                        if (next2 == constraintWidget3.I && constraintWidget3.c.moveToNextValue == null) {
                            int MyBillsEntityDataFactory3 = constraintWidget3.I.MyBillsEntityDataFactory() + i3;
                            constraintWidget3.PlaceComponentResult(MyBillsEntityDataFactory3, (constraintWidget3.h == 8 ? 0 : constraintWidget3.FlowViewUtil$textChanges$2) + MyBillsEntityDataFactory3);
                            MyBillsEntityDataFactory(i5, constraintWidget3, measurer, z);
                        } else if (next2 == constraintWidget3.c && constraintWidget3.I.moveToNextValue == null) {
                            int MyBillsEntityDataFactory4 = i3 - constraintWidget3.c.MyBillsEntityDataFactory();
                            constraintWidget3.PlaceComponentResult(MyBillsEntityDataFactory4 - (constraintWidget3.h == 8 ? 0 : constraintWidget3.FlowViewUtil$textChanges$2), MyBillsEntityDataFactory4);
                            MyBillsEntityDataFactory(i5, constraintWidget3, measurer, z);
                        } else if (z3 && !constraintWidget3.newProxyInstance()) {
                            BuiltInFictitiousFunctionClassFactory(i5, measurer, constraintWidget3, z);
                        }
                    }
                } else if (constraintWidget3.getNameOrBuilderList[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget3.O >= 0) {
                        if (constraintWidget3.P >= 0) {
                            if (constraintWidget3.h != 8) {
                                if (constraintWidget3.N == 0 && constraintWidget3.SubSequence == 0.0f) {
                                }
                            }
                            if (!constraintWidget3.newProxyInstance() && !constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda6() && z3 && !constraintWidget3.newProxyInstance()) {
                                KClassImpl$Data$declaredNonStaticMembers$2(i5, constraintWidget, measurer, constraintWidget3, z);
                            }
                        }
                    }
                }
            }
        }
        constraintWidget.GetContactSyncConfig = true;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        if (constraintWidget.FragmentBottomSheetPaymentSettingBinding()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda3() && getAuthRequestContext(constraintWidget)) {
            ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory = constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory2 = constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
        int i2 = !BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        int i3 = !BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult;
        if (BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory != null && BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
            Iterator<ConstraintAnchor> it = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.lookAheadTest;
                int i4 = i + 1;
                boolean authRequestContext = getAuthRequestContext(constraintWidget2);
                if (constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda3() && authRequestContext) {
                    ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                boolean z = (next == constraintWidget2.f5939a && constraintWidget2.isLayoutRequested.moveToNextValue != null && constraintWidget2.isLayoutRequested.moveToNextValue.getAuthRequestContext()) || (next == constraintWidget2.isLayoutRequested && constraintWidget2.f5939a.moveToNextValue != null && constraintWidget2.f5939a.moveToNextValue.getAuthRequestContext());
                if (constraintWidget2.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || authRequestContext) {
                    if (!constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                        if (next == constraintWidget2.f5939a && constraintWidget2.isLayoutRequested.moveToNextValue == null) {
                            int MyBillsEntityDataFactory = constraintWidget2.f5939a.MyBillsEntityDataFactory() + i2;
                            constraintWidget2.getAuthRequestContext(MyBillsEntityDataFactory, (constraintWidget2.h == 8 ? 0 : constraintWidget2.C) + MyBillsEntityDataFactory);
                            KClassImpl$Data$declaredNonStaticMembers$2(i4, constraintWidget2, measurer);
                        } else if (next == constraintWidget2.isLayoutRequested && constraintWidget2.f5939a.moveToNextValue == null) {
                            int MyBillsEntityDataFactory2 = i2 - constraintWidget2.isLayoutRequested.MyBillsEntityDataFactory();
                            constraintWidget2.getAuthRequestContext(MyBillsEntityDataFactory2 - (constraintWidget2.h == 8 ? 0 : constraintWidget2.C), MyBillsEntityDataFactory2);
                            KClassImpl$Data$declaredNonStaticMembers$2(i4, constraintWidget2, measurer);
                        } else if (z && !constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                            getAuthRequestContext(i4, measurer, constraintWidget2);
                        }
                    }
                } else if (constraintWidget2.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.Q >= 0 && constraintWidget2.SummaryVoucherView$$ExternalSyntheticLambda0 >= 0 && (constraintWidget2.h == 8 || (constraintWidget2.K == 0 && constraintWidget2.SubSequence == 0.0f))) {
                    if (!constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda5() && !constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda6() && z && !constraintWidget2.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                        PlaceComponentResult(i4, constraintWidget, measurer, constraintWidget2);
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory != null && BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext()) {
            Iterator<ConstraintAnchor> it2 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.lookAheadTest;
                int i5 = i + 1;
                boolean authRequestContext2 = getAuthRequestContext(constraintWidget3);
                if (constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda3() && authRequestContext2) {
                    ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                boolean z2 = (next2 == constraintWidget3.f5939a && constraintWidget3.isLayoutRequested.moveToNextValue != null && constraintWidget3.isLayoutRequested.moveToNextValue.getAuthRequestContext()) || (next2 == constraintWidget3.isLayoutRequested && constraintWidget3.f5939a.moveToNextValue != null && constraintWidget3.f5939a.moveToNextValue.getAuthRequestContext());
                if (constraintWidget3.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || authRequestContext2) {
                    if (!constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
                        if (next2 == constraintWidget3.f5939a && constraintWidget3.isLayoutRequested.moveToNextValue == null) {
                            int MyBillsEntityDataFactory3 = constraintWidget3.f5939a.MyBillsEntityDataFactory() + i3;
                            constraintWidget3.getAuthRequestContext(MyBillsEntityDataFactory3, (constraintWidget3.h == 8 ? 0 : constraintWidget3.C) + MyBillsEntityDataFactory3);
                            KClassImpl$Data$declaredNonStaticMembers$2(i5, constraintWidget3, measurer);
                        } else if (next2 == constraintWidget3.isLayoutRequested && constraintWidget3.f5939a.moveToNextValue == null) {
                            int MyBillsEntityDataFactory4 = i3 - constraintWidget3.isLayoutRequested.MyBillsEntityDataFactory();
                            constraintWidget3.getAuthRequestContext(MyBillsEntityDataFactory4 - (constraintWidget3.h == 8 ? 0 : constraintWidget3.C), MyBillsEntityDataFactory4);
                            KClassImpl$Data$declaredNonStaticMembers$2(i5, constraintWidget3, measurer);
                        } else if (z2 && !constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                            getAuthRequestContext(i5, measurer, constraintWidget3);
                        }
                    }
                } else if (constraintWidget3.getNameOrBuilderList[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget3.Q >= 0 && constraintWidget3.SummaryVoucherView$$ExternalSyntheticLambda0 >= 0 && (constraintWidget3.h == 8 || (constraintWidget3.K == 0 && constraintWidget3.SubSequence == 0.0f))) {
                    if (!constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda5() && !constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda6() && z2 && !constraintWidget3.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                        PlaceComponentResult(i5, constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor BuiltInFictitiousFunctionClassFactory3 = constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BASELINE);
        if (BuiltInFictitiousFunctionClassFactory3.MyBillsEntityDataFactory != null && BuiltInFictitiousFunctionClassFactory3.getAuthRequestContext()) {
            int i6 = !BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : BuiltInFictitiousFunctionClassFactory3.PlaceComponentResult;
            Iterator<ConstraintAnchor> it3 = BuiltInFictitiousFunctionClassFactory3.MyBillsEntityDataFactory.iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.lookAheadTest;
                int i7 = i + 1;
                boolean authRequestContext3 = getAuthRequestContext(constraintWidget4);
                if (constraintWidget4.NetworkUserEntityData$$ExternalSyntheticLambda3() && authRequestContext3) {
                    ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (constraintWidget4.getNameOrBuilderList[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || authRequestContext3) {
                    if (!constraintWidget4.NetworkUserEntityData$$ExternalSyntheticLambda3() && next3 == constraintWidget4.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                        constraintWidget4.BuiltInFictitiousFunctionClassFactory(next3.MyBillsEntityDataFactory() + i6);
                        KClassImpl$Data$declaredNonStaticMembers$2(i7, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        if (r7.BuiltInFictitiousFunctionClassFactory(0, r7.h == 8 ? 0 : r7.FlowViewUtil$textChanges$2) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0098, code lost:
    
        if (r7.BuiltInFictitiousFunctionClassFactory(1, r7.h != 8 ? 0 : r7.C) != false) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getAuthRequestContext(androidx.constraintlayout.core.widgets.ConstraintWidget r7) {
        /*
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r7.getNameOrBuilderList
            r1 = 0
            r0 = r0[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r7.getNameOrBuilderList
            r3 = 1
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r7.W
            if (r4 == 0) goto L13
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r7.W
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r4
            goto L14
        L13:
            r4 = 0
        L14:
            if (r4 == 0) goto L1c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r4.getNameOrBuilderList
            r5 = r5[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
        L1c:
            if (r4 == 0) goto L24
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.getNameOrBuilderList
            r4 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
        L24:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r5 = 8
            r6 = 0
            if (r0 == r4) goto L61
            boolean r4 = r7.PlaceComponentResult()
            if (r4 != 0) goto L61
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r4) goto L61
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r4) goto L49
            int r4 = r7.N
            if (r4 != 0) goto L49
            float r4 = r7.SubSequence
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L49
            boolean r4 = r7.getAuthRequestContext(r1)
            if (r4 != 0) goto L61
        L49:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r4) goto L5f
            int r0 = r7.N
            if (r0 != r3) goto L5f
            int r0 = r7.h
            if (r0 != r5) goto L57
            r0 = 0
            goto L59
        L57:
            int r0 = r7.FlowViewUtil$textChanges$2
        L59:
            boolean r0 = r7.BuiltInFictitiousFunctionClassFactory(r1, r0)
            if (r0 != 0) goto L61
        L5f:
            r0 = 0
            goto L62
        L61:
            r0 = 1
        L62:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r2 == r4) goto L9c
            boolean r4 = r7.getAuthRequestContext()
            if (r4 != 0) goto L9c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 == r4) goto L9c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r4) goto L84
            int r4 = r7.K
            if (r4 != 0) goto L84
            float r4 = r7.SubSequence
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L84
            boolean r4 = r7.getAuthRequestContext(r3)
            if (r4 != 0) goto L9c
        L84:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r4) goto L9a
            int r2 = r7.K
            if (r2 != r3) goto L9a
            int r2 = r7.h
            if (r2 != r5) goto L92
            r2 = 0
            goto L94
        L92:
            int r2 = r7.C
        L94:
            boolean r2 = r7.BuiltInFictitiousFunctionClassFactory(r3, r2)
            if (r2 != 0) goto L9c
        L9a:
            r2 = 0
            goto L9d
        L9c:
            r2 = 1
        L9d:
            float r7 = r7.SubSequence
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto La8
            if (r0 != 0) goto La7
            if (r2 == 0) goto La8
        La7:
            return r3
        La8:
            if (r0 == 0) goto Lad
            if (r2 == 0) goto Lad
            r1 = 1
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.getAuthRequestContext(androidx.constraintlayout.core.widgets.ConstraintWidget):boolean");
    }

    private static void BuiltInFictitiousFunctionClassFactory(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        float f = constraintWidget.BottomSheetCardBindingView$watcherCardNumberView$1;
        ConstraintAnchor constraintAnchor = constraintWidget.I.moveToNextValue;
        int i2 = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
        ConstraintAnchor constraintAnchor2 = constraintWidget.c.moveToNextValue;
        int i3 = !constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor2.PlaceComponentResult;
        int MyBillsEntityDataFactory = constraintWidget.I.MyBillsEntityDataFactory();
        int MyBillsEntityDataFactory2 = constraintWidget.c.MyBillsEntityDataFactory();
        if (i2 == i3) {
            f = 0.5f;
        } else {
            i2 += MyBillsEntityDataFactory;
            i3 -= MyBillsEntityDataFactory2;
        }
        int i4 = constraintWidget.h != 8 ? constraintWidget.FlowViewUtil$textChanges$2 : 0;
        int i5 = (i3 - i2) - i4;
        if (i2 > i3) {
            i5 = (i2 - i3) - i4;
        }
        int i6 = ((int) (i5 > 0 ? (f * i5) + 0.5f : f * i5)) + i2;
        int i7 = i6 + i4;
        if (i2 > i3) {
            i7 = i6 - i4;
        }
        constraintWidget.PlaceComponentResult(i6, i7);
        MyBillsEntityDataFactory(i + 1, constraintWidget, measurer, z);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        float f = constraintWidget2.BottomSheetCardBindingView$watcherCardNumberView$1;
        ConstraintAnchor constraintAnchor = constraintWidget2.I.moveToNextValue;
        int i2 = 0;
        int MyBillsEntityDataFactory = (!constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult) + constraintWidget2.I.MyBillsEntityDataFactory();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.c.moveToNextValue;
        int MyBillsEntityDataFactory2 = (!constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor2.PlaceComponentResult) - constraintWidget2.c.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 >= MyBillsEntityDataFactory) {
            int i3 = constraintWidget2.h == 8 ? 0 : constraintWidget2.FlowViewUtil$textChanges$2;
            if (constraintWidget2.h != 8) {
                if (constraintWidget2.N == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        if (constraintWidget.h != 8) {
                            i2 = constraintWidget.FlowViewUtil$textChanges$2;
                        }
                    } else {
                        ConstraintWidget constraintWidget3 = constraintWidget.W;
                        if (constraintWidget3.h != 8) {
                            i2 = constraintWidget3.FlowViewUtil$textChanges$2;
                        }
                    }
                    i3 = (int) (constraintWidget2.BottomSheetCardBindingView$watcherCardNumberView$1 * 0.5f * i2);
                } else if (constraintWidget2.N == 0) {
                    i3 = MyBillsEntityDataFactory2 - MyBillsEntityDataFactory;
                }
                i3 = Math.max(constraintWidget2.P, i3);
                if (constraintWidget2.O > 0) {
                    i3 = Math.min(constraintWidget2.O, i3);
                }
            }
            int i4 = MyBillsEntityDataFactory + ((int) ((f * ((MyBillsEntityDataFactory2 - MyBillsEntityDataFactory) - i3)) + 0.5f));
            constraintWidget2.PlaceComponentResult(i4, i3 + i4);
            MyBillsEntityDataFactory(i + 1, constraintWidget2, measurer, z);
        }
    }

    private static void getAuthRequestContext(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f = constraintWidget.e;
        ConstraintAnchor constraintAnchor = constraintWidget.f5939a.moveToNextValue;
        int i2 = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
        ConstraintAnchor constraintAnchor2 = constraintWidget.isLayoutRequested.moveToNextValue;
        int i3 = !constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor2.PlaceComponentResult;
        int MyBillsEntityDataFactory = constraintWidget.f5939a.MyBillsEntityDataFactory();
        int MyBillsEntityDataFactory2 = constraintWidget.isLayoutRequested.MyBillsEntityDataFactory();
        if (i2 == i3) {
            f = 0.5f;
        } else {
            i2 += MyBillsEntityDataFactory;
            i3 -= MyBillsEntityDataFactory2;
        }
        int i4 = constraintWidget.h != 8 ? constraintWidget.C : 0;
        int i5 = (i3 - i2) - i4;
        if (i2 > i3) {
            i5 = (i2 - i3) - i4;
        }
        int i6 = (int) (i5 > 0 ? (f * i5) + 0.5f : f * i5);
        int i7 = i2 + i6;
        int i8 = i7 + i4;
        if (i2 > i3) {
            i7 = i2 - i6;
            i8 = i7 - i4;
        }
        constraintWidget.getAuthRequestContext(i7, i8);
        KClassImpl$Data$declaredNonStaticMembers$2(i + 1, constraintWidget, measurer);
    }

    private static void PlaceComponentResult(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float f = constraintWidget2.e;
        ConstraintAnchor constraintAnchor = constraintWidget2.f5939a.moveToNextValue;
        int i2 = 0;
        int MyBillsEntityDataFactory = (!constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult) + constraintWidget2.f5939a.MyBillsEntityDataFactory();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.isLayoutRequested.moveToNextValue;
        int MyBillsEntityDataFactory2 = (!constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor2.PlaceComponentResult) - constraintWidget2.isLayoutRequested.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 >= MyBillsEntityDataFactory) {
            int i3 = constraintWidget2.h == 8 ? 0 : constraintWidget2.C;
            if (constraintWidget2.h != 8) {
                if (constraintWidget2.K == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        if (constraintWidget.h != 8) {
                            i2 = constraintWidget.C;
                        }
                    } else {
                        ConstraintWidget constraintWidget3 = constraintWidget.W;
                        if (constraintWidget3.h != 8) {
                            i2 = constraintWidget3.C;
                        }
                    }
                    i3 = (int) (f * 0.5f * i2);
                } else if (constraintWidget2.K == 0) {
                    i3 = MyBillsEntityDataFactory2 - MyBillsEntityDataFactory;
                }
                i3 = Math.max(constraintWidget2.SummaryVoucherView$$ExternalSyntheticLambda0, i3);
                if (constraintWidget2.Q > 0) {
                    i3 = Math.min(constraintWidget2.Q, i3);
                }
            }
            int i4 = MyBillsEntityDataFactory + ((int) ((f * ((MyBillsEntityDataFactory2 - MyBillsEntityDataFactory) - i3)) + 0.5f));
            constraintWidget2.getAuthRequestContext(i4, i3 + i4);
            KClassImpl$Data$declaredNonStaticMembers$2(i + 1, constraintWidget2, measurer);
        }
    }

    public static void getAuthRequestContext(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.getNameOrBuilderList[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer.getNameOrBuilderList[1];
        PlaceComponentResult = 0;
        KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        constraintWidgetContainer.readMicros();
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.getContainerAuth;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).readMicros();
        }
        boolean C = constraintWidgetContainer.C();
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.PlaceComponentResult(0, constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2);
        } else {
            constraintWidgetContainer.SubSequence();
        }
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            char c = 65535;
            if (i2 >= size) {
                break;
            }
            ConstraintWidget constraintWidget = arrayList.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.BuiltInFictitiousFunctionClassFactory == 1) {
                    if (guideline.BuiltInFictitiousFunctionClassFactory() != -1) {
                        int BuiltInFictitiousFunctionClassFactory = guideline.BuiltInFictitiousFunctionClassFactory();
                        ConstraintAnchor constraintAnchor = guideline.getAuthRequestContext;
                        constraintAnchor.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
                        constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline.t = true;
                    } else if (guideline.KClassImpl$Data$declaredNonStaticMembers$2() != -1 && constraintWidgetContainer.PlaceComponentResult()) {
                        int KClassImpl$Data$declaredNonStaticMembers$22 = (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2) - guideline.KClassImpl$Data$declaredNonStaticMembers$2();
                        ConstraintAnchor constraintAnchor2 = guideline.getAuthRequestContext;
                        constraintAnchor2.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$22;
                        constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline.t = true;
                    } else if (constraintWidgetContainer.PlaceComponentResult()) {
                        float lookAheadTest = guideline.lookAheadTest();
                        int i3 = constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.FlowViewUtil$textChanges$2;
                        ConstraintAnchor constraintAnchor3 = guideline.getAuthRequestContext;
                        constraintAnchor3.PlaceComponentResult = (int) ((lookAheadTest * i3) + 0.5f);
                        constraintAnchor3.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline.t = true;
                    }
                    z = true;
                }
            } else if (constraintWidget instanceof Barrier) {
                int i4 = ((Barrier) constraintWidget).PlaceComponentResult;
                if (i4 == 0 || i4 == 1) {
                    c = 0;
                } else if (i4 == 2 || i4 == 3) {
                    c = 1;
                }
                if (c == 0) {
                    z2 = true;
                }
            }
            i2++;
        }
        if (z) {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget2 = arrayList.get(i5);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.BuiltInFictitiousFunctionClassFactory == 1) {
                        MyBillsEntityDataFactory(0, guideline2, measurer, C);
                    }
                }
            }
        }
        MyBillsEntityDataFactory(0, constraintWidgetContainer, measurer, C);
        if (z2) {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget3 = arrayList.get(i6);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    int i7 = barrier.PlaceComponentResult;
                    if (((i7 == 0 || i7 == 1) ? (char) 0 : (i7 == 2 || i7 == 3) ? (char) 1 : (char) 65535) == 0 && barrier.BuiltInFictitiousFunctionClassFactory()) {
                        MyBillsEntityDataFactory(1, barrier, measurer, C);
                    }
                }
            }
        }
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.getAuthRequestContext(0, constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C);
        } else {
            constraintWidgetContainer.VerifyPinStateManager$executeRiskChallenge$2$1();
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget4 = arrayList.get(i8);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.BuiltInFictitiousFunctionClassFactory == 0) {
                    if (guideline3.BuiltInFictitiousFunctionClassFactory() != -1) {
                        int BuiltInFictitiousFunctionClassFactory2 = guideline3.BuiltInFictitiousFunctionClassFactory();
                        ConstraintAnchor constraintAnchor4 = guideline3.getAuthRequestContext;
                        constraintAnchor4.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2;
                        constraintAnchor4.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline3.t = true;
                    } else if (guideline3.KClassImpl$Data$declaredNonStaticMembers$2() != -1 && constraintWidgetContainer.getAuthRequestContext()) {
                        int KClassImpl$Data$declaredNonStaticMembers$23 = (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C) - guideline3.KClassImpl$Data$declaredNonStaticMembers$2();
                        ConstraintAnchor constraintAnchor5 = guideline3.getAuthRequestContext;
                        constraintAnchor5.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$23;
                        constraintAnchor5.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline3.t = true;
                    } else if (constraintWidgetContainer.getAuthRequestContext()) {
                        int lookAheadTest2 = (int) ((guideline3.lookAheadTest() * (constraintWidgetContainer.h == 8 ? 0 : constraintWidgetContainer.C)) + 0.5f);
                        ConstraintAnchor constraintAnchor6 = guideline3.getAuthRequestContext;
                        constraintAnchor6.PlaceComponentResult = lookAheadTest2;
                        constraintAnchor6.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        guideline3.t = true;
                    }
                    z3 = true;
                }
            } else if (constraintWidget4 instanceof Barrier) {
                int i9 = ((Barrier) constraintWidget4).PlaceComponentResult;
                if (((i9 == 0 || i9 == 1) ? (char) 0 : (i9 == 2 || i9 == 3) ? (char) 1 : (char) 65535) == 1) {
                    z4 = true;
                }
            }
        }
        if (z3) {
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget5 = arrayList.get(i10);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.BuiltInFictitiousFunctionClassFactory == 0) {
                        KClassImpl$Data$declaredNonStaticMembers$2(1, guideline4, measurer);
                    }
                }
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(0, constraintWidgetContainer, measurer);
        if (z4) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget6 = arrayList.get(i11);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    int i12 = barrier2.PlaceComponentResult;
                    if (((i12 == 0 || i12 == 1) ? (char) 0 : (i12 == 2 || i12 == 3) ? (char) 1 : (char) 65535) == 1 && barrier2.BuiltInFictitiousFunctionClassFactory()) {
                        KClassImpl$Data$declaredNonStaticMembers$2(1, barrier2, measurer);
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget7 = arrayList.get(i13);
            if (constraintWidget7.NetworkUserEntityData$$ExternalSyntheticLambda3() && getAuthRequestContext(constraintWidget7)) {
                ConstraintWidgetContainer.KClassImpl$Data$declaredNonStaticMembers$2(constraintWidget7, measurer, getAuthRequestContext, BasicMeasure.Measure.KClassImpl$Data$declaredNonStaticMembers$2);
                if (!(constraintWidget7 instanceof Guideline)) {
                    MyBillsEntityDataFactory(0, constraintWidget7, measurer, C);
                    KClassImpl$Data$declaredNonStaticMembers$2(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).BuiltInFictitiousFunctionClassFactory == 0) {
                    KClassImpl$Data$declaredNonStaticMembers$2(0, constraintWidget7, measurer);
                } else {
                    MyBillsEntityDataFactory(0, constraintWidget7, measurer, C);
                }
            }
        }
    }
}
