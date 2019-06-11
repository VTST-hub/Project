package thuyduong.vn.vnpt.vnpt_soctrang;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity              {
    EditText edituser, editpass;
    Button btnlogin, btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        class BackgroundProcesssingService extends Service{

            private CountDownTimer timer;

            //@androidx.annotation.Nullable
            @Override
            public IBinder onBind(final Intent intent) {

                timer =new CountDownTimer( 30*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.start();
                        Log.v("Timer::", "Started");
                    }

                    @Override
                    public void onFinish() {
                       // Indent indent = new Intent (MainActivity.this,HomePageActivity.class);
                        startActivity(intent);
                        timer.cancel();
                        Log.v("Timer::","Stoped");
                    }
                };
                return null;
            }
        }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
/*public interface VerifyService{
        @POST ("request")
    Call<VerifyService> request(@Body PhoneNumber PhoneNumber);
}
public static class VerifyUtil{
        private final Retrofit retrofit;
        private VerifyService verifyService;
        private static  VerifyUtil instance = null;

    public VerifyUtil(Retrofit retrofit) {
        this.retrofit = retrofit;
        HttpLoggingInterceptor interceptor= new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient Client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


    }
}*/
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Share) {
            Toast.makeText(getApplicationContext(), "You Click Share", Toast.LENGTH_SHORT).show();
        } else
            if (id == R.id.About) {
                Toast.makeText(getApplicationContext(), "You Click About", Toast.LENGTH_SHORT).show();
            } else
                if (id == R.id.Exit) {
                    Toast.makeText(getApplicationContext(), "You Click Exit", Toast.LENGTH_SHORT).show();
                } else
                    if (id == R.id.Search) {
                        Toast.makeText(getApplicationContext(), "You Click Search", Toast.LENGTH_SHORT).show();
                    } else
                        if (id == R.id.Setting) {
                            Toast.makeText(getApplicationContext(), "You Click Setting", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                }
