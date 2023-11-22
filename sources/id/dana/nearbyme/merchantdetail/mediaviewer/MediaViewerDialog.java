package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 **\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u001eJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\f\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\f\u0010\u001cJ\u001d\u0010\u0014\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u0014\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\"R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000#j\b\u0012\u0004\u0012\u00028\u0000`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010%R\u0016\u0010\u0014\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerDialog;", "Landroid/os/Parcelable;", "T", "Landroidx/fragment/app/DialogFragment;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "p0", "Landroid/view/View;", "p1", "", "getAuthRequestContext", "(Landroid/os/Parcelable;Landroid/view/View;)V", "", "BuiltInFictitiousFunctionClassFactory", "()I", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "Landroid/os/Bundle;", "p2", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "(Ljava/util/List;)V", "onStart", "()V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerAdapter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerAdapter;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MediaViewerDialog<T extends Parcelable> extends DialogFragment implements MediaViewerContract.View<T> {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ArrayList<T> getAuthRequestContext = new ArrayList<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private PagerSnapHelper KClassImpl$Data$declaredNonStaticMembers$2;
    private MediaViewerAdapter<T> PlaceComponentResult;

    public View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public abstract MediaViewerContract.Presenter<T> MyBillsEntityDataFactory();

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    public void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public abstract void getAuthRequestContext(T p0, View p1);

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -1);
        }
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setFlags(512, 512);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.inflate(R.layout.fragment_media_viewer, p1, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View p0, Bundle p1) {
        ImageView imageView;
        MediaViewerModel mediaViewerModel;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        ((Toolbar) MyBillsEntityDataFactory(R.id.res_0x7f0a1353_r8_lambda_vlonsci8c_fhfev8ygihtq_vyhm)).setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewerDialog.BuiltInFictitiousFunctionClassFactory(MediaViewerDialog.this);
            }
        });
        this.PlaceComponentResult = new MediaViewerAdapter<>(new MediaViewerDialog$initAdapter$1(this));
        ((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.KClassImpl$Data$declaredNonStaticMembers$2((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pagerSnapHelper;
        ((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog$getScrollListener$1
            final /* synthetic */ MediaViewerDialog<T> getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.getAuthRequestContext = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p02, int p12, int p2) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(p02, "");
                super.onScrolled(p02, p12, p2);
                KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                MediaViewerDialog<T> mediaViewerDialog = this.getAuthRequestContext;
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    mediaViewerDialog.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
                ((ImageView) mediaViewerDialog.MyBillsEntityDataFactory(R.id.res_0x7f0a0b70_homerecyclefragment_init_3_1)).setVisibility(KClassImpl$Data$declaredNonStaticMembers$2 ? 8 : 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p02, int p12) {
                Intrinsics.checkNotNullParameter(p02, "");
                super.onScrollStateChanged(p02, p12);
                boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p02);
                MediaViewerDialog<T> mediaViewerDialog = this.getAuthRequestContext;
                if (BuiltInFictitiousFunctionClassFactory) {
                    mediaViewerDialog.MyBillsEntityDataFactory().scheduleImpl();
                }
                ImageView imageView2 = (ImageView) mediaViewerDialog.MyBillsEntityDataFactory(R.id.res_0x7f0a0c1a_splitconfigentitydata_getdiagnosticlogconfig_lambda_184_inlined_getconfigcachedonceready_default_1_1);
                if (imageView2 != null) {
                    imageView2.setVisibility(BuiltInFictitiousFunctionClassFactory ? 8 : 0);
                }
            }

            private static boolean BuiltInFictitiousFunctionClassFactory(RecyclerView p02) {
                return !p02.canScrollHorizontally(66);
            }
        });
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1);
        MediaViewerAdapter<T> mediaViewerAdapter = this.PlaceComponentResult;
        Unit unit = null;
        if (mediaViewerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerAdapter = null;
        }
        recyclerView.setAdapter(mediaViewerAdapter);
        Bundle arguments = getArguments();
        if (arguments != null && (mediaViewerModel = (MediaViewerModel) arguments.getParcelable("MEDIA_VIEWER_MODEL_EXTRA")) != null) {
            MyBillsEntityDataFactory().MyBillsEntityDataFactory(mediaViewerModel);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new MustSetMediaViewerModelArgument();
        }
        MyBillsEntityDataFactory().getAuthRequestContext();
        ((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).scrollToPosition(MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory);
        ((ImageView) MyBillsEntityDataFactory(R.id.res_0x7f0a0b70_homerecyclefragment_init_3_1)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewerDialog.MyBillsEntityDataFactory(MediaViewerDialog.this);
            }
        });
        ((ImageView) MyBillsEntityDataFactory(R.id.res_0x7f0a0c1a_splitconfigentitydata_getdiagnosticlogconfig_lambda_184_inlined_getconfigcachedonceready_default_1_1)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewerDialog.PlaceComponentResult(MediaViewerDialog.this);
            }
        });
        if (!PlaceComponentResult() || (imageView = (ImageView) MyBillsEntityDataFactory(R.id.res_0x7f0a0c1a_splitconfigentitydata_getdiagnosticlogconfig_lambda_184_inlined_getconfigcachedonceready_default_1_1)) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private final boolean PlaceComponentResult() {
        MediaViewerModel BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory() == 0;
    }

    private final int BuiltInFictitiousFunctionClassFactory() {
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.addAll(0, p0);
        MediaViewerAdapter<T> mediaViewerAdapter = this.PlaceComponentResult;
        if (mediaViewerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerAdapter = null;
        }
        mediaViewerAdapter.notifyItemRangeInserted(0, p0.size());
    }

    @Override // id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract.View
    public final void BuiltInFictitiousFunctionClassFactory(List<? extends T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.addAll(p0);
        MediaViewerAdapter<T> mediaViewerAdapter = this.PlaceComponentResult;
        if (mediaViewerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerAdapter = null;
        }
        mediaViewerAdapter.setItems(this.getAuthRequestContext);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MediaViewerDialog mediaViewerDialog) {
        Intrinsics.checkNotNullParameter(mediaViewerDialog, "");
        int BuiltInFictitiousFunctionClassFactory = mediaViewerDialog.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory > 0) {
            ((RecyclerView) mediaViewerDialog.MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).smoothScrollToPosition(BuiltInFictitiousFunctionClassFactory - 1);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MediaViewerDialog mediaViewerDialog) {
        Intrinsics.checkNotNullParameter(mediaViewerDialog, "");
        int BuiltInFictitiousFunctionClassFactory = mediaViewerDialog.BuiltInFictitiousFunctionClassFactory();
        MediaViewerAdapter<T> mediaViewerAdapter = mediaViewerDialog.PlaceComponentResult;
        if (mediaViewerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            mediaViewerAdapter = null;
        }
        if (BuiltInFictitiousFunctionClassFactory < mediaViewerAdapter.getItems().size()) {
            ((RecyclerView) mediaViewerDialog.MyBillsEntityDataFactory(R.id.res_0x7f0a1164_textviewkt_doontextchanged_inlined_addtextchangedlistener_default_1)).smoothScrollToPosition(BuiltInFictitiousFunctionClassFactory + 1);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MediaViewerDialog mediaViewerDialog) {
        Intrinsics.checkNotNullParameter(mediaViewerDialog, "");
        mediaViewerDialog.dismiss();
    }
}
