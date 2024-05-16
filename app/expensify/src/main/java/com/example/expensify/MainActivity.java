package com.example.expensify;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editTextDate;
    EditText editTextExpenseName;
    EditText editTextExpenseAmount;
    Spinner spinnerExpenseCategory;
    SwitchCompat switchExpensePaid;
    Button buttonAddExpense;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ các thành phần trong layout
        editTextDate = findViewById(R.id.editTextDate);
        editTextExpenseName = findViewById(R.id.editTextExpenseName);
        editTextExpenseAmount = findViewById(R.id.editTextExpenseAmount);
        spinnerExpenseCategory = findViewById(R.id.spinnerExpenseCategory);
        switchExpensePaid = findViewById(R.id.switchExpensePaid);
        buttonAddExpense = findViewById(R.id.buttonAddExpense);
        ImageButton icon = findViewById(R.id.icon);

        // DatePickerDialog
        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "MM/dd/yy"; // your format
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            editTextDate.setText(sdf.format(myCalendar.getTime()));
        };

        icon.setOnClickListener(v -> new DatePickerDialog(MainActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());

        // Đặt sự kiện click cho nút "Thêm"
        buttonAddExpense.setOnClickListener(view -> {
            // Lấy thông tin từ các trường nhập liệu
            String date2 = editTextDate.getText().toString();
            String expenseName = editTextExpenseName.getText().toString();
            String expenseAmount = editTextExpenseAmount.getText().toString();
            String expenseCategory = spinnerExpenseCategory.getSelectedItem().toString();
            boolean expensePaid = switchExpensePaid.isChecked();

            // Xử lý dữ liệu theo nhu cầu của ứng dụng
            // (ví dụ: lưu vào cơ sở dữ liệu, thực hiện các thao tác khác)

            // Hiển thị thông báo hoặc thực hiện các hành động khác
            Toast.makeText(MainActivity.this, "Đã thêm khoản chi phí: " + expenseName, Toast.LENGTH_SHORT).show();
        });
    }
}