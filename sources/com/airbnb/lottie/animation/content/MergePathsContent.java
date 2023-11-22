package com.airbnb.lottie.animation.content;

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class MergePathsContent implements PathContent, GreedyContent {
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final MergePaths PlaceComponentResult;
    private final Path BuiltInFictitiousFunctionClassFactory = new Path();
    private final Path scheduleImpl = new Path();
    private final Path MyBillsEntityDataFactory = new Path();
    private final List<PathContent> getAuthRequestContext = new ArrayList();

    public MergePathsContent(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mergePaths.KClassImpl$Data$declaredNonStaticMembers$2;
        this.PlaceComponentResult = mergePaths;
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void BuiltInFictitiousFunctionClassFactory(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.getAuthRequestContext.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).MyBillsEntityDataFactory(list, list2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.reset();
        if (this.PlaceComponentResult.getAuthRequestContext()) {
            return this.MyBillsEntityDataFactory;
        }
        int i = AnonymousClass1.getAuthRequestContext[this.PlaceComponentResult.getAuthRequestContext.ordinal()];
        if (i == 1) {
            for (int i2 = 0; i2 < this.getAuthRequestContext.size(); i2++) {
                this.MyBillsEntityDataFactory.addPath(this.getAuthRequestContext.get(i2).KClassImpl$Data$declaredNonStaticMembers$2());
            }
        } else if (i == 2) {
            MyBillsEntityDataFactory(Path.Op.UNION);
        } else if (i == 3) {
            MyBillsEntityDataFactory(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            MyBillsEntityDataFactory(Path.Op.INTERSECT);
        } else if (i == 5) {
            MyBillsEntityDataFactory(Path.Op.XOR);
        }
        return this.MyBillsEntityDataFactory;
    }

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private void MyBillsEntityDataFactory(Path.Op op) {
        Matrix matrix;
        Matrix matrix2;
        this.scheduleImpl.reset();
        this.BuiltInFictitiousFunctionClassFactory.reset();
        for (int size = this.getAuthRequestContext.size() - 1; size > 0; size--) {
            PathContent pathContent = this.getAuthRequestContext.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> BuiltInFictitiousFunctionClassFactory = contentGroup.BuiltInFictitiousFunctionClassFactory();
                for (int size2 = BuiltInFictitiousFunctionClassFactory.size() - 1; size2 >= 0; size2--) {
                    Path KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.get(size2).KClassImpl$Data$declaredNonStaticMembers$2();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.MyBillsEntityDataFactory;
                    if (transformKeyframeAnimation != null) {
                        matrix2 = transformKeyframeAnimation.PlaceComponentResult();
                    } else {
                        contentGroup.getAuthRequestContext.reset();
                        matrix2 = contentGroup.getAuthRequestContext;
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.transform(matrix2);
                    this.scheduleImpl.addPath(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            } else {
                this.scheduleImpl.addPath(pathContent.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        }
        PathContent pathContent2 = this.getAuthRequestContext.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> BuiltInFictitiousFunctionClassFactory2 = contentGroup2.BuiltInFictitiousFunctionClassFactory();
            for (int i = 0; i < BuiltInFictitiousFunctionClassFactory2.size(); i++) {
                Path KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory2.get(i).KClassImpl$Data$declaredNonStaticMembers$2();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.MyBillsEntityDataFactory;
                if (transformKeyframeAnimation2 != null) {
                    matrix = transformKeyframeAnimation2.PlaceComponentResult();
                } else {
                    contentGroup2.getAuthRequestContext.reset();
                    matrix = contentGroup2.getAuthRequestContext;
                }
                KClassImpl$Data$declaredNonStaticMembers$22.transform(matrix);
                this.BuiltInFictitiousFunctionClassFactory.addPath(KClassImpl$Data$declaredNonStaticMembers$22);
            }
        } else {
            this.BuiltInFictitiousFunctionClassFactory.set(pathContent2.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        this.MyBillsEntityDataFactory.op(this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl, op);
    }
}
