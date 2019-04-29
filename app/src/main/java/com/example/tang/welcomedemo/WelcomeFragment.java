package com.example.tang.welcomedemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * @author TangAnna
 * @description: 引导页的Fragment
 * @date :${DATA} 17:18
 */
public class WelcomeFragment extends Fragment {
    //    #d7e4eb
//    #d8e7e6
//    #b6cfd8
    private ImageView mImageView;
    private int[] colors = {0xd7e4eb, 0xd8e7e6, 0xb6cfd8};

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int imgId = getArguments().getInt("imgId");
        int index = getArguments().getInt("index");
        mImageView = view.findViewById(R.id.iv_bg);

//        Resources resources = this.getResources();
//        DisplayMetrics dm = resources.getDisplayMetrics();
//        float density1 = dm.density;
//        int width3 = dm.widthPixels;
//        int height3 = dm.heightPixels;
//        Log.d("===TAG", "宽onViewCreated: " + width3);
//        Log.d("===TAG", "高onViewCreated: " + height3);
//        if (width3 <= 1080) {
//            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        } else {
//            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
//        mImageView.setImageBitmap(readBitMap(getContext(), imgId));
        mImageView.setImageResource(imgId);
    }

    /**
     * @param imgId 图片资源
     */
    public static WelcomeFragment getInstance(int imgId, int index) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imgId", imgId);
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
