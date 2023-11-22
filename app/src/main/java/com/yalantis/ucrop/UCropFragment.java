package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes8.dex */
public class UCropFragment extends Fragment {
    public static final Bitmap.CompressFormat KClassImpl$Data$declaredNonStaticMembers$2 = Bitmap.CompressFormat.JPEG;
    private ViewGroup DatabaseTableConfigUtil;
    private UCropView FragmentBottomSheetPaymentSettingBinding;
    private ViewGroup GetContactSyncConfig;
    private UCropFragmentCallback MyBillsEntityDataFactory;
    private ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda1;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda3;
    private ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda4;
    private ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda5;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda6;
    private OverlayView NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PlaceComponentResult;
    private boolean PrepareContext;
    private GestureCropImageView initRecordTimeStamp;
    private View moveToNextValue;
    private int newProxyInstance;
    private ViewGroup readMicros;
    private List<ViewGroup> getErrorConfigVersion = new ArrayList();
    private Bitmap.CompressFormat lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2;
    private int scheduleImpl = 90;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {1, 2, 3};
    private TransformImageView.TransformImageListener NetworkUserEntityData$$ExternalSyntheticLambda2 = new TransformImageView.TransformImageListener() { // from class: com.yalantis.ucrop.UCropFragment.1
        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void MyBillsEntityDataFactory(float f) {
            UCropFragment.getAuthRequestContext(UCropFragment.this, f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory(float f) {
            UCropFragment.KClassImpl$Data$declaredNonStaticMembers$2(UCropFragment.this, f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            UCropFragment.this.FragmentBottomSheetPaymentSettingBinding.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.moveToNextValue.setClickable(false);
            UCropFragmentCallback unused = UCropFragment.this.MyBillsEntityDataFactory;
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
            UCropFragmentCallback unused = UCropFragment.this.MyBillsEntityDataFactory;
            new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", exc));
        }
    };
    private final View.OnClickListener isLayoutRequested = new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropFragment.this.getAuthRequestContext(view.getId());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GestureTypes {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.MyBillsEntityDataFactory = (UCropFragmentCallback) context;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.toString());
            sb.append(" must implement UCropFragmentCallback");
            throw new ClassCastException(sb.toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        this.PlaceComponentResult = arguments.getInt("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.initRecordTimeStamp));
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = arguments.getInt("com.yalantis.ucrop.UcropLogoColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.getAuthRequestContext_res_0x7f06032c));
        this.PrepareContext = !arguments.getBoolean("com.yalantis.ucrop.HideBottomControls", false);
        this.newProxyInstance = arguments.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f060328));
        UCropView uCropView = (UCropView) inflate.findViewById(R.id.res_0x7f0a1989_networkuserentitydata_externalsyntheticlambda7);
        this.FragmentBottomSheetPaymentSettingBinding = uCropView;
        this.initRecordTimeStamp = uCropView.getCropImageView();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.FragmentBottomSheetPaymentSettingBinding.getOverlayView();
        this.initRecordTimeStamp.setTransformImageListener(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        ((ImageView) inflate.findViewById(R.id.image_view_logo)).setColorFilter(this.NetworkUserEntityData$$ExternalSyntheticLambda8, PorterDuff.Mode.SRC_ATOP);
        inflate.findViewById(R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a198a).setBackgroundColor(this.newProxyInstance);
        ViewGroup viewGroup2 = null;
        if (this.PrepareContext) {
            View.inflate(getContext(), R.layout.res_0x7f0d0461_kclassimpl_data_declarednonstaticmembers_2, (ViewGroup) inflate.findViewById(R.id.res_0x7f0a198b_networkuserentitydata_externalsyntheticlambda5));
            ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.state_aspect_ratio);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = viewGroup3;
            viewGroup3.setOnClickListener(this.isLayoutRequested);
            ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.initRecordTimeStamp_res_0x7f0a1271);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = viewGroup4;
            viewGroup4.setOnClickListener(this.isLayoutRequested);
            ViewGroup viewGroup5 = (ViewGroup) inflate.findViewById(R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
            this.readMicros = viewGroup5;
            viewGroup5.setOnClickListener(this.isLayoutRequested);
            this.GetContactSyncConfig = (ViewGroup) inflate.findViewById(R.id.layout_aspect_ratio);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (ViewGroup) inflate.findViewById(R.id.layout_rotate_wheel);
            this.DatabaseTableConfigUtil = (ViewGroup) inflate.findViewById(R.id.layout_scale_wheel);
            int i = arguments.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
            ArrayList parcelableArrayList = arguments.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                parcelableArrayList = new ArrayList();
                parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
                parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
                parcelableArrayList.add(new AspectRatio(getString(R.string.res_0x7f131846_kclassimpl_data_declarednonstaticmembers_2).toUpperCase(), 0.0f, 0.0f));
                parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
                parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
                i = 2;
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_aspect_ratio);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                AspectRatio aspectRatio = (AspectRatio) it.next();
                FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, viewGroup2);
                frameLayout.setLayoutParams(layoutParams);
                AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
                aspectRatioTextView.setActiveColor(this.PlaceComponentResult);
                aspectRatioTextView.setAspectRatio(aspectRatio);
                linearLayout.addView(frameLayout);
                this.getErrorConfigVersion.add(frameLayout);
                viewGroup2 = null;
            }
            this.getErrorConfigVersion.get(i).setSelected(true);
            Iterator<ViewGroup> it2 = this.getErrorConfigVersion.iterator();
            while (it2.hasNext()) {
                it2.next().setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        UCropFragment.this.initRecordTimeStamp.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                        UCropFragment.this.initRecordTimeStamp.setImageToWrapCropBounds();
                        if (view.isSelected()) {
                            return;
                        }
                        for (ViewGroup viewGroup6 : UCropFragment.this.getErrorConfigVersion) {
                            viewGroup6.setSelected(viewGroup6 == view);
                        }
                    }
                });
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = (TextView) inflate.findViewById(R.id.res_0x7f0a1305_networkuserentitydata_externalsyntheticlambda8);
            ((HorizontalProgressWheelView) inflate.findViewById(R.id.res_0x7f0a10cd_networkuserentitydata_externalsyntheticlambda1)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropFragment.3
                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void MyBillsEntityDataFactory(float f) {
                    UCropFragment.this.initRecordTimeStamp.postRotate(f / 42.0f);
                }

                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void MyBillsEntityDataFactory() {
                    UCropFragment.this.initRecordTimeStamp.setImageToWrapCropBounds();
                }

                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    UCropFragment.this.initRecordTimeStamp.cancelAllAnimations();
                }
            });
            ((HorizontalProgressWheelView) inflate.findViewById(R.id.res_0x7f0a10cd_networkuserentitydata_externalsyntheticlambda1)).setMiddleLineColor(this.PlaceComponentResult);
            inflate.findViewById(R.id.res_0x7f0a1bf2_networkuserentitydata_externalsyntheticlambda4).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UCropFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(UCropFragment.this);
                }
            });
            inflate.findViewById(R.id.res_0x7f0a1bf3_networkuserentitydata_externalsyntheticlambda3).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UCropFragment.moveToNextValue(UCropFragment.this);
                }
            });
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = (TextView) inflate.findViewById(R.id.text_view_scale);
            ((HorizontalProgressWheelView) inflate.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropFragment.6
                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void MyBillsEntityDataFactory(float f) {
                    if (f > 0.0f) {
                        UCropFragment.this.initRecordTimeStamp.zoomInImage(UCropFragment.this.initRecordTimeStamp.getCurrentScale() + (f * ((UCropFragment.this.initRecordTimeStamp.getMaxScale() - UCropFragment.this.initRecordTimeStamp.getMinScale()) / 15000.0f)));
                    } else {
                        UCropFragment.this.initRecordTimeStamp.zoomOutImage(UCropFragment.this.initRecordTimeStamp.getCurrentScale() + (f * ((UCropFragment.this.initRecordTimeStamp.getMaxScale() - UCropFragment.this.initRecordTimeStamp.getMinScale()) / 15000.0f)));
                    }
                }

                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void MyBillsEntityDataFactory() {
                    UCropFragment.this.initRecordTimeStamp.setImageToWrapCropBounds();
                }

                @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    UCropFragment.this.initRecordTimeStamp.cancelAllAnimations();
                }
            });
            ((HorizontalProgressWheelView) inflate.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.PlaceComponentResult);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.image_view_state_scale);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.res_0x7f0a08db_kclassimpl_data_declarednonstaticmembers_2);
            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.image_view_state_aspect_ratio);
            imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.PlaceComponentResult));
            imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.PlaceComponentResult));
            imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.PlaceComponentResult));
        }
        Uri uri = (Uri) arguments.getParcelable("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) arguments.getParcelable("com.yalantis.ucrop.OutputUri");
        String string = arguments.getString("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        this.lookAheadTest = valueOf;
        this.scheduleImpl = arguments.getInt("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArray = arguments.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (intArray != null && intArray.length == 3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = intArray;
        }
        this.initRecordTimeStamp.setMaxBitmapSize(arguments.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.initRecordTimeStamp.setMaxScaleMultiplier(arguments.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.initRecordTimeStamp.setImageToWrapCropBoundsAnimDuration(arguments.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setFreestyleCropEnabled(arguments.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setDimmedColor(arguments.getInt("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.MyBillsEntityDataFactory_res_0x7f06032b)));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCircleDimmedLayer(arguments.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setShowCropFrame(arguments.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropFrameColor(arguments.getInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.PlaceComponentResult_res_0x7f060329)));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropFrameStrokeWidth(arguments.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.getAuthRequestContext_res_0x7f0703d4)));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setShowCropGrid(arguments.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropGridRowCount(arguments.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropGridColumnCount(arguments.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropGridColor(arguments.getInt("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.res_0x7f06032a_kclassimpl_data_declarednonstaticmembers_2)));
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setCropGridStrokeWidth(arguments.getInt("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.res_0x7f0703d5_kclassimpl_data_declarednonstaticmembers_2)));
        float f = arguments.getFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float f2 = arguments.getFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int i2 = arguments.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayList2 = arguments.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (f > 0.0f && f2 > 0.0f) {
            ViewGroup viewGroup6 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (viewGroup6 != null) {
                viewGroup6.setVisibility(8);
            }
            this.initRecordTimeStamp.setTargetAspectRatio(f / f2);
        } else if (parcelableArrayList2 != null && i2 < parcelableArrayList2.size()) {
            this.initRecordTimeStamp.setTargetAspectRatio(((AspectRatio) parcelableArrayList2.get(i2)).BuiltInFictitiousFunctionClassFactory / ((AspectRatio) parcelableArrayList2.get(i2)).KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            this.initRecordTimeStamp.setTargetAspectRatio(0.0f);
        }
        int i3 = arguments.getInt("com.yalantis.ucrop.MaxSizeX", 0);
        int i4 = arguments.getInt("com.yalantis.ucrop.MaxSizeY", 0);
        if (i3 > 0 && i4 > 0) {
            this.initRecordTimeStamp.setMaxResultImageSizeX(i3);
            this.initRecordTimeStamp.setMaxResultImageSizeY(i4);
        }
        if (uri != null && uri2 != null) {
            try {
                this.initRecordTimeStamp.setImageUri(uri, uri2);
            } catch (Exception e) {
                new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", e));
            }
        } else {
            new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
        }
        if (this.PrepareContext) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4.getVisibility() == 0) {
                getAuthRequestContext(R.id.state_aspect_ratio);
            } else {
                getAuthRequestContext(R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
            }
        } else {
            PlaceComponentResult(0);
        }
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new View(getContext());
            this.moveToNextValue.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.moveToNextValue.setClickable(true);
        }
        ((RelativeLayout) inflate.findViewById(R.id.res_0x7f0a198b_networkuserentitydata_externalsyntheticlambda5)).addView(this.moveToNextValue);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(int i) {
        if (this.PrepareContext) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.setSelected(i == R.id.state_aspect_ratio);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.setSelected(i == R.id.initRecordTimeStamp_res_0x7f0a1271);
            this.readMicros.setSelected(i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
            this.GetContactSyncConfig.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(i == R.id.initRecordTimeStamp_res_0x7f0a1271 ? 0 : 8);
            this.DatabaseTableConfigUtil.setVisibility(i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2 ? 0 : 8);
            if (i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2) {
                PlaceComponentResult(0);
            } else if (i == R.id.initRecordTimeStamp_res_0x7f0a1271) {
                PlaceComponentResult(1);
            } else {
                PlaceComponentResult(2);
            }
        }
    }

    private void PlaceComponentResult(int i) {
        GestureCropImageView gestureCropImageView = this.initRecordTimeStamp;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.initRecordTimeStamp;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        gestureCropImageView2.setRotateEnabled(i3 == 3 || i3 == 2);
    }

    /* renamed from: com.yalantis.ucrop.UCropFragment$8  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass8 implements BitmapCropCallback {
        final /* synthetic */ UCropFragment KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public final void BuiltInFictitiousFunctionClassFactory(Uri uri, int i, int i2, int i3, int i4) {
            UCropFragmentCallback unused = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
            UCropFragment uCropFragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
            new UCropResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropFragment.initRecordTimeStamp.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            UCropFragmentCallback unused2 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public final void PlaceComponentResult(Throwable th) {
            UCropFragmentCallback unused = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
            new UCropResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
        }
    }

    /* loaded from: classes8.dex */
    public class UCropResult {
        public int BuiltInFictitiousFunctionClassFactory;
        public Intent KClassImpl$Data$declaredNonStaticMembers$2;

        public UCropResult(int i, Intent intent) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intent;
        }
    }

    static /* synthetic */ void getAuthRequestContext(UCropFragment uCropFragment, float f) {
        TextView textView = uCropFragment.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(UCropFragment uCropFragment, float f) {
        TextView textView = uCropFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(UCropFragment uCropFragment) {
        GestureCropImageView gestureCropImageView = uCropFragment.initRecordTimeStamp;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        uCropFragment.initRecordTimeStamp.setImageToWrapCropBounds();
    }

    static /* synthetic */ void moveToNextValue(UCropFragment uCropFragment) {
        uCropFragment.initRecordTimeStamp.postRotate(90.0f);
        uCropFragment.initRecordTimeStamp.setImageToWrapCropBounds();
    }
}
