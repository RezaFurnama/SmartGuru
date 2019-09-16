package apps.rez.com.smartguru;import android.app.ProgressDialog;import android.content.Context;import android.content.Intent;import android.content.SharedPreferences;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.text.TextUtils;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.EditText;import android.widget.ImageView;import android.widget.Toast;import com.amulyakhare.textdrawable.TextDrawable;import org.json.JSONException;import org.json.JSONObject;import java.io.IOException;import apps.rez.com.smartguru.Rest.BaseApiService;import apps.rez.com.smartguru.Rest.UtilsApi;import okhttp3.ResponseBody;import retrofit2.Call;import retrofit2.Callback;import retrofit2.Response;public class LoginActivity extends AppCompatActivity {    Button loginButton;    ImageView appLogo;    EditText username, password;    ProgressDialog loading;    String user, pass;    Context mContext;    BaseApiService mApiService;    SharedPrefManager sharedPrefManager;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_login);        // Remember that you should never show the action bar if the        // status bar is hidden, so hide that too if necessary.        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));        mContext = this;        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper        sharedPrefManager = new SharedPrefManager(this);        if (sharedPrefManager.getSPLoggedIn()) {            startActivity(new Intent(LoginActivity.this, HomeActivity.class)                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));            finish();        }        initComponents();    }    private void initComponents() {        username = findViewById(R.id.etUsername);        password = findViewById(R.id.etPassword);        appLogo = findViewById(R.id.appLogo);        TextDrawable drawable = TextDrawable.builder()                .buildRound("S", getResources().getColor(R.color.colorPrimaryDark));        appLogo.setImageDrawable(drawable);        loginButton = findViewById(R.id.btnLogin);        loginButton.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);//                startActivity(intent);                if (TextUtils.isEmpty(username.getText().toString())) {                    username.setError("Tidak boleh kosong");                } else if (TextUtils.isEmpty(password.getText().toString())) {                    password.setError("Tidak boleh kosong");                } else if (TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(password.getText().toString())) {                    Toast.makeText(mContext, "Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show();                } else {                    loading = ProgressDialog.show(mContext, null, "Sedang Login...", true, false);                    requestLogin();                }            }        });    }    private void requestLogin() {        mApiService.authLogin(username.getText().toString().trim(), password.getText().toString().trim())                .enqueue(new Callback<ResponseBody>() {                    @Override                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {                        if (response.isSuccessful()) {                            loading.dismiss();                            Log.d("Retrofit", "Success Login");                            try {                                JSONObject jsonRESULTS = new JSONObject(response.body().string());                                if (jsonRESULTS.getString("status").equals("true")) {                                    // Jika login berhasil maka data nama yang ada di response API                                    // akan diparsing ke activity selanjutnya.                                    Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();                                    int id = Integer.parseInt(jsonRESULTS.getString("data"));                                    sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID, id);                                    // Shared Pref ini berfungsi untuk menjadi trigger session login                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_LOGGED_IN, true);                                    startActivity(new Intent(mContext, HomeActivity.class)                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));                                    finish();                                } else {                                    // Jika login gagal                                    String error_message = jsonRESULTS.getString("error_msg");                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();                                }                            } catch (JSONException | IOException e) {                                e.printStackTrace();                            }                        } else {                            Log.d("Retrofit", "Failed Login");                            Toast.makeText(mContext, "Username atau Password salah", Toast.LENGTH_SHORT).show();                            loading.dismiss();                        }                    }                    @Override                    public void onFailure(Call<ResponseBody> call, Throwable t) {                        Log.d("Retrofit", "Failure  :" + t.toString());                        loading.dismiss();                        Toast.makeText(mContext, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();                    }                });    }}