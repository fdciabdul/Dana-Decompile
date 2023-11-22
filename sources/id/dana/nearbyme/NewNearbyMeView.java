package id.dana.nearbyme;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.common.base.Ascii;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.base.BaseAsyncRecyclerViewHolder;
import id.dana.base.GestureListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NetworkUtils;
import id.dana.databinding.NewViewNearbyMeEntryPointBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewNearbyMeWidgetComponent;
import id.dana.di.component.NewNearbyMeWidgetComponent;
import id.dana.di.modules.NewNearbyMeModule;
import id.dana.dialog.DialogPermission;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.nearbyme.merchantdetail.MerchantDetailActivity;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.permissionprompt.constant.PermissionPromptSource;
import id.dana.permissionprompt.view.PermissionPromptBottomSheetDialog;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.showcase.Utils;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public class NewNearbyMeView extends ViewBindingRichView<NewViewNearbyMeEntryPointBinding> {
    public static final byte[] $$a = {12, -73, 84, 57, -9, -58, TarHeader.LF_SYMLINK, -7, 9, -17, -55, 60, -13, -8, 13, -20, 19, -16, -12, -59, Ascii.FS, 19, -8, 13, -20, 19, -48, Ascii.DC4, -40, Ascii.RS, 13, -15, 9, -17, 7, 1};
    public static final int $$b = 13;
    public static final int MAX_RETRY = 5;
    public static final String SOURCE = "Nearby Home Widget";
    private final CompositeDisposable BuiltInFictitiousFunctionClassFactory;
    private boolean DatabaseTableConfigUtil;
    private DialogPermission FragmentBottomSheetPaymentSettingBinding;
    private Disposable GetContactSyncConfig;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Runnable MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda2;
    private OnRedirectListener NetworkUserEntityData$$ExternalSyntheticLambda3;
    private RecyclerViewSkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda4;
    private String NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda7;
    private NewNearbyShopsAdapter NetworkUserEntityData$$ExternalSyntheticLambda8;
    private NewNearbyMeWidgetComponent PlaceComponentResult;
    private boolean PrepareContext;
    private int getAuthRequestContext;
    private GestureDetector getErrorConfigVersion;
    private Location initRecordTimeStamp;
    private OnNearbyMeEntryView isLayoutRequested;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    private boolean newProxyInstance;
    @Inject
    Lazy<NewNearbyMeContract.Presenter> presenter;
    private boolean scheduleImpl;

    /* loaded from: classes2.dex */
    public interface OnNearbyMeEntryView {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(IntentSender intentSender);

        void MyBillsEntityDataFactory(boolean z);
    }

    private static void a(byte b, int i, byte b2, Object[] objArr) {
        int i2 = i + 4;
        int i3 = (b2 * 3) + 105;
        byte[] bArr = $$a;
        int i4 = 33 - (b * 3);
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3 = i2 + i6 + 4;
            i6 = i6;
            i2 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i2 + 1;
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = i3 + bArr[i7] + 4;
            i6 = i6;
            i2 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initLocationUpdateRequest$9() throws Exception {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.new_view_nearby_me_entry_point;
    }

    @Override // id.dana.base.BaseRichView
    public boolean isForRecyclerViewholder() {
        return true;
    }

    public NewNearbyMeView(Context context) {
        super(context);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
        this.moveToNextValue = false;
        this.DatabaseTableConfigUtil = false;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        this.PlaceComponentResult = null;
        this.lookAheadTest = false;
        this.scheduleImpl = true;
    }

    public NewNearbyMeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
        this.moveToNextValue = false;
        this.DatabaseTableConfigUtil = false;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        this.PlaceComponentResult = null;
        this.lookAheadTest = false;
        this.scheduleImpl = true;
    }

    public NewNearbyMeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
        this.moveToNextValue = false;
        this.DatabaseTableConfigUtil = false;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        this.PlaceComponentResult = null;
        this.lookAheadTest = false;
        this.scheduleImpl = true;
    }

    public void setOnRedirectToNearbyMeListener(OnRedirectListener onRedirectListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = onRedirectListener;
    }

    public void setFinishLoaded(Runnable runnable) {
        this.MyBillsEntityDataFactory = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showLocationPermissionDialog$0$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ Unit m2726xc3bf90a3() {
        this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2();
        PermissionHelper.getAuthRequestContext(getContext());
        return Unit.INSTANCE;
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        if (this.PlaceComponentResult != null) {
            return;
        }
        DaggerNewNearbyMeWidgetComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerNewNearbyMeWidgetComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (NewNearbyMeModule) Preconditions.getAuthRequestContext(new NewNearbyMeModule(new NewNearbyMeContract.View() { // from class: id.dana.nearbyme.NewNearbyMeView.1
            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                return NewNearbyMeView.SOURCE;
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, boolean z2) {
                NewNearbyMeView.this.newProxyInstance = z;
                NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext = z2;
                if (!z) {
                    ((NewViewNearbyMeEntryPointBinding) NewNearbyMeView.this.getBinding()).moveToNextValue.getAuthRequestContext.setVisibility(8);
                    ((NewViewNearbyMeEntryPointBinding) NewNearbyMeView.this.getBinding()).MyBillsEntityDataFactory.setVisibility(8);
                    NewNearbyMeView.access$600(NewNearbyMeView.this);
                    return;
                }
                ((NewViewNearbyMeEntryPointBinding) NewNearbyMeView.this.getBinding()).moveToNextValue.getAuthRequestContext.setVisibility(0);
                ((NewViewNearbyMeEntryPointBinding) NewNearbyMeView.this.getBinding()).MyBillsEntityDataFactory.setVisibility(0);
                NewNearbyMeView.this.checkPermission(false, false);
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void getAuthRequestContext(boolean z) {
                NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
                ((NewViewNearbyMeEntryPointBinding) NewNearbyMeView.this.getBinding()).getAuthRequestContext.setVisibility((!NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda6 || NewNearbyMeView.this.moveToNextValue) ? 8 : 0);
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void MyBillsEntityDataFactory(NearbyShopsModel nearbyShopsModel) {
                NewNearbyMeView.access$1000(NewNearbyMeView.this, nearbyShopsModel);
                if (NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory()) {
                    return;
                }
                NewNearbyMeView.this.presenter.get().BuiltInFictitiousFunctionClassFactory(nearbyShopsModel.MyBillsEntityDataFactory);
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void PlaceComponentResult(List<ShopModel> list) {
                NewNearbyShopsAdapter newNearbyShopsAdapter = NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                for (ShopModel shopModel : list) {
                    Integer num = newNearbyShopsAdapter.PlaceComponentResult.get(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1);
                    List<T> list2 = newNearbyShopsAdapter.MyBillsEntityDataFactory;
                    if (num != null) {
                        list2.set(num.intValue(), shopModel);
                    }
                    newNearbyShopsAdapter.getAuthRequestContext(list2);
                }
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
                NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
                NewNearbyMeView.access$1200(NewNearbyMeView.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
                NewNearbyMeView.access$1300(NewNearbyMeView.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
                if (NewNearbyMeView.this.NetworkUserEntityData$$ExternalSyntheticLambda8.getPlaceComponentResult() == 0) {
                    NewNearbyMeView.this.BuiltInFictitiousFunctionClassFactory();
                    NewNearbyMeView.access$600(NewNearbyMeView.this);
                }
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final String BuiltInFictitiousFunctionClassFactory() {
                return NewNearbyMeView.this.getShownErrorMessage();
            }

            @Override // id.dana.contract.nearbyme.NewNearbyMeContract.View
            public final void MyBillsEntityDataFactory() {
                if (NewNearbyMeView.this.initRecordTimeStamp != null) {
                    NewNearbyMeView newNearbyMeView = NewNearbyMeView.this;
                    newNearbyMeView.BuiltInFictitiousFunctionClassFactory(newNearbyMeView.initRecordTimeStamp);
                    return;
                }
                NewNearbyMeView.this.KClassImpl$Data$declaredNonStaticMembers$2(true);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, NewNearbyMeModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        DaggerNewNearbyMeWidgetComponent.NewNearbyMeWidgetComponentImpl newNearbyMeWidgetComponentImpl = new DaggerNewNearbyMeWidgetComponent.NewNearbyMeWidgetComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0);
        this.PlaceComponentResult = newNearbyMeWidgetComponentImpl;
        newNearbyMeWidgetComponentImpl.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.presenter.get());
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        Runnable runnable;
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.NEARBY_ME);
        getBinding().moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(R.string.lblNearbyHome));
        getBinding().moveToNextValue.MyBillsEntityDataFactory.setContentDescription(getContext().getString(R.string.lblNearbySubtitleHome));
        getBinding().moveToNextValue.getAuthRequestContext.setContentDescription(getContext().getString(R.string.btnNearbyExplore));
        getBinding().moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setText(R.string.nearby_me_entry_point_title);
        getBinding().moveToNextValue.MyBillsEntityDataFactory.setText(R.string.nearby_me_entry_point_body);
        getBinding().moveToNextValue.getAuthRequestContext.setActiveButton(getContext().getString(R.string.explore_text), null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new NewNearbyShopsAdapter(getBinding().KClassImpl$Data$declaredNonStaticMembers$2, new BaseAsyncRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda2
            @Override // id.dana.base.BaseAsyncRecyclerViewHolder.OnItemClickListener
            public final void getAuthRequestContext(int i) {
                NewNearbyMeView.this.m2723lambda$initNearbyShopList$1$iddananearbymeNewNearbyMeView(i);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.getErrorConfigVersion = new GestureDetector(getBaseActivity(), new GestureListener(getBinding().KClassImpl$Data$declaredNonStaticMembers$2));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: id.dana.nearbyme.NewNearbyMeView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
                NewNearbyMeView.this.getErrorConfigVersion.onTouchEvent(motionEvent);
                return false;
            }
        });
        Glide.getAuthRequestContext(this).getAuthRequestContext(Integer.valueOf((int) R.drawable.ic_nearby_widget_maps)).KClassImpl$Data$declaredNonStaticMembers$2(new CenterCrop(), new RoundedCorners(getResources().getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f))).MyBillsEntityDataFactory((ImageView) getBinding().PlaceComponentResult);
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewNearbyMeView.this.m2724lambda$initWidgetMap$2$iddananearbymeNewNearbyMeView(view);
            }
        });
        this.presenter.get().BuiltInFictitiousFunctionClassFactory();
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            this.presenter.get().getAuthRequestContext();
            return;
        }
        getBinding().getAuthRequestContext.setVisibility(8);
        BuiltInFictitiousFunctionClassFactory();
        if (this.DatabaseTableConfigUtil || (runnable = this.MyBillsEntityDataFactory) == null) {
            return;
        }
        runnable.run();
        this.DatabaseTableConfigUtil = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initNearbyShopList$1$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2723lambda$initNearbyShopList$1$iddananearbymeNewNearbyMeView(int i) {
        ShopModel KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(i);
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            NewNearbyMeActivity.openMerchantDetailBottomsheet(getContext(), KClassImpl$Data$declaredNonStaticMembers$2, "Home");
            return;
        }
        MerchantDetailActivity.Companion companion = MerchantDetailActivity.INSTANCE;
        MerchantDetailActivity.Companion.getAuthRequestContext(getContext(), KClassImpl$Data$declaredNonStaticMembers$2, "Home");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initWidgetMap$2$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2724lambda$initWidgetMap$2$iddananearbymeNewNearbyMeView(View view) {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent;
        OnRedirectListener onRedirectListener = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (onRedirectListener != null) {
            onRedirectListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            intent = new Intent(getContext(), NewNearbyMeActivity.class);
        } else {
            Context context = getContext();
            byte[] bArr = $$a;
            byte b = (byte) (bArr[35] - 1);
            byte b2 = (byte) (-bArr[35]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr);
            intent = new Intent(context, Class.forName((String) objArr[0]));
        }
        intent.putExtra("EXTRA_SOURCE", this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().moveToNextValue.getAuthRequestContext.setVisibility(0);
        getBinding().lookAheadTest.getAuthRequestContext.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public NewViewNearbyMeEntryPointBinding initViewBinding(View view) {
        return NewViewNearbyMeEntryPointBinding.PlaceComponentResult(view);
    }

    public void setSource(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str;
    }

    public void checkPermission(boolean z, boolean z2) {
        if (MyBillsEntityDataFactory()) {
            PlaceComponentResult();
            if (z) {
                return;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                this.isLayoutRequested.MyBillsEntityDataFactory(z2);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return;
        }
        onRequestPermissionResult(true, z);
    }

    private boolean MyBillsEntityDataFactory() {
        return (!OSUtil.GetContactSyncConfig() || ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || this.isLayoutRequested == null) ? false : true;
    }

    public void onRequestPermissionResult(boolean z, boolean z2) {
        if (this.newProxyInstance) {
            if (z) {
                if (LocationUtil.getAuthRequestContext(getContext())) {
                    if (this.scheduleImpl) {
                        this.presenter.get().MyBillsEntityDataFactory();
                        this.scheduleImpl = false;
                    }
                    getAuthRequestContext();
                    if (this.PrepareContext && !z2) {
                        this.PrepareContext = false;
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    KClassImpl$Data$declaredNonStaticMembers$2(z2);
                    return;
                }
                PlaceComponentResult();
                if (z2) {
                    return;
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    getBinding().moveToNextValue.getAuthRequestContext.setEnabled(false);
                    getBinding().moveToNextValue.getAuthRequestContext.setDanaButtonView(0, getContext().getString(R.string.explore_text), "", null);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    Disposable disposable = this.GetContactSyncConfig;
                    if (disposable != null) {
                        disposable.dispose();
                        this.GetContactSyncConfig = null;
                    }
                    LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder(getContext());
                    locationRequestBuilder.MyBillsEntityDataFactory.setAlwaysShow(true);
                    locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
                    Disposable subscribe = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda12
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            NewNearbyMeView.$r8$lambda$4bmi1bJ9IXa1eveqnMqBrBjW1OE(NewNearbyMeView.this, (LocationSettingsResult) obj);
                        }
                    });
                    this.GetContactSyncConfig = subscribe;
                    addDisposable(subscribe);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                return;
            }
            PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnViewAllClicked$3$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2725lambda$setOnViewAllClicked$3$iddananearbymeNewNearbyMeView(View view) {
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        this.PrepareContext = true;
        checkPermission(false, true);
    }

    private void lookAheadTest() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            getBinding().getAuthRequestContext.setVisibility(0);
        }
        getBinding().lookAheadTest.getAuthRequestContext.setVisibility(8);
        getBinding().moveToNextValue.getAuthRequestContext.setVisibility(0);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BuiltInFictitiousFunctionClassFactory(Location location) {
        if (location != null) {
            if (this.lookAheadTest) {
                this.presenter.get().getAuthRequestContext(location);
                return;
            }
            return;
        }
        PlaceComponentResult();
    }

    private void getErrorConfigVersion() {
        if (this.FragmentBottomSheetPaymentSettingBinding == null) {
            DialogPermission.Builder builder = new DialogPermission.Builder(getBaseActivity(), new DialogInterface.OnDismissListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda13
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NewNearbyMeView.this.m2727xaa96b50b(dialogInterface);
                }
            });
            builder.scheduleImpl = R.drawable.ic_location_graphic;
            String string = getContext().getString(R.string.t_n_c);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeView.this.m2728xe7b6792a(view);
                }
            };
            builder.MyBillsEntityDataFactory = string;
            builder.getAuthRequestContext = onClickListener;
            builder.lookAheadTest = getContext().getString(R.string.msg_location_dialog_desc);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = getContext().getString(R.string.msg_check_permission);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.nearbyme.NewNearbyMeView.3
                @Override // id.dana.dialog.DialogPermission.DialogListener
                public void onDialogDismissed() {
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public void onPositiveButtonClicked() {
                    Utils.PlaceComponentResult(NewNearbyMeView.this.getContext());
                    NewNearbyMeView.access$2000(NewNearbyMeView.this);
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public void onNegativeButtonClicked() {
                    NewNearbyMeView.access$2000(NewNearbyMeView.this);
                }
            };
            this.FragmentBottomSheetPaymentSettingBinding = new DialogPermission(builder.BuiltInFictitiousFunctionClassFactory, builder.moveToNextValue, builder, (byte) 0);
        }
        this.FragmentBottomSheetPaymentSettingBinding.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showSettingLocationPermission$4$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2727xaa96b50b(DialogInterface dialogInterface) {
        this.FragmentBottomSheetPaymentSettingBinding = null;
    }

    private void PlaceComponentResult() {
        Runnable runnable;
        this.moveToNextValue = true;
        getBinding().moveToNextValue.getAuthRequestContext.setVisibility(8);
        getBinding().lookAheadTest.getAuthRequestContext.setVisibility(8);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().getAuthRequestContext.setVisibility(8);
        Button button = (Button) getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.btn_action_emptystate);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeView.this.m2718xd2c8cc3c(view);
                }
            });
        }
        getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        if (this.DatabaseTableConfigUtil || (runnable = this.MyBillsEntityDataFactory) == null) {
            return;
        }
        runnable.run();
        this.DatabaseTableConfigUtil = true;
    }

    private void moveToNextValue() {
        getBinding().lookAheadTest.getAuthRequestContext.setVisibility(8);
        getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
    }

    private void scheduleImpl() {
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (recyclerViewSkeletonScreen == null) {
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.new_view_skeleton_nearby_shops;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 4;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen2 = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen2.MyBillsEntityDataFactory();
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = recyclerViewSkeletonScreen2;
            return;
        }
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initLocationUpdateRequest$8$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2722x16f3c7d(Throwable th) throws Exception {
        BuiltInFictitiousFunctionClassFactory();
    }

    /* renamed from: onLocationUpdate  reason: merged with bridge method [inline-methods] */
    public void m2721xc44f785e(final Location location, boolean z) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.getAuthRequestContext;
        if (i >= 5) {
            this.getAuthRequestContext = 0;
            Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (disposable != null) {
                disposable.dispose();
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            }
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (recyclerViewSkeletonScreen != null) {
                recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
            }
            SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (skeletonScreen != null) {
                skeletonScreen.PlaceComponentResult();
            }
            BuiltInFictitiousFunctionClassFactory();
            getAuthRequestContext();
        } else if (location != null) {
            if (this.scheduleImpl) {
                this.initRecordTimeStamp = location;
            }
            final ArrayList arrayList = new ArrayList();
            final Geocoder geocoder = new Geocoder(getContext());
            if (Build.VERSION.SDK_INT >= 33) {
                geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1, new Geocoder.GeocodeListener() { // from class: id.dana.nearbyme.NewNearbyMeView.4
                    @Override // android.location.Geocoder.GeocodeListener
                    public void onGeocode(List<Address> list) {
                        if (list.isEmpty()) {
                            NewNearbyMeView.access$2100(NewNearbyMeView.this, "");
                        } else {
                            NewNearbyMeView.access$2100(NewNearbyMeView.this, list.get(0).getSubLocality());
                        }
                    }
                });
            } else {
                Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda3
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return NewNearbyMeView.lambda$geocodeWithRx$11(geocoder, location, arrayList);
                    }
                });
                TimeUnit timeUnit = TimeUnit.SECONDS;
                KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
                ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
                ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
                Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(PlaceComponentResult, 10L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
                ObjectHelper.PlaceComponentResult(arrayList, "value is null");
                Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory, null, arrayList));
                Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
                ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
                Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory));
                Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
                ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
                addDisposable(RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory3, PlaceComponentResult2)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda4
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        NewNearbyMeView.this.m2719lambda$geocodeWithRx$12$iddananearbymeNewNearbyMeView((List) obj);
                    }
                }, Functions.DatabaseTableConfigUtil));
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                getAuthRequestContext();
                if (this.PrepareContext && !z) {
                    this.PrepareContext = false;
                    KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    BuiltInFictitiousFunctionClassFactory(location);
                    lookAheadTest();
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            Disposable disposable2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (disposable2 != null) {
                disposable2.dispose();
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            }
        } else {
            this.getAuthRequestContext = i + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$geocodeWithRx$11(Geocoder geocoder, Location location, List list) throws Exception {
        List<Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        return fromLocation == null ? list : fromLocation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$geocodeWithRx$12$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2719lambda$geocodeWithRx$12$iddananearbymeNewNearbyMeView(List list) throws Exception {
        if (!list.isEmpty()) {
            getBinding().BuiltInFictitiousFunctionClassFactory.setText(((Address) list.get(0)).getSubLocality());
            return;
        }
        getBinding().BuiltInFictitiousFunctionClassFactory.setText("");
    }

    public void setOnNearbyMeEntryView(OnNearbyMeEntryView onNearbyMeEntryView) {
        this.isLayoutRequested = onNearbyMeEntryView;
    }

    public void disposeByActivity() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.presenter.get().onDestroy();
    }

    public void notifyFinishCheckSessionWatcher() {
        this.lookAheadTest = true;
        this.presenter.get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$4bmi1bJ9IXa1eveqnMqBrBjW1OE(NewNearbyMeView newNearbyMeView, LocationSettingsResult locationSettingsResult) {
        if (locationSettingsResult != null && locationSettingsResult.getStatus() != null) {
            Status status = locationSettingsResult.getStatus();
            int statusCode = status.getStatusCode();
            if (statusCode == 6) {
                if (newNearbyMeView.isLayoutRequested != null) {
                    if (status.getResolution() != null && status.getResolution().getIntentSender() != null) {
                        newNearbyMeView.isLayoutRequested.MyBillsEntityDataFactory(status.getResolution().getIntentSender());
                        return;
                    }
                    newNearbyMeView.getErrorConfigVersion();
                    return;
                }
                return;
            } else if (statusCode == 8502) {
                return;
            }
        }
        newNearbyMeView.getErrorConfigVersion();
    }

    static /* synthetic */ void access$1000(NewNearbyMeView newNearbyMeView, NearbyShopsModel nearbyShopsModel) {
        Runnable runnable;
        if (nearbyShopsModel.MyBillsEntityDataFactory.isEmpty()) {
            newNearbyMeView.BuiltInFictitiousFunctionClassFactory();
        } else {
            newNearbyMeView.lookAheadTest();
            NewNearbyShopsAdapter newNearbyShopsAdapter = newNearbyMeView.NetworkUserEntityData$$ExternalSyntheticLambda8;
            List<T> list = newNearbyShopsAdapter.MyBillsEntityDataFactory;
            if (list != 0 && !list.isEmpty()) {
                newNearbyShopsAdapter.MyBillsEntityDataFactory.clear();
                newNearbyShopsAdapter.notifyDataSetChanged();
            }
            NewNearbyShopsAdapter newNearbyShopsAdapter2 = newNearbyMeView.NetworkUserEntityData$$ExternalSyntheticLambda8;
            List<ShopModel> list2 = nearbyShopsModel.MyBillsEntityDataFactory;
            if (list2 != null) {
                List<T> list3 = newNearbyShopsAdapter2.MyBillsEntityDataFactory;
                if (list3 == 0) {
                    newNearbyShopsAdapter2.getAuthRequestContext(list2);
                    newNearbyShopsAdapter2.notifyItemInserted(0);
                } else {
                    int size = list3.size();
                    newNearbyShopsAdapter2.MyBillsEntityDataFactory.addAll(list2);
                    newNearbyShopsAdapter2.notifyItemInserted(size);
                }
            }
        }
        if (newNearbyMeView.DatabaseTableConfigUtil || (runnable = newNearbyMeView.MyBillsEntityDataFactory) == null) {
            return;
        }
        runnable.run();
        newNearbyMeView.DatabaseTableConfigUtil = true;
    }

    static /* synthetic */ void access$1200(NewNearbyMeView newNearbyMeView) {
        newNearbyMeView.moveToNextValue();
        newNearbyMeView.scheduleImpl();
    }

    static /* synthetic */ void access$1300(NewNearbyMeView newNearbyMeView) {
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = newNearbyMeView.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
        }
        SkeletonScreen skeletonScreen = newNearbyMeView.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    static /* synthetic */ void access$2000(NewNearbyMeView newNearbyMeView) {
        DialogPermission dialogPermission = newNearbyMeView.FragmentBottomSheetPaymentSettingBinding;
        if (dialogPermission != null) {
            dialogPermission.getAuthRequestContext();
            newNearbyMeView.FragmentBottomSheetPaymentSettingBinding = null;
        }
    }

    static /* synthetic */ void access$2100(NewNearbyMeView newNearbyMeView, String str) {
        newNearbyMeView.getBinding().BuiltInFictitiousFunctionClassFactory.setText(str);
    }

    static /* synthetic */ void access$600(NewNearbyMeView newNearbyMeView) {
        Runnable runnable;
        if (newNearbyMeView.DatabaseTableConfigUtil || (runnable = newNearbyMeView.MyBillsEntityDataFactory) == null) {
            return;
        }
        runnable.run();
        newNearbyMeView.DatabaseTableConfigUtil = true;
    }

    private void getAuthRequestContext() {
        getBinding().moveToNextValue.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewNearbyMeView.this.m2725lambda$setOnViewAllClicked$3$iddananearbymeNewNearbyMeView(view);
            }
        });
        getBinding().moveToNextValue.getAuthRequestContext.setEnabled(true);
        getBinding().moveToNextValue.getAuthRequestContext.setDanaButtonView(1, getContext().getString(R.string.explore_text), "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(final boolean z) {
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (disposable != null) {
            disposable.dispose();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        }
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getBaseActivity().getDanaApplication()).KClassImpl$Data$declaredNonStaticMembers$2().subscribe(new Consumer() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyMeView.this.m2721xc44f785e(z, (Location) obj);
            }
        }, new Consumer() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyMeView.this.m2722x16f3c7d((Throwable) obj);
            }
        }, new Action() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Action
            public final void run() {
                NewNearbyMeView.lambda$initLocationUpdateRequest$9();
            }
        }, new Consumer() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyMeView.this.m2720x3bcc8636((Disposable) obj);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = subscribe;
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayNoLocationPermissionState$6$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2718xd2c8cc3c(View view) {
        new PermissionPromptBottomSheetDialog(PermissionPromptSource.NEARBY_WIDGET, new Function0() { // from class: id.dana.nearbyme.NewNearbyMeView$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewNearbyMeView.this.m2726xc3bf90a3();
            }
        }, null).BuiltInFictitiousFunctionClassFactory(getBaseActivity().getSupportFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initLocationUpdateRequest$10$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2720x3bcc8636(Disposable disposable) throws Exception {
        moveToNextValue();
        scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showSettingLocationPermission$5$id-dana-nearbyme-NewNearbyMeView  reason: not valid java name */
    public /* synthetic */ void m2728xe7b6792a(View view) {
        DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION));
    }

    public void onLocationResolutionResult(int i) {
        Disposable disposable = this.GetContactSyncConfig;
        if (disposable != null) {
            disposable.dispose();
            this.GetContactSyncConfig = null;
        }
        if (i == -1) {
            getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            if (!this.PrepareContext) {
                lookAheadTest();
                moveToNextValue();
                scheduleImpl();
            }
            KClassImpl$Data$declaredNonStaticMembers$2(false);
            return;
        }
        getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        getAuthRequestContext();
    }
}
