package aleul850.passwordstrengthmeter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Bauws on 2014-12-21.
 */
public class PasswordStrengthMeter extends EditText{

    Context _context;
    int _strength = 0;
    String _query;
    ProgressBar _progressBar;
    TextView _progress;
    StrengthAlgorithm _strengthAlgorithm;
    //Method to set the attached views progressbar and textview
    public void setViews (ProgressBar progressBar, TextView progress){
        _progressBar = progressBar;
        _progress = progress;
        _progress.setTextColor(Color.GRAY);
        _progress.setText("Too short");
        _progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

    }

    public PasswordStrengthMeter (Context context) {
        super(context);
        _context = context;
    }

    public PasswordStrengthMeter (final Context context, AttributeSet attrs) {
        super (context, attrs);
        _context = context;

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            //Textchangedlistener checks the strength of the password after every edit to it
            @Override
            public void afterTextChanged(Editable editable) {

                _query = editable.toString();
                if (!_query.isEmpty()) {
                    _progressBar.setProgress(getStrength(_query));
                }
                else {
                    _progress.setTextColor(Color.GRAY);
                    _progress.setText("Too short");
                    _progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                    _progressBar.setProgress(0);
                }
            }
        });
    }

    public PasswordStrengthMeter (Context context, AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
        _context = context;
    }

    public int getStrength (String password){

        _strength = _strengthAlgorithm.checkStrength(password);

        //switch-method that sets the textview "_progress" and progressbar's appropriate values
        //depending on the strength of the password
        switch (_strength) {

            case 0: _progress.setTextColor(Color.GRAY);
                _progress.setText("Too short");
                _progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                break;

            case 10: _progress.setTextColor(Color.RED);
                _progress.setText("Weak");
                _progressBar.setDrawingCacheBackgroundColor(Color.RED);
                _progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                break;

            case 20: _progress.setTextColor(Color.YELLOW);
                _progress.setText("Fair");
                _progressBar.setDrawingCacheBackgroundColor(Color.YELLOW);
                _progressBar.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                break;

            case 30: _progress.setTextColor(Color.BLUE);
                _progress.setText("Average");
                _progressBar.setDrawingCacheBackgroundColor(Color.BLUE);
                _progressBar.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                break;

            case 40: _progress.setTextColor(Color.CYAN);
                _progress.setText("Good");
                _progressBar.setDrawingCacheBackgroundColor(Color.CYAN);
                _progressBar.getProgressDrawable().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);
                break;

            case 50: _progress.setTextColor(Color.GREEN);
                _progress.setText("Strong");
                _progressBar.setDrawingCacheBackgroundColor(Color.GREEN);
                _progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                break;
        }

        return _strength;
    }

    public void setStrengthAlgorithm (StrengthAlgorithm algorithm){
        _strengthAlgorithm = algorithm;
    }
}
