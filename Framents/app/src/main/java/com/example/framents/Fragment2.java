package com.example.framents;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private static final String TAG = Fragment2.class.getSimpleName();
    private static final int REQUEST_CAMERA = 20;

    Button btncamara, btnmsg;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragment2, container, false);

        btncamara = (Button) rootview.findViewById(R.id.btnCamera);
        btnmsg = (Button) rootview.findViewById(R.id.btnMsg);
        img = (ImageView) rootview.findViewById(R.id.imgfragment);
        return rootview;

    }

    @Override
    public void onResume() {
        super.onResume();

        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{
                        "sebastian@mail.com", "mail@mail.com", "eliot@evilcorp.com"
                });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Este es un texto que va como subject del mensaje");
                intent.putExtra(Intent.EXTRA_TEXT, "Este es el texto del cuerpo del mensaje que estamos enviando por un intent");
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "No hay aplicaciones de mail instaladas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA) {
            Log.e(TAG, "onActivityResult: " + resultCode);
            if (resultCode == getActivity().RESULT_OK) {
                Log.e(TAG, "onActivityResult: " + data.toString());
                Log.e(TAG, "onActivityResult: " + data.getExtras().toString());
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                img.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        img = (ImageView) getActivity().findViewById(R.id.imgfragment);
        img.buildDrawingCache();
        if (img.getDrawingCache() != null) {
//            Bitmap bmp = ((BitmapDrawable) img.getDrawable()).getBitmap();
            Bitmap bmp = img.getDrawingCache();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            outState.putByteArray("img", byteArray);
            onViewStateRestored(outState);
        }

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG, "onViewStateRestored: started");
        img = (ImageView) getActivity().findViewById(R.id.imgfragment);

        Log.e(TAG, "onViewStateRestored: " + savedInstanceState);
        if (savedInstanceState != null) {
            Log.e(TAG, "onViewStateRestored: " + savedInstanceState.getByteArray("img"));
            byte[] baimg = savedInstanceState.getByteArray("img");
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeByteArray(baimg, 100, 100, options);
            img.setImageBitmap(bitmap);
        }

    }
}
