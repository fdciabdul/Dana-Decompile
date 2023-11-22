package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* loaded from: classes3.dex */
public class MergePaths implements ContentModel {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final MergePathsMode getAuthRequestContext;

    /* loaded from: classes3.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return EXCLUDE_INTERSECTIONS;
                            }
                            return MERGE;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = mergePathsMode;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public final boolean getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (!lottieDrawable.getAuthRequestContext()) {
            Logger.getAuthRequestContext("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new MergePathsContent(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergePaths{mode=");
        sb.append(this.getAuthRequestContext);
        sb.append('}');
        return sb.toString();
    }
}
