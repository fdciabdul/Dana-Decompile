package id.dana.core.ui.richview;

import id.dana.core.ui.richview.PausableProgressBar;
import id.dana.core.ui.richview.StoryProgressBar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/core/ui/richview/StoryProgressBar$callback$1;", "Lid/dana/core/ui/richview/PausableProgressBar$Callback;", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StoryProgressBar$callback$1 implements PausableProgressBar.Callback {
    final /* synthetic */ StoryProgressBar MyBillsEntityDataFactory;
    final /* synthetic */ int getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StoryProgressBar$callback$1(StoryProgressBar storyProgressBar, int i) {
        this.MyBillsEntityDataFactory = storyProgressBar;
        this.getAuthRequestContext = i;
    }

    @Override // id.dana.core.ui.richview.PausableProgressBar.Callback
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.getAuthRequestContext = this.getAuthRequestContext;
    }

    @Override // id.dana.core.ui.richview.PausableProgressBar.Callback
    public final void PlaceComponentResult() {
        boolean z;
        int i;
        ArrayList arrayList;
        StoryProgressBar.StoriesListener storiesListener;
        ArrayList arrayList2;
        StoryProgressBar.StoriesListener storiesListener2;
        int i2;
        ArrayList arrayList3;
        int i3;
        ArrayList arrayList4;
        int i4;
        ArrayList arrayList5;
        int i5;
        int i6;
        StoryProgressBar.StoriesListener unused;
        z = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        if (z) {
            storiesListener2 = this.MyBillsEntityDataFactory.getErrorConfigVersion;
            if (storiesListener2 != null) {
                storiesListener2.MyBillsEntityDataFactory();
            }
            i2 = this.MyBillsEntityDataFactory.getAuthRequestContext;
            if (i2 - 1 >= 0) {
                arrayList4 = this.MyBillsEntityDataFactory.PlaceComponentResult;
                i4 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                Object obj = arrayList4.get(i4 - 1);
                Intrinsics.checkNotNullExpressionValue(obj, "");
                ((PausableProgressBar) obj).setMinWithoutCallback();
                arrayList5 = this.MyBillsEntityDataFactory.PlaceComponentResult;
                StoryProgressBar storyProgressBar = this.MyBillsEntityDataFactory;
                i5 = storyProgressBar.getAuthRequestContext;
                storyProgressBar.getAuthRequestContext = i5 - 1;
                i6 = storyProgressBar.getAuthRequestContext;
                ((PausableProgressBar) arrayList5.get(i6)).startProgress();
            } else {
                arrayList3 = this.MyBillsEntityDataFactory.PlaceComponentResult;
                i3 = this.MyBillsEntityDataFactory.getAuthRequestContext;
                ((PausableProgressBar) arrayList3.get(i3)).startProgress();
            }
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = false;
            return;
        }
        i = this.MyBillsEntityDataFactory.getAuthRequestContext;
        int i7 = i + 1;
        arrayList = this.MyBillsEntityDataFactory.PlaceComponentResult;
        if (i7 <= arrayList.size() - 1) {
            storiesListener = this.MyBillsEntityDataFactory.getErrorConfigVersion;
            if (storiesListener != null) {
                storiesListener.BuiltInFictitiousFunctionClassFactory();
            }
            arrayList2 = this.MyBillsEntityDataFactory.PlaceComponentResult;
            ((PausableProgressBar) arrayList2.get(i7)).startProgress();
        } else {
            unused = this.MyBillsEntityDataFactory.getErrorConfigVersion;
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }
}
