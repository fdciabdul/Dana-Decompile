package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final RequestManager NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private boolean getAuthRequestContext;
    private final PreloadModelProvider<T> getErrorConfigVersion;
    private int lookAheadTest;
    private final PreloadTargetQueue moveToNextValue;
    private final PreloadSizeProvider<T> scheduleImpl;

    /* loaded from: classes7.dex */
    public interface PreloadModelProvider<U> {
        RequestBuilder<?> BuiltInFictitiousFunctionClassFactory();

        List<U> getAuthRequestContext();
    }

    /* loaded from: classes7.dex */
    public interface PreloadSizeProvider<T> {
        int[] PlaceComponentResult();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.lookAheadTest = i3;
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i > i4) {
            getAuthRequestContext(i2 + i, true);
        } else if (i < i4) {
            getAuthRequestContext(i, false);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    private void getAuthRequestContext(int i, boolean z) {
        int min;
        int i2;
        if (this.getAuthRequestContext != z) {
            this.getAuthRequestContext = z;
            for (int i3 = 0; i3 < this.moveToNextValue.PlaceComponentResult.size(); i3++) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext((Target<?>) this.moveToNextValue.PlaceComponentResult(0, 0));
            }
        }
        int i4 = (z ? this.MyBillsEntityDataFactory : -this.MyBillsEntityDataFactory) + i;
        if (i < i4) {
            i2 = Math.max(this.PlaceComponentResult, i);
            min = i4;
        } else {
            min = Math.min(this.BuiltInFictitiousFunctionClassFactory, i);
            i2 = i4;
        }
        int min2 = Math.min(this.lookAheadTest, min);
        int min3 = Math.min(this.lookAheadTest, Math.max(0, i2));
        if (i < i4) {
            for (int i5 = min3; i5 < min2; i5++) {
                getAuthRequestContext((List) this.getErrorConfigVersion.getAuthRequestContext(), true);
            }
        } else {
            for (int i6 = min2 - 1; i6 >= min3; i6--) {
                getAuthRequestContext((List) this.getErrorConfigVersion.getAuthRequestContext(), false);
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = min3;
        this.PlaceComponentResult = min2;
    }

    private void getAuthRequestContext(List<T> list, boolean z) {
        int size = list.size();
        if (z) {
            for (int i = 0; i < size; i++) {
                KClassImpl$Data$declaredNonStaticMembers$2(list.get(i));
            }
            return;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            KClassImpl$Data$declaredNonStaticMembers$2(list.get(i2));
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        int[] PlaceComponentResult;
        RequestBuilder<?> BuiltInFictitiousFunctionClassFactory;
        Executor executor;
        if (t == null || (PlaceComponentResult = this.scheduleImpl.PlaceComponentResult()) == null || (BuiltInFictitiousFunctionClassFactory = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory()) == null) {
            return;
        }
        PreloadTarget PlaceComponentResult2 = this.moveToNextValue.PlaceComponentResult(PlaceComponentResult[0], PlaceComponentResult[1]);
        executor = Executors.PlaceComponentResult;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, null, BuiltInFictitiousFunctionClassFactory, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> PlaceComponentResult;

        public final PreloadTarget PlaceComponentResult(int i, int i2) {
            PreloadTarget poll = this.PlaceComponentResult.poll();
            this.PlaceComponentResult.offer(poll);
            poll.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            poll.MyBillsEntityDataFactory = i2;
            return poll;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class PreloadTarget implements Target<Object> {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        private Request PlaceComponentResult;

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadStarted(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
        }

        PreloadTarget() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void setRequest(Request request) {
            this.PlaceComponentResult = request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final Request getRequest() {
            return this.PlaceComponentResult;
        }
    }
}
