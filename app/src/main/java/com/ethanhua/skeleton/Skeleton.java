package com.ethanhua.skeleton;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;

/* loaded from: classes.dex */
public class Skeleton {
    public static RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView) {
        return new RecyclerViewSkeletonScreen.Builder(recyclerView);
    }

    public static ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory(View view) {
        return new ViewSkeletonScreen.Builder(view);
    }
}
