package com.fullstack.android.preventamovil.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fullstack.android.preventamovil.R;

/**
 * Created by Jhony on 27/10/2016.
 */

public class LoginActivity extends AppCompatActivity {

    private String mNombreUsuario;
    private String mContrasenha;

    private EditText mNombreUsuarioView;
    private EditText mContrasenhaView;
    private View mLoginFormView;
    private View mLoginStatusView;
    private Button mLoginButton;

    /**
     * Tarea Asincrona para realizar el login
     */
    private UserLoginTask mAuthTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNombreUsuarioView = (EditText) findViewById(R.id.nombre_usuario);
        mContrasenhaView = (EditText) findViewById(R.id.contrasenha);
        mLoginFormView = (View) findViewById(R.id.login_form);
        mLoginStatusView = (View) findViewById(R.id.login_status);
        mLoginButton = (Button) findViewById(R.id.button_login);


        mContrasenhaView
                .setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int id,
                                                  KeyEvent keyEvent) {
                        realizarLogin();
                        return true;
                    }
                });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarLogin();
            }
        });
    }

    public void realizarLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset de los errores.
        mNombreUsuarioView.setError(null);
        mContrasenhaView.setError(null);

        // Se recueperan los datos para el login.
        mNombreUsuario = mNombreUsuarioView.getText().toString();
        mContrasenha = mContrasenhaView.getText().toString();

        // se chequea que los campos sean validos o se realiza el login
        if (TextUtils.isEmpty(mNombreUsuario)) {
            mNombreUsuarioView
                    .setError(getString(R.string.error_nombre_usuario_requerido));
            mNombreUsuarioView.requestFocus();
        } else if (TextUtils.isEmpty(mContrasenha)) {
            mContrasenhaView
                    .setError(getString(R.string.error_contrasenha_requerida));
            mContrasenhaView.requestFocus();
        } else {
            mLoginButton.requestFocus();
            showProgress(true);
            mAuthTask = new UserLoginTask();
            mAuthTask.execute((Void) null);
        }
    }

    /**
     * Muestra el cuadro de progreso para el login
     */
    private void showProgress(final boolean show) {
        if (show) {
            mLoginStatusView.requestLayout();
            mLoginStatusView.setVisibility(View.VISIBLE);
            mLoginFormView.setVisibility(View.GONE);
        } else {
            mLoginFormView.requestLayout();
            mLoginFormView.setVisibility(View.VISIBLE);
            mLoginStatusView.setVisibility(View.GONE);
        }
    }

    /**
     * Tarea asincrona encaragada de auntentica el usuario
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {

            if (mNombreUsuario != null && !mNombreUsuario.trim().isEmpty() &&
                    mContrasenha != null && !mContrasenha.trim().isEmpty()) {
                return true;
            }

            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;

            if (success) {
                finish();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                showProgress(false);
                mNombreUsuarioView
                        .setError(getString(R.string.error_login_incorrecto));
                mNombreUsuarioView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

