package org.itniorwings.aivita.Accounts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.itniorwings.aivita.ApiServices.ApiClient;
import org.itniorwings.aivita.ApiServices.RetrofitApi;
import org.itniorwings.aivita.R;

import org.itniorwings.aivita.model.RegisterModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    TextView tv_username,tv_useremail,txtphone;
    Button btnSignUp;
    ImageView imageView ;
    Button btn_take_photo,btn_save;
    private static final int SELECT_PHOTO = 200;
    private static final int CAMERA_REQUEST = 1888;
    final int MY_PERMISSIONS_REQUEST_WRITE = 103;

    EditText name,email,phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView relogin=findViewById(R.id.tv_loginagain);
        tv_username=findViewById(R.id.tv_username);
        tv_useremail=findViewById(R.id.tv_useremail);
        // password=findViewById(R.id.password);
        txtphone=findViewById(R.id.txtphone);
        btnSignUp=findViewById(R.id.btnSignUp);
        btn_take_photo=findViewById(R.id.btn_take_photo);
        imageView=findViewById(R.id.imageView);

        name=findViewById(R.id.simpleEditText);
        email=findViewById(R.id.edtemail);
        phone=findViewById(R.id.edtphone);
        password=findViewById(R.id.password);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE);
        }
        relogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,Login_A.class));
            }
        });

//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SignUp.this, Login_A.class));
//
//            }
//        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String email1=email.getText().toString();
                String phone1=phone.getText().toString();
                String pass=password.getText().toString();

                if(name1.equals("")){
                    Toast.makeText(SignUpActivity.this,"Enter First Name",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(email1.equals("")){
                    Toast.makeText(SignUpActivity.this,"Enter First Name",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(phone1.equals("")){
                    Toast.makeText(SignUpActivity.this,"Enter First Name",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(pass.equals("")){
                    Toast.makeText(SignUpActivity.this,"Enter First Name",Toast.LENGTH_LONG).show();
                    return;
                }


                else{
                    // progress_bar.setVisibility(View.VISIBLE);
                    postDriver(name1,email1,phone1,pass,imageImagePath);
                }
            }
        });

        btn_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        //setTitle();
        // back();
    }









    private void postDriver(String name ,String email, String phone,String pass ,String fileUrl) {
//        LoginModel model = sh.getLoginModel(getString(R.string.login_model));
//        String userid = model.getId();
        RequestBody imgFile = null;
        File imagPh = new File(fileUrl);
        //  Log.e("***********", "*************" + fileUrl);
        if (imagPh != null && (fileUrl!=null && !fileUrl.equalsIgnoreCase("")))
            imgFile = RequestBody.create(MediaType.parse("image/*"), imagPh);
        RequestBody name1 = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody email1 = RequestBody.create(MediaType.parse("text/plain"), email);
        RequestBody phone1 = RequestBody.create(MediaType.parse("text/plain"), phone);
        RequestBody pass1 = RequestBody.create(MediaType.parse("text/plain"), pass);
        RetrofitApi apiService = ApiClient.getClient().create(RetrofitApi.class);
        Call<RegisterModel> call=apiService.Register(name1,email1,phone1,pass1,imgFile);
        call.enqueue(new Callback<RegisterModel>() {


            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                //  progress_bar.setVisibility(View.GONE);
                Toast.makeText(SignUpActivity.this,"Data submitted successfully",Toast.LENGTH_LONG).show();
                finish();


            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                // progress_bar.setVisibility(View.GONE);

            }
        });
    }

    //    private void setTitle() {
//        TextView title = (TextView) findViewById(R.id.title);
//        title.setText(getString(R.string.add_image));
//    }
//    private void back() {
//       // RelativeLayout drawerIcon = (RelativeLayout) findViewById(R.id.drawerIcon);
//        drawerIcon.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
    Uri fileUri;

    private void selectImage() {
        final CharSequence[] options = {getString(R.string.take_photo), getString(R.string.choose_from_gallery), getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setTitle(getString(R.string.add_image));
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals(getString(R.string.take_photo))) {
                    /*Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);*/
                    String fileName = System.currentTimeMillis() + ".jpg";
                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, fileName);
                    fileUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    startActivityForResult(intent, CAMERA_REQUEST);
                } else if (options[item].equals(getString(R.string.choose_from_gallery))) {
                    openGallery();
                } else if (options[item].equals(getString(R.string.cancel))) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    String imageImagePath = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            try {
                imageImagePath = getPath(fileUri);
                File file=new File(imageImagePath);
                resize(file,"");
                Bitmap b = decodeUri(fileUri);
                imageView.setImageBitmap(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (requestCode == SELECT_PHOTO) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = data.getData();
                if (selectedImage != null) {
                    imageView.setImageURI(selectedImage);
                    imageImagePath = getPath(selectedImage);
                    File file=new File(imageImagePath);
                    resize(file,"");

                }
            }
        }
    }
    private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();

        o.inJustDecodeBounds = true;

        BitmapFactory.decodeStream(getContentResolver()
                .openInputStream(selectedImage), null, o);

        final int REQUIRED_SIZE = 72;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;

        int scale = 1;

        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;

            height_tmp /= 2;

            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();

        o2.inSampleSize = scale;

        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                .openInputStream(selectedImage), null, o2);

        return bitmap;
    }

    @SuppressWarnings("deprecation")
    private String getPath(Uri selectedImaeUri) {
        String[] projection = {MediaStore.Images.Media.DATA};

        Cursor cursor = managedQuery(selectedImaeUri, projection, null, null,
                null);

        if (cursor != null) {
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            return cursor.getString(columnIndex);
        }

        return selectedImaeUri.getPath();
    }

    BitmapFactory.Options bmOptions;
    Bitmap bitmap;
    public void resize(File file, String benchMark) {
        try {
            bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inPreferredConfig = Bitmap.Config.RGB_565;
            bmOptions.inDither = true;
            bitmap = BitmapFactory.decodeFile(imageImagePath, bmOptions);
            int w = bitmap.getWidth();
            int h = bitmap.getHeight();
            Log.e("width & Height", "width " + bitmap.getWidth());
            if (bitmap.getWidth() > 1200) {
                w = bitmap.getWidth() * 30 / 100;
                h = bitmap.getHeight() * 30 / 100;
            }

            Log.e("width & Height", "width " + w + " height " + h);
            bitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, bytes);
            try {
                Log.e("Compressing", "Compressing");
                FileOutputStream fo = new FileOutputStream(file);
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (Exception e) {
                Log.e("Exception", "Image Resizing" + e.getMessage());
            }
        } catch (
                Exception e
        ) {
            Log.e("Exception", "Exception in resizing image");
        }
    }
}
