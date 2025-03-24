package com.example.th27;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvEmployees;
    private EmployeeAdapter adapter;
    private List<Employee> employeeList;
    private EditText etID, etFullName; // Thêm etID
    private CheckBox cbIsManager;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEmployees = findViewById(R.id.rvEmployees);
        etID = findViewById(R.id.etID); // Sửa lỗi: Khai báo etID
        etFullName = findViewById(R.id.etFullName);
        cbIsManager = findViewById(R.id.cbIsManager);
        btnAdd = findViewById(R.id.btnAdd);

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("001", "Nhân", true));
        employeeList.add(new Employee("002", "Văn", false));
        employeeList.add(new Employee("003", "An", false));
        employeeList.add(new Employee("004", "Bình", true));

        rvEmployees.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeAdapter(employeeList);
        rvEmployees.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etID.getText().toString().trim();
                String fullName = etFullName.getText().toString().trim();
                boolean isManager = cbIsManager.isChecked();

                if (!id.isEmpty() && !fullName.isEmpty()) {
                    Employee newEmployee = new Employee(id, fullName, isManager);
                    adapter.addEmployee(newEmployee);

                    etID.setText("");
                    etFullName.setText("");
                    cbIsManager.setChecked(false);
                }
            }
        });
    }
}
