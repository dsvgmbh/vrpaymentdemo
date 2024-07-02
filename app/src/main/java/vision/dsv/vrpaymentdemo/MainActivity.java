package vision.dsv.vrpaymentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import de.vrpayment.vrpayme.lib.AppNotInstalledException;
import de.vrpayment.vrpayme.lib.PaymentResult;
import de.vrpayment.vrpayme.lib.RequestBuilder;
import de.vrpayment.vrpayme.lib.ResponseHandler;
import de.vrpayment.vrpayme.lib.RequestBuilderException;

public class MainActivity extends AppCompatActivity {

    private static final String VRPAYMENT_API_KEY = "yUaKLhYFPKns48W5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v -> {
            executeTransaction(100);
        });
    }

    private void executeTransaction(int amount) {
        try {
            Log.d("executeTransaction", "payment");
            RequestBuilder.payment(VRPAYMENT_API_KEY, this)
                    .amount(amount)
                    .start();
        } catch (IllegalArgumentException e) {
            Log.d("executeTransaction", e.toString());
        } catch (AppNotInstalledException e) {
            Log.d("executeTransaction", e.toString());
        } catch (RequestBuilderException e) {
            Log.d("executeTransaction", e.toString());
        } catch (Exception e) {
            Log.d("executeTransaction", e.toString());
        }
    }


}