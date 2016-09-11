package id.sch.smktelkom_mlg.tugas1.xirpl5005.pakettavel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etEmail, etNomer;
    Button bPesan;
    TextView hasil, hasilRg, hasilCB;
    RadioGroup rgJenis;
    CheckBox Makan, Snack, Inap, Guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etNomer = (EditText) findViewById(R.id.editTextNomer);
        bPesan = (Button) findViewById(R.id.buttonPesan);
        hasil = (TextView) findViewById(R.id.tvHasil1);
        hasilRg = (TextView) findViewById(R.id.textViewRg);
        hasilCB = (TextView) findViewById(R.id.textViewCB);
        rgJenis = (RadioGroup) findViewById(R.id.radioGroupJenis);
        Makan = (CheckBox) findViewById(R.id.checkBoxMakan);
        Snack = (CheckBox) findViewById(R.id.checkBoxSnack);
        Inap = (CheckBox) findViewById(R.id.checkBoxInap);
        Guide = (CheckBox) findViewById(R.id.checkBoxGuide);


        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
                doClickCB();
                doProcces();
            }
            private void doProcces() {
                if (isValid()) {
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                int tlp = Integer.parseInt(etNomer.getText().toString());

                hasil.setText("Anda sudah memesan Travel " +
                        "\n Atas nama : " + nama
                        + " \nEmail : " + email
                        + "\nNomer Telepon : " + tlp

                );
                }
            }
            private boolean isValid() {
                boolean valid = true;

                String nama = etNama.getText().toString();
                String nomer = etNomer.getText().toString();
                String email = etEmail.getText().toString();

                if (nama.isEmpty()) {
                    etNama.setError("Nama Belum diisi");
                    valid = false;
                } else if (nama.length() < 3) {
                    etNama.setError("Nama minimal 3 karakter");
                    valid = false;
                } else {
                    etNama.setError(null);
                }
                if (nomer.isEmpty()) {
                    etNomer.setError("Nomer HP belum diisi");
                    valid = false;
                } else if (nomer.length() < 7) {
                    etNomer.setError("Nomer HP minimal 7 angka");
                    valid = false;
                } else {
                    etNomer.setError(null);
                }
                if (email.isEmpty()) {
                    etEmail.setError("Email anda belum diisi");
                } else {
                    etEmail.setError(null);
                }
                return valid;
            }

            private void doClickCB() {
                String cb = "Paket tambahan yang anda pilih : ";
                int starlen = cb.length();
                if (Makan.isChecked()) cb += Makan.getText() + "\n";
                if (Snack.isChecked()) cb += Snack.getText() + "\n";
                if (Inap.isChecked()) cb += Inap.getText() + "\n";
                if (Guide.isChecked()) cb += Guide.getText() + "\n";
                if (cb.length() == starlen) cb += "Tidak ada pilihan terpilih";
                hasilCB.setText("" + cb);
            }

            private void doClick() {
                String jenis = null;
                if (rgJenis.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton)
                            findViewById(rgJenis.getCheckedRadioButtonId());
                    jenis = rb.getText().toString();
                }
                if (jenis == null) {
                    hasilRg.setText("Anda belum memilih jenis Travel");
                } else {
                    hasilRg.setText("Jenis Travel Anda : " + jenis);
                }
            }

        });


    }


}

