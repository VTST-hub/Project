package thuyduong.vn.vnpt.vnpt_soctrang;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

public class BackgroundProcessingService extends Service {
    private CountDownTimer timer;
    //@androidx.annotation.Nullable

    @Override
    public IBinder onBind(final Intent intent) {
        timer= new CountDownTimer(30 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.start();
                Log.v("Timer","Started");
            }

            @Override
            public void onFinish() {
                startActivity(intent);
                timer.cancel();
                Log.v("Timer::","Stoped");
            }
        };
        return null;
    }
}
