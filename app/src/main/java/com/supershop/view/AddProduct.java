package com.supershop.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.supershop.R;
import com.supershop.model.Product;
import com.supershop.service.IProductService;
import com.supershop.service.ProductService;

import java.io.ByteArrayOutputStream;

public class AddProduct extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    EditText productName;
    RadioButton men;
    RadioButton women;
    private Context mContext;
    private IProductService productService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        productName = findViewById(R.id.et_add_product_name);
        men = findViewById(R.id.radio_add_product_cat_men);
        women = findViewById(R.id.radio_add_product_cat_women);
        productService = new ProductService();
        if (mContext == null)
            mContext = this;
    }

    public void pickImage(View view) {
        selectImage();
    }

    public void selectImage() {
        try{
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

        }catch (Exception e){

        }
       }

    public void AddProduct(View view) {

        String pName = productName.getText().toString();
        String catMen = (Boolean.getBoolean(men.getText().toString())== true)? "Men":"";
        String catWomen = (Boolean.getBoolean(women.getText().toString())== true)? "Women":"";

        ImageView imageView = (ImageView) findViewById(R.id.show_imgView);
        byte[] imageInByte = new byte[10000];
        if (imageView.getDrawable() != null) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            imageInByte = baos.toByteArray();
        }
            Product product = new Product();
            product.setProductImage(imageInByte);
            product.setProductName(pName);
            product.setMen(catMen);
            product.setWomen(catWomen);
            productService.insertData(mContext, product);
            Toast.makeText(mContext, "ok", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            try{
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                ImageView imageView = (ImageView) findViewById(R.id.show_imgView);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }catch (Exception e){

            }

        }
    }
}
